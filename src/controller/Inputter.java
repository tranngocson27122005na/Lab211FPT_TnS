
package controller;


import java.util.Scanner;
import common.Messenger;

public class Inputter { 
    
    static Scanner sc = new Scanner(System.in);

    // Bắt buộc nhập - Nhập ko đúng thì bắt nhập lại
    public static String input(String label){
        System.out.print(label);
        String input = sc.nextLine();
        return input;
    }
    
    public static String inputRequired(String label){
        String input;
        do{
            System.out.print(label);
            input = sc.nextLine();
            if(input.trim().isEmpty()){
                System.out.println("Input cannot be empty!");
            }
        } while(input.trim().isEmpty());
        return input.trim();
    }

    public static String inputRequired(String label, String regex){
        String input;
        do{
            System.out.print(label);
            input = sc.nextLine();
            if(input.trim().isEmpty()){
                System.out.println("Input cannot be empty!");
                continue;
            }
            if(!input.matches(regex)){
                System.out.println(Messenger.ERR_INVALID_INPUT);
            }
        } while(input.trim().isEmpty() || !input.matches(regex));
        return input.trim();
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

