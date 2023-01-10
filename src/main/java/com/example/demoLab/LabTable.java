package com.example.demoLab;

import javax.persistence.*;

@Entity(name = "Lab2")
public class LabTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long Id;

    @Column (name = "name")
    private String name;

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
