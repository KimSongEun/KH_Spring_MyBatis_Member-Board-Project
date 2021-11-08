package com.mycompany.myapp06.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp06.board.model.service.BoardService;
import com.mycompany.myapp06.board.model.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	public ModelAndView getBoardList(ModelAndView mv) {
		System.out.println("Controller BoardController getBoardList");
		// 수업 임시 코드
		Board vo = new Board();
		// vo.setBoardNum(111);
		// vo.setBoardTitle("aaaa");
		List<Board> volist=boardService.getBoardList(vo);
		mv.addObject("volist", volist);
		mv.setViewName("board/boardlist");
		return mv;
	}
	
	 @RequestMapping(value="/boardlistPaging", method = RequestMethod.GET) 
	 public String getBoardListPaging(Model m) {
		 System.out.println("Controller BoardController getBoardListPaging");
//	 m.addAttribute("volist", boardService.getBoardListPaging(offset, pageNum));
	 return "board/boardlist"; 
	 }
	 
	@RequestMapping(value="/boardwrite", method = RequestMethod.GET)
	public String insertBoard(Model m) {
//		m.addAttribute("volist", boardService.insertBoard());
		return "board/";
	}
	
	@RequestMapping(value="/boardread", method = RequestMethod.GET)
	public String readBoard(Model m) {
		return "board/";
	}
	
	@RequestMapping(value="/boardupdate", method = RequestMethod.GET)
	public String updateBoard(Model m) {
		return "board/";
	}
}