package org.com.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

public class SettingTesters {
	private static final Logger logger = LoggerFactory.getLogger(SettingTesters.class);

	@Autowired
	private DataSource ds;

	@Autowired
	private SqlSessionFactory sqlFactory;
	
	
	@Test
	public void mybatisTest(){
		logger.info("====================================");
		logger.info(sqlFactory.toString());
		logger.info("====================================");

		SqlSession session = sqlFactory.openSession();
		logger.info("====================================");
		logger.info(session.toString());
		logger.info("====================================");
		
	}
	
	@Test
	public void dataSourceTest() throws Exception {
		logger.info("====================================");
		logger.info(ds.toString());
		logger.info("====================================");
		
		Connection con = ds.getConnection();
		
		logger.info("====================================");
		logger.info(con.toString());
		logger.info("====================================");
	}

}
