@TypeDefs({
	@TypeDef(name = "json", typeClass = JsonStringType.class),
	@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
package ua.com.pragmasoft.hibernate.jsonb.model;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import ua.com.pragmasoft.hibernate.jsonb.type.JsonBinaryType;
import ua.com.pragmasoft.hibernate.jsonb.type.JsonStringType;