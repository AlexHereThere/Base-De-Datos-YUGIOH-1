/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Todo;

import java.util.Comparator;
import java.util.Stack;

/**
 *clase para modelar la lista doble
 * @author ACR
 * @param <T>
 */
public class ListaDoble<T>{
    private NodoDoble inicio;

    public NodoDoble getInicio() {
        return inicio;
    }
    
    public ListaDoble()
    {
        this.inicio = null;
    }
    
    
    public void insertarInicio(T dato)
    {
        NodoDoble n = new NodoDoble();
        n.setInfo(dato);
        n.setSig(inicio);
        n.setAnt(null);
        if(inicio!= null) inicio.setAnt(n);
        inicio = n;
    }
    
    public void insertarFin(T dato)
    {
        NodoDoble n = new NodoDoble();
        n.setInfo(dato);
        n.setSig(null);
        if(inicio==null)
        {
            n.setAnt(inicio);
            inicio = n;
        }
        else
        {
            NodoDoble r = inicio;
            while(r.getSig()!=null)r = r.getSig();
            r.setSig(n);
            n.setAnt(r);
        }
    }
    
    public T eliminaInicio()
    {
        T dato;
        if(inicio==null)
        {
            System.out.println("esta vacio!");
            return null;
        }
        else if(inicio.getSig()==null) 
            {
                dato = (T) inicio.getInfo();
                inicio = null;
                return dato;
            }
            else
            {
                dato = (T) inicio.getInfo();
                inicio = inicio.getSig();
                inicio.setAnt(null);
                return dato;
            }
    }
    
    public T eliminaFin()
    {
        T dato;
        if(inicio==null)
        {
            System.out.println("esta vacio!");
            return null;
        }
        else if(inicio.getSig()==null) 
            {
                dato = (T) inicio.getInfo();
                inicio = null;
                return dato;
            }
            else
            {
                NodoDoble r = inicio;
                while(r.getSig()!=null)r = r.getSig();
                dato = (T) r.getInfo();
                r.getAnt().setSig(null);
                return dato;
            }
    }
    
    public String recorrerDatos()
    {
        String cadena = "";
        NodoDoble r = inicio;
        while(r!=null)
        {
            cadena += r.toString() + "\n";
            r = r.getSig();
        }
        return cadena;
    }
    //otros metodos --------------
    private void mostrarAlRevezDatosR(Stack<T> valores,NodoDoble r)
    {
        if(r==null)while(!valores.empty())System.out.println(valores.pop());
        else
        {
            valores.push((T) r.getInfo());
            r = r.getSig();
            mostrarAlRevezDatosR(valores,r);
        }
    }
    
    public void usarMostrarAlRevezDatosR()
    {
        NodoDoble r = inicio;
        Stack<T> valores = new Stack<>();
        mostrarAlRevezDatosR(valores,r);
    }
    
    public void eliminarPosicionesPares()//2
    {
        NodoDoble a;
        NodoDoble r = inicio;
        for(int i=1;r!=null;i++)
        {
            a=r.getSig();
            if(i%2==0)
            {
                if(r.getSig()!=null)
                {
                    r.getSig().setAnt(r.getAnt());
                    r.getAnt().setSig(r.getSig());
                }
                else r.getAnt().setSig(null);
            }
            r=a;
        }
    }
    
    public T eliminarPosicion(int posicion)//6
    {
        T Dato;
        int i=1;
        NodoDoble r = inicio;
        while(r!=null)
        {
            if(i==posicion)
            {
                Dato = (T) r.getInfo();
                if(r==inicio)r.getSig().setAnt(null);
                else if(r.getSig()==null) r.getAnt().setSig(null);
                else
                {
                r.getSig().setAnt(r.getAnt());
                r.getAnt().setSig(r.getSig());
                }
                return Dato;
            }
        r = r.getSig();
        i++;
        }
        return null;
    }
    
    public void insertaPosicion(int posicion,T dato)//7
    {
        NodoDoble n = new NodoDoble();
        n.setInfo(dato);
        int i = 1;
        NodoDoble r = inicio;
        while(r!=null)
        {
            if(i==posicion)
            {
                if(r==inicio)
                {
                    r.setAnt(n);
                    n.setSig(r);
                    inicio = n;
                }
                else
                {
                    n.setAnt(r.getAnt());
                    n.setSig(r);
                    r.setAnt(n);
                    n.getAnt().setSig(n);
                }
            return;    
            }
         r = r.getSig();
         i++;
        }
    }
    
    public void ordenar(Comparator<T> comp)//4
    {
        T datoAux;
        NodoDoble r = inicio;
        NodoDoble a = inicio.getSig();
        while(r!=null)
        {
            a=r.getSig();
            while(a!=null)
            {
                if(comp.compare((T)r.getInfo(),(T)a.getInfo())>0)
                {
                    datoAux = (T) r.getInfo();
                    r.setInfo(a.getInfo());
                    a.setInfo(datoAux);
                }
            a=a.getSig();
            }
        r=r.getSig();
        }
    } 
       //otros para examen.
    private void mostrarDatosR(NodoDoble r)//1
    {
        if(r.getSig()==null) System.out.println(r.getInfo());
        else
        {
            System.out.println(r.getInfo());
            r=r.getSig();
            mostrarDatosR(r);
        }
    }
    public void UsarMostrarDatosR()
    {
        NodoDoble r = inicio;
        mostrarDatosR(r);
    } 
    
    public T elmiminaX(T x)//3
    {
        NodoDoble r = inicio;
        if(r.getInfo()==x) 
        {
           inicio=inicio.getSig();
           inicio.setAnt(null);
           return (T) r.getInfo();
        }
        else 
        {
            while(r!=null)
            {
                if(r.getInfo()==x)
                {
                r.getAnt().setSig(r.getSig());
                r.getSig().setAnt(r.getAnt());
                return (T) r.getInfo();
                }
            r=r.getSig();
            }
           return (T) null;
        }
    }    
        
    public int buscar(T x)//5
    {
        int i=1;
        NodoDoble r = inicio;
        while(r!=null)
        {
            if(r.getInfo()==x)return i;
            r=r.getSig();
            i++;
        }   
        return -1;//-1 si no se encontro
    }
        
    
     public void vaciarLista()
    {
        inicio=null;
    }
    
    public int longitud()
    {
        int i=0;
        NodoDoble r = inicio;
        while(r!=null)
        {
            i++;
            r=r.getSig();
        }
        return i;
    }
    
     public T buscarPos(int pos)
    {
        int i=1;
        NodoDoble r = inicio;
        while(r!=null)
        {
            if(i==pos)return (T) r.getInfo();
            else
            {
                i++;
                r=r.getSig();
            }
        }
        return null;
    }
}

