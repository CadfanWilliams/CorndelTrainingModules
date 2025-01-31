package zoomanagementsystem.services;

import zoomanagementsystem.models.Animal;
import zoomanagementsystem.models.Keeper;
import java.util.List;

public abstract class JobScheduler {
    protected static JobScheduler instance;

    protected JobScheduler() {}

    public abstract void assignJobs(final List<? extends Keeper<? extends Animal>> keepers);
}
