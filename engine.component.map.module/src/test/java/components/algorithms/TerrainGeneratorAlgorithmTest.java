package components.algorithms;

import model.Board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import api.managers.BoardManager;
import api.managers.FieldManager;

import components.utilities.DiceUtility;
import components.utilities.LoggerUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/engine-component-map-module-spring.xml" })
public class TerrainGeneratorAlgorithmTest {

	@InjectMocks
	private TerrainGeneratorAlgorithmImpl testedAlgorithm;

	@Mock
	private BoardManager boardManager;

	@Mock
	private FieldManager fieldManager;

	@Mock
	private DiceUtility dice;

	@Mock
	private LoggerUtility log;

	@Captor
	private ArgumentCaptor<Board> boardCaptor;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateBoardDtoWithGeneratedTerrain() {

		// // Given
		// BoardSize boardSize = BoardSize.BIG;
		//
		// when(boardManager.getIterator(boardDtoCaptor.capture())).thenReturn(
		// new BoardIterator(boardDtoCaptor.getValue()));
		//
		// // When
		// BoardDto result = testedAlgorithm.createBoardDtoWithGeneratedTerrain(boardSize);
		//
		// // Then
		// assertNotNull(result);
		// assertEquals(result.getBoardSize(), boardSize);

	}

}
