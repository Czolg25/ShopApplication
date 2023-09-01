package pl.dykacz.shop.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {
    private static final int VAT = 23;
    @Value("${shop-discount}")
    private String discount;

    public int getVAT() {
        return VAT;
    }

    public int getDiscount() {
        return Integer.parseInt(discount);
    }
}
