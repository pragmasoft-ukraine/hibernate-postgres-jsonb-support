package ua.com.pragmasoft.hibernate.jsonb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface SerializerFactory {
	ObjectMapper instance();
}
