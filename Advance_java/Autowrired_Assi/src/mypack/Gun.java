package mypack;

import org.springframework.stereotype.Component;

@Component
public class Gun implements Weapon{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("Gun Attack");
	}

}
