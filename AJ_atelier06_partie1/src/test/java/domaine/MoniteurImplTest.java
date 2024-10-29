package domaine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoniteurImplTest {

private Sport sport;
private Moniteur moniteur;
private Stage stageStub;
private int numeroSemaine;

    @BeforeEach
    void setUp() {
        sport = new SportStub(true);
        moniteur=new MoniteurImpl("Abdel");
        numeroSemaine=1;
        stageStub=new StageStub(numeroSemaine,sport,moniteur);
    }

    @Test
    void ajouterStageTC1() {


        assertAll(
                ()->  assertTrue(moniteur.ajouterStage(stageStub)),
                ()->  assertEquals(1,moniteur.nombreDeStages()),
                () ->     assertTrue(moniteur.contientStage(stageStub))
        );


    }

    @Test
    void ajouterTC2(){
       int numerSemaine2=2;
       Stage stage= new StageStub(numerSemaine2,sport,moniteur);


        assertAll(

                ()->  assertTrue(moniteur.ajouterStage(stageStub)),
                ()->assertTrue( moniteur.ajouterStage(stage)),

                ()->  assertEquals(2,moniteur.nombreDeStages()),
                () ->     assertTrue(moniteur.contientStage(stage))
        );



    }

    @Test
    void ajouterTC3(){
        int numerSemaine2=2;
        Stage stage= new StageStub(numerSemaine2,sport,moniteur);
        int numerSemaine3=3;
        Stage stage3= new StageStub(numerSemaine3,sport,moniteur);
        assertAll(

                ()->  assertTrue(moniteur.ajouterStage(stageStub)),
                ()->assertTrue( moniteur.ajouterStage(stage)),
                ()->assertTrue( moniteur.ajouterStage(stage3)),


                ()->  assertEquals(3,moniteur.nombreDeStages()),
                () ->     assertTrue(moniteur.contientStage(stage3))
        );

    }





 @Test
    void ajouterTC4(){
     /*int numerSemaine2=2;
     Stage stage= new StageStub(numerSemaine2,sport,moniteur);
     int numerSemaine3=3;
     Stage stage3= new StageStub(numerSemaine3,sport,moniteur);*/
     int numerSemaine4=4;
     Stage stage4= new StageStub(numerSemaine4,sport,moniteur);

     /*moniteur.ajouterStage(stageStub);
     moniteur.ajouterStage(stage);
     moniteur.ajouterStage(stage3);*/
     amenerALEtat(3,moniteur);


     assertAll(


             ()->assertTrue( moniteur.ajouterStage(stage4)),

             ()->  assertEquals(4,moniteur.nombreDeStages()),
             () ->     assertTrue(moniteur.contientStage(stage4))
     );


    }

    private void amenerALEtat(int etat, Moniteur moniteur){
        for (int i = 1; i <=etat; i++) {
            moniteur.ajouterStage(new StageStub(i,sport,moniteur));

        }

    }



    @Test
    void supprimerStageTC5() {
        int numerSemaine4=4;
        Stage stage4= new StageStub(numerSemaine4,sport,moniteur);

        amenerALEtat(3,moniteur);


        assertAll(

                ()->assertTrue( moniteur.ajouterStage(stage4)),
                ()-> assertTrue(moniteur.supprimerStage(stage4)),

                ()->  assertEquals(3,moniteur.nombreDeStages()),
                () ->     assertTrue(!moniteur.contientStage(stage4))
        );


    }
@Test
    void supprimerStageTC6() {
        int numerSemaine3=3;
        Stage stage3= new StageStub(numerSemaine3,sport,moniteur);

        amenerALEtat(2,moniteur);


        assertAll(

                ()->assertTrue( moniteur.ajouterStage(stage3)),
                ()-> assertTrue(moniteur.supprimerStage(stage3)),

                ()->  assertEquals(2,moniteur.nombreDeStages()),
                () ->     assertTrue(!moniteur.contientStage(stage3))
        );


    }

    @Test
    void supprimerStageTC7() {
        int numerSemaine2=2;
        Stage stage2= new StageStub(numerSemaine2,sport,moniteur);

        amenerALEtat(1,moniteur);


        assertAll(

                ()->assertTrue( moniteur.ajouterStage(stage2)),
                ()-> assertTrue(moniteur.supprimerStage(stage2)),

                ()->  assertEquals(1,moniteur.nombreDeStages()),
                () ->     assertTrue(!moniteur.contientStage(stage2))
        );


    }

    @Test
    void supprimerStageTC8() {
        int numerSemaine1=1;
        Stage stage1= new StageStub(numerSemaine1,sport,moniteur);

        amenerALEtat(0,moniteur);


        assertAll(

                ()->assertTrue( moniteur.ajouterStage(stage1)),
                ()-> assertTrue(moniteur.supprimerStage(stage1)),

                ()->  assertEquals(0,moniteur.nombreDeStages()),
                () ->     assertTrue(!moniteur.contientStage(stage1))
        );


    }

  @Test
    void ajouterTC9(){

         int numerSemaine1=4;
      Stage stage1= new StageStub(numerSemaine1,sport,moniteur);
      amenerALEtat(4,moniteur);
      assertAll(

              ()->assertFalse( moniteur.ajouterStage(stage1)),


              ()->  assertEquals(4,moniteur.nombreDeStages()),
              () ->     assertTrue(!moniteur.contientStage(stage1))
      );

  }

  @Test
  void ajouter10(){
      int numerSemaine1=4;
      Stage stage1= new StageStub(numerSemaine1,sport,moniteur);
      amenerALEtat(4,moniteur);
      assertAll(

              ()->assertFalse( moniteur.ajouterStage(stage1)),


              ()->  assertEquals(4,moniteur.nombreDeStages()),
              () ->     assertTrue(!moniteur.contientStage(stage1))
      );

  }
@Test
  void ajouter11(){

  }
}