package pl.bzawadka.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @Test
    public void testGetters() {
        Price price = Price.builder()
                .setPrice(999)
                .setCurrency(Currency.CHF)
                .createPrice();

        assertThat(price.getPrice()).isEqualTo(999);
        assertThat(price.getCurrency()).isEqualTo(Currency.CHF);
    }

}