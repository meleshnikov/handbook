package ru.sber.model;

import java.time.LocalDate;

public class City {

    private final String name;
    private final String region;
    private final String district;
    private final int population;
    private final LocalDate foundation;

    public City(String name,
                String region,
                String district,
                int population,
                LocalDate foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return "City{" +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation.getYear() +
                '}';
    }
}
