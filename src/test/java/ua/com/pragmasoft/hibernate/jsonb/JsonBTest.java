package ua.com.pragmasoft.hibernate.jsonb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.com.pragmasoft.hibernate.jsonb.model.*;

public class JsonBTest {

	EntityManagerFactory factory;

	@Before
	public void setUp() {
		factory = Persistence.createEntityManagerFactory("test");
	}

	@Test
	public void testJson() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		MainEntity entity = getMainEntity();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		manager = factory.createEntityManager();
		MainEntity loaded = manager.find(MainEntity.class, entity.getId());
		Assert.assertThat(loaded, IsNull.notNullValue());
		Assert.assertThat(loaded.getId(), Is.is(entity.getId()));
		Assert.assertThat(loaded.getSubEntity().getClass().getCanonicalName(), Is.is(FirstSubEntity.class.getCanonicalName()));
		System.out.println(loaded);
	}

	private MainEntity getMainEntity() {
		MainEntity entity = new MainEntity();
		entity.setName("test");
		List<SubEntity> subEntities = new ArrayList<>();
		FirstSubEntity fse = new FirstSubEntity();
		fse.setName("FSE");
		fse.setValue(50);
		SecondSubEntity sse = new SecondSubEntity();
		sse.setName("SSE");
		sse.setdValue(6.0);
		ThirdSubEntity tse = new ThirdSubEntity();
		tse.setName("tse");
		tse.setValue(60);
		subEntities.add(fse);
		subEntities.add(sse);
		subEntities.add(tse);
		entity.setSubEntityList(subEntities);
		fse = new FirstSubEntity();
		fse.setValue(70);
		entity.setSubEntity(fse);
		return entity;
	}

}
