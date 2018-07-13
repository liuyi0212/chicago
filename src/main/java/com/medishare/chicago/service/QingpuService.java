package com.medishare.chicago.service;

import com.medishare.chicago.domain.reservation.Result;
import com.medishare.chicago.domain.reservation.ResultReservation;
import com.medishare.chicago.domain.reservation.ResultReservations;
import com.medishare.chicago.domain.reservation.ResultToMongo;

import java.util.List;
import java.util.Map;

/**
 * Created by liuy on 2018/4/12.
 */
public interface QingpuService {

    /**
     * 获取一级科室列表
     *
     * @param map 根据hospitalId
     * @return
     */
    ResultReservations queryOneLevelDepartments(Map<String, String> map);

    /**
     * 获取二级科室列表
     *
     * @param map
     * @return
     */
    ResultReservations queryTwoLevelDepartments(Map<String, String> map);

    /**
     * 获取号源排班表
     *
     * @param map
     * @return
     */
    ResultReservations querySchedules(Map<String, String> map);

    void save(ResultToMongo result);

    void remove();

    List<Result> searchResult();

    /**
     * 获取预约状态
     * @param map
     * @return
     */
    ResultReservation getReservationStatus(Map<String, String> map);

    /**
     * 取消预约
     * @param map
     * @return
     */
    ResultReservation cancellingReservationState(Map<String, String> map);


}
