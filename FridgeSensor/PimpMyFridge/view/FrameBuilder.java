import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
		p.setPreferredSize(new Dimension(400,530));
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
		p.setBackground(Color.BLUE);
		p.setPreferredSize(new Dimension(400,500));
		
		
		p.add(createCurvesDisplay());
		p.add(createLegendDisplay());
		return p;
	}
	
	private static JPanel createCurvesDisplay() {
		MyPanel p = new MyPanel(getGraphicsBuilder());
		getObservable().addObserver(p);
		p.setBackground(Color.YELLOW);
		p.setPreferredSize(new Dimension(350,350));
		p.setCursor(new Cursor(1));
		return p;
	}
	
	private static JPanel createLegendDisplay() {
		JPanel p = new JPanel();
		p.setBackground(Color.YELLOW);
		p.setPreferredSize(new Dimension(350,150));
		p.add(createLegend1());
		p.add(createLegend2());
		p.add(createLegend3());
		return p;
	}
	
	private static JPanel createLegend1() {
		JPanel p = new JPanel();
		p.setBackground(Color.GRAY);
		p.setPreferredSize(new Dimension(300,40));
		return p;
	}
	private static JPanel createLegend2() {
		JPanel p = new JPanel();
		p.setBackground(Color.GRAY);
		p.setPreferredSize(new Dimension(300,40));
		return p;
	}
	private static JPanel createLegend3() {
		JPanel p = new JPanel();
		p.setBackground(Color.GRAY);
		p.setPreferredSize(new Dimension(300,40));
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
