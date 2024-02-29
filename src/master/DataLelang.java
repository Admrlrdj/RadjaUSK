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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import menu.Admin;
import menu.Petugas;

/**
 *
 * @author rdjadmrl
 */
public class DataLelang extends javax.swing.JFrame {

    private Connection con;
    private ResultSet rs;
    private Statement stat;
    private String sql;
    private Koneksi kon = new Koneksi();
    private DefaultTableModel model;
    private UserSession session = new UserSession();
    private SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat fm1 = new SimpleDateFormat("dd-MM-yyyy");
    private Calendar cal = Calendar.getInstance();

    /**
     * Creates new form DataAdmin
     */
    public DataLelang() {
        initComponents();
        setLocationRelativeTo(this);

        con = kon.con;
        stat = kon.stat;
        aturTable();
        dataCB();
        dataCB1();
        sembunyiCRUD();

//        jTextField2.setEditable(false);
        nama.requestFocus();
        tanggal.setDate(cal.getTime());
//        jLabel7.setVisible(false);
    }

    private void sembunyi() {
        nama.setEnabled(false);
        statusLelang.setEnabled(false);
    }

    private void sembunyiCRUD() {
        btnCreate.setEnabled(true);
        btnUpdate.setEnabled(false);
    }

    private void tampil() {
        nama.setEnabled(true);
        statusLelang.setEnabled(true);
    }

    private void tampilCRUD() {
        btnCreate.setEnabled(false);
        btnUpdate.setEnabled(true);
    }

