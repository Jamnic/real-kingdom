package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import model.World;

import components.game.GameWindowImpl;

public class MainGamePanel extends JPanel {

	/* ========== Public ========== */
	public MainGamePanel(final GameWindowImpl gameWindow) {

		this.gameWindow = gameWindow;

		this.setBackground(new Color(0, 255, 0));

		final JButton playButton = playSelectedWorldButton();
		final JButton deleteButton = deleteSelectedWorldButton();
		JButton createButton = createNewWorldButton();
		JList<World> worldsList = createWorldsList(playButton, deleteButton);

		this.add(createButton);
		this.add(playButton);
		this.add(deleteButton);
		this.add(worldsList);
	}

	/* ========== Private ========== */
	private static final long serialVersionUID = -4843376019555924311L;

	private GameWindowImpl gameWindow;
	private World selectedWorld;
	private JList<World> worldsList;

	private JList<World> createWorldsList(final JButton playSelectedWorldButton, final JButton deleteSelectedWorldButton) {

		worldsList = new JList<World>();
		worldsList.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				selectedWorld = worldsList.getSelectedValue();
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});

		return worldsList;
	}

	private JButton deleteSelectedWorldButton() {
		final JButton removeSelectedWorldButton = new JButton("Remove selected world");
		removeSelectedWorldButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println(selectedWorld);
				gameWindow.worldService.deleteWorld(selectedWorld.getId());
				worldsList.setListData(gameWindow.worldService.getAvailableWorlds());
				worldsList.repaint();
			}
		});
		return removeSelectedWorldButton;
	}

	private JButton playSelectedWorldButton() {
		final JButton playSelectedWorldButton = new JButton("Play selected world");
		playSelectedWorldButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println(selectedWorld);
			}
		});
		return playSelectedWorldButton;
	}

	private JButton createNewWorldButton() {

		JButton createNewWorldButton = new JButton("Create new world");
		createNewWorldButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gameWindow.mainGamePanel.setVisible(false);
				gameWindow.worldCreationPanel.setVisible(true);
			}
		});
		return createNewWorldButton;
	}
}
