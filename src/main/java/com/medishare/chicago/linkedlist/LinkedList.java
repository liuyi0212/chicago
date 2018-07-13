package com.medishare.chicago.linkedlist;

/**
 * Created by liuy on 2018/4/8.
 */
public class LinkedList {

    static LinkedList l = new LinkedList();

    public static void main(String[] args) {
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
//        l.print();
//        l.length();
        l.deleteNode(2);
        l.print();
//        int j = 3;
//        System.out.println(j++);
//        System.out.println(++j);
    }

    Node head = null;

    public void add(int data){
        Node node = new Node(data);

        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while(temp.getNode() != null){
            temp = temp.getNode();
        }
        temp.setNode(node);
    }

    public boolean deleteNode(int index) {
        if (index < 1 || index > l.length()) {
            System.out.println("长度有问题");
            return false;
        }
        if (index == 1) {
            head = head.getNode();
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.getNode();
        while (curNode != null) {
            if (i == index) {
                preNode.setNode(curNode.getNode());
                return true;
            }
            preNode = curNode;
            curNode = curNode.getNode();
            ++i;
        }
        return false;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNode();
        }
    }

    public int length(){
        int length = 0;
        Node temp = head;
        while(temp!=null){
            length++;
            temp = temp.getNode();
        }
        System.out.println(length);
        return length;
    }
}
