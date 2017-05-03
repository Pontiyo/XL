package gui.menu;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import gui.StatusLabel;
import gui.XL;
import model.Sheet;

class SaveMenuItem extends OpenMenuItem {
	Sheet sheet;
    public SaveMenuItem(XL xl, StatusLabel statusLabel,Sheet sheet) {
        super(xl, statusLabel, "Save");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        sheet.saveToFile(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}