package pl.dykacz.shop.calculators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.dykacz.shop.configuration.Configuration;
import pl.dykacz.shop.objects.Money;

@Component
@Profile("PLUS")
public class PlusBasketCalculator extends BasketCalculator{

    @Autowired
    public PlusBasketCalculator(Configuration configuration) throws IllegalArgumentException{
        super(configuration);
    }

    @Override
    public Money calculate(Money price) {
        return price.add(price.multiply(vat));
    }
}
