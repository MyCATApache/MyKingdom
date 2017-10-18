package edu.ldcollege.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ldcollege.domain.TBUser;
import edu.ldcollege.exception.RestRespErrorException;
import edu.ldcollege.mapping.TBUserMapper;
import edu.ldcollege.util.JwtUtils;
import edu.ldcollege.util.PBEUtils;
import edu.ldcollege.util.RestStatus;
import edu.ldcollege.util.status.TBUserStatus;

/**
 * 
 * Authorization Service
 * @author Raindrops on 20171018
 *
 */
@Service
public class AuthorizationService {
	
	@Autowired
	TBUserMapper tbUserMapper;
	
	/**
	 * 用户登录
	 * @author Raindrops on 20171018
	 * @param username
	 * @param password
	 * @return token {@link String}
	 */
	public String authorization(String username,String password) {
		TBUser tbUser = tbUserMapper.authorization(username, password);
		if (tbUser==null) {
			throw new RestRespErrorException(RestStatus.ERROR_USER_DISABLE);
		}
		if (tbUser.getEnabled().equals(TBUserStatus.DISABLT.getValue())) {
			throw new RestRespErrorException(RestStatus.ERROR_USER_Authorization);
		}
		String token = JwtUtils.signJWT(tbUser.getUsername());
		return token;
	}
	
}
