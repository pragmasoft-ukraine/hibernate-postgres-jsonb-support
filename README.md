Simple PostgreSQL json and jsonb integration to Hibernate.

1. Add maven repo.
In you `pom.xml`:
```xml
<repositories>
    <repository>
        <id>hibernate-postgres-jsonb-support-mvn-repo</id>
        <url>https://raw.github.com/pragmasoft-ukraine/hibernate-postgres-jsonb-support/tree/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```

2. Add dependency:
In you `pom.xml`:
```xml
<dependency>
	<groupId>ua.com.pragmasoft.hibernate</groupId>
	<artifactId>jsonb</artifactId>
	<version>1.0</version>
</dependency>
```

3. Declare custom types definitions:
In `package-info.java` of your model's package:
```java
@TypeDefs({
	@TypeDef(name = "json", typeClass = JsonStringType.class),
	@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
package test.model;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import ua.com.pragmasoft.hibernate.jsonb.type.JsonBinaryType;
import ua.com.pragmasoft.hibernate.jsonb.type.JsonStringType;
```

4. Describe youe entity.
In your entity class:
```java
@org.hibernate.annotations.Type("json")
@javax.persistence.Column(name = "name", columnDefinition = "json")
private POJO name;
```
or
```java
@org.hibernate.annotations.Type("jsonb")
@javax.persistence.Column(name = "name", columnDefinition = "jsonb")
private POJO name;
```
