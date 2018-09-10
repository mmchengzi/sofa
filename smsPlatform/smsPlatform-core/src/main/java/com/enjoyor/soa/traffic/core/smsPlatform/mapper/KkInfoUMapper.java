package com.enjoyor.soa.traffic.core.smsPlatform.mapper;

import com.enjoyor.soa.traffic.core.smsPlatform.pojo.KkInfoUPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface KkInfoUMapper {

    List<KkInfoUPojo> queryKkInfoU(Map<String,Object> map);
}