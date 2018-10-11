import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.addClient("sabaka1", "petrovich1");
        clinic.addClient("sabaka2", "petrovich2");
        clinic.addClient("sabaka3", "petrovich3");
        clinic.addClient("sabaka4", "petrovich4");
        clinic.addClient("sabaka4", "petrovich5");
        clinic.addClient("qwe", "petrovich5");
        clinic.addClient("sabaka5", "petrovich6");

        clinic.showClients();

        clinic.searchByClientName("petrovich5");
        clinic.searchByPetName("sabaka1");
        clinic.searchByClientName("net");

        clinic.showClients();

        clinic.editOrDeleteClientName("petrovich1","zdarova", "edit");
        clinic.editOrDeletePetName("sabaka4","pes","edit");

        clinic.showClients();

        clinic.editOrDeleteClientName("petrovich2","zdarova", "del");
        clinic.editOrDeletePetName("sabaka3","zdarova", "del");

        clinic.showClients();
    }
}
