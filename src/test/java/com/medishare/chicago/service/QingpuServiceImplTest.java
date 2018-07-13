package com.medishare.chicago.service;

import com.medishare.chicago.Application;
import com.medishare.chicago.config.DatabaseConfig;
import com.medishare.chicago.config.MybatisConfig;
import com.medishare.chicago.dao.RedisClient;
import com.medishare.chicago.domain.reservation.Result;
import com.medishare.chicago.domain.reservation.ResultReservation;
import com.medishare.chicago.domain.reservation.ResultToMongo;
import com.medishare.chicago.utils.DateUtils;
import com.medishare.chicago.utils.JSonUtils;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.ParseException;
import java.util.*;

/**
 * Created by liuy on 2018/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, DatabaseConfig.class, MybatisConfig.class})
@WebAppConfiguration
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class QingpuServiceImplTest {

    @Autowired
    QingpuService qingpuService;

    @Autowired
    RedisClient redisClient;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Test
    public void testCase() {
        System.out.println("测试案例");
    }


    @Test
    public void testRedisClient() throws Exception {
//        List list = new ArrayList(Arrays.asList("1", "2", "3"));
//        Long l = redisClient.set("list", list);
//        List<Result> l = qingpuService.searchResult();
//        redisClient.set( "good", JSonUtils.toJsonString(l.get(0)));

        String str = redisClient.get("good");

        System.out.println(str);
//		redisClient.set("HAHA","HAHA");
//		System.out.println(redisClient.get("foo"));
//		System.out.println(redisClient.get("HAHA"));
    }

    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("hospitalId", "01");
//		map.put("departmentId", departmentId);
        qingpuService.queryOneLevelDepartments(map);
    }

    @Test
    public void testDate() throws ParseException {
        List<String> dateCollection = DateUtils.getFutureDateCollection("2018-04-13", 10);
        System.out.println(dateCollection);
    }

    @Test
    public void testQingpuSchedules() {
        ResultToMongo result = new ResultToMongo();
        result.setAddress("aaa");
        result.setDayPart("11");
        qingpuService.save(result);
    }

    @Test
    public void testQingpuSchedulesSearch() {
        List<Result> l = qingpuService.searchResult();
        System.out.println(JSonUtils.toJsonString(l));
    }

    @Test
    public void testDelete(){
        qingpuService.remove();
    }


    @Test
    public void testGetReservationStatus(){

        List<String> list = new ArrayList<>(Arrays.asList("844964","896023","896027","900361","901571"));
        try {
            list.forEach(l -> {
                Map<String, String> map = new HashMap<>();
                map.put("reservationNumber", l);//842894  842899

                ResultReservation ret = qingpuService.getReservationStatus(map);
                System.out.println("预约单号：" + l + "返回信息" + JSonUtils.toJsonString(ret));
            });
        } catch (Exception ex) {
            System.err.println("==========================");
            ex.printStackTrace();
            System.out.println("ret: " + "失败!");
            System.err.println("==========================");
            Assert.fail("The catching");
        }
    }
}