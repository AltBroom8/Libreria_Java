package View;


import Controller.DBManager;
import Controller.Errores;
import Model.Libro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Random;
import static Controller.Errores.*;

/**
 *
 * @author Carlos Gowing
 */
public class Programa extends javax.swing.JFrame {
    public Programa() {
        setResizable(false);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        logout = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        altaButton = new javax.swing.JButton();
        modButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        autor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        genero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        anio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        firstButton = new javax.swing.JButton();
        antButton = new javax.swing.JButton();
        sigButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;
        centerX/=4;
        System.out.println(centerX + " " + centerY);
        setLocation(centerY, centerX);
        libros = DBManager.listaLibros();
        setTableModel(libros);
        setListModel(libros);
        jScrollPane1.setViewportView(jTable1);
        logout.setText("⛔");
        profile.setText("👤");
        jScrollPane2.setViewportView(jList1);

        altaButton.setText("Alta");
        modButton.setText("Mod");
        deleteButton.setText("Del");


        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Titulo");
        jLabel3.setText("Autor");
        jLabel4.setText("Genero");
        jLabel5.setText("Año");
        jLabel6.setText("Precio");
        sigButton.addActionListener(this::sigButtonActionPerformed);
        antButton.addActionListener(this::antButtonActionPerformed);
        firstButton.addActionListener(this::firstButtonActionPerformed);
        lastButton.addActionListener(this::lastButtonActionPerformed);
        altaButton.addActionListener(this::onClickAltaButton);
        deleteButton.addActionListener(this::onClickBajaButton);
        modButton.addActionListener(this::onClickModButton);
        profile.addActionListener(this::profileInfo);
        logout.addActionListener(this::onLogout);


        //Layouts y cosas

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(autor))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(genero))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(anio))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(precio)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Nuevo");

        firstButton.setText("⏮️");

        antButton.setText("◀️");



        sigButton.setText("▶️");

        lastButton.setText("⏭️");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(altaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(modButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(57, 57, 57)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(firstButton)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(antButton)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(sigButton)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(lastButton)))))

                                                                .addGap(0, 46, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(altaButton)
                                                        .addComponent(modButton)
                                                        .addComponent(deleteButton))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(firstButton)
                                                        .addComponent(antButton)
                                                        .addComponent(sigButton)
                                                        .addComponent(lastButton))
                                                .addGap(0, 11, Short.MAX_VALUE))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }
    private void sigButtonActionPerformed(java.awt.event.ActionEvent ev){
        if (jList1.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "La lista esta vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jList1.getSelectedIndex()==-1){
            jList1.setSelectedIndex(0);
            return;
        }
        int tam = jList1.getModel().getSize();
        if(jList1.getSelectedIndex()<=tam-2){
            System.out.println(jList1.getSelectedIndex());
            jList1.setSelectedIndex(jList1.getSelectedIndex()+1);
        }else{
            System.out.println(jList1.getSelectedIndex());
            jList1.setSelectedIndex(tam);
        }
    }
    private void antButtonActionPerformed(java.awt.event.ActionEvent ev){
        if (jList1.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "La lista esta vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jList1.getSelectedIndex()==-1){
            jList1.setSelectedIndex(0);
            return;
        }
        int tam = jList1.getModel().getSize();
        if(jList1.getSelectedIndex()>0){
            System.out.println(jList1.getSelectedIndex());
            jList1.setSelectedIndex(jList1.getSelectedIndex()-1);
        }else{
            System.out.println(jList1.getSelectedIndex());
            jList1.setSelectedIndex(0);
        }
    }
    private void firstButtonActionPerformed(java.awt.event.ActionEvent ev){
        if (jList1.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "La lista esta vacía", "Error", JOptionPane.ERROR_MESSAGE);

        }else{
            jList1.setSelectedIndex(0);
        }
    }
    private void lastButtonActionPerformed(java.awt.event.ActionEvent ev){
        if (jList1.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "La lista esta vacía", "Error", JOptionPane.ERROR_MESSAGE);

        }else{
            jList1.setSelectedIndex(jList1.getModel().getSize()-1);
        }
    }
    public void setTableModel(Libro[] lista){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Autor");
        modelo.addColumn("Año");
        modelo.addColumn("Género");
        modelo.addColumn("Precio");
        if (libros != null) {
            for (Libro libro : lista) {
                Object[] fila = {
                        libro.getID(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getAnioPublicacion(),
                        libro.getGenero(),
                        libro.getPrecio(),
                        libro.getEditorialID()
                };
                modelo.addRow(fila);
            }
        }
        jTable1.setModel(modelo);

    }
    public void setListModel(Libro[] list){
        // Crear un DefaultListModel
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        modeloLista.clear();
        if (libros != null) {
            for (Libro libro : list) {
                modeloLista.addElement(libro.getTitulo());
            }
        }
        jList1.setModel(modeloLista);
        jList1.repaint();
    }
    public void onClickAltaButton(java.awt.event.ActionEvent ev) {
        try {
            if (titulo.getText().equals("")) {
                throw new Errores(TITULO_VACIO);
            } else if (autor.getText().equals("")) {
                throw new Errores(AUTOR_VACIO);
            } else if (genero.getText().equals("")) {
                throw new Errores(GENERO_VACIO);
            } else if (anio.getText().equals("")) {
                throw new Errores(ANIO_VACIO);
            } else if (precio.getText().equals("")) {
                throw new Errores(PRECIO_VACIO);
            } else {
                try {
                    String tituloString = titulo.getText();
                    String autorString = autor.getText();
                    String generoString = genero.getText();
                    Double precioDouble = Double.parseDouble(precio.getText());
                    int anioInt = Integer.parseInt(anio.getText());
                    System.out.println("año es " + anioInt);
                    System.out.println("precio es " + precioDouble);
                    DBManager.insertLibro(libros[libros.length - 1].getID(), tituloString, autorString, anioInt, generoString, precioDouble);
                    int idUser = DBManager.getUserById(DBManager.actualUser);
                    DBManager.altaTransaccion(libros[libros.length - 1].getID()+1,idUser,"Alta");
                    libros = DBManager.listaLibros();
                    setTableModel(libros);
                    setListModel(libros);
                    jList1.repaint();
                    jScrollPane1.setViewportView(jTable1);
                    titulo.setText("");
                    autor.setText("");
                    genero.setText("");
                    anio.setText("");
                    precio.setText("");


                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduzca valores numericos validos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(Errores e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void onClickBajaButton(java.awt.event.ActionEvent ev){
        if(jList1.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null, "Elija un componente de la lista para borrarlo", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String nombre = jList1.getSelectedValue();
            int id = DBManager.findLibroByString(nombre);
            DBManager.borraLibro(id);
            int idUser = DBManager.getUserById(DBManager.actualUser);
            DBManager.altaTransaccion(libros[libros.length - 1].getID(),idUser,"Baja");
            libros = DBManager.listaLibros();
            setTableModel(libros);
            setListModel(libros);
            jList1.repaint();
            jScrollPane1.setViewportView(jTable1);

        }
    }
    public void onClickModButton(java.awt.event.ActionEvent ev){
        if(isModEnabled==false){
            if(jList1.getSelectedIndex()==-1){
                JOptionPane.showMessageDialog(null, "Elija un componente de la lista para modificarlo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            altaButton.setEnabled(false);
            deleteButton.setEnabled(false);
            logout.setEnabled(false);
            profile.setEnabled(false);
            firstButton.setEnabled(false);
            antButton.setEnabled(false);
            sigButton.setEnabled(false);
            lastButton.setEnabled(false);
            tempID=jList1.getSelectedIndex();
            jList1.setEnabled(false);
            isModEnabled=true;
            tempID=jList1.getSelectedIndex()+1;
            Libro libroMod = DBManager.findLibroByID(tempID);
            titulo.setText(libroMod.getTitulo());
            autor.setText(libroMod.getAutor());
            genero.setText(libroMod.getGenero());
            anio.setText(String.valueOf(libroMod.getAnioPublicacion()));
            precio.setText(String.valueOf(libroMod.getPrecio()));
        }else{
            try {
                if (titulo.getText().equals("")) {
                    throw new Errores(TITULO_VACIO);
                } else if (autor.getText().equals("")) {
                    throw new Errores(AUTOR_VACIO);
                } else if (genero.getText().equals("")) {
                    throw new Errores(GENERO_VACIO);
                } else if (anio.getText().equals("")) {
                    throw new Errores(ANIO_VACIO);
                } else if (precio.getText().equals("")) {
                    throw new Errores(PRECIO_VACIO);
                } else {
                    try {
                        String tituloString = titulo.getText();
                        String autorString = autor.getText();
                        String generoString = genero.getText();
                        Double precioDouble = Double.parseDouble(precio.getText());
                        int anioInt = Integer.parseInt(anio.getText());
                        System.out.println("año es " + anioInt);
                        System.out.println("precio es " + precioDouble);
                        Random random = new Random();
                        int edId = random.nextInt(9) + 1;
                        Libro l = new Libro(tempID, tituloString, autorString, anioInt, generoString, precioDouble, edId);
                        DBManager.updateLibro(l);
                        int idUser = DBManager.getUserById(DBManager.actualUser);
                        DBManager.altaTransaccion(libros[libros.length - 1].getID(),idUser,"Modificacion");
                        libros = DBManager.listaLibros();
                        setTableModel(libros);
                        setListModel(libros);
                        jList1.repaint();
                        jScrollPane1.setViewportView(jTable1);
                        titulo.setText("");
                        autor.setText("");
                        genero.setText("");
                        anio.setText("");
                        precio.setText("");
                        altaButton.setEnabled(true);
                        deleteButton.setEnabled(true);
                        logout.setEnabled(true);
                        profile.setEnabled(true);
                        firstButton.setEnabled(true);
                        antButton.setEnabled(true);
                        sigButton.setEnabled(true);
                        lastButton.setEnabled(true);
                        jList1.setEnabled(true);
                        isModEnabled = false;

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Introduzca valores numericos validos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }catch (Errores e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void profileInfo(java.awt.event.ActionEvent ev){
        JOptionPane.showMessageDialog(null, "User: "+DBManager.actualUser, "INFO", JOptionPane.INFORMATION_MESSAGE);
    }
    public void onLogout(java.awt.event.ActionEvent ev){
        JOptionPane.showMessageDialog(null, "Version 1.0\n Autor:Carlos Gowing", "Info", JOptionPane.INFORMATION_MESSAGE);
        Main.cambioInterfaz2();
    }
    private Libro[] libros;
    private javax.swing.JButton logout;
    private javax.swing.JButton profile;
    private javax.swing.JButton altaButton;
    private javax.swing.JButton modButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton firstButton;
    private javax.swing.JButton antButton;
    private javax.swing.JButton sigButton;
    private javax.swing.JButton lastButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField titulo;
    private javax.swing.JTextField autor;
    private javax.swing.JTextField genero;
    private javax.swing.JTextField anio;
    private javax.swing.JTextField precio;
    private int tempID=-1;
    private boolean isModEnabled = false;
}


