package com.medishare.chicago.service;

import com.medishare.chicago.domain.order.AbstractInvoice;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:23
 * @descripttion: com.medishare.chicago.service
 */
public interface AbstractOrderService {

    /***
     * 创建订单
     * @param abOrder
     * @return
     */
    String createOrders(AbstractInvoice abOrder);

    int updateAbstractOrder(AbstractInvoice abstractOrder);

    List<AbstractInvoice> randomTop(String num);

    void updateAbstractInvoice(List<AbstractInvoice> aiList);
}
