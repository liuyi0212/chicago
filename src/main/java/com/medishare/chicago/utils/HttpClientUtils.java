package com.medishare.chicago.utils;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 请求
 *
 * @author lxg */
public class HttpClientUtils {

  static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);


  /** 向指定URL发送GET方法的请求
   *
   * @param url 发送请求的URL
   * @param param
   * @return URL 所代表远程资源的响应结果 */
  @SuppressWarnings("rawtypes")
  public static String sendGet(String url, Map<String, String> map) {
    String result = null;
    BufferedReader in = null;
    try {
      StringBuffer sb = new StringBuffer();
      sb.append(url);
      for (Map.Entry entry : map.entrySet()) {
        sb.append("<");
        sb.append(entry.getKey());
        sb.append(">");
        //需要对参数进行去空格处理 否则 connection.getInputStream() 会抛出异常
        sb.append(entry.getValue() !=null ? entry.getValue().toString().trim():entry.getValue());
        sb.append("</");
        sb.append(entry.getKey());
        sb.append(">");
      }
      String urlNameString = sb.toString();
      URL realUrl = new URL(urlNameString);
      // 打开和URL之间的连接
      URLConnection connection = realUrl.openConnection();
      // 设置通用的请求属性
      connection.setRequestProperty("accept", "*/*");
      connection.setRequestProperty("connection", "Keep-Alive");
      connection.setRequestProperty("user-agent",
          "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
      // 建立实际的连接
      connection.connect();
      // 定义 BufferedReader输入流来读取URL的响应
      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = in.readLine()) != null) {
        result += line;
      }
    } catch (Exception ex) {
      log.error("发送get请求出现异常！url=" + url + "|" + ex);
      ex.printStackTrace();
      return "{\"code\":2,\"errMsg\":\"his接口访问异常\"}";
    }
    // 使用finally块来关闭输入流
    finally {
      try {
        if (in != null) {
          in.close();
        }
      } catch (Exception e2) {
        log.error("流close异常！url=" + url + "|" + e2);
        e2.printStackTrace();
        return "{\"code\":2,\"errMsg\":\"his接口访问流close异常\"}";
      }
    }
    if (result == null) {
      return "{\"code\":2,\"errMsg\":\"his返回值为空\"}";
    }
    //正则处理xml数据
    Pattern p = Pattern.compile("\">(.*)</string>");
    Matcher m = p.matcher(result);//
    String action = "{\"code\":2,\"errMsg\":\"his返回值解析异常\"}";
    if (m.find()) {
      action = m.group(1);
    }
    return action;
  }

  /** post请求
   *
   * @param url url地址
   * @param string json字符串参数
   * @param noNeedResponse 不需要返回结果
   * @return */
  public static String sendPost(String url, Map<String, String> map) {
    String params = JSonUtils.toJsonString(map);
    String data = null;

    // post请求返回结果
    DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpPost method = new HttpPost(url);
    method.setHeader("Content-type", "application/json; charset=utf-8");
    try {
      if (null != params) {
        // 解决中文乱码问题
        StringEntity entity = new StringEntity(params, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        method.setEntity(entity);
      }
      HttpResponse result = httpClient.execute(method);
      url = URLDecoder.decode(url, "UTF-8");
      /** 请求发送成功，并得到响应 **/
      if (result.getStatusLine().getStatusCode() == 200) {
        /** 读取服务器返回过来的json字符串数据 **/
        data = EntityUtils.toString(result.getEntity());
      }
    } catch (Exception ex) {
      log.error("发送post请求出现异常！url=" + url + "|" + ex);
    }
    return data;
  }

  public static void main(String[] args) {
    // post请求
    Map<String, String> map = new HashMap<>();
    map.put("serviceId", "4");
    map.put("doctorId", "1832");
    map.put("description", "test");
    map.put("treatPeopleName", "哈哈");
    map.put("treatPeoplePhone", "18701939111");
    map.put("treatPeopleIDCard", "420624199212125835");
    map.put("treatPeopleAddress", "地址");
    // sendPost("http://192.168.10.212:8082/referral/addit/", map);

    // get请求
    Map<String, String> mapGet = new HashMap<>();
    mapGet.put("hospitalId", "01");
    String result =
    HttpClientUtils.sendGet("http://106.14.15.26:8060/ServiceYDYYJK.asmx/getOneLevelDepartmentsService?request=<hospitalId>01</hospitalId>", mapGet);
    System.out.println(result);


  }

}
