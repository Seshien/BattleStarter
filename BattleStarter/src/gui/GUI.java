package gui;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;

//Glowna klasa graficzna, jest to potomek JFrame.
public class GUI extends JFrame
{
	
	
	private PlayerPanel panelSideOne;
	public PlayerPanel GetPanelOne() {return this.panelSideOne;}
	private PlayerPanel panelSideTwo;
	public PlayerPanel GetPanelTwo() {return this.panelSideTwo;}
	private RosterPanel panelRoster;
	private InfoPanel panelInfo;
	public InfoPanel GetInfoPanel() {return this.panelInfo;}
	private EventHandler eventHandler;
	private Game _game;
	public Game GetGame() {return this._game;}
	public GUI(Game game)
	{
		super("Rysowanie");
		_game = game;
		init();
	}
	public void init()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(1050, 768);
		this.setMinimumSize(new Dimension(1050,768));
		initEventHandler();
		initPanels();
	}
	private void initEventHandler() 
	{
		eventHandler = new EventHandler(this);
	}
	public void initPanels()
	{
		panelSideOne = new PlayerPanel(350,350, _game.GetPlayerOne(), eventHandler);
		panelSideTwo = new PlayerPanel(350,350, _game.GetPlayerTwo(), eventHandler);
		panelInfo = new InfoPanel(eventHandler);
		panelRoster = new RosterPanel(_game.GetRooster(), eventHandler);
		add(panelSideOne);
		add(panelInfo);
		add(panelSideTwo);
		add(panelRoster);
		panelInfo.ShowInfo("Gold Gold");
	}
	public void refresh()
	{
		this.removeAll();
		this.initPanels();
	}
}
