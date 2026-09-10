
package Clases;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Directorio agenda = new Directorio();
        Contacto c1 = new Contacto(7, "Mauro", "Perez", "Villa Mercedes", "Guemes 1370");
        Contacto c2 = new Contacto(13, "Melisa", "Lucero", "Villa Mercedes", "Guemes 1370");
        Contacto c3 = new Contacto(24, "Enzo", "Fernandez", "Manchester", "Street 1");
        Contacto c4 = new Contacto(9, "Julian", "Alvarez", "Madrid", "Calle 2");
        Contacto c5= new Contacto(10, "Lionel", "Messi", "Miame", "Street 3");
        
        //metodo agregar funciona, no permite ingresar un numero que ya existe
        agenda.agregarContacto(c1, 2657285374L);
        agenda.agregarContacto(c2, 2657203654L);
        agenda.agregarContacto(c2, 2657203650L);
        agenda.agregarContacto(c3, 1122334455L);
        agenda.agregarContacto(c4, 9988776655L);
        agenda.agregarContacto(c5, 1234567890L);
        
        agenda.listarContactos();
        
        //metodo buscar contacto funciona
        Contacto c = agenda.buscarContacto(2657285374L);
        System.out.println(c);
        
        //metodo buscar telefono funciona
        TreeSet<Long> tel = agenda.buscarTelefono("Lucero");
        System.out.println("\nNumeros asociados: ");
        for (Long num : tel) {
            System.out.println(num);
        }
        
        // metodo buscar por ciudad funciona
        ArrayList<Contacto> contacto = agenda.buscarContactos("Manchester");
        System.out.println("\nContactos de la ciudad:");
        for (Contacto contactoCiudad : contacto) {
            System.out.println(contactoCiudad.toString());
        }
        
        agenda.borrarContacto(2657203650L);
        System.out.println("\n");
        agenda.listarContactos();
    }
    
}
