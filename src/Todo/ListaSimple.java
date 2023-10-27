package Todo;


import java.util.Comparator;
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karoe
 * @param <T>
 */
public class ListaSimple<T> {
    private Nodo inicio;
    
    public ListaSimple()
    {
        inicio=null;
    }

    public Nodo getInicio() {
        return inicio;
    }
    
    
    public void insertaInicio(T dato)
    {
        Nodo n = new Nodo();
        n.setInfo(dato);
        n.setSig(inicio);
        inicio = n;
    }
    
    public void insertaFin(T dato)
    {
        Nodo n = new Nodo();
        n.setInfo(dato);
        if(inicio==null) inicio=n;
        else
        {
            Nodo r = inicio;
            while(r.getSig()!=null) r=r.getSig();
            r.setSig(n);
            n.setSig(null);
        }
    }
        
    public T eliminaInicio()
    {
        Nodo n;
        if(inicio==null)
        {
            System.out.println("Lista Vacia");
            return null;
        }
        else
        {
            n = inicio;
            inicio = inicio.getSig();
            return (T) n.getInfo();
        }
    }
    
    public T eliminaFin()
    {
    
        Nodo n = new Nodo();
        if(inicio==null)
        {
            System.out.println("Lista Vacia");
            return null;
        }
        else if(inicio.getSig()==null)
        {
            n = inicio;
            inicio = null;
            return (T) n.getInfo();
        }
        else
        {
            Nodo r = inicio;
            Nodo a = r;
            while(r.getSig()!=null)
            {
                a=r;
                r=r.getSig();
            }
            a.setSig(null);
            return (T) r.getInfo();
        }
    }
            
    /**
     *metodo para mostrar los elementos de la lista
     * @return
     */
    public String mostrarLista()
    {
        String cadena="";
        Nodo r = inicio;
        while(r!=null)
        {
        cadena += r + "\n";
        r=r.getSig();
        }
        return cadena;
    }
    
    public int longitudDeDato()
    {
        int i =0;
        Nodo r = inicio;
        while(r!=null)
        {
            i++;
            r=r.getSig();
        }
        return i;
    }
    
    public void mostrarDatosAlRevez()
    {
        Stack<T> valores = new Stack();
        Nodo r = inicio;
        while(r!=null)
        {
            valores.push((T) r.getInfo());
            r=r.getSig();
        }
        
        while(!valores.empty())
        {
            System.out.println(valores.pop());
        }
    }
    
    private void mostrarDatosR(Nodo r)
    {
        if(r.getSig()==null) System.out.println(r.getInfo());
        else
        {
            System.out.println(r.getInfo());
            r=r.getSig();
            mostrarDatosR(r);
        }
    }
    
    public void UsarMostrarDatosR()//1
    {
        Nodo r = inicio;
        mostrarDatosR(r);
    }
    private void mostrarDatosAlRevezR(Nodo r,Stack<T> valores)
    {
        if(r==null)
        {
            while(!valores.empty())
            {
                System.out.println(valores.pop());
            }
        }
        else
        {
            valores.push((T) r.getInfo());
            r=r.getSig();
            mostrarDatosAlRevezR(r,valores);
        }
    }
    
    public void UsarMostrarDatosAlRevezR()
    {
        Nodo r = inicio;
        Stack<T> valores = new Stack<>();
        mostrarDatosAlRevezR(r,valores);
    }
    
    //metodos para examen
     public void eliminarPosicionesPares()//2
    {
       Nodo r = inicio;
       Nodo a;
       while(r!=null)
       {
           a=r.getSig();
           if(a==null) r.setSig(null);
           else r.setSig(a.getSig());
           r=r.getSig();
       }    
    }
     
    public T eliminaX(T x)//3
    {
        Nodo r = inicio;
        Nodo a;
        if(inicio.getInfo()==x)
        {
            inicio=inicio.getSig();
            return (T) r.getInfo();
        }
        else
        {
            while(r.getSig()!=null)
            {
                a=r.getSig();
                if(a.getInfo()==x)
                {
                    r.setSig(a.getSig());
                    return (T) a.getInfo();
                }
                r=a;
            }
            return null;
        }
    }
    
    public void ordenar(Comparator<T> comp)//4
    {
        T datoAux;
        Nodo r = inicio;
        Nodo a = inicio.getSig();
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
     
    public int buscar(T x)//5
    {
        int i=1;
        Nodo r = inicio;
        while(r!=null)
        {
            if(r.getInfo()==x)return i;
            r=r.getSig();
            i++;
        }   
        return -1;//-1 si no se encontro
    }
    
    public T buscarPos(int pos)
    {
        int i=1;
        Nodo r = inicio;
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
    
    public T eliminarPosicion(int posicion)//6
    {
        T Dato;
        int i=1;
        Nodo r = inicio;
        Nodo a = null;
        while(r!=null)
        {
            if(i==posicion)
            {
                Dato = (T) r.getInfo();
                if(r==inicio)inicio = r.getSig();
                else
                {
                a.setSig(r.getSig());
                }
                return Dato;
            }
        a = r;
        r = r.getSig();
        i++;
        }
        return null;
    }
     
    public void insertaPosicion(int posicion,T dato)//7
    {
        Nodo n = new Nodo();
        n.setInfo(dato);
        int i = 1;
        Nodo r = inicio;
        Nodo a = r;// nunca se usa esta asignacion
        while(r!=null)
        {
            if(i==posicion)
            {
                if(r==inicio)
                {
                    n.setSig(r);
                    inicio = n;
                }
                else
                {
                    n.setSig(r);
                    a.setSig(n);
                    
                }
                return;    
            }
         a = r;   
         r = r.getSig();
         i++;
        }
    }
    
    
    public void vaciarLista()
    {
        inicio=null;
    }
    
    public int longitud()
    {
        int i=0;
        Nodo r = inicio;
        while(r!=null)
        {
            i++;
            r=r.getSig();
        }
        return i;
    }
}
