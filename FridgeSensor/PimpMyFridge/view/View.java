import java.awt.Color;
import java.util.Observable;

public class View {
	private Model model;
	private CurveBuilder graphicsBuilder;
	private Frame frame;
	//private Panel panel;
	private Observable observable;
	
	public View (Model model, Observable observable) {
		setModel(model);
		setObservable(observable);
	}
	
	public void setModelHasLoad() {
		setGraphicsBuilder(new CurveBuilder(getModel()));
		//setPanel(new Panel(graphicsBuilder));
		setFrame(new Frame("FridgeSensor", getGraphicsBuilder(), getObservable(), 1400, 1000, getModel()));
		//getPanel().setBackground(Color.RED);
		//getFrame().setPanel(panel);
	}
	
	
	public Model getModel() {
		return model;
	}

	private void setModel(Model model) {
		this.model = model;
	}

	public CurveBuilder getGraphicsBuilder() {
		return graphicsBuilder;
	}

	public void setGraphicsBuilder(CurveBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public Observable getObservable() {
		return observable;
	}

	public void setObservable(Observable observable) {
		this.observable = observable;
	}

//	public Panel getPanel() {
//		return panel;
//	}
//
//	public void setPanel(Panel panel) {
//		this.panel = panel;
//	}
//	
	
	
	
	
}
