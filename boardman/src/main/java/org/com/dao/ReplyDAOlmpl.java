package org.com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.com.domain.Criteria;
import org.com.domain.ReplyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOlmpl implements ReplyDAO {


	private static final Logger logger = LoggerFactory.getLogger(ReplyDAOlmpl.class);
	
	@Inject
	private SqlSession session;
	
	private  static String namespace = "org.com.dao.ReplyDAO";
	
	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		return session.selectList(namespace+".list",bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		System.out.println("?");
		session.insert(namespace+".create",vo);
		System.out.println("나갔다.");
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		session.update(namespace+".update",vo);

	}

	@Override
	public void delete(Integer rno) throws Exception {
		session.delete(namespace+".delete",rno);

	}

	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		logger.info("------------------------------------------------");
		logger.info(paramMap.toString());
		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".count", bno);
	}

	@Override
	public int getBno(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getBno", rno);
	}

	
}
