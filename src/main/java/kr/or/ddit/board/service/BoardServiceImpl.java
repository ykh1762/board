
package kr.or.ddit.board.service;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
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
	public List<BoardVo> getAllBoard() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardVo> boardList = boardDao.getAllBoard(sqlSession); 
		sqlSession.close();
		
		return boardList;
	}

	/**
	 * 
	 * Method : updateBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 정보 수정.
	 */
	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int updateCnt = boardDao.updateBoard(sqlSession, boardVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}

	/**
	 * 
	 * Method : selectBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param board_nm
	 * @return
	 * Method 설명 : board_nm으로 게시판 조회.
	 */
	@Override
	public BoardVo selectBoard(String board_nm) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		BoardVo boardVo = boardDao.selectBoard(sqlSession, board_nm);
		
		sqlSession.close();
		
		return boardVo;
	}

}
