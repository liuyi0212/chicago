package com.medishare.chicago.linkedlist;

/**
 * Created by liuy on 2018/4/8.
 */
public class Node {
    public int data;
    public Node node;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
