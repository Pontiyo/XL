package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.CurrentSlot;
import model.Sheet;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	private Sheet sheet;
	private CurrentSlot cs;
	
    public ClearAllMenuItem(Sheet sheet, CurrentSlot cs) {
        super("Clear all");
        addActionListener(this);
        this.sheet = sheet;
        this.cs = cs;
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clearSheet();
        cs.notifyObservers();
    }
}