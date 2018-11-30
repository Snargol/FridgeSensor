import java.util.Observable;

public class Model extends Observable{
	private int humidity;
	private int tempPeltier;
	private int tempInt;
	private int tempExt;
	private int setPoint = 15;
	private int tempMaxValue = 25;
	private int tempMinValue = 10;
	private boolean doorOpen;
	private boolean condensation;
	private boolean riskCondensation;
	private DB dataBase = new DB();
	private GraphicCurve graphicCurve = new GraphicCurve(new Coordonate(30, 30), new Size(300,300));
	
	public Model() {
		
	}
	
	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getTempPeltier() {
		return tempPeltier;
	}

	public void setTempPeltier(int tempPeltier) {
		this.tempPeltier = tempPeltier;
	}

	public int getTempInt() {
		return tempInt;
	}

	public void setTempInt(int tempInt) {
		this.tempInt = tempInt;
	}

	public int getTempExt() {
		return tempExt;
	}

	public void setTempExt(int tempExt) {
		this.tempExt = tempExt;
	}

	public int getSetPoint() {
		return setPoint;
	}

	public void setSetPoint(int setPoint) {
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

	
	
	
	
}
