package pl.bzawadka;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import pl.bzawadka.model.Car;
import pl.bzawadka.model.Currency;
import pl.bzawadka.model.Engine;
import pl.bzawadka.model.Price;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.bzawadka.model.Fuel.DIESEL;
import static pl.bzawadka.model.Make.AUDI;
import static pl.bzawadka.model.SaleType.FIXED_PRICE;

public class CarParserTest {

    private CarParser underTest;

    @Before
    public void setUp() {
        underTest = new CarParser();
    }

    @Test
    public void testParseCarFromComparisHtml() throws Exception {
        Document doc = readFile("audi-a6-2.7.html");
        Car expected = Car.builder()
                .withMake(AUDI)
                .withModel("A6")
                .withYear(2010)
                .withPrice(Price.builder()
                    .withPrice(12500)
                    .withCurrency(Currency.CHF)
                    .build())
                .withSaleType(FIXED_PRICE)
                .withEngine(Engine.builder()
                        .withFuel(DIESEL)
                        .withSize(2.7)
                        .withPower(190)
                        .build())
                .withUrl(new URL("http://comparis.ch/carfinder/marktplatz/details/show/20361616"))
                .build();

        Car actual = underTest.parseCar(doc);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    private Document readFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String html = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        return Jsoup.parse(html);
    }
}