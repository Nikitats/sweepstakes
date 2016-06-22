package com.totalizator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import java.util.List;

/**
 * Created by home
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		stompEndpointRegistry.addEndpoint("/ws").withSockJS();
	}

	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration webSocketTransportRegistration) {
		webSocketTransportRegistration
				.setMessageSizeLimit(128 * 1024)
				.setSendTimeLimit(15 * 1000)
				.setSendBufferSizeLimit(512 * 1024);
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
		messageBrokerRegistry.enableSimpleBroker("/messages");
		messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration channelRegistration) {

	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration channelRegistration) {

	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

	}


	@Override
	public boolean configureMessageConverters(List<MessageConverter> list) {
		return true;
	}
}