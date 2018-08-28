package com.medishare.chicago.service;

import com.github.promeg.pinyinhelper.Pinyin;
import com.medishare.chicago.constant.ChatConstant;
import com.medishare.chicago.dao.DoctorDAO;
import com.medishare.chicago.dao.PatientDAO;
import com.medishare.chicago.dao.SysFriendDAO;
import com.medishare.chicago.domain.GpSpContract;
import com.medishare.chicago.domain.SignApply;
import com.medishare.chicago.domain.SysFriends;
import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.member.Patient;
import com.medishare.chicago.util.IdUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: liuy
 * @date: 2018/8/2
 * @time: 上午9:42
 * @descripttion: com.medishare.chicago.service
 */
@Service
public class SysFriendServiceImpl implements SysFriendService{

    @Autowired
    SysFriendDAO sysFriendDAO;

    @Autowired
    DoctorDAO doctorDAO;

    @Autowired
    PatientDAO patientDAO;

    @Override
    public int searchSignApplyAndUpdate() {
        int count = 0;
        List<SignApply> list = sysFriendDAO.getCurrSignedData();
        if(list !=null && !list.isEmpty()) {
            List<String> ids = list.stream().map(SignApply::getId).collect(Collectors.toList());
            list.forEach(l -> {
                jobs("sign", IdUtils.doctorId2MemberId(l.getDoctorId()), IdUtils.patientId2MemberId(l.getPatientId()));
            });
        }
        return count;
    }

    @Override
    public void doctorTeamFindAndUpdate(String memberA, String memberB) {

        List<GpSpContract> list = sysFriendDAO.getGpSpContract();

        if(list !=null && !list.isEmpty()) {

            list.forEach(l -> {
                System.out.println(IdUtils.doctorId2MemberId(l.getGp_id()));
                System.out.println(IdUtils.doctorId2MemberId(l.getSp_id()));
                jobs("docTeam", IdUtils.doctorId2MemberId(l.getGp_id()), IdUtils.doctorId2MemberId(l.getSp_id()));
            });
        }
    }

    public void jobs(String type, String memberA, String memberB){
        String from = memberA;
        String to = memberB;
        String from_id = memberA;
        String from_realname = null;
        String from_username = null;
        String to_id = memberB;
        String fromUserType = null;
        SysFriends sysFriends = new SysFriends();
        if("sign".equals(type)){
            from_id = IdUtils.memberId2DoctorId(memberA);
            to_id = IdUtils.memberId2PatientId(memberB);
            sysFriends.setApplyWay("通过签约添加");
            fromUserType = ChatConstant.D;
        }else if("docTeam".equals(type)){
            from_id = IdUtils.memberId2DoctorId(memberA);
            to_id = IdUtils.memberId2DoctorId(memberB);
            sysFriends.setApplyWay("通过医生合作");
            fromUserType = ChatConstant.D;
        }
        Doctor doctorA = doctorDAO.findDoctorById(from_id);
        Doctor doctorB = doctorDAO.findDoctorById(to_id);
        if(doctorA!=null && doctorB!=null) {
            if (IdUtils.isDoctorId(memberA)) {
                Doctor doctor = doctorDAO.findDoctorById(from_id);
                from_realname = StringUtils.isBlank(doctor.getRealname()) ? doctor.getUsername() : doctor.getRealname();
                from_username = StringUtils.isBlank(doctor.getRealname()) ? doctor.getUsername() : doctor.getRealname();
            } else if (IdUtils.isPatientId(memberA)) {
                Patient patient = patientDAO.findPatientById(from_id);
                from_realname = StringUtils.isBlank(patient.getRealname()) ? patient.getUsername() : patient.getRealname();
                from_username = StringUtils.isBlank(patient.getRealname()) ? patient.getUsername() : patient.getRealname();
            }
            //如果两人是好友不处理
            List<SysFriends> friends = sysFriendDAO.checkRelationShip(from, to);
            //检查两者关系，1条记录肯定是申请中或者拒绝
            if (friends != null && !friends.isEmpty() && 1 == friends.size()) {
                sysFriends.setId(friends.get(0).getId());
                sysFriends.setRelationShip("on");
                update(sysFriends);
                updateReversal(sysFriends);
            } else if (null == friends || friends.size() == 0) {
                sysFriends.setFrom(from);
                sysFriends.setFromId(from_id);
                sysFriends.setFromPhone(from_username);
                sysFriends.setFromRealname(from_realname);
                sysFriends.setFromUserType(fromUserType);
                sysFriends.setTo(to);
                sysFriends.setToId(to_id);
                if (StringUtils.isBlank(sysFriends.getApplyWay())) {
                    sysFriends.setApplyWay("通过好友添加");
                }
                sysFriends.setRelationShip("on");
                getBean(sysFriends);
                sysFriendDAO.insert(sysFriends);
                sysFriendDAO.insertReversal(sysFriends);
            }
        }
    }

