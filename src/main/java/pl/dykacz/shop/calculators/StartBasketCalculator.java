package pl.dykacz.shop.calculators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.dykacz.shop.configuration.Configuration;
import pl.dykacz.shop.objects.MoneyObject;

@Component
@Profile("START")
public class StartBasketCalculator extends BasketCalculator {

    @Autowired
    public StartBasketCalculator(Configuration configuration) throws IllegalArgumentException {
        super(configuration);
    }

    @Override
    public MoneyObject calculate(MoneyObject price) {
        return price;
    }
}
