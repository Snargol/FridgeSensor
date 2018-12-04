
public class GraphicCurve {
	private Coordonate coordonate;
	private Size size;
	
	private float tempIntThickness = 3.0f; 
	private float tempExtThickness = 3.0f;
	private float tempPeltierThickness = 3.0f;
	private float setPointThickness = 4.0f;
	
	
	public GraphicCurve(Coordonate coordonate, Size size) {
		setCoordonate(coordonate);
		setSize(size);
	}

	public Coordonate getCoordonate() {
		return coordonate;
	}

	public void setCoordonate(Coordonate coordonate) {
		this.coordonate = coordonate;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public float getTempIntThickness() {
		return tempIntThickness;
	}

	public void setTempIntThickness(float tempIntThickness) {
		this.tempIntThickness = tempIntThickness;
	}

	public float getTempExtThickness() {
		return tempExtThickness;
	}

	public void setTempExtThickness(float tempExtThickness) {
		this.tempExtThickness = tempExtThickness;
	}

	public float getTempPeltierThickness() {
		return tempPeltierThickness;
	}

	public void setTempPeltierThickness(float tempPeltierThickness) {
		this.tempPeltierThickness = tempPeltierThickness;
	}

	public float getSetPointThickness() {
		return setPointThickness;
	}

	public void setSetPointThickness(float setPointThickness) {
		this.setPointThickness = setPointThickness;
	}
	
	
}
