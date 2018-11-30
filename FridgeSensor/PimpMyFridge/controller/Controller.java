
public class Controller {
	private View view;
	private Model model;
	
	
	public Controller(View view, Model model) {
		setView(view);
		setModel(model);
		
	}
	
	public void load() {
		FrameBuilder.loadFrameBuilder(getModel(), new CurveBuilder(getModel()));
		getView().setModelHasLoad();
		loop();
	}
	
	private void loop() {
		while(true) {
			try {
				getModel().setMobilesHavesMoved();
				Thread.sleep(1000);
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
