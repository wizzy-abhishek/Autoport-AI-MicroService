package com.car_detail.CarDetailsMS.enitity;

import jakarta.persistence.*;

@Entity
public class CarImages {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String uri;

    private String fileName;

    @ManyToOne
    private Car car;

    public Long getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public String getFileName() {
        return fileName;
    }

    public Car getCar() {
        return car;
    }

}
