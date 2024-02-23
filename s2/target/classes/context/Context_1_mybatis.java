package context;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class Context_1_mybatis {
	
	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("test_pm");
		ds.setPassword("1111");
		return ds;
	}
	
	// SqlSessionFactoryBean�� �������� FactoryBean �������̽��� �����Ѵ�
	// �̼����� �������� SqlSessionFactoryBean ��ü�� �����ϴ� ���� �ƴ϶�
	// Factory���� getObject()�޼��带 ȣ���� ����� �����Ѵ�.
	// �� ��� �������� ���ø����̼� ���� �������� SqlSessionFactory�� �����ϰ�
	// sqlSessionFactory��� �̸����� �����Ѵ�.
	
	@Bean
	public SqlSessionFactory factioryBean(DataSource ds) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds);
		
		// �߰����� Mybatis ����
		factoryBean.setConfigLocation(new ClassPathResource("config/mybatis/mybatis-config.xml"));
		return factoryBean.getObject();
	}
	
	
	// Mybatis������ SqlSession�� �����ϱ� ���� SqlSessionFactory�� ����Ѵ�.
	// Session�� �ѹ� �� �����ϸ� ���α����� �����ϰų� commit �Ǵ� rollback�� ����ϱ� ���� session�� ����� �� �ִ�.
	// ���������� �� �̻� �ʿ����� ����  ���°� �Ǹ� Session�� �ݴ´�.
	// Mybatis Spring ��������� ����ϸ� SqlSessionFactory�� ���� ����� �ʿ䰡 ����.
	// �ֳ��ϸ�, ������ Ʈ����� ������ ���� �ڵ����� Ŀ�� �Ǵ� �ѹ��� �����ϱ� �����̴�.
	
	// SqlSessionTemplateŬ������ SqlSession�� implements�ϰ� �ڵ忡�� SqlSession�� ��ü�ϴ� ������ �Ѵ�.
	// SQL�� ó���ϴ� Mybatis Method�� ȣ���� �� SqlSession�� ������ Spring tracsaction���� ���� �� �ֵ��� �������ش�.
	// SqlSessionTemplate�� �ʿ��� �������� Session�� �ݰ�, Commit�ϰų� Rollback�ϴ� ���� ������ Session�� ����������Ŭ�� �����Ѵ�.
	
	
	@Bean
	public SqlSessionTemplate sessionTemplate(SqlSessionFactory factoryBean) {
		return new SqlSessionTemplate(factoryBean);
	}
}
