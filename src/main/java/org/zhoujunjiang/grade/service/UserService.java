package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.User;

public interface UserService {
    User findByUsername(String username);
}