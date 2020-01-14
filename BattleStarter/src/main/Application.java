package main;

import gui.GUI;
import loader.PrototypeManager;
import java.awt.EventQueue;

import game.Game;
//Klasa Main projektu, inicjalizuje glowne czesci projektu
public class Application {

	public static void main(String[] args) throws Exception 
	{
		PrototypeManager prototypeManager = new PrototypeManager();
		prototypeManager.loadAssets();
		Game game = new Game(prototypeManager);
		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				new GUI(game);
			}
		});
	}

}
