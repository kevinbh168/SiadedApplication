package com.brena.siadedapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Cursos {

    public String Nombre;
    public List<Bimestre> bimestres = new ArrayList<Bimestre>();
    public String getNombre() {
        return Nombre;
    }
}
