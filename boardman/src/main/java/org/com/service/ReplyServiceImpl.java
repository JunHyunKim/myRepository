package org.com.service;

import java.util.List;

import javax.inject.Inject;

import org.com.dao.BoardDAO;
import org.com.dao.ReplyDAO;
import org.com.domain.Criteria;
import org.com.domain.ReplyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService {

	private static final Logger log = LoggerFactory.getLogger(ReplyServiceImpl.class);
	
	@Inject
	private ReplyDAO rDao;
	
	@Inject
	private BoardDAO bDao;
	
	
	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return rDao.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		rDao.update(vo);
	}

	@Transactional
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		log.info("=================================================");
		log.info(vo.toString());
		rDao.create(vo);
		bDao.updateReplyCnt(vo.getBno(), 1);
		log.info("=================================================");
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {
		int bno = rDao.getBno(rno);
		rDao.delete(rno);
		bDao.updateReplyCnt(bno, -1);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return rDao.listPage(bno, cri);
	}

	@Override
	public int count(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return rDao.count(bno);
	}

}
