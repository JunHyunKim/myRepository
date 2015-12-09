package org.com.test;

import static org.junit.Assert.*;

import org.com.domain.ReplyVO;
import org.com.service.ReplyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class ReplyTest {
	private static final Logger logger = LoggerFactory.getLogger(ReplyTest.class);

	@Autowired
	private ReplyServiceImpl service;
	
	@Test
	public void testCreate() throws Exception{
		
		for(int i=0; i<10; i++){
			
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(100);
			vo.setReplytext("만들기 예제"+i);
			vo.setReplyer("테스트맨"+i);
			
			service.addReply(vo);
		}
	}
	
	@Test
	public void testModify() throws Exception{
		
		ReplyVO vo = new ReplyVO();
		
		vo.setReplytext("수정을확인");
		vo.setRno(2);
		
		service.modifyReply(vo);
	}

}
