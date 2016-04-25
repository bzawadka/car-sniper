package pl.bzawadka;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.bzawadka.model.*;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.Objects.requireNonNull;
import static pl.bzawadka.model.SaleType.FIXED_PRICE;

public class CarParser {
    private static Logger LOGGER = LoggerFactory.getLogger(CarParser.class);

    private static final String CLASS_NAME_HEADLINE = "headlinecontainer";
    private static final String CLASS_NAME_TITLE = "title_container";
    private static final String CLASS_PRICE = "favorite_price_container";
    private static final String CLASS_NAME_GRID_ELEMENTS = "ym-grid-padding";
    private static final String CLASS_NAME_SUB_ELEMENTS = "ym-g33";
    private static final String BASE_URL = "http://comparis.ch";

    public Car parseCar(Document doc) {
        return Car.builder()
                .setMake(getMake(doc))
                .setModel(getModel(doc))
                .setYear(getYear(doc))
                .setPrice(getPrice(doc))
                .setSaleType(FIXED_PRICE)
                .setEngine(getEngine(doc))
                .setUrl(getUrl(doc))
                .createCar();
    }

    private Make getMake(Document doc) {
        String primaryTitle = getPrimaryTitle(doc);
        String firstWord = StringUtils.split(primaryTitle, " ")[0];
        return Make.valueOf(firstWord.toUpperCase());
    }

    private String getModel(Document doc) {
        String primaryTitle = getPrimaryTitle(doc);
        return StringUtils.split(primaryTitle, " ")[1];
    }

    private int getYear(Document doc) {
        Element gridElement = getGridElement(doc, 1);
        Element subElement = getSubElement(gridElement, 1);
        String year = StringUtils.split(subElement.text(), ".")[1];
        return Integer.valueOf(year);
    }

    private Price getPrice(Document doc) {
        Elements priceDiv = doc.getElementsByClass(CLASS_PRICE);
        requireNonNull(priceDiv, "price not found in doc " + doc);
        Elements b = priceDiv.get(0).select("b");
        String[] price = StringUtils.split(b.text(), " ");
        return Price.builder()
                .setCurrency(Currency.valueOf(price[0]))
                .setPrice(Integer.parseInt(StringUtils.remove(price[1], "'")))
                .createPrice();
    }

    private Engine getEngine(Document doc) {
        String fuelType = StringUtils.split(StringUtils.remove(getSubTitle(doc), ","), " ")[0];
        double engineSize = EngineSizeParser.parseEngineSize(getPrimaryTitle(doc));
        int enginePower = getEnginePower(doc);
        return Engine.builder()
                .setFuel(Fuel.from(fuelType))
                .setSize(engineSize)
                .setPower(enginePower)
                .createEngine();
    }

    private URL getUrl(Document doc) {
        Elements headline = doc.getElementsByClass(CLASS_NAME_HEADLINE);
        requireNonNull(headline, "headline not found in doc " + doc);
        String href = headline.get(0).select("a").first().attr("href");
        try {
            return new URL(BASE_URL + href);
        } catch (MalformedURLException e) {
            LOGGER.warn("malformed URL: " + href);
            return null;
        }
    }

    private int getEnginePower(Document doc) {
        Element gridElement = getGridElement(doc, 3);
        Element subElement = getSubElement(gridElement, 1);
        String powerInPs = StringUtils.remove(subElement.text(), " PS");
        return Integer.parseInt(powerInPs);
    }

    /**
     * Example: Audi A6 Avant 2.7 TDI
     */
    private String getPrimaryTitle(Document doc) {
        Elements headline = doc.getElementsByClass(CLASS_NAME_HEADLINE);
        requireNonNull(headline, "headline not found in doc " + doc);
        return headline.get(0).select("a").first().text();
    }

    /**
     * Example: Diesel, Manuell, Schwarz
     */
    private String getSubTitle(Document doc) {
        Elements title = doc.getElementsByClass(CLASS_NAME_TITLE);
        requireNonNull(title, "title not found in doc " + doc);
        String subTitle = title.get(0).select("a").get(1).text();
        requireNonNull(subTitle, "subtitle must be set");
        return subTitle;
    }

    private Element getGridElement(Document doc, int index) {
        return doc.getElementsByClass(CLASS_NAME_GRID_ELEMENTS).get(index);
    }

    private Element getSubElement(Element element, int index) {
        return element.getElementsByClass(CLASS_NAME_SUB_ELEMENTS).get(index);
    }
}
