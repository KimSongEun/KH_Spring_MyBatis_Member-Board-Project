package com.mycompany.myapp06.board.model.service;

import java.util.List;

import com.mycompany.myapp06.board.model.vo.Board;

public interface BoardService {
	
	public List<Board> getBoardList(Board vo) throws Exception;
	public List<Board> searchBoardList(Board vo) throws Exception;
	
	public int insertBoard(Board vo) throws Exception;
	
	public int updateBoard(Board vo) throws Exception;
	
	public int deleteBoard(Board vo) throws Exception;
	public int deleteBoard(int bno) throws Exception;
	
}