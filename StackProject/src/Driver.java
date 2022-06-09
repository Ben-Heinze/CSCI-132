import java.util.Scanner;

public class Driver {

    public static void main(String args[]){
        Stack stack = new Stack();
        String numbers="";

        do {
            System.out.println("-------------------------------");
            System.out.print("Give a string: ");
            Scanner con = new Scanner(System.in);
            numbers = con.nextLine();
            if(numbers.equals("-1"))
                System.exit(0);//quits application
            stack.runMethod(numbers);
        }while(numbers!="-1");


    }//main
}
