package at.ac.fhcampuswien;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber(){
        boolean isInput = true;
        Scanner scan = new Scanner(System.in);
        double biggest = 0.00;
        int scannr = 1;
        DecimalFormat format = new DecimalFormat("0.00");
        while(isInput){
            System.out.print("Number "+scannr+": ");
            double input = scan.nextDouble();
            if(input <= 0.00 && scannr==1){
                System.out.println("No number entered.");
                isInput=false;
            }
            if(input <=0.00 && scannr >1){
                System.out.println("The largest number is "+format.format(biggest)); //String.format ist auch möglich
                isInput=false;
            }else if(input > biggest){
                biggest = input;
            }
            scannr=scannr+1;
        }
    }

    //todo Task 2
    public void stairs(){
        Scanner scan = new Scanner(System.in);
        System.out.print("n: ");
        int zeilen = scan.nextInt();
        int counter = 1;
        if(zeilen <=0){
            System.out.println("Invalid number!");
        }
        for (int i=1;i<=zeilen;i++){
            for(int s=1;s<=i;s++){
                System.out.print(counter+" ");
                counter=counter+1;
            }
            System.out.println();
        }

    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here
    }

    //todo Task 4
    public void printRhombus(){
        // input your solution here
    }

    //todo Task 5
    public void marks(){
        // input your solution here
    }

    //todo Task 6
    public void happyNumbers(){
        // input your solution here
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}