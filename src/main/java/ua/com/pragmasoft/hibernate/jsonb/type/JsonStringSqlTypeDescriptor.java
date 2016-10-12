package ua.com.pragmasoft.hibernate.jsonb.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicBinder;
import org.postgresql.util.PGobject;

class JsonStringSqlTypeDescriptor extends AbstractJsonSqlTypeDescriptor {

	static final JsonStringSqlTypeDescriptor INSTANCE =
		new JsonStringSqlTypeDescriptor();

	@Override
	public <X> ValueBinder<X> getBinder(
		final JavaTypeDescriptor<X> javaTypeDescriptor) {
		return new BasicBinder<X>(javaTypeDescriptor, this) {
			@Override
			protected void doBind(
				PreparedStatement st,
				X value,
				int index,
				WrapperOptions options) throws SQLException {
				PGobject pGobject = new PGobject();
				pGobject.setType("json");
				pGobject.setValue(javaTypeDescriptor.unwrap(value, String.class, options));
				st.setObject(index,
					pGobject
				);
			}

			protected void doBind(
				CallableStatement st,
				X value,
				String name,
				WrapperOptions options)
				throws SQLException {
				PGobject pGobject = new PGobject();
				pGobject.setType("json");
				pGobject.setValue(javaTypeDescriptor.unwrap(value, String.class, options));
				st.setObject(name,
					pGobject
					);
			}
		};
	}

}
