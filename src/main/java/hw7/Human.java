package hw7;

public class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void getIntoTransport(Transport transport) {
        this.currentTransport = transport;
        System.out.println(name + " сел на транспорт: " + transport.getName());
    }

    public void getOffTransport() {
        if (currentTransport != null) {
            System.out.println(name + " вышел из транспорта: " + currentTransport.getName());
            currentTransport = null;
        }
    }

    public boolean move(double distance, TerrainType terrain) {
        if (currentTransport != null) {
            boolean success = currentTransport.move(distance, terrain);
            if (success) {
                System.out.println(name + "успешно передвигается на " + currentTransport.getName() + " по " + terrain);
            }
            return success;
        } else {
            System.out.println(name + " идёт пешком по " + terrain);
            return true;
        }
    }
}
