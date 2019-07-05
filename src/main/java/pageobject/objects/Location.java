package pageobject.objects;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double coordinates) {
        this.latitude = coordinates;
    }

    public double getLongitude(){
        return longitude;
    }
    public void setLongitude(double coordinates) {
        this.longitude = coordinates;
    }

}
