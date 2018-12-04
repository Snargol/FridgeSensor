import java.awt.Color;

public class Controller {
	private View view;
	private Model model;
	Rxtx rxtx = new Rxtx();


	public Controller(View view, Model model) {
		setView(view);
		setModel(model);

	}

	public void load() {
		FrameBuilder.loadFrameBuilder(getModel(), new CurveBuilder(getModel()));
		rxtx.setModel(getModel());
		rxtx.initialize();
		CurvesManagement.setModel(getModel());
		getView().setModelHasLoad();


		loop();
	}

	private void loop() {
		while(true) {
			try {
				getModel().setMobilesHavesMoved();
				CurvesManagement.checkCurvesToDraw();
				actualizeJPanelObserver();
				getModel().getDewPoint();
				if (getModel().isNeedToSendSetPoint()) {
					getModel().setNeedToSendSetPoint(false);
					rxtx.writeData((int) getModel().getSetPoint());
				}
				checkValuesSize();
				Thread.sleep(100);


			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void actualizeJPanelObserver() {
		actualizeTempPanel();
		actualizeHygrometryPanel();
		actualizeAlertPanel();
	}

	private void actualizeTempPanel() {
		getModel().getTempLabel().setText(""+getModel().getTempInt());
		
	}

	private void actualizeHygrometryPanel() {

		getModel().getCondensationLabel().setText(""+getModel().getHumidity());
		if (getModel().getDewPoint() > getModel().getTempPeltier()) {
			getModel().getCondensationLabelAlert().setText("Alerte : Risque de condensation");
			getModel().getCondensationLabelAlert().setForeground(new Color(198, 23, 47));
		}
		else {
			getModel().getCondensationLabelAlert().setForeground(new Color(18, 96, 61));
			getModel().getCondensationLabelAlert().setText("Pas de risque de condensation");
		}
	}

	private void actualizeAlertPanel() {
		if (getModel().getTempInt() >= getModel().getTempExt() * 0.95) {
			getModel().getDoorOpenLabel().setText("Température du frigo anormale");
			getModel().getDoorOpenLabel().setForeground(new Color(198, 23, 47));
		}
		else {
			getModel().getDoorOpenLabel().setText("Aucune Anomalie");
			getModel().getDoorOpenLabel().setForeground(new Color(18, 96, 61));
		}
	}
	
	public void checkValuesSize() {
		if (getModel().getDataBase().getTempInt().size() >= getModel().getMaxValuesOnGraph()) {
			getModel().getDataBase().getTempInt().remove(0);
		}
		if (getModel().getDataBase().getTempExt().size() >= getModel().getMaxValuesOnGraph()) {
			getModel().getDataBase().getTempExt().remove(0);
		}
		if (getModel().getDataBase().getTempPeltier().size() >= getModel().getMaxValuesOnGraph()) {
			getModel().getDataBase().getTempPeltier().remove(0);
		}
		if (getModel().getDataBase().getSetPoint().size() >= getModel().getMaxValuesOnGraph()) {
			getModel().getDataBase().getSetPoint().remove(0);
		}
		if (getModel().getDataBase().getTimes().size() >= getModel().getMaxValuesOnGraph()) {
			getModel().getDataBase().getTimes().remove(0);
		}
	}

	private View getView() {
		return view;
	}

	private Model getModel() {
		return model;
	}

	private void setView(View view) {
		this.view = view;
	}

	private void setModel(Model model) {
		this.model = model;
	}



}
