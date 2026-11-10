package com.payroll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** The runnable JAR (maven-shade) must point at a class that exists and has main(String[]). */
class BuildConfigTest {

    @Test
    @DisplayName("Shade plugin-এর mainClass সত্যিই আছে এবং main() আছে")
    void shadeMainClassExists() throws Exception {
        String pom = Files.readString(Paths.get("pom.xml"));
        Matcher m = Pattern.compile("<mainClass>([^<]+)</mainClass>").matcher(pom);
        assertTrue(m.find(), "no <mainClass> in pom.xml");
        String mainClass = m.group(1).trim();
        Class<?> cls = assertDoesNotThrow(() -> Class.forName(mainClass, false, getClass().getClassLoader()),
                "pom.xml mainClass does not exist: " + mainClass);
        assertNotNull(cls.getMethod("main", String[].class));
    }
}
