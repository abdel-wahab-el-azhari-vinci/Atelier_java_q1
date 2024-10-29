import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Iterator;

public class Commande implements Iterable<LigneDeCommande> {
    private static int numeroSuivant = 1;
    private int numero;
    private Client client;
    private LocalDateTime date;
    private ArrayList<LigneDeCommande> ligneDeCommandes;

    public Commande(Client client) {
        this.client = client;
        this.ligneDeCommandes=new ArrayList<LigneDeCommande>();
        if(!client.enregistrer(this)){
            throw new IllegalArgumentException("impossible de créer une commande pour un client ayant encore une commande en cours");
        }else{
            client.enregistrer(this);
        }
        this.numero=numeroSuivant;
        numeroSuivant++;
        this.date=LocalDateTime.now();
    }

    public int getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public boolean ajouter (Pizza pizza,int quantite){
        if(this!=client.getCommandeEnCours()){
            return false;
        }
        if(ligneDeCommandes.contains(pizza)){
            int index=ligneDeCommandes.indexOf(pizza);
            int quatiteAncienne=ligneDeCommandes.get(index).getQuantite();
            ligneDeCommandes.get(index).setQuantite((quantite+quatiteAncienne));
        }else{
            LigneDeCommande ligneDeCommande=new LigneDeCommande(pizza, quantite);
            ligneDeCommandes.add(ligneDeCommande);
        }
        return true;
    }
    public boolean ajouter(Pizza pizza){

        return  ajouter(pizza,1);
    }

    public double calculerMontantTotal(){
        double total=0;
        for (LigneDeCommande ligneDeCommande : ligneDeCommandes) {
             total+=ligneDeCommande.calculerPrixTotal();
        }
        return total;
    }
    public String detailler (){
        String str=" ";
        for (LigneDeCommande ligneDeCommande : ligneDeCommandes) {
            str+=ligneDeCommande+"\n";
        }
        return str;


    }

    @Override
    public Iterator<LigneDeCommande> iterator() {
        return this.ligneDeCommandes.iterator();
    }

    public String toString() {
        DateTimeFormatter formater = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String encours = "";
        if (client.getCommandeEnCours() == this)
            encours = " (en cours)";
        return "Commande n° " + numero + encours + " du " + client + "\ndate : " + formater.format(date);
    }
}
