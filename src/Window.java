

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import java.lang.*;

import java.io.*;

import javax.swing.*;

public class Window extends JFrame {
	private JScrollPane filesToStudy;
	
	private void openFileChooser() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(selectedFile));
				
				String line = "";
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
				
				JCheckBox cb = new JCheckBox(selectedFile.getName());
				filesToStudy.add(cb);
			} catch (Exception e) {
				System.err.println("Failed to read file");
			}
		}
	}
	
	public Window() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.err.println("Error setting look and feel");
		}
		
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Mountain Dew");
		this.setLocation(600, 200);
		
		JButton loadFileButton = new JButton();
		loadFileButton.setText("Open new file");
		loadFileButton.setSize(this.getSize().width, 50);
		
		JPanel yeet = new JPanel();
		
		
		yeet.setSize(100, 500);
		yeet.setBackground(new Color(255, 0, 0));
		yeet.setForeground(new Color(0, 250, 0));
		
		filesToStudy = new JScrollPane(yeet);
		
		yeet.add(loadFileButton);
		add(yeet, BorderLayout.CENTER);
		//add(filesToStudy, BorderLayout.WEST);
		add(loadFileButton, BorderLayout.NORTH);
	}
	
	@Override
	public void dispose() {
		System.out.println("disposing");
	}
}
