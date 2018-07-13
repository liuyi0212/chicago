package com.medishare.chicago.service;

import com.medishare.chicago.constant.ReservationConstants;
import com.medishare.chicago.domain.reservation.Result;
import com.medishare.chicago.domain.reservation.ResultReservation;
import com.medishare.chicago.domain.reservation.ResultReservations;
import com.medishare.chicago.domain.reservation.ResultToMongo;
import com.medishare.chicago.utils.HttpClientUtils;
import com.medishare.chicago.utils.JSonUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuy on 2018/4/12.
 */
@Service
public class QingpuServiceImpl implements QingpuService{

    @Autowired
    Datastore ds;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    static Logger log = LoggerFactory.getLogger(QingpuServiceImpl.class);

    @Cacheable(value = "tool",
            key = "'find_privates_'+#map.get('hospitalId')")
    @Override
    public ResultReservations queryOneLevelDepartments(Map<String, String> map) {
        ResultReservations json = new ResultReservations();
        String result = HttpClientUtils.sendGet(ReservationConstants.MDS_URL_ONE_DEPARTMENTS, map);
        //result = "{\"code\":0,\"data\":[{\"departmentId\":\"1001\",\"departmentName\":\"内科\"},{\"departmentId\":\"1002\",\"departmentName\":\"外科\"}]}";
        log.info("queryOneLevelDepartments() param:" + JSonUtils.toJsonString(map) + " xml:" + result);
        try {
            if (StringUtils.isNotEmpty(result)) {
                json = JSonUtils.toObject(result, ResultReservations.class);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return json;
    }

    @Override
    public ResultReservations queryTwoLevelDepartments(Map<String, String> map) {
        ResultReservations json = new ResultReservations();
        String result = HttpClientUtils.sendGet(ReservationConstants.MDS_URL_TWO_DEPARTMENTS, map);
        //result = "{\"code\":0,\"data\":[{\"departmentId\":\"10001\",\"departmentName\":\"心内科\"},{\"departmentId\":\"10002\",\"departmentName\":\"呼吸内科\"}]}";
        log.info("queryTwoLevelDepartments() param:" + JSonUtils.toJsonString(map) + " xml:" + result);
        try {
            if (StringUtils.isNotEmpty(result)) {
                json = JSonUtils.toObject(result, ResultReservations.class);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return json;
    }

    @Override
    public ResultReservations querySchedules(Map<String, String> map) {
        ResultReservations json = new ResultReservations();
        String result = HttpClientUtils.sendGet(ReservationConstants.MDS_URL_SCHEDULE, map);
        log.info("querySchedules() param:" + JSonUtils.toJsonString(map) + " xml:" + result);
//    result = "{\"code\":0,\"data\":["
//        + "{\"sourceId\":\"1001\",\"scheduleTime\":\"2018-01-17\",\"idCard\":\"420624\",\"dayPart\":\"am\",\"doctorId\":\"1001\",\"doctorName\":\"wuhuan\",\"jobTitle\":\"主任医师\",\"beGoodAt\":\"擅长手术\",\"headPortraitUrl\":\"http://192.126.10.201//head.jpg\",\"departmentId\":\"1001\",\"departmentName\":\"内科\"},{\"sourceId\":\"1002\",\"scheduleTime\":\"2018-01-17\",\"idCard\":\"420624\",\"dayPart\":\"pm\",\"doctorId\":\"1001\",\"doctorName\":\"wuhuan\",\"jobTitle\":\"主任医师\",\"beGoodAt\":\"擅长手术\",\"headPortraitUrl\":\"http://192.126.10.201//head.jpg\",\"departmentId\":\"1001\",\"departmentName\":\"内科\"},"
//        + "{\"sourceId\":\"1003\",\"scheduleTime\":\"2018-01-17\",\"idCard\":\"420625\",\"dayPart\":\"am\",\"doctorId\":\"1002\",\"doctorName\":\"liuxiaogang\",\"jobTitle\":\"副主任医师\",\"beGoodAt\":\"擅长手术\",\"headPortraitUrl\":\"http://192.126.10.201//head.jpg\",\"departmentId\":\"1001\",\"departmentName\":\"外科\"},{\"sourceId\":\"1004\",\"scheduleTime\":\"2018-01-17\",\"idCard\":\"420625\",\"dayPart\":\"pm\",\"doctorId\":\"1002\",\"doctorName\":\"liuxiaogang\",\"jobTitle\":\"副主任医师\",\"beGoodAt\":\"擅长手术\",\"headPortraitUrl\":\"http://192.126.10.201//head.jpg\",\"departmentId\":\"1001\",\"departmentName\":\"内科\"},"
//        + "{\"sourceId\":\"1005\",\"scheduleTime\":\"2018-01-17\",\"dayPart\":\"am\",\"jobTitle\":\"医师\",\"beGoodAt\":\"擅长其他\",\"headPortraitUrl\":\"http://192.126.10.201//head.jpg\",\"departmentId\":\"1001\",\"departmentName\":\"外科\"},{\"sourceId\":\"1006\",\"scheduleTime\":\"2018-01-17\",\"dayPart\":\"pm\",\"jobTitle\":\"医师\",\"beGoodAt\":\"擅长其他\",\"headPortraitUrl\":\"http://192.126.10.201//head.jpg\",\"departmentId\":\"1001\",\"departmentName\":\"内科\"}"
//        + "]}";
        try {
            if (StringUtils.isNotEmpty(result)) {
                json = JSonUtils.toObject(result, ResultReservations.class);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return json;
    }

    @Override
    public void save(ResultToMongo result) {
        ds.save(result);
    }

    @Override
    public void remove() {
//        ds.getCollection("").remove(new ResultToMongo());
//        ResultToMongo r = new ResultToMongo();
//        ds.delete(r);
        DBCollection col = ds.getMongo().getDB("liuliang").getCollection("ResultToMongo");
        BasicDBObject values = new BasicDBObject();
//        values.put("className", "com.medishare.chicago.domain.reservation.ResultToMongo");
        values.put("className", "com.medishare.manis.domain.chcreferral.CHCReferralDTO");
        WriteResult writeResult = col.remove(values);
        System.out.println(JSonUtils.toJsonString(writeResult));
    }

    @Override
    public List<Result> searchResult() {

//        BasicDBObject query = new BasicDBObject();
//        query.put("name","");
//        Query<ResultToMongo> p = ds.createQuery(ResultToMongo.class).field("address").equal("aaa").order("address");
        Query<ResultToMongo> p = ds.createQuery(ResultToMongo.class);
        List<ResultToMongo> la = p.asList();
        List<Result> lb = new ArrayList<>();
        for (ResultToMongo rtm : la){
            Result r = new Result();
            dozerBeanMapper.map(rtm, r);
            lb.add(r);
        }
        return lb;
    }

    @Override
    public ResultReservation getReservationStatus(Map<String, String> map) {
        ResultReservation json = new ResultReservation();
        String result = HttpClientUtils.sendGet(ReservationConstants.MDS_URL_RESERVATION_STATUS,map);
        log.info("getReservationStatus() param:" + JSonUtils.toJsonString(map) + " xml:" + result);
        //result = "{\"code\":0,\"data\":{\"status\":\"1\"}}";
        try {
            if (StringUtils.isNotEmpty(result)) {
                json = JSonUtils.toObject(result, ResultReservation.class);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return json;
    }

    @Override
    public ResultReservation cancellingReservationState(Map<String, String> map) {
        ResultReservation json = new ResultReservation();
        String result = HttpClientUtils.sendGet(ReservationConstants.MDS_URL_CANCELLING_CANCELLING_RESERVATIONSTATE,map);
        log.info("cancellingReservationState() param:" + JSonUtils.toJsonString(map) + " xml:" + result);
        try {
            if (StringUtils.isNotEmpty(result)) {
                json = JSonUtils.toObject(result, ResultReservation.class);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return json;
    }


}
