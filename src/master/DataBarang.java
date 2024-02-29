/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import auth.MD5;
import auth.UserSession;
import static com.sun.webkit.perf.WCFontPerfLogger.reset;
import connection.Koneksi;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import menu.Admin;
import menu.Petugas;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rdjadmrl
 */
public class DataBarang extends javax.swing.JFrame {

    private Connection con;
    private ResultSet rs;
    private Statement stat;
    private String sql;
    private Koneksi kon = new Koneksi();
    private DefaultTableModel model;
//    private MD5 enc = new MD5();
    private UserSession session = new UserSession();
    private JasperReport jasper;
    private JasperPrint print;

    /**
     * Creates new form DataAdmin
     */
    public DataBarang() {
        initComponents();
        setLocationRelativeTo(this);

        con = kon.con;
        stat = kon.stat;
//        setTitle("Data Petugas");
        aturTable();
        sembunyiCRUD();
//        dataCB();

//        jTextField2.setEditable(false);
        nama.requestFocus();
//        jLabel7.setVisible(false);
    }

    private void sembunyi() {
        harga.setEnabled(false);
        idBarang.setEnabled(false);
        nama.setEnabled(false);
        deskripsi.setEnabled(false);
//        jComboBox1.setEnabled(false);
    }

    private void sembunyiCRUD() {
        btnCreate.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    private void tampil() {
        harga.setEnabled(true);
        idBarang.setEnabled(true);
        nama.setEnabled(true);
        deskripsi.setEnabled(true);
//        jComboBox1.setEnabled(true);
    }

    private void tampilCRUD() {
        btnCreate.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }

    private void reset() {
        harga.setText("");
        idBarang.setText("");
        nama.setText("");
        deskripsi.setText("");
//        jComboBox1.removeAllItems();
    }

    private void aturTable() {
        String[] judul = {"ID Barang", "Nama Barang", "Tanggal", "Harga Awal", "Deskripsi"};
        model = new DefaultTableModel(null, judul) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblBarang.setModel(model);

        try {
            sql = "SELECT * FROM tb_barang";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Object[] isi = {rs.getString("id_barang"), rs.getString("nama_barang"), rs.getString("tgl"), rs.getString("harga_awal"), rs.getString("deskripsi_barang")};
                model.addRow(isi);
            }

            ((DefaultTableCellRenderer) tblBarang.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            tblBarang.setModel(model);

            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            tblBarang.getColumnModel().getColumn(0).setCellRenderer(render);
            tblBarang.getColumnModel().getColumn(1).setCellRenderer(render);
            tblBarang.getColumnModel().getColumn(2).setCellRenderer(render);
            tblBarang.getColumnModel().getColumn(3).setCellRenderer(render);
            tblBarang.getColumnModel().getColumn(4).setCellRenderer(render);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDataAdmin = new javax.swing.JLabel();
        panelAdmin = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelHarga = new javax.swing.JLabel();
        labelDeskripsi = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        idBarang = new javax.swing.JTextField();
        SPTblAdmin = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        SPTFDeskripsi = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        btnLaporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radja USK | Data Barang");
        setResizable(false);

        labelDataAdmin.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        labelDataAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataAdmin.setText("Data Barang");
        labelDataAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelId.setText("ID Barang");

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNama.setText("Nama");

        labelHarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHarga.setText("Harga");

        labelDeskripsi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDeskripsi.setText("Deskripsi");

        harga.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        nama.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        idBarang.setEditable(false);
        idBarang.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblBarang.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        SPTblAdmin.setViewportView(tblBarang);

        btnReset.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnUpdate.setText("Edit");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnKembali.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        deskripsi.setColumns(20);
        deskripsi.setRows(5);
        deskripsi.setName(""); // NOI18N
        SPTFDeskripsi.setViewportView(deskripsi);

        btnLaporan.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnLaporan.setText("Laporan");
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHarga)
                            .addComponent(labelNama)
                            .addComponent(labelId)
                            .addComponent(labelDeskripsi))
                        .addGap(18, 18, 18)
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(harga, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                            .addComponent(nama)
                            .addComponent(idBarang)
                            .addComponent(SPTFDeskripsi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(btnKembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                    .addComponent(SPTblAdmin)
                    .addComponent(btnLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate))
                .addGap(17, 17, 17)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNama)
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHarga)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDeskripsi)
                            .addComponent(btnReset))
                        .addGap(18, 18, 18)
                        .addComponent(btnKembali))
                    .addComponent(SPTFDeskripsi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SPTblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLaporan)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDataAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDataAdmin)
                .addGap(18, 18, 18)
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
        btnCreate.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        try {
            sql = "SELECT * FROM tb_barang WHERE id_barang='" + tblBarang.getValueAt(tblBarang.getSelectedRow(), 0) + "'";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                idBarang.setText(rs.getString("id_barang"));
                nama.setText(rs.getString("nama_barang"));
                harga.setText(rs.getString("harga_awal"));
                deskripsi.setText(rs.getString("deskripsi_barang"));

                tampilCRUD();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblBarangMouseClicked

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            sql = "INSERT INTO tb_barang VALUES (" + null + ",'" + nama.getText() + "',CURDATE(),'" + harga.getText() + "','" + deskripsi.getText() + "')";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Sukses tambah data");

            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();

            aturTable();
            reset();
            sembunyiCRUD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            sql = "UPDATE tb_barang SET nama_barang='" + nama.getText() + "', harga_awal='" + harga.getText() + "', deskripsi_barang='" + deskripsi.getText() + "' WHERE id_barang='" + idBarang.getText() + "'";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Sukses edit data");

            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();

            aturTable();
            reset();
            sembunyiCRUD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            sql = "DELETE FROM tb_barang WHERE id_barang='" + idBarang.getText() + "'";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Sukses hapus data");

            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();

            aturTable();
            reset();
            sembunyiCRUD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        if(session.getLevel().equals("administrator")){
            new Admin().show();
            this.dispose();
        }else if(session.getLevel().equals("petugas")){
            new Petugas().show();
            this.dispose();
        }
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        try {
            File file = new File("src/laporan/LaporanDataBarang.jasper");
            HashMap hm = new HashMap();
            jasper = (JasperReport) JRLoader.loadObject(file);
            print = JasperFillManager.fillReport(jasper, hm, con);
            JasperViewer.viewReport(print, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnLaporanActionPerformed

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
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPTFDeskripsi;
    private javax.swing.JScrollPane SPTblAdmin;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField idBarang;
    private javax.swing.JLabel labelDataAdmin;
    private javax.swing.JLabel labelDeskripsi;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNama;
    private javax.swing.JTextField nama;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JTable tblBarang;
    // End of variables declaration//GEN-END:variables
}
