package domaine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MoniteurImplTest {
  private Stage stage;
  private Moniteur moniteur;
    @BeforeEach
    void setUp() {
        moniteur=new MoniteurImpl("abdel");
        stage= Mockito.mock(Stage.class);


    }




    @Test
    void ajouterStage() {
    }


}