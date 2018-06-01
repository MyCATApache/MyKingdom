package io.imking.reward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.imking.reward.domain.RwAskTags;
import io.imking.reward.services.RwAskTagService;
import io.imking.utils.Result;

@RestController
@RequestMapping("/api/rwAskTag")
public class RwAskTagController {
	
    @Autowired
    private RwAskTagService rwAskTagService;

    /**
     *保存
     * @param rwAskTags
     */
    @PostMapping(value="/saveRwAskTag")
    public Result<Object> saveReAskTag(RwAskTags rwAskTags) {
    	Result<Object> result = new Result<Object>();
    	List<RwAskTags> list = rwAskTagService.queryRwAskTagsList(rwAskTags.getTagName());
    	String mesage = "";
    	if(list!=null&&list.size()!=0) {
    		mesage ="红包标签已经存在" ;
    	}else {
    		rwAskTagService.saveRwAskTags(rwAskTags);
    		mesage ="红包标签保存成功";
    	}
    	return result.ok(mesage);
    			
    }
    
   /**
    * 获取所有
    * @return
    */
    @GetMapping(value="/queryRwAskTagList")
    public Result<Object> queryRwAskTagList() {
    	Result<Object> result =  new Result<Object>();
    	List<RwAskTags> list = rwAskTagService.queryAllRwAskTags();
        return result.ok(list);
    }
}


