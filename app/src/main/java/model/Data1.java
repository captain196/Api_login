package model;

public class Data1 {

    int id,year;
    String name,color,pantone_value;

    public Data1(int id, int year, String name, String color, String pantone_value) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getPantone_value() {
        return pantone_value;
    }
}
