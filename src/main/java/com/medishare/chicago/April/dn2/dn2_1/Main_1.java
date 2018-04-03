package com.medishare.chicago.April.dn2.dn2_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuy on 2018/4/3.
 */
public class Main_1 {
    public static void main(String[] args) {
        Map<String,String> map01 = new HashMap<String,String>(){
            {
                put("11111","1");
            }
        };
        Map<String,String> map02 = new HashMap<String,String>(){
            {
                put("2","2");
            }
        };
        Map<String,String> map03 = new HashMap<String,String>(){
            {
                put("3","3");
            }
        };
        List list = new List();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(new Node_1("1"));
        list.add(new Node_1("2"));
        list.add(new Node_1("3"));
        list.add(new Node_1("4"));
        list.add(new Node_1("5"));
        list.printAll();
    }
}
