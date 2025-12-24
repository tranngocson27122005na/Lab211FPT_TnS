package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Student;
import common.Constants;
import common.Messenger;


public class StudentController {
    ArrayList<Student> listStd = new ArrayList<>();
    
    public Student getStudentById(String studentId){
        for (Student student : listStd) {
            if(student.getId().equals(studentId)){
                return student;
            }
        }
        return null;
    }
    
    public void createStudent(){
        while(true){
            String id, name, semester, course;
            
            // Input Student ID with duplicate check
            do{
                id = Inputter.inputRequired("Enter Student ID: ");
                if(getStudentById(id) != null){
                    System.out.println(Messenger.ERR_DUP_STUDENT_ID);
                }
            }while(getStudentById(id) != null);
            
            // Input other fields with validation
            name = Inputter.inputRequired("Enter name: ");
            semester = Inputter.inputRequired("Enter semester: ");
            course = Inputter.inputRequired("Enter course: ");
            
            listStd.add(new Student(id, name, semester, course));
            System.out.println(Messenger.MSG_STUDENT_ADDED_SUCCESS);
            
            // Check if reached maximum students or ask to continue
            if(listStd.size() >= Constants.MAX_STUDENTS){
                System.out.println("Maximum number of students (" + Constants.MAX_STUDENTS + ") reached!");
                break;
            }
            
            String choice = Inputter.inputRequired(Messenger.MSG_CONTINUE_ADDING, Constants.YES_NO_VALIDATE);
            if(choice.equalsIgnoreCase("N")){
                break;
            }
        }
    }
    
    public void findAndSort(){
        if(listStd.isEmpty()){
            System.out.println(Messenger.ERR_NO_STUDENTS_ADDED);
            return;
        }
        
        String name = Inputter.inputRequired("Enter Student Name: ");
        
        ArrayList<Student> res = new ArrayList<>();
        
        for (Student student : listStd) {
            if(student.getName().toLowerCase().contains(name.toLowerCase())){
                res.add(student);
            }
        }
        
        if(res.isEmpty()){
            System.out.println(Messenger.ERR_NO_STUDENTS_FOUND);
            return;
        }
        
        Collections.sort(res, Comparator.comparing(Student::getName));
        
        System.out.println(Messenger.MSG_SEARCH_RESULTS);
        displayTableHeader();
        for (Student r : res) {
            System.out.println(r.toString());
        }
    }
    
    private void displayTableHeader(){
        System.out.println("ID        | Name                 | Semester   | Course         ");
        System.out.println(Constants.TABLE_SEPARATOR);
    }
    
    public void displayAllStudents(){
        if(listStd.isEmpty()){
            System.out.println(Messenger.ERR_NO_STUDENTS_ADDED);
            return;
        }
        
        System.out.println("All Students:");
        displayTableHeader();
        for (Student student : listStd) {
            System.out.println(student.toString());
        }
    }
}