package components.views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import model.Board;
import model.FieldColumn;
import model.enums.TerrainType;

public class MapPanel extends JPanel {

	public void setBoard(Board board) {
		System.out.println("SET!");
		this.board = board;
	}

	private Board board;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		List<FieldColumn> array = board.getFieldColumns();

		for (int i = 0; i < array.size(); ++i)
			for (int j = 0; j < array.get(i).getFields().size(); ++j)
				drawTerrain(array.get(i).getFields().get(j).getTerrainType(), i, j, g);
	}

	private void drawTerrain(TerrainType type, int i, int j, Graphics g) {

		g.setColor(determineColor(type));
		g.drawRect(i, j, 5, 5);

	}

	private Color determineColor(TerrainType type) {
		switch (type) {
		case HILLS:
			return new Color(200, 0, 100);
		case MOUNTAINS:
			return new Color(200, 100, 100);
		case OCEANS:
			return new Color(150, 150, 255);
		case SAVANNAH:
			return new Color(20, 200, 50);
		case WASTELANDS:
			return new Color(100, 0, 100);
		default:
			return new Color(0);
		}
	}

}
