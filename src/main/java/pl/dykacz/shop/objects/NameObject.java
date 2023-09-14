package pl.dykacz.shop.objects;

public class NameObject {
    private final String name;

    public NameObject(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name cannot be null!");
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty!");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
