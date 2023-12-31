/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Todo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;

/**
 *
 * @author karoe
 */
public class GraficaUIPrincipal extends javax.swing.JFrame {
    AudioInputStream audioStream;
    Clip audio;
    BaseDeDatosCartas misCartas;
    ListaSimple unasCartas;
    int numCartaActual;
    int numCartas;
    /**
     * Creates new form GraficaUI
     * @throws java.io.IOException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public GraficaUIPrincipal() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File csv = new File("C:\\Users\\karoe\\Desktop\\Alejandro Castro Renteria\\Cosas Uni\\"
                + "Trabajos Uni\\Semestre 5\\Algoritmos y Estructura de Datos\\Reportes y Practicas\\"
                + "Practica 4\\BaseDeDatosYUGIOH\\src\\resources\\DataGood.csv");//datos generales
        File info = new File("C:\\Users\\karoe\\Desktop\\Alejandro Castro Renteria\\Cosas Uni\\"
                + "Trabajos Uni\\Semestre 5\\Algoritmos y Estructura de Datos\\Reportes y Practicas\\"
                + "Practica 4\\BaseDeDatosYUGIOH\\src\\resources\\DataInfo.txt");//descripciones
        File name = new File("C:\\Users\\karoe\\Desktop\\Alejandro Castro Renteria\\Cosas Uni\\"
                + "Trabajos Uni\\Semestre 5\\Algoritmos y Estructura de Datos\\Reportes y Practicas\\"
                + "Practica 4\\BaseDeDatosYUGIOH\\src\\resources\\nombres.txt");//nobres
        misCartas = new BaseDeDatosCartas(csv,info,name);
        audioStream = AudioSystem.getAudioInputStream(
                getClass().getResource("/resources/01 Scape Main.wav"));
        audio = AudioSystem.getClip();
        audio.open(audioStream);
        audio.start();
        audio.loop(Clip.LOOP_CONTINUOUSLY);
        initComponents();
        scalaImagen(fondoPrincipal);
    }

     /**
     * metodo para escalar la imagen al tamano del label
     * @param label 
     */
    public static void scalaImagen(javax.swing.JLabel label)
    {
        if(label.getIcon()==null) return; //no hacer nada si no hay imagen
        javax.swing.Icon i = label.getIcon();
        ImageIcon icon = (ImageIcon) i;
        java.awt.Image image = icon.getImage().getScaledInstance(label.getWidth(), 
             label.getHeight(), java.awt.Image.SCALE_SMOOTH);
        label.setIcon(new javax.swing.ImageIcon(image));
    }
    
    /**
     * metodo para poder graficar la siguiente carta
     * @param carta 
     */
    public void asignarEspacioACarta(CartaYUGIOH carta)
    {
        nombre.setText(carta.getNombre());
        info.setText(carta.getInfo());
        nivel.setText(""+carta.getNivel());
        defensa.setText("DEF/"+carta.getDefensa());
        ataque.setText("ATK/"+carta.getAtaque());
        tipo.setText(carta.getTipo());
        cartaG.setIcon(carta.getImage());
        scalaImagen(cartaG);
        asignarIconAtributo(carta);
    }
    
    /**
     * para determinar cual imagen de atributo tendra la carta al graficar
     * @param carta 
     */
    public void asignarIconAtributo(CartaYUGIOH carta)
    {
       atributo.setText("");
       atributo.setIcon(new ImageIcon(
               getClass().getResource("/resources/Atributos/"
                       +carta.getAtributo()+".png")));
       scalaImagen(atributo);
    }
    
