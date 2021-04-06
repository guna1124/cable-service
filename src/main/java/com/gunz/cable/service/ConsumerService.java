package com.gunz.cable.service;

import java.util.List;

import com.gunz.cable.entity.Consumer;

public interface ConsumerService {
	
	List<Consumer> getAllConsumers();
	Consumer getConsumerById(int id);
	Consumer addConsumer(Consumer consumer);
	void updateConsumer(Consumer consumer);
	void deleteUserById(int consumerId);
}
