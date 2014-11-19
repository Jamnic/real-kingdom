package components.views;

import java.awt.Dimension;

import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel {

	/* ========== Public ========== */
	public void initialize(Dimension dimension) {
		initialized = true;

		setSize(dimension);
		setPreferredSize(dimension);

		setVisible(false);
		setOpaque(true);
	}

	public void showPanel() throws IllegalStateException {
		checkState();

		this.setVisible(true);
	}

	public void hidePanel() throws IllegalStateException {
		checkState();

		this.setVisible(false);
	}

	private void checkState() {
		if (!initialized)
			throw new IllegalStateException("You must invoke 'initialize' method before using any other method!");
	}

	/* ========== Private ========== */
	private static final long serialVersionUID = 5101442850204958269L;

	private boolean initialized;

}
