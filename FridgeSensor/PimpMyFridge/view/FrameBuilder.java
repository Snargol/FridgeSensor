import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.Observable;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		p.setBackground(Color.WHITE);
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
		p.setBackground(Color.WHITE);
		
		p.add(createDisplayTemp(),BorderLayout.NORTH);
		p.add(createSetPointManagementDisplay(),BorderLayout.NORTH);
		p.add(createHygrometryDisplay(),BorderLayout.NORTH);
		p.add(createDoorOpenDisplay(),BorderLayout.NORTH);
		
		return p;
	}
	
	private static JPanelObserver createDisplayTemp() {
		JPanelObserver p = new JPanelObserver();
		getObservable().addObserver(p);
		p.setBackground(Color.LIGHT_GRAY);
		p.setPreferredSize(new Dimension(300,125));
		p.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.CENTER;
		
		JLabel label1 = new JLabel("Température du frigo");
		label1.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel label2 = getModel().getTempLabel();
		label2.setText(""+getModel().getTempInt()+" °C");
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		p.add(label1, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label2, constraints);
		return p;
	}
	
	private static JPanel createSetPointManagementDisplay() {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(300,125));
        p.setBackground(Color.WHITE);
        int defaultValue = 15;

        JLabel label = new JLabel("Réglage de la consigne :");
        JSlider slider = new JSlider(getModel().getTempMinValue(), getModel().getTempMaxValue(), defaultValue);
        slider.setBackground(Color.white);
        JLabel tempLabel = new JLabel(String.valueOf(slider.getValue()));

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               // System.out.println(slider.getValue());
                tempLabel.setText(String.valueOf(slider.getValue()));
                model.setSetPoint((slider.getValue()));
            }
        });
        p.add(label);
        p.add(tempLabel);
        p.add(slider);
        return p;
    }
	
	private static JPanelObserver createHygrometryDisplay() {
		JPanelObserver p = new JPanelObserver();
		getObservable().addObserver(p);
		p.setBackground(Color.WHITE);
		p.setPreferredSize(new Dimension(300,125));
		JLabel label = getModel().getCondensationLabel();
		label.setText("Hygrométrie actuelle: "+getModel().getHumidity());
		label.setFont(new Font("Arial", Font.BOLD, 15));
		p.add(label);
		return p;
	}
	
	private static JPanelObserver createDoorOpenDisplay() {
		JPanelObserver p = new JPanelObserver();
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
		p.add(createCurveToolPanel());
		
		return p;
	}
	
	private static JPanel createCurveToolPanel() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 1));
		p.setPreferredSize(new Dimension(550,225));
		p.setBackground(Color.WHITE);
		p.add(createCheckBoxPanel());
		p.add(createLegendDisplay());
		return p;
	}
	
	private static JPanelObserverDraw createCurvesDisplay() {
		JPanelObserverDraw p = new JPanelObserverDraw(getGraphicsBuilder());
		getObservable().addObserver(p);
		p.setPreferredSize(new Dimension(550,410));
		p.setCursor(new Cursor(1));
		p.addMouseListener(new ClickListener(getModel()));
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
		p.setLayout(new GridLayout(1, 1));
		JLabel labelLegend = new JLabel();
		labelLegend.setIcon(icon);
		
		p.setBackground(Color.WHITE);
		p.setPreferredSize(new Dimension(50,150));
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
