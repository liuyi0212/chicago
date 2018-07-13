package com.medishare.chicago.utils;

import java.util.List;

/**
 * Created by liuy on 2018/4/4.
 */
public class ListUtils {
    /**
     * 判断list是否为null, true是false否
     * @param list
     * @return
     */
    public static boolean isNUll(List<Object> list){
        return (list ==null && list.isEmpty());
    }
}
