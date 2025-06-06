package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zhoujunjiang.grade.entity.PhoneUser;

@Mapper
public interface PhoneUserMapper {

    @Select("SELECT * FROM phone_user WHERE phone = #{phone}")
    PhoneUser findByPhone(String phone);

    @Insert("INSERT INTO phone_user(phone) VALUES (#{phone})")
    void insert(PhoneUser user);
}