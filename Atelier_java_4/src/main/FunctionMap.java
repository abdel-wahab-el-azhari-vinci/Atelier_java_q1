package main;

import domaine.Employe;

import java.util.function.Function;


public class FunctionMap implements Function<Employe,String> {


    @Override
    public String apply(Employe employe) {
        return employe.getNom();
    }
}
