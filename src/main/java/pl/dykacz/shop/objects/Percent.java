package pl.dykacz.shop.objects;

public class Percent {
    private final double percent;

    public Percent(double percent) throws IllegalArgumentException {//0-100
        if(percent < 0 || percent > 100)
            throw new IllegalArgumentException("Invalid Percent Value");
        this.percent = percent;
    }

    public double getPercent() {
        return percent/100;
    }

    @Override
    public String toString() {
        return percent+"%";
    }
}
