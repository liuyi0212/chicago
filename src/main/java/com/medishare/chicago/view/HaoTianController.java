package com.medishare.chicago.view;

import com.medishare.chicago.service.SysFriendService;
import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSonUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author: liuy
 * @date: 2018/6/20
 * @time: 下午4:13
 * @descripttion: com.medishare.chicago.view
 */
@Controller
public class HaoTianController {

//    @RequestMapping(path = "/get/measurement/data/", method = {RequestMethod.GET},
//            produces = "application/json; charset=utf-8")
//    public String getMeasurementDataService(HttpServletRequest req,
//                                         @RequestParam(value = "departmentId", defaultValue = "03") String departmentId) {
//        JSONRet ret = new JSONRet();
//
//        return JSonUtils.toJsonString(ret);
//    }

    @Autowired
    SysFriendService sysFriendService;

    @ResponseBody
    @RequestMapping(path = "/get/haotian/person", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String getPerson(HttpServletRequest req,
                                @RequestParam(value = "realname") String realname,
                                @RequestParam(value = "starttime", defaultValue = "1991", required = false) String starttime,
                                @RequestParam(value = "endtime", defaultValue = "03", required = false) String endtime) {
        JSONRet ret = new JSONRet();
//        sysFriendService.searchSignApplyAndUpdate();
        sysFriendService.doctorTeamFindAndUpdate(null,null);
        return JSonUtils.toJsonString(ret);
    }

    @ResponseBody
    @RequestMapping(path = "/get/haotian/person/info/", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String getPersonInfo(HttpServletRequest req,
                                @RequestParam(value = "realname") String realname,
                                @RequestParam(value = "starttime", defaultValue = "1991", required = false) String starttime,
                                @RequestParam(value = "endtime", defaultValue = "03", required = false) String endtime) {
        JSONRet ret = new JSONRet();
        Map<String, Object> map = new HashMap<>();

        Map<String, String> personBloodMap = new HashMap<>();
        personBloodMap.put("name","warning");
        personBloodMap.put("text","偏高");

        Map<String, Object> personMap = new HashMap<>();
        personMap.put("realname","8bit");
        personMap.put("age","60");
        personMap.put("gender","男");
        personMap.put("blood","A");
        personMap.put("BMI","24.3");
        personMap.put("personalStatus","偏高");
        personMap.put("bloodStatus", personBloodMap);

        List<Object> tips = new ArrayList<>();
        Map<String, String> exerciseAdviceMap = new HashMap<>();
        exerciseAdviceMap.put("img","");
        exerciseAdviceMap.put("title","运动建议");
        exerciseAdviceMap.put("advice","不听老人言吃亏在眼前。");
        Map<String, String> dietaryAdviceMap = new HashMap<>();
        dietaryAdviceMap.put("img","");
        dietaryAdviceMap.put("title","膳食建议");
        dietaryAdviceMap.put("advice","不听老人言吃亏在眼前。");
        Map<String, String> doctorAdviceMap = new HashMap<>();
        doctorAdviceMap.put("img","");
        doctorAdviceMap.put("title","医生建议");
        doctorAdviceMap.put("advice","不听老人言吃亏在眼前。");
        tips.add(exerciseAdviceMap);
        tips.add(dietaryAdviceMap);
        tips.add(doctorAdviceMap);


        List<Object> list = new ArrayList<>();


        Map<String, Object> mbData1 = new HashMap<>();
        mbData1.put("date", "2018/06/30");
        mbData1.put("systolicPressure", 100);
        mbData1.put("diastolicPressure", 100);
        mbData1.put("pulsePressure", 100);
        mbData1.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData2 = new HashMap<>();
        mbData2.put("date", "2018/06/29");
        mbData2.put("systolicPressure", 100);
        mbData2.put("diastolicPressure", 100);
        mbData2.put("pulsePressure", 100);
        mbData2.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData3 = new HashMap<>();
        mbData3.put("date", "2018/06/28");
        mbData3.put("systolicPressure", 100);
        mbData3.put("diastolicPressure", 100);
        mbData3.put("pulsePressure", 27);
        mbData3.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData4 = new HashMap<>();
        mbData4.put("date", "2018/06/26");
        mbData4.put("systolicPressure", 100);
        mbData4.put("diastolicPressure", 100);
        mbData4.put("pulsePressure", 100);
        mbData4.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData5 = new HashMap<>();
        mbData5.put("date", "2018/06/25");
        mbData5.put("systolicPressure", 100);
        mbData5.put("diastolicPressure", 100);
        mbData5.put("pulsePressure", 100);
        mbData5.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData6 = new HashMap<>();
        mbData6.put("date", "2018/06/24");
        mbData6.put("systolicPressure", 100);
        mbData6.put("diastolicPressure", 100);
        mbData6.put("pulsePressure", 100);
        mbData6.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData7 = new HashMap<>();
        mbData7.put("date", "2018/06/23");
        mbData7.put("systolicPressure", 100);
        mbData7.put("diastolicPressure", 100);
        mbData7.put("pulsePressure", 100);
        mbData7.put("tip", "危险");
        mbData1.put("advice", tips);
        list.add(mbData1);
        list.add(mbData2);
        list.add(mbData3);
        list.add(mbData4);
        list.add(mbData5);
        list.add(mbData6);
        list.add(mbData7);



        List<Object> servicePackage = new ArrayList<>();
        Map<String, String> tuwenMap = new HashMap<>();
        tuwenMap.put("title","图文咨询");
        tuwenMap.put("content","不听老人言吃亏在眼前。");
        tuwenMap.put("serviceTime","咨询时长：30分钟");
        tuwenMap.put("borderColor","#CD3278");
        Map<String, String> dianhuaMap = new HashMap<>();
        dianhuaMap.put("title","图文咨询");
        dianhuaMap.put("content","不听老人言吃亏在眼前。");
        dianhuaMap.put("serviceTime","咨询时长：30分钟");
        dianhuaMap.put("borderColor","#5CACEE");
        Map<String, String> shangmenMap = new HashMap<>();
        shangmenMap.put("title","图文咨询");
        shangmenMap.put("content","不听老人言吃亏在眼前。");
        shangmenMap.put("serviceTime","咨询时长：30分钟");
        shangmenMap.put("borderColor","#FFC125");
        servicePackage.add(tuwenMap);
        servicePackage.add(dianhuaMap);
        servicePackage.add(shangmenMap);



        map.put("person", personMap);
        map.put("measurementData", list);
        map.put("servicePackage", servicePackage);

        ret.setData(map);
        return JSonUtils.toJsonString(ret);
    }

    @ResponseBody
    @RequestMapping(path = "/get/measurement/data/", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String getMeasurement(HttpServletRequest req,
                                         @RequestParam(value = "realname", required = false) String realname) {
        JSONRet ret = new JSONRet();
        Map<String, Object> map = new HashMap<>();
        List<Object> tips = new ArrayList<>();
        Map<String, String> exerciseAdviceMap = new HashMap<>();
        exerciseAdviceMap.put("img","");
        exerciseAdviceMap.put("title","运动建议");
        exerciseAdviceMap.put("advice","不听老人言吃亏在眼前。");
        Map<String, String> dietaryAdviceMap = new HashMap<>();
        dietaryAdviceMap.put("img","");
        dietaryAdviceMap.put("title","膳食建议");
        dietaryAdviceMap.put("advice","不听老人言吃亏在眼前。");
        Map<String, String> doctorAdviceMap = new HashMap<>();
        doctorAdviceMap.put("img","");
        doctorAdviceMap.put("title","医生建议");
        doctorAdviceMap.put("advice","不听老人言吃亏在眼前。");
        tips.add(exerciseAdviceMap);
        tips.add(dietaryAdviceMap);
        tips.add(doctorAdviceMap);


        List<Object> list = new ArrayList<>();


        Map<String, Object> mbData1 = new HashMap<>();
        mbData1.put("date", "2018/06/30");
        mbData1.put("systolicPressure", 100);
        mbData1.put("diastolicPressure", 100);
        mbData1.put("pulsePressure", 100);
        mbData1.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData2 = new HashMap<>();
        mbData2.put("date", "2018/06/29");
        mbData2.put("systolicPressure", 100);
        mbData2.put("diastolicPressure", 100);
        mbData2.put("pulsePressure", 100);
        mbData2.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData3 = new HashMap<>();
        mbData3.put("date", "2018/06/28");
        mbData3.put("systolicPressure", 100);
        mbData3.put("diastolicPressure", 100);
        mbData3.put("pulsePressure", 27);
        mbData3.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData4 = new HashMap<>();
        mbData4.put("date", "2018/06/26");
        mbData4.put("systolicPressure", 100);
        mbData4.put("diastolicPressure", 100);
        mbData4.put("pulsePressure", 100);
        mbData4.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData5 = new HashMap<>();
        mbData5.put("date", "2018/06/25");
        mbData5.put("systolicPressure", 100);
        mbData5.put("diastolicPressure", 100);
        mbData5.put("pulsePressure", 100);
        mbData5.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData6 = new HashMap<>();
        mbData6.put("date", "2018/06/24");
        mbData6.put("systolicPressure", 100);
        mbData6.put("diastolicPressure", 100);
        mbData6.put("pulsePressure", 100);
        mbData6.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData7 = new HashMap<>();
        mbData7.put("date", "2018/06/23");
        mbData7.put("systolicPressure", 100);
        mbData7.put("diastolicPressure", 100);
        mbData7.put("pulsePressure", 100);
        mbData7.put("tip", "危险");
        mbData1.put("advice", tips);
        list.add(mbData1);
        list.add(mbData2);
        list.add(mbData3);
        list.add(mbData4);
        list.add(mbData5);
        list.add(mbData6);
        list.add(mbData7);

        map.put("metricData", list);
        ret.setData(map);
        return JSonUtils.toJsonString(ret);
    }

//    public static void main(String[] args) {
//
////        String appId = "appid=20180420134924815651";
////        String timestamp = "timestamp=" + String.valueOf(System.currentTimeMillis());
////        String sign = "sign=A3FC76845D75EF3A7402C8258EF41E6B";
////        String startdate = "startdate=2018-06-01";
////        String enddate = "enddate=2018-06-15";
////        String type = "type=" + HaoTianConstants.HAOTIAN_TYPE_XUEYA;
//
//        String key = "&key=7ECB532ABF712213D77A5213A317FB29";
//        Map<String, String> paraMap = new HashMap<>(20);
//        paraMap.put("appid", "20180420134924815651");
//        paraMap.put("timestamp", "1529485575034");
//        paraMap.put("startdate", "2018-06-20");
//        paraMap.put("enddate", "2018-06-22");
//        paraMap.put("type", HaoTianConstants.HAOTIAN_TYPE_XUEYA);
////        paraMap.put("type", HaoTianConstants.HAOTIAN_TYPE_MAIBO);
////        paraMap.put("type", HaoTianConstants.HAOTIAN_TYPE_XUETANG);
////        paraMap.put("type", HaoTianConstants.HAOTIAN_TYPE_XUEYANG);
//
//        String stringA = formatUrlMap(paraMap, true, false);
//        String stringSignTemp = sign(stringA, key, null);
//        System.out.println(stringSignTemp.toUpperCase());
//    }



    public static void main(String[] args) {

        JSONRet ret = new JSONRet();
        Map<String, Object> map = new HashMap<>();


        Map<String, String> personMap = new HashMap<>();
        personMap.put("realname","8bit");
        personMap.put("age","60");
        personMap.put("gender","男");
        personMap.put("blood","A");
        personMap.put("BMI","24.3");
        personMap.put("personalStatus","偏高");

        List<Object> tips = new ArrayList<>();
        Map<String, String> exerciseAdviceMap = new HashMap<>();
        exerciseAdviceMap.put("img","");
        exerciseAdviceMap.put("title","运动建议");
        exerciseAdviceMap.put("advice","不听老人言吃亏在眼前。");
        Map<String, String> dietaryAdviceMap = new HashMap<>();
        dietaryAdviceMap.put("img","");
        dietaryAdviceMap.put("title","膳食建议");
        dietaryAdviceMap.put("advice","不听老人言吃亏在眼前。");
        Map<String, String> doctorAdviceMap = new HashMap<>();
        doctorAdviceMap.put("img","");
        doctorAdviceMap.put("title","医生建议");
        doctorAdviceMap.put("advice","不听老人言吃亏在眼前。");
        tips.add(exerciseAdviceMap);
        tips.add(dietaryAdviceMap);
        tips.add(doctorAdviceMap);


        List<Object> list = new ArrayList<>();


        Map<String, Object> mbData1 = new HashMap<>();
        mbData1.put("date", "2018/06/30");
        mbData1.put("systolicPressure", "100");
        mbData1.put("diastolicPressure", "100");
        mbData1.put("pulsePressure", "100");
        mbData1.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData2 = new HashMap<>();
        mbData2.put("date", "2018/06/29");
        mbData2.put("systolicPressure", "100");
        mbData2.put("diastolicPressure", "100");
        mbData2.put("pulsePressure", "100");
        mbData2.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData3 = new HashMap<>();
        mbData3.put("date", "2018/06/28");
        mbData3.put("systolicPressure", "100");
        mbData3.put("diastolicPressure", "100");
        mbData3.put("pulsePressure", "27");
        mbData3.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData4 = new HashMap<>();
        mbData4.put("date", "2018/06/26");
        mbData4.put("systolicPressure", "100");
        mbData4.put("diastolicPressure", "100");
        mbData4.put("pulsePressure", "100");
        mbData4.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData5 = new HashMap<>();
        mbData5.put("date", "2018/06/25");
        mbData5.put("systolicPressure", "100");
        mbData5.put("diastolicPressure", "100");
        mbData5.put("pulsePressure", "100");
        mbData5.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData6 = new HashMap<>();
        mbData6.put("date", "2018/06/24");
        mbData6.put("systolicPressure", "100");
        mbData6.put("diastolicPressure", "100");
        mbData6.put("pulsePressure", "100");
        mbData6.put("tip", "危险");
        mbData1.put("advice", tips);
        Map<String, Object> mbData7 = new HashMap<>();
        mbData7.put("date", "2018/06/23");
        mbData7.put("systolicPressure", "100");
        mbData7.put("diastolicPressure", "100");
        mbData7.put("pulsePressure", "100");
        mbData7.put("tip", "危险");
        mbData1.put("advice", tips);
        list.add(mbData1);
        list.add(mbData2);
        list.add(mbData3);
        list.add(mbData4);
        list.add(mbData5);
        list.add(mbData6);
        list.add(mbData7);



        List<Object> servicePackage = new ArrayList<>();
        Map<String, String> tuwenMap = new HashMap<>();
        tuwenMap.put("title","图文咨询");
        tuwenMap.put("content","不听老人言吃亏在眼前。");
        tuwenMap.put("serviceTime","咨询时长：30分钟");
        tuwenMap.put("borderColor","#CD3278");
        Map<String, String> dianhuaMap = new HashMap<>();
        dianhuaMap.put("title","图文咨询");
        dianhuaMap.put("content","不听老人言吃亏在眼前。");
        dianhuaMap.put("serviceTime","咨询时长：30分钟");
        dianhuaMap.put("borderColor","#5CACEE");
        Map<String, String> shangmenMap = new HashMap<>();
        shangmenMap.put("title","图文咨询");
        shangmenMap.put("content","不听老人言吃亏在眼前。");
        shangmenMap.put("serviceTime","咨询时长：30分钟");
        shangmenMap.put("borderColor","#FFC125");
        servicePackage.add(tuwenMap);
        servicePackage.add(dianhuaMap);
        servicePackage.add(shangmenMap);



        map.put("person", personMap);
        map.put("metricData", list);
        map.put("servicePackage", servicePackage);


        ret.setData(map);
        System.out.println(JSonUtils.toJsonString(ret));
    }
    /**
     * 签名字符串
     *
     * @param text          需要签名的字符串
     * @param key           密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String input_charset) {
        text = text + key;
        System.out.println("sign text + key:" + text);
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws java.security.SignatureException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    /**
     * 方法用途: 对所有传入参数按照字段名的Unicode码从小到大排序（字典序），并且生成url参数串<br>
     * 实现步骤: <br>
     *
     * @param paraMap    要排序的Map对象
     * @param urlEncode  是否需要URLENCODE
     * @param keyToLower 是否需要将Key转换为全小写
     *                   true:key转化成小写，false:不转化
     * @return
     */
    public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
        String buff;
        Map<String, String> tmpMap = paraMap;
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlEncode) {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    if (keyToLower) {
                        buf.append(key.toLowerCase() + "=" + val);
                    } else {
                        buf.append(key + "=" + val);
                    }
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false) {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e) {
            return null;
        }
        return buff;
    }

}
