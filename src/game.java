import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class game extends JFrame {
	
	private    Animation        animated;
	private    screenManager    screen;
	private    Image            bg;
	
	public static void main(String[] args){
		game g = new game();
		g.run();
		
	}
	
	//display modes array
	private static final DisplayMode modes1[] = {
		
		new DisplayMode(800, 600, 32, 0),
		new DisplayMode(800, 600, 24, 0),
		new DisplayMode(800, 600, 16, 0),
		
		new DisplayMode(640, 480, 32, 0),
		new DisplayMode(640, 480, 24, 0),
		new DisplayMode(640, 480, 16, 0),
	};
	
	//load images and add scenes
	public void loadImages(){
		
		Image open      = new ImageIcon("C:\\Users\\User\\newboston-java\\Images\\eyes_open.png").getImage();
		Image close     = new ImageIcon("C:\\Users\\User\\newboston-java\\Images\\eyes_closed.png").getImage();
		      bg        = new ImageIcon("C:\\Users\\User\\newboston-java\\Images\\bg.jpg").getImage();
		      animated  = new Animation();
		
		animated.addScene(open, 250);
		animated.addScene(close, 250);
	}
	
	//main method called from main
	public void run(){
		
		screen = new screenManager();
		
		try{
			DisplayMode dm = screen.findFirstCompatibleMode(modes1);
			screen.setFullScreen(dm);
			loadImages();
			movieLoop();
		}finally{
			screen.restoreScreen();
		}
	}
	
	//play movie
	public void movieLoop(){
		
		long     startingTime     = System.currentTimeMillis();
		long     cummlTime        = startingTime;
		
		while(cummlTime - startingTime < 7000){
			long timePassed = System.currentTimeMillis() - cummlTime;
			cummlTime += timePassed;
			animated.update(timePassed);
			
			//draw and update screen
			Graphics2D g = screen.getGraphics();
			draw(g);
			g.dispose();
			screen.update();
			
			try{
				Thread.sleep(20);
			}catch(Exception ex){
				
			}
		}
		
	}
	
	//draw graphics
	public void draw(Graphics g){
		g.drawImage(bg, 0, 0, null);
		g.drawImage(animated.getImage(), 0, 0, null);
	}
	
}


	
