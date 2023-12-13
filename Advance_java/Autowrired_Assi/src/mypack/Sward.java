package mypack;

import org.springframework.stereotype.Component;

@Component
public class Sward implements Weapon{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("Sward Attack");
	}

}
