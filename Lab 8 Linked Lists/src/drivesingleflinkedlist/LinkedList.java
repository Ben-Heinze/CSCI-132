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
public class LinkedList
{
      private Node first;
      
      LinkedList(){}//dummy node

      public void addToFront(Node temp){
            if(first == null) {
                first = temp;
                first.setNext(first);//points to itself
                first.setPrev(first);
            }
            else{
                Node last = first.getPrev();
                last.setNext(temp);//sets last to temp
                temp.setPrev(last);//points prev pointer to 'new' first(tempt)
                temp.setNext(first);
                first.setPrev(temp);
                first = temp;
            }
      }
      public void addToBack(Node temp)
      {
           if(first == null){
               first = temp;
               first.setNext(first);
               first.setPrev(first);
           }
           else{
               Node last = first.getPrev();
               temp.setNext(first);//loops last to first

               temp.setPrev(last);
               last.setNext(temp);
               first.setPrev(temp);
           }
      }
      public void addInOrder(Node temp)
      {
          System.out.println("temp " + temp.getData());
          if(first == null){
              first = temp;
              first.setNext(first);
              first.setPrev(first);
              return;
          }
                 
          Node iter = first;
          if(iter.getNext() == first)
          {
              if(iter.getData() < temp.getData()){
                  iter.setNext(temp);
                  iter.setPrev(temp);
                  temp.setPrev(iter);
                  temp.setNext(iter);
                  return;
              }
              else{
                  iter.setPrev(temp);
                  iter.setNext(temp);
                  temp.setNext(iter);
                  temp.setPrev(iter);
                  first = temp;
                  return;
              }
          }
          while(temp.getData() > iter.getData())
          {
             
              if(iter.getNext() == first)
              {
                   iter.setNext(temp);
                   temp.setPrev(iter);
                   first.setPrev(temp);
                   temp.setNext(first);
                   return;
              }
              iter = iter.getNext();
            
          }
          if(iter == first)
          {
              temp.setNext(iter);
              temp.setPrev(iter.getPrev());
              iter.getPrev().setNext(temp);
              iter.setPrev(temp);

              first = temp;
              return;
          }
          iter.getPrev().setNext(temp);
          temp.setPrev(iter.getPrev());
          temp.setNext(iter);
          iter.setPrev(temp);
      }

      public boolean deleteNode(int del)
      {//do while
          Node iter = first;
          Node last = first.getPrev();
          System.out.println("last... getPrev: "+ last);
          if(first.getData() == del) //if the first item in list needs to be deleted...
          {
              first = first.getNext();
              first.setPrev(last);
              return true;
          }
          else if(first.getPrev().getData() == del){//if last item is del...
              first.setPrev(last.getPrev());//sets first prev to the old last prev
              last.getPrev().setNext(first);//sets last prev to point to first

          }
          while(iter!=first.getPrev())
          {
              if(iter.getData() == del)
              {
                  iter.getPrev().setNext(iter.getNext());
                  if(iter.getNext() != first.getPrev())// if its not last
                      iter.getNext().setPrev(iter.getPrev());
                  return true;
              }
              iter = iter.getNext();
          }
          return false;
      }
      public void print(){
          System.out.println("****************");
          Node iter = first;
          Node last = first.getPrev();//sets last
          do{
              System.out.println(iter);
              iter = iter.getNext();
          }while(iter!=last);
          System.out.println(iter);
      }

      public void printBackwards(){
          System.out.println("****************");
          Node iter = first.getPrev();
          do{
              System.out.println(iter);
              iter = iter.getPrev();
          }while(iter!=first);
          System.out.println(iter);

      }
      
      
      
}
