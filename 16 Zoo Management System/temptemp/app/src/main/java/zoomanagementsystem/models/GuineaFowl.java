package zoomanagementsystem.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GuineaFowl extends AbstractAnimal implements SmallAnimal, CanBeGroomed{
    private LocalDateTime lastGroomed;
    public GuineaFowl(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void feed() {
        System.out.println("<MMM what a hungry Guinea Fowl I am!>");
        super.feed();
    }
    @Override
    public void groom() {
        lastGroomed = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return MessageFormat.format("{0}; Last Groomed {1}", super.toString(), lastGroomed);
    }
}
