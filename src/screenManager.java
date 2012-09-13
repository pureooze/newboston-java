import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

public class screenManager {

	private		GraphicsDevice		vc;
	
	//give vc access to monitor
	public screenManager(){
		
		GraphicsEnvironment e     = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc                        = e.getDefaultScreenDevice();
	}
	
	//gets compatible dms
	public DisplayMode[] getCompatibleModes(){
		return vc.getDisplayModes();
	}
	
	//compares DM passed into vc DM and sees if they match
	public DisplayMode finfFirstCompatibleMode(DisplayMode modes[]){
		
		DisplayMode goodModes[] = vc.getDisplayModes();
		for(int x = 0; x < modes.length; x++){
			for(int y = 0; y < goodModes.length; y++){
				if(displayModesMatch(modes[x], goodModes[y])){
					return modes[x];
				}
			}
		}
	}
	
	//get current DM
	public DisplayMode getCurrentDM(){
		
		return vc.getDisplayMode();
	}
	
}
