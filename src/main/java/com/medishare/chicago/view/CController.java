package com.medishare.chicago.view;

import com.medishare.chicago.domain.Money;
import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.member.Patient;
import com.medishare.chicago.domain.order.AbstractInvoice;
import com.medishare.chicago.service.AbstractOrderService;
import com.medishare.chicago.service.DoctorService;
import com.medishare.chicago.service.PatientService;
import com.medishare.chicago.utils.JSonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by liuy on 2018/4/3.
 */

@Controller
public class CController {

    @Autowired
    AbstractOrderService abstractOrderService;


    @ResponseBody
    @RequestMapping(path = "/test/c/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    String testB() {
        long start, end;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        start = System.currentTimeMillis();
        test();
        end = System.currentTimeMillis();


        return JSonUtils.toJsonString("========结束" + "start time:" + format.format(start) + "; end time:" + format.format(end) + "; Run Time:" + (end - start) + "(ms)");
    }


    void test() {
        boolean result = true;
        while(result){
            //获取服务包
            List<String> list = Arrays.asList("3", "4", "5");
            Collections.shuffle(list);
            List<AbstractInvoice> aiList = abstractOrderService.randomTop(list.get(0));
            abstractOrderService.updateAbstractInvoice(aiList);
            if(aiList.size()<3){
                result = false;
            }
        }

    }





}
