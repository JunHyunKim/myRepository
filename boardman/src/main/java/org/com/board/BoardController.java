package org.com.board;

import org.com.domain.BoardVO;
import org.com.domain.Criteria;
import org.com.domain.PageMaker;
import org.com.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String registPost(BoardVO vo, RedirectAttributes rttr)throws Exception{
		logger.info("regist post.................");
		logger.info(vo.toString());
		
		service.regist(vo);
		
//		model.addAttribute("result", "success");
//		return "/board/success";
		rttr.addFlashAttribute("msg", "success");		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		logger.info("show all list........");
//		model.addAttribute("list",service.listAll());
	}
	
	@RequestMapping(value="/listpage", method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model)throws Exception{
		logger.info("show paging list........");
		model.addAttribute("list",service.listPage(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(131);
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model)throws Exception{
		model.addAttribute(service.view(bno));
	}
	
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr)
	throws Exception{
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model)throws Exception{
		model.addAttribute(service.view(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO vo, RedirectAttributes rttr)throws Exception{
		logger.info("mod post........");
		
		service.modify(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
}
