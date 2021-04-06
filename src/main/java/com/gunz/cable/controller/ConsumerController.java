package com.gunz.cable.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gunz.cable.entity.Consumer;
import com.gunz.cable.service.ConsumerService;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {
	
	@Autowired
	ConsumerService consumerService;
	
	@GetMapping
	public List<Consumer> getAllConsumers(){
		return consumerService.getAllConsumers();
	}
	
	@GetMapping("/{id}")
	public Consumer getConsumerById(@PathVariable("id") int id) {
		return consumerService.getConsumerById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Consumer addConsumer(@RequestBody Consumer consumer) {
		return consumerService.addConsumer(consumer);
	}
	
	@PutMapping("/update-consumer")
	public ResponseEntity<String> updateConsumer(@RequestBody Consumer consumer) {
		try {
			consumerService.updateConsumer(consumer);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch(NoSuchElementException ex){
		      // log the error message
		      System.out.println(ex.getMessage());
		      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteConsumer(@PathVariable int id) {
		try {
			consumerService.deleteUserById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch(RuntimeException ex){
		      // log the error message
		      System.out.println(ex.getMessage());
		      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		    }
	}
}