    public SysFriends getBean(SysFriends sysFriends){
        //格式化接收人数据
        if(IdUtils.isPatientId(sysFriends.getTo())){
            sysFriends.setTo(IdUtils.patientId2MemberId(sysFriends.getToId()));
            sysFriends.setToUserType(ChatConstant.C);
        }else if(IdUtils.isDoctorId(sysFriends.getFrom())){
            sysFriends.setTo(IdUtils.doctorId2MemberId(sysFriends.getToId()));
            sysFriends.setToUserType(ChatConstant.D);
        }
//        sysFriends.setToId(sysFriends.getToId());
        //发送人数据绑定
        if(IdUtils.isDoctorId(sysFriends.getFrom()) || ChatConstant.D.toLowerCase().equals(sysFriends.getFrom())){
            Doctor d = doctorDAO.findDoctorById(sysFriends.getFromId());
            sysFriends.setFromPortrait(d.getPortrait());
            sysFriends.setFromRealname(d.getRealname());
            sysFriends.setFromPhone(d.getUsername());
            sysFriends.setFromUserType(ChatConstant.D);
        }else if(IdUtils.isPatientId(sysFriends.getFrom()) || ChatConstant.C.toLowerCase().equals(sysFriends.getFrom())){
            Patient p = patientDAO.findPatientById(sysFriends.getFromId());
            sysFriends.setFromPortrait(p.getPortrait());
            sysFriends.setFromRealname(p.getRealname());
            sysFriends.setFromPhone(p.getUsername());
            sysFriends.setFromUserType(ChatConstant.C);
        }
        //接收人数据绑定
        if(IdUtils.isDoctorId(sysFriends.getTo()) || ChatConstant.D.toLowerCase().equals(sysFriends.getTo())){
            Doctor d = doctorDAO.findDoctorById(sysFriends.getToId());
            sysFriends.setToPortrait(d.getPortrait());
            sysFriends.setToRealname(d.getRealname());
            sysFriends.setToPhone(d.getUsername());
            sysFriends.setToUserType(ChatConstant.D);
        }else if(IdUtils.isPatientId(sysFriends.getTo()) || ChatConstant.C.toLowerCase().equals(sysFriends.getTo())){
            Patient p = patientDAO.findPatientById(sysFriends.getToId());
            sysFriends.setToPortrait(p.getPortrait());
            sysFriends.setToRealname(p.getRealname());
            sysFriends.setToPhone(p.getUsername());
            sysFriends.setToUserType(ChatConstant.C);
        }
        //汉字转拼音
        if(!StringUtils.isBlank(sysFriends.getToRealname())){
            sysFriends.setToPinyin(Pinyin.toPinyin(sysFriends.getToRealname(), "").toUpperCase());
        }
        if(!StringUtils.isBlank(sysFriends.getFromRealname())){
            sysFriends.setFromPinyin(Pinyin.toPinyin(sysFriends.getFromRealname(), "").toUpperCase());
        }
        sysFriends.setRelationShip(StringUtils.isBlank(sysFriends.getRelationShip())?"apply":sysFriends.getRelationShip());
        sysFriends.setFromTo("from");
        return sysFriends;
    }


    @Override
    public int update(SysFriends sysFriends) {
        //如果两个人都是医生，将他们添加为团队关系signDoctor
//        SysFriends sf = selectByPrimaryKey(sysFriends.getId());
//        if(IdUtils.isDoctorId(sf.getFrom()) && IdUtils.isDoctorId(sf.getTo())){
//            Doctor doctorA = doctorDAO.findDoctorById(sf.getFromId());
//            Doctor doctorB = doctorDAO.findDoctorById(sf.getToId());
//            doctorService.updateSignDoctor(doctorA, doctorB, "2");
//        }
//        return sysFriendDAO.update(sysFriends);
        return 0;
    }

    @Override
    public int updateReversal(SysFriends sysFriends) {
        SysFriends sf = selectByPrimaryKey(sysFriends.getId());
        return sysFriendDAO.insertReversal(sf);
    }








    @Override
    public int updateSysFriendsByPinyin(String id, String pinyin) {
        return 0;
    }

    @Override
    public Map<String, Object> getAddressList(String memberType, String memberId) {
        return null;
    }

    @Override
    public SysFriends selectBetweenTheTwo(String from, String to) {
        return null;
    }

    @Override
    public int insert(SysFriends sysFriends) {
        return 0;
    }

    @Override
    public SysFriends selectByPrimaryKey(String id) {
        return sysFriendDAO.selectByPrimaryKey(id);
    }

    @Override
    public List<SysFriends> searchSysFriendsBy(String from, String to, String fromTo, String relationShip) {
        return null;
    }
}
