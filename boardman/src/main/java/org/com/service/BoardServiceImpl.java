package org.com.service;

import java.util.List;

import org.com.dao.BoardDAO;
import org.com.domain.BoardVO;
import org.com.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
//	@Override
//	public List<BoardVO> listAll() throws Exception {
//		// TODO Auto-generated method stub
//		return dao.listAll();
//	}

	@Override
	public void regist(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public BoardVO view(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void remove(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearchPage(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}

}
