import java.awt.Checkbox;
import java.util.Observable;

import javax.swing.JLabel;

public class Model extends Observable{
	private float humidity;
	private float tempPeltier;
	private float tempInt;
	private float tempExt;
	private float setPoint = 15;
	private int tempMaxValue = 25;
	private int tempMinValue = 10;
	private boolean doorOpen;
	private boolean condensation;
	private boolean riskCondensation;
	private DB dataBase = new DB();
	private GraphicCurve graphicCurve = new GraphicCurve(new Coordonate(30, 30), new Size(500,350));
	//private boolean needActualize = false;
	private boolean needToDrawTempInt = true;
	private boolean needToDrawTempExt = true;
	private boolean needToDrawTempPeltier = true;
	private boolean needToDrawTempSetPoint = true;
	private Coordonate clickCoordonate;
	private boolean drawPointerLine = false;
	
	Checkbox interieurCheckBox = new Checkbox("Température intérieure", true);
	Checkbox exterieurCheckBox = new Checkbox("Température extérieure", true);
	Checkbox peltierCheckBox = new Checkbox("Température du module peltier", true);
	Checkbox setPointCheckBox = new Checkbox("Consigne", true);
	JLabel tempLabel = new JLabel();
	JLabel setPointLabel = new JLabel();
	JLabel condensationLabel = new JLabel();
	JLabel doorOpenLabel = new JLabel();
	
	public Model() {
		
	}
	
	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getTempPeltier() {
		return tempPeltier;
	}

	public void setTempPeltier(float tempPeltier) {
		this.tempPeltier = tempPeltier;
		getDataBase().addTempPeltier(new Value(tempPeltier));
	}

	public float getTempInt() {
		return tempInt;
	}

	public void setTempInt(float f) {
		this.tempInt = f;
		getDataBase().addTempInt(new Value(f));
	}

	public float getTempExt() {
		return tempExt;
	}

	public void setTempExt(float tempExt) {
		this.tempExt = tempExt;
		getDataBase().addTempExt(new Value(tempExt));
	}

	public float getSetPoint() {
		return setPoint;
	}

	public void setSetPoint(float setPoint) {
		this.setPoint = setPoint;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public boolean isCondensation() {
		return condensation;
	}

	public void setCondensation(boolean condensation) {
		this.condensation = condensation;
	}

	public boolean isRiskCondensation() {
		return riskCondensation;
	}

	public void setRiskCondensation(boolean riskCondensation) {
		this.riskCondensation = riskCondensation;
	}

    public int getTempMaxValue() {
        return tempMaxValue;
    }

    public int getTempMinValue() {
        return tempMinValue;
    }

    public DB getDataBase() {
		return dataBase;
	}

	public GraphicCurve getGraphicCurve() {
		return graphicCurve;
	}

//	public boolean isNeedActualize() {
//		return needActualize;
//	}
//
//	public void setNeedActualize(boolean needActualize) {
//		this.needActualize = needActualize;
//	}

	public boolean isNeedToDrawTempInt() {
		return needToDrawTempInt;
	}

	public void setNeedToDrawTempInt(boolean needToDrawTempInt) {
		this.needToDrawTempInt = needToDrawTempInt;
	}

	public boolean isNeedToDrawTempExt() {
		return needToDrawTempExt;
	}

	public void setNeedToDrawTempExt(boolean needToDrawTempExt) {
		this.needToDrawTempExt = needToDrawTempExt;
	}

	public boolean isNeedToDrawTempPeltier() {
		return needToDrawTempPeltier;
	}

	public void setNeedToDrawTempPeltier(boolean needToDrawTempPeltier) {
		this.needToDrawTempPeltier = needToDrawTempPeltier;
	}

	public boolean isNeedToDrawTempSetPoint() {
		return needToDrawTempSetPoint;
	}

	public void setNeedToDrawTempSetPoint(boolean needToDrawTempSetPoint) {
		this.needToDrawTempSetPoint = needToDrawTempSetPoint;
	}

	public Checkbox getInterieurCheckBox() {
		return interieurCheckBox;
	}

	public Checkbox getExterieurCheckBox() {
		return exterieurCheckBox;
	}

	public Checkbox getPeltierCheckBox() {
		return peltierCheckBox;
	}

	public Checkbox getSetPointCheckBox() {
		return setPointCheckBox;
	}

	public JLabel getTempLabel() {
		return tempLabel;
	}

	public void setTempLabel(JLabel tempLabel) {
		this.tempLabel = tempLabel;
	}

	public JLabel getSetPointLabel() {
		return setPointLabel;
	}

	public void setSetPointLabel(JLabel setPointLabel) {
		this.setPointLabel = setPointLabel;
	}

	public JLabel getCondensationLabel() {
		return condensationLabel;
	}

	public void setCondensationLabel(JLabel condensationLabel) {
		this.condensationLabel = condensationLabel;
	}

	public JLabel getDoorOpenLabel() {
		return doorOpenLabel;
	}

	public void setDoorOpenLabel(JLabel doorOpenLabel) {
		this.doorOpenLabel = doorOpenLabel;
	}

	public Coordonate getClickCoordonate() {
		return clickCoordonate;
	}

	public void setClickCoordonate(Coordonate clickCoordonate) {
		this.clickCoordonate = clickCoordonate;
	}

	public boolean isDrawPointerLine() {
		return drawPointerLine;
	}

	public void setDrawPointerLine(boolean drawPointerLine) {
		this.drawPointerLine = drawPointerLine;
	}

	
	
	
	
}
