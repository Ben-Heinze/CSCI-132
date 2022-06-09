/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivertrain;

/**
 *
 * @author Hunter
 */
public class DriverTrain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
         TrainDepot td = new TrainDepot(new Train("Thomas"));
         Train percy = new Train("Percy");
         TrainDepot second = td;
         td.setTrain(percy);
         
         System.out.println(td.getTrainName());
         System.out.println(second.getTrainName());
         
         percy.setTrainName("Francis");
         
         System.out.println(td.getTrainName());
         System.out.println(second.getTrainName());
         
         Train x = new Train("Rick");
         System.out.println(Train.count);
         System.out.println(percy.num);
         System.out.println(percy.count);
         System.out.println(x.count);
         
         
    }
    
}
