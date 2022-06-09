package com.company;

public class Node {
    private int data;
    private Node next;
    private Node prev;


    Node(int input){
        next = null;
        prev = null;
        data = input;
    }


    public void setNext(Node n) {next = n;}
    public void setPrev(Node p) {prev = p;}

    public Node getNext() {return next;}
    public Node getPrev() {return prev;}

    public int getData() {return data;}



    @Override
    public String toString(){return "The data is "+ data;}
}
