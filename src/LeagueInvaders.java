import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel gpanel;
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 750;
	public static void main(String[] args) {
		new LeagueInvaders().run();
		LeagueInvaders LI = new LeagueInvaders();
		LI.setup();
		

		
	}
	LeagueInvaders(){
		frame = new JFrame();
		gpanel = new GamePanel();
		frame.addKeyListener(gpanel);

	}

	
	private void run() {
		// TODO Auto-generated method stub
		
	}
void setup() {
	frame.add(gpanel);
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}

}