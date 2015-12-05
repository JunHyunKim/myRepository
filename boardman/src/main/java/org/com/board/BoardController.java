package org.com.board;

import org.com.domain.BoardVO;
import org.com.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGet(BoardVO vo, Model model)throws Exception{
		logger.info("register get.................");
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPost(BoardVO vo, Model model)throws Exception{
		logger.info("register post.................");
		logger.info(vo.toString());
		
		service.regist(vo);
		
		model.addAttribute("result", "success");
		return "/board/success";
	}
	
}
