package domaine;

import exceptions.QuantiteNonAutoriseeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PrixTest {
    private Prix prixAucune;
    private Prix prixPub;
    private Prix prixSolde;

    @BeforeEach
    void setUp() {
        prixAucune=new Prix();
        prixAucune.definirPrix(1,20);
        prixAucune.definirPrix(10,10);
        prixPub=new Prix(TypePromo.PUB,14);
        prixPub.definirPrix(3,15);
        prixSolde=new Prix(TypePromo.SOLDE,12);
    }

    @DisplayName("Test constructeur : ")

    @Test
    void testConstructeur1 (){

        assertThrows(IllegalArgumentException.class,()->new Prix(null,16),"la valeur de type promo est : ");

    }

    @Test
    void testConstructeur2(){

        assertThrows(IllegalArgumentException.class,()->new Prix(TypePromo.PUB,-1),"le prix  est : ");

    }

    @DisplayName("Voir dans le constructeur sans paramétres  type promo == null")
    @Test
    void VoirTypePromoNull() {
        assertNull(prixAucune.getTypePromo());
    }



    @DisplayName("Voir si valeur retourner est égal à celle dans la variable .")
    @Test
    void getTypePromo() {
        assertEquals(prixPub.getTypePromo(),TypePromo.PUB);
    }

    @DisplayName("Voir si valeur défini dans prixPub pareil que celle introduite")
    @Test
    void getValeurPromo() {
        assertEquals(prixPub.getValeurPromo(),14);
    }

    @Test
    void definirPrix() {

        assertThrows(IllegalArgumentException.class,()->new Prix(TypePromo.PUB,14).definirPrix(0,13),"définir ");
    }


    @Test
    void definirPrixUnitaire() {
        assertThrows(IllegalArgumentException.class,()->new Prix(TypePromo.PUB,14).definirPrix(14,-5),"définir ");
    }

    @DisplayName("Test pour voir si dans le constructeur Valeur promo vaut 0")
    @Test
    void getPrix() {
        assertEquals(prixAucune.getValeurPromo(),0);
    }

    @Test

    void TestReplace() {
        prixAucune.definirPrix(4,13);
      assertEquals(prixAucune.getPrix(4),13);
    }

    @Test
    void getPix1(){
        Prix prix=new Prix();
        prix.definirPrix(4,13);
        assertThrows(IllegalArgumentException.class,()->prix.getPrix(-5),"définir ");

    }
    @ParameterizedTest
    @ValueSource (ints = {1,5,9})
    void getPix2(int quantite){
        assertEquals(20,prixAucune.getPrix(quantite));


    }

    @ParameterizedTest
    @ValueSource (ints = {10,15,20,25})
    void getPix2_2(int quantite){
        assertEquals(10,prixAucune.getPrix(quantite));


    }

    @Test
    void getPrix3(){
        assertThrows(QuantiteNonAutoriseeException.class,()->prixPub.getPrix(2));
    }

    @Test
    void getPrix4(){
        assertThrows(QuantiteNonAutoriseeException.class,()->prixSolde.getPrix(1));
    }








}