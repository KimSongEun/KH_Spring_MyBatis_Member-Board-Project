package com.mycompany.myapp06.board.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp06.board.model.dao.BoardDao;
import com.mycompany.myapp06.board.model.vo.Board;

@Service("boardService")
public class BoardService {
	@Autowired
	private BoardDao boardDao;

	public List<Board> getBoardList(Board vo) {
//		System.out.println("BoardService getBoardList : " + vo);
		List<Board> volist = boardDao.getBoardList();
		System.out.println(volist);
		return volist;
	}
	public List<Board> getBoardListPaging(int offset, int pageSize) {
		return boardDao.getBoardListPaging(offset,pageSize);
	}
	
	public int insertBoard(Board b) {
		return boardDao.insertBoard(b);
	}
	
	public Board selectBoard(Board b) {
		return boardDao.selectBoard(b);
	}
	
	public int updateBoard(Board b) {
		return boardDao.updateBoard(b);
	}
}