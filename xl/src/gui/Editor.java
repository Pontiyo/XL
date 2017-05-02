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
	StatusLabel statL;
	
    public Editor(CurrentSlot cs, Sheet sheet,StatusLabel statL) {
        setBackground(Color.WHITE);
        this.sheet = sheet;
        this.cs = cs;
        this.statL = statL;
        cs.addObserver(this);
        addActionListener(this);
    }

	@Override
	public void update(Observable arg0, Object arg) {
		String str = sheet.getString(cs.getAddress());
		setText(str);
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		String address = cs.getAddress();
		if(!this.getText().isEmpty()){
			try{
				sheet.setSlot(address, this.getText());
			} catch (XLException e){
				statL.setText(e.getMessage());
			}
		}
	}
}