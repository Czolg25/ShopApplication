package pl.dykacz.shop.objects;

public class PercentObject {
    private final double amountOfPercent;

    public PercentObject(double percent) throws IllegalArgumentException {//0-100
        if (percent < 0 || percent > 100)
            throw new IllegalArgumentException("Invalid Percent Value");
        this.amountOfPercent = percent;
    }

    public double getPercentAsDouble() {
        return amountOfPercent / 100;
    }

    @Override
    public String toString() {
        return amountOfPercent + "%";
    }
}
