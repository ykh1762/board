package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.PostVo;

public interface IPostDao {
	/**
	 * 
	 * Method : postList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시글 조회.
	 */
	List<PostVo> getAllPost(SqlSession sqlSession);
	
	/**
	 * 
	 * Method : getLevel
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 게시글 level 구하기.
	 */
	List<PostVo> getLevel(SqlSession sqlSession);
	
	/**
	 * 
	 * Method : updateLevel
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 게시글에 level 설정.
	 */
	int updateLevel(SqlSession sqlSession, PostVo postVo);

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
	int updateGn(SqlSession sqlSession, PostVo postVo);
	
	/**
	 * 
	 * Method : getEditList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 답글에 따른 순서변경, 제목 변경된 리스트 조회 + 해당 게시판(board_no).
	 */
	List<PostVo> getEditList(SqlSession sqlSession, String board_no);
	
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
	int insertPost(SqlSession sqlSession, PostVo postVo);

	/**
	 * 
	 * Method : getPostCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 게시글 수 조회.
	 */
	int getPostCnt(SqlSession sqlSession);
	
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
	PostVo selectPost(SqlSession sqlSession, String post_no);
}











