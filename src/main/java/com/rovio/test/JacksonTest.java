package com.rovio.test;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.collect.ImmutableList;

public class JacksonTest {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new GuavaModule())
            .setDefaultSetterInfo(JsonSetter.Value.forContentNulls(Nulls.AS_EMPTY));

    public static void main(String[] args) throws Exception {
        String json = MAPPER.writeValueAsString(new TestClass());
        MAPPER.readValue(json, TestClass.class);
    }

    public static class TestClass {
        public ImmutableList<ImmutableList<String>> lists = ImmutableList.of();
    }
}
