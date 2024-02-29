/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import connection.Koneksi;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import menu.Admin;
import menu.Masyarakat;
import menu.Petugas;

/**
 *
 * @author rdjadmrl
 */
public class Login extends javax.swing.JFrame {

    private String sql;
    private ResultSet rs;
    private java.sql.Connection con;
    private java.sql.Statement stat;
    private Koneksi kon = new Koneksi();
    private UserSession sessionAdmin = new UserSession();
    private UserSession a;
//    private UserSession sessionUser = new UserSession();
//    private UserSession u;
    private List<UserSession> listAdmin;
//    private List<UserSession> listUser;
    private MD5 enc = new MD5();

    public Login() {
        initComponents();
        setLocationRelativeTo(this);

        con = kon.con;
        stat = kon.stat;
        username.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        labelLogin = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        labelRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radja USK | Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frameLogin"); // NOI18N
        setResizable(false);

        labelLogin.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        labelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogin.setText("Login");
        labelLogin.setAutoscrolls(true);
        labelLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelLogin.setMaximumSize(new java.awt.Dimension(90, 30));
        labelLogin.setMinimumSize(new java.awt.Dimension(90, 30));
        labelLogin.setName("labelLogin"); // NOI18N
        labelLogin.setNextFocusableComponent(this);
        labelLogin.setPreferredSize(new java.awt.Dimension(90, 30));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ObjectProperty.create(), labelLogin, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        labelUsername.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsername.setLabelFor(this);
        labelUsername.setText("Username");
        labelUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelUsername.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelUsername.setMaximumSize(new java.awt.Dimension(90, 30));
        labelUsername.setMinimumSize(new java.awt.Dimension(90, 30));
        labelUsername.setName("labelLogin"); // NOI18N
        labelUsername.setNextFocusableComponent(this);
        labelUsername.setPreferredSize(new java.awt.Dimension(90, 30));

        username.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setToolTipText("");
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        labelPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPassword.setLabelFor(this);
        labelPassword.setText("Password");
        labelPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelPassword.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelPassword.setMaximumSize(new java.awt.Dimension(90, 30));
        labelPassword.setMinimumSize(new java.awt.Dimension(90, 30));
        labelPassword.setName("labelLogin"); // NOI18N
        labelPassword.setNextFocusableComponent(this);
        labelPassword.setPreferredSize(new java.awt.Dimension(90, 30));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("Belum punya akun?");
        jLabel.setAutoscrolls(true);
        jLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel.setMaximumSize(new java.awt.Dimension(90, 30));
        jLabel.setMinimumSize(new java.awt.Dimension(90, 30));
        jLabel.setName("labelLogin"); // NOI18N
        jLabel.setNextFocusableComponent(this);
        jLabel.setPreferredSize(new java.awt.Dimension(90, 30));

        labelRegister.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRegister.setText("Register");
        labelRegister.setAutoscrolls(true);
        labelRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelRegister.setMaximumSize(new java.awt.Dimension(90, 30));
        labelRegister.setMinimumSize(new java.awt.Dimension(90, 30));
        labelRegister.setName("labelLogin"); // NOI18N
        labelRegister.setNextFocusableComponent(this);
        labelRegister.setPreferredSize(new java.awt.Dimension(90, 30));
        labelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(btnLogin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        labelLogin.getAccessibleContext().setAccessibleDescription("");

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (username.getText().isEmpty() && password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                String pass;
                pass = enc.getMD5EncryptedValue(password.getText());

                sql = "SELECT * FROM tb_petugas INNER JOIN tb_level ON tb_petugas.id_level = tb_level.id_level WHERE username='" + username.getText() + "' AND password='" + pass + "'";
                rs = stat.executeQuery(sql);

                if (rs.next()) {
                    if (username.getText().equals(rs.getString("username"))) {
                        listAdmin = new ArrayList<UserSession>();
                        a = new UserSession();
                        a.setId(rs.getInt("id_petugas"));
                        a.setUsername(rs.getString("username"));
                        a.setPassword(rs.getString("password"));
                        a.setName(rs.getString("nama_petugas"));
                        a.setLevel(rs.getString("level"));
                        listAdmin.add(a);

                        String level = a.getLevel();

                        if (level.equalsIgnoreCase("administrator")) {
                            JOptionPane.showMessageDialog(null, "Welcome, " + a.getName() + " - Administrator", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                            new Admin().show();
                            this.dispose();
                        } else if (level.equalsIgnoreCase("petugas")) {
                            JOptionPane.showMessageDialog(null, "Welcome, " + a.getName() + " - Petugas", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                            new Petugas().show();
                            this.dispose();
                        }

                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal\nUsername atau Password salah", "Informasi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    sql = "SELECT * FROM tb_masyarakat WHERE username='" + username.getText() + "' AND password='" + pass + "'";
                    rs = stat.executeQuery(sql);

                    if (rs.next()) {
                        if (username.getText().equals(rs.getString("username"))) {
                            listAdmin = new ArrayList<UserSession>();
                            a = new UserSession();
                            a.setId(rs.getInt("id_user"));
                            a.setUsername(rs.getString("username"));
                            a.setPassword(rs.getString("password"));
                            a.setName(rs.getString("nama_lengkap"));
//                            a.setTelp(rs.getString("telp"));
                            listAdmin.add(a);

                            JOptionPane.showMessageDialog(null, "Welcome, " + a.getId() + " - " + a.getName() + " - Masyarakat", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                            new Masyarakat().show();
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal\nUsername atau Password salah", "Informasi", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal\nUsername atau Password salah", "Informasi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void labelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegisterMouseClicked
        new Register().show();
        this.dispose();
    }//GEN-LAST:event_labelRegisterMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelRegister;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}