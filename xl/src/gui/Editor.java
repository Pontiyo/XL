package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;

public class Editor extends JTextField implements ActionListener, Observer{
	Sheet sheet;
	CurrentLabel cl;
	
	
    public Editor(CurrentLabel cl, Sheet sheet) {
        setBackground(Color.WHITE);
    }

	@Override
	public void update(Observable arg0, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		
	}
}