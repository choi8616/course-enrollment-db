/**
 * This is PA5 Course.java file
 * Name: Yonghyeon Choi
 * PID: A17010613
 * Email: y9choi@ucsd.edu
 * Sources used: Oracle, Lecture Slides, Zybooks
 * 
 * This file contains a HashCode that stores all
 * the students in the Course. Course also has 
 * it's own unique characteristics. It also includes
 * various methods that are related to the Course.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * This class provides unique characteristics to a Course.
 * It also sets up a HashSet so it can store students in
 * random. It also deals with Course's charactersitics 
 * through various methods. 
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    /**
     * Initializes the course's information 
     * @param department - department course is in
     * @param number - course number
     * @param description - description of course
     * @param capacity - maximum number of students that can be enrolled
     */
    public Course(String department, String number, String description, 
        int capacity){

            if (department == null || number == null 
                || description == null || capacity <= 0) {
                throw new IllegalArgumentException();
            }

            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;

        }

    /**
     * Returns the department of the course
     * @return course's department
     */
    public String getDepartment(){
        return department;
    }

    /**
     * Returns the course number
     * @return course number
     */
    public String getNumber(){
        return number;
    }

    /**
     * Returns the description of the course
     * @return course's description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Returns the maximum number of students that
     * can be enrolled in the course
     * @return capacity of course
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Adds the student to the course after checking
     * if the student is not currently enrolled and 
     * there is a room
     * @param student - student being added
     * @return true if student is added successfully 
     * and false otherwise
     */
    public boolean enroll(Student student) {
        
        if (student == null) {
            throw new IllegalArgumentException();
        }

        // checks if student is not currently enrolled and that
        // there is a room before actually adding
        if (enrolled.size() < capacity && enrolled.add(student)) {
            enrolled.add(student);
            return true;
        }

        return false;

    }

    /**
     * Remove the student that is enrolled in the course
     * @param student - student being removed
     * @return true if unenrollment is successful and false
     * otherwise
     */
    public boolean unenroll(Student student) {

        if (student == null) {
            throw new IllegalArgumentException();
        }

        // checks if the student exists in the course
        if (enrolled.contains(student) == true) {
            enrolled.remove(student);
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Remove all the students from the course
     */
    public void cancel() {

        enrolled.clear();

    }

    /**
     * Checks if the course is at its capacity
     * @return true if the course is full and 
     * false otherwise
     */
    public boolean isFull() {
        
        if (enrolled.size() == capacity) {
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Return the number of students enrolled in the
     * course
     * @return current number of enrolled students
     */
    public int getEnrolledCount() {

        return enrolled.size();

    }

    /**
     * Return the number of students that can still
     * be enrolled
     * @return number of students that can be enrolled
     */
    public int getAvailableSeats() {

        return capacity - enrolled.size();

    }

    /**
     * Returns a shallow copy of the students in 
     * the course
     * @return copy of the students in the course
     */
    public HashSet<Student> getStudents() {

        return (HashSet)enrolled.clone();

    }

    /**
     * Turn the collection of students in the course
     * into an ArrayList collection in increasing order
     * @return ArrayList version of the roster
     */
    public ArrayList<Student> getRoster() {

        ArrayList<Student> enrolledArray = new ArrayList<Student>();
        
        //iterates through the HashSet to move all the students
        for (Student s : enrolled) {
            enrolledArray.add(s);
        }
        Collections.sort(enrolledArray);

        return enrolledArray;

    }

    /**
     * Return a string version of Course object and its 
     * information
     * @return string representation of the course
     */
    public String toString() {
        
        return department + " " + number + " [" 
            + capacity + "]\n" + description;
        
    }
}

