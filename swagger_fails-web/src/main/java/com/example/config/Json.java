package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.zalando.problem.ProblemModule;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Value.construct;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;
import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;
import static com.fasterxml.jackson.databind.DeserializationFeature.*;
import static com.fasterxml.jackson.databind.MapperFeature.*;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_ENUMS_USING_TO_STRING;
import static com.example.domain.enumeration.Constants.DEFAULT_TIMEZONE;

public class Json extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    public Json() {
        configure(this);
    }

    public void configure(ObjectMapper mapper) {
        mapper.setTimeZone(DEFAULT_TIMEZONE)
        .registerModules(
            new JavaTimeModule(),
            new ParameterNamesModule(PROPERTIES),
            new AfterburnerModule(),
            new ProblemModule()
        ).setSerializationInclusion(NON_ABSENT)
//            .disable(WRITE_DATES_AS_TIMESTAMPS)
        /*.setDefaultSetterInfo(empty().withValueNulls(SKIP, SKIP))*/
        .setDefaultVisibility(construct(PUBLIC_ONLY, PUBLIC_ONLY, PUBLIC_ONLY, PUBLIC_ONLY, PUBLIC_ONLY))
        .enable(ALLOW_EXPLICIT_PROPERTY_RENAMING, ACCEPT_CASE_INSENSITIVE_ENUMS, ACCEPT_CASE_INSENSITIVE_PROPERTIES)
        .enable(FAIL_ON_NUMBERS_FOR_ENUMS, READ_ENUMS_USING_TO_STRING)
        .enable(WRITE_ENUMS_USING_TO_STRING)
        .disable(ALLOW_FINAL_FIELDS_AS_MUTATORS)
        .disable(FAIL_ON_UNKNOWN_PROPERTIES/*, WRAP_EXCEPTIONS*/);
    }
}
