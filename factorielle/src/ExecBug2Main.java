import javax.swing.text.Position;

class MyPosition implements Position{
    private int x;
    private int y;

    public MyPosition(){
        x=0;
        y=0;
    }

    public void moveTo(int newX, int newY) {
        x=newX;
        y=newY;
    }

    public void display(){
        System.out.println("Position: (" + x + ", " + y + ")");
    }

    @Override
    public int getOffset(){
        return 0; // required by Position interface
    }
}

public class ExecBug2Main {
public static void main(String[] args) {
    MyPosition p = new MyPosition();
    p.display();
    p.moveTo(4, 2);
    p.display();
}
}
