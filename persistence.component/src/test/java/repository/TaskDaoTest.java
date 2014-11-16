package repository;

import static org.junit.Assert.assertEquals;
import model.Task;
import model.enums.PriorityType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/persistence-component-spring-test.xml" })
public class TaskDaoTest {

	@Autowired
	private TaskDao taskDao;

	@Test
	public void testCRUD() {

		// Create
		taskDao.save(new Task());

		Task willBeUpdated = new Task();
		willBeUpdated.setPriority(PriorityType.CRITICAL);
		taskDao.save(willBeUpdated);

		Task willBeDeleted = new Task();
		taskDao.save(willBeDeleted);

		// Read
		assertEquals(taskDao.findAll().size(), 3);

		// Update
		willBeUpdated.setPriority(PriorityType.MAJOR);
		taskDao.save(willBeUpdated);
		assertEquals(taskDao.findAll().size(), 3);

		// Delete
		taskDao.delete(willBeDeleted);
		assertEquals(taskDao.findAll().size(), 2);

	}
}
