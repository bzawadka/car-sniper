package pl.bzawadka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EngineSizeParser {
    private static Logger LOGGER = LoggerFactory.getLogger(EngineSizeParser.class);

    private static final Pattern ENGINE_SIZE_PATTERN = Pattern.compile("(.*)(\\d.\\d)(.*)");
    private static final int ENGINE_SIZE_REGEX_GROUP_NO = 2;
    private static final double ENGINE_SIZE_NOT_FOUND_VALUE = 0.0;

    public static double parseEngineSize(String carDescription) {
        Matcher matcher = ENGINE_SIZE_PATTERN.matcher(carDescription);
        if (matcher.find()) {
            return Double.valueOf(matcher.group(ENGINE_SIZE_REGEX_GROUP_NO));
        } else {
            LOGGER.warn("Engine size not matched from: " + carDescription);
            return ENGINE_SIZE_NOT_FOUND_VALUE;
        }
    }
}
