public class Animals {
    private int id;
    private String name;
    private String type;
    private String weight;
    private String height;

    public String getHeight() {
        return height;
    }

    public Animals(String name, String type, String weight, String height){
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }






}
