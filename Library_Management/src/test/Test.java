package test;

import javax.swing.UIManager;

import view.LibraryView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			LibraryView library = new LibraryView();
			library.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}