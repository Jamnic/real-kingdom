package repository;

import static org.junit.Assert.assertEquals;
import model.Creature;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/persistence-component-spring-test.xml" })
public class CreatureDaoTest {

	@Autowired
	private CreatureDao creatureDao;

	@Test
	public void testCRUD() {

		// Create
		creatureDao.save(new Creature());
		
		Creature willBeUpdated = new Creature();
		willBeUpdated.setName("Name");
		creatureDao.save(willBeUpdated);

		Creature willBeDeleted = new Creature();
		creatureDao.save(willBeDeleted);

		// Read
		assertEquals(creatureDao.findAll().size(), 3);

		// Update
		willBeUpdated.setName("New name");
		creatureDao.save(willBeUpdated);
		assertEquals(creatureDao.findAll().size(), 3);
		
		// Delete
		creatureDao.delete(willBeDeleted);
		assertEquals(creatureDao.findAll().size(), 2);

	}
}
