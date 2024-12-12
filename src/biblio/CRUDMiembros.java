/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblio;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author gordi
 */
public class CRUDMiembros extends javax.swing.JFrame {
Connection conn;
Statement sent;
String fecha;
DefaultTableModel model;
    /**
     * Creates new form GestionProducto
     */
    public CRUDMiembros() {
        initComponents();
        opa.setOpaque(true);
        opa.setBackground(new Color(74,74,82, 200));
        ope.setOpaque(true);
        ope.setBackground(new Color(74,74,82, 200));
        Llenar();
        fecha();
        setLocationRelativeTo(null);
        
    }

    void fecha(){
        LocalDateTime hoy = LocalDateTime.now();
        int dia = hoy.getDayOfMonth();
        int mes = hoy.getMonthValue();
        int anio = hoy.getYear();
        fecha= dia+"-"+mes+"-"+anio;
        //lblfecha.setText(fecha);
    }
    
    void Limpiar(){
        txtnombre.setText("");
        txttelefono.setText("");
        lblfecha.setText("");
        lblID.setText("");
    }
    
void Nueva(){
    if(txtnombre.getText().equals("") || txttelefono.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
    }else{
        try{
            conn = DB.Mysql.getConnection();
            String sql = "insert into Miembros (NOMBRE_MIEMBRO,FECHA_MIEMBRO,TEL_MIEMBRO)"
                    +"values("
                    +"'"+txtnombre.getText()+"',"
                    +"'"+fecha+"',"
                    +"'"+txttelefono.getText()+"')";
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                JOptionPane.showMessageDialog(null,"Datos guardados");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"No se pudieron guardar los datos");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        Llenar();
        Limpiar();
}
}
void Editar(){
    if(txtnombre.getText().equals("") || txttelefono.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
    }else{
        try{
            conn = DB.Mysql.getConnection();
            String sql = "UPDATE Miembros SET NOMBRE_MIEMBRO="
                    +"'"+txtnombre.getText()+"',FECHA_MIEMBRO="
                    +"'"+fecha+"',TEL_MIEMBRO="
                    +"'"+txttelefono.getText()+"' WHERE ID_MIEMBRO='"+lblID.getText()+"'";
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                JOptionPane.showMessageDialog(null,"Datos guardados");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"No se pudieron guardar los datos");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        Llenar();
        Limpiar();
}
}
void Eliminar(){
    try{
            String sql = "DELETE from Miembros WHERE ID_MIEMBRO='"
                    +lblID.getText()+"'";
            conn = DB.Mysql.getConnection();
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            
            if(n>0){
                JOptionPane.showMessageDialog(null,"Miembro eliminado correctamente");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"No se eliminó el registro");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    Limpiar();
    Llenar();
}

void Llenar(){
        JTableHeader header = tblDB.getTableHeader();
        Font headerFont = new Font("Dialog", Font.BOLD, 12); 
        header.setFont(headerFont);
        header.setBackground(new Color(51, 51, 55));
        header.setForeground(Color.white);
        try {
            conn = DB.Mysql.getConnection();
            String[] titulos ={"ID","Nombre","Fecha de modificacion","Telefono"};
            String sql = "Select * from Miembros";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String[] fila = new String[4];
            while (rs.next()){
                fila[0]=rs.getString("ID_MIEMBRO");
                fila[1]=rs.getString("NOMBRE_MIEMBRO");
                fila[2]=rs.getString("FECHA_MIEMBRO");
                fila[3]=rs.getString("TEL_MIEMBRO");
                model.addRow(fila);
            }
            tblDB.setModel(model);
            
        } catch (Exception e){
            e.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDB = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lblbuscar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        opa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        ope = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDB.setBackground(new java.awt.Color(32, 32, 53));
        tblDB.setBorder(new javax.swing.border.MatteBorder(null));
        tblDB.setForeground(new java.awt.Color(255, 255, 255));
        tblDB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDB.setGridColor(new java.awt.Color(51, 51, 51));
        tblDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDB);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 368, 570, 140));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 96, 37));

        btneditar.setBackground(new java.awt.Color(0, 0, 0));
        btneditar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btneditar.setForeground(new java.awt.Color(255, 255, 255));
        btneditar.setText("Editar");
        btneditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        jPanel4.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 96, 37));

        btneliminar.setBackground(new java.awt.Color(0, 0, 0));
        btneliminar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setText("Eliminar");
        btneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 96, 37));

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
        jPanel4.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 96, 37));

        lblbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descargar.png"))); // NOI18N
        lblbuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbuscarMouseClicked(evt);
            }
        });
        jPanel4.add(lblbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 25, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar por ID:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, -1, -1));

        txtID.setBackground(new java.awt.Color(32, 32, 53));
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtID.setCaretColor(new java.awt.Color(255, 255, 255));
        txtID.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtID.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtID.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        jPanel4.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 40, 122, -1));
        jPanel4.add(opa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 240));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 190, 240));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 14, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 80, -1, -1));

        txtnombre.setBackground(new java.awt.Color(32, 32, 53));
        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtnombre.setCaretColor(new java.awt.Color(255, 255, 255));
        txtnombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtnombre.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtnombre.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 106, 150, 22));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Número Telefónico:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 146, -1, -1));

        txttelefono.setBackground(new java.awt.Color(32, 32, 53));
        txttelefono.setForeground(new java.awt.Color(255, 255, 255));
        txttelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txttelefono.setCaretColor(new java.awt.Color(255, 255, 255));
        txttelefono.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txttelefono.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txttelefono.setSelectionColor(new java.awt.Color(255, 255, 255));
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });
        jPanel3.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 172, 150, 22));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de última modificación:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 212, -1, -1));

        lblID.setBackground(new java.awt.Color(204, 204, 204));
        lblID.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        jPanel3.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 40, 150, 22));

        lblfecha.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 255));
        lblfecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        jPanel3.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 238, 150, 22));
        jPanel3.add(ope, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 270));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 220, -1));

        lblTitulo.setBackground(new java.awt.Color(51, 102, 0));
        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión de Miembros");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/biblio3.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDBMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = tblDB.getSelectedRow();
            try{
                conn = DB.Mysql.getConnection();
                String sql = "Select * from Miembros where ID_MIEMBRO='" + tblDB.getValueAt(fila, 0)+"'";
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                if(rs.getString("NOMBRE_MIEMBRO")!=""){
                    lblID.setText(rs.getString("ID_MIEMBRO"));
                    txtnombre.setText(rs.getString("NOMBRE_MIEMBRO"));
                    lblfecha.setText(rs.getString("FECHA_MIEMBRO"));
                    txttelefono.setText(rs.getString("TEL_MIEMBRO"));

                }else{
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_tblDBMouseClicked

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        if(txtnombre.getText().equals("") || txttelefono.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        }else{
        if(txttelefono.getText().length()<10){
           JOptionPane.showMessageDialog(null, "Número telefónico inválido");
        }else{
        Nueva();
        }
        }
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        if(txtnombre.getText().equals("") || txttelefono.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        }else{
        if(txttelefono.getText().length()<10){
           JOptionPane.showMessageDialog(null, "Número telefónico inválido");
        }else{
        Editar();
        }
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Está seguro de eliminar este registro?","Alerta",1);
        if(dialogResult == JOptionPane.YES_OPTION){
            Eliminar();
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void lblbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuscarMouseClicked
        // TODO add your handling code here:
        try{
            conn = DB.Mysql.getConnection();
            String sql = "Select * from Miembros where ID_MIEMBRO='" + txtID.getText()+"'";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            rs.next();
            String a = rs.getString(1);
            if(rs!=null){
                //JOptionPane.showMessageDialog(null, "Registro encontrado con éxito");
                lblID.setText(rs.getString("ID_MIEMBRO"));
                    txtnombre.setText(rs.getString("NOMBRE_MIEMBRO"));
                    lblfecha.setText(rs.getString("FECHA_MIEMBRO"));
                    txttelefono.setText(rs.getString("TEL_MIEMBRO"));

            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Registro no encontrado");
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblbuscarMouseClicked

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

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        
        boolean numero = key >= 48 && key <= 57;
        
        if(!numero){
            evt.consume();
        }
        if(txttelefono.getText().trim().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        
        boolean numero = key >= 48 && key <= 57;
        
        if(!numero){
            evt.consume();
        }
    }//GEN-LAST:event_txtIDKeyTyped

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
            java.util.logging.Logger.getLogger(CRUDMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDMiembros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblbuscar;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel opa;
    private javax.swing.JLabel ope;
    private javax.swing.JTable tblDB;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
