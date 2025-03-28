/**
 * This is PA5 CustomTester.java file
 * Name: Yonghyeon Choi
 * ID: A17010613
 * Email: y9choi@ucsd.edu
 * Sources used: Oracle, Lecture Slides, Zybooks
 * 
 * This custom tester includes different tests that
 * test the behaviors of methods in Student.java, Course.java,
 * Sanctuary.java. These tests test behaviors that are
 * not covered by the PublicTester.
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class creates certain circumstances to test the methods.
 * It makes sure that it covers all the behaviors that are
 * not covered by the PublicTester so that all the methods 
 * perfectly do their jobs.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when a student is null or two studnets 
     * are different
     */
    @Test
    public void testEquals() {
        
        Student student1 = (Student)null;
        Student student2 = new Student("A", "B", "A1234");
        Student student3 = new Student("A", "B", "A1235");

        assertFalse("Tests null student input", student2.equals(student1));
        assertFalse("Tests two different students", student2.equals(student3));

    }

    /**
     * Test the compareTo method when students are valid and have 
     * different information
     */
    @Test
    public void testCompareTo() {

        Student student1 = new Student("A", "B", "A12345");
        Student student2 = new Student("B", "C", "A13456");
        Student student3 = new Student("A", "B", "B12345");

        assertTrue("Tests compareTo with valid input", student1.compareTo(student2) < 0);
        assertTrue("Tests compareTo with valid input", student2.compareTo(student1) > 0);
        assertTrue("Tests compareTo with valid input", student1.compareTo(student3) < 0);
        assertTrue("Tests compareTo when two students are equal", student1.compareTo(student1) == 0);

    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when the input values are null
     */
    @Test
    public void testEnroll() {

        boolean exceptionThrown1 = false;
        boolean exceptionThrown2 = false;
        boolean exceptionThrown3 = false;
        boolean exceptionThrown4 = false;

        try {
             Course course1 = new Course(null, "1", "test", 1);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown1 = true;
        }

        try {
            Course course2 = new Course("test", null, "test", 1);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown2 = true;
        }

        try {
            Course course3 = new Course("test", "1", null, 1);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown3 = true;
        }

        try {
            Course course4 = new Course("test", "1", "test", -1);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown4 = true;
        }


        assertTrue("Tests null department input", exceptionThrown1);
        assertTrue("Tests null number input", exceptionThrown2);
        assertTrue("Tests null description input", exceptionThrown3);
        assertTrue("Tests null capacity input", exceptionThrown4);

    }

    /**
     * Test the unenroll method when the student doesn't exist or the 
     * student is null
     */
    @Test
    public void testUnenroll() {
        
        Course course = new Course("ABC", "15", "CS", 50);
        Student student = new Student("Yonghyeon", "Choi", "A17010613");
        Student studentNull = (Student)null;

        course.enrolled = new HashSet<>();
        boolean exceptionThrown = false;

        try {
            course.unenroll(studentNull);
        } 
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        assertFalse("Tests unenroll non-existing student", course.unenroll(student));
        assertTrue("Tests unenroll null student", exceptionThrown);

    }

    /**
     * Test the getRoster method when three valid students are in HashSet
     * with different information
     */
    @Test
    public void testGetRoster() {

        Course course = new Course("CSE", "100", "Math", 10);
        Student student1 = new Student("A", "B", "1");
        Student student2 = new Student("B", "C", "1");
        Student student3 = new Student("C", "D", "2");
        course.enrolled = new HashSet<>();
        course.enroll(student2);
        course.enroll(student1);
        course.enroll(student3);

        ArrayList<Student> testArray = new ArrayList<Student>();
        testArray = course.getRoster();

        assertEquals(student1, testArray.get(0));
        assertEquals(student2, testArray.get(1));
        assertEquals(student3, testArray.get(2));

    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when maxAnimal and maxSpecies input are invalid
     */
    @Test
    public void testSanctuaryConstructor() {

        boolean exceptionThrown1 = false;
        boolean exceptionThrown2 = false;

        try {
            Sanctuary sanc1 = new Sanctuary(-1, 100);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown1 = true;
        }

        try {
            Sanctuary sanc2 = new Sanctuary(100, -1);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown2 = true;
        }

        assertTrue("Tests illegal maxAnimals input", exceptionThrown1);
        assertTrue("Tests illegal maxSpecies input", exceptionThrown2);

    }

    /**
     * Test the rescue method when additional number of animals exceed 
     * the maxAnimal
     */
    @Test
    public void testRescueTestOne(){

        Sanctuary sanct = new Sanctuary(20, 100);

        assertEquals(10, sanct.rescue("Tiger", 30));
        assertTrue(sanct.sanctuary.containsKey("Tiger"));
        assertEquals(20, (int)sanct.sanctuary.get("Tiger"));

        assertEquals(1, (int)sanct.sanctuary.size());

    }

    /**
     * Test the rescue method when num and species value are invalid
     */
    @Test
    public void testRescueTestTwo(){
        
        Sanctuary sanct = new Sanctuary(20, 100);
        boolean exceptionThrown1 = false;
        boolean exceptionThrown2 = false;

        try {
            sanct.rescue("Rabbit", 0);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown1 = true;
        }

        try {
            sanct.rescue(null, 1);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown2 = true;
        }

        assertTrue("Tests invalid num value", exceptionThrown1);
        assertTrue("Tests invalid species value", exceptionThrown2);

    }

    /**
     * Test the release method when all the animals for the species are removed
     */
    @Test
    public void testReleaseTestOne(){

        Sanctuary sanct = new Sanctuary(100, 5);
        sanct.sanctuary.put("Bear", 10);

        sanct.release("Bear", 10);
        assertFalse("Checks if the species has been removed", sanct.sanctuary.containsKey("Bear"));
        assertEquals(0, sanct.sanctuary.size());

    }

    /**
     * Test the release method when num and species value are invalid
     */
    @Test
    public void testReleaseTestTwo(){

        Sanctuary sanct = new Sanctuary(20, 100);
        sanct.sanctuary.put("Rabbit", 5);

        boolean exceptionThrown1 = false;
        boolean exceptionThrown2 = false;
        boolean exceptionThrown3 = false;
        boolean exceptionThrown4 = false;

        try {
            sanct.release("Rabbit", 0);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown1 = true;
        }

        try {
            sanct.release("Rabbit", 999);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown2 = true;
        }

        try {
            sanct.release(null, 1);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown3 = true;
        }

        try {
            sanct.release("Tiger", 1);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown4 = true;
        }

        assertTrue("Tests num out of bound", exceptionThrown1);
        assertTrue("Tests num exceeding number of species", exceptionThrown2);
        assertTrue("Tests null species input", exceptionThrown3);
        assertTrue("Tests invalid species input", exceptionThrown4);


    }
}

