package kr.or.ddit.attach_file.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.attach_file.model.Attach_fileVo;
import kr.or.ddit.post.service.PostServiceImplTest;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Attach_fileServiceImplTest {
	private Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);
	private IAttach_fileService attach_fileService;

	@Before
	public void setUp() throws Exception {
		attach_fileService = new Attach_fileServiceImpl();
	}

	@Test
	public void testGetAttach_fileCnt() {
		/***Given***/
		
		/***When***/
		int attach_fileCnt = attach_fileService.getAttach_fileCnt();
		
		/***Then***/
		assertNotNull(attach_fileCnt);

	}
	
	@Test
	public void testUpdateFileFlag(){
		/***Given***/
		List<Attach_fileVo> fileList = attach_fileService.getFileList("1");
		
		/***When***/
		int updateCnt = 0;
		for(Attach_fileVo attach_fileVo : fileList){
			attach_fileVo.setInsertflag("f");
			
			updateCnt = attach_fileService.updateFileFlag(attach_fileVo);
		}

		/***Then***/
		assertNotNull(updateCnt);

	}
	
	

}










