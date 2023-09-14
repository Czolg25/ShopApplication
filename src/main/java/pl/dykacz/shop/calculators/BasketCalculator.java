package pl.dykacz.shop.calculators;

import pl.dykacz.shop.configuration.Configuration;
import pl.dykacz.shop.objects.MoneyObject;
import pl.dykacz.shop.objects.PercentObject;

public abstract class BasketCalculator {
    protected final PercentObject vat;
    protected final PercentObject discount;

    public BasketCalculator(Configuration configuration) throws IllegalArgumentException {
        this.vat = new PercentObject(configuration.getVAT());
        this.discount = new PercentObject(configuration.getDiscount());
    }

    public abstract MoneyObject calculate(MoneyObject price);
}
