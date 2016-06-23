package com.totalizator.web.controller;

import com.totalizator.dao.entities.Club;
import com.totalizator.dao.entities.Message;
import com.totalizator.web.modules.interfaces.IMapperModule;
import com.totalizator.web.modules.interfaces.INotifyMessageModule;
import com.totalizator.web.viewmodels.MessageViewModel;
import com.totalizator.services.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by home
 */
@Controller
@RequestMapping(value = "/messages")
public class MessagesController {

	@Autowired
	public MessagesController(IDataService dataService, IMapperModule mapperModule, INotifyMessageModule notifyMessageModule) {
		this.dataService = dataService;
		this.mapperModule = mapperModule;
		this.notifyMessageModule = notifyMessageModule;
	}

	private final IDataService dataService;
	private final IMapperModule mapperModule;
	private final INotifyMessageModule notifyMessageModule;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(ModelMap model) {

		List<Message> messages = dataService.findAllMessages();

		model.addAttribute("messagesList", messages);

		return "messages/messages";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/showClubs")
	public String showClubs(ModelMap model) {

		List<Club> clubs = dataService.getAllClubs();

		model.addAttribute("clubList", clubs);

		return "matches";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	@ResponseBody
	public MessageViewModel addMessage(@RequestBody @Valid MessageViewModel messageViewModel,
	                         BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			throw new Exception("error binding model");
		}

		Message message = mapperModule.map(messageViewModel, Message.class);

		Message msg = dataService.createMessage(message);

		MessageViewModel result = mapperModule.map(msg, MessageViewModel.class);

		notifyMessageModule.notifyAddMessage(result);

		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	@ResponseBody
	public boolean deleteMessage(@RequestBody @Valid MessageViewModel messageViewModel,
	                               BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return false;
		}

		dataService.deleteMessage(messageViewModel.getId());

		return true;
	}
}
