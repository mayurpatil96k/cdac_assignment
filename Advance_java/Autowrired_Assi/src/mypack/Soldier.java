package mypack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Soldier {
@Autowired
@Qualifier(value="sward")
private Weapon weapon;
	
	void perform()
	{
		weapon.attack();
	}
}
