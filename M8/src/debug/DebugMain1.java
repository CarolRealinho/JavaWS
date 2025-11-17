package debug;

public class DebugMain1 {

	public static void main(String[] args) {
		Position[] positions = new Position[3];
		for(int i = 0; i < positions.length; i++) {
            positions[i] = new Position(i,i);
			positions[i].translate(i, i);
			System.out.println(positions[i]);
		}
	}

}
