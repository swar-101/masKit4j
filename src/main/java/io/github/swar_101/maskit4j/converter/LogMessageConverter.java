package io.github.swar_101.maskit4j.converter;

import io.github.swar_101.maskit4j.MasKit4j;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

import java.util.Map;

@Log4j2
@Plugin(name = "LogMessageConverter", category = "Converter")
@ConverterKeys({"maskFields"})
public class LogMessageConverter extends LogEventPatternConverter {


    protected LogMessageConverter(String name, String style) {
        super(name, style);
    }



    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
//        MasKit4j.formatAndMask(event, toAppendTo);
    }
}