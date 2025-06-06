package org.zhoujunjiang.grade.entity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data

public class User implements UserDetails{
    private int id;
    private String username;
    private String password;

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    // 不需要权限，返回空集合
    return Collections.emptyList();
}

@Override
public String getPassword() {
    return password;
}

@Override
public String getUsername() {
    return username;
}

// 其他必须实现的方法，全部返回true，表示账户有效
@Override
public boolean isAccountNonExpired() { return true; }

@Override
public boolean isAccountNonLocked() { return true; }

@Override
public boolean isCredentialsNonExpired() { return true; }

@Override
public boolean isEnabled() { return true; }
}
