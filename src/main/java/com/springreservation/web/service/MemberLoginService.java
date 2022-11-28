package com.springreservation.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springreservation.web.dao.MemberDao;
import com.springreservation.web.entity.Member;

@Service
public class MemberLoginService implements UserDetailsService{

    Pattern emailpattern = Pattern.compile("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");

    @Autowired
    MemberDao memberDao;


    @Override
    public UserDetails loadUserByUsername(String username){
        
        Member member;
        if(emailpattern.matcher(username).find()) member = memberDao.findByLoginEmail(username);
        else member = memberDao.findByPhoneNumber(username);

        //id가 없을시
        if(member == null || member.getId() ==0) throw new UsernameNotFoundException(username) ;

        String password = member.getEncodedPw();

        Collection<GrantedAuthority> collectors = new ArrayList<>();

        collectors.add(new SimpleGrantedAuthority(member.getRole()));

        UserDetails user = new User(username, password, collectors);
        return user;
    }
    
}
