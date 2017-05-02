package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Sheet;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private Sheet sheet;
	
    public ClearMenuItem(Sheet sheet) {
        super("Clear");
        addActionListener(this);
        this.sheet = sheet;
    }

    public void actionPerformed(ActionEvent e) {
        //String address = 
    }
}