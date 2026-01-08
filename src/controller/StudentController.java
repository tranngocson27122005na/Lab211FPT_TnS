package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import model.Student;

public class StudentController {
    
    ArrayList<Student> listStd = new ArrayList<>();

    // Lấy student theo ID
    public Student getStudentById(String studentId){
        for (Student student : listStd) {
            if(student.getId().equals(studentId)){
                return student;
            }
        }
        return null;
    }
    
    // CREATE student với validation
    public void createStudent(){
        while(true){
            String id, name, semester, course;

            // Validate ID
            do{
                id = Inputter.input("Enter Student ID: ").trim();
                if(id.isEmpty()) System.out.println("ID cannot be empty!");
                else if(getStudentById(id) != null) System.out.println("ID already exists!");
            }while(id.isEmpty() || getStudentById(id) != null);

            // Validate Name
            do{
                name = Inputter.input("Enter name: ").trim();
                if(name.isEmpty()) System.out.println("Name cannot be empty!");
            }while(name.isEmpty());

            // Validate Semester
            do{
                semester = Inputter.input("Enter semester: ").trim();
                if(semester.isEmpty()) System.out.println("Semester cannot be empty!");
            }while(semester.isEmpty());

            // Validate Course
            do{
                course = Inputter.input("Enter course (Java/.Net/C/C++): ").trim();
                if(!course.equalsIgnoreCase("Java") &&
                   !course.equalsIgnoreCase(".Net") &&
                   !course.equalsIgnoreCase("C/C++")){
                    System.out.println("Invalid course! Only Java/.Net/C/C++ allowed.");
                }
            }while(!course.equalsIgnoreCase("Java") &&
                   !course.equalsIgnoreCase(".Net") &&
                   !course.equalsIgnoreCase("C/C++"));

            // Thêm student vào list
            listStd.add(new Student(id, name, semester, course));

            // Nếu >=10 student, hỏi tiếp
            if(listStd.size() >= 10){
                String choice = Inputter.inputRequired("Do you want to continue (Y/N)? ", Inputter.YES_NO_VALIDATE);
                if(choice.equalsIgnoreCase("N")) break;
            }
        }
    }
    
    // FIND & SORT
    public void findAndSort(){
        String keyword = Inputter.input("Enter Student Name: ").trim();
        ArrayList<Student> res = new ArrayList<>();
        for (Student s : listStd) {
            if(s.getName().toLowerCase().contains(keyword.toLowerCase())){
                res.add(s);
            }
        }
        // Sort theo Name
        Collections.sort(res, Comparator.comparing(Student::getName));
        
        // Display
        if(res.isEmpty()){
            System.out.println("No student found!");
        }else{
            System.out.println("\nID | Name | Course | Semester");
            for(Student s : res){
                System.out.println(s.getId() + " | " + s.getName() + " | " + s.getCourse() + " | " + s.getSemester());
            }
        }
    }
    
    // UPDATE or DELETE
    public void updateOrDelete(){
        String id = Inputter.input("Enter Student ID to update/delete: ").trim();
        Student s = getStudentById(id);
        if(s == null){
            System.out.println("Student not found!");
            return;
        }

        String action = Inputter.inputRequired("Update(U) or Delete(D)? ", "^(U|D)$");
        if(action.equalsIgnoreCase("U")){
            // Update
            String name, semester, course;

            // Name
            do{
                name = Inputter.input("Enter new name: ").trim();
                if(name.isEmpty()) System.out.println("Name cannot be empty!");
            }while(name.isEmpty());

            // Semester
            do{
                semester = Inputter.input("Enter new semester: ").trim();
                if(semester.isEmpty()) System.out.println("Semester cannot be empty!");
            }while(semester.isEmpty());

            // Course
            do{
                course = Inputter.input("Enter new course (Java/.Net/C/C++): ").trim();
                if(!course.equalsIgnoreCase("Java") &&
                   !course.equalsIgnoreCase(".Net") &&
                   !course.equalsIgnoreCase("C/C++")){
                    System.out.println("Invalid course! Only Java/.Net/C/C++ allowed.");
                }
            }while(!course.equalsIgnoreCase("Java") &&
                   !course.equalsIgnoreCase(".Net") &&
                   !course.equalsIgnoreCase("C/C++"));

            // Set new info
            s.setName(name);
            s.setSemester(semester);
            s.setCourse(course);

            System.out.println("Update successful!");
        } else {
            // Delete
            listStd.remove(s);
            System.out.println("Delete successful!");
        }
    }
    
    // REPORT
    public void report(){
        if(listStd.isEmpty()){
            System.out.println("No students to report!");
            return;
        }

        // Map<StudentName, Map<Course, Count>>
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for(Student s : listStd){
            map.putIfAbsent(s.getName(), new HashMap<>());
            Map<String,Integer> courses = map.get(s.getName());
            courses.put(s.getCourse(), courses.getOrDefault(s.getCourse(),0)+1);
        }

        System.out.println("\nStudent Name | Course | Total");
        for(String name : map.keySet()){
            Map<String,Integer> courses = map.get(name);
            for(String course : courses.keySet()){
                System.out.println(name + " | " + course + " | " + courses.get(course));
            }
        }
    }
}
