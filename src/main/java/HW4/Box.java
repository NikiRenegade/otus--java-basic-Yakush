package HW4;

public class Box {

    private int width;
    private int height;
    private int depth;
    private String color;
    private boolean isOpen;
    private String item;

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getDepth() {
        return depth;
    }
    public String getColor() {
        return color;
    }
    public boolean getIsOpen() {
        return isOpen;
    }
    public String getItem() {
        return item;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setOpen(boolean open) {
        isOpen = open;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public Box(int width, int height, int depth, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
        this.isOpen = false;
        this.item = null;
    }

    public void openOrClose() {
        this.isOpen = !this.isOpen;
        System.out.println("Коробка" + (this.isOpen ? "открыта" : "закрыта"));
    }

    public void rePaint (String newColor) {
        this.color = newColor;
        System.out.println("Коробка перекрашена в:" + this.color);
    }

    public void putItem(String item) {
        if (isOpen) {
            if (item == null) {
                this.item = item;
                System.out.println("Предмет успешно помещен в коробку");
            } else {
                System.out.println("Не удалось положить предмет в коробку! В коробке уже находится:" + this.item);
            }
        }
        else {
            System.out.println("Не удалось положить предмет в коробку! Коробка закрыта");
        }
    }

    public void removeItem() {
        if (isOpen) {
            if (item == null) {
                System.out.println("Не удалось вытащить предмет из коробки! коробка пуста");
            } else {
                System.out.println("Предмет успешно вытащен из коробки");
                this.item = null;
            }
        }
        else {
            System.out.println("Не удалось вытащить предмет из коробки! Коробка закрыта");
        }
    }
    public void printBoxInfo() {
        System.out.println("Размеры коробки: " + width + "x" + height + "x" + depth
                + "\nЦвет коробки: " + color
                + "\nКоробка " + (isOpen ? "открыта" : "закрыта")
                + "\nПредмет в коробке: " + (item == null ? "нет предмета" : item));
    }

}

