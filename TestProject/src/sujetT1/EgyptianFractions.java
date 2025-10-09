package sujetT1;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public static List<Rational> decompose(Rational f) {
        List<Rational> result = new ArrayList<>();
        Rational remaining = f; // copy of the fraction

        while (remaining.getNum() != 0) {
            // compute next unit fraction denominator
            int n = (int) Math.ceil((double) remaining.getDenom() / remaining.getNum());

            // add 1/n to the list
            result.add(new Rational(1, n));

            // subtract 1/n from remaining
            Rational unit = new Rational(1, n);
            remaining = remaining.subtract(unit);
        }

        return result;
    }
}
