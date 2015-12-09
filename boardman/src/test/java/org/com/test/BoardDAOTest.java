package org.com.test;

import static org.junit.Assert.*;

import org.com.dao.BoardDAO;
import org.com.domain.BoardVO;
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

public class BoardDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("이것은 JUNIT 테스트케이스를 통해 만들어졌다." );
		vo.setContent("DAO설정을 마친 후 제이유닛으로 테스트코드를 작성한것이다.");
		vo.setWriter("김준현");
		dao.create(vo);
	}
	
	@Test
	public void testRead() throws Exception{
		logger.info("-----------------------------------------------");
		logger.info(dao.read(10).toString());
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setBno(0);
		vo.setTitle("JUnit으로 업데이트가 정상작동하는지 테스트해봄." );
		vo.setContent("DAO설정을 마친 후 제이유닛으로 테스트코드를 작성한것이다.");
		dao.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception{
		
	}
	
	@Test
	public void testList() throws Exception{
		
	}
	


}
