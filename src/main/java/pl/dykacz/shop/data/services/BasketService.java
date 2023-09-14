package pl.dykacz.shop.data.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.dykacz.shop.calculators.BasketCalculator;
import pl.dykacz.shop.data.Product;
import pl.dykacz.shop.objects.MoneyObject;
import pl.dykacz.shop.objects.NameObject;

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
    public BasketService(BasketCalculator basketCalculator) {
        this.basketCalculator = basketCalculator;
        this.logger = LoggerFactory.getLogger(BasketService.class);
        this.products = getRandomProducts(5);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        this.logger.info(products.toString());
        this.logger.info(calculateSumNormalPrice().toString());
        this.logger.info(calculateSumPrice().toString());
    }

    public MoneyObject calculateSumPrice() {
        MoneyObject price = calculateSumNormalPrice();
        return this.basketCalculator.calculate(price);
    }

    private MoneyObject calculateSumNormalPrice() {
        MoneyObject price = new MoneyObject(0);

        for (Product product : this.products) {
            price = price.add(product.getPrice());
        }

        return price;
    }

    private List<Product> getRandomProducts(int number) {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            NameObject name = new NameObject("Product " + i);
            MoneyObject money = new MoneyObject(RANDOM.nextInt(250) + 50, RANDOM.nextInt(100));
            Product product = new Product(name, money);
            products.add(product);
        }

        return products;
    }
}
