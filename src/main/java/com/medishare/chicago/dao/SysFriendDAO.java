package com.medishare.chicago.dao;

import com.medishare.chicago.domain.GpSpContract;
import com.medishare.chicago.domain.SignApply;
import com.medishare.chicago.domain.SysFriends;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * @author: liuy
 * @date: 2018/8/2
 * @time: 上午9:43
 * @descripttion: com.medishare.chicago.dao
 */
public interface SysFriendDAO {
    //    @Select({"select id, doctor_id as doctorId, patient_id as patientId from sign_apply where date(created) = curdate() and `status` = '4' and (friend is null or friend = '');"})
    @Select({"select sa.id, sa.doctor_id as doctorId, sa.patient_id as patientId from member_patient mp left join sign_apply sa on mp.contract_id = sa.contract_id where mp.contract_id is not null order by mp.id desc;;"})
    List<SignApply> getCurrSignedData();


    @Select({"select * from gp_sp_contract where `status` = '2';"})
    List<GpSpContract> getGpSpContract();




    @Insert({
            "INSERT INTO `sys_friends` (`from`, `from_id`, `from_realname`, `from_phone`, `from_usertype`, `from_pinyin`, `from_portrait`, " +
                    "`to`, `to_id`, `to_realname`, `to_phone`, `to_usertype`, `to_pinyin`, `to_portrait`, `created`, `relation_ship`, `apply_way`, `from_to`)",
            "values(#{from}, #{fromId}, #{fromRealname}, #{fromPhone}, #{fromUserType}, #{fromPinyin}, #{fromPortrait}, " +
                    "#{to}, #{toId}, #{toRealname}, #{toPhone}, #{toUserType}, #{toPinyin}, #{toPortrait}, now(), #{relationShip}, #{applyWay}, #{fromTo})"})
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = String.class)
    int insert(SysFriends sysFriends);

    @Insert({
            "INSERT INTO `sys_friends` (`from`, `from_id`, `from_realname`, `from_phone`, `from_usertype`, `from_pinyin`, `from_portrait`, " +
                    "`to`, `to_id`, `to_realname`, `to_phone`, `to_usertype`, `to_pinyin`, `to_portrait`, `created`, `updated`, `relation_ship`, `apply_way`)",
            "values(#{to}, #{toId}, #{toRealname}, #{toPhone}, #{toUserType}, #{toPinyin}, #{toPortrait}, " +
                    "#{from}, #{fromId}, #{fromRealname}, #{fromPhone}, #{fromUserType}, #{fromPinyin}, #{fromPortrait}, now(), now(), #{relationShip}, #{applyWay})"})
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = String.class)
    int insertReversal(SysFriends sysFriends);

    @Insert({"<script>", "update sys_friends set updated = now() ",
            "<if test='relationShip != null'> , relation_ship = #{relationShip} </if>",
            "<if test='tab != null'> , tab = #{tab} </if>",
            "where id = #{id}", "</script>"})
    int update(SysFriends sysFriends);

    @Insert({"<script>", "update sys_friends set updated = now() ",
            "<if test='pinyin != null'> , from_pinyin = #{pinyin}, to_pinyin = #{pinyin} </if>",
            "where `to` = #{memberId} or `from` = #{memberId}", "</script>"})
    int updateSysFriendsByPinyin(@Param("memberId") String memberId, @Param("pinyin") String pinyin);

    @Results(value = {@Result(column = "from", property = "from", javaType = String.class),
            @Result(column = "from_id", property = "fromId", javaType = String.class),
            @Result(column = "from_realname", property = "fromRealname", javaType = String.class),
            @Result(column = "from_portrait", property = "fromPortrait", javaType = String.class),
            @Result(column = "to", property = "to", javaType = String.class),
            @Result(column = "to_id", property = "toId", javaType = String.class),
            @Result(column = "to_realname", property = "toRealname", javaType = String.class),
            @Result(column = "to_phone", property = "toPhone", javaType = String.class),
            @Result(column = "to_usertype", property = "toUserType", javaType = String.class),
            @Result(column = "to_pinyin", property = "toPinyin", javaType = String.class),
            @Result(column = "to_initials", property = "toInitials", javaType = String.class),
            @Result(column = "to_portrait", property = "toPortrait", javaType = String.class),
            @Result(column = "created", property = "created", javaType = Date.class),
            @Result(column = "relation_ship", property = "relationShip", javaType = String.class),
            @Result(column = "apply_way", property = "applyWay", javaType = String.class),
            @Result(column = "tab", property = "tab", javaType = String.class),
    })
    @Select({"<script>", "select sf.*, substring(sf.`to_pinyin`,1,1) as to_initials from sys_friends sf where 1=1 " +
            "<if test='from != null'> and sf.from = #{from} </if>" +
            "<if test='to != null'> and sf.to = #{to} </if>" +
            "<if test='fromTo != null'> and sf.from_to = #{fromTo} </if>" +
            "<if test='relationShip != null'> and sf.relation_ship = #{relationShip} </if>", "</script>"})
    List<SysFriends> searchSysFriendsBy(@Param("from") String from, @Param("to") String to, @Param("fromTo") String fromTo, @Param("relationShip") String relationShip);

