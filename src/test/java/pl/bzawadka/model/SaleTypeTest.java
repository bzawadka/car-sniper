package pl.bzawadka.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.SaleType.AUCTION;
import static pl.bzawadka.model.SaleType.FIXED_PRICE;

public class SaleTypeTest {

    @Test
    public void testFrom() {
        assertThat(SaleType.from("auction")).isEqualTo(AUCTION);
        assertThat(SaleType.from("AUCTION")).isEqualTo(AUCTION);
    }

    @Test
    public void testValueOf() {
        assertThat(SaleType.from("FIXED_PRICE")).isEqualTo(FIXED_PRICE);
    }
}