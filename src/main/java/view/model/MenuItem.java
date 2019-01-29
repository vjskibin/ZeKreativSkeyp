package view.model;

public class MenuItem {
//    private int id;
//    private String name;
//    private String gender;
//    private int age;
//    private String role;
//
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getGender() {
//        return gender;
//    }
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//    public String getRole() {
//        return role;
//    }
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee:: ID="+this.id+" Name=" + this.name + " Age=" + this.age + " Gender=" + this.gender +
//                " Role=" + this.role;
//    }
    private Integer id;
    private String name;
    private Float price;
    private String description;
    private Float calories;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " NAME: " + this.getName() + " DESCRIPTION: " + this.getDescription() + " CALORIES: " + this.getCalories() + " PRICE: " + this.getPrice();
    }
}
