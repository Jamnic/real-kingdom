package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.game.GameWindowImpl;

import model.enums.BoardSize;
import model.enums.WorldSize;

public class WorldCreationPanel extends JPanel {

	/* ========== Public ========== */
	public WorldCreationPanel(final GameWindowImpl gameWindow) {

		this.setBackground(new Color(255, 0, 0));

		final JTextField nameField = nameField();
		final JList<WorldSize> worldSizesList = new JList<WorldSize>(WorldSize.values());
		final JList<BoardSize> boardSizesList = new JList<BoardSize>(BoardSize.values());
		JButton createButton = createButton(gameWindow, nameField, worldSizesList, boardSizesList);
		JButton returnButton = returnButton(gameWindow);

		this.add(nameField);
		this.add(worldSizesList);
		this.add(boardSizesList);
		this.add(createButton);
		this.add(returnButton);

	}

	/* ========== Private ========== */
	private static final long serialVersionUID = 1096318507719422427L;

	private JTextField nameField() {
		final JTextField nameField = new JTextField(10);
		return nameField;
	}

	private JButton createButton(final GameWindowImpl gameWindow, final JTextField nameField,
			final JList<WorldSize> worldSizesList, final JList<BoardSize> boardSizesList) {
		JButton createButton = new JButton("Create world");
		createButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = nameField.getText();
				int worldIndex = worldSizesList.getSelectedIndex();
				int boardIndex = boardSizesList.getSelectedIndex();
				if (text == null || text.isEmpty() || worldIndex == -1 || boardIndex == -1) {

					// Błąd

				} else {

					gameWindow.worldService.createNewWorld(text, WorldSize.values()[worldIndex],
							BoardSize.values()[boardIndex]);

				}
			}
		});
		return createButton;
	}

	private JButton returnButton(final GameWindowImpl gameWindow) {
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				gameWindow.remove(gameWindow.worldCreationPanel);
				gameWindow.add(gameWindow.mainGamePanel);

			}
		});
		return returnButton;
	}

}
