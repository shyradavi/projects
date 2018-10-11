public class Client {
    private Pet pet;
    private int id;
    private String name;

    public Client() {
    }

    public Client(Pet pet, int id, String name) {
        this.pet = pet;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetName() {
        return pet.getName();
    }

    public void setPetName(String petName) {
        this.pet.setName(petName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id && pet.equals(client.pet) && name.equals(client.name);
    }

    @Override
    public int hashCode() {
        int result = pet.hashCode();
        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name +", "+ pet.toString();
    }
}
