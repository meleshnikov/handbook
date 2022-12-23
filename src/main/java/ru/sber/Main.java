package ru.sber;

import static ru.sber.service.CityService.parse;
import static ru.sber.service.CityService.print;

public class Main {

    private static final String FILE_PATH = "src/main/resources/city_ru.csv";
    private static final String DELIMITER = ";";

    public static void main(String[] args) {
        print(parse(FILE_PATH, DELIMITER));
    }

}