import java.util.ArrayList;
import java.util.List;

public class AnimalRule {

    public static List<String> typeOptionList = new ArrayList<>();
    public static List<String> weightOptionList = new ArrayList<>();
    public static List<String> heightOptionList = new ArrayList<>();

    //  Перевод параметров фильтра в список
    public AnimalRule() {
        typeOptionList.addAll(ReaderFile.typeOption);
        weightOptionList.addAll(ReaderFile.weightOption);
        heightOptionList.addAll(ReaderFile.heightOption);
    }

    //  Правило: Сколько животных – травоядных
    public static long CountHerbivores(List<Animals> animals){
        return animals.stream().filter(animal -> typeOptionList.get(1).equalsIgnoreCase(animal.getType())).count();
    }
    //  Правило: Сколько животных – травоядных или плотоядных и они при этом маленькие
    public static long CountHerbivoresOrCarnivoresAndSmall(List<Animals> animals){
        return animals.stream().filter(animal -> (typeOptionList.get(1).equalsIgnoreCase(animal.getType()) ||
                typeOptionList.get(2).equalsIgnoreCase(animal.getType())) && heightOptionList.get(2).equalsIgnoreCase(animal.getHeight())).count();
    }
    //  Правило: Сколько животных – всеядных, но не являются высокими
    public static long CountOmnivoresNotTall(List<Animals> animals){
        return animals.stream().filter(animal -> typeOptionList.get(0).equalsIgnoreCase(animal.getType()) &&
                !heightOptionList.get(1).equalsIgnoreCase(animal.getHeight())).count();
    }
}
