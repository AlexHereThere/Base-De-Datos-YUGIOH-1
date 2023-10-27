/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Todo;

/**
 *clase para modelar los nodos de una lista doble
 * @author ACR 
 * @param <T> 
 */
public class NodoDoble<T>{
    private NodoDoble sig,ant;
    private T info;
    
    public NodoDoble()
    {
        this.ant=null;
        this.sig=null;
        this.info=null;
    }

    public NodoDoble getSig() {
        return sig;
    }

    public void setSig(NodoDoble sig) {
        this.sig = sig;
    }

    public NodoDoble getAnt() {
        return ant;
    }

    public void setAnt(NodoDoble ant) {
        this.ant = ant;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    
    @Override
    public String toString()
    {
    return info.toString();
    }
    
}
