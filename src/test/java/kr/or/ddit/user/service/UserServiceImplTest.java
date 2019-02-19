package kr.or.ddit.user.service;

import static org.junit.Assert.*;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImplTest {

	private IUserService userService;
	private Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
	
	@Before
	public void setUp() throws Exception {
		userService = new UserServiceImpl();
	}

	@Test
	public void testSelectUser() {
		/***Given***/
		String userId = "brown1";
		
		/***When***/
		UserVo userVo = userService.selectUser(userId);
		if(userVo == null)
			logger.debug("userVo is null");
		
		logger.debug("userVo : {}", userVo.toString());

		/***Then***/
		assertNotNull(userVo);
		
	}

}
