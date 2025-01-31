package counter.items;

import counter.Countable;

import java.time.LocalDate;
import java.util.Objects;

public final class Apple implements Countable {
    private final Colour colour;
    private final LocalDate datePicked;
    private final LocalDate bestBefore;

    public Apple(Colour colour, LocalDate datePicked, LocalDate bestBefore) {
        this.colour = colour;
        this.datePicked = datePicked;
        this.bestBefore = bestBefore;
    }

    public int getCount() {
        return 1;
    }

    public Colour colour() {
        return colour;
    }

    public LocalDate datePicked() {
        return datePicked;
    }

    public LocalDate bestBefore() {
        return bestBefore;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Apple that = (Apple) obj;
        return Objects.equals(this.colour, that.colour) &&
            Objects.equals(this.datePicked, that.datePicked) &&
            Objects.equals(this.bestBefore, that.bestBefore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, datePicked, bestBefore);
    }

    @Override
    public String toString() {
        return "Apple[" +
            "colour=" + colour + ", " +
            "datePicked=" + datePicked + ", " +
            "bestBefore=" + bestBefore + ']';
    }

}
