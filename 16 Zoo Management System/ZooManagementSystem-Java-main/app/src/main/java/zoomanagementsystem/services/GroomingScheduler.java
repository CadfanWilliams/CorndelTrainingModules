package zoomanagementsystem.services;

import zoomanagementsystem.models.Animal;
import zoomanagementsystem.models.CanBeGroomed;
import zoomanagementsystem.models.Keeper;

import java.util.List;

public class GroomingScheduler extends JobScheduler {
    private static GroomingScheduler instance;

    private GroomingScheduler() {
        super();
    }

    public static GroomingScheduler getInstance() {
        if (instance == null) {
            instance = new GroomingScheduler();
        }
        return instance;
    }

    @Override
    public void assignJobs(List<? extends Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
            if (animal instanceof CanBeGroomed) {
                keeper.groom((CanBeGroomed) animal);
            }
        }));
    }
}
