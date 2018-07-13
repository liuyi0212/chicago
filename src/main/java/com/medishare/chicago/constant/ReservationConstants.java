package com.medishare.chicago.constant;

/** Created by lxg on 2018/01/15. */
public class ReservationConstants {

  /**
   * 对接医院预约url地址
   */
  public static final String MDS_URL = "http://106.14.15.26:8060/ServiceYDYYJK.asmx";
  // 获取居民签约状态
  public static final String MDS_URL_RESIDENT_SIGN_STATUS = MDS_URL + "/getResidentSignStatusService?request=";
  // 获取医院列表
  public static final String MDS_URL_HOSPITAlS = MDS_URL + "/getHospitalsService?request=";
  // 获取一级科室列表
  public static final String MDS_URL_ONE_DEPARTMENTS = MDS_URL + "/getOneLevelDepartmentsService?request=";
  // 获取二级科室列表
  public static final String MDS_URL_TWO_DEPARTMENTS = MDS_URL + "/getTwoLevelDepartmentsService?request=";
  // 获取号源排班列表
  public static final String MDS_URL_SCHEDULE = MDS_URL + "/getSchedulesService?request=";
  // 提交预约
  public static final String MDS_URL_RESERVATION = MDS_URL + "/submitReservationService?request=";
  // 获取预约状态
  public static final String MDS_URL_RESERVATION_STATUS = MDS_URL + "/getReservationStatusService?request=";
  // 获取诊断信息
  public static final String MDS_URL_RESIDENT_DIAGNOSIS_INFO = MDS_URL + "/getResidentDiagnosisInfoService?request=";
  // 获取病人的入院状况 信息
  public static final String MDS_URL_RESIDENT_HOSPITAL_STROKE = MDS_URL + "/getResidentHospitalStrokeService?request=";
  // 取消预约
  public static final String MDS_URL_CANCELLING_CANCELLING_RESERVATIONSTATE = MDS_URL + "/cancellingReservationState?request=";


  // 已预约
  public static final String STATUS_HIS_CONFIRM = "0";

  // 已缴费
  public static final String STATUS_HIS_PAYMENT = "1";

  // 已取消
  public static final String STATUS_HIS_CANCEL = "2";
  
  // 已完成就诊
  public static final String STATUS_HIS_COMPLETE = "3";

  
  /** 通过his预约状态获取对应米喜转诊记录库中的状态
   * 
   * @param status
   * @return */
  public static Integer getMXStatus(String status) {
    if (STATUS_HIS_CONFIRM.equals(status)) {//已预约
      return CHCReferralConstant.getStatus2(CHCReferralConstant.CONFIRM);// 已确认
    } else if (STATUS_HIS_PAYMENT.equals(status)) {//已缴费
      return CHCReferralConstant.getStatus2(CHCReferralConstant.TREATMENT);// 已就诊
    } else if (STATUS_HIS_CANCEL.equals(status)) {//已取消
      return CHCReferralConstant.getStatus2(CHCReferralConstant.CANCEL);// 已取消
    } else if (STATUS_HIS_COMPLETE.equals(status)) {//已完成就诊
      return CHCReferralConstant.getStatus2(CHCReferralConstant.COMPLETE);// 已完成
    }
    return null;
  }
}
