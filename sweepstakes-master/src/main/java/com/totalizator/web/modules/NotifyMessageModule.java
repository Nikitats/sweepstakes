package com.totalizator.web.modules;

import com.totalizator.web.modules.interfaces.INotifyMessageModule;
import com.totalizator.web.viewmodels.MessageViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by home
 */
@Component
public class NotifyMessageModule implements INotifyMessageModule {

	@Autowired
	public NotifyMessageModule(SimpMessagingTemplate template) throws Exception {
		this.template = template;
	}

	private final SimpMessagingTemplate template;

	@Override
	public void notifyAddMessage(MessageViewModel messageViewModel) {
		template.convertAndSend("/messages/addMessage", messageViewModel);
	}
}
