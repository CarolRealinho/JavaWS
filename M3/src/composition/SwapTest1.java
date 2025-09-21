package composition;

class Complex {
    double re; 
    double im;

    public Complex(double x, double y) {
        this.re = x;
        this.im = y;
    }

    public void display() {
        System.out.println("(" + re + ", " + im + ")");
    }
}

class Swapper {
    public void swap(Complex a, Complex b) {
        double re = a.re;
        double im = a.im;

        a.re = b.re;
        a.im = b.im;

        b.re = re;
        b.im = im;
    }
}

public class SwapTest1 {
    public static void main(String[] args) {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 4);

        Swapper s = new Swapper();
        s.swap(a, b);

        System.out.print("a = "); a.display();
        System.out.print("b = "); b.display();
    }
}

