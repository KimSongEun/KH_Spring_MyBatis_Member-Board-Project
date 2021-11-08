package com.mycompany.myapp06.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp06.board.model.vo.Board;

@Repository("boardDao")
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;

	public List<Board> getBoardList() {
		System.out.println("BoardDao getBoardList");
//		return sqlSession.selectList("BoardNS.baordlistRM");
//		return sqlSession.selectList("BoardNS.boardlistHM");
		Map<String, Object> map1 = new HashMap<String, Object>();
//		map1.put("bt",  "제목");
//		map1.put("bw",  "sese");
//		map1.put("bc",  "내용");
//		return sqlSession.selectList("BoardNS.searchBoardlist", map1);
//		return sqlSession.selectList("BoardNS.searchBoardlist2", map1);

		map1.put("category", "작성자"); // 작성자 // 내용 // 전체 // 제목
		map1.put("searchValue", "sese");
		return sqlSession.selectList("BoardNS.searchBoardList3", map1);
	}

	public List<Board> getBoardListPaging(int offset, int pageSize) {
		RowBounds rbounds = new RowBounds(offset, pageSize);
		return sqlSession.selectList("Board.boardlist", null, rbounds);
	}
	
	public int insertBoard(Board b) {
		return sqlSession.insert("BoardNS.insertBoard", b);
	}
	
	public Board selectBoard(Board b) {
		return sqlSession.selectOne("BoardNS.boarddetail", b); 
	}
	
	public int updateBoard(Board b) {
		return sqlSession.update("BoardNS.updateBoard", b);
	}
	
}