package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.post.model.PostVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostServiceImplTest {
	private IPostService postService;
	private Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);
	
	@Before
	public void setUp() throws Exception {
		postService = new PostServiceImpl();
	}

	@Test
	public void testUpdateLevel() {
		/***Given***/
		List<PostVo> postList = postService.getAllPost();
		PostVo postVo = postList.get(0);
		postVo.setPost_level("1");
		
		/***When***/
		int updateCnt = postService.updateLevel(postVo);
		logger.debug("updateCnt : {}", updateCnt);
		
		/***Then***/
		assertEquals(1, updateCnt);

	}
	
	// 전체 게시글에 level 설정하기.
	@Test
	public void testUpdateAllLevel(){
		/***Given***/
		List<PostVo> postList = postService.getAllPost();
		List<PostVo> levelList = postService.getLevel();
		
		/***When***/
		int updateCnt = 0;
		
		for(int i = 0; i < postList.size(); i++){
			PostVo postVo = postList.get(i);
			
			String level = levelList.get(i).getPost_level();
			postVo.setPost_level(level);
			
			updateCnt += postService.updateLevel(postVo);
		}
		
		/***Then***/
		assertEquals(postList.size(), updateCnt);
		
	}
	
	@Test
	public void testUpdateGn(){
		/***Given***/
		List<PostVo> postList = postService.getAllPost();
		PostVo postVo = postList.get(0);
		postVo.setGn("1");
		
		/***When***/
		int updateCnt = postService.updateGn(postVo);
		logger.debug("updateCnt : {}", updateCnt);
		
		/***Then***/
		assertEquals(1, updateCnt);
				
	}
	
	// 전체 게시글에 gn 설정하기.
	@Test
	public void testUpdateAllGn(){
		/***Given***/
		List<PostVo> postList = postService.getAllPost();
		
		/***When***/
		int updateCnt = 0;
		
		for(PostVo postVo : postList){
			if(postVo.getPost_level().equals("1")){
				postVo.setGn(postVo.getPost_no());
				updateCnt += postService.updateGn(postVo);
			}else{
				int parent_post_no = Integer.valueOf(postVo.getParent_post_no());
				
				boolean flag = false;
				
				while(true){
					logger.debug("post_level : {} -> {}", postVo.getPost_no(), postList.get(parent_post_no - 1).getPost_level());
					
					// index -> (post_no - 1)... ...
					if(postList.get(parent_post_no - 1).getPost_level().equals("1") || flag){
						postVo.setGn(postList.get(parent_post_no - 1).getPost_no());	
						updateCnt += postService.updateGn(postVo);
						flag = false;
						break;
					}else{
						if(postList.get(parent_post_no - 1).getParent_post_no() == null){
							logger.debug("flag check");

							flag = true;
						}else{
							parent_post_no = Integer.valueOf(postList.get(parent_post_no - 1).getParent_post_no());
						}
					}
				}
				
			}
				
		}

		logger.debug("updateCnt : {}", updateCnt);
		
		/***Then***/
		assertEquals("", updateCnt);
		
	}

	@Test
	public void testGetPostCnt(){
		/***Given***/
		
		/***When***/
		int postCnt = postService.getPostCnt();
		logger.debug("postCnt : {}", postCnt);
		
		/***Then***/
		assertNotNull(postCnt);
		
	}
	
	@Test
	public void testInsertPost(){
		/***Given***/
		PostVo postVo = new PostVo();
		int postCnt = postService.getPostCnt();
		
		postVo.setPost_no(postCnt  + 1 + "");
		postVo.setUserid("m");
		postVo.setTitle("열두번째글");
		
		/***When***/
		int insertCnt = postService.insertPost(postVo);
		
		/***Then***/
		assertNotNull(insertCnt);

	}
	
	@Test
	public void testSelectPost(){
		/***Given***/
		String post_no = "2";
		
		/***When***/
		PostVo postVo = postService.selectPost(post_no);
		logger.debug("title : {}", postVo.getTitle());
		
		/***Then***/
		assertNotNull(postVo);

	}
	
	@Test
	public void testUpdatePost(){
		/***Given***/
		PostVo postVo = postService.selectPost("28");
		postVo.setTitle("123123");
		postVo.setContent("123123");
		
		/***When***/
		int updateCnt = postService.updatePost(postVo);
		
		/***Then***/
		assertNotNull(updateCnt);
		
	}
	
	
}


















