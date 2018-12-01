import java.util.ArrayList;

public class DB {
	private ArrayList<Value> tempInt = new ArrayList<>();
	private ArrayList<Value> tempExt = new ArrayList<>();
	private ArrayList<Value> tempPeltier = new ArrayList<>();
	
	public DB() {
		createDatas();
	}
	
	private void createDatas() {
		createDatasTempInt();
		createDatasTempExt();
		createDatasTempPeltier();
	}
	
	private void createDatasTempInt() {
		tempInt.add(new Value((float)14.15));
		tempInt.add(new Value((float)14.55));
		tempInt.add(new Value((float)14.75));
		tempInt.add(new Value((float)14.95));
		tempInt.add(new Value((float)15.00));
		tempInt.add(new Value((float)15.00));
		tempInt.add(new Value((float)15.05));
		tempInt.add(new Value((float)15.10));
		tempInt.add(new Value((float)15.30));
		tempInt.add(new Value((float)15.45));
		tempInt.add(new Value((float)15.90));
		tempInt.add(new Value((float)16.50));
		tempInt.add(new Value((float)17.50));
		tempInt.add(new Value((float)19.60));
		tempInt.add(new Value((float)21.30));	
		
	}
	
	private void createDatasTempExt() {
		tempExt.add(new Value((float)23.05));
		tempExt.add(new Value((float)22.95));
		tempExt.add(new Value((float)22.85));
		tempExt.add(new Value((float)22.60));
		tempExt.add(new Value((float)22.30));
		tempExt.add(new Value((float)22.30));
		tempExt.add(new Value((float)21.90));
		tempExt.add(new Value((float)21.50));
		tempExt.add(new Value((float)21.41));
		tempExt.add(new Value((float)21.35));
		tempExt.add(new Value((float)21.03));
		tempExt.add(new Value((float)20.70));
		tempExt.add(new Value((float)20.53));
		tempExt.add(new Value((float)20.21));
		tempExt.add(new Value((float)20.05));
		tempExt.add(new Value((float)20.00));
		tempExt.add(new Value((float)19.65));
		tempExt.add(new Value((float)19.53));
		tempExt.add(new Value((float)19.42));
		tempExt.add(new Value((float)19.30));
	}
	
	private void createDatasTempPeltier() {
		tempPeltier.add(new Value((float) 12.05));
		tempPeltier.add(new Value((float) 10.05));
		tempPeltier.add(new Value((float) 8.05));
		tempPeltier.add(new Value((float) 7.05));
		tempPeltier.add(new Value((float) 6.05));
		tempPeltier.add(new Value((float) 3.05));
		tempPeltier.add(new Value((float) 2.05));
		tempPeltier.add(new Value((float) 1.05));
	}

	public ArrayList<Value> getTempInt() {
		return tempInt;
	}

	public void addTempInt(Value tempInt) {
		this.tempInt.add(tempInt);
	}

	public ArrayList<Value> getTempExt() {
		return tempExt;
	}

	public void addTempExt(Value tempExt) {
		this.tempExt.add(tempExt);
	}

	public ArrayList<Value> getTempPeltier() {
		return tempPeltier;
	}

	public void addTempPeltier(Value tempPeltier) {
		this.tempPeltier.add(tempPeltier);
	}
	
	
}
