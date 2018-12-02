
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class JPanelObserverDraw extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;
	private final CurveBuilder graphicsBuilder;
	
	public JPanelObserverDraw(CurveBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}
	

	@Override
	public void update(Observable observable, Object arg) {
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(0, 0, 50, 50);
		super.paintComponent(g);
		this.graphicsBuilder.applyModelToGraphic(g);
	}


	
}
