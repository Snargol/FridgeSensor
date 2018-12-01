

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.annotation.Generated;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;




public class CurveBuilder implements Runnable  {
	private final Model model;

	public CurveBuilder(Model model) {
		this.model = model;
	}

	public void applyModelToGraphic(Graphics graphics) {
		clearScreen(graphics);
		drawMarker(graphics);
		drawMarkerTexts(graphics);
		//drawTempIntCurve(graphics);
		drawCurves(graphics);
	}

	private void clearScreen(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 2000, 2000);
	}

	private void drawMarker(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BasicStroke line = new BasicStroke(3.0f);
		g2.setStroke(line);
		g2.setColor(Color.BLACK);

		//draw ordinate
		g2.drawLine(
				getModel().getGraphicCurve().getCoordonate().getX(), 
				getModel().getGraphicCurve().getCoordonate().getY(),
				getModel().getGraphicCurve().getCoordonate().getX(), 
				getModel().getGraphicCurve().getCoordonate().getY()+getModel().getGraphicCurve().getSize().getHeight()+15);

		//draw abscice
		g2.drawLine(
				getModel().getGraphicCurve().getCoordonate().getX()-15, 
				getModel().getGraphicCurve().getCoordonate().getY() + getModel().getGraphicCurve().getSize().getHeight(),
				getModel().getGraphicCurve().getCoordonate().getX() + getModel().getGraphicCurve().getSize().getWidth(),
				getModel().getGraphicCurve().getCoordonate().getY() + getModel().getGraphicCurve().getSize().getHeight());

	}

	private void drawMarkerTexts(Graphics g) {
		g.setFont(new Font("calibri",1, 18));
		g.setColor(Color.black);
		//max temperature
		g.drawString(""+getModel().getGraphicCurve().getTempMaxValue(), getModel().getGraphicCurve().getCoordonate().getX() - 25, getModel().getGraphicCurve().getCoordonate().getY()+10);
		//medium temperature
		g.drawString(""+(getModel().getGraphicCurve().getTempMinValue() + (getModel().getGraphicCurve().getTempMaxValue() - getModel().getGraphicCurve().getTempMinValue()) / 2), getModel().getGraphicCurve().getCoordonate().getX() - 25, getModel().getGraphicCurve().getCoordonate().getY() + getModel().getGraphicCurve().getSize().getHeight()/2);
		//min temperature
		g.drawString(""+getModel().getGraphicCurve().getTempMinValue(), getModel().getGraphicCurve().getCoordonate().getX() - 25, getModel().getGraphicCurve().getCoordonate().getY() + getModel().getGraphicCurve().getSize().getHeight()-5);

	}

	private void drawCurve(Graphics2D g2, int coordonateXGraph, int coordonateYGraph, int width, int height, int maxTempValue, int minTempValue, ArrayList<Value> datas ) {
		for(int i = 0; i < datas.size()-1; i++) {
			g2.drawLine(
					//x of the 1st point
					(int) (coordonateXGraph + ((float) width / (datas.size()-1)) * i),
					//y of the 1st point
					(int) (coordonateYGraph + height - (datas.get(i).getNumber() - minTempValue) * (height / (maxTempValue - minTempValue))),
					//x of the 2nd point
					(int) (coordonateXGraph + ((float) width / (datas.size()-1)) * (i+1)),
					//y of the 2nd point
					(int) (coordonateYGraph + height - (datas.get(i+1).getNumber() - minTempValue) * (height / (maxTempValue - minTempValue))));
		}
	}

	private void drawSetPoint(Graphics2D g2, int coordonateXGraph, int coordonateYGraph, int width, int height, int maxTempValue, int minTempValue) {
		g2.drawLine(
				//x of the 1st point
				(int) (coordonateXGraph),
				//y of the 1st point
				(int) (coordonateYGraph + height - (getModel().getSetPoint() - minTempValue) * (height / (maxTempValue - minTempValue))),
				//x of the 2nd point
				(int) (coordonateXGraph + width),
				//y of the 2nd point
				(int) (coordonateYGraph + height - (getModel().getSetPoint() - minTempValue) * (height / (maxTempValue - minTempValue))));

	}


	private void drawCurves(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		int width = getModel().getGraphicCurve().getSize().getWidth();
		int height = getModel().getGraphicCurve().getSize().getHeight();
		int maxTempValue = getModel().getGraphicCurve().getTempMaxValue();
		int minTempValue = getModel().getGraphicCurve().getTempMinValue();
		int coordonateXGraph = getModel().getGraphicCurve().getCoordonate().getX();
		int coordonateYGraph = getModel().getGraphicCurve().getCoordonate().getY();
		int sizeDatas = getModel().getDataBase().getTempInt().size();
		ArrayList<Value> datasTempInt = getModel().getDataBase().getTempInt();
		ArrayList<Value> datasTempExt = getModel().getDataBase().getTempExt();
		ArrayList<Value> datasTempPeltier = getModel().getDataBase().getTempPeltier();

		BasicStroke line;

		//draw setPoint
		if (getModel().isNeedToDrawTempSetPoint()) {
			g2.setColor(Color.GREEN);
			line = new BasicStroke(getModel().getGraphicCurve().getSetPointThickness());
			g2.setStroke(line);
			drawSetPoint(g2, coordonateXGraph, coordonateYGraph, width, height, maxTempValue, minTempValue);
		}

		//draw TempExt
		if (getModel().isNeedToDrawTempExt()) {
			g2.setColor(Color.RED);
			line = new BasicStroke(getModel().getGraphicCurve().getTempExtThickness());
			g2.setStroke(line);
			drawCurve(g2, coordonateXGraph, coordonateYGraph, width, height, maxTempValue, minTempValue, datasTempExt);
		}

		//draw TempPeltier 
		if (getModel().isNeedToDrawTempPeltier())
		{
			g2.setColor(Color.BLUE);
			line = new BasicStroke(getModel().getGraphicCurve().getTempExtThickness());
			g2.setStroke(line);
			drawCurve(g2, coordonateXGraph, coordonateYGraph, width, height, maxTempValue, minTempValue, datasTempPeltier);
		}

		//draw TempInt
		if (getModel().isNeedToDrawTempInt()) {
			g2.setColor(Color.DARK_GRAY);
			line = new BasicStroke(getModel().getGraphicCurve().getTempIntThickness());
			g2.setStroke(line);
			drawCurve(g2, coordonateXGraph, coordonateYGraph, width, height, maxTempValue, minTempValue, datasTempInt);
		}


	}

	public Model getModel() {
		return model;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}