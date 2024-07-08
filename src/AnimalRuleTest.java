import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AnimalRuleTest {

    private static AnimalRule animalRule;

    //  Добавление параметров фильтра до начала тестов
    @BeforeAll
    static void setup() {
        animalRule = new AnimalRule();
        animalRule.typeOptionList = Arrays.asList("ВСЕЯДНОЕ", "ТРАВОЯДНОЕ", "ПЛОТОЯДНОЕ");
        animalRule.weightOptionList = Arrays.asList("ЛЕГКОЕ", "СРЕДНЕЕ", "ТЯЖЕЛОЕ");
        animalRule.heightOptionList = Arrays.asList("МАЛЕНЬКОЕ", "НЕВЫСОКОЕ", "ВЫСОКОЕ");
    }

    //  Тестирование правила: Сколько животных – травоядных
    @Test
    void countHerbivores() {
        List<Animals> animals = Arrays.asList(
                new Animals("ЖИРАФ","ТРАВОЯДНОЕ","ТЯЖЕЛОЕ","ВЫСОКОЕ"),
                new Animals("КРОКОДИЛ","ПЛОТОЯДНОЕ","ТЯЖЕЛОЕ","НЕВЫСОКОЕ"),
                new Animals("СЛОН","ТРАВОЯДНОЕ","ТЯЖЕЛОЕ","ВЫСОКОЕ"),
                new Animals("ЗЕБРА","ТРАВОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ"),
                new Animals("ЛЕМУР","ТРАВОЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ")
        );
        assertEquals(4,animalRule.CountHerbivores(animals));
    }

    //  Тестирование правила: Сколько животных – травоядных или плотоядных и они при этом маленькие
    @Test
    void countHerbivoresOrCarnivoresAndSmall() {
        List<Animals> animals = Arrays.asList(
                new Animals("ЖИРАФ","ТРАВОЯДНОЕ","ТЯЖЕЛОЕ","ВЫСОКОЕ"),
                new Animals("КЕНГУРУ","ТРАВОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ"),
                new Animals("ВЕРБЛЮД","ТРАВОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ"),
                new Animals("КРЫСА","ВСЕЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ"),
                new Animals("ЛЕМУР","ТРАВОЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ")
        );
        assertEquals(1,animalRule.CountHerbivoresOrCarnivoresAndSmall(animals));
    }

    //  Тестирование правила: Сколько животных – всеядных, но не являются высокими
    @Test
    void countOmnivoresNotTall() {
        List<Animals> animals = Arrays.asList(
                new Animals("ЛАСКА","ВСЕЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ"),
                new Animals("ВОЛК","ПЛОТОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ"),
                new Animals("СЛОН","ТРАВОЯДНОЕ","ТЯЖЕЛОЕ","ВЫСОКОЕ"),
                new Animals("ВЫДРА","ВСЕЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ"),
                new Animals("ЗЕБРА","ТРАВОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ")

        );
        assertEquals(2,animalRule.CountOmnivoresNotTall(animals));
    }
}