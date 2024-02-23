package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.korea.s2.MemberController;

import service.MemberService;

//import com.korea.board.BoardController;
//
//import dao.BoardDAO;
//import service.BoardService;

@Configuration
@EnableWebMvc
// Enable�� �����ϴ� ������̼��� @Configuration�� ���� ����Ŭ������ �������� �� �̿� ���õ� ��ɵ��� ���ϰ� ����
// ������̼� ����� SpringMVC�� ������ �� �ʿ��� Bean �������� �ڵ����� ���ִ� ������̼�
//@ComponentScan(basePackages={"com.korea.json","dao"})//�������� ������Ʈ��ĵ�ϱ����� ��
// @component, streotype(@service, @repository, @controller)������̼��� �ο��� Class���� 
// �ڵ����� Scan�Ͽ� Bean���� ������ִ� ������ �ϴ� ������̼�
public class ServletContext implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
//	@Bean
//	public InternalResourceViewResolver resolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setViewClass(JstlView.class);
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
	
	
//	@Bean
//	public MemberController MemberController(MemberService memberService) {
//		return new MemberController(memberService);
//	}
	
	@Bean
	public MemberController MemberController() {
		return new MemberController();
	}
}
