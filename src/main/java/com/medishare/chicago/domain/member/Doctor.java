package com.medishare.chicago.domain.member;

import com.medishare.chicago.domain.activity.DoctorActivity;
import com.medishare.chicago.domain.medical.Disease;

import java.util.Date;
import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
public class Doctor extends Member {

        private static final long serialVersionUID = 1L;

        /**
         * 医院ID
         */
        protected String hospitalId;

        /**
         * 部门ID
         */
        protected String departmentId;

        /**
         * 医生擅长的IDs
         */
        protected List<String> specialtyIds;

        /**
         * 职位头衔
         */
        protected String title;

        /**
         * 职称类型
         */
        protected String titleType;

        /**
         * 医生类型
         */
        protected String doctorType;

        /**
         * 认证信息
         */
        protected List<String> certifies;

        /**
         * 认证完成时间
         */
        protected Date certifiedDate;

        /**
         * 擅长疾病
         */
        protected List<Disease> specialty;

        /**
         * 接诊状态
         */
        protected Boolean inService;

        /**
         * 医生是否参加活动0不参加1参加
         */
        protected String joinStatus;

        /**
         * 签约量
         */
        protected Integer signCount;

        /**
         * 学历
         */
        protected String education;

        /**
         * 医生职业年份
         */
        protected String careerTime;

        /**
         * 医生职业范围
         */
        protected String vocationalArea;

        /**
         * 医生签约状态
         */
        protected String signStatus;

        /**
         * 医生职业时长
         */
        protected String proTime;

        /**
         * 医院名称
         */
        protected String hospitalName;

        /**
         * 医生职业编号
         */
        protected String formalDoctor;
        /**
         * 科室名称
         */
        protected String departmentName;
        /**
         * 医院类型
         */
        protected String gradeId;
        /**
         * 合作记录id
         */
        protected String contractId;
        /**
         * 毕业院校
         */
        protected String schoolId;

        /**
         * 医院级别
         */
        protected String hospitalLevel;

        /**
         * 医生身份证
         */
        protected String idCard;

        /**
         * #岗位(科别)
         */
        protected String post;

        /**
         * 是否执行临床手术
         */
        protected String clinicOperationFlag;

        /**
         * 医师所在执业医疗机构
         */
        protected String medicalOrg;

        /**
         * 医师所在执业医疗机构级别
         */
        protected String medicalOrgGrade;

        /**
         * 执业地点
         */
        protected String practicePlace;


        /**
         * 微信医生二维码链接
         */
        protected String wxQrcode;
        /**
         * 身份证审核状态
         */
        protected Integer checkCardUrl;

        /**
         * 执业类别
         */
        protected List<String> practiceCategory;

        /**
         * 执业范围
         */
        protected List<String> practiceScope;

        /**
         * 医生备注
         */
        protected String remarks;

        /**
         * 医生标识 null :真实医生 0 : 测试医生
         */
        protected String doctorFlag;
        /**
         * 待审核的医生头像
         */
        protected String checkPortrait;

        /**
         * 医生个人主页背景图片.
         */
        protected String personalPageBackgroundImg;
        /**
         * 专科医生科室类别
         * @return
         */
        protected String departmentCategory;
        /**
         * 推荐指数
         */
        protected String recommend;
        /**
         * 服务态度
         */
        protected String serviceAttitude;
        /**
         * 响应速度
         */
        protected String responseSpeed;
        /**
         * 整体满意度
         */
        protected String satisficing;
        /**
         * 专业技能
         */
        protected String professional;
        /**
         * 奖项授予
         */
        protected String award;
        /**
         * 文章发表
         */
        protected String articlePublished;
        /**
         * 1+1+1签约数
         */
        private String plusSign;

        /**
         * gpa姓名
         */
        private String gpaName;
        /**
         * ma姓名
         */
        private String maName;
        /**
         * 预计签约目标
         */
        private String expectQuantity;

        /**
         * 医生等级
         */
        private String docLevel;

        /**
         * 排序使用
         */
        private int sort;
        /**
         * 认证信息备份
         */
        private List<String> certifiesBak;



    public String getMaName() {
        return maName;
    }

    public void setMaName(String maName) {
        this.maName = maName;
    }

    public List<String> getCertifiesBak() {
        return certifiesBak;
    }

    public void setCertifiesBak(List<String> certifiesBak) {
        this.certifiesBak = certifiesBak;
    }

    /**
     * 团队医生职称
     */
    private String contractDoctorTitle;

    public String getPersonalPageBackgroundImg() {
        return personalPageBackgroundImg;
    }

    public void setPersonalPageBackgroundImg(String personalPageBackgroundImg) {
        this.personalPageBackgroundImg = personalPageBackgroundImg;
    }
    /**
     * 审核拒绝理由
     */
    private List<String> certifyRefuseReason;

    public String getExpectQuantity() {
        return expectQuantity;
    }

    public void setExpectQuantity(String expectQuantity) {
        this.expectQuantity = expectQuantity;
    }

    public String getPlusSign() {
        return plusSign;
    }

