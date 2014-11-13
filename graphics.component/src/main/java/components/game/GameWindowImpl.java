package components.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

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
	@Override
	public void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMaximumSize(new Dimension(100, 200));
		setMinimumSize(new Dimension(100, 200));
		setVisible(true);
		setBackground(new Color(0, 0, 255));

		mainGamePanel = new MainGamePanel(this);
		this.add(mainGamePanel);
		
//		worldCreationPanel = new WorldCreationPanel(this);
//		this.add(worldCreationPanel);
		
		mainGamePanel.setVisible(true);
//		worldCreationPanel.setVisible(false);

	}

	/* ========== Private ========== */
	private static final long serialVersionUID = 1092317308071541762L;

}
