package ua.com.pragmasoft.hibernate.jsonb.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonUtil {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	static {
		OBJECT_MAPPER.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	}

	public static <T> T fromString(String string, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(string, new TypeReference<T>() {});
		} catch (IOException e) {
			throw new IllegalArgumentException("The given string value: "
				+ string + " cannot be transformed to Json object");
		}
	}

	public static String toString(Object value) {
		try {
			return OBJECT_MAPPER.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("The given Json object value: "
				+ value + " cannot be transformed to a String");
		}
	}

	public static JsonNode toJsonNode(String value) {
		try {
			return OBJECT_MAPPER.readTree(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T clone(T value) {
		return fromString(toString(value), (Class<T>) value.getClass());
	}

}
