public class Customer {

    //Long id, String name, String city, String tier
    private long id;
    private String name;
    private String city;
    private String tier;

    public Customer() {
    }

    public Customer(long id, String name, String city, String tier) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.tier = tier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
}
