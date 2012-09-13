import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

public class screenManager {

	private		GraphicsDevice		vc;
	
	//give vc access to monitor
	public screenManager(){
		
		GraphicsEnvironment e	= GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = e.getDefaultScreenDevice();
	}
	
	//gets compatible dms
	public DisplayMode[] getCompatibleModes(){
		return vc.getDisplayModes();
	}
	
	
}
