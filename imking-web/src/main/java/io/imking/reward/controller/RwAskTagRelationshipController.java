package io.imking.reward.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.imking.reward.domain.RwAskTagRelationship;
import io.imking.reward.services.RwAskTagRelationshipService;
import io.imking.utils.Result;

@RestController
@RequestMapping("/api/rwAskTagRelationship")
public class RwAskTagRelationshipController {
	
    @Autowired
    private RwAskTagRelationshipService rwAskTagRelationshipService;

    /**
     *保存
     * @param rwAskTags
     */
    @PostMapping(value="/saveRwAskTagRelationship")
    public Result<Object> saveRwAskTagRelationship(String rwAskTagIds,Integer rwAskId) {
    	Result<Object> result = new Result<Object>();
    	rwAskTagRelationshipService.deleteRwAskTagRelationshipList(rwAskId);
    	String [] tagIds = rwAskTagIds.split(",");
    	List<RwAskTagRelationship> list = new ArrayList<>();
    	for(int i =0;i< tagIds.length;i++) {
    		RwAskTagRelationship rwAskTagRelationship = new RwAskTagRelationship();
    		rwAskTagRelationship.setTagId(Integer.valueOf(tagIds[i]));
    		rwAskTagRelationship.setRwAskId(rwAskId);
    		list.add(rwAskTagRelationship);
    	}
    	rwAskTagRelationshipService.saveRwAskTags(list);
    	return result.ok("保存成功");			
    }
    
    @GetMapping(value="/queryRwAskTagRelationshipList")
    public Result<Object> queryRwAskTagRelationshipList(Integer rwAskId){
    	Result<Object> result = new Result<Object>();
    	List<RwAskTagRelationship> list = rwAskTagRelationshipService.queryRwAskTagRelationshipList(rwAskId);
    	return result.ok(list);
    }
}
