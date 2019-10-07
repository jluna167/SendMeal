package frsf.isi.lunaojeda.dam.sendmeal.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plato {
    private String Nombre;
    private double Precio;

    public Plato(){

    }

    public Plato(String nombre, double precio) {
        Nombre = nombre;
        Precio = precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plato plato = (Plato) o;
        return Double.compare(plato.Precio, Precio) == 0 &&
                Objects.equals(Nombre, plato.Nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Precio);
    }

    public static List<Plato> getLista(){
        ArrayList<Plato> resultado = new ArrayList<Plato>();

        resultado.add(new Plato("Plato1", 123));
        resultado.add(new Plato("Plato2", 123));
        resultado.add(new Plato("Plato3", 123));
        resultado.add(new Plato("Plato4", 123));
        resultado.add(new Plato("Plato5", 123));
        resultado.add(new Plato("Plato6", 123));
        resultado.add(new Plato("Plato7", 123));
        resultado.add(new Plato("Plato8", 123));
        resultado.add(new Plato("Plato9", 123));
        resultado.add(new Plato("Plato10", 123));
        return resultado;


    }
}
