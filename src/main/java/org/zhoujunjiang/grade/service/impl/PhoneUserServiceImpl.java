package org.zhoujunjiang.grade.service.impl;

import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.entity.PhoneUser;
import org.zhoujunjiang.grade.mapper.PhoneUserMapper;
import org.zhoujunjiang.grade.service.PhoneUserService;

import javax.annotation.Resource;
@Service
public class PhoneUserServiceImpl implements PhoneUserService {
    @Resource
    private PhoneUserMapper phoneUserMapper;
    @Override
    public PhoneUser findByPhone(String phone){
        return phoneUserMapper.findByPhone(phone);
    }
    @Override
    public void insert(PhoneUser user){
        phoneUserMapper.insert(user);
    }
}
