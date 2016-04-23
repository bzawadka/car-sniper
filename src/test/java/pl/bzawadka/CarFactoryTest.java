package pl.bzawadka;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import pl.bzawadka.model.Car;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @Test
    public void testCarIsParsedFromHtml() throws Exception {
        String html = readFile("audi-a6-2.7.html");
        Car car = CarFactory.parseHtml(html);
        assertThat(car).isEqualToComparingFieldByField(null);
    }

    private String readFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(classLoader.getResourceAsStream(fileName));
    }
}