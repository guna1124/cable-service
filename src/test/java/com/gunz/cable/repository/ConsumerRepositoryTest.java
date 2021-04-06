package com.gunz.cable.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gunz.cable.entity.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerRepositoryTest {
	
	@Autowired
    private ConsumerRepository consumerRepository;
	
	/*
	 * @Before public void setUp() throws Exception { ConsumerRepository con= new
	 * ConsumerRepository("Alice", 23); ConsumerRepository con2= new
	 * ConsumerRepository("Bob", 38); //save user, verify has ID value after save
	 * assertNull(user1.getId()); assertNull(user2.getId());//null before save
	 * this.consumerRepository.save(user1); this.consumerRepository.save(user2);
	 * assertNotNull(user1.getId()); assertNotNull(user2.getId()); }
	 */
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
    	//Optional<Consumer> userA = consumerRepository.findById(2);
        //assertNotNull(userA);
       // assertEquals(38, userA.getAge());
        /*Get all products, list should only have two*/
        Iterable<Consumer> consumers = consumerRepository.findAll();
        int count = 0;
        for(Consumer p : consumers){
            count++;
        }
        assertEquals(count, 2);
    }
}
