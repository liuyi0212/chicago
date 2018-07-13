package com.medishare.chicago.service;

import com.medishare.chicago.constant.PageConstant;
import com.medishare.chicago.dao.DoctorDAO;
import com.medishare.chicago.dao.PatientDAO;
import com.medishare.chicago.domain.PatientRequest;
import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.request.DoctorRequest;
import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSONRet.Pager;
import com.medishare.chicago.utils.JSonUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liuy on 2018/3/31.
 */

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    Datastore ds;

    @Autowired
    DoctorDAO doctorDAO;

    @Autowired
    PatientDAO patientDAO;


    @Override
    public JSONRet searchDoctorsJsonType(DoctorRequest doctorRequest, int page) {
        JSONRet ret = new JSONRet();
        if(StringUtils.isEmpty(doctorRequest.getProvinceId())){
            doctorRequest.setProvinceId("2");
        }
        Map<String, Object> map = new HashMap<>();
        Pager pager = new Pager();
        int start = page <= 1 ? 0 : ((page - 1) * PageConstant.PAGE_COUNT);
        List<DoctorRequest> doctorRequestList = doctorDAO.findDoctorList(doctorRequest, start, PageConstant.PAGE_COUNT);
        int count = doctorDAO.findDoctorListCount(doctorRequest);
        List<String> docIds = doctorRequestList.stream().map(DoctorRequest::getId).collect(Collectors.toList());
        List<String> docTags = searchDoctorTags(docIds);
        pager.setHasNextPage(doctorRequestList);
        pager.setCount(count);
        pager.setCurrent(page);
        map.put("list", doctorRequestList);
        map.put("docTags", docTags);
        ret.setData(map);
        ret.setPager(pager);
        return ret;
    }

    /**
     * List<String> docIds = doctorRequestList.stream().map(DoctorRequest::getId).collect(Collectors.toList());
     */


    @Override
    public List<DoctorRequest> searchDoctorList(DoctorRequest doctorRequest, int page) {
        int start = page <= 1 ? 0 : ((page - 1) * PageConstant.PAGE_COUNT);
//        List<DoctorRequest> doctorRequestList = doctorDAO.findDoctorList(doctorRequest, start, PageConstant.PAGE_COUNT);
        List<DoctorRequest> doctorRequestList = doctorDAO.findDoctorList(doctorRequest, 0, 50000);
        return doctorRequestList;
    }


    @Override
    public List<String> searchDoctorTags(List<String> docIds) {
        List<Map<String, Object>> list = searchDoctorTagTable(docIds, null);
        Map<String, String> docTagsMap = new HashMap<>();
        for (Map<String, Object> map : list) {
            List<Object> tagList = (List<Object>) map.get("tag_list");
            for (int i = 0; i < tagList.size(); i++) {
                for (Object o : tagList) {
                    Map<String, Object> m = (Map<String, Object>) o;
                    docTagsMap.put(m.get("tag_name").toString(), m.get("tag_name").toString());
                }
            }
        }
        List<String> docTags = docTagsMap.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList());
        return docTags;
    }

    /**
     *
     * @param docIds
     * @param docTags
     * @return {"100218":["糖尿病","高血压"],"100219":["高血压","糖尿病","糖尿病","高血压"]}
     */
    @Override
    public Map<String, List<String>> searchSignedPatientDBMongo(List<String> docIds, List<String> docTags) {
        DBCollection col = ds.getMongo().getDB("liuliang").getCollection("tag");
        BasicDBObject filter = new BasicDBObject();
        filter.put("tag_master", new BasicDBObject("$in", docIds));
        filter.put("ns", 101);
        filter.put("tag_list.tag_name", new BasicDBObject("$in", docTags));
        DBCursor dBCursor = col.find(filter);
        if (dBCursor == null) return null;
        Map<String, List<String>> retMap = new HashMap<>();
        for (DBObject obj : dBCursor) {
            //获取标签列表
            List<DBObject> tagList = (List<DBObject>) obj.get("tag_list");
            if (obj != null) {
                tagList = (List<DBObject>) obj.get("tag_list");
                if (tagList != null && tagList.size() > 0)
                    for (DBObject tag : tagList) {
                        List<DBObject> dbslaveList = (List<DBObject>) tag.get("slave_list");
                        if (dbslaveList != null)
                            for (DBObject dbSlave : dbslaveList) {
                                if (docTags.contains(tag.get("tag_name").toString())) {
                                    List<String> retList = null;
                                    if (retMap.get(dbSlave.get("tag_slave").toString()) == null) {
                                        retList = new ArrayList<>();
                                    } else {
                                        retList = retMap.get(dbSlave.get("tag_slave").toString());
                                    }
                                    retList.add((String) tag.get("tag_name"));
                                    retMap.put(dbSlave.get("tag_slave").toString(), retList);
                                }
                            }
                    }
            }
        }
//        List<Map<String, Object>> list = searchDoctorTagTable(docIds, docTags);
//        Map<String, List<String>> tagMap = new HashMap<>();
//        for (Map<String, Object> map : list) {
//            List<Object> tagList = (List<Object>) map.get("tag_list");
//            for (Object o : tagList) {
//                Map<String, Object> slaveMap = (Map<String, Object>) o;
//                if ((!tagMap.isEmpty() && tagMap.size() > 0) && tagMap.containsKey(slaveMap.get("tag_name").toString())) {
//                    List<String> pats = tagMap.get(slaveMap.get("tag_name").toString());
//                    List<Object> slaveList = (List<Object>) slaveMap.get("slave_list");
//                    for (Object so : slaveList) {
//                        Map<String, Object> tagSlaveMap = (Map<String, Object>) so;
//                        if (!StringUtils.isEmpty(tagSlaveMap.get("tag_slave").toString())) {
//                            pats.add(tagSlaveMap.get("tag_slave").toString());
//                        }
//                    }
//                    tagMap.put(slaveMap.get("tag_name").toString(), pats);
//                } else {
//                    List<String> pats = new ArrayList<>();
//                    List<Object> slaveList = (List<Object>) slaveMap.get("slave_list");
//                    for (Object so : slaveList) {
//                        Map<String, Object> tagSlaveMap = (Map<String, Object>) so;
//                        if (!StringUtils.isEmpty(tagSlaveMap.get("tag_slave").toString())) {
//                            pats.add(tagSlaveMap.get("tag_slave").toString());
//                        }
//                    }
//                    tagMap.put(slaveMap.get("tag_name").toString(), pats);
//                }
//            }
//
//        }
        return retMap;
    }

    /**
     *
     * @param doctorRequest
     * @return
     */
    @Override
    public List<PatientRequest> searchSignedPatient(DoctorRequest doctorRequest, int page) {

        doctorRequest.setProvinceId("2");
        List<DoctorRequest> doctorRequestList = searchDoctorList(doctorRequest, page);
        List<String> doctorIds = doctorRequestList.stream().map(DoctorRequest::getId).collect(Collectors.toList());
        List<String> tags = searchDoctorTags(doctorIds);


        Map<String, List<String>> map = searchSignedPatientDBMongo(doctorIds, tags);
        List<String> pats = new ArrayList<>();
        map.forEach((k,v)->pats.add(k));
        List<String> unique = pats.stream().distinct().collect(Collectors.toList());
        List<PatientRequest> pr = patientDAO.searchSignedPatientsByPatient(unique);
        pr.forEach(p-> p.setTags(map.get(p.getPatientId())));
        return pr;
    }


    /**
     * @param docIds  医生id
     * @param docTags 标签
     * @return
     */
    @Override
    public List<Map<String, Object>> searchDoctorTagTable(List<String> docIds, List<String> docTags) {
        List<Map<String, Object>> list = new ArrayList<>();
        // 查询集合
        DBCollection col = ds.getMongo().getDB("liuliang").getCollection("tag");
        // 过滤条件
        BasicDBObject filter = new BasicDBObject();
        if (docIds != null && !docIds.isEmpty()) {
            filter.put("tag_master", new BasicDBObject("$in", docIds));
        }
        if (docTags != null && !docTags.isEmpty()) {
            filter.put("tag_list.tag_name", new BasicDBObject("$in", docTags));
        }
        if ((docIds != null && !docIds.isEmpty()) && (docTags != null && !docTags.isEmpty())) {
            filter.put("tag_list.slave_list", new BasicDBObject("$ne", null));
        }
        filter.put("ns", 101); // 签约
//        System.out.println(JSonUtils.toJsonString(filter));
        DBCursor dBCursor = col.find(filter);
        for (DBObject obj : dBCursor) {
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("tag_master", obj.get("tag_master"));
            returnMap.put("tag_list", obj.get("tag_list"));
            list.add(returnMap);
        }
        return list;
    }

    @Override
    public int finDoctorCount(Doctor doctor, String[] ids) {
        return doctorDAO.finDoctorCount(ids);
    }
}
