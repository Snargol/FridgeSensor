
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class JPanelObserver extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;

	
	public JPanelObserver() {

	}
	

	@Override
	public void update(Observable observable, Object arg) {
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}
