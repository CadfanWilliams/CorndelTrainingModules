package zoomanagementsystem.models;

import java.time.LocalDate;

public class Elephant extends AbstractAnimal implements LargeAnimal, NeedsMuckSweeping{
    public Elephant(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void feed() {
        System.out.println("<*Elephant Noise* I am such a hungry elephant call me el hunger>");
        super.feed();
    }
    @Override
    public void sweep(){
        System.out.println("I am such a stinky elephant, thanks for sweeping my poo");
    }


}
