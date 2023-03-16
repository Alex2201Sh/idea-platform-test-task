package by.shumilov.service;

import by.shumilov.bean.TicketList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import java.io.IOException;
import java.util.Locale;

public class TicketParser {

    public static TicketList getTickets(String json) {
        try {
            return newMapper().readValue(json, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ObjectMapper newMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setLocale(Locale.ENGLISH);
        mapper.registerModule(new JSR310Module());
        return mapper;
    }
}
