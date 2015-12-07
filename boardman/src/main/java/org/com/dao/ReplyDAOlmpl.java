package org.com.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.com.domain.BoardVO;
import org.com.domain.Criteria;
import org.com.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOlmpl implements ReplyDAO {

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

	
}
