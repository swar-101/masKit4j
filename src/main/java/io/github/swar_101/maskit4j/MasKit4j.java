package io.github.swar_101.maskit4j;

import io.github.swar_101.maskit4j.exception.MasKit4jPropertiesException;
import org.apache.logging.log4j.core.LogEvent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;


public class MasKit4j {
    private static final Map<String, String> masKit4jProperties;

    static {
        masKit4jProperties = MasKit4j.load();
    }

    private static final String MASKIT4J_PROPERTIES_FILENAME = "maskit4j.properties";
    private static final String MASKIT4J_PROPERTIES_NOT_FOUND_MSG = "MasKit4j Property file not found";
    private static final String MASKIT4J_PROPERTIES_LOADING_FAILED_MSG = "Loading MasKit4j Property file failed.";

    public static Map<String, String> load() {
        Properties properties = new Properties();
        try (InputStream input = MasKit4j.class
                .getClassLoader().getResourceAsStream(MASKIT4J_PROPERTIES_FILENAME)) {

            if (input == null) {
                throw new MasKit4jPropertiesException(MASKIT4J_PROPERTIES_NOT_FOUND_MSG);
            }
            properties.load(input);

            for (String key : properties.stringPropertyNames()) {
                masKit4jProperties.put(key, properties.getProperty(key));
            }

            return masKit4jProperties;
        } catch (IOException e) {
            throw new MasKit4jPropertiesException(MASKIT4J_PROPERTIES_LOADING_FAILED_MSG, e);
        }
    }

    public static void formatAndMask(LogEvent event, StringBuilder toAppendTo) {
        String messageString = toAppendTo.toString();
        String maskedInputMessage = maskSensitiveData(messageString);
        toAppendTo.delete(0, toAppendTo.length());
        toAppendTo.append(maskedInputMessage);
    }

    private static String maskSensitiveData(String messageString) {
        return "";
    }
}