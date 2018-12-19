package androiddersleri.com.externalsqliteexample.Modals;

public class Country {
    private int countryId;
    private String country;
    private String capital;

    public Country() {
    }

    public Country(int countryId, String country, String capital) {
        this.countryId = countryId;
        this.country = country;
        this.capital = capital;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
