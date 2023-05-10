package org.datasource;


import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;


/*
 * mvn spring-boot:run
 */
@SpringBootApplication (exclude={DataSourceAutoConfiguration.class} )
public class SpringBootDataService 
		extends SpringBootServletInitializer
{
	private static Logger logger = Logger.getLogger(SpringBootDataService.class.getName());
	
	public static void main(String[] args) {
		logger.info("Loading ... SpringBootDataService Default Settings ... JSON");
		SpringApplication.run(SpringBootDataService.class, args);
	}
	
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
	    return (mapperBuilder) -> mapperBuilder.modulesToInstall(new JaxbAnnotationModule());
	}
}


/*
# Script to manage 18c
# Start docker
open -a docker
# Start container
docker start 94277f0dc1ed
# Stop container
docker stop 94277f0dc1ed
# Stop docker
osascript -e 'quit app "Docker"'
*/

/*
sudo -i
VBoxManage startvm "Oracle DB Developer VM" --type headless
###
VBoxManage controlvm "Oracle DB Developer VM" savestate
###
*/