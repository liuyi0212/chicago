package com.medishare.chicago.view;

import com.medishare.chicago.constant.HaoTianConstants;
import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSonUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(path = "/get/measured/data/", method = {RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    public String getMeasuredDataService(HttpServletRequest req,
                                         @RequestParam(value = "departmentId", defaultValue = "03") String departmentId) {
        JSONRet ret = new JSONRet();

        return JSonUtils.toJsonString(ret);
    }

    public static void main(String[] args) {

//        String appId = "appid=20180420134924815651";
//        String timestamp = "timestamp=" + String.valueOf(System.currentTimeMillis());
//        String sign = "sign=A3FC76845D75EF3A7402C8258EF41E6B";
//        String startdate = "startdate=2018-06-01";
//        String enddate = "enddate=2018-06-15";
//        String type = "type=" + HaoTianConstants.HAOTIAN_TYPE_XUEYA;

        String key = "&key=7ECB532ABF712213D77A5213A317FB29";
        Map<String, String> paraMap = new HashMap<>(20);
        paraMap.put("appid", "20180420134924815651");
        paraMap.put("timestamp", "1529485575034");
        paraMap.put("startdate", "2018-06-20");
        paraMap.put("enddate", "2018-06-22");
        paraMap.put("type", HaoTianConstants.HAOTIAN_TYPE_XUEYA);
//        paraMap.put("type", HaoTianConstants.HAOTIAN_TYPE_MAIBO);
//        paraMap.put("type", HaoTianConstants.HAOTIAN_TYPE_XUETANG);
//        paraMap.put("type", HaoTianConstants.HAOTIAN_TYPE_XUEYANG);

        String stringA = formatUrlMap(paraMap, true, false);
        String stringSignTemp = sign(stringA, key, null);
        System.out.println(stringSignTemp.toUpperCase());
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
