
import java.util.Map;
import java.util.TreeMap;

public class Clinic {
    private int idCounter = 1;
    private Map<Integer, Client> clients = new TreeMap<>();

    public void addClient(String petName, String clientName) {
        System.out.print("Try to add client... ");
        if (null == searchByName(clientName, new Client(), "clientName")) {
            clients.put(idCounter, new Client(new Pet(petName), idCounter++, clientName));
            System.out.println("Client added!");
        } else {
            System.out.println("A client with this name exists. Try again.");
        }
    }

    public void search() {

    }

    public void showClients() {
        clients.forEach((k, v) -> System.out.println(v));
        System.out.println();
    }

    public void searchByClientName(String name) {
        System.out.print("By clientName ");
        Client searchResult = searchByName(name, new Client(), "clientName");
    }

    public void searchByPetName(String name) {
        System.out.print("By petName ");
        Client searchResult = searchByName(name, new Pet(), "petName");
    }

    public void editOrDeleteClientName(String currentName, String newName, String operation) {

        Client modifiedClient = searchByName(currentName, new Client(), null);
        for (Map.Entry<Integer, Client> entry : clients.entrySet()) {
            if (currentName.equals(entry.getValue().getName())) {
                if ("edit".equals(operation)) {
                    modifiedClient.setName(newName);
                    clients.replace(entry.getKey(), modifiedClient);
                    break;
                }
                clients.remove(entry.getKey());
                break;
            }
        }
    }

    public void editOrDeletePetName(String currentPetName, String newName, String operation) {
        Map<Integer, Client> modifiedClients = new TreeMap<>();

        for (Map.Entry<Integer, Client> entry : clients.entrySet()) {
            int id = entry.getKey();
            Client client = entry.getValue();

            if ("edit".equals(operation)) {
                if (currentPetName.equals(client.getPetName())) {
                    client.setPetName(newName);
                    modifiedClients.put(id, client);
                }
                else {
                    modifiedClients.put(id, client);
                }
            } else {
                if (!currentPetName.equals(client.getPetName())) {
                    modifiedClients.put(id, client);
                }
            }
        }

        clients = modifiedClients;
    }

    public Client searchByName(String name, Object o, String message) {
        Client searchResult = null;
        if (o instanceof Pet) {
            for (Client client : clients.values()) {
                if (name.equals(client.getPetName())) {
                    searchResult = client;
                    break;
                }
            }
        } else if (o instanceof Client) {
            for (Client client : clients.values()) {
                if (name.equals(client.getName())) {
                    searchResult = client;
                    break;
                }
            }
        }

        if (null != message) {
            if (searchResult == null) {
                System.out.println("Client with " + message + " \"" + name + "\" not found. ");
            } else {
                System.out.println("Search result: " + searchResult + ". ");
            }
        }

        return searchResult;
    }
}