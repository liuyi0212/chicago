package com.medishare.chicago.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liuy
 * @date: 2018/6/22
 * @time: 下午6:53
 * @descripttion: com.medishare.manis.constant
 * 新建好友表（系统之前签约关系需要刷数据）
 * C端：新朋友、群聊、我的医生、好友名单
 * D端：新朋友、群聊、我的病人、我的团队、好友名单
 * SP端：新朋友、群聊、我服务的医生、好友名单
 * BA_MA端：新朋友、群聊、我服务的医生、好友名单
 * CHC端：暂无
 */
public class ChatConstant {
    /**
     * 患者通讯录
     */
    public static Map<String, String> C_CHAT_CONSTANT = new HashMap<>();
    /**
     * 医生通讯录
     */
    public static Map<String, String> D_CHAT_CONSTANT = new HashMap<>();
    /**
     * 专科护士通讯录
     */
    public static Map<String, String> SP_CHAT_CONSTANT = new HashMap<>();
    /**
     * BA_MA通讯录
     */
    public static Map<String, String> BA_MA_CHAT_CONSTANT = new HashMap<>();

    public static Map<String, String> NEW_FRIENDS = new HashMap<>();
    public static Map<String, String> GROUP_CHAT = new HashMap<>();
    public static Map<String, String> MY_DOCTOR = new HashMap<>();
    public static Map<String, String> DOCTOR_TEAM = new HashMap<>();
    public static Map<String, String> MEDICAL_MAN = new HashMap<>();
    public static Map<String, String> MY_PATIENT = new HashMap<>();

    public static String C = "PATIENT";
    public static String D = "DOCTOR";
    public static String SP = "SP";
    public static String BA_MA = "BA_MA";

    public static String RELATION_SHIP_ON = "on";
    public static String RELATION_SHIP_APPLY = "apply";
    public static String RELATION_SHIP_BREAK = "break";
    public static String RELATION_SHIP_TIMEOUT = "timeout";

    private static String NEW_FRIENDS_TITLE = "新的朋友";
    private static String NEW_FRIENDS_ICON = "https://upyun.thedoc.cn/img/9d28f892-8f73-4a82-a629-1f040e45b594.png";
    private static String NEW_FRIENDS_ROUTER = "router://friendApplyList";
    private static String NEW_FRIENDS_NUM = "新的朋友";

    private static String GROUP_CHAT_TITLE = "群聊";
    private static String GROUP_CHAT_ICON = "https://upyun.thedoc.cn/img/7cff5b7a-d47d-45bf-855d-0b05e8315942.png";
    private static String GROUP_CHAT_ROUTER = "router://hybridWebView?url=/matrix/homepage.html#/group/chat/list";

    private static String MY_DOCTOR_TITLE = "我的医生";
    private static String MY_DOCTOR_ICON = "https://upyun.thedoc.cn/img/297150e5-02ff-49d9-88f7-492e0ba9b6ce.png";
    private static String MY_DOCTOR_ROUTER = "router://hybridWebView?url=/matrix/doctor.html#/mydoctor";

    private static String DOCTOR_TEAM_TITLE = "我的团队";
    private static String DOCTOR_TEAM_ICON = "https://upyun.thedoc.cn/img/fc6dd786-bd53-4344-90ff-47a0659d20ee.png";
    private static String DOCTOR_TEAM_ROUTER = "router://hybridWebView?url=/matrix/doctor.html#/myteam";

    private static String MEDICAL_MAN_TITLE = "我服务的医生";
    private static String MEDICAL_MAN_ICON = "https://upyun.thedoc.cn/img/66dbb1da-5edc-4fbf-997f-5af92ca1b52a.png";
    private static String MEDICAL_MAN_ROUTER = "router://hybridWebView?url=/matrix/doctor.html#/myteam";

