package ua.com.pragmasoft.hibernate.jsonb.type;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class JsonPostgresqlDialect extends PostgreSQL9Dialect {

	public JsonPostgresqlDialect() {
		registerColumnType(Types.OTHER, "json");
		registerColumnType(Types.OTHER, "jsonb");
	}

	@Override
	public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {

		return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
	}
}