    public void setPlusSign(String plusSign) {
        this.plusSign = plusSign;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getArticlePublished() {
        return articlePublished;
    }

    public void setArticlePublished(String articlePublished) {
        this.articlePublished = articlePublished;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getServiceAttitude() {
        return serviceAttitude;
    }

    public void setServiceAttitude(String serviceAttitude) {
        this.serviceAttitude = serviceAttitude;
    }

    public String getResponseSpeed() {
        return responseSpeed;
    }

    public void setResponseSpeed(String responseSpeed) {
        this.responseSpeed = responseSpeed;
    }

    public String getSatisficing() {
        return satisficing;
    }

    public void setSatisficing(String satisficing) {
        this.satisficing = satisficing;
    }

    public String getCheckPortrait() {
        return checkPortrait;
    }

    public void setCheckPortrait(String checkPortrait) {
        this.checkPortrait = checkPortrait;
    }

    public Integer getCheckCardUrl() {
        return checkCardUrl;
    }

    public void setCheckCardUrl(Integer checkCardUrl) {
        this.checkCardUrl = checkCardUrl;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getProTime() {
        return proTime;
    }

    public void setProTime(String proTime) {
        this.proTime = proTime;
    }

    /**
     * 邀约类型
     */
    protected String inviteType;
    /**
     * 明星医生标识 1明星医生 0 普通医生
     */
    protected String star;

    public String getInviteType() {
        return inviteType;
    }

    public void setInviteType(String inviteType) {
        this.inviteType = inviteType;
    }

    public String getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(String joinStatus) {
        this.joinStatus = joinStatus;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public List<Disease> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<Disease> specialty) {
        this.specialty = specialty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public Boolean isInService() {
        return inService;
    }

    public void setInService(Boolean inService) {
        this.inService = inService;
    }

    public List<String> getCertifies() {
        return certifies;
    }

    public void setCertifies(List<String> certifies) {
        this.certifies = certifies;
    }

    public List<String> getSpecialtyIds() {
        return specialtyIds;
    }

    public void setSpecialtyIds(List<String> specialtyIds) {
        this.specialtyIds = specialtyIds;
    }

    public DoctorActivity getActivity() {
        return DoctorActivity.class.cast(activity);
    }

    public void setActivity(DoctorActivity activity) {
        this.activity = activity;
    }

    public Date getCertifiedDate() {
        return certifiedDate;
    }

    public void setCertifiedDate(Date certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCareerTime() {
        return careerTime;
    }

    public void setCareerTime(String careerTime) {
        this.careerTime = careerTime;
    }

    public String getVocationalArea() {
        return vocationalArea;
    }

    public void setVocationalArea(String vocationalArea) {
        this.vocationalArea = vocationalArea;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
    }

    public String getFormalDoctor() {
        return formalDoctor;
    }

    public void setFormalDoctor(String formalDoctor) {
        this.formalDoctor = formalDoctor;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getHospitalLevel() {
        return hospitalLevel;
    }

    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getClinicOperationFlag() {
        return clinicOperationFlag;
    }

    public void setClinicOperationFlag(String clinicOperationFlag) {
        this.clinicOperationFlag = clinicOperationFlag;
    }

    public String getMedicalOrg() {
        return medicalOrg;
    }

    public void setMedicalOrg(String medicalOrg) {
        this.medicalOrg = medicalOrg;
    }

    public String getMedicalOrgGrade() {
        return medicalOrgGrade;
    }

    public void setMedicalOrgGrade(String medicalOrgGrade) {
        this.medicalOrgGrade = medicalOrgGrade;
    }

    public String getPracticePlace() {
        return practicePlace;
    }

    public void setPracticePlace(String practicePlace) {
        this.practicePlace = practicePlace;
    }

    public List<String> getPracticeCategory() {
        return practiceCategory;
    }

    public void setPracticeCategory(List<String> practiceCategory) {
        this.practiceCategory = practiceCategory;
    }

    public List<String> getPracticeScope() {
        return practiceScope;
    }

    public void setPracticeScope(List<String> practiceScope) {
        this.practiceScope = practiceScope;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDoctorFlag() {
        return doctorFlag;
    }

    public void setDoctorFlag(String doctorFlag) {
        this.doctorFlag = doctorFlag;
    }

    public String getWxQrcode() {
        return wxQrcode;
    }

    public void setWxQrcode(String wxQrcode) {
        this.wxQrcode = wxQrcode;
    }

    public String getDepartmentCategory() {
        return departmentCategory;
    }

    public void setDepartmentCategory(String departmentCategory) {
        this.departmentCategory = departmentCategory;
    }

    public String getGpaName() {
        return gpaName;
    }

    public void setGpaName(String gpaName) {
        this.gpaName = gpaName;
    }

    public String getDocLevel() {
        return docLevel;
    }

    public void setDocLevel(String docLevel) {
        this.docLevel = docLevel;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getContractDoctorTitle() {
        return contractDoctorTitle;
    }

    public void setContractDoctorTitle(String contractDoctorTitle) {
        this.contractDoctorTitle = contractDoctorTitle;
    }

    public List<String> getCertifyRefuseReason() {
        return certifyRefuseReason;
    }

    public void setCertifyRefuseReason(List<String> certifyRefuseReason) {
        this.certifyRefuseReason = certifyRefuseReason;
    }
}
