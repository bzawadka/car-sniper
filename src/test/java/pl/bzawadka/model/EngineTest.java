package pl.bzawadka.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Fuel.PETROL;

public class EngineTest {

    @Test
    public void testGetters() {
        Engine engine = Engine.builder()
                .withFuel(DIESEL)
                .withSize(2.0)
                .withPower(140)
                .build();

        assertThat(engine.getFuel()).isEqualTo(DIESEL);
        assertThat(engine.getSize()).isEqualTo(2.0);
        assertThat(engine.getPower()).isEqualTo(140);
    }

    @Test
    public void testEquals() {
        Engine engine = Engine.builder()
                .withFuel(DIESEL)
                .withSize(2.0)
                .withPower(140)
                .build();

        assertThat(engine).matches(
                e -> e.toString().endsWith("[fuel=DIESEL,size=2.0,power=140]"));
    }

    @Test
    public void testDeserialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Engine engine = objectMapper.readValue("{\"fuel\":\"PETROL\",\"size\":2.5,\"power\":196}", Engine.class);
        assertThat(engine.getFuel()).isEqualTo(PETROL);
        assertThat(engine.getSize()).isEqualTo(2.5);
        assertThat(engine.getPower()).isEqualTo(196);
    }

}