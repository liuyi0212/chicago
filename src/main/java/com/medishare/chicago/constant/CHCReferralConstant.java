package com.medishare.chicago.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxg on 8/22/17.
 * 
 * gp 全科医生    chc 呼叫中心    sp 专科医生
 */
public class CHCReferralConstant {
  
  //业务类型
  final public static String BUSINESS_PROCESS_CHC = "0"; //chc业务流程 (例如 杨浦转诊)
  final public static String BUSINESS_PROCESS_HIS = "1"; //his业务流程 (例如 青浦预约)
  
  //状态  

  final public static String CREATE = "CREATE"; //创建转诊   gp

  final public static String CONFIRM= "CONFIRM"; //确认转诊    gp

  final public static String REVIEW = "REVIEW";  //审核转诊  chc

  final public static String TREATMENT = "TREATMENT";  //(患者)就诊  chc

  final public static String COMPLETE = "COMPLETE";  //(患者)确诊-完成转诊   sp

  final public static String CANCEL = "CANCEL";  //取消转诊   chc
  
  final public static String DELETE = "DELETE";  //删除转诊   gp
  
  final public static String FAIL = "FAIL"; //已失效  his流程(青浦) 新增的状态
  
  
  //===============================================
  public static final String TO_HIS_NO = "0";  //转诊流程是否走医院的his系统 
  public static final String TO_HIS_YES = "1";  //转诊流程是否走医院的his系统 

  
  public static final String CHC_TYPE_WJW = "0";  //卫计委
  public static final String CHC_TYPE_GP = "1";  //社区
  public static final String CHC_TYPE_SP = "2";  //医院

  
  /**
   * status1状态
   */
  public static Map<Integer, String> REFERRAL_STATUS_1 = new HashMap<Integer, String>();
  /**
   * status2状态
   */
  public static Map<String, Integer> REFERRAL_STATUS_2 = new HashMap<String, Integer>();
  /**
   * gp业务状态
   */
  public static Map<Integer, String> REFERRAL_STATUS_GP = new HashMap<Integer, String>();
  /**
   * gp业务状态
   */
  public static Map<Integer, String> REFERRAL_STATUS_GP_HIS = new HashMap<Integer, String>();
  /**
   * chc业务装
   */
  public static Map<Integer, String> REFERRAL_STATUS_CHC = new HashMap<Integer, String>();
  /**
   * sp业务状态
   */
  public static Map<Integer, String> REFERRAL_STATUS_SP = new HashMap<Integer, String>();
  
  /**
   * pat业务状态
   */
  public static Map<Integer, String> REFERRAL_STATUS_PAT = new HashMap<Integer, String>();

  

  static {
      REFERRAL_STATUS_1.put(0, "CREATE");
      REFERRAL_STATUS_1.put(1, "CONFIRM");
      REFERRAL_STATUS_1.put(2, "REVIEW");
      REFERRAL_STATUS_1.put(3, "TREATMENT");
      REFERRAL_STATUS_1.put(4, "COMPLETE");
      REFERRAL_STATUS_1.put(5, "CANCEL");
      REFERRAL_STATUS_1.put(6, "FAIL");
      
      REFERRAL_STATUS_2.put("CREATE", 0);
      REFERRAL_STATUS_2.put("CONFIRM", 1);
      REFERRAL_STATUS_2.put("REVIEW", 2);
      REFERRAL_STATUS_2.put("TREATMENT", 3);
      REFERRAL_STATUS_2.put("COMPLETE", 4);
      REFERRAL_STATUS_2.put("CANCEL", 5);
      REFERRAL_STATUS_2.put("FAIL", 6);
      
    
      REFERRAL_STATUS_GP.put(0, "待转诊");
      REFERRAL_STATUS_GP.put(1, "待审核");
      REFERRAL_STATUS_GP.put(2, "待完成");
      REFERRAL_STATUS_GP.put(3, "待完成");
      REFERRAL_STATUS_GP.put(4, "已完成");
      REFERRAL_STATUS_GP.put(5, "已取消");
      REFERRAL_STATUS_GP.put(6, "已失效");
      
      REFERRAL_STATUS_GP_HIS.put(0, "待转诊");
      REFERRAL_STATUS_GP_HIS.put(1, "待就诊");
      REFERRAL_STATUS_GP_HIS.put(3, "待就诊");
      REFERRAL_STATUS_GP_HIS.put(4, "已完成");
      REFERRAL_STATUS_GP_HIS.put(6, "已失效");

      REFERRAL_STATUS_CHC.put(1, "待审核");
      REFERRAL_STATUS_CHC.put(2, "待就医");
      REFERRAL_STATUS_CHC.put(3, "待确诊");
      REFERRAL_STATUS_CHC.put(4, "已完成");
      REFERRAL_STATUS_CHC.put(5, "已取消");
      
      REFERRAL_STATUS_SP.put(3, "待就医");
      REFERRAL_STATUS_SP.put(4, "已完成");

      REFERRAL_STATUS_PAT.put(2, "待就医");
     
      
  }

  public static String getStatus1(Integer status) {
      return REFERRAL_STATUS_1.get(status);
  }
  
  public static Integer getStatus2(String status) {
    return REFERRAL_STATUS_2.get(status);
}
  
  public static String getStatusName(String platform,Integer status,String type) {
      if ("pat".equals(platform)) {
        return REFERRAL_STATUS_PAT.get(status);
      } else if ("gp".equals(platform) && "his".equals(type)) {
        return REFERRAL_STATUS_GP_HIS.get(status);
      } else if ("gp".equals(platform) && "chc".equals(type)) {
        return REFERRAL_STATUS_GP.get(status);
      
      } else if ("sp".equals(platform)) {
        return REFERRAL_STATUS_SP.get(status);
      
      } else if ("chc".equals(platform)) {
        return REFERRAL_STATUS_CHC.get(status);
        
      }
      return null;
  }
}
