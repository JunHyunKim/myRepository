package org.com.service;

import java.util.List;

import org.com.domain.BoardVO;
import org.com.domain.Criteria;

public interface BoardService {

	//public List<BoardVO> listAll()throws Exception;
	
	public List<BoardVO> listPage(Criteria cri)throws Exception;
	
	public void regist(BoardVO vo)throws Exception;
	
	public BoardVO view(int bno)throws Exception;
	
	public void modify(BoardVO vo)throws Exception;
	
	public void remove(int bno)throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
	
	public List<BoardVO> listSearchPage(Criteria cri)throws Exception;
	
	public int listSearchCount(Criteria cri)throws Exception;
	
}
