package edu.ldcollege.ctrl;

import java.util.Date;

import org.apache.ibatis.javassist.expr.NewArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import edu.ldcollege.domain.TBLdClass;
import edu.ldcollege.exception.NullParamException;
import edu.ldcollege.exception.RestRespErrorException;
import edu.ldcollege.service.ClassService;
import edu.ldcollege.util.DateUtils;
import edu.ldcollege.util.RestResult;
import edu.ldcollege.util.RestStatus;

/**
 * 
 * @author Raindrops on 2017 10 19
 *
 */
@RestController
@RequestMapping("class")
public class ClassController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ClassService classService;
	
	/**
	 * 获取班级列表
	 * @author Raindrops on 2017 10 19
	 * @param pageSize
	 * @param pageNum
	 * @param keyword
	 * @return
	 */
	@GetMapping()
	@ResponseBody
	public RestResult getClasses(
			@RequestParam(defaultValue="10") Integer pageSize,
			@RequestParam(defaultValue="1") Integer pageNum,
			String keyword) {
		if (logger.isInfoEnabled()) {
			logger.info("GET /class 获取班级  ==> [pageSize={},pageNum={},keyword={}]",pageSize,pageNum,keyword);
		}
		PageInfo result = classService.getClasses(pageNum, pageSize,keyword);
		return RestResult.success(result);
	}
	
	/**
	 * 根据id获取班级信息
	 * @author Raindrops on 2017 10 19
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	@ResponseBody
	public RestResult getClassById(@PathVariable("id") Integer id) {
		TBLdClass tbLdClass = classService.getClassInfoById(id);
		return RestResult.success(tbLdClass);
	}
	
	/**
	 * 新增班级
	 * @author Raindrops on 2017 10 19
	 * @param classdesc
	 * @param classname
	 * @param commissaryid
	 * @param startdate
	 * @param endday
	 * @param monitorid
	 * @return
	 */
	@PostMapping()
	@ResponseBody
	public RestResult addClass(String classdesc,String classname,Integer commissaryid,String startdate,String endday
						,Integer monitorid) {
		if (StringUtils.isEmpty(classdesc)) {
			throw new NullParamException("classdesc");
		}
		if (StringUtils.isEmpty(classname)) {
			throw new NullParamException("classname");
		}
		if (StringUtils.isEmpty(startdate)) {
			throw new NullParamException("startdate");
		}
		if (StringUtils.isEmpty(endday)) {
			throw new NullParamException("endday");
		}
		if (!DateUtils.isDate(startdate) || !DateUtils.isDate(endday)) {
			throw new RestRespErrorException(RestStatus.FORMATTER_DATE_ERROR);
		}
		TBLdClass tbLdClass = 
				classService.addClass(classdesc, classname, commissaryid, DateUtils.StringToDate(startdate), DateUtils.StringToDate(endday), monitorid);
		return RestResult.success(tbLdClass);
	}
	
	/**
	 * 修改班级信息
	 * @author Raindrops on 2017 10 19
	 * @param id
	 * @param classdesc
	 * @param classname
	 * @param commissaryid
	 * @param startdate
	 * @param endday
	 * @param monitorid
	 * @return
	 */
	@PutMapping("{id}")
	@ResponseBody
	public RestResult updateClass(
			@PathVariable("id") Integer id,
			String classdesc,String classname,Integer commissaryid,String startdate,String endday,Integer monitorid) {
		if (id==null) {
			throw new NullParamException("id");
		}
		if (StringUtils.isEmpty(classdesc)) {
			throw new NullParamException("classdesc");
		}
		if (StringUtils.isEmpty(classname)) {
			throw new NullParamException("classname");
		}
		if (StringUtils.isEmpty(startdate)) {
			throw new NullParamException("startdate");
		}
		if (StringUtils.isEmpty(endday)) {
			throw new NullParamException("endday");
		}
		if (!DateUtils.isDate(startdate) || !DateUtils.isDate(endday)) {
			throw new RestRespErrorException(RestStatus.FORMATTER_DATE_ERROR);
		}
		TBLdClass tbLdClass = 
				classService.updateClass(id , classdesc, classname, commissaryid, DateUtils.StringToDate(startdate), DateUtils.StringToDate(endday), monitorid);
		return RestResult.success(tbLdClass);
	}
	
	/**
	 * 删除课程
	 * @author Raindrops on 2017 10 19
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	@ResponseBody
	public RestResult deleteClass(
			@PathVariable("id") Integer id) {
		if (id==null) {
			throw new NullParamException("id");
		}
		classService.deleteClass(id);
		return RestResult.success(null);
	}
	
}
