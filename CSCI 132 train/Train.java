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
public class Train {
   
    public String name;
    public static int count = 0;
    public int num = 0;
    
    Train(String n)
    {
        name = n;
        count++;
        num++;
    }
    
           
    public String getName(){
        return name;
    }
    public void setTrainName(String x){ name = x;}
    
}
