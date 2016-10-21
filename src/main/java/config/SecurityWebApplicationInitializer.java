package config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * This class will be discovered by Spring and used to register DelegatingFilterProxy
 * with the web container. It will intercept requests coming into the application and
 * delegate them to a bean whose ID is springSecurityFilterChain.
 * 
 * @author aTrifonov
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{
	
}
