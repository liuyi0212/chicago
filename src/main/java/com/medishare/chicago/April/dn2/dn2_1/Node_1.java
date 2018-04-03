package com.medishare.chicago.April.dn2.dn2_1;

/**
 * Created by liuy on 2018/4/3.
 */
public class Node_1 {
    private Object data;
    private Node_1 next;

    public Node_1(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node_1 getNext() {
        return next;
    }

    public void setNext(Node_1 next) {
        this.next = next;
    }
}
