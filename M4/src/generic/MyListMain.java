package generic;

import geometry.Position;

public class MyListMain {
	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		// part 1: fill a DoubleList
		MyList<Double> dl1 = new MyList<Double>();
		dl1.display();
		dl1.insertElement(0, 0.0);
		dl1.display();
		dl1.insertElement(1, 1.1);
		dl1.display();
		
		// call some other methods
		int sz = dl1.size();
		boolean e = dl1.isEmpty();
		System.out.println("size = " +sz + ", empty = " + e);
		dl1.removeElement(0);
		dl1.display();
		
		// create other lists
		MyList<Position> dl2 = new MyList<Position>();
		Position pos1 = new Position(0,0);
		Position pos2 = new Position(5,12);
		dl2.insertElement(0,pos1);
		dl2.insertElement(0, pos2);
		MyList<String> dl3 = new MyList<String>();
		dl3.insertElement(0, "Hello");
		dl3.insertElement(0, "Bonjour");
		dl3.insertElement(0, "Servus");
		
		// display the 3 lists
		dl1.display();
		dl2.display();
		dl3.display();
	}
}
