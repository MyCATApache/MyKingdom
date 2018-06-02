package io.imking.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.imking.common.domain.ImkUser;
import io.imking.common.mapping.ImkUserMapper;
import io.imking.utils.Result;

/**
 * @author hwb
 * @create 2018/5/25 16:47
 */
@Service
public class UserService {

    @Autowired
    private ImkUserMapper userMapper;

    public Result<ImkUser> getUserInfo(Integer id) {
    	Result<ImkUser> result = new Result<ImkUser>();
    	ImkUser user = userMapper.selectByPrimaryKey(id);
        if(user != null){
            result.setData(user);
        }
        return result;
    }

}
