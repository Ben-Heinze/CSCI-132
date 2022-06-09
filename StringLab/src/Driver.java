import java.util.Scanner;

public class Driver {


    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);

        manipulatingStrings f = new manipulatingStrings();

        System.out.println("Give me your string:");
        String sentence = con.nextLine();
        int menuChoice;

        //sentence = changeSentence();

        do{
            System.out.println();
            System.out.println("Press 1 to count the occurrence of a particular letter.");
            System.out.println("Press 2 to count the total words in your user sentence.");
            System.out.println("Press 3 to change your input sentence.");
            System.out.println("Press 4 to exit.");
            System.out.println("What do you want to do?");
            menuChoice = con.nextInt();

            sentence = f.menu(sentence, menuChoice);

        }while(menuChoice!= 4);

        // write your code here
    }
}
