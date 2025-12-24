package common;

public final class Messenger {
    
    private Messenger() {
    }

    // Error messages
    public static final String ERR_DUP_STUDENT_ID = "Student ID already exists!";
    public static final String ERR_EMPTY_STUDENT_ID = "Student ID cannot be empty!";
    public static final String ERR_EMPTY_STUDENT_NAME = "Student name cannot be empty!";
    public static final String ERR_EMPTY_SEMESTER = "Semester cannot be empty!";
    public static final String ERR_EMPTY_COURSE = "Course cannot be empty!";
    public static final String ERR_INVALID_INPUT = "Invalid input! Please try again.";
    public static final String ERR_NO_STUDENTS_FOUND = "No students found!";
    public static final String ERR_NO_STUDENTS_ADDED = "No students have been added yet!";

    // Success messages
    public static final String MSG_STUDENT_ADDED_SUCCESS = "Student added successfully!";
    public static final String MSG_CONTINUE_ADDING = "Do you want to continue adding students (Y/N)?";
    public static final String MSG_SEARCH_RESULTS = "Search results:";
    public static final String MSG_PROGRAM_EXIT = "Thank you for using the program!";
}