package io.imking.common.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.util.DigestUtils;

import io.imking.common.beans.dto.UserRoleDTO;
import io.imking.common.mapping.ImkUserMapper;
import io.imking.utils.SpringUtils;


public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    private UserDetailsService userDetailsService;

    @Autowired
    private ImkUserMapper userMapper;
    public CustomAuthenticationProvider(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        // 用户认证逻辑
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        if (null != userDetails) {
        	ApplicationContext beanFactory= SpringUtils.getApplicationContext();  
   		    BCryptPasswordEncoder bCryptPasswordEncoder = beanFactory.getBean(BCryptPasswordEncoder.class);
            if(bCryptPasswordEncoder.matches(password, userDetails.getPassword())){
                // 这里设置角色
            	ImkUserMapper imkUserMapper = beanFactory.getBean(ImkUserMapper.class);
            	List<UserRoleDTO> roles = imkUserMapper.queryImkUserRole(name);
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            	for(UserRoleDTO role: roles)
            	{
            		 authorities.add(new GrantedAuthorityImpl(role.getAuthority()));
            	}              
                // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
                return auth;
            } else {
                throw new BadCredentialsException("密码错误");
            }
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }

    /**
     * 是否可以提供输入类型的认证服务
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}