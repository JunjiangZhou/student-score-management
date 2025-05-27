package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Param;
import org.zhoujunjiang.grade.entity.User;

public interface UserMapper {

    User findByUsername(@Param("username") String username);
}