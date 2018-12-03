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
		p.setBackground(new Color(255, 180, 0));
		p.setPreferredSize(new Dimension(600,100));
		p.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		JLabel label = new JLabel("Fridge Sensor");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label, constraints);
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
		p.setBackground(new Color(255, 211, 96));
		p.setPreferredSize(new Dimension(300,125));
		p.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		JLabel label1 = new JLabel("Température du frigo");
		label1.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel label2 = getModel().getTempLabel();
		label2.setText(""+getModel().getTempInt());
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel label3 = new JLabel ("              °C");
		label3.setFont(new Font("Arial", Font.BOLD, 20));
        
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label1, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label2, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.CENTER;
        p.add(label3, constraints);
        
		return p;
	}
	
	private static JPanel createSetPointManagementDisplay() {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(300,125));
        p.setBackground(new Color(255, 211, 96));
        int defaultValue = 15;
        p.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel label1 = new JLabel("Réglage de la consigne");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel label2 = new JLabel ("              °C");
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        JSlider slider = new JSlider(getModel().getTempMinValue(), getModel().getTempMaxValue(), defaultValue);
        slider.setBackground(new Color(255, 211, 96));
        slider.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel tempLabel = new JLabel(String.valueOf(slider.getValue()));
        tempLabel.setFont(new Font("Arial", Font.BOLD, 20));

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               // System.out.println(slider.getValue());
                tempLabel.setText(String.valueOf(slider.getValue()));
                model.setSetPoint((slider.getValue()));
            }
        });
        
        constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.CENTER;
        p.add(label1, constraints);
        
        constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.CENTER;
        p.add(slider, constraints);
        
        constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.CENTER;
        p.add(tempLabel, constraints);
        
        constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.CENTER;
        p.add(label2, constraints);
        
        return p;
    }
	
	private static JPanelObserver createHygrometryDisplay() {
		JPanelObserver p = new JPanelObserver();
		getObservable().addObserver(p);
		p.setBackground(new Color(255, 211, 96));
		p.setPreferredSize(new Dimension(300,125));
		p.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        JLabel label1 = new JLabel("Hygrométrie actuelle");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel label2 = getModel().getCondensationLabel();
		label2.setText(""+getModel().getHumidity());
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel label3 = new JLabel ("              %");
		label3.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel label4 = model.getCondensationLabelAlert();
		label4.setFont(new Font("Arial", Font.BOLD, 15));
		label4.setForeground(Color.red);

		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label1, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label2, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label3, constraints);

		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label4, constraints);
		
		
		return p;
	}
	
	private static JPanelObserver createDoorOpenDisplay() {
		JPanelObserver p = new JPanelObserver();
		p.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
		p.setBackground(new Color(255, 211, 96));
		p.setPreferredSize(new Dimension(300,125));
		
		JLabel label1 = new JLabel("Dysfonctionnements constatés :");
		label1.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel label2 = getModel().getDoorOpenLabel();
		label2.setFont(new Font("Arial", Font.BOLD, 15));
		label2.setText("Aucune Anomalie");
		label2.setForeground(new Color(18, 96, 61));

		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label1, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.CENTER;
		p.add(label2, constraints);
		
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
