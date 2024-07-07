import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ReaderFile {

    public static Set<String> typeOption = new HashSet<>();
    public static Set<String> weightOption = new HashSet<>();
    public static Set<String> heightOption = new HashSet<>();

    //  Чтение списка из файла,добавление параметров в Set и создание нового объекта
    public static List<Animals> ReaderAnimalInfo(String filepath) {
        List<Animals> animals = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(",");
                Animals animal = new Animals(values[0],values[1],values[2],values[3]);
                typeOption.add(values[1]);
                weightOption.add(values[2]);
                heightOption.add(values[3]);
                animals.add(animal);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return animals;
    }

    //  Чтение списка из файла и создание нового объекта
    public static List<Rule> ReaderRuleInfo(String filepath) {
        List<Rule> rules = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                Rule rule = new Rule();
                rule.setSwitchId(values[0]);
                rule.setDescription(values[1]);
                rules.add(rule);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rules;
    }
}
