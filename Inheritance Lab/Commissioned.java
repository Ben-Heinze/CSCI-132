package employeedriver;

public class Commissioned extends Employee {

    protected double rate;
    protected int grossSales;

    public Commissioned(){
        super();
    }

    public Commissioned(String first, String last, double rate, int grossSales){
        super(first, last);
        this.rate = rate;
        this.grossSales = grossSales;
    }


    @Override
    public String toString() {
        return super.toString() +" " +rate +" "+ grossSales;
    }
}
