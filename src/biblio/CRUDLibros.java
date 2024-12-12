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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author gordi
 */
public class CRUDLibros extends javax.swing.JFrame {
Connection conn;
Statement sent;
String folio;
DefaultTableModel model;
    /**
     * Creates new form GestionProducto
     */
    public CRUDLibros() {
        initComponents();
        opa.setOpaque(true);
        opa.setBackground(new Color(74,74,82, 200));
        ope.setOpaque(true);
        ope.setBackground(new Color(74,74,82, 200));
        Llenar();
        setLocationRelativeTo(null);
        
    }

    void Limpiar(){
        txttitulo.setText("");
        txtautor.setText("");
        txteditorial.setText("");
        txtanio.setText("");
        txtcategoria.setText("");
        txtejemplar.setText("");
        lblID.setText("");
        txtISBN.setText("");
    }
    
void Nueva(){
        if(txtISBN.getText().equals("") || txttitulo.getText().equals("") || txtautor.getText().equals("") || txteditorial.getText().equals("") || txtanio.getText().equals("") || txtcategoria.getText().equals("") || txtejemplar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Llene todos los campos por favor");
        }else{
        try{
            conn = DB.Mysql.getConnection();
            String sql = "insert into Libros (ISBN,TITULO_LIBRO,AUTOR_LIBRO,EDITORIAL_LIBRO,ANIO_LIBRO,ESTADO_LIBRO,CATEGORIA_LIBRO,EJEMPLAR_LIBRO)"
                    +"values("
                    +"'"+txtISBN.getText()+"',"
                    +"'"+txttitulo.getText()+"',"
                    +"'"+txtautor.getText()+"',"
                    +"'"+txteditorial.getText()+"',"
                    +"'"+txtanio.getText()+"',"
                    +"'Disponible',"
                    +"'"+txtcategoria.getText()+"',"
                    +"'"+txtejemplar.getText()+"')";
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
        }
}

void Editar(){
    if(txttitulo.getText().equals("") || txtautor.getText().equals("") || txteditorial.getText().equals("") || txtanio.getText().equals("") || txtcategoria.getText().equals("") || txtejemplar.getText().equals("") || txtISBN.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Llene todos los campos por favor");
        }else{
        try{
            conn = DB.Mysql.getConnection();
            String sql = "UPDATE Libros SET ISBN="
                    +"'"+txtISBN.getText()+"',TITULO_LIBRO="
                    +"'"+txttitulo.getText()+"',AUTOR_LIBRO="
                    +"'"+txtautor.getText()+"',EDITORIAL_LIBRO="
                    +"'"+txteditorial.getText()+"',ANIO_LIBRO="
                    +"'"+txtanio.getText()+"',ESTADO_LIBRO= 'Disponible',CATEGORIA_LIBRO="
                    +"'"+txtcategoria.getText()+"',EJEMPLAR_LIBRO="
                    +"'"+txtejemplar.getText()+"' WHERE ID_LIBRO='"
                    +lblID.getText()+"'";
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
    }
}

void Eliminar(){
    try{
            String sql = "DELETE from Libros WHERE ID_LIBRO='"
                    +lblID.getText()+"'";
            conn = DB.Mysql.getConnection();
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            
            if(n>0){
                JOptionPane.showMessageDialog(null,"Libro eliminado correctamente");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"No se eliminó el registro");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    Llenar();
}

void Llenar(){
     // Obtener el encabezado de la tabla
        JTableHeader header = tblDB.getTableHeader();

        // Crear una fuente personalizada para el encabezado
        Font headerFont = new Font("Dialog", Font.BOLD, 12); // Cambia "Arial" por el nombre de tu fuente
        header.setFont(headerFont);
        header.setBackground(new Color(51, 51, 55));
        header.setForeground(Color.white);
        try {
            conn = DB.Mysql.getConnection();
            String[] titulos ={"ID","ISBN","Título","Autor","Editorial","Año","Estado","Categoría","#Ejemplar"};
            String sql = "Select * from libros";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String[] fila = new String[9];
            while (rs.next()){
                fila[0]=rs.getString("ID_LIBRO");
                fila[1]=rs.getString("ISBN");
                fila[2]=rs.getString("TITULO_LIBRO");
                fila[3]=rs.getString("AUTOR_LIBRO");
                fila[4]=rs.getString("EDITORIAL_LIBRO");
                fila[5]=rs.getString("ANIO_LIBRO");
                fila[6]=rs.getString("ESTADO_LIBRO");
                fila[7]=rs.getString("CATEGORIA_LIBRO");
                fila[8]=rs.getString("EJEMPLAR_LIBRO");
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
        btnsalir = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblbuscar = new javax.swing.JLabel();
        ope = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtautor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txteditorial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtanio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcategoria = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtejemplar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        opa = new javax.swing.JLabel();
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 368, 590, 140));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 96, 37));

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
        jPanel4.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 96, 37));

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
        jPanel4.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 96, 37));

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
        jPanel4.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 96, 37));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar por ID:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, -1, -1));

        txtID.setBackground(new java.awt.Color(32, 32, 53));
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtID.setCaretColor(new java.awt.Color(255, 255, 255));
        txtID.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtID.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        jPanel4.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 40, 122, -1));

        lblbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descargar.png"))); // NOI18N
        lblbuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbuscarMouseClicked(evt);
            }
        });
        jPanel4.add(lblbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 25, -1, -1));
        jPanel4.add(ope, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 260));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 200, 260));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Título:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 92, -1, -1));

        txttitulo.setBackground(new java.awt.Color(32, 32, 53));
        txttitulo.setForeground(new java.awt.Color(255, 255, 255));
        txttitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txttitulo.setCaretColor(new java.awt.Color(255, 255, 255));
        txttitulo.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txttitulo.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txttitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 93, 150, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Autor:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 130, -1, -1));

        txtautor.setBackground(new java.awt.Color(32, 32, 53));
        txtautor.setForeground(new java.awt.Color(255, 255, 255));
        txtautor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtautor.setCaretColor(new java.awt.Color(255, 255, 255));
        txtautor.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtautor.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtautor, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 131, 150, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Editorial:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 168, -1, -1));

        txteditorial.setBackground(new java.awt.Color(32, 32, 53));
        txteditorial.setForeground(new java.awt.Color(255, 255, 255));
        txteditorial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txteditorial.setCaretColor(new java.awt.Color(255, 255, 255));
        txteditorial.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txteditorial.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txteditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 169, 150, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Año de publicación:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 206, -1, -1));

        txtanio.setBackground(new java.awt.Color(32, 32, 53));
        txtanio.setForeground(new java.awt.Color(255, 255, 255));
        txtanio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtanio.setCaretColor(new java.awt.Color(255, 255, 255));
        txtanio.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtanio.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtanio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtanioKeyTyped(evt);
            }
        });
        jPanel3.add(txtanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 207, 150, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categoría:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 244, -1, -1));

        txtcategoria.setBackground(new java.awt.Color(32, 32, 53));
        txtcategoria.setForeground(new java.awt.Color(255, 255, 255));
        txtcategoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtcategoria.setCaretColor(new java.awt.Color(255, 255, 255));
        txtcategoria.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtcategoria.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 245, 150, -1));

        lblID.setBackground(new java.awt.Color(204, 204, 204));
        lblID.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        jPanel3.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 14, 150, 22));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("# De Ejemplar:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 282, -1, -1));

        txtejemplar.setBackground(new java.awt.Color(32, 32, 53));
        txtejemplar.setForeground(new java.awt.Color(255, 255, 255));
        txtejemplar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtejemplar.setCaretColor(new java.awt.Color(255, 255, 255));
        txtejemplar.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtejemplar.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtejemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 283, 150, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ISBN:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 54, -1, -1));

        txtISBN.setBackground(new java.awt.Color(32, 32, 53));
        txtISBN.setForeground(new java.awt.Color(255, 255, 255));
        txtISBN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtISBN.setCaretColor(new java.awt.Color(255, 255, 255));
        txtISBN.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtISBN.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtISBNKeyTyped(evt);
            }
        });
        jPanel3.add(txtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 55, 150, -1));
        jPanel3.add(opa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 320, 320));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblTitulo.setBackground(new java.awt.Color(51, 102, 0));
        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión de Libros");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/teslas-library-1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 510));

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
                String sql = "Select * from libros where ID_LIBRO='" + tblDB.getValueAt(fila, 0)+"'";
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                if(rs.getString("TITULO_LIBRO")!=""){
                    txtISBN.setText(rs.getString("ISBN"));
                    lblID.setText(rs.getString("ID_LIBRO"));
                    txttitulo.setText(rs.getString("TITULO_LIBRO"));
                    txtautor.setText(rs.getString("AUTOR_LIBRO"));
                    txteditorial.setText(rs.getString("EDITORIAL_LIBRO"));
                    txtanio.setText(rs.getString("ANIO_LIBRO"));
                    txtcategoria.setText(rs.getString("CATEGORIA_LIBRO"));
                    txtejemplar.setText(rs.getString("EJEMPLAR_LIBRO"));

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
        LocalDateTime hoy = LocalDateTime.now();
        int anio=hoy.getYear();
        int aux=Integer.parseInt(txtanio.getText());
        if(txtanio.getText().length()<4 || aux>anio){
            JOptionPane.showMessageDialog(null, "Año de publicación no valido");
        }else{
        Nueva();
        }
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        LocalDateTime hoy = LocalDateTime.now();
        int anio=hoy.getYear();
        int aux=Integer.parseInt(txtanio.getText());
        if(txtanio.getText().length()<4 || aux>anio){
            JOptionPane.showMessageDialog(null, "Año de publicación no valido");
        }else{
        Editar();
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if(txtISBN.getText().equals("") || txttitulo.getText().equals("") || txtautor.getText().equals("") || txteditorial.getText().equals("") || txtanio.getText().equals("") || txtcategoria.getText().equals("") || txtejemplar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Llene todos los campos por favor");
        }else{
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este registro?");
        if(dialogResult == JOptionPane.YES_OPTION){
            Eliminar();
        }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void lblbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuscarMouseClicked
        // TODO add your handling code here:
        try{
                conn = DB.Mysql.getConnection();
                String sql = "Select * from libros where ID_LIBRO='" + txtID.getText()+"'";
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                String a = rs.getString(1);
                if(rs!=null){
                    //JOptionPane.showMessageDialog(null, "Registro encontrado");
                    lblID.setText(rs.getString("ID_LIBRO"));
                    txtISBN.setText(rs.getString("ISBN"));
                    txttitulo.setText(rs.getString("TITULO_LIBRO"));
                    txtautor.setText(rs.getString("AUTOR_LIBRO"));
                    txteditorial.setText(rs.getString("EDITORIAL_LIBRO"));
                    txtanio.setText(rs.getString("ANIO_LIBRO"));
                    txtcategoria.setText(rs.getString("CATEGORIA_LIBRO"));
                    txtejemplar.setText(rs.getString("EJEMPLAR_LIBRO"));

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

    private void txtISBNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtISBNKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        
        boolean numero = key >= 48 && key <= 57;
        
        if(!numero){
            evt.consume();
        }
        
        if(txtISBN.getText().trim().length() == 13){
            evt.consume();
        }
    }//GEN-LAST:event_txtISBNKeyTyped

    private void txtanioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtanioKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        
        boolean numero = key >= 48 && key <= 57;
        
        if(!numero){
            evt.consume();
        }
        
        if(txtanio.getText().trim().length() == 4){
            evt.consume();
        }
    }//GEN-LAST:event_txtanioKeyTyped

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
            java.util.logging.Logger.getLogger(CRUDLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new CRUDLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblbuscar;
    private javax.swing.JLabel opa;
    private javax.swing.JLabel ope;
    private javax.swing.JTable tblDB;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtanio;
    private javax.swing.JTextField txtautor;
    private javax.swing.JTextField txtcategoria;
    private javax.swing.JTextField txteditorial;
    private javax.swing.JTextField txtejemplar;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables
}
