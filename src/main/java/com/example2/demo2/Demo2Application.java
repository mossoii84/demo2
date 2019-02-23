package com.example2.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {
    //SpringApplication.run(Demo2Application.class, args) - Это сообщает Spring о чтении метаданных аннотации
// из Application и управлении ею как компонентом в Spring application context.
//Аннотация @ComponentScan говорит Spring'у рекурсивно искать в пакете hello и его потомках классы,
// помеченные прямо или косвенно Spring аннотацией @Component (@RestController).
    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}
