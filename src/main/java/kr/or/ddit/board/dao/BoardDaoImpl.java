package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.apache.ibatis.session.SqlSession;

public class BoardDaoImpl implements IBoardDao {

	/**
	 * 
	 * Method : getAllBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 모든 게시판 조회.
	 */
	@Override
	public List<BoardVo> getAllBoard(SqlSession sqlSession) {
		List<BoardVo> boardList = sqlSession.selectList("board.getAllBoard");
		
		return boardList;
	}

	/**
	 * 
	 * Method : updateBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 정보 수정
	 */
	@Override
	public int updateBoard(SqlSession sqlSession, BoardVo boardVo) {
		int updateCnt = sqlSession.update("board.updateBoard", boardVo);
		
		return updateCnt;
	}

	/**
	 * 
	 * Method : selectBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param board_nm
	 * @return
	 * Method 설명 : board_nm으로 게시판 조회.
	 */
	@Override
	public BoardVo selectBoard(SqlSession sqlSession, String board_nm) {
		BoardVo boardVo = sqlSession.selectOne("board.selectBoard", board_nm);
		
		return boardVo;
	}

}
