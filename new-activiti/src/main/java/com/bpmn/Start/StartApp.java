package com.bpmn.Start;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan ( basePackages= {"com.bpmn.Start", "com.bpmn.process", "com.bpmn.controllers"})
public class StartApp {

	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args);
	}



@Bean
InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

    return new InitializingBean() {
        public void afterPropertiesSet() throws Exception {

        	System.out.println("Initiating new User");
            Group group = identityService.newGroup("user");
            group.setName("users");
            group.setType("security-role");
            identityService.saveGroup(group);

            User kermit = identityService.newUser("kermit");
            kermit.setPassword("kermit");
            kermit.setFirstName("vignesh");
            kermit.setLastName("T");
            kermit.setEmail("t.vignesh@abc.com");
            identityService.saveUser(kermit);
            System.out.println("Kermit user saved");
            
            User admin = identityService.newUser("admin");
            admin.setPassword("admin");
            admin.setFirstName("admin");
            
            admin.setEmail("admin.activiti@abc.com");
            identityService.saveUser(admin);
            
            System.out.println("admin user saved");  

        }
    };
}


@Bean
public FilterRegistrationBean corsFilter() {
	System.out.println("Initializing CORS filter ");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config);
    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE); 
    System.out.println("Completed CORS filter");
    return bean;
}
}