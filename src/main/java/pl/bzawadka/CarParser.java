package pl.bzawadka;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.bzawadka.model.Car;
import pl.bzawadka.model.Currency;
import pl.bzawadka.model.Make;
import pl.bzawadka.model.Price;

import static java.util.Objects.requireNonNull;

public class CarParser {

    public static final String CLASS_NAME_HEADLINE = "headlinecontainer";
    public static final String CLASS_PRICE = "favorite_price_container";

    public Car parseCar(Document doc) {
        return Car.builder()
                .setMake(getMake(doc))
                .setModel(getModel(doc))
                .setPrice(getPrice(doc))
                .createCar();
    }

    private static Make getMake(Document doc) {
        Element headlineAnchor = getHeadlineAnchor(doc);
        String make = StringUtils.split(headlineAnchor.text(), " ")[0];
        return Make.valueOf(make.toUpperCase());
    }

    private static String getModel(Document doc) {
        Element headlineAnchor = getHeadlineAnchor(doc);
        return StringUtils.split(headlineAnchor.text(), " ")[1];
    }

    private static Element getHeadlineAnchor(Document doc) {
        Elements headline = doc.getElementsByClass(CLASS_NAME_HEADLINE);
        requireNonNull(headline, "headline not found in doc " + doc);
        return headline.get(0).select("a").first();
    }

    private static Price getPrice(Document doc) {
        Elements priceDiv = doc.getElementsByClass(CLASS_PRICE);
        requireNonNull(priceDiv, "price not found in doc " + doc);
        Elements b = priceDiv.get(0).select("b");
        String[] price = StringUtils.split(b.text(), " ");
        return Price.builder()
                .setCurrency(Currency.valueOf(price[0]))
                .setPrice(Integer.parseInt(StringUtils.remove(price[1], "'")))
                .createPrice();
    }
}
