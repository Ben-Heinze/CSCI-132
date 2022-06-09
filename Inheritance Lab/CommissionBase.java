package employeedriver;

public class CommissionBase extends Commissioned{

    protected int base_salary;

    public CommissionBase(){
        super();
    }

    public CommissionBase(String first, String last,double rate, int grossSales,int baseSalary){
        super(first,last,rate,grossSales);
        this.base_salary = baseSalary;

    }

    @Override
    public String toString() {
        return super.toString()+ " " + base_salary;
    }


}
