package pl.dykacz.shop.calculators;

import pl.dykacz.shop.configuration.Configuration;
import pl.dykacz.shop.objects.Money;
import pl.dykacz.shop.objects.Percent;

public abstract class BasketCalculator {
    protected final Percent vat;
    protected final Percent discount;

    public BasketCalculator(Configuration configuration) throws IllegalArgumentException {
        this.vat = new Percent(configuration.getVAT());
        this.discount = new Percent(configuration.getDiscount());
    }

    public abstract Money calculate(Money price);
}
