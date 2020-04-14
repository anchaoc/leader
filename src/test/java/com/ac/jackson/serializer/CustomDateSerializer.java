package com.ac.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** 自定义序列化
 * @author anchao
 * @date 2020/4/14 12:34
 **/
public class CustomDateSerializer extends JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter dateFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (ObjectUtils.isEmpty(value)) {
            return;
        }
        String format = value.format(dateFormatter);
        gen.writeString(format);
    }
}
