package com.laboon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class MainWindow extends JFrame {

    private final int HEIGHT = 600;
    private final int WIDTH = 800;
    
    private JFrame _frame = new JFrame("JBefunge");

    private MainPanel _mainPanel;

    private ButtonPanel _buttonPanel;

    private JMenuBar _menuBar;

    // File menu and its menu items
    private JMenu _fileMenu;

    private JMenuItem _open;
    private JMenuItem _save;
    private JMenuItem _exit;
    
    // Run menu and its menu items
    
    private JMenu _runMenu;

    private JMenuItem _run;
    private JMenuItem _step;

    JTextArea output;
    JScrollPane scrollPane;
 
    public JMenuBar createMenuBar() {

	// // // Add menu options
	// // _menuBar = new JMenuBar();
	// // _fileMenu = new JMenu("File");
	// // _runMenu = new JMenu("Run");

	// // _open = new JMenuItem("Open");
	// // _save = new JMenuItem("Save");
	// // _exit = new JMenuItem("Exit");
    
	// // _run = new JMenuItem("Run");
	// // _step = new JMenuItem("Step");

	// // _fileMenu.add(_open);
	// // _fileMenu.add(_save);
	// // _fileMenu.add(_exit);
	
	// // _runMenu.add(_run);
	// // _runMenu.add(_step);

	// // _menuBar.add(_fileMenu);
	// // _menuBar.add(_runMenu);

	
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription(
                "File options");
        menuBar.add(menu);
 
        //a group of JMenuItems
        menuItem = new JMenuItem("Open file");
        menuItem.setMnemonic(KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Open Befunge file");
        menu.add(menuItem);

        menuItem = new JMenuItem("Save file");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Save Befunge file");
        menu.add(menuItem);

	menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Quit IDE");
	menuItem.addActionListener(new QuitListener());
        menu.add(menuItem);

        //Build second menu in the menu bar.
        menu = new JMenu("Run");
        menu.setMnemonic(KeyEvent.VK_R);
        menu.getAccessibleContext().setAccessibleDescription(
                "Run options");
        menuBar.add(menu);

	menuItem = new JMenuItem("Run program");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_4, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Run Program");
        menu.add(menuItem);

	menuItem = new JMenuItem("Step program");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_5, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Step Program");
        menu.add(menuItem);

	// Separator
        menu.addSeparator();
	
        //a group of check box menu items
        cbMenuItem = new JCheckBoxMenuItem("Time program");
        cbMenuItem.setMnemonic(KeyEvent.VK_T);
        menu.add(cbMenuItem);
 
        cbMenuItem = new JCheckBoxMenuItem("Check for end opcode");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Check syntax");
        cbMenuItem.setMnemonic(KeyEvent.VK_Y);
        menu.add(cbMenuItem);
 
        return menuBar;
    }
 
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
 
        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
 
        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }
    
    
    public MainWindow() {

	//Create and set up the window.
        JFrame frame = new JFrame("MenuLookDemo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        this.setJMenuBar(createMenuBar());
	this.setContentPane(createContentPane());
 
        //Display the window.
	
	this.setSize(WIDTH, HEIGHT);
	// Close program when window is closed
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// Add Main Panel and Button Panel
	
	_mainPanel = new MainPanel();

	_buttonPanel = new ButtonPanel(_mainPanel);
	
	this.add(_mainPanel, BorderLayout.NORTH);
	this.add(_buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
	
		
    }
    
    
}
