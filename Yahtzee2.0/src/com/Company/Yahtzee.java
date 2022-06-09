package com.Company;

import java.util.Arrays;
import java.util.Random;

public class Yahtzee {
    private double ytz=0, fullH=0, largeS=0, fok=0, tok=0, losers=0;//overall score for each outcome

    //returns a sorted array of 5 with random nums
    public static int[] genDiceSet(){
        int[] diceSet = new int[5];
        Random rand = new Random();
        for(int i=0;i<diceSet.length; i++){
            diceSet[i] = rand.nextInt(1,7);
        }
        Arrays.sort(diceSet);
        return diceSet;
    } //DONE

    //takes a random array and grades it;loops ROLLS times.
    //When finished looping, it prints the statistics.
    public void play(int rolls){
        for(int i=0; i<=rolls;i++){//loops
            int[] diceSet = genDiceSet();//makes new dice set
            grade(diceSet);//grades dice set (updates counts)
        }
        print(rolls);
    }// //DONE

    public static boolean countYtz(int[] diceSet){
        int count =0;
        for(int i=0;i<diceSet.length;i++){
            if(diceSet[0]==diceSet[i])
                count++;
        }
        if(count==5)
            return true;
        else
            return false;
    }//DONE
    public boolean countFullHouse(int[] diceSet){
        int count1=0;
        int count2=0;

        for(int i=0;i<diceSet.length;i++){
            if(diceSet[i] == diceSet[0])
                count1++;
            else if(diceSet[i] ==diceSet[diceSet.length-1])//[diceSet.length-1] gets last index
                count2++;
        }
        if(count1==3&&count2==2 || count1==2&&count2==3)
            return true;
        return false;
    }//DONE
    public boolean countLargeS(int[] diceSet){
        int count=0,decrement=4;

        for(int i=4;i>0;i--){
            if(diceSet[i]-decrement== diceSet[0]){
                decrement--;
                count++;
            }
            else
                break;
        }
        if(count==4 && diceSet[0]+1 == diceSet[1])
            return true;
        return false;
    }

    public boolean countFok(int[] diceSet){
        int count1=0, count2=0;
        for(int i=0;i<diceSet.length;i++){
            if(diceSet[i]==diceSet[0])  //counts first number
                count1++;
            else if(diceSet[i]==diceSet[diceSet.length-1])
                count2++;
        }//for
        if(count1==4 || count2==4)
            return true;
        return false;
    }//DONE

    public boolean countTok(int[] diceSet){
        int count1=0,count2=0;//count1->first number, count2->middle number,
        for(int i =0;i<diceSet.length;i++){
            if(diceSet[i]==diceSet[2])//checks for 3's in indexes 0-2 (first three)
                count1++;
            else if(diceSet[i]==diceSet[diceSet.length-1])//checks for 3's for last index
                count2++;
        }//
        if(count1==3 || count2==3)
            return true;

        return false;
    }//DONE

    public void grade(int[] diceSet){
        if(countYtz(diceSet)==true)
            ytz++;
        else if(countFullHouse(diceSet)==true)
            this.fullH++;
        else if(countLargeS(diceSet)==true)
            this.largeS++;
        else if(countFok(diceSet)==true)
            this.fok++;
        else if(countTok(diceSet)==true)
            this.tok++;
        else
            this.losers++;
    }//grades and counts DONE

    public void print(int numOfRolls){
        System.out.println("Number of Rolls: "+ numOfRolls);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Number of Yahtzees: "+ (int)this.ytz);
        System.out.println("Yahtzee Percent: "+ ((this.ytz/numOfRolls)*100) +"%");
        System.out.println();
        System.out.println("Number of Full Houses: " + (int)this.fullH);
        System.out.println("Full House Percent: "+ ((this.fullH/numOfRolls)*100)+"%");
        System.out.println();
        System.out.println("Number of Large Straights: "+ (int)this.largeS);
        System.out.println("Large Straight Percent:  "+ ((this.largeS/numOfRolls)*100) +"%");
        System.out.println();
        System.out.println("Number of Four of a Kind: "+ (int)this.fok);
        System.out.println("Four of a Kind Percent:  "+ ((this.fok/numOfRolls)*100)+"%");
        System.out.println();
        System.out.println("Number of Three of a Kind: "+ (int)this.tok);
        System.out.println("Three of a Kind Percent:  "+ (((this.tok/numOfRolls)*100))+"%");
        System.out.println();
        System.out.println("Number of Losers: "+ (int)this.losers);
        System.out.println("Losers Percent " + ((this.losers/numOfRolls)*100)+"%");
    }//print statistics  ... wont get double right...

}
