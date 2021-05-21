package ro.sd.a2.dto;


public class ConstructorDto {

    private String constructor_id;


    private String constructor_name;


    private float constructor_price;


    private int constructor_points;

    public ConstructorDto() {
    }

    public String getConstructor_id() {
        return constructor_id;
    }

    public void setConstructor_id(String constructor_id) {
        this.constructor_id = constructor_id;
    }

    public String getConstructor_name() {
        return constructor_name;
    }

    public void setConstructor_name(String constructor_name) {
        this.constructor_name = constructor_name;
    }

    public float getConstructor_price() {
        return constructor_price;
    }

    public void setConstructor_price(float constructor_price) {
        this.constructor_price = constructor_price;
    }

    public int getConstructor_points() {
        return constructor_points;
    }

    public void setConstructor_points(int constructor_points) {
        this.constructor_points = constructor_points;
    }
}
