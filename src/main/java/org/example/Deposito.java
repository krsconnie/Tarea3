package org.example;
import java.util.ArrayList;
/**
 * Clase Deposito de tipo generico para crear depositos
 * tanto de Producto y sus subclases
 * como de Moneda y sus subclases*/
public class Deposito<T>{
    private ArrayList<T> items;
    /**
     *Constructor para crear un Array
     *con los productos o monedas (simboliza
     *el stock de "x" producto o moneda
     */
    public Deposito(){
        items = new ArrayList<>();
    }
    /**
     * método getItem() no tiene parámetros,
     * se encarga de obtener un elemento
     *@return si el tamaño del Array es 0 devuelve null,
     * si no devuelve el elemento en la primera posición
     * despues de haberlo borrado de la posición
     *en la que estaba
     */

    public <T> T getItem(){

        if(items.size() == 0){
            return null;

        } else {
            T ret = (T) items.get(0);
            items.remove(0);
            return ret;
        }
    }

    /**
     * método addItem se encarga de agregar un elemento
     * @param item puede ser tanto un producto como moneda
     * que se agregue
     *retorna void si no hay elemento que agregar
     */

    public void addItem(T item){
        if(item == null){
            return;
        }
        items.add(item);
    }
}