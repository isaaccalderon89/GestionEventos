package com.neoris.segundaprueba.infrastructure.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "EVENTOS")
public class InMemoryEventoRepositoryEntity {
    /**
     * Esta es la clase de base de datos, con las anotaciones Spring estamos indicando el nombre de la tabla
     * en la base de datos, así como las columnas y la clase primaria y la estrategia que esta va a seguir.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENTO")
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CAPACITY")
    private Integer capacity;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    @Column(name = "PRICE")
    private Double price;

    public InMemoryEventoRepositoryEntity(Long id, String description, Integer capacity, LocalDateTime startDate, LocalDateTime endDate, Double price) {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public InMemoryEventoRepositoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
