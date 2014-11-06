package repository;

import static org.junit.Assert.assertEquals;
import model.Sprite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/persistence-component-spring-test.xml" })
public class SpriteDaoTest {

	@Autowired
	private SpriteDao spriteDao;

	@Test
	public void testCRUD() {

		// Create
		spriteDao.save(new Sprite());

		Sprite willBeUpdated = new Sprite();
		willBeUpdated.setImage(new byte[1]);
		spriteDao.save(willBeUpdated);

		Sprite willBeDeleted = new Sprite();
		spriteDao.save(willBeDeleted);

		// Read
		assertEquals(spriteDao.findAll().size(), 3);

		// Update
		willBeUpdated.setImage(new byte[1]);
		spriteDao.save(willBeUpdated);
		assertEquals(spriteDao.findAll().size(), 3);

		// Delete
		spriteDao.delete(willBeDeleted);
		assertEquals(spriteDao.findAll().size(), 2);

	}
}
