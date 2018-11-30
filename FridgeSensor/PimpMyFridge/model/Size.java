
public class Size {
	private int width;
	private int height;
	
	public Size(Size size) {
		setWidth(size.getWidth());
		setHeight(size.getHeight());
	}
	
	public Size(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
