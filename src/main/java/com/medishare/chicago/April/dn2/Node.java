package com.medishare.chicago.April.dn2;

/**
 * Created by liuy on 2018/4/2.
 */
public class Node {

    protected int data;//数据域

    protected Node next; //指针域

    public Node( int data) {
        this.data = data;
    }

    //显示此节点
    public void display() {
        System.out.print( data + " ");
    }


    public void setNext(Node next) {
        this.next = next;
    }
}
