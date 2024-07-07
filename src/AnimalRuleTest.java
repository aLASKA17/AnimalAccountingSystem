import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AnimalRuleTest {

    @BeforeAll
    static void setup() {
        AnimalRule.typeOptionList = Arrays.asList("ВСЕЯДНОЕ", "ТРАВОЯДНОЕ", "ПЛОТОЯДНОЕ");
        AnimalRule.weightOptionList = Arrays.asList("ЛЕГКОЕ", "СРЕДНЕЕ", "ТЯЖЕЛОЕ");
        AnimalRule.heightOptionList = Arrays.asList("МАЛЕНЬКОЕ", "НЕВЫСОКОЕ", "ВЫСОКОЕ");
    }

    @Test
    void countHerbivores() {
        List<Animals> animals = Arrays.asList(
                new Animals("ЖИРАФ","ТРАВОЯДНОЕ","ТЯЖЕЛОЕ","ВЫСОКОЕ"),
                new Animals("КРОКОДИЛ","ПЛОТОЯДНОЕ","ТЯЖЕЛОЕ","НЕВЫСОКОЕ"),
                new Animals("СЛОН","ТРАВОЯДНОЕ","ТЯЖЕЛОЕ","ВЫСОКОЕ"),
                new Animals("ЗЕБРА","ТРАВОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ"),
                new Animals("ЛЕМУР","ТРАВОЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ")
        );
        assertEquals(4,AnimalRule.CountHerbivores(animals));
    }

    @Test
    void countHerbivoresOrCarnivoresAndSmall() {
        List<Animals> animals = Arrays.asList(
                new Animals("ЖИРАФ","ТРАВОЯДНОЕ","ТЯЖЕЛОЕ","ВЫСОКОЕ"),
                new Animals("КЕНГУРУ","ТРАВОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ"),
                new Animals("ВЕРБЛЮД","ТРАВОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ"),
                new Animals("КРЫСА","ВСЕЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ"),
                new Animals("ЛЕМУР","ТРАВОЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ")
        );
        assertEquals(1,AnimalRule.CountHerbivoresOrCarnivoresAndSmall(animals));
    }

    @Test
    void countOmnivoresNotTall() {
        List<Animals> animals = Arrays.asList(
                new Animals("ЛАСКА","ВСЕЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ"),
                new Animals("ВОЛК","ПЛОТОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ"),
                new Animals("СЛОН","ТРАВОЯДНОЕ","ТЯЖЕЛОЕ","ВЫСОКОЕ"),
                new Animals("ВЫДРА","ВСЕЯДНОЕ","ЛЕГКОЕ","МАЛЕНЬКОЕ"),
                new Animals("ЗЕБРА","ТРАВОЯДНОЕ","СРЕДНЕЕ","НЕВЫСОКОЕ")

        );
        assertEquals(2,AnimalRule.CountOmnivoresNotTall(animals));
    }
}