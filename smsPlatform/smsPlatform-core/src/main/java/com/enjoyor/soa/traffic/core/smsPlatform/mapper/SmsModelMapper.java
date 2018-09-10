package com.enjoyor.soa.traffic.core.smsPlatform.mapper;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsModelPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface SmsModelMapper {
    List<SmsModelPojo> querySmsModel(Map<String,Object> map);
    int insertSmsModel(SmsModelPojo area);
    int updateSmsModel(SmsModelPojo area);
    int delSmsModel(Map<String,Object> map);
}