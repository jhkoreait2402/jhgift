package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.korea.board.BoardController;
//
//import dao.BoardDAO;
//import service.BoardService;

@Configuration
@EnableWebMvc
// Enable로 시작하는 어노테이션을 @Configuration이 붙은 설정클래스에 붙임으로 써 이와 관련된 기능들을 편리하게 제공
// 어노테이션 기반의 SpringMVC를 구성할 때 필요한 Bean 설정들을 자동으로 해주는 어노테이션
//@ComponentScan(basePackages={"com.korea.json","dao"})//여러개의 컴포넌트스캔하기위한 것
// @component, streotype(@service, @repository, @controller)어노테이션이 부여된 Class들을 
// 자동으로 Scan하여 Bean으로 등록해주는 역할을 하는 어노테이션
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
//	public BoardController boardController(BoardService boardService) {
//		return new BoardController(boardService);
//	}
	
}
