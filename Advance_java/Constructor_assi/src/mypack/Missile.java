package mypack;

import org.springframework.stereotype.Component;


public class Missile implements Weapon {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("Missile Attack");
	}

}