//    /**
//     * 返回我的好友
//     * @param from 谁申请
//     * @param to   谁接受
//     * @param relationShip
//     * @return
//     */
//    @Results(value = {
//            @Result(column = "from_realname", property = "realname", javaType = String.class),
//            @Result(column = "from_portrait", property = "portrait", javaType = String.class),
//            @Result(column = "from_phone", property = "phone", javaType = String.class),
//            @Result(column = "from_initials", property = "initials", javaType = String.class),
//            @Result(column = "from_usertype", property = "userType", javaType = String.class),
//    })
//    @Select({"<script>", "select sf.*, substring(sf.`from_pinyin`,1,1) as from_initials from sys_friends sf where 1=1 " +
////            " and sf.`from_to` = 'from' " +
//            "<if test='from != null'> and sf.from = #{from} </if>" +
//            "<if test='to != null'> and sf.to = #{to} </if>" +
//            "<if test='relationShip != null'> and sf.relation_ship = #{relationShip} </if>", "</script>"})
//    List<SysFriendTemp> searchTemp(@Param("from") String from, @Param("to") String to, @Param("relationShip") String relationShip);

//    @Results(value = { @Result(column = "id", property = "id", javaType = String.class),
//            @Result(column = "memberId", property = "memberId", javaType = String.class),
//            @Result(column = "usertype", property = "usertype", javaType = String.class),
//            @Result(column = "groupNick", property = "realname", javaType = String.class),
//            @Result(column = "portrait", property = "portrait", javaType = String.class),
//            @Result(column = "disabled", property = "disabled", javaType = Boolean.class, jdbcType = JdbcType.VARCHAR, typeHandler = BooleanTypeHandler.class),
//    })
//    @Select({"<script>",
//            "select distinct s.from_id as id, s.`from` as memberId, s.from_usertype as usertype, IFNULL(s.from_realname,s.from_phone) as groupNick, s.`from_portrait` as portrait, " +
//                    "0 DISABLE  from chat_user_group_rel c left join `sys_friends` s on c.memberId = s.`to` " +
//                    "where s.relation_ship = 'on' " +
//                    "<if test='groupId != null and memberId != null'> and c.groupId = #{groupId} and c.memberId = #{memberId} </if>" +
//                    "<if test='groupId == null and memberId != null'> and s.to = #{memberId} </if>", "</script>"
//    })
//    List<ChatMemberInfo> getAnotherPerson(@Param("groupId") String groupId, @Param("memberId") String memberId);
//
//    @Results(value = { @Result(column = "id", property = "id", javaType = String.class),
//            @Result(column = "memberId", property = "memberId", javaType = String.class),
//            @Result(column = "usertype", property = "usertype", javaType = String.class),
//            @Result(column = "groupNick", property = "realname", javaType = String.class),
//            @Result(column = "portrait", property = "portrait", javaType = String.class),
//            @Result(column = "disabled", property = "disabled", javaType = Boolean.class, jdbcType = JdbcType.VARCHAR, typeHandler = BooleanTypeHandler.class),
//    })
//    @Select({"<script>",
//            "select s.to_id as id, s.to as memberId, s.to_usertype as usertype, IFNULL(s.to_realname,s.to_phone) as groupNick, s.`to_portrait` as portrait, " +
//                    "case  WHEN LOCATE('Doctor', s.to) " +
//                    "THEN (SELECT wyy_accid from member_doctor a where a.id=SUBSTR(s.to FROM LOCATE('_',s.to)+1)) end as wyyId, " +
//                    "0 DISABLE from sys_friends s " +
//                    "where s.to in ( select memberId from chat_user_group_rel where groupId=#{groupId} and memberId!=#{memberId} ) group by s.to; "+
//                    "</script>"
//    })
//    List<ChatMemberInfo> searchGroupChatPersons(@Param("groupId") String groupId, @Param("memberId") String memberId);

    @Select({ "<script>",
            " select memberId from chat_user_group_rel where groupId=#{groupId}  ",
            "</script>" })
    List<String> getChatMemberList(@Param("groupId") String groupId);


    @Results(value = {@Result(column = "from", property = "from", javaType = String.class),
            @Result(column = "from_id", property = "fromId", javaType = String.class),
            @Result(column = "from_realname", property = "fromRealname", javaType = String.class),
            @Result(column = "from_phone", property = "fromPhone", javaType = String.class),
            @Result(column = "from_usertype", property = "fromUserType", javaType = String.class),
            @Result(column = "from_pinyin", property = "fromPinyin", javaType = String.class),
            @Result(column = "from_portrait", property = "fromPortrait", javaType = String.class),
            @Result(column = "to", property = "to", javaType = String.class),
            @Result(column = "to_id", property = "toId", javaType = String.class),
            @Result(column = "to_realname", property = "toRealname", javaType = String.class),
            @Result(column = "to_phone", property = "toPhone", javaType = String.class),
            @Result(column = "to_usertype", property = "toUserType", javaType = String.class),
            @Result(column = "to_pinyin", property = "toPinyin", javaType = String.class),
            @Result(column = "to_portrait", property = "toPortrait", javaType = String.class),
            @Result(column = "created", property = "created", javaType = Date.class),
            @Result(column = "relation_ship", property = "relationShip", javaType = String.class),
            @Result(column = "apply_way", property = "applyWay", javaType = String.class),
    })
    @Select({"select sf.* from sys_friends sf where 1=1 and sf.id = #{id}"})
    SysFriends selectByPrimaryKey(@Param("id") String id);

    @Select({"<script>", "SELECT sf.id, sf.from, sf.to, " +
            "SUM(sf.relation_ship = 'on') AS relationShipOn, " +
            "SUM(sf.relation_ship = 'break') AS relationShipBreak, " +
            "SUM(sf.relation_ship = 'apply') AS relationShipApply, " +
            "SUM(sf.relation_ship = 'timeout') AS relationShipTimeout, " +
            "sf.relation_ship " +
            "FROM sys_friends sf " +
            "where 1=1" +
            "<if test='from != null'> and sf.from = #{from} </if>" +
            "<if test='to != null'> and sf.to = #{to} </if>" +
            "order by id desc limit 1","</script>"})
    SysFriends selectBetweenTheTwo(@Param("from") String from, @Param("to") String to);

    @Select({"select count(*) from sys_friends sf where sf.to = #{to} and relation_ship = 'apply' order by created desc;"})
    int getNewFriendApply(@Param("to") String to);

    @Select({"select count(*) from sys_friends sf where sf.to = #{to} and relation_ship = 'on';"})
    int getFrientCount(@Param("to") String to);

    @Update({ "<script>",
            "update sign_apply set friend = 'on' where id in ",
            "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>" })
    int updateCurrSignedData(@Param("ids") List<String> ids);

    @Results(value = {@Result(column = "id", property = "id", javaType = String.class),
            @Result(column = "from", property = "from", javaType = String.class),
            @Result(column = "from_id", property = "fromId", javaType = String.class),
            @Result(column = "from_realname", property = "fromRealname", javaType = String.class),
            @Result(column = "from_phone", property = "fromPhone", javaType = String.class),
            @Result(column = "from_usertype", property = "fromUserType", javaType = String.class),
            @Result(column = "from_pinyin", property = "fromPinyin", javaType = String.class),
            @Result(column = "from_portrait", property = "fromPortrait", javaType = String.class),
            @Result(column = "to", property = "to", javaType = String.class),
            @Result(column = "to_id", property = "toId", javaType = String.class),
            @Result(column = "to_realname", property = "toRealname", javaType = String.class),
            @Result(column = "to_phone", property = "toPhone", javaType = String.class),
            @Result(column = "to_usertype", property = "toUserType", javaType = String.class),
            @Result(column = "to_pinyin", property = "toPinyin", javaType = String.class),
            @Result(column = "to_portrait", property = "toPortrait", javaType = String.class),
            @Result(column = "created", property = "created", javaType = Date.class),
            @Result(column = "relation_ship", property = "relationShip", javaType = String.class),
            @Result(column = "apply_way", property = "applyWay", javaType = String.class),
    })
    @Select({"select * from `sys_friends` where " +
            "(`from` = #{from} and `to` = #{to}) or (`from` = #{to} and `to` = #{from});"})
    List<SysFriends> checkRelationShip(@Param("from") String from, @Param("to") String to);
}
