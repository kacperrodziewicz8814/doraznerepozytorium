package WczytywanieDanych;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {


    private static final String pathFemaleFirstnames = "src/WczytywanieDanych/Dane/polish_female_firstnames.txt";
    private static final String pathMaleFirstnames = "src/WczytywanieDanych/Dane/polish_male_firstnames.txt";
    private static final String pathSurnames = "src/WczytywanieDanych/Dane/polish_surnames.txt";
    private static final String pathUlic =  "src/WczytywanieDanych/Dane/streets.txt";
    private static final String pathCitiesData = "src/WczytywanieDanych/Dane/cities_population.txt";

    private static final List<String> femaleFirstnames = readFile(pathFemaleFirstnames);
    private static final List<String> maleFirstnames = readFile(pathMaleFirstnames);
    private static final List<String> surnames = readFile(pathSurnames);
    private static final List<String> streets = readFile(pathUlic);
    private static final List<String[]> cityAndPopulation = readCitiesPopulation(pathCitiesData);



    public static List<String> getFemaleFirstnames() {
        return femaleFirstnames;
    }

    public static List<String> getMaleFirstnames() {
        return maleFirstnames;
    }

    public static List<String> getSurnames() {
        return surnames;
    }

    public static List<String> getStreets() {
        return streets;
    }

    public static List<String[]> getCityAndPopulation() {
        return cityAndPopulation;
    }

    private static List<String> readFile(String path) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static List<String[]> readCitiesPopulation(String path) {
        List<String[]> citiesPopulation = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] cityInfo = line.split(", ");
                if (cityInfo.length == 2) {
                    citiesPopulation.add(cityInfo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return citiesPopulation;
    }

}