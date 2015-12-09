package org.com.test;

import static org.junit.Assert.*;

import org.com.domain.Criteria;
import org.com.service.BoardService;
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

public class BoardServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardService service;
	
	@Test
	public void test() throws Exception {
		logger.info("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		Criteria cri = new Criteria();
		cri.setPageNo(2);
		cri.setPerPage(20);
		
		logger.info(service.listPage(cri).toString());
	}

}
