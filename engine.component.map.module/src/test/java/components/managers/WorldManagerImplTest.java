package components.managers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import model.Board;
import model.World;
import model.enums.BoardSize;
import model.enums.WorldSize;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.managers.BoardManager;
import components.managers.WorldManagerImpl;
import repository.WorldDao;

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

//		// Given
//		String worldName = "Test_World_Name";
//		String boardName = "Test_Board_Name";
//		WorldSize worldSize = WorldSize.MEDIUM;
//		BoardSize boardSize = BoardSize.MEDIUM;
//		Board mainBoard = new Board();
//
//		when(boardManager.createBoardName(eq(worldName))).thenReturn(boardName);
//		when(boardManager.createNewBoard(eq(boardName), eq(boardSize))).thenReturn(mainBoard);
//
//		// When
//		World result = testedManager.createNewWorld(worldName, worldSize, boardSize);
//
//		// Then
//		assertNotNull(result);
//		assertEquals(result.getName(), worldName);
//		assertEquals(result.getWorldSize(), worldSize);
//
//		Board resultMainBoard = result.getMainBoard();
//		assertNotNull(resultMainBoard);
//		assertEquals(resultMainBoard, mainBoard);
//		assertEquals(resultMainBoard.getName(), boardName);
//		assertEquals(resultMainBoard.getBoardSize(), boardSize);

	}
}
