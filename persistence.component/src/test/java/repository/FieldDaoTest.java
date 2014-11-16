package repository;

import static org.junit.Assert.assertEquals;
import model.Field;
import model.enums.TerrainType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/persistence-component-spring-test.xml" })
public class FieldDaoTest {

	@Autowired
	private FieldDao worldDao;

	@Test
	public void testCRUD() {

		// Create
		worldDao.save(new Field());
		
		Field willBeUpdated = new Field();
		willBeUpdated.setTerrainType(TerrainType.OCEANS);
		worldDao.save(willBeUpdated);

		Field willBeDeleted = new Field();
		worldDao.save(willBeDeleted);

		// Read
		assertEquals(worldDao.findAll().size(), 3);

		// Update
		willBeUpdated.setTerrainType(TerrainType.WASTELANDS);
		worldDao.save(willBeUpdated);
		assertEquals(worldDao.findAll().size(), 3);
		
		// Delete
		worldDao.delete(willBeDeleted);
		assertEquals(worldDao.findAll().size(), 2);

	}
}
