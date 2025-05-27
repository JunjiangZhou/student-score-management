package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zhoujunjiang.grade.entity.User;

@Mapper
public interface UserMapper {

    User findByUsername(@Param("username") String username);
    void insert(User user);
}