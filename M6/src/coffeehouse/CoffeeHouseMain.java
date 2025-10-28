package coffeehouse;

public class CoffeeHouseMain {
    public static void main(String[] args) {
        /** First part
        Coffee coffeeSimple = new Coffee(false);
        Coffee coffeeExtras = new Coffee(true);
        Tea teaSimple = new Tea(false);
        Tea teaExtras = new Tea(true);

        coffeeSimple.prepareRecipe();
        coffeeExtras.prepareRecipe();
        teaSimple.prepareRecipe();
        teaExtras.prepareRecipe();
        */

        Barista barista = new Barista();

        barista.takeOrder("coffee").prepareRecipe();
        barista.takeOrder("coffee, extras").prepareRecipe();
        barista.takeOrder("tea").prepareRecipe();
        barista.takeOrder("tea, extras").prepareRecipe();
    }
}
