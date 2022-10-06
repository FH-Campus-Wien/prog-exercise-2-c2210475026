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
        final int zeilen =6;
        int sterne=1;
        for(int i=1;i<=zeilen;i++){         //zeilen werden generiert bis 6 zeilen
            for(int p=i;p<zeilen;p++) {     //pro Zeile die Leerzeichen, durch p=i werden Leerzeichen immer weniger
                System.out.print(" ");
            }
            for(int s=1;s<=sterne;s++){     //Sterne werden ausgegeben
                System.out.print("*");
            }
            sterne=sterne+2;                //hier wird die sternanzahl erhöht (+2 pro Zeile)
            System.out.println();
        }

    }

    //todo Task 4
    public void printRhombus(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("h: ");
        int h = scanner.nextInt();
        System.out.print("c: ");
        char c = scanner.next().charAt(0);

        if(h%2 ==0){
            System.out.println("Invalid number!");
        }else {

            int haelfte = h/2+1;
            int anzahl=1;
            for(int zeile=1;zeile<=haelfte;zeile++){
                for (int p=zeile;p<haelfte;p++){
                    System.out.print(" ");
                }
                for (int stelle=1;stelle<=anzahl;stelle++) {
                        if (stelle<=anzahl/2){
                            System.out.print(Character.toChars(Integer.valueOf(c)-zeile+stelle));
                        }else{
                            System.out.print(Character.toChars(Integer.valueOf(c)+zeile-stelle));
                        }
                }
                anzahl=anzahl+2;
                System.out.println();
            }
            for(int j=haelfte-1;j>=1;j--){
                for (int l=j;l<=haelfte-1;l++){
                    System.out.print(" ");
                }
                for (int k=1;k<=(anzahl-4);k++){ //-4 weil anzahl einmal "unnötig" um +2 hochzählt
                    if(k<=(anzahl-4)/2){
                        System.out.print(Character.toChars(Integer.valueOf(c)-j+k));
                    }else{
                        System.out.print(Character.toChars(Integer.valueOf(c)+j-k));
                    }
                }
                anzahl=anzahl-2;
                System.out.println();
            }

        }
    }

    //todo Task 5
    public void marks(){
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        double sum=0;
        boolean isInput=true;
        int counter=1;
        int counterfuenfer=0;
        while(isInput){
            System.out.print("Mark "+counter+": ");
            int input=scanner.nextInt();
            if (input >=1 && input <=5){
                sum = sum+input;
                counter = counter+1;
                if(input==5){
                    counterfuenfer=counterfuenfer+1;
                }
            }else if (input==0){
                if (counter==1){
                    System.out.println("Average: 0.00");
                    System.out.println("Negative marks: "+counterfuenfer);
                }else {
                    System.out.println("Average: " + df.format(sum / (counter - 1)));
                    System.out.println("Negative marks: " + counterfuenfer);
                }
                isInput = false;
            }else {
                System.out.println("Invalid mark!");
            }
        }
    }

    //todo Task 6
    public void happyNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        String inputString = scanner.next();
        int gesamt=0;
        boolean loop = true;

        while (loop) {
            for (int i = 0; i < inputString.length(); i++) {
                int stelle = Character.getNumericValue(inputString.charAt(i));
                gesamt = gesamt + stelle * stelle;
            }
            if(gesamt==1 || gesamt==4){
                loop=false;
                if (gesamt==1){
                    System.out.println("Happy number!");
                }else {
                    System.out.println("Sad number!");
                }
            }
            inputString=Integer.toString(gesamt);
            gesamt=0;
        }




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