package components.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Board;

import org.springframework.stereotype.Component;

@Component
public class ViewPanel extends AbstractPanel {

	/* ========== Public ========== */
	@Override
	public void initialize(Dimension dimension) {

		super.initialize(dimension);

		setLayout(null);
		createComponents();
	}

	public void setBoard(Board board) {
		mainPanel.setBoard(board);
	}

	/* ========== Private ========== */
	private static final long serialVersionUID = 4614838575552614875L;

	private JPanel menuPanel;
	private MapPanel mainPanel;

	private void createComponents() {
		menuPanel();
		mainPanel();
	}

	private void mainPanel() {
		mainPanel = new MapPanel();

		mainPanel.setBackground(new Color(0, 100, 100));
		mainPanel.setBounds(0, 0, 400, 400);

		add(mainPanel);
	}

	private void menuPanel() {
		menuPanel = new JPanel();

		menuPanel.setBackground(new Color(100, 100, 0));
		menuPanel.setBounds(400, 0, 100, 400);

		add(menuPanel);
	}

}
