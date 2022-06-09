/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivesingleflinkedlist;

/**
 *
 * @author Hunter
 */

//=============DONT====================
//=============TOUCH===================
public class Node {
    private int data;
    private Node next;
    private Node prev;
    
    Node(int input){
        next = null;
        prev = null;
        data = input;
    }
    
    public void setNext(Node n){
            next = n;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setPrev(Node p)
    {
        prev = p;
    }
    public Node getPrev(){
        return prev;
    }
    
    public int getData()
    {
        return data;
    }
    
    @Override
    public String toString()
    {
        return "The data is " + data;
    }
    
}
