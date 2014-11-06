package repository;

import static org.junit.Assert.assertEquals;
import model.Hero;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/persistence-component-spring-test.xml" })
public class HeroDaoTest {

	@Autowired
	private HeroDao heroDao;

	@Test
	public void testCRUD() {

		// Create
		heroDao.save(new Hero());

		Hero willBeUpdated = new Hero();
		willBeUpdated.setName("Name");
		heroDao.save(willBeUpdated);

		Hero willBeDeleted = new Hero();
		heroDao.save(willBeDeleted);

		// Read
		assertEquals(heroDao.findAll().size(), 3);

		// Update
		willBeUpdated.setName("New name");
		heroDao.save(willBeUpdated);
		assertEquals(heroDao.findAll().size(), 3);

		// Delete
		heroDao.delete(willBeDeleted);
		assertEquals(heroDao.findAll().size(), 2);

	}
}
