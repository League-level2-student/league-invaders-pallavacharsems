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
	int score = 0;

	ObjectManager(Rocketship r) {
		this.r = r;

	}

	public int getScore() {
		return score;

	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien a = aliens.get(i);
			a.update();
			if (a.y >= LeagueInvaders.HEIGHT || a.y <= 0) {
				a.isActive = false;
			}
		}
		for (int h = 0; h < projectiles.size(); h++) {
			Projectile t = projectiles.get(h);
			t.update();
			if (t.y < 0) {
				t.isActive = false;

			}
		}
		checkCollision();
		purgeObjects();
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien c = aliens.get(i);
			if (c.isActive == false) {
				aliens.remove(c);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile a = projectiles.get(i);
			if (a.isActive == false) {
				projectiles.remove(a);
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

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien b = aliens.get(i);
			if (r.collisionBox.intersects(b.collisionBox)) {
				r.isActive = false;
				b.isActive = false;
				System.out.println("t");
			}
			for (int k = 0; k < projectiles.size(); k++) {
				Projectile d = projectiles.get(k);
				if (d.collisionBox.intersects(b.collisionBox)) {
					d.isActive = false;
					b.isActive = false;
					score+=1;
				}
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}