    /**
     * metodo para actualizar los valores del contador cuando se avanza
     */
    public void modificarContador()
    {
    contador.setText(numCartaActual+"/"+numCartas);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorCartas = new javax.swing.JFrame();
        siguientes = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        cInfo = new javax.swing.JPanel();
        cartaG = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        atributo = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        ataque = new javax.swing.JLabel();
        defensa = new javax.swing.JLabel();
        info = new javax.swing.JTextArea();
        Espacio3 = new javax.swing.JPanel();
        contador = new javax.swing.JLabel();
        fondoCartas = new javax.swing.JLabel();
        Espacio1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        Espacio2 = new javax.swing.JPanel();
        OrdenBR = new javax.swing.JRadioButton();
        mostrarTodoB = new javax.swing.JButton();
        mostrarAtributoB = new javax.swing.JButton();
        atributoSelector = new javax.swing.JComboBox<>();
        mostrarNivelB = new javax.swing.JButton();
        nivelSelector = new javax.swing.JComboBox<>();
        mostrarPorAtaque = new javax.swing.JButton();
        mostrarPorDefensa = new javax.swing.JButton();
        audioB = new javax.swing.JButton();
        fondoPrincipal = new javax.swing.JLabel();

        contenedorCartas.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        contenedorCartas.setMinimumSize(new java.awt.Dimension(770, 400));
        contenedorCartas.setResizable(false);
        contenedorCartas.setSize(new java.awt.Dimension(780, 400));
        contenedorCartas.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        siguientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        siguientes.setText("-------->");
        siguientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguientesActionPerformed(evt);
            }
        });
        contenedorCartas.getContentPane().add(siguientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 177, -1));

        salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        contenedorCartas.getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 177, -1));
        salir.getAccessibleContext().setAccessibleDescription("");

        cInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cartaG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Imágenes/Alba-Lenatus the Abyss Dragon.jpg"))); // NOI18N
        cartaG.setText("<carta>");
        cartaG.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nombre.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("<Nombre>");

        atributo.setText("<Atributo>");

        tipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo.setText("<Tipo>");

        nivel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/nivel.png"))); // NOI18N
        nivel.setText("<Nivel>");
        nivel.setIconTextGap(8);
        nivel.setVerifyInputWhenFocusTarget(false);

        ataque.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ataque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ataque.setText("<Ataque>");

        defensa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        defensa.setText("<Defensa>");

        info.setEditable(false);
        info.setColumns(20);
        info.setLineWrap(true);
        info.setRows(5);

        javax.swing.GroupLayout cInfoLayout = new javax.swing.GroupLayout(cInfo);
        cInfo.setLayout(cInfoLayout);
        cInfoLayout.setHorizontalGroup(
            cInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartaG, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cInfoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(atributo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(ataque)
                        .addGap(50, 50, 50)
                        .addComponent(defensa))
                    .addGroup(cInfoLayout.createSequentialGroup()
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cInfoLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(info)
                .addContainerGap())
        );
        cInfoLayout.setVerticalGroup(
            cInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cInfoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(cInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atributo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(defensa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ataque, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(cInfoLayout.createSequentialGroup()
                        .addComponent(cartaG, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        contenedorCartas.getContentPane().add(cInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 290));

        Espacio3.setBackground(new java.awt.Color(255, 255, 255));

        contador.setBackground(new java.awt.Color(255, 255, 255));
        contador.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        contador.setForeground(new java.awt.Color(51, 51, 51));
        contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contador.setText("5/52");

        javax.swing.GroupLayout Espacio3Layout = new javax.swing.GroupLayout(Espacio3);
        Espacio3.setLayout(Espacio3Layout);
        Espacio3Layout.setHorizontalGroup(
            Espacio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Espacio3Layout.createSequentialGroup()
                .addComponent(contador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Espacio3Layout.setVerticalGroup(
            Espacio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Espacio3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(contador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contenedorCartas.getContentPane().add(Espacio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 150, 40));

        fondoCartas.setText("<Fondo>");
        fondoCartas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fondoCartas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedorCartas.getContentPane().add(fondoCartas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 360));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(0, 0, 0));
        titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Mis Cartas YU-GI-OH!");

        javax.swing.GroupLayout Espacio1Layout = new javax.swing.GroupLayout(Espacio1);
        Espacio1.setLayout(Espacio1Layout);
        Espacio1Layout.setHorizontalGroup(
            Espacio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Espacio1Layout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        Espacio1Layout.setVerticalGroup(
            Espacio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Espacio1Layout.createSequentialGroup()
                .addComponent(titulo)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(Espacio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, 30));

        OrdenBR.setForeground(new java.awt.Color(0, 0, 0));
        OrdenBR.setText("De MAYOR a MENOR");
        OrdenBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenBRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Espacio2Layout = new javax.swing.GroupLayout(Espacio2);
        Espacio2.setLayout(Espacio2Layout);
        Espacio2Layout.setHorizontalGroup(
            Espacio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Espacio2Layout.createSequentialGroup()
                .addComponent(OrdenBR)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        Espacio2Layout.setVerticalGroup(
            Espacio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Espacio2Layout.createSequentialGroup()
                .addComponent(OrdenBR)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(Espacio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 150, 20));

        mostrarTodoB.setText("Mostrar TODAS!");
        mostrarTodoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTodoBActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarTodoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        mostrarAtributoB.setText("Mostrar POR ATRIBUTO!");
        mostrarAtributoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAtributoBActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarAtributoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        atributoSelector.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        atributoSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DARK", "EARTH", "FIRE", "LIGHT", "SPELL", "TRAP", "WATER", "WIND" }));
        atributoSelector.setToolTipText("");
        atributoSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atributoSelectorActionPerformed(evt);
            }
        });
        getContentPane().add(atributoSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 87, 45));

        mostrarNivelB.setText("Mostrar POR NIVEL!");
        mostrarNivelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarNivelBActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarNivelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        nivelSelector.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nivelSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        getContentPane().add(nivelSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 87, 45));

        mostrarPorAtaque.setText("Mostrar POR PUNTOS DE ATAQUE!");
        mostrarPorAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPorAtaqueActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarPorAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 230, -1));

        mostrarPorDefensa.setText("Mostrar POR PUNTOS DE DEFENSA!");
        mostrarPorDefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPorDefensaActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarPorDefensa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 230, -1));

        audioB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/AudioOn.png"))); // NOI18N
        audioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audioBActionPerformed(evt);
            }
        });
        getContentPane().add(audioB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 50, 50));

        fondoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/FondoTematico.png"))); // NOI18N
        fondoPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(fondoPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 290, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarTodoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTodoBActionPerformed
        contenedorCartas.setVisible(true);
       
        unasCartas = misCartas.hacerListaParaTodo();
        
        numCartaActual=1;
        numCartas=unasCartas.longitud();
        modificarContador();
        
        asignarEspacioACarta((CartaYUGIOH) unasCartas.eliminaInicio());
       
     
        fondoCartas.setIcon(new ImageIcon(getClass().getResource("/resources/FondoTodos.jpg")));
        scalaImagen(fondoCartas);
    }//GEN-LAST:event_mostrarTodoBActionPerformed

    private void mostrarAtributoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAtributoBActionPerformed
        contenedorCartas.setVisible(true);
       
        unasCartas = misCartas.hacerListaPorAtributo(
                atributoSelector.getSelectedItem().toString());
        
        numCartaActual=1;
        numCartas=unasCartas.longitud();
        modificarContador();
        
        asignarEspacioACarta((CartaYUGIOH) unasCartas.eliminaInicio());
        
        fondoCartas.setIcon(new ImageIcon(getClass().getResource("/resources/"+
                atributoSelector.getSelectedItem().toString()+".jpg")));
        scalaImagen(fondoCartas);
    }//GEN-LAST:event_mostrarAtributoBActionPerformed

    private void mostrarNivelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarNivelBActionPerformed
       contenedorCartas.setVisible(true);
       
        unasCartas = misCartas.hacerListaPorNivel( 
                Integer.parseInt(nivelSelector.getSelectedItem().toString()));
   
        numCartaActual=1;
        numCartas=unasCartas.longitud();
        modificarContador();
        
        asignarEspacioACarta((CartaYUGIOH) unasCartas.eliminaInicio());
        
        fondoCartas.setIcon(new ImageIcon(getClass().getResource("/resources/FondoNivel.jpg")));
        scalaImagen(fondoCartas);
    }//GEN-LAST:event_mostrarNivelBActionPerformed

    private void mostrarPorAtaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarPorAtaqueActionPerformed
        contenedorCartas.setVisible(true);
        
        if(OrdenBR.isSelected())unasCartas = misCartas.ordenarDeMayorAMenorPorAtaque();
        else unasCartas = misCartas.ordenarDeMenorAMayorPorAtaque();
        
        numCartaActual=1;
        numCartas=unasCartas.longitud();
        modificarContador();
        
        asignarEspacioACarta((CartaYUGIOH) unasCartas.eliminaInicio());
        fondoCartas.setIcon(new ImageIcon(getClass().getResource("/resources/FondoAtaque.jpg")));
        scalaImagen(fondoCartas);
    }//GEN-LAST:event_mostrarPorAtaqueActionPerformed

    private void mostrarPorDefensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarPorDefensaActionPerformed
      contenedorCartas.setVisible(true);
        
        if(OrdenBR.isSelected())unasCartas = misCartas.ordenarDeMayorAMenorPorDefensa();
        else unasCartas = misCartas.ordenarDeMenorAMayorPorDefensa();
        
        numCartaActual=1;
        numCartas=unasCartas.longitud();
        modificarContador();
        
        asignarEspacioACarta((CartaYUGIOH) unasCartas.eliminaInicio());
        fondoCartas.setIcon(new ImageIcon(getClass().getResource("/resources/FondoEscudo.jpg")));
        scalaImagen(fondoCartas);
    }//GEN-LAST:event_mostrarPorDefensaActionPerformed

    private void OrdenBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenBRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrdenBRActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
       contenedorCartas.setVisible(false);
    }//GEN-LAST:event_salirActionPerformed

    private void siguientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguientesActionPerformed
        if(unasCartas.longitud()!=0)
        {
        asignarEspacioACarta((CartaYUGIOH) unasCartas.eliminaInicio());
        numCartaActual++;
        modificarContador();
        }
    }//GEN-LAST:event_siguientesActionPerformed

    private void atributoSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atributoSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atributoSelectorActionPerformed

    private void audioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audioBActionPerformed
        if(audio.isRunning())
        {
           audioB.setIcon(new ImageIcon(getClass().getResource(
                   "/resources/AudioOff.png")));
            audio.stop();
        }
        else
        {
            audioB.setIcon(new ImageIcon(getClass().getResource(
                   "/resources/AudioOn.png")));
            audio.setFramePosition(0);
            audio.start();
            audio.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }//GEN-LAST:event_audioBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraficaUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        try {
                            new GraficaUIPrincipal().setVisible(true);
                        } catch (LineUnavailableException ex) {
                            Logger.getLogger(GraficaUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(GraficaUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(GraficaUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Espacio1;
    private javax.swing.JPanel Espacio2;
    private javax.swing.JPanel Espacio3;
    private javax.swing.JRadioButton OrdenBR;
    private javax.swing.JLabel ataque;
    private javax.swing.JLabel atributo;
    private javax.swing.JComboBox<String> atributoSelector;
    private javax.swing.JButton audioB;
    private javax.swing.JPanel cInfo;
    private javax.swing.JLabel cartaG;
    private javax.swing.JLabel contador;
    private javax.swing.JFrame contenedorCartas;
    private javax.swing.JLabel defensa;
    private javax.swing.JLabel fondoCartas;
    private javax.swing.JLabel fondoPrincipal;
    private javax.swing.JTextArea info;
    private javax.swing.JButton mostrarAtributoB;
    private javax.swing.JButton mostrarNivelB;
    private javax.swing.JButton mostrarPorAtaque;
    private javax.swing.JButton mostrarPorDefensa;
    private javax.swing.JButton mostrarTodoB;
    private javax.swing.JLabel nivel;
    private javax.swing.JComboBox<String> nivelSelector;
    private javax.swing.JLabel nombre;
    private javax.swing.JButton salir;
    private javax.swing.JButton siguientes;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
