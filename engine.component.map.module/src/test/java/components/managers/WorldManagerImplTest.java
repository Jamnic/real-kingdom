package components.managers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.WorldDao;
import api.managers.BoardManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/engine-component-map-module-spring.xml" })
public class WorldManagerImplTest {

	@InjectMocks
	private WorldManagerImpl testedManager;

	@Mock
	private BoardManager boardManager;

	@Mock
	private WorldDao worldDao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateNewWorld() {

		// // Given
		// String worldName = "Test_World_Name";
		// String boardName = "Test_Board_Name";
		// WorldSize worldSize = WorldSize.MEDIUM;
		// BoardSize boardSize = BoardSize.MEDIUM;
		// Board mainBoard = new Board();
		//
		// when(boardManager.createBoardName(eq(worldName))).thenReturn(boardName);
		// when(boardManager.createNewBoard(eq(boardName), eq(boardSize))).thenReturn(mainBoard);
		//
		// // When
		// World result = testedManager.createNewWorld(worldName, worldSize, boardSize);
		//
		// // Then
		// assertNotNull(result);
		// assertEquals(result.getName(), worldName);
		// assertEquals(result.getWorldSize(), worldSize);
		//
		// Board resultMainBoard = result.getMainBoard();
		// assertNotNull(resultMainBoard);
		// assertEquals(resultMainBoard, mainBoard);
		// assertEquals(resultMainBoard.getName(), boardName);
		// assertEquals(resultMainBoard.getBoardSize(), boardSize);

	}
}
