package employeedriver;

public class Hourly extends Employee {

    protected double wage;
    protected int hoursWorked;


    public Hourly() {
        super();
    }

    public Hourly(String first,String last, double wage, int hours) {
        super(first,last);
        this.wage = wage;
        this.hoursWorked = hours;
    }


    @Override
    public String toString() {
        return super.toString()+" " +wage +" "+ hoursWorked;
    }

}