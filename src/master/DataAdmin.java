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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rdjadmrl
 */
public class DataAdmin extends javax.swing.JFrame {

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
    public DataAdmin() {
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
        username.setEnabled(false);
        idAdmin.setEnabled(false);
        nama.setEnabled(false);
        password.setEnabled(false);
//        jComboBox1.setEnabled(false);
    }

    private void sembunyiCRUD() {
        btnCreate.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    private void tampil() {
        username.setEnabled(true);
        idAdmin.setEnabled(true);
        nama.setEnabled(true);
        password.setEnabled(true);
//        jComboBox1.setEnabled(true);
    }

    private void tampilCRUD() {
        btnCreate.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }

    private void reset() {
        username.setText("");
        idAdmin.setText("");
        nama.setText("");
        password.setText("");
//        jComboBox1.removeAllItems();
    }

    private void aturTable() {
        String[] judul = {"ID Petugas", "Nama Petugas", "Username", "Hak Akses"};
        model = new DefaultTableModel(null, judul) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblAdmin.setModel(model);

        try {
            sql = "SELECT * FROM tb_petugas INNER JOIN tb_level ON tb_petugas.id_level = tb_level.id_level WHERE tb_petugas.id_level = 1";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Object[] isi = {rs.getString("id_petugas"), rs.getString("nama_petugas"), rs.getString("username"), rs.getString("level").substring(0, 1).toUpperCase() + rs.getString("level").substring(1)};
                model.addRow(isi);
            }

            ((DefaultTableCellRenderer) tblAdmin.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            tblAdmin.setModel(model);

            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            tblAdmin.getColumnModel().getColumn(0).setCellRenderer(render);
            tblAdmin.getColumnModel().getColumn(1).setCellRenderer(render);
            tblAdmin.getColumnModel().getColumn(2).setCellRenderer(render);
            tblAdmin.getColumnModel().getColumn(3).setCellRenderer(render);
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
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        idAdmin = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        SPTblAdmin = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radja USK | Data Admin");
        setResizable(false);

        labelDataAdmin.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        labelDataAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataAdmin.setText("Data Admin");
        labelDataAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelId.setText("ID Admin");

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNama.setText("Nama");

        labelUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUsername.setText("Username");

        labelPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPassword.setText("Password");

        username.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        nama.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        idAdmin.setEditable(false);
        idAdmin.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        password.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblAdmin.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        SPTblAdmin.setViewportView(tblAdmin);

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
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SPTblAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsername)
                            .addComponent(labelNama)
                            .addComponent(labelId)
                            .addComponent(labelPassword))
                        .addGap(18, 18, 18)
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                            .addComponent(password)
                            .addComponent(nama)
                            .addComponent(idAdmin))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(btnLaporan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(idAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate))
                .addGap(17, 17, 17)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNama)
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addComponent(btnKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(btnLaporan))
                    .addComponent(SPTblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
        try {
            sql = "SELECT * FROM tb_petugas INNER JOIN tb_level ON tb_petugas.id_level=tb_level.id_level WHERE id_petugas='" + tblAdmin.getValueAt(tblAdmin.getSelectedRow(), 0) + "'";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                idAdmin.setText(rs.getString("id_petugas"));
                nama.setText(rs.getString("nama_petugas"));
                username.setText(rs.getString("username"));
//                password.setText(rs.getString("password"));
//                jComboBox1.setSelectedIndex(rs.getInt("id_level") == 1 ? 1 : 2);

                tampilCRUD();
//                jLabel7.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblAdminMouseClicked

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (nama.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
//                   Integer level;
                String pass;

//                   level = jComboBox1.getSelectedIndex() == 1 ? 1 : 2;
                pass = enc.getMD5EncryptedValue(password.getText());

                sql = "SELECT * FROM tb_petugas WHERE username='" + username.getText() + "'";
                rs = stat.executeQuery(sql);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username sudah terdaftar", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    sql = "INSERT INTO tb_petugas VALUES (" + null + ",'" + nama.getText() + "','" + username.getText() + "','" + pass + "', '1')";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Sukses tambah data");

                    model.fireTableDataChanged();
                    model.getDataVector().removeAllElements();

                    aturTable();
                    reset();
//                       dataCB();
                    sembunyiCRUD();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (nama.getText().isEmpty() || username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Integer level;
                String pass;

//                level = jComboBox1.getSelectedIndex() == 1 ? 1 : 2;
                pass = enc.getMD5EncryptedValue(password.getText());

                if (session.getUsername().equals(username.getText())) {
                    if (password.getText().isEmpty()) {
                        sql = "UPDATE tb_petugas SET nama_petugas='" + nama.getText() + "', username='" + username.getText() + "', id_level='1' WHERE id_petugas='" + idAdmin.getText() + "'";
                    } else {
                        if (password.getText().length() < 7) {
                            JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 7 huruf");
                            return;
                        } else {
                            sql = "UPDATE tb_petugas SET nama_petugas='" + nama.getText() + "', username='" + username.getText() + "', password='" + pass + "', id_level='1' WHERE id_petugas='" + idAdmin.getText() + "'";
                        }
                    }
                } else if (!session.getUsername().equals(username.getText())) {
                    sql = "SELECT * FROM tb_petugas WHERE username='" + username.getText() + "'";
                    rs = stat.executeQuery(sql);

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Username sudah terdaftar");
                        return;
                    } else {
                        if (password.getText().isEmpty()) {
                            sql = "UPDATE tb_petugas SET nama_petugas='" + nama.getText() + "', username='" + username.getText() + "', id_level='1' WHERE id_petugas='" + idAdmin.getText() + "'";
                        } else {
                            if (password.getText().length() < 7) {
                                JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 7 huruf");
                                return;
                            } else {
                                sql = "UPDATE tb_petugas SET nama_petugas='" + nama.getText() + "', username='" + username.getText() + "', password='" + pass + "', id_level='1' username='" + username.getText() + "' WHERE id_petugas='" + idAdmin.getText() + "'";
                            }
                        }
                    }
                } else {
                    sql = "SELECT * FROM tb_petugas WHERE username='" + username.getText() + "'";
                    rs = stat.executeQuery(sql);

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Username sudah terdaftar");
                        return;
                    } else {
                        if (password.getText().isEmpty()) {
                            sql = "UPDATE tb_petugas SET nama_petugas='" + nama.getText() + "', username='" + username.getText() + "', id_level='1' WHERE id_petugas='" + idAdmin.getText() + "'";
                        } else {
                            if (password.getText().length() < 7) {
                                JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 7 huruf");
                                return;
                            } else {
                                sql = "UPDATE tb_petugas SET nama_petugas='" + nama.getText() + "', username='" + username.getText() + "', password='" + pass + "', id_level='1' username='" + username.getText() + "' WHERE id_petugas='" + idAdmin.getText() + "'";
                            }
                        }
                    }
                }

                stat.execute(sql);
                JOptionPane.showMessageDialog(null, "Sukses edit data");

                model.fireTableDataChanged();
                model.getDataVector().removeAllElements();

                aturTable();
                reset();
//                dataCB();
                sembunyiCRUD();
//                jLabel7.setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            sql = "DELETE FROM tb_petugas WHERE id_petugas='" + idAdmin.getText() + "'";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Sukses hapus data");

            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();

            aturTable();
            reset();
//            dataCB();
            sembunyiCRUD();
//            jLabel7.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new Admin().show();
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        try {
            File file = new File("src/laporan/LaporanDataAdmin.jasper");
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
            java.util.logging.Logger.getLogger(DataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPTblAdmin;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField idAdmin;
    private javax.swing.JLabel labelDataAdmin;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextField nama;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPasswordField password;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
