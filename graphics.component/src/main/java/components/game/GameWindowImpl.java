package components.game;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.game.GameWindow;

import components.utilities.LoggerUtility;
import components.views.MainGamePanel;
import components.views.ViewPanel;
import components.views.WorldCreationPanel;

/**
 * Default implementation of {@link GameWindow}.
 */
@Component
public class GameWindowImpl extends JFrame implements GameWindow {

	@Autowired
	private LoggerUtility log;

	@Autowired
	private Game game;

	@Autowired
	private ViewPanel viewPanel;

	@Autowired
	private MainGamePanel mainGamePanel;

	@Autowired
	private WorldCreationPanel worldCreationPanel;

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public void initialize() {

		log.info(GameWindowImpl.class, "Initializing game window...");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension dimension = new Dimension(500, 400);

		setMaximumSize(dimension);
		setMinimumSize(dimension);
		setVisible(true);

		JPanel contentPane = new JPanel();

		contentPane.setOpaque(true);

		worldCreationPanel.initialize(dimension);
		mainGamePanel.initialize(dimension);
		viewPanel.initialize(dimension);

		mainGamePanel.showPanel();

		contentPane.add(mainGamePanel);
		contentPane.add(viewPanel);
		contentPane.add(worldCreationPanel);

		setContentPane(contentPane);

		log.info(GameWindowImpl.class, "Game window initialized!");

	}

	/* ========== Private ========== */
	private static final long serialVersionUID = 1092317308071541762L;

}
