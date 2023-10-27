/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Todo;
import java.io.*;
import java.util.Comparator;
/**
 *clase para modelar la base de datos de cartas YUGIOH
 * @author ACR
 */
public class BaseDeDatosCartas{

ListaSimple<CartaYUGIOH> todasCartas;
    //constructor
    public BaseDeDatosCartas(File csv,File texto,File nombre) throws FileNotFoundException, IOException {
        todasCartas = new ListaSimple();

        FileReader file = new FileReader(csv);
        FileReader infoFile = new FileReader(texto);
        FileReader nameFile = new FileReader(nombre);
        
        BufferedReader fileString  = new BufferedReader(file);
        BufferedReader infoFileString = new BufferedReader(infoFile);//descripcion de carta
        BufferedReader infoNameString = new BufferedReader(nameFile);//nombres
        
        String line = fileString.readLine();//leer descripcion de valores
        String infoLine = infoFileString.readLine();
        String nameLine = infoNameString.readLine();
        
        line = fileString.readLine();//leer primer dato
        infoLine = infoFileString.readLine();
        nameLine = infoNameString.readLine();
        
        String[] datos;//contener los datos divididos
        while(line!=null)
        {
            datos = line.split(",");
            CartaYUGIOH carta = new CartaYUGIOH(nameLine,datos[1],datos[2],
                    Integer.parseInt(datos[3]),
                    Integer.parseInt(datos[4]),
                    Integer.parseInt(datos[5]),datos[6],infoLine);
            todasCartas.insertaInicio(carta);
            
            
            line = fileString.readLine(); //guardar siguiente
            infoLine = infoFileString.readLine();
            nameLine = infoNameString.readLine();
        }
    }


    //getters
    public ListaSimple<CartaYUGIOH> getTodasCartas() {
        return todasCartas;
    }
    
    //setters
    public void setTodasCartas(ListaSimple<CartaYUGIOH> todasCartas) {
        this.todasCartas = todasCartas;
    }
    
    /**
     * metodo para regresar una lista con todas las cartas
     * @return 
     */
    public ListaSimple hacerListaParaTodo()
    {
         ListaSimple unasCartas = new ListaSimple();
         Nodo r = todasCartas.getInicio();
        while(r!=null)
        {
            CartaYUGIOH carta = (CartaYUGIOH) r.getInfo(); 
                unasCartas.insertaInicio(carta);
            r=r.getSig();
        }
        return unasCartas;
    }
   
    /**
     * metodo para regresar una lista con las cartas de un atributo dado
     * @param atributo
     * @return 
     */
    public ListaSimple hacerListaPorAtributo(String atributo)
    {
        ListaSimple unasCartas = new ListaSimple();
        Nodo r = todasCartas.getInicio();
        while(r!=null)
        {
            CartaYUGIOH carta = (CartaYUGIOH) r.getInfo();
            if(carta.getAtributo().contains(atributo)) 
                unasCartas.insertaInicio(carta);
            r=r.getSig();
        }
        return unasCartas;
    }
    
    /**
     * metodo para regresar una lista con las cartas de un nivel dado
     * @param nivel
     * @return 
     */
    public ListaSimple hacerListaPorNivel(int nivel)
    {
        ListaSimple unasCartas = new ListaSimple();
        Nodo r = todasCartas.getInicio();
        while(r!=null)
        {
            CartaYUGIOH carta = (CartaYUGIOH) r.getInfo();
            if(carta.getNivel()==nivel) 
                unasCartas.insertaInicio(carta);
            r=r.getSig();
        }
        return unasCartas;
    }
    
    /**
     * metodo para ordenar de menor a mayor por ataque
     * @return 
     */
    public ListaSimple ordenarDeMenorAMayorPorAtaque()
    {
        Comparator<CartaYUGIOH> comp = (CartaYUGIOH o1, CartaYUGIOH o2) -> 
                o1.getAtaque() - o2.getAtaque();
        ListaSimple unasCartas = hacerListaParaTodo();
        unasCartas.ordenar(comp);
        return unasCartas;
    }
    
    /**
     * metodo para ordenar de mayor a menor por ataque
     * @return 
     */
    public ListaSimple ordenarDeMayorAMenorPorAtaque()
    {
        Comparator<CartaYUGIOH> comp = (CartaYUGIOH o1, CartaYUGIOH o2) -> 
                o2.getAtaque() - o1.getAtaque();
        ListaSimple unasCartas = hacerListaParaTodo();
        unasCartas.ordenar(comp);
        return unasCartas;
    }
     
    /**
     * metodo para ordenar de menor a mayor por defensa
     * @return 
     */
    public ListaSimple ordenarDeMenorAMayorPorDefensa()
    {
        Comparator<CartaYUGIOH> comp = (CartaYUGIOH o1, CartaYUGIOH o2) -> 
                o1.getDefensa() - o2.getDefensa();
        ListaSimple unasCartas = hacerListaParaTodo();
        unasCartas.ordenar(comp);
        return unasCartas;
    }
    
    /**
     * metodo para ordenar de mayor de menor por defensa
     * @return 
     */
     public ListaSimple ordenarDeMayorAMenorPorDefensa()
    {
        Comparator<CartaYUGIOH> comp = (CartaYUGIOH o1, CartaYUGIOH o2) -> 
                o2.getDefensa() - o1.getDefensa();
        ListaSimple unasCartas = hacerListaParaTodo();
        unasCartas.ordenar(comp);
        return unasCartas;
    }
    
  
}
    
   
   
            
