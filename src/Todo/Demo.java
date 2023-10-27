/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Todo;

import java.io.File;
import java.io.IOException;

/**
 *clase para probar cosas
 * @author ACR
 */
public class Demo {
    public static void main(String[] a) throws IOException
    {
        File csv = new File("C:\\Users\\karoe\\Desktop\\Alejandro Castro Renteria\\Cosas Uni\\"
                + "Trabajos Uni\\Semestre 5\\Algoritmos y Estructura de Datos\\Reportes y Practicas\\"
                + "Practica 4\\BaseDeDatosYUGIOH\\src\\resources\\DataGood.csv");
        File info = new File("C:\\Users\\karoe\\Desktop\\Alejandro Castro Renteria\\Cosas Uni\\"
                + "Trabajos Uni\\Semestre 5\\Algoritmos y Estructura de Datos\\Reportes y Practicas\\"
                + "Practica 4\\BaseDeDatosYUGIOH\\src\\resources\\DataInfo.txt");
        File name = new File("C:\\Users\\karoe\\Desktop\\Alejandro Castro Renteria\\Cosas Uni\\"
                + "Trabajos Uni\\Semestre 5\\Algoritmos y Estructura de Datos\\Reportes y Practicas\\"
                + "Practica 4\\BaseDeDatosYUGIOH\\src\\resources\\nombres.txt");
        BaseDeDatosCartas misCartas = new BaseDeDatosCartas(csv,info,name);
       
        misCartas.ordenarDeMayorAMenorPorAtaque();
        ListaSimple unasCartas = misCartas.ordenarDeMayorAMenorPorDefensa();
        unasCartas.UsarMostrarDatosR();
    }
}
