package kr.or.ddit.post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.post.dao.IPostDao;
import kr.or.ddit.post.dao.PostDaoImpl;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.user.model.UserVo;

public class PostServiceImpl implements IPostService {
	private IPostDao postDao;
	
	public PostServiceImpl() {
		postDao = new PostDaoImpl();
	}
	
	/**
	 * 
	 * Method : getAllPost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모든 게시글 조회.
	 */
	@Override
	public List<PostVo> getAllPost() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<PostVo> postList = postDao.getAllPost(sqlSession);
		sqlSession.close();
		
		return postList;
	}

	/**
	 * 
	 * Method : getLevel
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 게시글 level 구하기.
	 */
	@Override
	public List<PostVo> getLevel(){
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<PostVo> levelList = postDao.getLevel(sqlSession);
		sqlSession.close();
		
		return levelList;
	}
	
	/**
	 * 
	 * Method : updateLevel
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 level 설정.
	 */
	@Override
	public int updateLevel(PostVo postVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		
		int updateCnt = postDao.updateLevel(sqlSession, postVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}

	/**
	 * 
	 * Method : updateGn
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글에 gn 설정.
	 */
	@Override
	public int updateGn(PostVo postVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		
		int updateCnt = postDao.updateGn(sqlSession, postVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}

	/**
	 * 
	 * Method : getEditList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 답글에 따른 순서변경, 제목 변경된 리스트 조회.
	 */
	@Override
	public List<PostVo> getEditList(String board_no) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<PostVo> editList = postDao.getEditList(sqlSession, board_no);
		sqlSession.close();
		
		return editList;
	}

	/**
	 * 
	 * Method : getPostCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시글 수 조회.
	 */
	@Override
	public int getPostCnt() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int postCnt = postDao.getPostCnt(sqlSession);
		sqlSession.close();

		return postCnt;
	}

	/**
	 * 
	 * Method : insertPost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 등록
	 */
	@Override
	public int insertPost(PostVo postVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int insertCnt = postDao.insertPost(sqlSession, postVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	/**
	 * 
	 * Method : selectPost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : 특정 게시글 조회.
	 */	
	@Override
	public PostVo selectPost(String post_no) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		PostVo postVo = postDao.selectPost(sqlSession, post_no);
		
		sqlSession.close();
		
		return postVo;
	}

	/**
	 * 
	 * Method : updatePost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 수정.
	 */
	@Override
	public int updatePost(PostVo postVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int updateCnt = postDao.updatePost(sqlSession, postVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}
	
}















