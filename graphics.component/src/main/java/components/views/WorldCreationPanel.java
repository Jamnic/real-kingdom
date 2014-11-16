package components.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import model.enums.BoardSize;
import model.enums.WorldSize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.services.WorldService;

@Component
public class WorldCreationPanel extends AbstractPanel {

	@Autowired
	private MainGamePanel mainGamePanel;

	@Autowired
	private WorldService worldService;

	/* ========== Public ========== */
	@Override
	public void initialize(Dimension dimension) {

		super.initialize(dimension);

		setBackground(new Color(255, 0, 0));
		createComponents();
	}

	@Override
	public void showPanel() {
		super.showPanel();
		clear();
	}

	/* ========== Private ========== */
	private static final long serialVersionUID = 1096318507719422427L;
	private JTextField nameField;
	private JList<WorldSize> worldSizesList;
	private JList<BoardSize> boardSizesList;
	private JButton createButton;
	private JButton returnButton;

	private void createComponents() {

		nameField();
		worldSizesList();
		boardSizesList();
		createButton();
		returnButton();
	}

	private void clear() {
		nameField.setText("");
		worldSizesList.setSelectedIndex(0);
		boardSizesList.setSelectedIndex(0);
	}

	private void nameField() {
		add(nameField = new JTextField(10));
	}

	private void boardSizesList() {
		add(boardSizesList = new JList<BoardSize>(BoardSize.values()));
	}

	private void worldSizesList() {
		add(worldSizesList = new JList<WorldSize>(WorldSize.values()));
	}

	private void createButton() {

		createButton = new JButton("Create world");

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = nameField.getText();
				int worldIndex = worldSizesList.getSelectedIndex();
				int boardIndex = boardSizesList.getSelectedIndex();

				if (text != null && !text.isEmpty() && worldIndex != -1 && boardIndex != -1)
					worldService.createNewWorld(text, WorldSize.values()[worldIndex], BoardSize.values()[boardIndex]);
			}
		});

		add(createButton);
	}

	private void returnButton() {

		returnButton = new JButton("Return");

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hidePanel();
				mainGamePanel.showPanel();
			}
		});

		add(returnButton);
	}

}
