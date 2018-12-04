import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListener extends MouseAdapter {
	Model model;

	public ClickListener(Model model) {
		setModel(model);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		getModel().setDrawPointerLine(true);
		getModel().setClickCoordonate(new Coordonate(e.getX(), e.getY()));
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		getModel().setDrawPointerLine(false);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
}
