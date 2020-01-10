package gui;
import java.awt.*;

import javax.swing.JPanel;


public abstract class Panel extends JPanel 
{
	private EventHandler eventHandler;
	public EventHandler getEventHandler() {return eventHandler;}
	public Panel(EventHandler ev ) 
	{
		eventHandler = ev;
		setPreferredSize(new Dimension(500, 350));
	}
	
	public Panel(int x, int y, EventHandler ev)
	{
		eventHandler = ev;
		setPreferredSize(new Dimension(x, y));
	}
	public Object getOwner() {return null;};
	@Override
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// prostokat
		g2d.drawRect(5, 5, this.getWidth()-10, this.getHeight()-10);
	}
	public void refresh()
	{
		for (Component comp : this.getComponents())
			comp.setVisible(false);
		this.removeAll();
		this.Init();
	}
	protected abstract void Init();
}
