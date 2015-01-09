package de.htwg.minesweeper.aview.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import de.htwg.minesweeper.controller.IController;
import de.htwg.util.observer.IObserver;

public class BaseFrame extends JFrame implements IObserver{
	private IController contr;

	public BaseFrame(IController c) {
		this.contr = c;
		contr.addObserver(this);

		JMenuBar menuBar;
		
		JMenu fileMenu;
		JMenuItem fileNew, fileGiveup, fileQuit;

		setTitle("HTWG SE Mine Sweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		fileNew = new JMenuItem("New");
		fileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new Setup();
			}
		});
		fileNew.setMnemonic(KeyEvent.VK_N);
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_DOWN_MASK));

		fileGiveup = new JMenuItem("Give Up");
		fileGiveup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new Setup();
			}
		});
		fileGiveup.setMnemonic(KeyEvent.VK_G);
		fileGiveup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				InputEvent.CTRL_DOWN_MASK));

		fileQuit = new JMenuItem("Quit");
		fileQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new Setup();
			}
		});
		fileQuit.setMnemonic(KeyEvent.VK_Q);
		fileQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_DOWN_MASK));

		menuBar = new JMenuBar();

		fileMenu.add(fileNew);
		fileMenu.add(fileGiveup);
		fileMenu.add(fileQuit);
		menuBar.add(fileMenu);
		
		setJMenuBar(menuBar);
		setVisible(true);
	}

	@Override
	public void update() {
		repaint();
	}

}
