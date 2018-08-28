package com.medishare.chicago.service;

import com.medishare.chicago.domain.SysFriends;

import java.util.List;
import java.util.Map;

/**
 * @author: liuy
 * @date: 2018/8/2
 * @time: 上午9:41
 * @descripttion: com.medishare.chicago.service
 */
public interface SysFriendService {
    /**
     * 新增好友关系
     *
     * @param sysFriends
     * @return
     */
    int insert(SysFriends sysFriends);

    /**
     * 根据Id查找关系
     *
     * @param id
     * @return
     */
    SysFriends selectByPrimaryKey(String id);

    /**
     * 根据当前登录人、好友关系，查找好友列表
     *
     * @param from
     * @param to
     * @param relationShip
     * @return
     */
    List<SysFriends> searchSysFriendsBy(String from, String to, String fromTo, String relationShip);

    /**
     * 修改好友关系
     *
     * @param sysFriends
     * @return
     */
    int update(SysFriends sysFriends);

    int updateReversal(SysFriends sysFriends);

    /**
     * 更新关心人拼音
     *
     * @param id
     * @param pinyin
     * @return
     */
    int updateSysFriendsByPinyin(String id, String pinyin);


    /**
     * 第三屏 通讯录返回数据
     *
     * @param memberType
     * @param memberId
     * @return
     */
    Map<String, Object> getAddressList(String memberType, String memberId);

    /**
     * 判断两者之间关系
     *
     * @param from
     * @param to
     * @return
     */
    SysFriends selectBetweenTheTwo(String from, String to);

    /**
     * 签约入口太多，没办法堵住
     * 定时任务 在ironman里面 ，15秒一次，查找条件是当天status='4' and friend='on'
     * @return
     */
    int searchSignApplyAndUpdate();

    /**
     * 医生团队
     * @param memberA
     * @param memberB
     */
    void doctorTeamFindAndUpdate(String memberA, String memberB);
}