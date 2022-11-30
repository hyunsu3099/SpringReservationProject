package com.springreservation.web.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{

    private String username;
    private String password;
    private String name;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked= true;
    private boolean isCredentialsNonExpired= true;
    private boolean isEnabled= true;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return authorities;}

    @Override
    public String getPassword() {return password;}

    @Override
    public String getUsername() {return username;}

    @Override
    public boolean isAccountNonExpired() {return isAccountNonExpired;}

    @Override
    public boolean isAccountNonLocked() {return isAccountNonLocked;}

    @Override
    public boolean isCredentialsNonExpired() { return isCredentialsNonExpired;}

    @Override
    public boolean isEnabled() { return isEnabled;}
    public String getName() { return name;}

    public User(){
    }
    public User(String email, String password, String name, Collection<? extends GrantedAuthority> authorities){
        this.username = email;
        this.password =password;
        this.name=name;
        this.authorities=authorities;
    }
    
}
