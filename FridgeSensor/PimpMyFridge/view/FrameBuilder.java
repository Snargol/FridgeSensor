import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.*;

public class FrameBuilder {
	static Model model;
	static CurveBuilder graphicsBuilder;
	static Observable observable;
	
	public static void loadFrameBuilder(Model model, CurveBuilder graphicsBuilder) {
		setModel(model);
		setGraphicsBuilder(graphicsBuilder);
		
	}


	public static void loadObservable(Observable observable) {
		setObservable(observable);
	}
	
	public static JPanel createPanels() {
		JPanel p = new JPanel();
		p.setBackground(Color.cyan);
		p.setLayout(new BorderLayout(5,5));
		
		p.add(createTitlePanel(), BorderLayout.NORTH);
		p.add(createDatasPanel(), BorderLayout.WEST);
		p.add(createCurvesPanel(), BorderLayout.EAST);
		return p;
		
	}
	//-------------------------------UP----------------------------------
	/*------------------------------------------------------------------*/
	private static JPanel createTitlePanel() {
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		//p.setLayout(new (5,5));
		p.setPreferredSize(new Dimension(600,100));
		
		JLabel label = new JLabel("Fridge Sensor");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		p.add(label);
		return p;
	}
	//------------------------------LEFT---------------------------------
	/*------------------------------------------------------------------*/
	
	private static JPanel createDatasPanel() {
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(400,600));
		p.setBackground(Color.BLUE);
		
		p.add(createDisplayTemp(),BorderLayout.NORTH);
		p.add(createSetPointManagementDisplay(),BorderLayout.NORTH);
		p.add(createHygrometryDisplay(),BorderLayout.NORTH);
		p.add(createDoorOpenDisplay(),BorderLayout.NORTH);
		
		return p;
	}
	
	private static JPanel createDisplayTemp() {
		JPanel p = new JPanel();
		p.setBackground(Color.YELLOW);
		p.setPreferredSize(new Dimension(300,125));
		return p;
	}
	
	private static JPanel createSetPointManagementDisplay() {
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(300,125));
        //JSlider slider = new JSlider(JSlider.HORIZONTAL,);

		return p;
	}
	
	private static JPanel createHygrometryDisplay() {
		JPanel p = new JPanel();
		p.setBackground(Color.YELLOW);
		p.setPreferredSize(new Dimension(300,125));
		return p;
	}
	
	private static JPanel createDoorOpenDisplay() {
		JPanel p = new JPanel();
		p.setBackground(Color.YELLOW);
		p.setPreferredSize(new Dimension(300,125));
		return p;
	}
	//------------------------------RIGHT---------------------------------
	/*------------------------------------------------------------------*/
	private static JPanel createCurvesPanel() {
		JPanel p = new JPanel();
		//p.setLayout(new BorderLayout(5,5));
		p.setBackground(Color.WHITE);
		p.setPreferredSize(new Dimension(600,600));
		
		
		p.add(createCurvesDisplay());
		p.add(createCheckBoxPanel());
		p.add(createLegendDisplay());
		
		return p;
	}
	
	private static JPanel createCurvesDisplay() {
		MyPanel p = new MyPanel(getGraphicsBuilder());
		getObservable().addObserver(p);
		p.setPreferredSize(new Dimension(550,350));
		p.setCursor(new Cursor(1));
		return p;
	}
	
	private static JPanel createCheckBoxPanel() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.setBackground(Color.WHITE);
		p.setPreferredSize(new Dimension(350,60));

		p.add(getModel().exterieurCheckBox);
		p.add(getModel().interieurCheckBox);
		p.add(getModel().peltierCheckBox);
		p.add(getModel().setPointCheckBox);

		
		return p;
	}
	
	
	private static JPanel createLegendDisplay() {
		JPanel p = new JPanel();
		Icon icon = new ImageIcon("Ressources\\Legend.png");
		JLabel labelLegend = new JLabel();
		labelLegend.setIcon(icon);
		
		p.setBackground(Color.WHITE);
		p.setPreferredSize(new Dimension(350,150));
		p.add(labelLegend);
		
		return p;
	}
	
	/*------------------------------------------------------------------*/
	public static Model getModel() {
		return model;
	}

	public static void setModel(Model newModel) {
		model = newModel;
	}

	public static CurveBuilder getGraphicsBuilder() {
		return graphicsBuilder;
	}

	public static void setGraphicsBuilder(CurveBuilder graphicsBuilder) {
		FrameBuilder.graphicsBuilder = graphicsBuilder;
	}

	public static Observable getObservable() {
		return observable;
	}

	public static void setObservable(Observable observable) {
		FrameBuilder.observable = observable;
	}
	
	
	
}