    private static String MY_PATIENT_TITLE = "我的病人";
    private static String MY_PATIENT_ICON = "https://upyun.thedoc.cn/img/1bd063d8-6064-4ee5-bcba-cbfc3422687a.png";
    private static String MY_PATIENT_ROUTER = "router://hybridWebView?url=/matrix/homepage.html#/mypatient";

    static {
        NEW_FRIENDS.put("title", NEW_FRIENDS_TITLE);
        NEW_FRIENDS.put("icon", NEW_FRIENDS_ICON);
        NEW_FRIENDS.put("router", NEW_FRIENDS_ROUTER);
        NEW_FRIENDS.put("num", NEW_FRIENDS_NUM);

        GROUP_CHAT.put("title", GROUP_CHAT_TITLE);
        GROUP_CHAT.put("icon", GROUP_CHAT_ICON);
        GROUP_CHAT.put("router", GROUP_CHAT_ROUTER);

        MY_DOCTOR.put("title", MY_DOCTOR_TITLE);
        MY_DOCTOR.put("icon", MY_DOCTOR_ICON);
        MY_DOCTOR.put("router", MY_DOCTOR_ROUTER);

        DOCTOR_TEAM.put("title", DOCTOR_TEAM_TITLE);
        DOCTOR_TEAM.put("icon", DOCTOR_TEAM_ICON);
        DOCTOR_TEAM.put("router", DOCTOR_TEAM_ROUTER);

        MEDICAL_MAN.put("title", MEDICAL_MAN_TITLE);
        MEDICAL_MAN.put("icon", MEDICAL_MAN_ICON);
        MEDICAL_MAN.put("router", MEDICAL_MAN_ROUTER);

        MY_PATIENT.put("title", MY_PATIENT_TITLE);
        MY_PATIENT.put("icon", MY_PATIENT_ICON);
        MY_PATIENT.put("router", MY_PATIENT_ROUTER);

    }

    public static List<Map<String, String>> getChatBean(String type, String memberId){
        List<Map<String, String>> list = new ArrayList<>();


        if(C.equals(type)){
            list.add(NEW_FRIENDS);
            list.add(GROUP_CHAT);
            list.add(MY_DOCTOR);
        }else if(D.equals(type)){
            list.add(NEW_FRIENDS);
            list.add(GROUP_CHAT);
            list.add(MY_PATIENT);
            list.add(DOCTOR_TEAM);
        }else if(SP.equals(type)){
            list.add(NEW_FRIENDS);
            list.add(GROUP_CHAT);
            list.add(MEDICAL_MAN);
        }else if(BA_MA.equals(type)){
            list.add(NEW_FRIENDS);
            list.add(GROUP_CHAT);
            list.add(MEDICAL_MAN);
        }
        return list;
    }

    //新增好友关系推送文案
    final public static String FRIENDPUSH = "%s请求添加你为好友";

    public static String GET_FRIEND_PUSH_CONTENT(String realname) {
        String sendContent = String.format(FRIENDPUSH, realname);
        return sendContent;
    }

    public static Map<String, String> SEND_PUSH_FRIEND_MAP(String userType, String realname) {
        Map<String, String> ret = new HashMap<>();
//        String chcRouter = "";
//        try {
//            chcRouter = URLEncoder.encode(NEW_FRIENDS_ROUTER, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String router = C.equals(userType.toUpperCase())?NativeRouterConstants.CLIENT_ROUTER_PREFIX_FOR_H5:NativeRouterConstants.PRO_ROUTER_PREFIX_FOR_H5 + chcRouter;
        String router = NEW_FRIENDS_ROUTER;
        ret.put("title", "好友申请");
        ret.put("content", GET_FRIEND_PUSH_CONTENT(realname));
        ret.put("groupType", "系统");
        ret.put("platform", "app");
        ret.put("route",router);
        ret.put("type","friend");
        return ret;
    }



    public static void main(String[] args) {
        List<Map<String, String>> list = getChatBean("PATIENT", "");
        System.out.println(list);
    }
}
