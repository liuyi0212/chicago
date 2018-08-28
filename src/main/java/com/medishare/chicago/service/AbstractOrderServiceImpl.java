package com.medishare.chicago.service;

import com.medishare.chicago.dao.AbstractOrderDAO;
import com.medishare.chicago.dao.DoctorDAO;
import com.medishare.chicago.domain.Money;
import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.order.AbstractInvoice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:23
 * @descripttion: com.medishare.chicago.service
 */
@Component
public class AbstractOrderServiceImpl implements AbstractOrderService {

    @Autowired
    AbstractOrderDAO abstractOrderDAO;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorDAO doctorDAO;


    @Override
    public String createOrders(AbstractInvoice abOrder) {
        if (StringUtils.isEmpty(abOrder.getProStatus())) {
            abOrder.setProStatus("0");
        }
        if (abOrder.getServiceCharge() == null) {
            abOrder.setServiceCharge(new Money(0));
        }
        if (StringUtils.isBlank(abOrder.getServedUserId())) {
            abOrder.setServedUserId(abOrder.getOwnerId());
            abOrder.setServedUserName(abOrder.getOwnerName());
        }

        int count = abstractOrderDAO.insertAbstract(abOrder);
        if (count <= 0) {
            return null;
        }
        return abOrder.getId();
    }

    @Override
    public int updateAbstractOrder(AbstractInvoice abstractOrder) {
        return abstractOrderDAO.updateAbstractOrder(abstractOrder);
    }

    @Override
    public List<AbstractInvoice> randomTop(String num) {
        return abstractOrderDAO.selectBy(Integer.valueOf(num));
    }

    @Override
    public void updateAbstractInvoice(List<AbstractInvoice> aiList) {

        Doctor doctor = doctorService.findDoctorLimit1();
        aiList.forEach(l->{
            abstractOrderDAO.update(l.getOwnerId(), doctor.getId(), doctor.getRealname());
        });
        doctor.setSource("9");
        doctorDAO.updateDoctor(doctor);
    }


}
