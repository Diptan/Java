package pageobject.objects;

public class ResultItem {
    private Location coordinates;
    private String name;

    public Location getCoordinates()
    {
        return coordinates;
    }
    public void setCoordinates(Location coordinates) {
        this.coordinates = coordinates;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name) {this.name = name; }
}
