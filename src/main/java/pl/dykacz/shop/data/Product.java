package pl.dykacz.shop.data;

import pl.dykacz.shop.objects.MoneyObject;
import pl.dykacz.shop.objects.NameObject;

public class Product {
    private final NameObject name;
    private final MoneyObject price;

    public Product(NameObject name, MoneyObject price) {
        this.name = name;
        this.price = price;
    }

    public MoneyObject getPrice() {
        return price;
    }

    public NameObject getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", price=" + price +
                '}';
    }
}
