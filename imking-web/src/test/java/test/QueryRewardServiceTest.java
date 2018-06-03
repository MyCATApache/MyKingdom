package test;

import io.imking.MyKingdomApp;
import io.imking.reward.beans.dto.RwApplyDetailDTO;
import io.imking.reward.services.QueryRewardService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MyKingdomApp.class)
public class QueryRewardServiceTest {
	@Autowired
	private QueryRewardService queryRewardService;
	
	@Test
	public void testQueryRewardService(){
		PageInfo<RwApplyDetailDTO> page = queryRewardService.getMyParticipates(1, 1, 10);
		System.out.println(page);
	}
}
