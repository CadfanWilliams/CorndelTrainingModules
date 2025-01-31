package zoomanagementsystem.services;

import zoomanagementsystem.models.Animal;
import zoomanagementsystem.models.Keeper;

import java.util.List;

public class FeedingScheduler {
    private static FeedingScheduler instance;

    private FeedingScheduler() {
    }

    public static FeedingScheduler getInstance() {
        if (instance == null) {
            instance = new FeedingScheduler();
        }
        return instance;
    }

    public void assignFeedingJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(keeper::feed));
    }
}
