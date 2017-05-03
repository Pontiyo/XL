package gui.menu;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import gui.CurrentSlot;
import gui.SlotLabels;
import gui.StatusLabel;
import gui.XL;
import model.Sheet;

class LoadMenuItem extends OpenMenuItem {
	private Sheet sheet;
	
    public LoadMenuItem(XL xl, StatusLabel statusLabel,Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        sheet.readFromFile(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}