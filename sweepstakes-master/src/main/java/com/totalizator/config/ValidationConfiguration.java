package com.totalizator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
/**
 * Created by home
 */
@Configuration
@ComponentScan(basePackages = {"com.totalizator.web.viewmodels"})
public class ValidationConfiguration {

	@Autowired
	ExposedResourceMessageBundleSource messageBundleSource;

	@Bean(name = "basicValidator")
	public Validator basicValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageBundleSource);
		return validator;
	}
}
