
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
		getView().setModelHasLoad();
		rxtx.setModel(getModel());
		rxtx.initialize();

		loop();



	}

	private void loop() {
		while(true) {
			try {
				if (getModel().isNeedActualize()) {
					getModel().setNeedActualize(false);
					getModel().setMobilesHavesMoved();
				}
				Thread.sleep(3000);


			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
