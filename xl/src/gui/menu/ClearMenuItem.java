package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.CurrentSlot;
import model.Sheet;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private Sheet sheet;
	private CurrentSlot cs;
	
    public ClearMenuItem(Sheet sheet,CurrentSlot cs) {
        super("Clear");
        addActionListener(this);
        this.sheet = sheet;
        this.cs = cs;
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clearSlot(cs.getAddress());
        cs.notifyObservers();
    }
}