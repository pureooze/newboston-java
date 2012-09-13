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
	public DisplayMode findFirstCompatibleMode(DisplayMode modes[]){
		
		DisplayMode goodModes[] = vc.getDisplayModes();
		for(int x = 0; x < modes.length; x++){
			for(int y = 0; y < goodModes.length; y++){
				if(displayModesMatch(modes[x], goodModes[y])){
					return modes[x];
				}
			}
		}
		return null;
	}
	
	//get current DM
	public DisplayMode getCurrentDM(){
		
		return vc.getDisplayMode();
	}
	
	//checks if two modes match each other
	public boolean displayModesMatch(DisplayMode m1, DisplayMode m2){
		
		if(m1.getWidth() != m2.getWidth() || 
				m1.getHeight() != m2.getHeight()){
			return false;
		}
		
		if(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && 
				m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && 
				m1.getBitDepth() != m2.getBitDepth()){
			return false;
		}
		
		if(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && 
				m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && 
				m1.getRefreshRate() != m2.getRefreshRate()){
			return false;
		}
		
		return true;
	}
	
}
