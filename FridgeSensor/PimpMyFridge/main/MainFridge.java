

public class MainFridge {
	public static void main(String[] args) {
		Model model = new Model();
		View view = new View(model, model);
		Controller controller = new Controller(view, model);

		controller.load();
	}
}
