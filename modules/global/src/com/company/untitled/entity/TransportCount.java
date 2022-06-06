package com.company.untitled.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Table(name = "UNTITLED_TRANSPORT_COUNT")
@Entity(name = "untitled_TransportCount")
public class TransportCount extends StandardEntity {
    private static final long serialVersionUID = -62667039231461687L;

    @NotNull
    @Column(name = "YEAR_", nullable = false)
    private Integer year;

    @NotNull
    @Column(name = "CARS", nullable = false)
    private Integer cars;

    @NotNull
    @Column(name = "MOTORCYCLES", nullable = false)
    private String motorcycles;

    @NotNull
    @Column(name = "BICYCLES", nullable = false)
    private String bicycles;

    public String getBicycles() {
        return bicycles;
    }

    public void setBicycles(String bicycles) {
        this.bicycles = bicycles;
    }

    public String getMotorcycles() {
        return motorcycles;
    }

    public void setMotorcycles(String motorcycles) {
        this.motorcycles = motorcycles;
    }

    public Integer getCars() {
        return cars;
    }

    public void setCars(Integer cars) {
        this.cars = cars;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}