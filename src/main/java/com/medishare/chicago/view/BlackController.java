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
public class BlackController {

    @Autowired
    AbstractOrderService abstractOrderService;
    @Autowired
    PatientService patientService;
    @Autowired
    DoctorService doctorService;

    static int tuwenAmount = 5;
    static int dianhuaAmount = 10;
    static int jianhouAmount = 100;
    static int totalAmount = 5 + 10 + 100;

    public static void main(String[] args) {
        //患者订单金额在100，300正整数
        //图文金额五元，电话咨询十元，检后咨询一百元
        //图文最小最大概率0~60之间
        //电话最小最大概率0~30之间
        //检后最小最大概率0~3之间

        //总金额
        int totalAmount = 300;
        //总次数
        int totalNum = 0;
        //累计数量
        int cumulative = 0;

        Random r = new Random();
        for (int i =0; i<300; i++){
            System.out.println(r.nextInt(301));
        }


    }

    @ResponseBody
    @RequestMapping(path = "/test/case/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    String testCase(@RequestParam(value = "a", required = false, defaultValue = "300") int a) {
        long start,end;
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        start = System.currentTimeMillis();
        test(a);
        end = System.currentTimeMillis();
        return JSonUtils.toJsonString("start time:" + format.format(start) + "; end time:" + format.format(end) + "; Run Time:" + (end - start) + "(ms)");
    }


    void test(int a) {
        int cumulativeAmount = 0;
        int cycleTime = 0;
        boolean isnext = true;
        int total = a;
        while(isnext){
            //本次用户生成服务包总金额
            int personAmount = getPersonPayServiceAmount();
            cumulativeAmount = cumulativeAmount + personAmount;
            if((total-cumulativeAmount) < 0){
                roundOutput(personAmount, "zidingyiB", total - (cumulativeAmount - personAmount), 1, String.valueOf(System.currentTimeMillis()));
                break;
            }
            System.out.println("============================分隔符============================生成总金额" + cumulativeAmount);
            System.out.println("============================分隔符============================剩余总金额" + (total-cumulativeAmount));
            System.out.println("============================分隔符============================当前循环次数" + cycleTime++);
            //第一轮服务包顺序下标0，1，2
            List<String> list = Arrays.asList("tuwen", "dianhua", "zhenhou");
            Collections.shuffle(list);
            String timeMillis = String.valueOf(System.currentTimeMillis());
            int sumServiceAmount = 0;
            for (int i = 0; i < list.size(); i++) {
                boolean result = true;
                if (result) {
                    //服务包金额
                    int serviceAmount = getServiceAmount(list.get(i));
                    //服务包生成次数
                    int serviceNum = getServiceNum(personAmount, serviceAmount);
                    int realNum = getServiceNum(serviceNum);

                    System.out.println("第" + i + "次服务包金额，服务包名称：" + list.get(i) + "生成服务包金额：" + serviceAmount + "    生成服务包次数" + realNum);
                    roundOutput(personAmount, list.get(i), serviceAmount, realNum, timeMillis);
                    sumServiceAmount = sumServiceAmount + serviceAmount * realNum;
                    if (i == 2) {
                        result = false;
                    }
                }
            }

            if((total-cumulativeAmount) < 100){
                roundOutput(personAmount, "zidingyiA", total-cumulativeAmount, 1, String.valueOf(System.currentTimeMillis()));
                isnext = false;
            }
        }
    }

    void roundOutput(int personAmount, String serviceType, int serviceAmount, int serviceNum, String timeMillis) {
        for (int i = 0; i < serviceNum; i++) {
            Patient patient = patientService.findPatientLimit1();
            Doctor doctor = doctorService.findDoctorLimit1();
            AbstractInvoice ai = new AbstractInvoice();
            ai.setPrice(new Money(serviceAmount));
            ai.setTitle(serviceType);
            ai.setDescription(serviceType);
            ai.setStatus("SERVICE_DONE");
            ai.setBatch(timeMillis);
            ai.setOwnerId(patient.getId());
            ai.setOwnerName(patient.getRealname());
            ai.setPartyBId(doctor.getId());
            ai.setPartyBName(doctor.getRealname());
            abstractOrderService.createOrders(ai);
        }
    }


    int getPersonPayServiceAmount() {
        int amount = new Random().nextInt(301);
        if (amount < 100) {
            amount = amount+100;
        }
        return amount;
    }

    int getServiceAmount(String serverType) {
        int serviceAmount;
        if (serverType == "tuwen") {
            serviceAmount = 5;
        } else if (serverType == "dianhua") {
            serviceAmount = 10;
        } else {
            serviceAmount = 100;
        }
        return serviceAmount;
    }

    String getServiceType() {
        int num = new Random().nextInt(3);
        String serviceType;
        if (num == 0) {
            serviceType = "tuwen";
        } else if (num == 1) {
            serviceType = "dianhua";
        } else {
            serviceType = "zhenhou";
        }
        return serviceType;
    }

    int getServiceNum(int personAmount, int serviceAmount) {
        return (int) Math.floor(personAmount / serviceAmount);
    }


    int getServiceNum(int num) {
        int max = num;
        int min = 0;

        int result = min + (int) (Math.random() * ((max - min) + 1));
        return result;
    }
}
