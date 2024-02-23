package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class Context_3_FileUpload {
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setDefaultEncoding("utf-8");
		
		// 최대 업로드 용량
		mr.setMaxUploadSize(10485760);
		return mr;
	}
	
	
}
