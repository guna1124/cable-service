package com.gunz.cable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gunz.cable.entity.Consumer;


public interface ConsumerRepository extends JpaRepository<Consumer, Integer>{
	
}
