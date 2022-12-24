package ru.sber.service;

import ru.sber.model.City;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class CityService {

    /**
     * Загрузка данных о городах в массив
     *
     * @return массив с данными о городах
     */

    public static List<City> parse(String path, String delimiter) {
        List<City> cities = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(path))) {
            while (scanner.hasNextLine()) {
                cities.add(parseLine(scanner.nextLine(), delimiter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    /**
     * Вывод в консоль списка городов
     *
     * @param cities список городов
     */
    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    private static City parseLine(String line, String delimiter) {
        Objects.requireNonNull(line);
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(delimiter);
        scanner.skip("\\d*"); // Необходимо пропустить значение номера строки по условиям задачи
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        int year = 0;
        if (scanner.hasNext()) { // В файле с городами возможно отсутствие данного значения
            year = parseYear(scanner.next());
        }
        LocalDate foundation = LocalDate.ofYearDay(year, 1);
        scanner.close();

        return new City(name, region, district, population, foundation);
    }

    private static int parseYear(String s) {
        int y = Integer.parseInt(s.replaceAll("\\D+", ""));
        return s.endsWith("век") ? y * 100 : y;
    }


    public static final Comparator<City> BY_NAME_CASE_INSENSITIVE_ORDER =
            (c1, c2) -> c2.getName().compareToIgnoreCase(c1.getName());


    public static final Comparator<City> BY_DISTRICT_AND_NAME =
            (c1, c2) ->
            {
                int nameCmp = c1.getName().compareTo(c2.getName());
                int districtCmp = c1.getDistrict().compareTo(c2.getDistrict());
                return districtCmp == 0 ? nameCmp : districtCmp;
            };

    public static final Comparator<City> BY_DISTRICT_AND_NAME1 =
            Comparator.comparing(City::getDistrict).thenComparing(City::getName);

    public static void sort(List<City> cities, Comparator<City> c) {
        cities.sort(c);
    }

}
