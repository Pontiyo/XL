package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class StatusPanel extends BorderPanel {
	CurrentSlot cs;
    protected StatusPanel(StatusLabel statusLabel, CurrentSlot cs) {
    	this.cs = cs;
        add(WEST, new CurrentLabel(cs));
        add(CENTER, statusLabel);
    }
}