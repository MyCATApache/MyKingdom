package io.imking.common.services;

import java.util.List;

import io.imking.reward.domain.RwAsk;
import io.imking.reward.domain.RwAskExample;
import io.imking.reward.mapping.RwAskMapper;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

/**
 * @author hwb
 * @create 2018/5/25 16:47
 */
@Service
@Log4j
public class RwAskService {

	@Autowired
	private RwAskMapper rwAskMapper;


	public Result<String> saveContent(RwAsk rwAsk) {
		RwAskExample example = new RwAskExample();
		RwAskExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(rwAsk.getId());
		try {
			long rwAskNum = rwAskMapper.countByExample(example);
			if (rwAskNum != 1) {
				return new Result<>(ResultEnum.SERVER_ERROR, "红包异常");
			}
		} catch (Exception e) {
			log.error("红包查询异常" + e.toString());
			return new Result<>(ResultEnum.SERVER_ERROR, "当前红包不存在");
		}
		/**
		 * 判断当前操作人是否是该条红包悬赏的主人
		 */
		String content = rwAsk.getContent().trim();
		if (StringUtils.isBlank(content)) {
			return new Result<>(ResultEnum.SERVER_ERROR, "红包内容不允许为空");
		}
		try {
			rwAskMapper.insert(rwAsk);
		} catch (Exception e) {
			log.error("红包内容存错异常" + e.toString());
			return new Result<>(ResultEnum.SERVER_ERROR, "存储异常");
		}
		return new Result<>(ResultEnum.SUCCESS, "保存成功");
	}

    /**
     * 更新红包内容
     * @param rwAsk
     * @return
     */
    public Result<String> updateRwAsk(RwAsk rwAsk){
        Result<String> result = new Result<String>();
        int count = rwAskMapper.updateByPrimaryKey(rwAsk);
        if(count > 0){
            result.ok("更新成功");
        }else{
            result.error("更新失败");
        }
        return result;
    }
    

    /**
     * 获取红包任务列表
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
	public Result<Object> getRwAskList(int pageNum,int pageSize) throws Exception{
		PageHelper.startPage(pageNum, pageSize);
		Result<Object> result = new Result<Object>();
		List<RwAsk> RwAskList = rwAskMapper.selectByExample(null);
		result.setData(RwAskList);
		return result;
    }
	
	

}
