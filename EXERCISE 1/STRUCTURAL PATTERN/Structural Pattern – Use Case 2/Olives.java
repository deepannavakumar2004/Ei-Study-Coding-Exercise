public class Olives extends ToppingDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 1.5;
    }
}
