package com.medishare.chicago.April.dn2.dn2_1;

/**
 * Created by liuy on 2018/4/3.
 */
public class List {
    private Node_1 root;
    private Node_1 point;
    private int count;

    public void add(Node_1 node_1){
        if(root == null){
            this.root = node_1;
            this.point = node_1;
        }else{
            this.point.setNext(node_1);
            this.point = node_1;
        }
        count++;
    }

    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.root == null ? true : false;
    }

    private void print(Node_1 node){
        if(node == null){
            return;
        }
        System.out.println(node.getData());
        print(node.getNext());
    }

    public void printAll(){
        print(this.root);
    }

}
