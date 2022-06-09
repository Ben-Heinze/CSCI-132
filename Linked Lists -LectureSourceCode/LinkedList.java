/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistsfall21;

/**
 *
 * @author Hunter
 */
public class LinkedList {
    private Node first;
    
    public void print(){
        Node iter = first;
        while(iter != null)
        {
            System.out.println(iter.getData());
            iter = iter.getNext();
        }
    }
    public void add(int num){
        Node temp = new Node(num);
        if(first == null)
        {
            first = temp;
       
        } 
        else{    
            temp.setNext(first);
            first.setPrev(temp);
            first = temp;
         }
        
        
    }
    public void search(int num){
        Node iter = first;
        while(iter != null)
        {
            if(iter.getData() == num){
                 System.out.println("Found " +  iter.getData());
                 return;
            }
             iter = iter.getNext();
        }
        System.out.println("Didn't find " + num);
    }
    public boolean deleteNode(int num){
        Node iter = first;
        
        
        while(iter != null)
        {
            
            if(iter.getData() == num)
            {
                if (iter == first)
                {
                    first = first.getNext();
                    first.setPrev(null);
                    return true;
                }
                else if(iter.getNext() != null)
                   iter.getNext().setPrev(iter.getPrev());
                iter.getPrev().setNext(iter.getNext());
                return true;
            }
            iter = iter.getNext();
        }
    
        return false;
    }
    
    
}
