package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=1,max = 10)
    private String name;
    @ManyToOne
    @JoinColumn(name = "nation_id")
    @NotNull
    private Nation nation;
    @Positive
    @NotNull
    private double area;
    @Positive
    @NotNull
    //Nếu them @NotEmty,@NotNull thì lỗi-> test lại
    private Long population;
    @Positive
    @NotNull
    //Nếu them @NotEmty thì lỗi-> test lại
    private Long GDP;
    //Nếu them @NotEmty thì lỗi-> test lại
    @NotNull
    private String description;

    public City() {
    }

    public City(Long id, @NotEmpty @Size(min = 1, max = 10) String name, @NotNull Nation nation, @Positive @NotNull double area, @Positive @NotNull Long population, @Positive @NotNull Long GDP, @NotNull String description) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
