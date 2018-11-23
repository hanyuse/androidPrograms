package example.com.androidprograms.instance;
//定义实体类

public class Fruit {
    private String name;
    private String id;

    public Fruit(String name,String id){
        this.name = name;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
