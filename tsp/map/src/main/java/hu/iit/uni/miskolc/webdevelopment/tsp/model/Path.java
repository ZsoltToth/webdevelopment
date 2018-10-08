package hu.iit.uni.miskolc.webdevelopment.tsp.model;

public class Path {

    private City source;
    private City destination;
    private double cost;

    public Path(City source, City destination, double cost) throws  NegativePathCostException{
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public City getSource() {
        return source;
    }

    public City getDestination() {
        return destination;
    }

    public double getCost() {
        return cost;
    }
}
