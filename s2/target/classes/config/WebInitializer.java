package config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import context.Context_1_mybatis;
import context.Context_2_dao;
import context.Context_3_FileUpload;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	//AbstractAnnotationConfigDispatcherServletInitializer
	// ���������� �����ϴ� Ŭ������ �� ���ø����̼��� �ʱ�ȭ�� ���� ���� ����� �����Ѵ�.
	// �� Ŭ������ ����ϸ� �ڹ� ��� ���� Ŭ������ �̿��Ͽ� DispatcherSevlet �� ContextLoaderListener�� �̿��� �� �ִ�.
	// �̸� ���� web.xml�� ������� �ʰ� �� ���ø����̼��� �ʱ�ȭ�� ������ �� �ִ�.
	// �ش� Ŭ������ ��ӹ޾� �ʿ��� ������ �������̵� �Ͽ� ����Ѵ�.
	
	// ������Ʈ �𵨿��� ������ ���
	// ���������̽� ����Ǯ(DBCP), Mybatis, Mybatis���ۿ� ���� ���� ���������� ����ϴ� �޼���
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {Context_1_mybatis.class, Context_2_dao.class, Context_3_FileUpload.class};
	}
	
	//.class : Ŭ���� ���ͷ�
	// Ŭ���� �� ��ü�� �����ϴ� ����
	// Class clazz = String.class;
	
	
	// DispatcherServlet �� ����� ����Ŭ������ ��ȯ
	// SpringMVC �� ���� ������ ���
	// View�� Controller ���� ������ ����ϴ� �޼���
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletContext.class};
	}
	
	
	// DispatcherServlet�� URL������ ����
	// ����û�� ó���ϵ��� "/"�� �����Ǿ� �ִ�.
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	
	// filter
	// client�� ��û�� servlet�� �����ϱ� ���̳� �Ŀ� ��û �� ���� �����͸� 
	// �����ϰų� �߰� �۾��� �����ϴµ� ���Ǵ� �ڹ� ������Ʈ�� �ǹ�
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("utf-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter [] {characterEncodingFilter};
	}
	
}
