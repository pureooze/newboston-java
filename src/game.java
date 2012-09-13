import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class game extends JFrame {

	private 	Screen 		screen;
	private		Image		bg;
	private		Animation	animatedFace;
	
	
	public static void main(String[] args){
		
		DisplayMode 	dm 	= new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		game 			b 	= new game();
		
		b.run(dm);
	}

	//loads pictures and adds scene
	public void loadPics(){
		
		bg				= new ImageIcon("C:\\Users\\User\\Documents\\Java\\Images\\bg.jpg").getImage();
		Image open		= new ImageIcon("C:\\Users\\User\\Documents\\Java\\Images\\eyes_open.png").getImage();
		Image closed	= new ImageIcon("C:\\Users\\User\\Documents\\Java\\Images\\eyes_closed.png").getImage();
		animatedFace 	= new Animation();
		
		animatedFace.addScene(open, 250);
		animatedFace.addScene(closed, 250);
	}
	
	//runs the animation
	public void run(DisplayMode dm){
		
		screen		= new Screen();
		
		try{
			screen.setFullScreen(dm, new JFrame());
			loadPics();
			movieLoop();
		}finally{
			screen.restoreScreen();
		}
	}
	
	//movie loop
	public void movieLoop(){
		
		long	startingTime	= System.currentTimeMillis();
		long	cummulTime		= startingTime;
		
		while(cummulTime - startingTime < 5000){
			long		timePassed		= System.currentTimeMillis() - cummulTime;
			Graphics 	g				= screen.getFullScreenWindow().getGraphics();
			
			cummulTime += timePassed;
			animatedFace.update(timePassed);
			draw(g);
			g.dispose();
			
			try{
				Thread.sleep(20);
			}catch(Exception ex){
				
			}
		}
	}
	
	//draw method
	public void draw(Graphics g){
		
		g.drawImage(bg, 0, 0, null);
		g.drawImage(animatedFace.getImage(), 0, 0, null);
	}
	
}
























