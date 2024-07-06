import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<Animals> animals = ReaderFile.ReaderAnimalInfo("C:\\Users\\valer\\IdeaProjects\\AnimalAccountingSystem\\src\\Animals");
        List<Rule> rules = ReaderFile.ReaderRuleInfo("C:\\Users\\valer\\IdeaProjects\\AnimalAccountingSystem\\src\\Rule");

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