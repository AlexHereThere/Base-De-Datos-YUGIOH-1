package Todo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *clase que modela los nodos de la lista
 * @author ACR
 * @param <T>
 */
public class Nodo <T>{
    T info;
    Nodo sig;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    public Nodo()
    {
        this.info=null;
        this.sig=null;
    }
    
    @Override
    public String toString()
    {
        return info.toString();
    }
}
