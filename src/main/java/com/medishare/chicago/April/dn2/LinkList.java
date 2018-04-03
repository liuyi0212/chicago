package com.medishare.chicago.April.dn2;

/**
 * Created by liuy on 2018/4/2.
 */
public class LinkList {

    public Person p;
    public Person p_1;


    public void set(Person person) {
        if (p == null) {
            p = person;
            p_1 = person;
        }else{
            System.out.println(p.hashCode() == p_1.hashCode());
            System.out.println(p==p_1);
            System.out.println(p.equals(p_1));
            p_1.setName(person.getName());
            p_1 = person;
        }

    }



    public Node first; // 定义一个头结点
    public Node next; // 定义一个头结点
    public Node next_1; // 定义一个头结点

    private int pos = 0;// 节点的位置

//    public LinkList() {
//        this.first = null;
//    }

    // 插入一个头节点
    public void addNode(Node node) {
//        node.next = first; //初始化
//        first = node; //赋值

        if (first == null) {
            first = node;
            next = node;
            next_1 = node;
            System.out.println("第一次" + first.data);
            System.out.println("第一次" + next.data);
            System.out.println("第一次" + next_1.data);
        } else {
            System.out.println(first == next);
            next.setNext(node);
            next = node;
        }
        System.out.println(first.data);
        System.out.println(next.data);
        System.out.println(next_1.data);

    }

    // 删除一个头结点,并返回头结点
    public Node deleteFirstNode() {
        Node tempNode = first;
        first = tempNode.next;
        return tempNode;
    }

    // 显示出所有的节点信息
    public void displayAllNodes() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    public void clear() {
        this.first.next = null;
        this.first.data = 0;
        System.gc();
    }


}
