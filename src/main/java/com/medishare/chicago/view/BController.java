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
import java.util.*;

/**
 * Created by liuy on 2018/4/3.
 */

@Controller
public class BController {

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

    @ResponseBody
    @RequestMapping(path = "/test/b/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    String testB(@RequestParam(value = "a", required = false, defaultValue = "300") int a) {
        long start, end;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        start = System.currentTimeMillis();
        test(a);
        end = System.currentTimeMillis();
        return JSonUtils.toJsonString("========结束" + "start time:" + format.format(start) + "; end time:" + format.format(end) + "; Run Time:" + (end - start) + "(ms)");
    }


    void test(int a) {
        //生成服务单总金额
        int total = a;
        int cycleTime = 0;
        int cumulativeAmount = 0;
        boolean isnext = true;
        while (isnext) {
            //生成当前患者服务包金额
            int personAmount = getPersonPayServiceAmount();
            cumulativeAmount = cumulativeAmount + personAmount;
            if ((total - cumulativeAmount) < 0) {
                Patient patient = patientService.findPatientLimit1();
                roundOutput(patient, 0, "zidingyi", total - (cumulativeAmount - personAmount), 1, String.valueOf(System.currentTimeMillis()));
                break;
            }

            List<String> list = Arrays.asList("tuwen", "dianhua", "zhenhou");
            Collections.shuffle(list);
            String timeMillis = String.valueOf(System.currentTimeMillis());
            System.out.println("============================分隔符============================生成总金额：" + cumulativeAmount);
            int personBalanceAmount = 0;
            int personRealAmount = personAmount;
            //循环生成 服务单
            Patient patient = patientService.findPatientLimit1();
            for (int i = 0; i < list.size(); i++) {


                System.out.println("============================分隔符============================当前循环次数：" + cycleTime++);
                boolean result = true;
                if (result) {
                    //获取服务包金额
                    int serviceAmount = getServiceAmount(list.get(i));
                    int serviceNum = getServiceNum(personRealAmount, serviceAmount);
                    int realNum = getServiceNum(serviceNum);
                    System.out.println("===============生成服务单名称：" + list.get(i) + "生成服务包金额：" + serviceAmount + "生成服务包次数：" + realNum);
                    if (realNum > 0) {
                        roundOutput(patient, personAmount, list.get(i), serviceAmount, realNum, timeMillis);
                        personRealAmount = personRealAmount - (serviceAmount * realNum);
                        personBalanceAmount = personBalanceAmount + serviceAmount * realNum;
                        System.out.println("===============服务单总金额：" + personAmount + "服务单生成金额：" + personBalanceAmount + "服务单剩余金额：" + personRealAmount);
                    }

                    if (i == 2) {
                        if ((personAmount - personBalanceAmount) > 0) {
                            System.out.println("===============生成自定义服务包金额：" + (personAmount - personBalanceAmount));
                            roundOutput(patient, 0, "zidingyi", (personAmount - personBalanceAmount), 1, timeMillis);
                        }
                        result = false;
                    }
                }
            }
            if ((total - cumulativeAmount) < 5) {
                Patient patientA = patientService.findPatientLimit1();
                roundOutput(patientA, 0, "zidingyiC", total - cumulativeAmount, 1, String.valueOf(System.currentTimeMillis()));
                isnext = false;
            }
        }
    }


    void roundOutput(Patient patient, int personAmount, String serviceType, int serviceAmount, int serviceNum, String timeMillis) {
        Date date = randomDate("2018-08-20","20018-08-26");
        for (int i = 0; i < serviceNum; i++) {
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
            ai.setCreated(randomDateBetweenMinAndMax());
            ai.setRemarks("2018年08月23日16:50");
            abstractOrderService.createOrders(ai);
            patient.setMedicareCard("9");
            patientService.update(patient);
        }
    }

    public static Date randomDateBetweenMinAndMax(){
        Calendar calendar = Calendar.getInstance();
        //注意月份要减去1
        calendar.set(2018,8,20);
        calendar.getTime().getTime();
        //根据需求，这里要将时分秒设置为0
        calendar.set(Calendar.HOUR_OF_DAY, new Random().nextInt(22 - 10 + 1) + 10);
        calendar.set(Calendar.MINUTE, new Random().nextInt(60));
        calendar.set(Calendar.SECOND,new Random().nextInt(60));
        long min = calendar.getTime().getTime();
        calendar.set(2018,8,26);
        calendar.set(Calendar.HOUR_OF_DAY,new Random().nextInt(22 - 10 + 1) + 10);
        calendar.set(Calendar.MINUTE,new Random().nextInt(60));
        calendar.set(Calendar.SECOND,new Random().nextInt(60));
        calendar.getTime().getTime();
        long max = calendar.getTime().getTime();
        //得到大于等于min小于max的double值
        double randomDate = Math.random()*(max-min)+min;
        //将double值舍入为整数，转化成long类型
        calendar.setTimeInMillis(Math.round(randomDate));
        return calendar.getTime();
    }



    int getPersonPayServiceAmount() {
        int amount = new Random().nextInt(301);
        if (amount < 100) {
            amount = amount + 100;
        }
        return amount;
    }

    int getServiceAmount(String serverType) {
        int serviceAmount;
        if (serverType == "tuwen") {
            serviceAmount = 5;
        } else if (serverType == "dianhua") {
            serviceAmount = 10;
        } else if (serverType == "zhenhou") {
            serviceAmount = 100;
        } else {
            serviceAmount = 300;
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
        } else if (num == 2) {
            serviceType = "zhenhou";
        } else {
            serviceType = "zidingyi";
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

    /**
     * 获取随机日期
     * @param beginDate 起始日期，格式为：yyyy-MM-dd
     * @param endDate 结束日期，格式为：yyyy-MM-dd
     * @return
     */
    private Date randomDate(String beginDate, String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);  // 构造开始日期
            Date end = format.parse(endDate);  // 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if(start.getTime() >= end.getTime()){
                return null;
            }

            long date = random(start.getTime(),end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }


}
