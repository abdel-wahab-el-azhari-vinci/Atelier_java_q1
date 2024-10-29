package domaine;

import java.util.Set;

public class StageStub implements Stage {
   private Moniteur moniteur;
   private Sport sport;
    private int numeroDeSemaine;


    public StageStub(int numeroDeSemaine, Sport sport ,Moniteur moniteur) {
        this.moniteur = moniteur;
        this.sport = sport;
        this.numeroDeSemaine= numeroDeSemaine;
    }

    @Override
    public String getIntitule() {
        return "";
    }

    /**
     * @return
     */
    @Override
    public String getLieu() {
        return "";
    }

    /**
     * @return
     */
    @Override
    public int getNumeroDeSemaine() {
        return numeroDeSemaine;
    }

    /**
     * @return
     */
    @Override
    public Sport getSport() {
        return sport;
    }

    /**
     * @param moniteur le moniteur qui va assurer le stage.
     * @return
     */
    @Override
    public boolean enregistrerMoniteur(Moniteur moniteur) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean supprimerMoniteur() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public Moniteur getMoniteur() {
        return moniteur;
    }

    /**
     * @param enfant l'enfant qui veut s'inscrire au stage.
     * @return
     */
    @Override
    public boolean ajouterEnfant(Enfant enfant) {
        return false;
    }

    /**
     * @param enfant l'enfant qui veut se desinscrire au stage.
     * @return
     */
    @Override
    public boolean supprimerEnfant(Enfant enfant) {
        return false;
    }

    /**
     * @param enfant l'enfant qu'il faut tester.
     * @return
     */
    @Override
    public boolean contientEnfant(Enfant enfant) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public int nombreDEnfants() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public Set<Enfant> enfants() {
        return Set.of();
    }
}
