package com.example;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.config.Json;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.oas.integration.api.ObjectMapperProcessor;
import io.swagger.v3.oas.models.media.*;

import javax.ws.rs.core.StreamingOutput;
import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.time.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import static com.example.domain.enumeration.Constants.LOCALE_PATTERN;
import static com.example.domain.enumeration.Constants.PERIOD_PATTERN;


public class OpenApiConfig implements ModelConverter, ObjectMapperProcessor {

    private static final List<String>
        WRAPPER_CLASSES,
        SKIPPABLE_PACKAGES;

    static {
        WRAPPER_CLASSES = new ArrayList<>();
        WRAPPER_CLASSES.add("io.reactivex.Single");
        WRAPPER_CLASSES.add("io.reactivex.Observable");
        WRAPPER_CLASSES.add("io.reactivex.Flowable");
        WRAPPER_CLASSES.add("io.reactivex.Maybe");
        WRAPPER_CLASSES.add("java.util.concurrent.CompletableFuture");
        WRAPPER_CLASSES.add("java.util.concurrent.CompletionStage");

        SKIPPABLE_PACKAGES = new ArrayList<>();
        SKIPPABLE_PACKAGES.add("com.example.filter");
        SKIPPABLE_PACKAGES.add("com.example.criteria");
        SKIPPABLE_PACKAGES.add("java.lang.Void");
    }

    private final Json mapper = new Json();

    @Override
    public Schema<?> resolve(AnnotatedType type, ModelConverterContext context, Iterator<ModelConverter> chain) {
        if (SKIPPABLE_PACKAGES.stream().anyMatch(type.getType().getTypeName()::contains)) return null;
        if (type.getType() instanceof ParameterizedType) {
            ParameterizedType param = (ParameterizedType) type.getType();
            if (WRAPPER_CLASSES.contains(param.getRawType().getTypeName()))
                return chain.next().resolve(new AnnotatedType(param.getActualTypeArguments()[0]), context, chain);
        }
        if (type.isSchemaProperty()) {
            JavaType _type = mapper.constructType(type.getType());
            if (_type != null) {
                Class<?> cls = _type.getRawClass();
                // Try to put checks in the order from most frequently-used
                // to less frequently-used in the code-base
                if (Instant.class.isAssignableFrom(cls))
                    return new ComposedSchema().addAnyOfItem(new DateTimeSchema()).addAnyOfItem(new IntegerSchema().format("int64"));
                if (Year.class.isAssignableFrom(cls))
                    return new ComposedSchema().addAnyOfItem(new StringSchema()).addAnyOfItem(new IntegerSchema()).pattern("^\\d{4}$").example("2018");
                if (Period.class.isAssignableFrom(cls))
                    return new StringSchema().format("ISO 8601").pattern(PERIOD_PATTERN).example("-P3Y+6M25W-15D");
                if (LocalDate.class.isAssignableFrom(cls))
                    return new DateSchema().pattern("\\d{4}-\\d{2}-\\d{2}").example("'2018-09-09'");
                if (ZoneId.class.isAssignableFrom(cls))
                    return new StringSchema().format("time_zone").example("America/Los_Angeles");
                if (Locale.class.isAssignableFrom(cls))
                    return new StringSchema().format("ISO 3166-1 alpha-2").pattern(LOCALE_PATTERN).example("de_DE");
                if (ByteBuffer.class.isAssignableFrom(cls))
                    return new FileSchema();
                if (StreamingOutput.class.isAssignableFrom(cls))
                    return new FileSchema();
            }
        }
        return chain.hasNext() ? chain.next().resolve(type, context, chain) : null;
    }

    @Override
    public void processJsonObjectMapper(ObjectMapper mapper) {
        this.mapper.configure(mapper);
    }

    @Override
    public void processYamlObjectMapper(ObjectMapper mapper) {
        this.mapper.configure(mapper);
    }
}
