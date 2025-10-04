package sujetT1;

public class Rational {
    private int num;
    private int denom;

    public Rational(int n, int d){
        int pgcd = gcd(n, d);
        this.num = n/pgcd;
        this.denom = d/pgcd;
    }

    public Rational(int i){
        this.num = i;
        this.denom = 1;
    }

    public int getNum(){
        return this.num;
    }

    public int getDenom(){
        return this.denom;
    }

    public String toString(){
        if(this.denom == 1){
            return "" + this.num;
        }
        else{
            return this.num + "/" + this.denom;
        }
    }

    private int gcd(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }
}