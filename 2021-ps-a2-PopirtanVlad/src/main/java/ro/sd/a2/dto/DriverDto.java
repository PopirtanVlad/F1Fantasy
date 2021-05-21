package ro.sd.a2.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class DriverDto {

    private String driver_id;

    private String driver_name;

    private int driver_nr;

    private int driver_age;

    private String driver_nationality;

    private String driver_constructor_id;

    private float driver_price;

    private int driver_points;

    private  int driver_standing;

    public DriverDto() {
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public int getDriver_nr() {
        return driver_nr;
    }

    public void setDriver_nr(int driver_nr) {
        this.driver_nr = driver_nr;
    }

    public int getDriver_age() {
        return driver_age;
    }

    public void setDriver_age(int driver_age) {
        this.driver_age = driver_age;
    }

    public String getDriver_nationality() {
        return driver_nationality;
    }

    public void setDriver_nationality(String driver_nationality) {
        this.driver_nationality = driver_nationality;
    }

    public String getDriver_constructor_id() {
        return driver_constructor_id;
    }

    public void setDriver_constructor_id(String driver_constructor_id) {
        this.driver_constructor_id = driver_constructor_id;
    }

    public float getDriver_price() {
        return driver_price;
    }

    public void setDriver_price(float driver_price) {
        this.driver_price = driver_price;
    }

    public int getDriver_points() {
        return driver_points;
    }

    public void setDriver_points(int driver_points) {
        this.driver_points = driver_points;
    }

    public int getDriver_standing() {
        return driver_standing;
    }

    public void setDriver_standing(int driver_standing) {
        this.driver_standing = driver_standing;
    }
}

