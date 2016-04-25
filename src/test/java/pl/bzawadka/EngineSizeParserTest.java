package pl.bzawadka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class EngineSizeParserTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Audi A6 Avant 2.7 TDI", 2.7 },
                { "Audi A6 allroad 3.0TDI quattro", 3.0 },
                { "Audi A6 Avant 2.0", 2.0 },
                { "1.8 AUDI A3 TFSI Cabrio Attraction", 1.8 },
                { "1.0", 1.0 },
        });
    }

    @Parameter(value = 0)
    public String carDescription;

    @Parameter(value = 1)
    public double expectedEngineSize;

    @Test
    public void testParseEngineSize() {
        assertThat(EngineSizeParser.parseEngineSize(carDescription)).isEqualTo(expectedEngineSize);
    }

}