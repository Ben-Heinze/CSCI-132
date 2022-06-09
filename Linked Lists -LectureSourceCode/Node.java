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
public class Node {
   private Node next;
   private Node prev;
   private int data;
   Node(int d){ data = d; }
   public Node getPrev(){ return prev;}
   public Node getNext(){ return next;}
   public void setPrev(Node p){ prev = p;}
   public void setNext(Node n){next = n; }
   public int getData(){ return data; }
}
