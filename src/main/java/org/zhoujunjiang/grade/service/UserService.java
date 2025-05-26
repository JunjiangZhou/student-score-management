package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.User;

public interface UserService {
    User findByUsernameAndPassword(String username, String password);
}