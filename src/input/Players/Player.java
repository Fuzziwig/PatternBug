package input.Players;

import input.Strategies.Strategy;

public abstract class Player {

    private String name = "";
    private Strategy strategy;

    public Player(String name) {
        this.name = name;
    }

    //using Strategy Design Pattern
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void init(){
        strategy.init();
    }

}
