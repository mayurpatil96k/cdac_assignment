package mypack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Soldier {

private Weapon weapon;
	
	public Soldier(Weapon weapon) {
	this.weapon = weapon;
}

	void perform()
	{
		weapon.attack();
	}
}
