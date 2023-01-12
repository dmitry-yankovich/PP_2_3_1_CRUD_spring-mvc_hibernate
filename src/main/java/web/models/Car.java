package web.models;

public class Car {
    private long id;



    private String producer;
    private String model;
    private Color color;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                '}';
    }

    public Car(long id, String producer, String model, Color color) {
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.color = color;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public long getId() {
        return id;
    }
}
