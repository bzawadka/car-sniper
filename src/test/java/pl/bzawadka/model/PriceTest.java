package pl.bzawadka.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @Test
    public void testGetters() {
        Price price = Price.builder()
                .withPrice(999)
                .withCurrency(Currency.CHF)
                .build();

        assertThat(price.getPrice()).isEqualTo(999);
        assertThat(price.getCurrency()).isEqualTo(Currency.CHF);
    }

    @Test
    public void testDeserialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Price price = objectMapper.readValue("{\"price\":1234,\"currency\":\"CHF\"}", Price.class);
        assertThat(price.getPrice()).isEqualTo(1234);
        assertThat(price.getCurrency()).isEqualTo(Currency.CHF);
    }

}