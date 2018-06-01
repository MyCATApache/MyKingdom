package io.imking.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.imking.common.domain.User;
import io.imking.common.mapping.UserMapper;
import io.imking.utils.Result;

/**
 * @author hwb
 * @create 2018/5/25 16:47
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Result<User> getUserInfo(Long id) {
    	Result<User> result = new Result<User>();
    	User user = userMapper.selectByPrimaryKey(id);
        if(user != null){
            result.setData(user);
        }
        return result;
    }

}
