package edu.ldcollege.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.ldcollege.domain.TBUser;
import edu.ldcollege.mapping.TBUserMapper;

@Component
@Transactional
public class UserService {

	@Autowired
	private TBUserMapper userMapper;

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void createUser(TBUser user) {
		userMapper.insert(user);
		
		// sqlSession.insert("leader.mapping.TBUserMapper.insert", user);
	}

	public List<TBUser> getAllUsers() {
		// sqlSessionTemp.selectList("leader.mapping.TBUserMapper.selectAll");
		
		return userMapper.selectAll();
	}

	public List<TBUser> queryUsers(List<String> usrIds) {
		// sqlSessionTemp.selectList("leader.mapping.TBUserMapper.selectAll");
		return userMapper.selectByCondition(usrIds);
	}
	
	public List<TBUser> queryUserByParams(String userId,boolean enabled) {
		// sqlSessionTemp.selectList("leader.mapping.TBUserMapper.selectAll");
		return userMapper.selectByPrarams(userId, enabled);
	}
	public TBUser getUser(String userID) {
		return sqlSession.selectOne("leader.mapping.TBUserMapper.selectByPrimaryKey", userID);
	}

}
