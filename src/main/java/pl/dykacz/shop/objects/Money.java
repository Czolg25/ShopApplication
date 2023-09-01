package pl.dykacz.shop.objects;

public class Money {
    private final long moneyAmount;

    public Money(long money){
        if(money<0)
            throw new IllegalArgumentException("money cannot be below 0!");

        this.moneyAmount = money;
    }

    //moneyFirstPart.moneySecondPart
    public Money(int moneyFirstPart,int moneySecondPart){
        if(moneyFirstPart<0||moneySecondPart<0)
            throw new IllegalArgumentException("money cannot be below 0!");
        if(moneySecondPart > 100)
            throw new IllegalArgumentException("money second part cannot be above 100!");

        this.moneyAmount = (long) moneyFirstPart*1_000_000+(long) moneySecondPart*10_000;
    }

    public Money add(Money money){
        long moneyAmount = this.moneyAmount+money.moneyAmount;
        return new Money(moneyAmount);
    }
    public Money minus(Money money){
        long moneyAmount = this.moneyAmount-money.moneyAmount;
        return new Money(moneyAmount);
    }

    public Money multiply(Percent percent){
        long moneyAmount = (long) (this.moneyAmount* percent.getPercent());
        return new Money(moneyAmount);
    }

    @Override
    public String toString() {
        long moneyFirstPart = this.moneyAmount / 1_000_000;
        long moneySecondPart = this.moneyAmount % 1_000_000+1_000_000;

        return moneyFirstPart+"."+String.valueOf(moneySecondPart).substring(1,3)+" PLN";
    }
}
