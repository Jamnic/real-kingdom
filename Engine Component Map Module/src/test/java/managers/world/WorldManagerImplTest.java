package managers.world;

import managers.world.WorldManagerImpl;
import model.enums.WorldSize;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.WorldDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/engine-component-map-module-spring.xml" })
public class WorldManagerImplTest {

	@InjectMocks
	private WorldManagerImpl testedManager;

	@Mock
	private WorldDao worldDao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateNewWorld() {

		testedManager.createNewWorld("Test", WorldSize.MEDIUM);
		
	}

}
