package pl.bzawadka.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.Fuel.DIESEL;

public class EngineTest {

    @Test
    public void testEquals() {
        Engine engine = Engine.builder()
                .setFuel(DIESEL)
                .setSize(2.0)
                .setPower(140)
                .createEngine();

        assertThat(engine).matches(
                e -> e.toString().endsWith("[fuel=DIESEL,size=2.0,power=140]"));
    }
}