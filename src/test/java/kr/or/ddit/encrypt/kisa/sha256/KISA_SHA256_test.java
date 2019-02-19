package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256_test {
	private Logger logger = LoggerFactory.getLogger(KISA_SHA256_test.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEncrypt() {
		/***Given***/
		String str = "moon1234";
		String str2 = "m";
		
		/***When***/
		String encryptStr = KISA_SHA256.encrypt(str2);
		logger.debug("encryptStr : {}", encryptStr);
		
		/***Then***/
		assertEquals("62c66a7a5dd7c3146618063c344e531e6d4b59e37988443ce962b3abd63c5a", encryptStr);
		
	}

}
