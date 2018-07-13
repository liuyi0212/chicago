package com.medishare.chicago.view;

import com.medishare.chicago.api.ScheduleDTO;
import com.medishare.chicago.api.SourceDTO;
import com.medishare.chicago.domain.reservation.Result;
import com.medishare.chicago.domain.reservation.ResultReservation;
import com.medishare.chicago.domain.reservation.ResultReservations;
import com.medishare.chicago.domain.reservation.ResultToMongo;
import com.medishare.chicago.service.QingpuService;
import com.medishare.chicago.utils.ComparatorResultUtil;
import com.medishare.chicago.utils.DateUtils;
import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSonUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liuy on 2018/4/3.
 */

@RestController
public class QingpuController {

    @Autowired
    QingpuService qingpuService;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @RequestMapping(path = "/first/", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String queryOneLevelDepartments() {
        JSONRet ret = new JSONRet();
        Map<String, String> map = new HashMap<>();
        map.put("hospitalId", "01");
//		map.put("departmentId", departmentId);
        ResultReservations s = qingpuService.queryOneLevelDepartments(map);
//        List<String> list = s.getData().stream().map(Result :: getDepartmentId).collect(Collectors.toList());
        ret.setData(s.getData());
        return JSonUtils.toJsonString(ret);
    }

    @RequestMapping(path = "/cancel/", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String cancel(@RequestParam(value = "id") String id) {
        JSONRet ret = new JSONRet();
        Map<String, String> map = new HashMap<>();
        map.put("reservationNumber", id);
        ResultReservation i = qingpuService.cancellingReservationState(map);
        ret.setData(i);
        return JSonUtils.toJsonString(ret);
    }

    /**
     * 获取一级科室列表
     *
     * @return
     */
    public List<Result> getFirst() {
        Map<String, String> map = new HashMap<>();
        map.put("hospitalId", "01");
        ResultReservations s = qingpuService.queryOneLevelDepartments(map);
//        List<String> list = s.getData().stream().map(Result :: getDepartmentId).collect(Collectors.toList());
        return s.getData();
    }

    @RequestMapping(path = "/second/", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String queryTwoLevelDepartments(HttpServletRequest req,
                                           @RequestParam(value = "departmentId", defaultValue = "03") String departmentId) {
        JSONRet ret = new JSONRet();
        List<Result> firstList = getFirst();  //获取到一级科室
        List<Map<String, Object>> secondList = new ArrayList<>();
        for (Result result : firstList){
            Map<String, Object> resultMap = new HashMap<>();

            Map<String, String> map = new HashMap<>();
            map.put("hospitalId", "01");
            map.put("departmentId", result.getDepartmentId());
            ResultReservations s = qingpuService.queryTwoLevelDepartments(map);
            resultMap.put("departmentId",result.getDepartmentId());
            resultMap.put("departmentName",result.getDepartmentName());
            resultMap.put("secondList",s.getData());
            secondList.add(resultMap);
        }

//        List<Result> secondList = getSecond();
        ret.setData(secondList);
        return JSonUtils.toJsonString(ret);
    }

    /**
     * 获取二级科室列表
     *
     * @return
     */
    public List<Result> getSecond() {

        List<Result> firstResultList = getFirst();
        List<String> firstDepartmentIds = firstResultList.stream().map(Result::getDepartmentId).collect(Collectors.toList());
        List<Result> secondDepartmentsDataList = new ArrayList<>();
        for (String str : firstDepartmentIds) { //循环一级科室
            Map<String, String> secondMap = new HashMap<>();  //二级科室参数
            secondMap.put("hospitalId", "01");
            secondMap.put("departmentId", str);
            ResultReservations secondDepartments = qingpuService.queryTwoLevelDepartments(secondMap); //获取二级科室

            List<Result> secondDepartmentsData = secondDepartments.getData();
            secondDepartmentsDataList.addAll(secondDepartmentsData);

        }
        return secondDepartmentsDataList;
    }

    @RequestMapping(path = "/third/", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String querySchedules(HttpServletRequest req,
                                 @RequestParam(value = "departmentId", defaultValue = "5400") String departmentId,
                                 @RequestParam(value = "reservationTime", defaultValue = "2018-04-12") String reservationTime) throws
            ParseException {
        JSONRet ret = new JSONRet();
        Map<String, String> map = new HashMap<>();
        map.put("departmentId", departmentId);
        map.put("startTime", DateUtils.format(new Date(), "yyyy-MM-dd"));
        map.put("endTime", DateUtils.format(DateUtils.getIncreaseDay(new Date(), 10), "yyyy-MM-dd"));

        ResultReservations result = qingpuService.querySchedules(map);

        if (result != null && result.getCode() == 0) {
            if (result.getData().size() > 0) {
                // 处理后的排班数据
                ret.setData(getJSONSchedules(reservationTime, result.getData()));
            }
        }
        return JSonUtils.toJsonString(ret);
    }

    @RequestMapping(path = "/search/schedules/", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String searchSchedules(HttpServletRequest req,
                                  @RequestParam(value = "reservationTime", defaultValue = "2018-04-13") String reservationTime) throws
            ParseException {
        JSONRet ret = new JSONRet();
        List<Result> secondData = getSecond();
        List<ScheduleDTO> schedulesList = new ArrayList<>();
        List<Result> schedulesCollection = new ArrayList<>();
        for (Result r : secondData) {
            Map<String, String> map = new HashMap<>();
            map.put("departmentId", r.getDepartmentId());
            map.put("startTime", DateUtils.format(new Date(), "yyyy-MM-dd"));
            map.put("endTime", DateUtils.format(DateUtils.getIncreaseDay(new Date(), 10), "yyyy-MM-dd"));
            ResultReservations schedulesData = qingpuService.querySchedules(map); //获取二级科室下面排班表
            for(Result sd : schedulesData.getData()){
                ResultToMongo rtm = new ResultToMongo();
                dozerBeanMapper.map(sd, rtm);
                rtm.setDoctorName(rtm.getDoctorName().trim());
                rtm.setDoctorJobNumber(rtm.getDoctorJobNumber().trim());
                rtm.setHeadPortraitUrl((rtm.getHeadPortraitUrl().trim()));
                qingpuService.save(rtm);
                schedulesCollection.add(sd);
            }


//            if (schedulesData != null && schedulesData.getCode() == 0) {
//                if (schedulesData.getData().size() > 0) {
//                    // 处理后的排班数据
//                    List<ScheduleDTO> schedulesDTO = getJSONSchedules(reservationTime, schedulesData.getData());
//                    schedulesList.addAll(schedulesDTO);
//                }
//            }

        }
        ret.setData(schedulesCollection);
        return JSonUtils.toJsonString(ret);
    }



    /**
     * 处理排班数据格式
     *
     * @param reservationTime 医生身份证号
     * @param results         排班数据
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("rawtypes")
    private List<ScheduleDTO> getJSONSchedules(String reservationTime, List<Result> results)
            throws ParseException {
        //排序
        ComparatorResultUtil crUtil = new ComparatorResultUtil();
        //在这里进行排序(具体实现看源代码)
        Collections.sort(results, crUtil);

        // 获取接条件入参时间内的排班数据
        List<Result> timeDatas = new ArrayList<>();
        // 获取去重后的医生信息
        Map<String, ScheduleDTO> mapDoctor = new LinkedHashMap<>();
        for (Result timeResult : results) {
            if (reservationTime.equals(timeResult.getScheduleTime())) {
                timeDatas.add(timeResult);
                ScheduleDTO docInfo = new ScheduleDTO();
                docInfo.setDoctorId(timeResult.getDoctorId());
                if (StringUtils.isBlank(timeResult.getDoctorJobNumber())) {
                    docInfo.setDoctorJobNumber("");
                } else {
                    docInfo.setDoctorJobNumber(timeResult.getDoctorJobNumber().trim());
                }
                docInfo.setRealname(timeResult.getDoctorName());
                docInfo.setDoctorIdCard(timeResult.getIdCard());
                docInfo.setTitleType(timeResult.getDepartmentName());
                docInfo.setJobTitle(timeResult.getJobTitle());
                docInfo.setBeGoodAt(timeResult.getBeGoodAt());
                docInfo.setPortrait(timeResult.getHeadPortraitUrl());
                mapDoctor.put(docInfo.getDoctorJobNumber(), docInfo);// map去重获取医生列表(key:医生工号[唯一] value 医生信息)
            }
        }
        // 排班数据处理后返回结果
        List<ScheduleDTO> data = new ArrayList<>();
        for (Map.Entry entry : mapDoctor.entrySet()) {
            ScheduleDTO schedule = new ScheduleDTO();
            schedule = (ScheduleDTO) entry.getValue();
            schedule.setSources(getAmpmToSchedule((String) entry.getKey(), timeDatas));
            data.add(schedule);
        }
        return data;
    }

    /**
     * 封装时刻数据 上午下午 全天
     *
     * @param doctorJobNumber 医生身份证号
     * @param results         排班数据
     * @return
     * @throws ParseException
     */
    private List<SourceDTO> getAmpmToSchedule(String doctorJobNumber, List<Result> results)
            throws ParseException {
        // 获取入参时间的排班数据
        List<SourceDTO> sources = new ArrayList<>();
        for (Result result : results) {
            if (StringUtils.isBlank(result.getDoctorJobNumber())) {
                result.setDoctorJobNumber("");
            } else {
                result.setDoctorJobNumber(result.getDoctorJobNumber().trim());
            }
            if (doctorJobNumber.equals(result.getDoctorJobNumber())) {
                SourceDTO dto = new SourceDTO();
                dto.setSourceId(result.getSourceId());
                if (result.getScheduleTime() != null) {
                    dto.setScheduleTime(DateUtils.toDate(result.getScheduleTime(), "yyyy-MM-dd").getTime());
                }
                dto.setDayPart("".equals(result.getDayPart()) ? "ad" : result.getDayPart());
                dto.setDayPartName(getName(result.getDayPart()));
                if (StringUtils.isBlank(result.getDoctorName())) {
                    dto.setOutpatientType("普通门诊");
                } else {
                    dto.setOutpatientType("专家门诊");
                }
                sources.add(dto);
            }
        }
        return sources;
    }

    private String getName(String dayPart) {
        if ("am".equals(dayPart)) {
            return "上午";
        } else if ("pm".equals(dayPart)) {
            return "下午";
        } else {
            return "全天";
        }
    }


}
