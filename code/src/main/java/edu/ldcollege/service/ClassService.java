package edu.ldcollege.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.ldcollege.domain.TBLdClass;
import edu.ldcollege.exception.RestRespErrorException;
import edu.ldcollege.mapping.TBLdClassMapper;
import edu.ldcollege.util.RestStatus;

/**
 * 
 * @author Raindrops on 2017 10 19
 *
 */
@Service
public class ClassService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	TBLdClassMapper tbLdClassMapper;
	
	
	/**
	 * 查询课程
	 * @author Raindrops on 2017 10 19
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo getClasses(Integer pageNum,Integer pageSize,String keyword) {
		// log
		if (logger.isInfoEnabled()) {
			logger.info("getClasses ==> [pageNum={},pageSize={},keyword={}]",pageNum,pageSize,keyword);
		}
		PageHelper.startPage(pageNum, pageSize);
		if (!StringUtils.isEmpty(keyword)) {
			keyword = keyword.trim();
		}
		List<TBLdClass> tbLdClasses = tbLdClassMapper.selectAllByKeyWord(keyword);
		return new PageInfo(tbLdClasses);
	}
	
	/**
	 * 根据班级Id查询班级详情
	 * @author Raindrops on 2017 10 19
	 * @param cId
	 * @return
	 */
	public TBLdClass getClassInfoById(Integer cId) {
		if (logger.isInfoEnabled()) {
			logger.info("getClassInfoById ==> [cId={}]",cId);
		}
		TBLdClass tbLdClass = tbLdClassMapper.selectByPrimaryKey(cId);
		//if not exsts throw Exception
		Optional.of(tbLdClass).orElseThrow(()->new RestRespErrorException(RestStatus.NULL_CLASS_FOUND));
		return tbLdClass;
	}
	
	/**
	 * 添加班级
	 * @author Raindrops on 2017 10 19
	 * @param classdesc
	 * @param classname
	 * @param commissaryid
	 * @param startdate
	 * @param endday
	 * @param monitorid
	 * @return
	 */
	@Transactional
	public TBLdClass addClass(String classdesc,String classname,Integer commissaryid,Date startdate,Date endday,Integer monitorid) {
		TBLdClass persitent = new TBLdClass();
		persitent.setClassdesc(classdesc);
		persitent.setClassname(classname);
		persitent.setCommissaryid(commissaryid);
		persitent.setCreateday(new Date());
		persitent.setEndday(endday);
		persitent.setStartdate(startdate);
		persitent.setMonitorid(monitorid);
		tbLdClassMapper.insert(persitent);
		return persitent;
	}
	/**
	 * 编辑班级信息
	 * @param classId
	 * @param classdesc
	 * @param classname
	 * @param commissaryid
	 * @param startdate
	 * @param endday
	 * @param monitorid
	 * @return
	 */
	@Transactional
	public TBLdClass updateClass(Integer classId,String classdesc,String classname,Integer commissaryid,Date startdate,Date endday,Integer monitorid) {
		TBLdClass persitent = tbLdClassMapper.selectByPrimaryKey(classId);
		Optional.of(persitent).orElseThrow(()->new RestRespErrorException(RestStatus.NULL_CLASS_FOUND));
		persitent.setClassid(classId);
		persitent.setClassdesc(classdesc);
		persitent.setClassname(classname);
		persitent.setCommissaryid(commissaryid);
		persitent.setCreateday(new Date());
		persitent.setEndday(endday);
		persitent.setStartdate(startdate);
		persitent.setMonitorid(monitorid);
		tbLdClassMapper.updateByPrimaryKey(persitent);
		return persitent;
	}
	
	/**
	 * 删除班级
	 * @author Raindrops on 2017 10 19
	 * <pre>这个删除是弱智删除 懒的搞了 </pre>
	 * @param classId
	 */
	@Transactional
	public void deleteClass(Integer classId) {
		tbLdClassMapper.deleteByPrimaryKey(classId);
	}
	
}
