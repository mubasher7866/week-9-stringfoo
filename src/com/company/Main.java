package com.company;
import java.util.Scanner;
import java.io.File;

public class Main {

    private static String customerName="Mubasher Zeb Khan";

    public static void main(String args[]){
        createFile(customerName);
    }

    public static void createFile(String name){

        try {
            char [] initials = new char[name.length()];
            int lengthOfName = name.length();
            char charArrayOfName[] = name.toCharArray();
            char firstAlphabet = charArrayOfName[0];
            int positionOfFirstInitial=0;
            int positionOfSecondInitial=0;

            for (int i = 0 ; i < name.length();i++){
                if(Character.isUpperCase(name.charAt(i))){
                    initials[i] = name.charAt(i);
                }
            }



            int temp = (int) firstAlphabet;
            int temp_Integer = 64;
            char secondinitial = '0';
            for (int i = 1;i<name.length();i++){
                if (Character.isUpperCase(name.charAt(i))){
                    secondinitial = name.charAt(i);
                }
            }
            int temp2 = (int) secondinitial;
            if(temp <= 90 && temp >= 65 && temp2 <= 90 && temp2 >= 65){
                positionOfFirstInitial = temp - temp_Integer;
                positionOfSecondInitial = temp2-temp_Integer;
            }

            //tried to insert name initials at start using String.valueOf(initials) but getting an error
            String SavingFileName=lengthOfName+"-"+positionOfFirstInitial+"-"+positionOfSecondInitial+"-savingAccount.txt";
            String CurrentFileName=lengthOfName+"-"+positionOfFirstInitial+"-"+positionOfSecondInitial+"-currentAccount.txt";
            System.out.println(String.valueOf(initials));



            File savingFile = new File(SavingFileName);
            File currentfile = new File(CurrentFileName);

            if(savingFile.createNewFile() && currentfile.createNewFile()){
                System.out.println("Saving File created :"+ savingFile.getName());
                System.out.println("Current File created :"+ currentfile.getName());
            }
            else {
                System.out.println("File Already exists");
            }

        }catch (Exception e){
            System.out.println("An error occured");
            e.printStackTrace();
        }

    }


}