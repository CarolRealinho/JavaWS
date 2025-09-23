public class EuclideMain {
public static void main(String[] args) {
    // Numbers that we want to calculate the PGCD
    int a = -12;
    int aInit = a; // to write in the end 
    int b = 16;
    int bInit = b; // to write in the end 
    int aux;

    if (a<0){
        a = Math.abs(a);
    }
    if (b<0){
        b = Math.abs(b);
    }

    while (b!=0){
        aux = b;
        b = a%b;
        a = aux;
    }

    System.out.print("PGCD (" + aInit + ", " + bInit + ")" + " is " + a);
}
}
