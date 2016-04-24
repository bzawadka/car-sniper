package pl.bzawadka.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Fuel.PETROL;

public class FuelTest {

    @Test
    public void testFrom() {
        assertThat(Fuel.from("diesel")).isEqualTo(DIESEL);
        assertThat(Fuel.from("DIESEL")).isEqualTo(DIESEL);
    }

    @Test
    public void testValueOf() {
        assertThat(Fuel.from("PETROL")).isEqualTo(PETROL);
    }

}