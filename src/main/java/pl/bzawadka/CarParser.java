package pl.bzawadka;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.bzawadka.model.*;

import static java.util.Objects.requireNonNull;
import static pl.bzawadka.model.SaleType.FIXED_PRICE;

public class CarParser {

    private static final String CLASS_NAME_HEADLINE = "headlinecontainer";
    private static final String CLASS_NAME_TITLE = "title_container";
    private static final String CLASS_PRICE = "favorite_price_container";
    private static final String CLASS_NAME_GRID_ELEMENTS = "ym-grid-padding";
    private static final String CLASS_NAME_SUB_ELEMENTS = "ym-g33";

    public Car parseCar(Document doc) {
        return Car.builder()
                .setMake(getMake(doc))
                .setModel(getModel(doc))
                .setYear(getYear(doc))
                .setPrice(getPrice(doc))
                .setSaleType(FIXED_PRICE)
                .setEngine(getEngine(doc))
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

    private Element getGridElement(Document doc, int index) {
        return doc.getElementsByClass(CLASS_NAME_GRID_ELEMENTS).get(index);
    }

    private Element getSubElement(Element element, int index) {
        return element.getElementsByClass(CLASS_NAME_SUB_ELEMENTS).get(index);
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
        String subTitle = getSubTitle(doc);
        String fuelType = StringUtils.split(StringUtils.remove(subTitle, ","), " ")[0];

        return Engine.builder()
                .setFuel(Fuel.from(fuelType))
                .createEngine();
    }
}
