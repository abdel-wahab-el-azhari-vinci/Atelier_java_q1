package domaine;

import exceptions.DateDejaPresenteException;
import exceptions.PrixNonDisponibleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {
    private Prix prixAucune;
    private Prix prixPub;
    private Prix prixSolde;
    private Produit produit;
    private Produit produit1;
    private  LocalDate date1;
    private  LocalDate date;

    @BeforeEach
    public void setUp() {
        prixAucune=new Prix();
        prixAucune.definirPrix(1,20);
        prixAucune.definirPrix(10,10);
        prixPub=new Prix(TypePromo.PUB,14);
        prixPub.definirPrix(3,15);
        prixSolde=new Prix(TypePromo.SOLDE,12);
        produit=new Produit("Abdel","nike","Vetement");
        produit.ajouterPrix(LocalDate.now(),prixAucune);
        date=LocalDate.of(2024,10,12);
        produit.ajouterPrix(date,prixPub);
         date1=LocalDate.of(2023,10,12);
        produit.ajouterPrix(date1,prixPub);
        produit1=new Produit("Sys","nak","vetement");

    }

    @Test
    void testConstructeur(){
        assertThrows(IllegalArgumentException.class,()->new Produit("","",""));
    }

    @Test
    void testConstructeur1(){
        assertThrows(IllegalArgumentException.class,()->new Produit(null,null,null));
    }


    @Test
    void getMarque() {
        assertEquals(produit.getMarque(),"nike");
    }

    @Test
    void getNom() {
        assertEquals(produit.getNom(),"Abdel");
    }

    @Test
    void getRayon() {
        assertEquals(produit.getRayon(),"Vetement");
    }

    @Test
    void ajouterPrix1() {
        assertThrows(IllegalArgumentException.class,()->new Produit("vv","vv","vv").ajouterPrix(null,null));
    }

    @Test
    void ajouterPrix2() {
        assertThrows(DateDejaPresenteException.class,()->produit.ajouterPrix(date,prixPub));
    }

    @Test
    void ajouterPrix3() {
        LocalDate date2=LocalDate.of(2024,10,15);
       produit.ajouterPrix(date2,prixSolde);
       assertEquals(prixSolde,produit.getPrix(date2));
    }

    @Test
    void ajouterPrix4() {
        LocalDate date2=LocalDate.of(2022,10,15);
        assertThrows(PrixNonDisponibleException.class,()->produit.getPrix(date2));
    }
    @Test
    void ajouterPrix5() {
        LocalDate date2=LocalDate.of(2022,10,15);
        assertThrows(PrixNonDisponibleException.class,()->new Produit("vd","vs","vv").getPrix(date2));
    }

    @Test
    void ajouterPrix6(){
        LocalDate date2=LocalDate.of(2023,11,14);
        assertEquals(produit.getPrix(date2),prixPub);
    }

    @Test
    void equals1(){
        Produit produit2=new Produit("Sys","nak","vetement");
        assertEquals(produit2,produit1);
    }

    @Test
    void equals2(){
        Produit produit2=new Produit("Syse","nak","vetement");
        assertFalse(produit2.equals(produit1));
    }

    @Test
    void equals3(){
        Produit produit2=new Produit("Sys","nakii","vetement");
        assertFalse(produit2.equals(produit1));
    }

    @Test
    void equals4(){
        Produit produit2=new Produit("Sys","nak","vetementss");
        assertFalse(produit2.equals(produit1));
    }

    @Test
    void hascode(){
        Produit produit2=new Produit("Sys","nak","vetement");
        assertEquals(produit2.hashCode(),produit1.hashCode());

    }












}