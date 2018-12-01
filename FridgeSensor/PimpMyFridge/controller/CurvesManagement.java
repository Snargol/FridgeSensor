
public class CurvesManagement {
	static Model model;
	public static void checkCurvesToDraw() {
		if (getModel().exterieurCheckBox.getState()) {
			getModel().setNeedToDrawTempExt(true);
		}
		else {
			getModel().setNeedToDrawTempExt(false);
		}

		if (getModel().interieurCheckBox.getState()) {
			getModel().setNeedToDrawTempInt(true);
		}
		else {
			getModel().setNeedToDrawTempInt(false);
		}

		if (getModel().peltierCheckBox.getState()) {
			getModel().setNeedToDrawTempPeltier(true);
		}
		else {
			getModel().setNeedToDrawTempPeltier(false);
		}

		if (getModel().setPointCheckBox.getState()) {
			getModel().setNeedToDrawTempSetPoint(true);
		}
		else {
			getModel().setNeedToDrawTempSetPoint(false);
		}
	}


	public static Model getModel() {
		return model;
	}
	public static void setModel(Model model1) {
		model = model1;
	}




}
