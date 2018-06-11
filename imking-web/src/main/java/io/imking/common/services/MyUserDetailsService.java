package io.imking.common.services;

import static java.util.Collections.emptyList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.imking.common.domain.ImkUser;
import io.imking.common.domain.ImkUserExample;
import io.imking.common.mapping.ImkUserMapper;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private ImkUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	ImkUserExample imkuser = new ImkUserExample();
    	imkuser.createCriteria().andAccountEqualTo(username);
        List<ImkUser> imkUserList=userMapper.selectByExample(imkuser);
        String account = imkUserList.get(0).getAccount();
        String pwd = imkUserList.get(0).getPwd();
        if(imkUserList.size()==0){
            throw new UsernameNotFoundException(username);
        }
        return new User(account,pwd, emptyList());
    }

}