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
public class TrainDepot {
     private Train myTrain;
     public static int count = 0;
     
     public TrainDepot(Train mt)
     {
         myTrain = mt;
         count++;
     }
     
     public void setTrain(Train x)
     {
         myTrain = x;
     }
     public String getTrainName()
     {
         return myTrain.getName();
     }
}
