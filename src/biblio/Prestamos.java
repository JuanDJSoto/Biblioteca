/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblio;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Soto
 */
public class Prestamos extends javax.swing.JFrame {
private DatePicker datePickerSalida;
    private DatePicker datePickerEntrega;
    DatePickerSettings settings = new DatePickerSettings();
    Connection conn;
    String ide="";
    String fecha="";
Statement sent;
    /**
     * Creates new form PrePrestamos
     */
    public Prestamos() {
        
        settings.setFormatForDatesCommonEra("dd/MM/yyyy"); // Cambiar formato de fecha
        initComponents();
        setLocationRelativeTo(null);
        fecha();
        opa.setOpaque(true);
        opa.setBackground(new Color(74,74,82, 200));
        opa.setOpaque(true);
        opa.setBackground(new Color(74,74,82, 200));
        
    }
    void fecha(){
        LocalDateTime hoy = LocalDateTime.now();
        int dia = hoy.getDayOfMonth();
        int mes = hoy.getMonthValue();
        int anio = hoy.getYear();
        fecha= dia+"/"+mes+"/"+anio;
        lblfecha.setText(fecha);
    }
    void Limpiar(){
        txtIDLibro.setText("");
        txtIDLibro.setText("");
        lblMiembro.setText("");
        lblLibro.setText("");
    }
void Nueva(){
        try{
            conn = DB.Mysql.getConnection();
            String sql = "insert into Prestamos (ID_LIBRO,ID_MIEMBRO,FECHA_PRESTAMO,FECHA_DEVOLUCION,ESTADO_PRESTAMO)"
                    +"values("
                    +"'"+txtIDLibro.getText()+"',"
                    +"'"+txtIDMiembro.getText()+"',"
                    +"'"+fecha+"',"
                    +"'"+datePicker1.getText()+"',"
                    +"'Prestado')";
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                JOptionPane.showMessageDialog(null,"Préstamo realizado");
            }else{
                JOptionPane.showMessageDialog(null,"No se pudieron guardar los datos");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        reset();
        iden();
}

void iden(){
    try{
            conn = DB.Mysql.getConnection();
            String sql = "Select ID_PRESTAMO from Prestamos where ID_LIBRO='" +txtIDLibro.getText() +"' AND ID_MIEMBRO='"+txtIDMiembro.getText()+"'";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            rs.next();
            ide = rs.getString(1);
            if(rs!=null){
                //JOptionPane.showMessageDialog(null, "Registro encontrado con éxito");

            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Registro no encontrado");
            e.printStackTrace();
        }
    Limpiar();
    N_H();
}

void N_H(){
        try{
            conn = DB.Mysql.getConnection();
            String sql = "insert into Historial (ID_PRESTAMO,FECHA_REGISTRO,ESTADO_HISTORIAL)"
                    +"values("
                    +"'"+ide+"',"
                    +"'FECHA PRESTAMO',"
                    +"'En proceso')";
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                //JOptionPane.showMessageDialog(null,"Préstamo realizado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"No se pudieron guardar los datos");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        Limpiar();
}
void reset(){
    String sql = "UPDATE Libros SET ESTADO_LIBRO= 'En prestamo' WHERE ID_LIBRO='"+txtIDLibro.getText()+"'";
    try{
            conn = DB.Mysql.getConnection();
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                //JOptionPane.showMessageDialog(null,"Datos guardados");
            }else{
                JOptionPane.showMessageDialog(null,"No se pudieron guardar los datos");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIDLibro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblIDMiembro = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombreMiembro = new javax.swing.JLabel();
        lblMiembro = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        lblbuscar = new javax.swing.JLabel();
        lblbuscar1 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        txtIDLibro = new javax.swing.JTextField();
        txtIDMiembro = new javax.swing.JTextField();
        lblLibro = new javax.swing.JLabel();
        datePicker1 =  new DatePicker(settings)
        ;
        opa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIDLibro.setBackground(new java.awt.Color(255, 255, 255));
        lblIDLibro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblIDLibro.setForeground(new java.awt.Color(255, 255, 255));
        lblIDLibro.setText("ID del libro:");
        jPanel1.add(lblIDLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del libro:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Préstamos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de salida:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lblIDMiembro.setBackground(new java.awt.Color(255, 255, 255));
        lblIDMiembro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblIDMiembro.setForeground(new java.awt.Color(255, 255, 255));
        lblIDMiembro.setText("ID del miembro:");
        jPanel1.add(lblIDMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de entrega:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        lblNombreMiembro.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreMiembro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNombreMiembro.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreMiembro.setText("Nombre del miembro:");
        jPanel1.add(lblNombreMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        lblMiembro.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblMiembro.setForeground(new java.awt.Color(255, 255, 255));
        lblMiembro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        jPanel1.add(lblMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 150, 22));

        lblfecha.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 255));
        lblfecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        jPanel1.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 150, 22));

        btnnuevo.setBackground(new java.awt.Color(0, 0, 0));
        btnnuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setText("Nuevo");
        btnnuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 96, 37));

        lblbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descargar.png"))); // NOI18N
        lblbuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbuscarMouseClicked(evt);
            }
        });
        jPanel1.add(lblbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        lblbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descargar.png"))); // NOI18N
        lblbuscar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblbuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbuscar1MouseClicked(evt);
            }
        });
        jPanel1.add(lblbuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        btnsalir.setBackground(new java.awt.Color(0, 0, 0));
        btnsalir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setText("Volver");
        btnsalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 96, 37));

        txtIDLibro.setBackground(new java.awt.Color(32, 32, 53));
        txtIDLibro.setForeground(new java.awt.Color(255, 255, 255));
        txtIDLibro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIDLibro.setCaretColor(new java.awt.Color(255, 255, 255));
        txtIDLibro.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIDLibro.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtIDLibro.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtIDLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 22));

        txtIDMiembro.setBackground(new java.awt.Color(32, 32, 53));
        txtIDMiembro.setForeground(new java.awt.Color(255, 255, 255));
        txtIDMiembro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIDMiembro.setCaretColor(new java.awt.Color(255, 255, 255));
        txtIDMiembro.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIDMiembro.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtIDMiembro.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtIDMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 22));

        lblLibro.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblLibro.setForeground(new java.awt.Color(255, 255, 255));
        lblLibro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        jPanel1.add(lblLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 150, 22));
        jPanel1.add(datePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));
        jPanel1.add(opa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 420, 360));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/library-7720589_960_720.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        if(txtIDLibro.getText().equals("") || txtIDLibro.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        }else{
                Nueva();
        }
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void lblbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuscarMouseClicked
        String idMiembro = txtIDMiembro.getText();

        if (idMiembro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa el ID del miembro.");
            return;
        }

        try (Connection con = DB.Mysql.getConnection()){
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT NOMBRE_MIEMBRO FROM Miembros WHERE ID_MIEMBRO = ?");
            ps.setString(1, idMiembro);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    lblMiembro.setText(rs.getString("NOMBRE_MIEMBRO"));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un miembro con ese ID.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el miembro: " + e.getMessage());
        }
    }//GEN-LAST:event_lblbuscarMouseClicked

    private void lblbuscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuscar1MouseClicked
        // TODO add your handling code here:
        String idLibro = txtIDLibro.getText(); // Obtener el ID del libro ingresado

        if (idLibro.isEmpty()) { // Validar si el campo está vacío
            JOptionPane.showMessageDialog(this, "Por favor, ingresa el ID del libro.");
            return;
        }

        try (Connection con = DB.Mysql.getConnection()){ // Establecer conexión a la BD
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT TITULO_LIBRO FROM libros WHERE ID_LIBRO = ?");  // Ajustar 
            ps.setString(1, idLibro); // Asignar el ID del libro al parámetro

            try (ResultSet rs = ps.executeQuery()) { // Ejecutar la consulta
                
                if (rs.next()) { // Si se encuentra el libro
                    lblLibro.setText(rs.getString("TITULO_LIBRO")); // Agregar el título al ComboBox
                } else { // Si no se encuentra el libro
                    JOptionPane.showMessageDialog(this, "No se encontró un libro con ese ID.");
                }
            }
        } catch (Exception e) { // Manejar errores
            JOptionPane.showMessageDialog(this, "Error al buscar el libro: " + e.getMessage());
        }
    }//GEN-LAST:event_lblbuscar1MouseClicked

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        if(biblio.Login.rang.equals("0")){
            new MenuAdmin().setVisible(true);
            this.setVisible(false);
        }if(biblio.Login.rang.equals("1")){
            new MenuEncargado().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIDLibro;
    private javax.swing.JLabel lblIDMiembro;
    private javax.swing.JLabel lblLibro;
    private javax.swing.JLabel lblMiembro;
    private javax.swing.JLabel lblNombreMiembro;
    private javax.swing.JLabel lblbuscar;
    private javax.swing.JLabel lblbuscar1;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel opa;
    private javax.swing.JTextField txtIDLibro;
    private javax.swing.JTextField txtIDMiembro;
    // End of variables declaration//GEN-END:variables
}
