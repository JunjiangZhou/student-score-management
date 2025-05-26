package org.zhoujunjiang.grade.mapper;

import org.apache.ibatis.annotations.Param;
import org.zhoujunjiang.grade.entity.User;

public interface UserMapper {
    User findByUsernameAndPassword(@Param("username") String username,
                                   @Param("password") String password);
}