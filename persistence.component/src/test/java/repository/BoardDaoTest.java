package repository;

import static org.junit.Assert.assertEquals;
import model.Board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/persistence-component-spring-test.xml" })
public class BoardDaoTest {

	@Autowired
	private BoardDao boardDao;

	@Test
	public void testCRUD() {

		// Create
		boardDao.save(new Board());

		Board willBeUpdated = new Board();
		willBeUpdated.setName("Name");
		boardDao.save(willBeUpdated);

		Board willBeDeleted = new Board();
		boardDao.save(willBeDeleted);

		// Read
		assertEquals(boardDao.findAll().size(), 3);

		// Update
		willBeUpdated.setName("New name");
		boardDao.save(willBeUpdated);
		assertEquals(boardDao.findAll().size(), 3);

		// Delete
		boardDao.delete(willBeDeleted);
		assertEquals(boardDao.findAll().size(), 2);

	}
}
