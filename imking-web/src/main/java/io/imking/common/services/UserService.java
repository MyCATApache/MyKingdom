package io.imking.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.imking.common.beans.dto.ImkUserDTO;
import io.imking.common.domain.ImkUser;
import io.imking.common.mapping.ImkUserMapper;
import io.imking.utils.Result;
import lombok.extern.log4j.Log4j;

/**
 * @author hwb
 * @create 2018/5/25 16:47
 */
@Service
@Log4j
public class UserService {

    @Autowired
    private ImkUserMapper imkUserMapper;

    public Result<ImkUserDTO> getUserInfo(Integer id) {
    	Result<ImkUserDTO> result = new Result<ImkUserDTO>();
    	ImkUserDTO user = imkUserMapper.selectByPrimaryKey(id);
        if(user != null){
            result.setData(user);
        }
        return result;
    }

	public void insert(ImkUser user) {
		// TODO Auto-generated method stub
		imkUserMapper.insert(user);
	}

}
