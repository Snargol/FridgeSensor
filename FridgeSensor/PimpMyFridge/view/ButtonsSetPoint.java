import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonsSetPoint extends JPanel implements ActionListener {
	   private JButton add = new JButton("Add");
	   private JButton remove = new JButton("Remove");
	   private JPanel ardoise = new JPanel();
	   private JLabel label;
	   private Model model;
	   
	   
	public ButtonsSetPoint(Model model) {
		  setModel(model);
		  setLayout(new BorderLayout(5, 5));
		  JPanel lesBoutons = new JPanel();
		  setLabel(new JLabel(""+getModel().getSetPoint()));
		  lesBoutons.add(add);
		  lesBoutons.add(label);
		  lesBoutons.add(remove);
		  add(lesBoutons, BorderLayout.NORTH);
		  add(ardoise, BorderLayout.CENTER);
		  add.addActionListener(this);
		  remove.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == add) 
	    	 getModel().setSetPoint(getModel().getSetPoint() + 1);
	      else if (e.getSource() == remove) 
	    	  getModel().setSetPoint(getModel().getSetPoint() - 1);
	      actualizeText(getLabel());
	      ardoise.repaint(); 
		
	}

	private void actualizeText(JLabel label) {
		label.setText(""+getModel().getSetPoint());
	}
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	
	
}
