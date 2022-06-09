public class DriverTrain {


    public static void main(String[] args){

        TrainDepot td = new TrainDepot(new Train("Thomas"));
        Train percy = new Train("percy");
        TrainDepot second = td;

        td.setTrain(percy);
    }
}
