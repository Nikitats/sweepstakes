package com.totalizator.services;

import com.totalizator.dao.entities.Club;
import com.totalizator.dao.entities.Message;
import com.totalizator.dao.repository.IClubRepository;
import com.totalizator.dao.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by home
 */
@Service
@Transactional
public class DataService implements IDataService {

	private final IMessageRepository messageRepository;
	private final IClubRepository clubRepository;

	@Autowired
	public DataService(IMessageRepository messageRepository, IClubRepository clubRepository) {
		this.messageRepository = messageRepository;
		this.clubRepository = clubRepository;
	}

	@Override
	public boolean test() {
		return false;
	}

	@Override
	public Message createMessage(Message message){
		return messageRepository.saveAndFlush(message);
	}

	@Override
	public Message readMessage(Long id) {
		return messageRepository.findOne(id);
	}

	@Override
	public void deleteMessage(Long id) {
		messageRepository.delete(id);
	}

	@Override
	public List<Message> findAllMessages() {
		return messageRepository.findAll();
	}

	public List<Club> getAllClubs() {
		return clubRepository.findAll();
	}
}
