package pl.dykacz.shop.data;

import pl.dykacz.shop.objects.Money;
import pl.dykacz.shop.objects.Name;

public class Product {
    private final Name name;
    private final Money price;

    public Product(Name name,Money price){
        this.name = name;
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    public Name getName() {
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