    private void dataCB() {
        nama.removeAllItems();
        nama.addItem("-- Pilih --");

        try {
            sql = "SELECT * FROM tb_barang LEFT JOIN tb_lelang ON tb_barang.id_barang = tb_lelang.id_barang WHERE id_lelang IS NULL";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                nama.addItem(rs.getString("nama_barang"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal" + e.getMessage());
        }
    }

    private void dataCB1() {
        statusLelang.removeAllItems();
        String[] data = {"-- Pilih --", "Dibuka", "Ditutup"};
        for (String a : data) {
            statusLelang.addItem(a);
        }
    }

    private void reset() {
        model.fireTableDataChanged();
        model.getDataVector().removeAllElements();
        aturTable();
        sembunyiCRUD();
        dataCB();
        dataCB1();
        tanggal.setDate(cal.getTime());
        idLelang.setText("");
    }

    private void aturTable() {
        String[] judul = {"ID Lelang", "Nama Barang", "Tgl Lelang", "Harga Awal", "Harga Akhir", "Penawar", "Petugas", "Status"};
        model = new DefaultTableModel(null, judul) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblLelang.setModel(model);

        try {
            sql = "SELECT * FROM tb_lelang INNER JOIN tb_barang ON tb_lelang.id_barang = tb_barang.id_barang LEFT JOIN tb_masyarakat ON tb_lelang.id_user = tb_masyarakat.id_user INNER JOIN tb_petugas ON tb_lelang.id_petugas = tb_petugas.id_petugas";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Object[] isi = {rs.getString("id_lelang"), rs.getString("nama_barang"), String.valueOf(fm1.format(rs.getDate("tgl_lelang"))), rs.getString("harga_awal"), rs.getString("harga_akhir") == null ? "Belum Ada" : rs.getString("harga_akhir"), rs.getString("nama_lengkap") == null ? "Belum Ada" : rs.getString("nama_lengkap"), rs.getString("nama_petugas"), rs.getString("status").substring(0, 1).toUpperCase() + rs.getString("status").substring(1)};
                model.addRow(isi);
            }

            ((DefaultTableCellRenderer) tblLelang.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            tblLelang.setModel(model);

            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            tblLelang.getColumnModel().getColumn(0).setCellRenderer(render);
            tblLelang.getColumnModel().getColumn(1).setCellRenderer(render);
            tblLelang.getColumnModel().getColumn(2).setCellRenderer(render);
            tblLelang.getColumnModel().getColumn(3).setCellRenderer(render);
            tblLelang.getColumnModel().getColumn(4).setCellRenderer(render);
            tblLelang.getColumnModel().getColumn(5).setCellRenderer(render);
            tblLelang.getColumnModel().getColumn(6).setCellRenderer(render);
            tblLelang.getColumnModel().getColumn(7).setCellRenderer(render);
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
        labelTgl = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        idLelang = new javax.swing.JTextField();
        SPTblLelang = new javax.swing.JScrollPane();
        tblLelang = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        statusLelang = new javax.swing.JComboBox();
        nama = new javax.swing.JComboBox();
        tanggal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radja USK | Data Lelang");
        setResizable(false);

        labelDataAdmin.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        labelDataAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataAdmin.setText("Data Lelang");
        labelDataAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelId.setText("ID Lelang");

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNama.setText("Nama Barang");

        labelTgl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTgl.setText("Tanggal Lelang");

        labelStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelStatus.setText("Status Lelang");

        idLelang.setEditable(false);
        idLelang.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblLelang.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblLelang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblLelang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLelangMouseClicked(evt);
            }
        });
        SPTblLelang.setViewportView(tblLelang);

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

        btnReset.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnKembali.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        statusLelang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        nama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAdminLayout.createSequentialGroup()
                                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNama)
                                    .addComponent(labelId)
                                    .addComponent(labelStatus))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                                .addComponent(labelTgl)
                                .addGap(18, 18, 18)))
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama, 0, 438, Short.MAX_VALUE)
                            .addGroup(panelAdminLayout.createSequentialGroup()
                                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idLelang)
                                    .addComponent(statusLelang, 0, 438, Short.MAX_VALUE)
                                    .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(SPTblLelang))
                .addContainerGap())
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(idLelang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate))
                .addGap(17, 17, 17)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNama)
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTgl))
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatus)
                    .addComponent(statusLelang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembali))
                .addGap(18, 18, 18)
                .addComponent(SPTblLelang, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
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

    private void tblLelangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLelangMouseClicked
        try {
            sql = "SELECT * FROM tb_lelang INNER JOIN tb_barang ON tb_lelang.id_barang=tb_barang.id_barang WHERE id_lelang='" + tblLelang.getValueAt(tblLelang.getSelectedRow(), 0) + "'";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                idLelang.setText(rs.getString("id_lelang"));
                nama.getModel().setSelectedItem(rs.getString("nama_barang"));
                statusLelang.setSelectedIndex(rs.getString("status").equals("dibuka") ? 1 : 2);
                tanggal.setDate(rs.getDate("tgl_lelang"));

                tampilCRUD();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblLelangMouseClicked

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (nama.getSelectedIndex() == 0 || statusLelang.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                String status;

                if (statusLelang.getSelectedIndex() == 1) {
                    status = "dibuka";
                } else {
                    status = "ditutup";
                }

                sql = "INSERT INTO tb_lelang VALUES (" + null + ",(SELECT id_barang FROM tb_barang WHERE nama_barang='" + nama.getSelectedItem() + "'), '" + String.valueOf(fm.format(tanggal.getDate())) + "', " + null + ", " + null + ", '" + session.getId() + "', '" + status + "')";
                stat.execute(sql);
                JOptionPane.showMessageDialog(null, "Sukses tambah data");

                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (nama.getSelectedIndex() == 0 || statusLelang.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                String status;

                if (statusLelang.getSelectedIndex() == 1) {
                    status = "dibuka";
                } else {
                    status = "ditutup";
                }

                sql = "UPDATE tb_lelang SET id_barang=(SELECT id_barang FROM tb_barang WHERE nama_barang='" + nama.getSelectedItem() + "'), tgl_lelang='" + String.valueOf(fm.format(tanggal.getDate())) + "', status='" + status + "' WHERE id_lelang='" + idLelang.getText() + "'";
                stat.execute(sql);
                JOptionPane.showMessageDialog(null, "Sukses edit data");

                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new Petugas().show();
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(DataLelang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataLelang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataLelang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataLelang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataLelang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPTblLelang;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField idLelang;
    private javax.swing.JLabel labelDataAdmin;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTgl;
    private javax.swing.JComboBox nama;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JComboBox statusLelang;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTable tblLelang;
    // End of variables declaration//GEN-END:variables
}
