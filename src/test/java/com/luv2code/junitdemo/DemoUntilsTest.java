package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUntilsTest {
    DemoUtils demoUtils;
    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }
    @DisplayName("Multiply")
    @Test
    void testMultiply() {
        assertEquals(12, demoUtils.multiply(4, 3), "4*3 must be 12");
    }
    @DisplayName("Equals and Not Equals")
    @Test
    @Order(1)
    void testEqualsAndNotEquals() {
        System.out.println("Running test: testEqualsAndNotEquals");
        DemoUtils demoUtils = new DemoUtils();
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1,9), "1+9 must not be 6");
    }
    @DisplayName("Null and Not Null")
    @Test
    @Order(0)
    void testNullAndNotNull() {
        System.out.println("Running test: testNullAndNotNull");
        DemoUtils demoUtils = new DemoUtils();
        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }
    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {
        String str = "luv2code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Object should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Object should not refer to same object");
    }
    @DisplayName("True and False")
    @Test
    @Order(30)
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;
        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }
    @DisplayName("Array Equals")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Array should be the same");
    }
    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }
    @DisplayName("Lines match")
    @Test
    @Order(50)
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }
    @DisplayName("Throws and Does Not Throw")
    @Test
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, ()->{demoUtils.throwException(-1);}, "Should throw exception");
        assertDoesNotThrow(()->{demoUtils.throwException(5);}, "Should not throw exception");
    }
    @DisplayName("Timeout")
    @Test
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), ()->{demoUtils.checkTimeout();},
                "Method should execute in 3 seconds");
    }


















    /*
    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @AfterEach");
        System.out.println();
    }
    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }
    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }*/
}
