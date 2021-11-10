package com.mycompany.myapp06.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myapp06.board.model.dao.BoardDao;
import com.mycompany.myapp06.board.model.vo.Board;

@Service("boardService")
//@Transactional(rollbackFor=Exception.class)
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;

	public int getListCount() throws Exception {
		return boardDao.getListCount();
	}
	
	public List<Board> getBoardList(Board vo) throws Exception {
//		System.out.println("BoardService getBoardList : " + vo);
		List<Board> volist = null;
		try {
			volist = boardDao.getBoardList();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println(volist);
		return volist;
	}
	public List<Board> getBoardListPaging(int offset, int pageSize) throws Exception {
		return boardDao.getBoardListPaging(offset,pageSize);
	}
	
	@Override
	public int insertBoard(Board b) throws Exception {
		return boardDao.insertBoard(b);
	}
	
	public Board selectBoard(Board b) throws Exception {
		return boardDao.selectBoard(b);
	}
	
	@Override
	public int updateBoard(Board b) throws Exception {
		return boardDao.updateBoard(b);
	}

	@Override
	public List<Board> searchBoardList(Board vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBoard(Board vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
