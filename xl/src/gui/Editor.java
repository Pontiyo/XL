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
	StatusLabel stl;
	
    public Editor(CurrentSlot cs, Sheet sheet,StatusLabel stl) {
        setBackground(Color.WHITE);
        this.sheet = sheet;
        this.cs = cs;
        this.stl = stl;
        cs.addObserver(this);
        addActionListener(this);
    }

	@Override
	public void update(Observable arg0, Object arg) {
		String str = sheet.getInput(cs.getAddress());
		setText(str);
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		String address = cs.getAddress();
		if(!this.getText().isEmpty()){
			try{
				sheet.setSlot(address, this.getText());
				cs.notifyObservers();
			} catch (XLException e){
				stl.setText(e.getMessage());
			}
		} else {
			try{
				sheet.setSlot(address, "");
				cs.notifyObservers();
			} catch (XLException e){
				stl.setText(e.getMessage());
			}
		}
	}
}