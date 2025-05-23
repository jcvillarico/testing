/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringsystem;

import config.dbConnector;
import config.passwordHasher;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class registrationForm extends javax.swing.JFrame {

    /**
     * Creates new form registrationForm
     */
    public registrationForm() {
        initComponents();
    }
     public String destination ="";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }

    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
      public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   } 

    Color hovercolor = new Color(255,4,4);
    Color navcolor = new Color(153,102,0);
    
    public boolean duplicateCheck(){
        String email;
        String usname;
    
    dbConnector dbc = new dbConnector();
    
    try{
     String query = "SELECT * FROM tbl_user  WHERE u_username = '" +un.getText()+ "' OR u_email = '" +em.getText()+ "'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                email = resultSet.getString("u_email");           
                if(email.equals(em.getText())){
                JOptionPane.showMessageDialog(null,"Email is Already used!");
                em.setText("");
                }
                
                usname = resultSet.getString("u_username");
                if(usname.equals(un.getText())){
                JOptionPane.showMessageDialog(null,"Username is Already used!");
                un.setText("");
                }
                
                return true;
            }else{
            return false;
            }
    }catch(SQLException ex){
        System.out.println(""+ex);
        return false;
    
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

        cps1 = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ps = new javax.swing.JPasswordField();
        ut = new javax.swing.JComboBox<>();
        register = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cps = new javax.swing.JPasswordField();
        un = new javax.swing.JTextField();
        showpassreg = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SELECT = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ans = new javax.swing.JTextField();
        sqq = new javax.swing.JComboBox<>();

        cps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cps1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WELCOME TO CATERING SERVICE SYSTEM");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 920, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 0, 990, 50));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("User Type:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 80, 20));

        contact.setBackground(new java.awt.Color(153, 153, 0));
        contact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 150, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("First Name:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 80, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Last Name:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 80, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Email:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 80, 30));

        fn.setBackground(new java.awt.Color(153, 153, 0));
        fn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 150, 30));

        ln.setBackground(new java.awt.Color(153, 153, 0));
        ln.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 150, 30));

        em.setBackground(new java.awt.Color(153, 153, 0));
        em.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 150, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Password:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 80, 30));

        ps.setBackground(new java.awt.Color(153, 153, 0));
        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        jPanel1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 150, 30));

        ut.setBackground(new java.awt.Color(153, 153, 0));
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User", "Client" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel1.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 150, -1));

        register.setBackground(new java.awt.Color(153, 102, 0));
        register.setText("Register");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel1.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        cancel.setBackground(new java.awt.Color(153, 102, 0));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 70, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Confirm Pass:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 100, 30));

        cps.setBackground(new java.awt.Color(153, 153, 0));
        cps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpsActionPerformed(evt);
            }
        });
        jPanel1.add(cps, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 150, 30));

        un.setBackground(new java.awt.Color(153, 153, 0));
        un.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 150, 30));

        showpassreg.setText("Show Pass");
        showpassreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassregActionPerformed(evt);
            }
        });
        jPanel1.add(showpassreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 100, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Contact Num:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 100, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Register Now!");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 140, 30));

        SELECT.setText("PHOTO");
        SELECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SELECTActionPerformed(evt);
            }
        });
        jPanel1.add(SELECT, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 110, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Catering-logo-vector-icon-illustration-Graphics-68140048-1-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 160, 490, 250));
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 110, 120));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hala.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 390, 400));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Username:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 80, 30));

        jLabel5.setText("Questioner:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 184, 80, 20));

        ans.setBackground(new java.awt.Color(153, 153, 0));
        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });
        jPanel1.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 150, 30));

        sqq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favorite food?", "What is your favorite pet?", "Whats is your secret ability?" }));
        sqq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqqActionPerformed(evt);
            }
        });
        jPanel1.add(sqq, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        
if (fn.getText().isEmpty() || ln.getText().isEmpty() || un.getText().isEmpty() || em.getText().isEmpty()
    || contact.getText().isEmpty() || ps.getText().isEmpty() || cps.getText().isEmpty() || ans.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null, "All fields are required!");

} else if (ps.getText().length() < 8) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
    ps.setText("");
    cps.setText(""); 

} else if (!ps.getText().equals(cps.getText())) {
    JOptionPane.showMessageDialog(null, "Passwords do not match.");
    ps.setText("");
    cps.setText(""); 

} else if (!em.getText().matches("^.+@.+\\..{2,}$")) {
    JOptionPane.showMessageDialog(null, "Invalid email format.");
    em.setText("");

} else if (!contact.getText().matches("\\d{11}")) {
    JOptionPane.showMessageDialog(null, "Contact number must contain only digits and be 11 digits long.");
    contact.setText("");

} else if (duplicateCheck()) {
    System.out.println("Duplicate Exist!");

} else {
    dbConnector dbc = new dbConnector();

    try {
        String hashedPass = passwordHasher.hashPassword(ps.getText());
        String hashedCpass = passwordHasher.hashPassword(cps.getText());
        String hashedAnswer = passwordHasher.hashPassword(ans.getText());
        String status = "Pending"; // or SELECT.getText() if needed
        String image = "Undecided";
        String question = sqq.getSelectedItem().toString();

        String sql = "INSERT INTO tbl_user (u_fname, u_lname, u_type, u_email, u_username, u_contact, u_password, u_cpassword, u_status, u_image, u_question, u_answer) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = dbc.connect.prepareStatement(sql);
        pst.setString(1, fn.getText());
        pst.setString(2, ln.getText());
        pst.setString(3, ut.getSelectedItem().toString());
        pst.setString(4, em.getText());
        pst.setString(5, un.getText());
        pst.setString(6, contact.getText());
        pst.setString(7, hashedPass);
        pst.setString(8, hashedCpass);
        pst.setString(9, status);
        pst.setString(10, image);
        pst.setString(11, question);
        pst.setString(12, hashedAnswer);

        int inserted = pst.executeUpdate();

        if (inserted > 0) {
            JOptionPane.showMessageDialog(null, "Inserted Successfully!");
            loginForm lfr = new loginForm();
            lfr.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Connection Error!");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
    }
}

        
       
      
      
    }//GEN-LAST:event_registerActionPerformed

    private void cps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cps1ActionPerformed
        // TODO ad d your handling code here:
    }//GEN-LAST:event_cps1ActionPerformed

    private void cpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpsActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
       
    }//GEN-LAST:event_emActionPerformed

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
        register.setBackground(hovercolor);
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        register.setBackground(navcolor);
    }//GEN-LAST:event_registerMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        loginForm lfm = new loginForm();
        lfm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_cancelActionPerformed

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(navcolor);
    }//GEN-LAST:event_cancelMouseExited

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(hovercolor);
    }//GEN-LAST:event_cancelMouseEntered

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed

    }//GEN-LAST:event_contactActionPerformed

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
       
    }//GEN-LAST:event_psActionPerformed

    private void showpassregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassregActionPerformed
        if(showpassreg.isSelected()){
           ps.setEchoChar((char)0);
           cps.setEchoChar((char)0);
        }
        else {
            ps.setEchoChar('*');
            cps.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassregActionPerformed

    private void SELECTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SELECTActionPerformed
        JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            SELECT.setEnabled(false);
                            
                            
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    
                    }}
    }//GEN-LAST:event_SELECTActionPerformed

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerActionPerformed

    private void sqqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqqActionPerformed
            System.out.println("Security question changed: " + sqq.getSelectedItem());

    }//GEN-LAST:event_sqqActionPerformed

    private void sqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansActionPerformed

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
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton SELECT;
    private javax.swing.JTextField ans;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField contact;
    private javax.swing.JPasswordField cps;
    private javax.swing.JPasswordField cps1;
    private javax.swing.JTextField em;
    private javax.swing.JTextField fn;
    private javax.swing.JLabel image;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField ln;
    private javax.swing.JPasswordField ps;
    private javax.swing.JButton register;
    private javax.swing.JCheckBox showpassreg;
    private javax.swing.JComboBox<String> sqq;
    private javax.swing.JTextField un;
    private javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
