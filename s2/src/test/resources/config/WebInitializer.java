package config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import context.Context_1_mybatis;
import context.Context_2_dao;
import context.Context_3_FileUpload;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	//AbstractAnnotationConfigDispatcherServletInitializer
	// 스프링에서 제공하는 클래스로 웹 어플리케이션의 초기화를 위한 편리한 방법을 제공한다.
	// 이 클래스를 사용하면 자바 기반 설정 클래스를 이용하여 DispatcherSevlet 및 ContextLoaderListener를 이용할 수 있다.
	// 이를 통해 web.xml을 사용하지 않고도 웹 어플리케이션의 초기화를 설정할 수 있다.
	// 해당 클래스를 상속받아 필요한 설정을 오버라이딩 하여 사용한다.
	
	// 프로젝트 모델영역 설정을 담당
	// 데이터페이스 연결풀(DBCP), Mybatis, Mybatis매퍼와 같은 로직 설정파일을 담당하는 메서드
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {Context_1_mybatis.class, Context_2_dao.class, Context_3_FileUpload.class};
	}
	
	//.class : 클래스 리터럴
	// 클래스 그 자체를 참조하는 구문
	// Class clazz = String.class;
	
	
	// DispatcherServlet 이 사용할 설정클래스를 반환
	// SpringMVC 웹 영역 설정을 담당
	// View와 Controller 관련 설정을 담당하는 메서드
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletContext.class};
	}
	
	
	// DispatcherServlet의 URL패턴을 지정
	// 모든요청을 처리하도록 "/"로 설정되어 있다.
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	
	// filter
	// client의 요청이 servlet에 도달하기 전이나 후에 요청 및 응답 데이터를 
	// 변형하거나 추가 작업을 수행하는데 사용되는 자바 컴포넌트를 의미
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("utf-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter [] {characterEncodingFilter};
	}
	
}
