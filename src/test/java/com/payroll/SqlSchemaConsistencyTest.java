package com.payroll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Every column used by the app's SQL (any string literal in src/main/java that
 * talks to the employees table) must exist in db/setup_payroll_db.sql.
 * Runs without MySQL, straight from the source code.
 */
class SqlSchemaConsistencyTest {

    private static final Set<String> SCHEMA = new TreeSet<>();
    private static final Set<String> KEYWORDS = Set.of("select", "from", "where", "and", "or", "insert", "into",
            "values", "update", "set", "delete", "like", "upper", "order", "by", "employees", "as", "max",
            "asc", "desc", "limit", "null", "is", "not", "in", "count");

    @BeforeAll
    static void readSchema() throws IOException {
        String sql = Files.readString(Paths.get("db/setup_payroll_db.sql"));
        String table = sql.substring(sql.indexOf("CREATE TABLE IF NOT EXISTS employees"));
        table = table.substring(table.indexOf('(') + 1, table.indexOf(");"));
        Matcher m = Pattern.compile("(?m)^\\s+(\\w+)\\s+(INT|VARCHAR|DOUBLE|DATE|TINYINT)").matcher(table);
        while (m.find()) SCHEMA.add(m.group(1).toLowerCase(Locale.ROOT));
        assertTrue(SCHEMA.size() > 30, "schema parse failed: " + SCHEMA);
    }

    /** All SQL statements in the source: string literals joined with + across lines. */
    static List<String[]> sqlStatements() throws IOException {
        List<String[]> out = new ArrayList<>();
        Pattern stmt = Pattern.compile("\"((?:SELECT|INSERT|UPDATE|DELETE)\\b[^;]*?)\"\\s*;", Pattern.DOTALL);
        try (Stream<Path> files = Files.list(Paths.get("src/main/java/com/payroll"))) {
            for (Path f : (Iterable<Path>) files.filter(p -> p.toString().endsWith(".java"))::iterator) {
                String src = Files.readString(f);
                // inline simple String constants/variables used inside SQL ("SELECT " + cols + " FROM ...")
                Matcher v = Pattern.compile("String\\s+(\\w+)\\s*=\\s*\"([^\"]*)\"\\s*;").matcher(src);
                while (v.find()) {
                    src = src.replaceAll("\"\\s*\\+\\s*" + v.group(1) + "\\s*\\+\\s*\"",
                            Matcher.quoteReplacement(v.group(2)));
                }
                Matcher m = stmt.matcher(src);
                while (m.find()) {
                    // join "a " +\n "b" concatenations, drop Java code between literals
                    String sql = m.group(1).replaceAll("\"\\s*\\+\\s*\"", "");
                    if (sql.toLowerCase(Locale.ROOT).contains("employees")) {
                        out.add(new String[] { f.getFileName().toString(), sql });
                    }
                }
            }
        }
        return out;
    }

    static List<String> columnsOf(String sql) {
        List<String> cols = new ArrayList<>();
        Matcher m = Pattern.compile("\\b([A-Za-z_][A-Za-z0-9_]*)\\b").matcher(sql);
        while (m.find()) {
            String w = m.group(1).toLowerCase(Locale.ROOT);
            if (!KEYWORDS.contains(w) && !w.equals("last_id")) cols.add(w);
        }
        return cols;
    }

    @Test
    @DisplayName("অ্যাপের প্রতিটি SQL column db/setup_payroll_db.sql-এ আছে")
    void everyColumnUsedByTheAppExists() throws IOException {
        List<String[]> stmts = sqlStatements();
        assertTrue(stmts.size() >= 7, "expected at least 7 SQL statements, found " + stmts.size());
        List<String> problems = new ArrayList<>();
        for (String[] s : stmts) {
            for (String c : columnsOf(s[1])) {
                if (!SCHEMA.contains(c)) problems.add(s[0] + ": " + c);
            }
        }
        assertTrue(problems.isEmpty(), "columns not in the schema: " + problems);
    }
}
