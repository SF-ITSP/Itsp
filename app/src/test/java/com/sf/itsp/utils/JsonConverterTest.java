package com.sf.itsp.utils;

import com.google.gson.reflect.TypeToken;
import com.sf.app.library.utils.JsonConverter;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class JsonConverterTest {

    @Test
    public void should_convert_json_to_object() {
        // given
        JsonObject jsonObject = new JsonObject();
        jsonObject.anyBoolean = false;
        jsonObject.integer = 1;
        jsonObject.string = "test";

        // when
        String json = JsonConverter.toJson(jsonObject);

        // then
        assertThat(json).isEqualTo("{\"string\":\"test\",\"integer\":1,\"anyBoolean\":false}");
    }

    @Test
    public void should_parse_single_object_from_json() {
        // given
        String json = "{\"string\":\"test\",\"integer\":1,\"anyBoolean\":false}";

        // when
        JsonObject jsonToObject = JsonConverter.jsonToObject(json, TypeToken.get(JsonObject.class));

        // then
        assertThat(jsonToObject.string).isEqualTo("test");
        assertThat(jsonToObject.integer).isEqualTo(1);
        assertThat(jsonToObject.anyBoolean).isFalse();
    }

    @Test
    public void should_parse_list_from_json() {
        // given
        String json = "[{\"string\":\"test\",\"integer\":1,\"anyBoolean\":false},{\"string\":\"test2\",\"integer\":2,\"anyBoolean\":false}]";

        // when
        List<JsonObject> jsonObjects = JsonConverter.jsonFromObjectList(json, TypeToken.get(JsonObject[].class));

        // then
        assertThat(jsonObjects).hasSize(2);
        assertThat(jsonObjects.get(1).string).isEqualTo("test2");
        assertThat(jsonObjects.get(1).integer).isEqualTo(2);
        assertThat(jsonObjects.get(1).anyBoolean).isFalse();
    }

    private class JsonObject {
        private String string;
        private int integer;
        private boolean anyBoolean;
    }

}