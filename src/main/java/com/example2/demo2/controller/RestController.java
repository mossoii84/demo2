package com.example2.demo2.controller;
import com.example2.demo2.model.Greeting;
import com.example2.demo2.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    GreetingRepository greetingRepository;

    @GetMapping("/greeting")
    public List<Greeting> list() {
        List<Greeting> list = new ArrayList<>();
        Iterable<Greeting> list1 = greetingRepository.findAll(); //прохождение по всем элементам кострукции foreche
        list1.forEach(list::add); // берем лист и с каждым эл. списка перезаписываем из одного List1 в list
        return list;
    }
    @PostMapping("/greeting/create")
    public Greeting createGreeting(@RequestBody Greeting greeting) { //принять тело запроса и правратить его в объект класса Greting
        // и вывести через json
        System.out.println("Create Book: " + greeting.getContent() + "...");
        Greeting greeting1 = greetingRepository.save(greeting);
        return greeting1; }

    @GetMapping("/greeting/content")
    public List<Greeting> f() {
        return greetingRepository.f();
    }

    @GetMapping("/greeting/findNumber")
    public List<Greeting> f2(@RequestParam(name = "id", defaultValue = "2") String i) { //i - мы указали в интерфейсе
        return greetingRepository.f2(Long.valueOf(i)); //переводим String в Long
    }
    @GetMapping("/greeting/findById")
    public Greeting findById(@RequestParam(name = "id", defaultValue = "2") String i) {
        return greetingRepository.findById(Long.valueOf(i));
    }

    @GetMapping("/greeting/findByContent/{content}")
    List<Greeting> findByContent(@PathVariable("content") String content) { //выборка контента строки
        return greetingRepository.findByContent(content);
    }
}
