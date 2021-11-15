package com.mycompany.myapp06.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp06.board.model.service.BoardService;
import com.mycompany.myapp06.board.model.vo.Board;
import com.mycompany.myapp06.member.model.vo.Member;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;  // List = Arraylist 처럼 BoardService에 Impl 클래스 넣는 형태로 이렇게 작성함.
										// interface를 넣어줘도 된다. BoardServiceImpl을 써도 되지만 interface 쓰는게 일반적.

	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	public ModelAndView getBoardList(ModelAndView mv
			//, @RequestParam(name="msg") String msg
			//, @RequestParam(name="pagenum") int pagenum
			// , @RequestParam(name="boardVo") Board bvo
			) {
		System.out.println("Controller BoardController getBoardList");
		Board vo = new Board();
		String viewpage = "";
		// 수업 임시 코드
		// vo.setBoardNum(111);
		// vo.setBoardTitle("aaaa");
		List<Board> volist = null;
		try {
		volist = boardService.getBoardList(vo);
		viewpage = "board/boardlist";
		mv.addObject("volist", volist);
//		mv.setViewName("board/boardlist");
		} catch (Exception e) {
			viewpage = "error/commonError";
			mv.addObject("msg", "게시글 읽기에 문제가 발생하였습니다. 페이지를 다시 열어주세요.");
			mv.addObject("url", "boardlist"); // 티나게하려고 지금 boardlist적은거지 원래는 /적거나 "" 공백으로!!
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}

	@RequestMapping(value = "/boardlistpaging", method = RequestMethod.GET)
	public ModelAndView getBoardListPaging(ModelAndView mv) {
		System.out.println("Controller BoardController getBoardListPaging");
//		int currentPage = 1;
//		int limit = 2;
//		int listCount = boardService.getListCount();
//		int maxPage = (int) ((double) listCount / limit + 0.9);
//		int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
//		int endPage = startPage + limit - 1;
//		if (maxPage < endPage) endPage = maxPage;
//		List<Board> list = boardService.getBoardListPaging(currentPage, limit);
//		if(list != null && list.size() > 0) {
//			mv.addObject("list", list);
//			mv.addObject("currentPage", currentPage);
//			mv.addObject("maxPage", maxPage);
//			mv.addObject("startPage", startPage);
//			mv.addObject("endPage", endPage);
//			mv.addObject("listCount", listCount);
//			mv.setViewName("board/boardlistpaging");
//		}
		return mv;
	}

	/*
	 * @RequestMapping(value = "/boardwrite", method = RequestMethod.GET) public
	 * ModelAndView insertBoard(ModelAndView mv) { String viewpage = ""; Board vo =
	 * new Board(); try { int result = boardService.insertBoard(vo); viewpage =
	 * "commonAlert"; mv.addObject("msg", "글이 등록되었습니다."); mv.addObject("url",
	 * "boardlist"); } catch (Exception e) { viewpage = "error/commonError";
	 * mv.addObject("msg", "게시글 읽기에 문제가 발생하였습니다. 페이지를 다시 열어주세요.");
	 * mv.addObject("url", "boardlist"); // 티나게하려고 지금 boardlist적은거지 원래는 /적거나 ""
	 * 공백으로!! e.printStackTrace(); } return mv; }
	 */

	@RequestMapping(value = "/boardread", method = RequestMethod.GET)
	public String readBoard(Model m) {
		return "board/";
	}

	@RequestMapping(value = "/boardupdate", method = RequestMethod.GET)
	public String updateBoard(Model m) {
		return "board/";
	}
	
	@RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
	public ModelAndView write(ModelAndView mv) {
		mv.setViewName("board/boardwrite");
		return mv;
	}
	@RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
	// 이렇게 request로 실려온 애들(req) 중에 읽고싶은 모양(bvo)이 있다면 담아줄께. 그러면 스프링일 필드 이름과 똑같이 하면 알아서 담아주는 것이다.  
	public ModelAndView doWrite(@RequestParam(name="boardNum") int bnum
			, ModelAndView mv
			// , HttpServletRequest req
			, Board bvo
			, Member mvo
			, @RequestParam("report") MultipartFile report // 방법1 : new 방법, 제일 편함
			, MultipartHttpServletRequest multiReq // 방법2 : 예전방법, 이 안에는 boardNum도 꺼낼 수 있고 그런 식
			) { // Board, Member에 각각 잘 채워진다. 
//		request.getParameter("title"); // 예전에 이걸로 꺼냈다. 예전엔 doGet, doPost가 있어서 인자로 있었다. 그래서 request 안에 Tomcat에서 전달 받은 데이터를 다 넣어주는데 이제는 request가 없다. 
//		Board vo = new Board();
		// req.getParameter("title"); // 이렇게 하면 Post 방식으로 넘어온 것이 있다.
		// Board bvo를 가지고 들어오면 밑의 것을 다 없애도 된다. 단, 이 아이들은 다 채워졌는지 아닌지는 sysout ("req bvo : " +bvo)를 찍어야 알 수 있다. Aop를 활용하면 다 찍힌다.
//		vo.setBoardTitle(req.getParameter("boardTitle"));
//		vo.setBoardContent(req.getParameter("boardContent"));
//		System.out.println("req vo : " + vo); // 이건 title과 content에 잘 들어왔다. 
		System.out.println("req bvo : " + bvo); // 모양은 갖추고 있지만 안이 다 null 또는 0이다. 따라서 boardwrite에서 boardTitle, boardContent로 name을 설정!! vo 필드 이름을 설정하는 것.
		//  그럼 만약 readCount가 int 형인데 그걸 넘겨준다면?? 그걸 해주나?? 해준다!!!!! parseInt까지도 해준다. 와우 bravo!!
		// 날짜는? 날짜도 포멧 꽤 맞춰서 들어오는데 어차피 화면단에서 날짜 입력하는 것은 따로 있기 때문에 vo에서 Date 작성안하는걸 추천한다. String 쓰는걸 추천!!!!!!!!
		// 그럼 완벽?? Nope.... 숫자에다가 문자까지 해서 오면 ReadCount에 값이 결코 들어갈 수 없따!!!!! 아예 bvo 조차도 안뜬다. 즉, 진입 조차 못한다는 것이다. 그게 맹점이다. 진입안하고 멍하니 멈춰있다. 그래서 우리는 항상 doWrite로 잘 진입했는가를 보고 확인해야함!!
		// ㄴ이걸 막아줘야한다. jsp안에서 유효성 검사로!!!! boardwrite.jsp로 go!!
		MultipartFile upfile2 = multiReq.getFile("report"); // 방법2 : 예전방식
		//--------------------
		// 예전코드
		if(bnum==0) {
			// 새글쓰기
		} // 아니라면 수정하기
		//--------------------
		
		try {
			boardService.insertBoard(bvo);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		mv.addObject("msg", "리다이렉트방식으로도 메시지가 전달됩니다."); // ? 뒤에 실려감
		mv.addObject("pagenum", "1");
//		mv.addObject("boardVo", String.valueOf(bvo));
		mv.setViewName("redirect:/boardlist"); // get방식
		return mv;
	}
}