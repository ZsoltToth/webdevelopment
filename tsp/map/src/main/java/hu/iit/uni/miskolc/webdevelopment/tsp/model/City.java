package hu.iit.uni.miskolc.webdevelopment.tsp.model;

public class City {

    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof City == false){
            return false;
        }
        return this.name.equals(((City)obj).name);
    }
}
