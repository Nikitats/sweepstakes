package com.totalizator.config;

import com.google.common.collect.Lists;
import com.totalizator.services.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;

/**
 * Created by home
 */
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration {

	@Autowired
	private IUserDetailsService userDetailsService;

	@Autowired
	protected void configure(AuthenticationManagerBuilder registry) throws Exception {
		registry.userDetailsService(userDetailsService);
	}

	@Bean
	public RoleHierarchy roleHierarchy() {
		RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
		hierarchy.setHierarchy(
				"ROLE_ADMIN > ROLE_EMPLOYEE_WRITE " +
						"ROLE_ADMIN > ROLE_ACCESS_CONTROL " +
						"ROLE_ADMIN > ROLE_REPORTS_WRITE " +
						"ROLE_ADMIN > ROLE_SENTINEL " +
						"ROLE_ADMIN > ROLE_SCHEDULE_WRITE " +
						"ROLE_EMPLOYEE_WRITE > ROLE_EMPLOYEE_READ " +
						"ROLE_REPORTS_WRITE > ROLE_REPORTS_READ " +
						"ROLE_SCHEDULE_WRITE > ROLE_SCHEDULE_READ"
		);
		return hierarchy;
	}

	@Bean
	public RoleHierarchyVoter roleHierarchyVoter() {
		return new RoleHierarchyVoter(roleHierarchy());
	}

	@Bean
	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
		DefaultWebSecurityExpressionHandler webSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
		webSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
		return webSecurityExpressionHandler;
	}

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		DefaultMethodSecurityExpressionHandler d = new DefaultMethodSecurityExpressionHandler();
		d.setRoleHierarchy(roleHierarchy());
		return d;
	}

	@Configuration
	@Order(1)
	public static class ApiSecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.csrf().disable()
					.regexMatcher("/[aA]pi/.*").authorizeRequests().anyRequest().hasRole("API")
					.and().httpBasic();
		}
	}

	@Configuration
	@Order(2)
	public static class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.csrf().disable()
					.regexMatcher("/rest/.*").authorizeRequests().anyRequest().hasRole("REST")
					.and().httpBasic();
		}
	}

	@Configuration
	@Order(3)
	public static class FormLoginWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/resources/**", "/assets/**");
		}

		@Autowired
		private RoleHierarchyVoter hierarchyVoter;

		@Autowired
		private DefaultWebSecurityExpressionHandler webSecurityExpressionHandler;

		@Bean
		public AccessDecisionManager accessDecisionManager() {
			WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
			webExpressionVoter.setExpressionHandler(webSecurityExpressionHandler);
			return new AffirmativeBased(Lists.newArrayList(hierarchyVoter, webExpressionVoter));
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.csrf().disable()
					.authorizeRequests()
					.accessDecisionManager(accessDecisionManager())
					.antMatchers("/messages")
					.authenticated()
					.anyRequest().hasRole("ADMIN")
					.and()
					.formLogin()
					.loginPage("/login").permitAll()
					.failureUrl("/login?auth=fail")
					.and()
					.logout().permitAll()
					.and()
					.exceptionHandling().accessDeniedPage("/403")
					.and().httpBasic();
		}
	}

}