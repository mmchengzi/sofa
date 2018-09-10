package com.enjoyor.soa.traffic.core.smsPlatform.mapper;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.MvJdcInfoPojo;
import com.enjoyor.soa.traffic.core.smsPlatform.pojo.SmsLogPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface MvJdcInfoMapper {
    List<MvJdcInfoPojo> queryMvJdcInfo(Map<String,Object> map);
}