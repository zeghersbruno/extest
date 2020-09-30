package be.abis.exa1.model;

import be.abis.exa1.utilities.FilesUtilities;
import java.util.ArrayList;
import java.util.List;

public class Address {
    private String street;
    private String nr;
    private String zipCode;
    private String town;
    private String country;
    private String countryCode;

    public Address(String street, String nr, String zipCode, String town, String country, String countryCode) {
        this.street = street;
        this.nr = nr;
        this.zipCode = zipCode;
        this.town = town;
        this.country = country;
        this.countryCode = countryCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean checkBelgianZipCode() {
        String regex = "^[0-9]{4}";
        boolean isAZipCode = false;
        if (zipCode.matches(regex)) {
            return true;
        }
        return isAZipCode;
    }

    public void writeAddressToFile() {
        List<String> lsSt = new ArrayList<>();
        lsSt.add("Address " + street + " " + nr + " " + zipCode + " " + town + " " + country + " " + countryCode);
        String fileName = "C:\\Users\\bruno\\IdeaProjects\\JavaTest\\ExA1\\src\\main\\resources\\address.txt";
        FilesUtilities.writeToFile(lsSt, fileName);
    }

}
