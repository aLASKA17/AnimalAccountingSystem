import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFile {
    public static List<Animals> ReaderAnimalInfo(String filepath) {
        List<Animals> animals = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(",");
                Animals animal = new Animals(values[0],values[1],values[2],values[3]);
                animals.add(animal);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return animals;
    }

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
