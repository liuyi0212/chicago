package com.medishare.chicago.April.dn2.dn2_0;

/**
 * Created by liuy on 2018/4/3.
 */
public class List {
    private Node first;
    private Node temp;

    public void add(Node node){
        if(first == null){
            first = node;
            temp = node;
        }else{
            temp.setNext(node);
            temp = node;
        }
    }

    public void print(Node node){
        if(node != null){
            System.out.println(node.getData());
            print(node.getNext());
        }
    }

    public void printAll(){
        print(this.first);
    }
}
