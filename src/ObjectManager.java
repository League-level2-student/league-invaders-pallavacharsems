import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
Rocketship r;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
Random random = new Random();
ObjectManager(Rocketship r){
	this.r = r;
	
}
void addProjectile(Projectile p) {
	projectiles.add(p);
}
void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void update() {
	for (int i = 0; i < aliens.size(); i++) {
		Alien a = aliens.get(i);
		a.update();
		if(a.y >= LeagueInvaders.HEIGHT ||a.y <= LeagueInvaders.HEIGHT) {
			a.isActive = false;
		}
	}
		for (int h = 0; h < projectiles.size(); h++) {
			Projectile t = projectiles.get(h);
			t.update();
			if(t.y < 0 ) {
				t.isActive = false;
	}
}
}
void draw(Graphics g) {
	r.draw(g);
	for (int i = 0; i < aliens.size(); i++) {
		Alien a = aliens.get(i);
		a.draw(g);
}
	for (int i = 0; i < projectiles.size(); i++) {
		Projectile pr = projectiles.get(i);
		pr.draw(g);
}
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addAlien();
}
}