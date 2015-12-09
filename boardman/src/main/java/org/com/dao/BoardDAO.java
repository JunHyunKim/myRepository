package org.com.dao;

import java.util.List;

import org.com.domain.BoardVO;
import org.com.domain.Criteria;

public interface BoardDAO {

	public List<BoardVO> listAll()throws Exception;
	
	public List<BoardVO> listPage(Criteria cri)throws Exception;
	
	public void create(BoardVO vo)throws Exception;
	
	public BoardVO read(int bno)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(int bno)throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
	
	public void updateReplyCnt(Integer bno, int amount)throws Exception;
	
	public void updateViewCnt(Integer bno)throws Exception;
	
	
	
}
