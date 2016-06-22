package com.totalizator.config;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Properties;

/**
 * Created by home
 */
public class ExposedResourceMessageBundleSource extends ReloadableResourceBundleMessageSource {
	/**
	 * Gets all messages for presented Locale.
	 * @param locale user request's locale
	 * @return all messages
	 */
	public Properties getMessages(Locale locale){
		return getMergedProperties(locale).getProperties();
	}
}
