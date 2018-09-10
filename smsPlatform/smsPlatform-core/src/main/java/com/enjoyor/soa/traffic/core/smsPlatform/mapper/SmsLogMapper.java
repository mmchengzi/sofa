package com.enjoyor.soa.traffic.core.smsPlatform.mapper;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface SmsLogMapper {
     List<SmsLogPojo> querySmsLog(Map<String,Object> map);
     int insertSmsLog(SmsLogPojo area);
     int updateSmsLog(SmsLogPojo area);
     int delSmsLog(Map<String,Object> map);
}