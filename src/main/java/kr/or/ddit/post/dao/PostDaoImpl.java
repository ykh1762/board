package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.PostVo;

public class PostDaoImpl implements IPostDao {
	/**
	 * 
	 * Method : postList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시글 조회.
	 */
	@Override
	public List<PostVo> getAllPost(SqlSession sqlSession) {
		List<PostVo> postList = sqlSession.selectList("post.getAllPost");

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
	public List<PostVo> getLevel(SqlSession sqlSession) {
		List<PostVo> postList = sqlSession.selectList("post.getLevel"); 
		
		return postList;
	}

	/**
	 * 
	 * Method : updateLevel
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 게시글에 level 설정.
	 */
	@Override
	public int updateLevel(SqlSession sqlSession, PostVo postVo) {
		int updateCnt = sqlSession.update("post.updateLevel", postVo);
		
		return updateCnt;
	}
	
	/**
	 * 
	 * Method : updateGn
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글에 gn 설정.
	 */
	@Override
	public int updateGn(SqlSession sqlSession, PostVo postVo) {
		int updateCnt = sqlSession.update("post.updateGn", postVo);
		
		return updateCnt;
	}

	/**
	 * 
	 * Method : getEditList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 답글에 따른 순서변경, 제목 변경된 리스트 조회.
	 */
	@Override
	public List<PostVo> getEditList(SqlSession sqlSession, String board_no) {
		List<PostVo> editList = sqlSession.selectList("post.getEditList", board_no);
		
		return editList;
	}

	/**
	 * 
	 * Method : insertPost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 등록.
	 */
	@Override
	public int insertPost(SqlSession sqlSession, PostVo postVo) {
		int insertCnt = sqlSession.insert("post.insertPost", postVo);
		
		return insertCnt;
	}

	/**
	 * 
	 * Method : getPostCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 게시글 수 조회.
	 */
	@Override
	public int getPostCnt(SqlSession sqlSession) {
		int postCnt = sqlSession.selectOne("post.getPostCnt");
		
		return postCnt;
	}

	/**
	 * 
	 * Method : selectPost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param post_no
	 * @return
	 * Method 설명 : 특정 게시글 조회.
	 */
	@Override
	public PostVo selectPost(SqlSession sqlSession, String post_no) {
		PostVo postVo = sqlSession.selectOne("post.selectPost", post_no);
		
		return postVo;
	}

}
