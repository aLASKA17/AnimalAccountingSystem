import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        List<Animals> animals = ReaderFile.ReaderAnimalInfo(".\\src\\Animals");
        List<Rule> rules = ReaderFile.ReaderRuleInfo(".\\src\\Rule");
        AnimalRule animalRule = new AnimalRule();

        System.out.println(ReaderFile.typeOption);
        System.out.println(ReaderFile.weightOption);
        System.out.println(ReaderFile.heightOption);

        for (Rule rule : rules) {
            switch (rule.getSwitchId()) {
                case "1":
                    System.out.println(rule.getDescription() + " - " + AnimalRule.CountHerbivores(animals));
                    break;
                case "2":
                    System.out.println(rule.getDescription() + " - " + AnimalRule.CountHerbivoresOrCarnivoresAndSmall(animals));
                    break;
                case "3":
                    System.out.println(rule.getDescription() + " - " + AnimalRule.CountOmnivoresNotTall(animals));
                    break;
                default:
                    System.out.println("Неизвестное правило");
            }
        }
    }
}