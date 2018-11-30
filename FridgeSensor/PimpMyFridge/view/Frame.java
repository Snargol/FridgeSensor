
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

	

public class Frame extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	int width;
	int height;

	Observable observable;
	CurveBuilder graphicsBuilder;
	String title;
	JPanel panel;
	Model model;

	public Frame(final String title, final CurveBuilder graphicsBuilder, final Observable observable, int width, int height, Model model){
		this.observable = observable;
		this.graphicsBuilder = graphicsBuilder;
		this.title = title;
		this.width = width;
		this.height = height;
		setModel(model);
		
		SwingUtilities.invokeLater(this);
	}


	
	@Override
	public void run() {
		this.setTitle(title);

		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//this.setUndecorated(true);
		//this.setVisible(true);
		this.setBackground(Color.CYAN);
		
//		createJPanel();
//		createButtons();
		
		

		this.setContentPane(createPanels());
		this.setLocation(250, 150);
//		this.setSize(1400, 800);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		
		this.setVisible(true);
	}
	
	private JPanel createPanels() {
		FrameBuilder.loadObservable(getObservable());
		return FrameBuilder.createPanels();
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public Model getModel() {
		return model;
	}


	public void setModel(Model model) {
		this.model = model;
	}



	public Observable getObservable() {
		return observable;
	}



	public void setObservable(Observable observable) {
		this.observable = observable;
	}
	
	
	
	
//	public void setPanel(Panel panel) {
//		this.setContentPane(panel);
//	}
	
//	public void createJPanel() {
//	final Panel panel = new Panel(graphicsBuilder);
//	//JPanel panel = new JPanel();
//	panel.setBackground(Color.RED);
//	panel.setPreferredSize(new Dimension(1400, 800));
//	setPanel(panel);
//	observable.addObserver(panel);
//}



//public void createButtons() {
//	panel.add(new ButtonsSetPoint(getModel()));
//}
	
	
	
}