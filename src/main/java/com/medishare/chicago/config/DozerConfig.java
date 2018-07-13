package com.medishare.chicago.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by limaosheng on 2016/9/1.
 */
@Configuration
public class DozerConfig {

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        
        return dozerBean;
    }

}
