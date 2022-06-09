import java.util.Scanner;

public class SwitchDoWhile {


    int balance;
    SwitchDoWhile(){balance = 50;}

    public void begin(){
        Scanner con = new Scanner(System.in);
        int choice = -1;


        do {
            try{
            menu();
            System.out.println("Give me a menu choice:");
            choice = con.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    subtract();
                    break;
                case 3:
                    print();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Wrong choice idiot");
            }
            System.out.println("*************************");
            }catch(Exception e){
                System.err.println("No characters, idiot");
                e.printStackTrace();
            }
        }while(choice != -1);
    }//begin

    private void add(){balance++;}
    private void subtract(){balance--;}
    private void print(){System.out.println(balance);}

    private void menu(){
        System.out.println("1 to add");
        System.out.println("2 to subtract");
        System.out.println("3 to print");
        System.out.println("-1 to exit");
    }



    public static void main(String[] args) {
        new SwitchDoWhile().begin();


    }//main


}//class
