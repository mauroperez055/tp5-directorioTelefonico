
package Clases;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class DirectorioTelefonico {
    private TreeMap<Long, Contacto> directorio;

    public DirectorioTelefonico() {
        this.directorio = new TreeMap<>();
    }
    
    public void agregarContacto(Contacto contacto, Long numero) {
        directorio.put(numero, contacto);
    }
    
    public Contacto buscarContacto(Long numero) {
        Contacto contactoEncontrado = null;
        
        for (Map.Entry<Long, Contacto> entry : directorio.entrySet()) {
            if (entry.getKey() == numero) {
                contactoEncontrado = entry.getValue();
            }
        }
        return contactoEncontrado;
    }
    
    public void buscarTelefono(String apellido) {
        
    }
}
