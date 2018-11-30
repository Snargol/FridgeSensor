
public class Controller {
	private View view;
	private Model model;
	Rxtx main = new Rxtx();
	
	
	public Controller(View view, Model model) {
		setView(view);
		setModel(model);
		
	}
	
	public void load() {
		FrameBuilder.loadFrameBuilder(getModel(), new CurveBuilder(getModel()));
		getView().setModelHasLoad();
		
		
		main.initialize();
		Thread t=new Thread() {
			public void run() {
				//the following line will keep this app alive for 1000 seconds,
				//waiting for events to occur and responding to them (printing incoming messages to console).
				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
			}
		};
		t.start();
		System.out.println("Started");
		
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
