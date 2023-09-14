package pl.dykacz.shop.calculators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.dykacz.shop.configuration.Configuration;
import pl.dykacz.shop.objects.MoneyObject;

@Component
@Profile("PRO")
public class ProBasketCalculator extends BasketCalculator {

    @Autowired
    public ProBasketCalculator(Configuration configuration) throws IllegalArgumentException {
        super(configuration);
    }

    @Override
    public MoneyObject calculate(MoneyObject price) {
        MoneyObject priceCalculated = price.add(price.multiply(vat));
        return priceCalculated.minus(price.multiply(discount));
    }
}
