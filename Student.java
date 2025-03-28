/**
 * This is PA5 Student.java file
 * Name: Yonghyeon Choi
 * PID: A17010613
 * Email: y9choi@ucsd.edu
 * Sources used: Oracle, Lecture Slides, Zybooks
 * 
 * This file contains class called Student with particular
 * characteristics. It includes multiple methods that get
 * characteristics of the Students. It also includes methods
 * that compare two students.
 */
import java.util.Objects;

/**
 * This class contains private instance variables that become
 * characterisitcs of a Student. It includes methods that 
 * construct a Student, return characteristics, or compare
 * two Students.
 */
public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    /**
     * It initializes the student's information and checks
     * if any of them are null
     * @param firstName - first name of the student
     * @param lastName - last name of the student
     * @param PID - unique PID of the student
     */
    public Student(String firstName, String lastName, String PID) {

        if (firstName == null || lastName == null || PID == null) {
            throw new IllegalArgumentException();
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;

    }

    /**
     * It returns student's last name
     * @return student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * It returns student's first name
     * @return student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * It returns student's unique PID
     * @return student's PID
     */
    public String getPID() {
        return PID;
    }

    /**
     * It compares three characteristics of two
     * different students 
     * @param o - a student that is being compared
     * @return true if they are equal, otherwise false
     */
    @Override
    public boolean equals(Object o) {

        //Changes the type of o to Student
        Student s = (Student)o;

        if (s == null) {
            return false;
        }

        if (this.compareTo(s) == 0) {
            return true;
        } 
        else {
            return false;
        }

    }

    /**
     * It returns unique hash value for the student
     * with Object's hash function
     * @return hash value in order of firstName, lastName, PID
     */
    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, PID);
        
    }

    /**
     * Compares two students' lastName, firstName, and PID
     * lexicographically
     * @param o - a student that is being compared
     * @return negative number if current student is before, 
     * positive number if student is after, and zero if 
     * they are equivalent
     */
    @Override
    public int compareTo(Student o) {

        Student s = (Student)o;

        // Compares two students lexicographically
        // in order of lastname, firstname, and PID
        if (this.lastName.compareTo(s.lastName) < 0) {
            return -1;
        }
        else if (this.lastName.compareTo(s.lastName) > 0) {
            return 1;
        }
        else if (this.firstName.compareTo(s.firstName) < 0) {
            return -1;
        }
        else if (this.firstName.compareTo(s.firstName) > 0) {
            return 1;
        }
        else if (this.PID.compareTo(s.PID) < 0) {
            return -1;
        }
        else if (this.PID.compareTo(s.PID) < 0) {
            return 1;
        }
        else {
            return 0;
        }
        
    }
}

