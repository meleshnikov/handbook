package ru.sber;

import ru.sber.model.City;

import java.util.List;

import static ru.sber.service.CityService.*;

public class Main {

    private static final String FILE_PATH = "src/main/resources/city_ru.csv";
    private static final String DELIMITER = ";";

    public static void main(String[] args) {
        List<City> cities = parse(FILE_PATH, DELIMITER);

        printCitiesCountByRegion(cities);
    }

}