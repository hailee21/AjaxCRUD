package cafe.jjdev.ajaxcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AjaxCrudApplication {

	public static void main(String[] args) {
		System.out.println("=======================tomcat 실행 전==========================");
		SpringApplication.run(AjaxCrudApplication.class, args);
		System.out.println("=======================Spring 구동 후==========================");
	}

}
