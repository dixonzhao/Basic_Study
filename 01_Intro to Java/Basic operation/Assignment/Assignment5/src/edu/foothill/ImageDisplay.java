package edu.foothill;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageDisplay extends JPanel {

	public String imagePath = "loading.gif";

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		this.repaint();
	}

	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage(imagePath);
		g.drawImage(i, 0, 0, this);
	}

	public static void main(String[] args) {
		ImageDisplay imageDisplay = new ImageDisplay();
		JFrame jFrame = new JFrame();
		jFrame.add(imageDisplay);
		jFrame.setSize(600, 900);
//		jFrame.setLayout(null);
		jFrame.setVisible(true);
		// Change from the default loading.gif to display a movie poster
		imageDisplay.setImagePath("4859886671_cef0598bf3_b.jpg");
	}

}
