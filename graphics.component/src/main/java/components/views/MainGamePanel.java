package components.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import model.Board;
import model.World;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.services.WorldService;

@Component
public class MainGamePanel extends AbstractPanel {

	@Autowired
	private WorldCreationPanel worldCreationPanel;

	@Autowired
	private ViewPanel viewPanel;

	@Autowired
	private WorldService worldService;

	/* ========== Public ========== */
	@Override
	public void initialize(Dimension dimension) {

		super.initialize(dimension);

		setBackground(new Color(0, 255, 0));
		createComponents();
	}

	@Override
	public void showPanel() {
		super.showPanel();
		setModel();
	}

	/* ========== Private ========== */
	private static final long serialVersionUID = -4843376019555924311L;
	private JButton playSelectedButton;
	private JButton deleteButton;
	private JButton createButton;
	private JList<String> worldsList;

	private World[] availableWorlds;
	private World selectedWorld;

	private void createComponents() {
		createButton();
		deleteButton();
		worldsList();
		playSelectedButton();
	}

	private void setModel() {

		availableWorlds = worldService.getAvailableWorlds();

		ListModel<String> model = new ListModel<String>() {

			@Override
			public int getSize() {
				return availableWorlds.length;
			}

			@Override
			public String getElementAt(int index) {
				return availableWorlds[index].getName();
			}

			public void addListDataListener(ListDataListener l) {
			}

			public void removeListDataListener(ListDataListener l) {
			}
		};

		worldsList.setModel(model);
	}

	private void worldsList() {

		worldsList = new JList<String>();
		worldsList.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				selectedWorld = availableWorlds[worldsList.getSelectedIndex()];
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

		add(worldsList);
	}

	private void deleteButton() {

		deleteButton = new JButton("Remove selected world");

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedWorld != null) {
					worldService.deleteWorld(selectedWorld.getId());
					setModel();
					worldsList.repaint();
				}
			}
		});

		add(deleteButton);
	}

	private void playSelectedButton() {

		playSelectedButton = new JButton("Play selected world");

		playSelectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedWorld != null) {
					Board mainBoard = selectedWorld.getMainBoard();
					viewPanel.setBoard(mainBoard);
					viewPanel.showPanel();
					hidePanel();
				}
			}
		});

		add(playSelectedButton);
	}

	private void createButton() {

		createButton = new JButton("Create new world");

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worldCreationPanel.showPanel();
				hidePanel();
			}
		});

		add(createButton);
	}

}
