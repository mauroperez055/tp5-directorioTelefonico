
package Clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Directorio {
    private TreeMap<Long, Contacto> directorio;

    public Directorio() {
        this.directorio = new TreeMap<>();
    }
    
    public void agregarContacto(Contacto contacto, Long numero) {
        if (!directorio.containsKey(numero)) {
            directorio.put(numero, contacto);
        } else {
            System.out.println("El teléfono ya existe en el directorio.");
        }
    }
    
    // dado un número devuelve el Contacto asociado a ese número
    public Contacto buscarContacto(Long numero) {

        if (directorio.containsKey(numero)) {
            return directorio.get(numero);
        } else {
            System.out.println("El número no existe en el directorio.");
        }
        return null;
    }
    
    // dado un apellido devuelve un Set con los números asociados a ese apellido
    public TreeSet<Long> buscarTelefono(String apellido) {
        TreeSet<Long> nrosEncontrados = new TreeSet<>();
        
        for (Map.Entry<Long, Contacto> entry : directorio.entrySet()) {
            if (entry.getValue().getApellido().equals(apellido)) {
                nrosEncontrados.add(entry.getKey());
            }
        }
        return nrosEncontrados;
    }
    
    // dada una ciudad devuelve un ArrayList con los contactos asociados a esa ciudad
    public ArrayList<Contacto> buscarContactos(String ciudad) {
        ArrayList<Contacto> contactosEcontrados = new ArrayList<>();
        
        for (Map.Entry<Long, Contacto> entry : directorio.entrySet()) {
            if (entry.getValue().getCiudad().equals(ciudad)) {
                contactosEcontrados.add(entry.getValue());
            }
        }
        
        return contactosEcontrados;
    }
    
    //dado un numero elimina el contacto del directorio
    public void borrarContacto(Long numero) {
        Iterator<Map.Entry<Long, Contacto>> it = directorio.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry<Long, Contacto> entry = it.next();
            if (entry.getKey().equals(numero)) {
                it.remove();
                break;
            }
        }
    }
    
    public void listarContactos() {
        for (Map.Entry<Long, Contacto> entry : directorio.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getApellido() + " " + entry.getValue().getNombre() + "\n");
        }
    }
}
