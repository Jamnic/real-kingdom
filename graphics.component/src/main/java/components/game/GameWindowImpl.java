package components.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.World;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import views.MainGamePanel;
import views.WorldCreationPanel;
import api.game.GameWindow;
import api.services.WorldService;

/**
 * Default implementation of {@link GameWindow}.
 */
@Component
public class GameWindowImpl extends JFrame implements GameWindow {

	@Autowired
	private Game game;

	@Autowired
	public WorldService worldService;

	/* ========== Public ========== */
	public WorldCreationPanel worldCreationPanel;
	public MainGamePanel mainGamePanel;

	/** {@inheritDoc} */
	public void initialize() {
		
		World[] availableWorlds = worldService.getAvailableWorlds();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = new Dimension(100, 200);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
		setVisible(true);
		setBackground(new Color(0, 0, 255));

		worldCreationPanel = new WorldCreationPanel(this);
		worldCreationPanel.setVisible(false);
		worldCreationPanel.setPreferredSize(dimension);
		worldCreationPanel.setSize(dimension);
		
		mainGamePanel = new MainGamePanel(this);
		mainGamePanel.setVisible(true);
		mainGamePanel.setPreferredSize(dimension);
		mainGamePanel.setSize(dimension);

		this.add(worldCreationPanel);
		this.add(mainGamePanel);
		
		

	}

	/* ========== Private ========== */
	private static final long serialVersionUID = 1092317308071541762L;

}
