package com.medishare.chicago.service;

import com.medishare.chicago.Application;
import com.medishare.chicago.config.DatabaseConfig;
import com.medishare.chicago.config.MybatisConfig;
import com.medishare.chicago.dao.DoctorDAO;
import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.utils.JSonUtils;
import net.minidev.json.JSONUtil;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuy on 2018/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, DatabaseConfig.class, MybatisConfig.class })
@WebAppConfiguration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class MybatisTest {

    @Autowired
    DoctorService doctorService;

    @Test
    public void test(){
        System.out.println("test case.");
    }

    @Test
    public void selectPersonSql() {
        String str = new SQL()
                .SELECT("P.ID", "A.USERNAME", "A.PASSWORD", "P.FULL_NAME", "D.DEPARTMENT_NAME", "C.COMPANY_NAME")
                .FROM("PERSON P", "ACCOUNT A")
                .INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID", "COMPANY C on D.COMPANY_ID = C.ID")
                .WHERE("P.ID = A.ID", "P.FULL_NAME like #{name}")
                .ORDER_BY("P.ID", "P.FULL_NAME")
                .toString();
        System.out.println(str);
    }

    @Test
    public void insertPersonSql() {
        String sql = new SQL()
                .INSERT_INTO("PERSON")
                .VALUES("ID, FIRST_NAME", "#{id}, #{firstName}")
                .VALUES("LAST_NAME", "#{lastName}")
                .toString();
        System.out.println(sql);
    }

    @Test
    public void testDAO(){
        Doctor doctor = new Doctor();
        doctor.setUsername("13916139743");
        doctor.setRealname("hakunaDoc");
//        Arrays.asList("1028","1026","1100");
        String[] ids = {"1028","1026","1100"};
        int count = doctorService.finDoctorCount(doctor, ids);
        System.out.println(count);
    }

    @Test
    public void testReplaceAllWord(){
        List<String> list = new ArrayList<>();

        List<String> listA = new ArrayList<>(Arrays.asList("最为","最佳","最具","最爱","最赚","最优","最好"
                ,"最大","最高级","最高档","最奢侈","最一流","最低级","最低价","最底","最便宜","最简单","史上最低价","最流行"
                ,"最著名","最受欢迎","最时尚","最聚拢","最符合","最舒适","最适合","最合适","最先","最后一波","最后一次","最新"
                ,"最轻便","最逼真","最牛","最热卖","最热销","最强","最有效","最实惠","最专业","最火","最新鲜","最新发明","最萌","世界之最","最安全"));

        List<String> listB = new ArrayList<>(Arrays.asList("第一","中国第一","全网第一","全球第一","销量第一","排名第一","唯一","第一品牌"
                ,"NO.1","TOP1","独一无二","全国第一","一流","仅此一次","最后一波","全国","大品牌之一"));
        List<String> listC = new ArrayList<>(Arrays.asList("国家级","全球级","宇宙级","世界级","顶级","顶尖","尖端","顶级工艺","顶级享受"
                ,"高级","极品","极佳","绝佳","绝对","终极","极致","5A","甲级","超甲级","至尊","至臻","臻品","臻致","臻席"
                ,"压轴","问鼎","空前","绝后","绝版","无双","非此莫属","巅峰","前所未有","无人能及","顶级","鼎级","鼎冠","定鼎"
                ,"完美","翘楚之作","不可再生","不可复制","绝无仅有","寸土寸金","淋漓尽致","无与伦比","卓越","卓著"));
        List<String> listD = new ArrayList<>(Arrays.asList("首个","首选","独家","首发","全网首发","全国首家","全国首发","中国首家","网独家","首次","首款"
                ,"首屈一指","全国销量冠军","国家级产品","国家免检","国家领导人","填补国内空白","中国驰名","驰名商标","国际品质","中国最好"));
        List<String> listE = new ArrayList<>(Arrays.asList("大牌","金牌","名牌","王牌","领袖品牌","世界领先","遥遥领先","领先","领导者","缔造者","创领品牌"
                ,"领先上市","巨星","著名","掌门人","至尊","巅峰","奢侈","优秀","资深","领袖","之王","王者","冠军"));
        List<String> listF = new ArrayList<>(Arrays.asList("史无前例","前无古人","永久","万能","祖传","特效","无敌","纯天然","100%","百分之百","高档","正品","真皮","超赚","精准"));
        List<String> listG = new ArrayList<>(Arrays.asList("老字号","中国驰名商标","特供","专供","专家推荐","质量免检","无需国家质量检测","免抽检","国家","领导人推荐","国家","机关推荐"));
        List<String> listH = new ArrayList<>(Arrays.asList("贵族","高贵","隐贵","上流","层峰","富人区","名门"));
        List<String> listI = new ArrayList<>(Arrays.asList("疗效最佳","根治","安全预防","安全无副作用","药到病除","无效退款","药之王","国家级新药"));
        list.addAll(listA);
        list.addAll(listB);
        list.addAll(listC);
        list.addAll(listD);
        list.addAll(listE);
        list.addAll(listF);
        list.addAll(listH);
        list.addAll(listG);
        list.addAll(listI);

        System.out.println(JSonUtils.toJsonString(list));



    }

}
