package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;
import util.XLException;

public class Editor extends JTextField implements ActionListener, Observer{
	Sheet sheet;
	CurrentSlot cs;
	
	
    public Editor(CurrentSlot cs, Sheet sheet) {
        setBackground(Color.WHITE);
        this.sheet = sheet;
        this.cs = cs;
        cs.addObserver(this);
        addActionListener(this);
    }

	@Override
	public void update(Observable arg0, Object arg) {
		String address = cs.toString();
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		String address = cs.toString();
		try{
			sheet.setSlot(address, this.getText());
		} catch (XLException e){
			
		}
	}
}