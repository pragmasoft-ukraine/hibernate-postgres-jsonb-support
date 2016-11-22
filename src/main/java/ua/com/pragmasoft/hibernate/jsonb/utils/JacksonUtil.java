package ua.com.pragmasoft.hibernate.jsonb.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ServiceLoader;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonUtil {

	private static SerializerFactory serializer = new DefaultFactory();

	static {
		ServiceLoader<SerializerFactory> factory = ServiceLoader.load(SerializerFactory.class);
		if(factory.iterator().hasNext()) {
			serializer = factory.iterator().next();
		}
	}

	public static <T> T fromString(String string, Class<T> clazz) {
		try {
			return serializer.instance().readValue(string, clazz);
		} catch (IOException e) {
			throw new IllegalArgumentException("The given string value: "
				+ string + " cannot be transformed to Json object");
		}
	}

	public static String toString(Object value) {
		try {
			return serializer.instance().writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("The given Json object value: "
				+ value + " cannot be transformed to a String");
		}
	}

	public static JsonNode toJsonNode(String value) {
		try {
			return serializer.instance().readTree(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T clone(T value) {
		return fromString(toString(value), (Class<T>) value.getClass());
	}

	private static class DefaultFactory implements SerializerFactory {

		private ObjectMapper mapper = new ObjectMapper();

		DefaultFactory() {
			mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
		}

		@Override
		public ObjectMapper instance() {
			return mapper;
		}
	}

}
