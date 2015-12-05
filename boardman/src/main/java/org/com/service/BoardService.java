package org.com.service;

import java.util.List;

import org.com.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> listAll()throws Exception;
	
	public void regist(BoardVO vo)throws Exception;
	
	public BoardVO view(int bno)throws Exception;
	
	public void modify(BoardVO vo)throws Exception;
	
	public void remove(int bno)throws Exception;
	
}
