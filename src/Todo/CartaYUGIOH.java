/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Todo;

import javax.swing.ImageIcon;

/**
 *clase para modelar las cartas YUGIOH
 * @author ACR
 */
public class CartaYUGIOH {
    private String nombre,info,tipo,atributo,atributoH;
    private int ataque,defensa,nivel;
    private ImageIcon imagen;

    //constructor
    public CartaYUGIOH(String nombre, String atributo, String tipo, int nivel, 
            int ataque, int defensa, String atributoH, String info) {
        this.nombre = nombre;
        this.info = info;
        this.tipo = tipo;
        this.atributo = atributo;
        this.atributoH = atributoH;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        asignarImagen();
    }

    //getters
    public String getNombre() {
        return nombre;
    }
    public String getInfo() {
        return info;
    }
    public String getTipo() {
        return tipo;
    }
    public String getAtributo() {
        return atributo;
    }
    public String getAtributoH() {
        return atributoH;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getNivel() {
        return nivel;
    }
    public ImageIcon getImage()
    {
        return imagen;
    }
    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setAtributo(String atrubuto) {
        this.atributo = atrubuto;
    }
    public void setAtributoH(String atributoH) {
        this.atributoH = atributoH;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    /**
     * metodo para asignar la imagen a dicha carta.
     */
    private void asignarImagen()
    {
       String tNombre = this.nombre;
       tNombre=tNombre.replace('/', '$');
       tNombre=tNombre.replace('"', '#');
       tNombre=tNombre.replace(':', '%');//condicionar para detectar las imagenes.
        System.out.println(tNombre);
        imagen = new ImageIcon(getClass().getResource("/resources/Imágenes/"+tNombre+".jpg"));
    }
                
    @Override
    public String toString()
    {
    return nombre +";"+ atributo +";"+ tipo +";"+ nivel
            +";"+ ataque +";"+ defensa +";"+ atributoH +";"+ info +"\n";   
    }
}
