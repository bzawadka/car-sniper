package pl.bzawadka.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.Fuel.DIESEL;

public class EngineTest {

    @Test
    public void testGetters() {
        Engine engine = Engine.builder()
                .setFuel(DIESEL)
                .setSize(2.0)
                .setPower(140)
                .createEngine();

        assertThat(engine.getFuel()).isEqualTo(DIESEL);
        assertThat(engine.getSize()).isEqualTo(2.0);
        assertThat(engine.getPower()).isEqualTo(140);
    }

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