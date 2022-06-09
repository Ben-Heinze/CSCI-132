package employeedriver;

import java.util.Random;

public class Employee {

    protected String firstName;
    protected String lastName;
    protected int id;

    public Employee(){
        firstName = null;
        lastName = null;

        Random rand = new Random();
        id = rand.nextInt(99);
    }

    public Employee(String first, String last){
        this.firstName = first;
        this.lastName = last;
        Random rand = new Random();
        id = rand.nextInt(99);

    }

    @Override
    public String toString() {
        return firstName +" "+lastName + " "+ id;
    }


}
