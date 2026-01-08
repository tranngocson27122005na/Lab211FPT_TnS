package controller;

import java.util.Scanner;

public class Inputter { 
    
    public static final String YES_NO_VALIDATE = "^(Y|N)$";
    static Scanner sc = new Scanner(System.in);

    // Bắt buộc nhập - Nhập ko đúng thì bắt nhập lại
    public static String input(String label){
        System.out.print(label);
        String input = sc.nextLine();
        return input;
    }
    
    public static String inputRequired(String label, String regex){
        String input;
        do{
            System.out.print(label);
            input = sc.nextLine();
        } while( !input.matches(regex));
        return input;
    }

    // Nhập đúng thì trả về giá trị vừa nhập , còn bỏ trống thì trả về chuỗi rỗng
    // Có nhập , nhma nhập sai => Thì bắt nhập lại
    public static String inputOptional(String label, String regex){
        String input;
        while(true){
            System.out.print(label);
            input = sc.nextLine();
            if(input == null || input.isEmpty()) return "";
            if(input.matches(regex)) return input;
        }
    }
}
