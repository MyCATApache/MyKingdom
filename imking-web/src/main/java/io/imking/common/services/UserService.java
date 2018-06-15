package io.imking.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.imking.common.beans.dto.ImkUserDTO;
import io.imking.common.domain.ImkUser;
import io.imking.common.mapping.ImkUserMapper;
import io.imking.utils.Result;

/**
 * @author bigbomb
 * @create 2018/5/25 16:47
 */
@Service
public class UserService {

    @Autowired
    private ImkUserMapper userMapper;
	/*
	 * 获取用户信息
	 */
    public ImkUserDTO getUserInfo(Integer id) {
    	ImkUserDTO user = userMapper.selectByPrimaryKey(id);
        return user;
    }


	/*
	 * 插入用户信息
	 */
    public void insert(ImkUser user) {
		// TODO Auto-generated method stub
    	userMapper.insert(user);
	}

	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateByPrimaryKeySelective(ImkUser user){
    	return userMapper.updateByPrimaryKeySelective(user);
	}
}
