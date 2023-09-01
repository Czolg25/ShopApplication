package pl.dykacz.shop.data.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.dykacz.shop.calculators.BasketCalculator;
import pl.dykacz.shop.data.Product;
import pl.dykacz.shop.objects.Money;
import pl.dykacz.shop.objects.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BasketService {
    private static final Random RANDOM = new Random();
    private final Logger logger;
    private final BasketCalculator basketCalculator;

    private List<Product> products;

    @Autowired
    public BasketService(BasketCalculator basketCalculator){
        this.basketCalculator = basketCalculator;
        this.logger = LoggerFactory.getLogger(BasketService.class);
        this.products = getRandomProducts(5);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        this.logger.info(products.toString());
        this.logger.info(calculateSumNormalPrice().toString());
        this.logger.info(calculateSumPrice().toString());
    }

    public Money calculateSumPrice(){
        Money price = calculateSumNormalPrice();
        return this.basketCalculator.calculate(price);
    }

    private Money calculateSumNormalPrice(){
        Money price = new Money(0);

        for (Product product : this.products) {
            price = price.add(product.getPrice());
        }

        return price;
    }

    private List<Product> getRandomProducts(int number){
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Name name = new Name("Product "+i);
            Money money = new Money(RANDOM.nextInt(250)+50,RANDOM.nextInt(100));
            Product product = new Product(name,money);
            products.add(product);
        }

        return products;
    }
}
