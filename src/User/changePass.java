/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import cateringsystem.loginForm;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SCC-COLLEGE
 */
public class changePass extends javax.swing.JFrame {

    /**
     * Creates new form userDashboard
     */
    public changePass() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        iddisplay = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        acc_fn = new javax.swing.JLabel();
        changepass = new javax.swing.JLabel();
        acc_ln = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        oldpass = new javax.swing.JTextField();
        newpass = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        conpass = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        j = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iddisplay.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        iddisplay.setForeground(new java.awt.Color(255, 255, 255));
        iddisplay.setText("(UID)");
        jPanel2.add(iddisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 70, 30));

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGOUT");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 80, -1));

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CHANGE PASSWORD");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 50));

        jPanel3.setBackground(new java.awt.Color(204, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconuser-removebg-preview edit.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 140, 130));

        acc_fn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_fn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_fn.setText("ac_fn");
        jPanel3.add(acc_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 150, -1));

        changepass.setBackground(new java.awt.Color(255, 255, 255));
        changepass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        changepass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        changepass.setText("Change Pass");
        changepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changepassMouseClicked(evt);
            }
        });
        jPanel3.add(changepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, 30));

        acc_ln.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_ln.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_ln.setText("User");
        jPanel3.add(acc_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 150, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 460));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hala.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 290, 370));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Old password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 110, 30));

        oldpass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        oldpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldpassActionPerformed(evt);
            }
        });
        jPanel1.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 150, 30));

        newpass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 150, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("New Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 110, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Confirm password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 130, 30));

        conpass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        conpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conpassActionPerformed(evt);
            }
        });
        jPanel1.add(conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 150, 30));

        jPanel4.setBackground(new java.awt.Color(204, 153, 0));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(null);

        j.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        j.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        j.setText("Save");
        jPanel4.add(j);
        j.setBounds(0, 10, 70, 10);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 70, 30));

        jPanel6.setBackground(new java.awt.Color(204, 153, 0));
        jPanel6.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Back");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(0, 10, 70, 10);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        loginForm wes = new loginForm();
        wes.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          Session sess = Session.getInstance();
        iddisplay.setText("USER ID:"+sess.getUid());

        
    }//GEN-LAST:event_formWindowActivated

    private void conpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conpassActionPerformed

    }//GEN-LAST:event_conpassActionPerformed

    private void oldpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldpassActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        try{
        dbConnector dbc = new dbConnector();
         Session sess = Session.getInstance();
         
     
        String query = "SELECT * FROM tbl_user WHERE u_id = '"+sess.getUid()+"'";
            ResultSet rs = dbc.getData(query);
        if(rs.next()){
            String olddbpass = rs.getString("u_password");
            String oldhash = passwordHasher.hashPassword(oldpass.getText());
            
            if(olddbpass.equals(oldhash)){
                String npass = passwordHasher.hashPassword(newpass.getText());
                dbc.updateData("UPDATE tbl_user SET u_password ='"+npass+"'");
                loginForm lg = new loginForm();
                lg.setVisible(true);
                this.dispose();
            }else if(!newpass.equals(conpass)){
                JOptionPane.showMessageDialog(null,"Password Doesn't Match!");
                loginForm rr = new loginForm();
                rr.setVisible(true);
                this.dispose();
          }else{
            JOptionPane.showMessageDialog(null,"Old password Is Incorrect");
            }
        
        }
        }catch(SQLException|NoSuchAlgorithmException ex){
            System.out.println(""+ex);
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void changepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changepassMouseClicked
        
    }//GEN-LAST:event_changepassMouseClicked

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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_fn;
    private javax.swing.JLabel acc_ln;
    private javax.swing.JLabel changepass;
    private javax.swing.JTextField conpass;
    private javax.swing.JLabel iddisplay;
    private javax.swing.JLabel j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField newpass;
    private javax.swing.JTextField oldpass;
    // End of variables declaration//GEN-END:variables

    private loginForm loginForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
