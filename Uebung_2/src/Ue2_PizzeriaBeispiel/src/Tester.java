package Ue2_PizzeriaBeispiel.src;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Pizzeria meinePizzeria = new Pizzeria();
		Pizza neuePizza =  meinePizzeria.erstellePizza("Berlin", "Salami");
		Pizza neuePizza2 =  meinePizzeria.erstellePizza("Koeln", "Salami");
		
	}

}
