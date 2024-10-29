import java.util.Objects;

public class Client {
    private static int numeroSuivant = 1;
    private int numero;
    private String nom,prenom,telephone;
    private Commande commandeEnCours;

    public Client( String nom, String prenom, String telephone) {

        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.numero=numeroSuivant++;
    }

    public Commande getCommandeEnCours() {
        return commandeEnCours;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }
    public boolean enregistrer(Commande commande){
        if(commandeEnCours!=null||commande.getClient()!=this){
            return false;
        }
        this.commandeEnCours=commande;
        return true;
    }
    public boolean cloturerCommandeEnCours(){
        if(commandeEnCours==null){
            return false;
        }
        commandeEnCours=null;
        return true;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return numero == client.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }
    public String toString() {
        return "client n° " + numero + " (" + prenom  + " " + nom + ", telephone : " + telephone +")";
    }


}
