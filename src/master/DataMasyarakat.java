/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import auth.MD5;
//import auth.UserSession;
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
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;

/**
 *
 * @author rdjadmrl
 */
public class DataMasyarakat extends javax.swing.JFrame {

    private Connection con;
    private ResultSet rs;
    private Statement stat;
    private String sql;
    private Koneksi kon = new Koneksi();
    private DefaultTableModel model;
    private MD5 enc = new MD5();
    private UserSession session = new UserSession();
    private JasperReport jasper;
    private JasperPrint print;

    /**
     * Creates new form DataAdmin
     */
    public DataMasyarakat() {
        initComponents();
        setLocationRelativeTo(this);

        con = kon.con;
        stat = kon.stat;
//        setTitle("Data Petugas");
        aturTable();
//        sembunyiCRUD();
//        dataCB();

//        jTextField2.setEditable(false);
//        nama.requestFocus();
//        jLabel7.setVisible(false);
    }

//    private void sembunyi() {
//        username.setEnabled(false);
//        idUser.setEnabled(false);
//        nama.setEnabled(false);
//        password.setEnabled(false);
//        telp.setEnabled(false);
//        jComboBox1.setEnabled(false);
//    }
//    private void sembunyiCRUD() {
//        btnCreate.setEnabled(true);
//        btnUpdate.setEnabled(false);
//        btnDelete.setEnabled(false);
//    }
//    private void tampil() {
//        username.setEnabled(true);
//        idUser.setEnabled(true);
//        nama.setEnabled(true);
//        password.setEnabled(true);
//        telp.setEnabled(true);
//        jComboBox1.setEnabled(true);
//    }
//    private void tampilCRUD() {
//        btnCreate.setEnabled(false);
//        btnUpdate.setEnabled(true);
//        btnDelete.setEnabled(true);
//    }
//    private void reset() {
//        username.setText("");
//        idUser.setText("");
//        nama.setText("");
//        password.setText("");
//        telp.setText("");
//        jComboBox1.removeAllItems();
//    }
    private void aturTable() {
        String[] judul = {"ID Masyarakat", "Nama Lengkap", "Username", "No. Telepon"};
        model = new DefaultTableModel(null, judul) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblMasyarakat.setModel(model);

        try {
            sql = "SELECT * FROM tb_masyarakat";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Object[] isi = {rs.getString("id_user"), rs.getString("nama_lengkap"), rs.getString("username"), rs.getString("telp")};
                model.addRow(isi);
            }

            ((DefaultTableCellRenderer) tblMasyarakat.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            tblMasyarakat.setModel(model);

            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            tblMasyarakat.getColumnModel().getColumn(0).setCellRenderer(render);
            tblMasyarakat.getColumnModel().getColumn(1).setCellRenderer(render);
            tblMasyarakat.getColumnModel().getColumn(2).setCellRenderer(render);
            tblMasyarakat.getColumnModel().getColumn(3).setCellRenderer(render);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDataPetugas = new javax.swing.JLabel();
        panelAdmin = new javax.swing.JPanel();
        SPTblAdmin = new javax.swing.JScrollPane();
        tblMasyarakat = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radja USK | Data Masyarakat");
        setResizable(false);

        labelDataPetugas.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        labelDataPetugas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataPetugas.setText("Data Masyarakat");
        labelDataPetugas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblMasyarakat.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblMasyarakat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMasyarakat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMasyarakatMouseClicked(evt);
            }
        });
        SPTblAdmin.setViewportView(tblMasyarakat);

        btnKembali.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

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
                    .addComponent(SPTblAdmin)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SPTblAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali)
                    .addComponent(btnLaporan))
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
                    .addComponent(labelDataPetugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDataPetugas)
                .addGap(18, 18, 18)
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblMasyarakatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMasyarakatMouseClicked
//        try {
//            sql = "SELECT * FROM tb_masyarakat WHERE id_user='" + tblMasyarakat.getValueAt(tblMasyarakat.getSelectedRow(), 0) + "'";
//            rs = stat.executeQuery(sql);
//            if (rs.next()) {
//                idUser.setText(rs.getString("id_user"));
//                nama.setText(rs.getString("nama_lengkap"));
//                username.setText(rs.getString("username"));
////                password.setText(rs.getString("password"));
//                telp.setText(rs.getString("telp"));
////                jComboBox1.setSelectedIndex(rs.getInt("id_level") == 1 ? 1 : 2);
//
//                tampilCRUD();
////                jLabel7.setVisible(true);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
    }//GEN-LAST:event_tblMasyarakatMouseClicked

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        if (session.getLevel().equals("administrator")) {
            new Admin().show();
            this.dispose();
        } else if (session.getLevel().equals("petugas")) {
            new Petugas().show();
            this.dispose();
        }
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        try {
            File file = new File("src/laporan/LaporanDataMasyarakat.jasper");
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
            java.util.logging.Logger.getLogger(DataMasyarakat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMasyarakat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMasyarakat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMasyarakat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataMasyarakat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPTblAdmin;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JLabel labelDataPetugas;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JTable tblMasyarakat;
    // End of variables declaration//GEN-END:variables
}
