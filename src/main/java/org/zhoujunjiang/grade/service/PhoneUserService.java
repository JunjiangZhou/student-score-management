package org.zhoujunjiang.grade.service;

import org.zhoujunjiang.grade.entity.PhoneUser;

public interface PhoneUserService {
    PhoneUser findByPhone(String phone);
    void insert(PhoneUser user);
}
