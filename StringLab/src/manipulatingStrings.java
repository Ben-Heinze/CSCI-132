import java.util.Scanner;

public class manipulatingStrings {

    public static String menu(String sentence,int menuChoice) {

        switch (menuChoice) {
            case 1:
                countLetter(sentence);
                break;
            case 2:
                countWords(sentence);
                break;
            case 3:
                //String newInput = changeSentence();
                sentence = changeSentence();
                break;
            case 4:
                System.out.println("Goodbye.");
                break;
        }//switch
        return sentence;
    }//menu DONE

    private static void countLetter(String sentence) {
        int count = 0;
        Scanner ltr = new Scanner(System.in);
        System.out.println("What letter do you want to count?");
        String choice = ltr.nextLine();

        for(int i=0; i< sentence.length(); i++) {
            String s = String.valueOf(sentence.charAt(i)); //assigns char to a string
            if(choice.equalsIgnoreCase(s)) //if the char in sentence is the same as the choice, count it
                count++;
        }//for

        System.out.println("****The letter '"+ choice + "' was found "+ count + " times.");
    }//countLetter DONE

    public static void countWords(String sentence){
        int count = 0;
        sentence = sentence.trim();
        String[] splitSent = sentence.split(" ");
        for(String i: splitSent)
            count++;
        System.out.println("****There are " + count + " words in the input.");
    }//countWords DONE

    public static String changeSentence(){
        Scanner newSent = new Scanner(System.in);
        System.out.println("What is your new input sentence?");
        String newSentence = newSent.nextLine();

        //make sure it actually gets sent to menu
        System.out.println("****Your input sentence has been changed to: " + newSentence);

        return newSentence;
    }//changeSentence DONE
}
