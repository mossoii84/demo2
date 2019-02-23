package com.example2.demo2.repository;

import com.example2.demo2.model.Greeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository //хранилище, CRUD и других операций
public interface GreetingRepository extends CrudRepository<Greeting, AtomicLong> {
    List<Greeting> f(); //метод чье выполнение обеспечивается NamedQuery, это интерфейс к NamedQuery


    // именованный запрос, префикс Query позволяет создать свои Интерфейс
    @Query("select g from Greeting g where id>:i")//заспрос HQL для привязки запросов к методам интерф.репозитория
    public List<Greeting> f2(@Param("i") Long i);
    //Greeting  имя обьекта с которым работает, findNumber - имя метода которое мы задаем


    Greeting findById(Long id); //ключевые слова стандарные методы Spring Data (есть в инете)

    List<Greeting> findByContent(String content); //это стандартные ключевые слова + имя поля класа

}

