package com.example2.demo2.model;


import javax.persistence.*;

@Entity
@NamedQuery(name = "Greeting.f", query = "select g from Greeting g where id>1")//именнованый запрос
@Table(name = "greeting")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Greeting() {
    }
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }

}