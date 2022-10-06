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
            if(input <= 0.00 && scannr==1){             //wenn erster input <= 0 dann Fehler und loop beenden
                System.out.println("No number entered.");
                isInput=false;
            }
            if(input <=0.00 && scannr >1){              //wenn nummer <=0 und richtige Inputanzahl über 1 dann largest ausgeben
                System.out.println("The largest number is "+format.format(biggest)); //String.format ist auch möglich
                isInput=false;                          //loop beenden
            }else if(input > biggest){
                biggest = input;           //falls richtiger input, loop geht weiter
            }
            scannr=scannr+1;            //zaehlt wie oft ein richtiger Input kam
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
        for (int i=1;i<=zeilen;i++){                //loop für die Zeilen
            for(int s=1;s<=i;s++){                  //loop für einzelnen stellen pro Zeile
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
            int half = h/2+1;
            int number=1;
            for(int row=1;row<=half;row++){             //printet eine Pyramide bis mit zur hälftenzeile
                for (int p=row;p<half;p++){             //printet die Leerzeichen -> werden pro Zeile weniger
                    System.out.print(" ");
                }
                for (int pos=1;pos<=number;pos++) {     //printet die anzahl von buchstaben die pro Zeile sein sollen, +2 jede Zeile
                        if (pos<=number/2){             //vor der Hälfte dieser Zeile zählt er hoch
                            System.out.print(Character.toChars(Integer.valueOf(c)-row+pos));
                        }else{                          //nach der Häflte zählt er runter
                            System.out.print(Character.toChars(Integer.valueOf(c)+row-pos));
                        }
                }
                number=number+2;
                System.out.println();
            }
            for(int row=half-1;row>=1;row--){       //pyramide in die andere Richtung
                for (int l=row;l<=half-1;l++){
                    System.out.print(" ");
                }
                for (int pos=1;pos<=(number-4);pos++){ //-4 weil number einmal "unnötig" um +2 hochzählt
                    if(pos<=(number-4)/2){
                        System.out.print(Character.toChars(Integer.valueOf(c)-row+pos));
                    }else{
                        System.out.print(Character.toChars(Integer.valueOf(c)+row-pos));
                    }
                }
                number=number-2;
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

        while(isInput){                             //solange input korrekt ist gehts weiter
            System.out.print("Mark "+counter+": ");
            int input=scanner.nextInt();

            if (input >=1 && input <=5){    //wenn input richtig ist wird summiert und gecountet
                sum = sum+input;
                counter = counter+1;
                if(input==5){
                    counterfuenfer=counterfuenfer+1;        //falls 5er geht der fuenfderzaehler hoch
                }
            }else if (input==0){
                if (counter==1){                            //wenn bei erstem Eingeben Input =0 , ist durchschnitt 0
                    System.out.println("Average: 0.00");    //hardcoded weil 0 dividiert durch 0 NaN ist
                    System.out.println("Negative marks: "+counterfuenfer);
                }else {
                    System.out.println("Average: " + df.format(sum / (counter - 1)));   //durchschnitt berechnen
                    System.out.println("Negative marks: " + counterfuenfer);
                }
                isInput = false;
            }else {
                System.out.println("Invalid mark!");        //bei unerlaubtem input gehts einfach weiter und der input wird nicht gezaehlt
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
            for (int i = 0; i < inputString.length(); i++) {            //jede ziffer pro Zahl wird herausgenommen und quadriert
                int stelle = Character.getNumericValue(inputString.charAt(i));
                gesamt = gesamt + stelle * stelle;
            }
            if(gesamt==1 || gesamt==4){                             //falls das ergebnis von einer Zahl 1 oder 4 ist wird der loop beendet und ausgegebn
                loop=false;
                if (gesamt==1){
                    System.out.println("Happy number!");
                }else {
                    System.out.println("Sad number!");
                }
            }
            inputString=Integer.toString(gesamt);               //Ergebnis wird zum neuen Input
            gesamt=0;                                           //gesamt wird wieder auf 0 gesetzt weil es wiederverwendet werden soll
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