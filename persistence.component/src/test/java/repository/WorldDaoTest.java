package repository;

import static org.junit.Assert.assertEquals;
import model.World;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/persistence-component-spring-test.xml" })
public class WorldDaoTest {

	@Autowired
	private WorldDao worldDao;

	@Test
	public void testCRUD() {

		// Create
		worldDao.save(new World());
		
		World willBeUpdated = new World();
		willBeUpdated.setName("Name");
		worldDao.save(willBeUpdated);

		World willBeDeleted = new World();
		worldDao.save(willBeDeleted);

		// Read
		assertEquals(worldDao.findAll().size(), 3);

		// Update
		willBeUpdated.setName("New name");
		worldDao.save(willBeUpdated);
		assertEquals(worldDao.findAll().size(), 3);
		
		// Delete
		worldDao.delete(willBeDeleted);
		assertEquals(worldDao.findAll().size(), 2);

	}
}
