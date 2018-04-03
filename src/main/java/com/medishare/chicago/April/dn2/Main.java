package com.medishare.chicago.April.dn2;

import java.util.Arrays;

/**
 * Created by liuy on 2018/4/2.
 */
public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
//        list.addNode(new Node(1));
//        list.addNode(new Node(2));
//        list.addNode(new Node(3));
//        list.addNode(new Node(4));
//        list.addNode(new Node(5));
//        list.deleteFirstNode();
//        list.clear();
//        list.displayAllNodes();
        list.set(new Person(Arrays.asList("2")));
        list.set(new Person(Arrays.asList("2,3")));
        list.set(new Person(Arrays.asList("2,3,4")));
        list.set(new Person(Arrays.asList("2,3,4,5")));
    }
}
