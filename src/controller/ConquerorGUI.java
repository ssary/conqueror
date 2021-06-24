package controller;

import java.io.IOException;

public class ConquerorGUI {
	Control controller;
	public ConquerorGUI() throws IOException {
		controller = new Control();
		
	}
	public static void main(String []args) throws IOException  {
		new ConquerorGUI();
		
	}
}
