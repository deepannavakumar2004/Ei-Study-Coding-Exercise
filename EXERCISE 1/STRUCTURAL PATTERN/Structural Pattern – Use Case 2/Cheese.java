public class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 2.0;
    }
}
