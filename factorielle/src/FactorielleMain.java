public class FactorielleMain {
    public static void main(String[] args) {
        int n=4;
        int factorial = 1; 

        if(n<0) {
            System.out.print("Can't calculate the factorial of negative numbers.");
        }
        else{
            //while (n>1){
            //    factorial*=n;
            //    n--;
            //}

            for(int i=n;i>1;i--){
                System.out.print(i);
                factorial*=i;
            }

            System.out.print("Factorial = " + factorial);
        }
    }
}
