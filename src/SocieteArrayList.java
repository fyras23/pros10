import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employee> {

    private ArrayList<Employee> employes;

    public SocieteArrayList() {
        this.employes = new ArrayList<>();
    }

    @Override
    public void ajouterEmploye(Employee employe) {
        employes.add(employe);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employee emp : employes) {
            if (emp.getLastName().equals(nom)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean rechercherEmploye(Employee employe) {
        return employes.contains(employe);
    }


    @Override
    public void supprimerEmploye(Employee employe) {
        employes.remove(employe);
    }


    @Override
    public void displayEmploye() {
        for (Employee emp : employes) {
            System.out.println(emp.toString());
        }
    }


    @Override
    public void trierEmployeParId() {
        Collections.sort(employes, (emp1, emp2) -> Integer.compare(emp1.getId(), emp2.getId()));
    }

    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        employes.sort(Comparator
                .comparing(Employee::getLastName)
                .thenComparing(Employee::getDepartment)
                .thenComparingInt(Employee::getGrade));
    }
}
