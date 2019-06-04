package edu.foothill;
import javax.swing.JFrame;

public class Gallery 
{
   public static void main(String[] args)
   {
	   // TODO: Your group needs to write ControlsFrame together
	   ControlsFrame controls = new ControlsFrame("Gallery");
	   // Make sure the entire application exits when the ControlsFrame is closed.
	   controls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       controls.setSize(500, 250);
       controls.setVisible(true);
   }
}