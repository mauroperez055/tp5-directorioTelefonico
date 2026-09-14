
package Clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Directorio {
    private TreeMap<Long, Contacto> directorio;

    public Directorio() {
        this.directorio = new TreeMap<>();
    }
    
    // devuelvo un set solo con las claves del directorio que son los telefonos
    public TreeSet<Long> getTelefono(){
        return new TreeSet<Long>(directorio.keySet());
    }
    
    // devuelve una coleccion de objetos tipo Contacto
    public Collection<Contacto> getContacto() {
        return directorio.values();
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
    
    // busca los contactos de la ciudad dada y los devuelve a cada uno junto con sus datos
    public ArrayList<Map.Entry<Long, Contacto>> buscarContactos(String ciudad) {

        ArrayList<Map.Entry<Long, Contacto>> contactos = new ArrayList<>();

        for (Map.Entry<Long, Contacto> entry : directorio.entrySet()) {

            Contacto contacto = entry.getValue();

            if (contacto.getCiudad().equals(ciudad)) {
                contactos.add(entry);
            }
        }

        return contactos;
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
