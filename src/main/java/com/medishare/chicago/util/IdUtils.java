package com.medishare.chicago.util;

import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.member.Patient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liuy
 * @date: 2018/8/2
 * @time: 上午9:47
 * @descripttion: com.medishare.chicago.util
 */
public class IdUtils {
    static Logger log = LoggerFactory.getLogger(IdUtils.class);
    /**
     * 米喜虚拟用户
     */
    public final static String MEDISHARE_USER_ID = "1132";


    /**
     * 获取member id type
     * @param memberId
     * @return
     */
    public static String getMemberIdType(String memberId) {
        return StringUtils.substringBefore(memberId, "_");
    }

    /**
     * 判断是否是医生id
     * @param memberId
     * @return
     */
    public static boolean isDoctorId(String memberId) {
        return StringUtils.equals(Doctor.class.getName(), getMemberIdType(memberId));
    }

//    /**
//     * 判断是否是CHC id. 参照isDoctorId().
//     * @param memberId
//     * @return
//     */
//    public static boolean isCHCId(String memberId) {
//        return StringUtils.equals(CHC.class.getName(), getMemberIdType(memberId));
//    }


    /**
     * 判断是否是病人id
     * @param memberId
     * @return
     */
    public static boolean isPatientId(String memberId) {
        return StringUtils.equals(Patient.class.getName(), getMemberIdType(memberId));
    }

    /**
     * 病人id转memberid
     * @param patientId
     * @return
     */
    public static String patientId2MemberId(String patientId) {
        return Patient.class.getName() + "_" + patientId;
    }

    /**
     * memberid转病人id
     * @param memberId
     * @return
     */
    public static String memberId2PatientId(String memberId) {
        if (!isPatientId(memberId)) {
            log.error("is not patient id : " + memberId);
            return "";
        }
        return StringUtils.substringAfterLast(memberId, "_");
    }

    /**
     * 医生id转memberid
     * @param doctorId
     * @return
     */
    public static String doctorId2MemberId(String doctorId) {
        return Doctor.class.getName() + "_" + doctorId;
    }

    /**
     * memberid转医生id
     * @param memberId
     * @return
     */
    public static String memberId2DoctorId(String memberId) {
        if (!isDoctorId(memberId)) {
            log.error("is not doctor id : " + memberId);
            return "";
        }
        return StringUtils.substringAfterLast(memberId, "_");
    }

//    /**
//     * chcid转memberid
//     * @param doctorId
//     * @return
//     */
//    public static String chcId2MemberId(String chcId) {
//        return CHC.class.getName() + "_" + chcId;
//    }

//    /**
//     * memberid转chcid
//     * @param memberId
//     * @return
//     */
//    public static String memberId2CHCId(String memberId) {
//        if (!isCHCId(memberId)) {
//            log.error("is not chc id : " + memberId);
//            return "";
//        }
//        return StringUtils.substringAfterLast(memberId, "_");
//    }


    /**
     * 生成聊天session id
     * @param a
     * @param b
     * @return
     */
    public static String mkSessionId(String a, String b) {
        if (idorder(a,b)) {
            return a + "_" + b;
        }

        return b + "_" + a;
    }
    public static String[] sessionId2memberIds(String sessionId) {
        if(StringUtils.isEmpty(sessionId) || !sessionId.contains("_")){
            return null;
        }
        int i = sessionId.indexOf("_",sessionId.indexOf("_")+1);
        String memberA=sessionId.substring(0, i);
        String memberB=sessionId.substring(i+1);
        return new String[]{memberA,memberB};
    }
    /**
     * 获取另一个人的memberId
     * @param sessionId
     * @param a
     * @return
     */
    public static String sessionId2otherMemberId(String sessionId,String a) {
        String[] mems = sessionId2memberIds(sessionId);
        if(mems != null && mems.length == 2){
            if(StringUtils.equals(a, mems[0])){
                return mems[1];
            }else{
                return mems[0];
            }
        }
        return null;
    }

    public static boolean idorder(String a, String b) {
        return a.compareTo(b) > 0;
    }

    public static String extractOrderId(String session_id) {
        String id = StringUtils.substringBefore(session_id, "_");
        if (id == null || id.isEmpty() || StringUtils.startsWith(id, "com")) {
            return null;
        }

        return id;
    }
    /**
     * 米喜虚拟用户
     * @return
     */
    public static String getMedishareUserId() {

        return MEDISHARE_USER_ID;
    }
}
