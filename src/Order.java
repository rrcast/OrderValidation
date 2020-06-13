import java.util.ArrayList;
import java.util.List;

public class Order implements Subject{
    private Boolean shopper;
    private Integer cookingTime;

    public Boolean getShopper() {
        return shopper;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public Boolean getPartner() {
        return partner;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    private Boolean partner;
    private String lat;
    private String lng;
    private List<Observer> observerList;

    public Order(Boolean shopper, Integer cookingTime, Boolean partner, String lat, String lng) {
        this.shopper = shopper;
        this.cookingTime = cookingTime;
        this.partner = partner;
        this.lat = lat;
        this.lng = lng;
    }



    public Order(){
        this.observerList = new ArrayList<>();

    }

    @Override
    public void addObserver(Observer o) {
        this.observerList.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        this.observerList.remove(o);

    }

    @Override
    public void notifyAllObservers() {
        for(Observer o: observerList){
            o.update(shopper,cookingTime,partner,lat,lng);
        }

    }

    public void setShopper(Boolean shopper) {
        this.shopper = shopper;
        notifyAllObservers();
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
        notifyAllObservers();
    }

    public void setPartner(Boolean partner) {
        this.partner = partner;
        notifyAllObservers();
    }

    public void setLat(String lat) {
        this.lat = lat;
        notifyAllObservers();
    }

    public void setLng(String lng) {
        this.lng = lng;
        notifyAllObservers();
    }
}
