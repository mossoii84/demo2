package com.example2.demo2.controller;

import com.example2.demo2.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController  // java превращает в Json и обратно,преобразуется в ответ HTTP.
public class GreetingController {

    private static final String template = "Hello, %s!"; //
    private final AtomicLong counter = new AtomicLong();  //стандартная инструкция, атомарные переменные
    // использование AtomicInteger вместо обычного Integer позволило нам корректно увеличить число (Id +1),
    // распределив работу сразу по двум потокам(многопоточность)

    @RequestMapping("/greeting")  //Аннотация используется для маппинга урл-адреса запроса на указанный метод или класс
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "Jav") String name) {
        //такая форма записи, передаем Get параметры в URL-?name

        // new Greeting конструктор класса с параметрами
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        //return new Greeting(counter.incrementAndGet(),
        //String.format(template, name, name));
        return greeting;
    }
}