package com.example2.demo2.repository;

import com.example2.demo2.model.Greeting;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@AutoConfigureTestDatabase (replace =AutoConfigureTestDatabase.Replace.NONE )
@RunWith(SpringRunner.class)
@DataJpaTest
public class GreetingRepositoryTest1 {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private GreetingRepository greetingRepository;

   private Greeting greeting;
   private Greeting greeting1;
    @Before
    public void setup(){
        greeting=new Greeting(1L, "привет"); //1L - Long
        greeting1= testEntityManager.merge(greeting);

    }
    @Test
    public void f() { }
    @Test
    public void f2() { }

    @Test
    public void findById() {
        Greeting getGreeting=greetingRepository.findById(greeting1.getId());
        assertEquals("привет", getGreeting.getContent());
    }

    @Test
    public void findByContent() {                                 //здесь "привет" находиться    //возьми его контент 0-го объекта
   assertEquals("привет", greetingRepository.findByContent(greeting1.getContent()).get(0).getContent());

    }
}
//