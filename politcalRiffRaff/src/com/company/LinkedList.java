package com.company;

public class LinkedList {

    private Node first;

    public Node getLast() {
        return first.getPrev();
    }

    public Node getFirst() {
        return first;
    }

    public int getLength() {
        //checks if first exists
        int count = 0;
        Node iter = first;//starts node at first
        if (iter == null)//checks if linked list is empty; return 0 if it is
            return 000;
        do {
            iter = iter.getNext();
            count++;

        } while (iter != first);//loops through Linked List and counts Nodes//iter.getNext().getData() == first.getData()
        return count;
    }//... DONE

    public void addToBack(Node temp) {
        if (first == null) {
            first = temp;
            first.setNext(first);
            first.setPrev(first);
            //System.out.println("first's Prev: " + first.getPrev());
        }//if linkedList is empty,fill it
        else {
            Node last = first.getPrev();
            temp.setNext(first);//loops last to first

            temp.setPrev(last);
            last.setNext(temp);
            first.setPrev(temp);

            //prints out the candidates number that was added behind first
            //System.out.println("first's Prev: " + first.getPrev());
        }
    }//... DONE

    public Node move(Node e, int[] array, int size, boolean isK) {
        if(size<3)//if there are more than 3 nodes, go to removeSpecial cases method
            removeSpecialCases(array,size,e);
        else if (isK) {
            if (array[1] <= size) {
                for (int i = 1; i <= array[1]; i++) { //loops 4 times
                    e = e.getNext();//iterate
                }
                e = e.getPrev();
            }//if there are more nodes than spaces to move
        }//K movement
        else {
            if (array[2] <= size) {
                for (int i = 1; i <= array[2]; i++) {
                    e = e.getPrev();
                }
                e = e.getNext();
            }
        }//Go here if node m is sent
        return e;
    }//move()

    public Node remove(Node e, boolean isK, int listSize) {
        //System.out.println("person selected for removal: " + e.getData());
        e.getPrev().setNext(e.getNext());
        e.getNext().setPrev(e.getPrev());
        if (isK) {
            if (e.getNext() == e)
                e = null;
            else
                e = e.getNext();
        } else if (!isK) {
            if (e.getNext() == e) {
                e = null;
            }
            else
                e = e.getPrev();
        }
        return e;
    }//mostly confident its done

    //k value is greater than the size of the list
    public Node removeSpecialCases(int[] array,int size ,Node e){
        if(size>=3){
            //use modulo function to remove unnecessary spinning
            //System.out.println("RSC size>=3");
            int move = array[1]%size;
            for(int i=1;i<=move;i++){
                e=e.getNext();
            }
            e=e.getNext();//
            e.getPrev().setNext(e.getNext());
            e.getNext().setPrev(e.getPrev());
        }
        else if(size==2){
            if(array[1]%2==0) {
                e=e.getNext();
                e.setPrev(e);
                e.setNext(e);
                first=e;
            }//checks if arr[1] is even
            else{
                e.setNext(e);
                e.setPrev(e);
                first=e;
            }//if its odd, remove e
        }

        else if(size==1){
            e=null;
        }//remove last node
        else
            return e;
        return e;
    }//removeSpecialCase
}