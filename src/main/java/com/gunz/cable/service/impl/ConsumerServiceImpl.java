package com.gunz.cable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.gunz.cable.entity.Consumer;
import com.gunz.cable.repository.ConsumerRepository;
import com.gunz.cable.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	ConsumerRepository consumerRepository;

	@Override
	public List<Consumer> getAllConsumers() {
		// TODO Auto-generated method stub
		return consumerRepository.findAll();
	}
	
	@Override
	  public Consumer getConsumerById(int id) {
	    return consumerRepository.findById(id).get();
	  }

	@Override
	public Consumer addConsumer(Consumer consumer) {
		return consumerRepository.save(consumer);
	}

	@Override
	public void updateConsumer(Consumer consumer) {
		Consumer consumerDb = consumerRepository.findById(consumer.getId()).orElseThrow();
		consumerRepository.save(consumer);
	}

	@Override
	public void deleteUserById(int consumerId) {
		try {
			consumerRepository.deleteById(consumerId);
		}
		catch(DataAccessException ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
	
}
