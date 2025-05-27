package org.zhoujunjiang.grade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.zhoujunjiang.grade.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;  // 你自己写的服务，用于查数据库

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username); // 自定义方法只按用户名查找
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user; // 返回实现了 UserDetails 的 User 对象
    }
}
