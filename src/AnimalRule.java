import java.util.List;

public class AnimalRule {
    public static long CountHerbivores(List<Animals> animals){
        return animals.stream().filter(animal -> "ТРАВОЯДНОЕ".equalsIgnoreCase(animal.getType())).count();
    }

    public static long CountHerbivoresOrCarnivoresAndSmall(List<Animals> animals){
        return animals.stream().filter(animal -> ("ТРАВОЯДНОЕ".equalsIgnoreCase(animal.getType()) ||
                "ПЛОТОЯДНОЕ".equalsIgnoreCase(animal.getType())) && "МАЛЕНЬКОЕ".equalsIgnoreCase(animal.getHeight())).count();
    }

    public static long CountOmnivoresNotTall(List<Animals> animals){
        return animals.stream().filter(animal -> "ВСЕЯДНОЕ".equalsIgnoreCase(animal.getType()) &&
                !"ВЫСОКОЕ".equalsIgnoreCase(animal.getHeight())).count();
    }
}
