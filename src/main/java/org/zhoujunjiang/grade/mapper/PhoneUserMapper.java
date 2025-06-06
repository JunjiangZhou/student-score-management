package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhoujunjiang.grade.entity.PhoneUser;

@Mapper
public interface PhoneUserMapper {
    PhoneUser findByPhone(String phone);
    void save(PhoneUser user);
}
