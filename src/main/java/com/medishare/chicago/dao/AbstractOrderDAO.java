package com.medishare.chicago.dao;

import com.medishare.chicago.domain.order.AbstractInvoice;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:15
 * @descripttion: com.medishare.chicago.dao
 */
public interface AbstractOrderDAO {
    @Insert({
            "insert into order_abstract_pseudo_data (account_id, agreement_id, user_type, user_id, user_name, employed_type, employed_id, employed_name, ",
            "amount, title, description, memo, status, payment_id, alert_at,is_read,patient_family_id,service_money_id,service_ids,pro_status,gpa_name,ma_name, ",
            "sub_agreement_id,earnings,service_charge,desc_voice_list,served_user_id,served_user_name,chat_employed_id,diseaseList,treat_people_idcard,treat_people_address,batch,treat_people_phone,created) ",
            "values(" +
                    "#{order.owner.id}, " +
                    "#{order.agreementId}, " +
                    "#{order.ownerType}, " +
                    "#{order.ownerId}, " +
                    "#{order.ownerName}, " +
                    "#{order.partyBType}, " +
                    "#{order.partyBId}, " +
                    "#{order.partyBName}," +
                    "#{order.price,typeHandler=com.medishare.chicago.domain.finance.MoneyTypehandler}, " +
                    "#{order.title}, " +
                    "#{order.description}, " +
                    "#{order.memo,typeHandler=com.medishare.chicago.domain.finance.MemoTypehandler}," +
                    "#{order.status}, " +
                    "#{order.paymentId}, " +
                    "#{order.alertAt},'0'," +
                    "#{order.patientFamilyId}," +
                    "#{order.serviceMoneyId}," +
                    "#{order.serviceIds,typeHandler=com.medishare.chicago.domain.finance.MemoTypehandler}," +
                    "#{order.proStatus}," +
                    "#{order.gpaName}," +
                    "#{order.maName}," +
                    "#{order.subAgreementIds,typeHandler=com.medishare.chicago.domain.finance.MemoTypehandler}," +
                    "#{order.earnings,typeHandler=com.medishare.chicago.domain.finance.MoneyTypehandler}," +
                    "#{order.serviceCharge,typeHandler=com.medishare.chicago.domain.finance.MoneyTypehandler}," +
                    "#{order.descVoiceList,typeHandler=com.medishare.chicago.domain.finance.MemoTypehandler}," +
                    "#{order.servedUserId},#{order.servedUserName},#{order.chatEmployedId}," +
                    "#{order.diseaseList,typeHandler=com.medishare.chicago.domain.finance.MemoTypehandler}," +
                    "#{order.treatPeopleIdcard}," +
                    "#{order.treatPeopleAddress}," +
                    "#{order.batch}," +
                    "#{order.treatPeoplePhone}," +
                    "#{order.created})"})
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "order.id", before = false, resultType = String.class)
    int insertAbstract(@Param("order") AbstractInvoice order);


    @Update({"<script>", "update order_abstract_pseudo_data set updated = now() ",
            "<if test='callId != null'> , call_id = #{callId} </if>",
            "<if test='title != null'> , title = #{title} </if>",
            "<if test='refundReason != null'> , refund_reason = #{refundReason} </if>",
            "<if test='refundAmount != null'> , refund_amount = #{refundAmount} </if>",
            "<if test='status != null'> , status = #{status} </if>",
            "<if test='cashStatus != null'> , cash_status = #{cashStatus} </if>",
            "<if test='paymentId != null'> , payment_id = #{paymentId} </if>",
            "<if test='partyBId != null'> , employed_id = #{partyBId} </if>",
            "<if test='partyBName != null'> , employed_name = #{partyBName} </if>",
            "<if test='ownerName != null'> , user_name = #{ownerName} </if>",
            "<if test='alertAt != null'> , alert_at = #{alertAt} </if>",
            "<if test='patientFamilyId != null'> , patient_family_id = #{patientFamilyId} </if>",
            "<if test='price != null'> , amount = #{price,typeHandler=com.medishare.chicago.domain.finance.MoneyTypehandler} </if>",
            "<if test='earnings != null'> , earnings = #{earnings,typeHandler=com.medishare.whale.domain.finance.MoneyTypehandler} </if>",
            "<if test='memo != null'> , memo = #{memo,typeHandler=com.medishare.whale.domain.finance.MemoTypehandler} </if>",
            "<if test='descVoiceList != null'> , desc_voice_list = #{descVoiceList,typeHandler=com.medishare.whale.domain.finance.MemoTypehandler} </if>",
            "<if test='description != null'> , description = #{description} </if>",
            "<if test='servedUserId != null'> , served_user_id = #{servedUserId} </if>",
            "<if test='servedUserName != null'> , served_user_name = #{servedUserName} </if>",
            "<if test='gpaName != null'> , gpa_name = #{gpaName} </if>",
            "<if test='maName != null'> , ma_name = #{maName} </if>",
            "<if test='remarks != null'> , remarks = #{remarks} </if>",
            "<if test='remindFlag != null'> , remind_flag = #{remindFlag} </if>",
            "where id = #{id}",
            "</script>"
    })
    int updateAbstractOrder(AbstractInvoice abstractOrder);

    @Update({"<script>", "update order_abstract_pseudo_data set updated = now() ",
            "<if test='doctorId != null'> , employed_id = #{doctorId} </if>",
            "<if test='doctorName != null'> , employed_name = #{doctorName} </if>",
            "where user_id = #{patientId}",
            "</script>"
    })
    int update(@Param("patientId") String patientId, @Param("doctorId") String doctorId, @Param("doctorName") String doctorName);



    @Results(value = {
            @Result(column = "user_id", property = "ownerId"),
            @Result(column = "user_name", property = "ownerName"),
    })
    @Select({"select * from order_abstract_pseudo_data where employed_id is null group by user_id limit #{limitNum};"})
    List<AbstractInvoice> selectBy(@Param("limitNum") int limitNum);
}
