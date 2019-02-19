package kr.or.ddit.post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.PostVo;

public interface IPostService {
	/**
	 * 
	 * Method : getAllPost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시글 조회.
	 */
	List<PostVo> getAllPost();

	/**
	 * 
	 * Method : getLevel
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 level 구하기.
	 */
	List<PostVo> getLevel();
	
	/**
	 * 
	 * Method : updateLevel
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 level 설정.
	 */
	int updateLevel(PostVo postVo);
	
	/**
	 * 
	 * Method : updateGn
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글에 gn 설정.
	 */
	int updateGn(PostVo postVo);
	
	/**
	 * 
	 * Method : getEditList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 답글에 따른 순서변경, 제목 변경된 리스트 조회.
	 */
	List<PostVo> getEditList(String board_no);
	
	/**
	 * 
	 * Method : getPostCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 게시글 수 조회.
	 */
	int getPostCnt();
	
	/**
	 * 
	 * Method : insertPost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 등록
	 */
	int insertPost(PostVo postVo);
	
	/**
	 * 
	 * Method : selectPost
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : 특정 게시글 조회.
	 */
	PostVo selectPost(String post_no);	
	
	
	
}












