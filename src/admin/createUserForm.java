/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import User.clientsForm;
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
public class createUserForm extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public createUserForm() {
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

            
    public boolean duplicateCheck(){
        String email;
        String usname;
    
    dbConnector dbc = new dbConnector();
    
    try{
     String query = "SELECT * FROM tbl_user  WHERE u_username = '" +un1.getText()+ "' OR u_email = '" +em1.getText()+ "'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                email = resultSet.getString("u_email");           
                if(email.equals(em1.getText())){
                JOptionPane.showMessageDialog(null,"Email is Already used!");
                em1.setText("");
                }
                
                usname = resultSet.getString("u_username");
                if(usname.equals(un1.getText())){
                JOptionPane.showMessageDialog(null,"Username is Already used!");
                un1.setText("");
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
    
     public boolean UpdateCheck(){
        String email;
        String usname;
    
    dbConnector dbc = new dbConnector();
    
    try{
     String query = "SELECT * FROM tbl_user  WHERE (u_username = '" +un1.getText()+ "' OR u_email = '" +em1.getText()+ "')AND u_id!='"+userID.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                email = resultSet.getString("u_email");           
                if(email.equals(em1.getText())){
                JOptionPane.showMessageDialog(null,"Email is Already used!");
                em1.setText("");
                }
                
                usname = resultSet.getString("u_username");
                if(usname.equals(un1.getText())){
                JOptionPane.showMessageDialog(null,"Username is Already used!");
                un1.setText("");
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
    Color hovercolor = new Color(255,4,4);
    Color navcolor = new Color(153,102,0);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fn = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        ut = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ps = new javax.swing.JPasswordField();
        cps = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        userID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ln1 = new javax.swing.JTextField();
        em1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        un1 = new javax.swing.JTextField();
        fn1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        userupdate = new javax.swing.JButton();
        userdelete = new javax.swing.JButton();
        userclear = new javax.swing.JButton();
        usercancel = new javax.swing.JButton();
        userrefresh = new javax.swing.JButton();
        ut1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ps1 = new javax.swing.JPasswordField();
        cps1 = new javax.swing.JPasswordField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        contact1 = new javax.swing.JTextField();
        us = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ans = new javax.swing.JTextField();
        sq = new javax.swing.JComboBox<>();

        fn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("First Name:");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Last Name:");

        ln.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        em.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Email:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Username:");

        un.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("User Type:");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Password:");

        cps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpsActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Confirm Pass:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Contact Num:");

        contact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

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

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 102, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        userID.setBackground(new java.awt.Color(153, 153, 0));
        userID.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        userID.setEnabled(false);
        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });
        getContentPane().add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 80, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("User ID:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 70, 20));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Last Name:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 80, 30));

        ln1.setBackground(new java.awt.Color(153, 153, 0));
        ln1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ln1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln1ActionPerformed(evt);
            }
        });
        getContentPane().add(ln1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, 30));

        em1.setBackground(new java.awt.Color(153, 153, 0));
        em1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        em1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                em1ActionPerformed(evt);
            }
        });
        getContentPane().add(em1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 150, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Email:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 80, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Username:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 80, 30));

        un1.setBackground(new java.awt.Color(153, 153, 0));
        un1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(un1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 150, 30));

        fn1.setBackground(new java.awt.Color(153, 153, 0));
        fn1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(fn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 150, 30));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setText("First Name:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 80, 30));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hala.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 390));

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CREATE USER FORM");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 780, 30));

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, 0, 940, 50));

        add.setBackground(new java.awt.Color(153, 102, 0));
        add.setText("ADD");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel6.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 90, -1));

        userupdate.setBackground(new java.awt.Color(153, 102, 0));
        userupdate.setText("UPDATE");
        userupdate.setEnabled(false);
        userupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userupdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userupdateMouseExited(evt);
            }
        });
        userupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userupdateActionPerformed(evt);
            }
        });
        jPanel6.add(userupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 90, -1));

        userdelete.setBackground(new java.awt.Color(153, 102, 0));
        userdelete.setText("DELETE");
        userdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userdeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userdeleteMouseExited(evt);
            }
        });
        userdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userdeleteActionPerformed(evt);
            }
        });
        jPanel6.add(userdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 90, -1));

        userclear.setBackground(new java.awt.Color(153, 102, 0));
        userclear.setText("CLEAR");
        userclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userclearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userclearMouseExited(evt);
            }
        });
        userclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userclearActionPerformed(evt);
            }
        });
        jPanel6.add(userclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 90, -1));

        usercancel.setBackground(new java.awt.Color(153, 102, 0));
        usercancel.setText("CANCEL");
        usercancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usercancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usercancelMouseExited(evt);
            }
        });
        usercancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usercancelActionPerformed(evt);
            }
        });
        jPanel6.add(usercancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 90, -1));

        userrefresh.setBackground(new java.awt.Color(153, 102, 0));
        userrefresh.setText("REFRESH");
        userrefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userrefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userrefreshMouseExited(evt);
            }
        });
        userrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userrefreshActionPerformed(evt);
            }
        });
        jPanel6.add(userrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 90, -1));

        ut1.setBackground(new java.awt.Color(153, 153, 0));
        ut1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        ut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ut1ActionPerformed(evt);
            }
        });
        jPanel6.add(ut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 150, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("User Type:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 80, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Password:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 80, 40));

        ps1.setBackground(new java.awt.Color(153, 153, 0));
        ps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ps1ActionPerformed(evt);
            }
        });
        jPanel6.add(ps1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 150, 40));

        cps1.setBackground(new java.awt.Color(153, 153, 0));
        cps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cps1ActionPerformed(evt);
            }
        });
        jPanel6.add(cps1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 150, 40));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Confirm Pass:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 100, 40));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Contact Num:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 100, 40));

        contact1.setBackground(new java.awt.Color(153, 153, 0));
        contact1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel6.add(contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 150, 40));

        us.setBackground(new java.awt.Color(153, 153, 0));
        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel6.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 150, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("User Status:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 90, 30));

        select.setText("SELECT");
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectMouseExited(evt);
            }
        });
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel6.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 80, -1));

        remove.setText("REMOVE");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeMouseExited(evt);
            }
        });
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel6.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 80, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 120));

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 110, 120));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IMAGE");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Questioner:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 264, 90, 20));
        jPanel6.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 140, 30));

        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favorite food?", "What is your favorite pet?", "Whats is your secret ability?", " " }));
        sq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqActionPerformed(evt);
            }
        });
        jPanel6.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 140, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed

    }//GEN-LAST:event_emActionPerformed

    private void cpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpsActionPerformed

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
    
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited

    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
      
    }//GEN-LAST:event_cancelActionPerformed

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
        add.setBackground(hovercolor);
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        add.setBackground(navcolor);
    }//GEN-LAST:event_registerMouseExited

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        
        if(fn1.getText().isEmpty()||ln1.getText().isEmpty()||em1.getText().isEmpty()
            ||contact1.getText().isEmpty()||ps1.getText().isEmpty()||cps1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"All fields are Required!");

        }else if(ps1.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Password should be 8 above!");
            ps1.setText("");
            cps1.setText("");
        }else if(!em1.getText().matches("^.+@.+..com")){
        JOptionPane.showMessageDialog(null,"Invalid Email format!");

        }else if(duplicateCheck()){
            System.out.println("Duplicate Exist!");

        }else{
            dbConnector dbc = new dbConnector();

            if(dbc.insertData("INSERT INTO tbl_user(u_fname,u_lname,u_type,u_email,u_username,u_contact,u_password,u_cpassword,u_status)"
                + "VALUES('"+fn1.getText()+"','"+ln1.getText()+"','"+ut1.getSelectedItem()+"','"+em1.getText()+"','"+un1.getText()+"','"+contact1.getText()+"','"+ps1.getText()+"','"+cps1.getText()+"','"+us.getSelectedItem()+"')"))
        {
            JOptionPane.showMessageDialog(null,"Inserted Successfully");
            usersForm uf = new usersForm();
            uf.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Connection Error!");
        }
        }

    }//GEN-LAST:event_registerActionPerformed

    private void em1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_em1ActionPerformed

    }//GEN-LAST:event_em1ActionPerformed

    private void cps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cps1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cps1ActionPerformed

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(hovercolor);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(navcolor);
    }//GEN-LAST:event_addMouseExited

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

       if (fn1.getText().isEmpty() || ln1.getText().isEmpty() || un1.getText().isEmpty() || em1.getText().isEmpty()
        || contact1.getText().isEmpty() || ps1.getText().isEmpty() || cps1.getText().isEmpty() || ans.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null, "All fields are required!");

} else if (!em1.getText().endsWith("@gmail.com")) {
    JOptionPane.showMessageDialog(null, "Invalid email format.");
    em1.setText("");

} else if (!contact1.getText().matches("\\d{11}")) {
    JOptionPane.showMessageDialog(null, "Contact number must contain only digits and be 11 digits long.");
    contact1.setText("");

} else if (ps1.getText().length() < 8) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
    ps1.setText("");
    cps1.setText("");

} else if (!ps1.getText().equals(cps1.getText())) {
    JOptionPane.showMessageDialog(null, "Passwords do not match.");
    ps1.setText("");
    cps1.setText("");

} else if (duplicateCheck()) {
    JOptionPane.showMessageDialog(null, "Duplicate record exists!");

} else {
    dbConnector dbc = new dbConnector();
    String hashedPassword = "";
    String hashedCPassword = "";
    String hashedAnswer = "";

    try {
        hashedPassword = passwordHasher.hashPassword(ps1.getText());
        hashedCPassword = passwordHasher.hashPassword(cps1.getText());
        hashedAnswer = passwordHasher.hashPassword(ans.getText());
    } catch (NoSuchAlgorithmException ex) {
        JOptionPane.showMessageDialog(null, "Hashing error: " + ex.getMessage());
        return;
    }

    String sql = "INSERT INTO tbl_user (u_fname, u_lname, u_type, u_email, u_username, u_contact, u_password, u_cpassword, u_status, u_image, u_question, u_answer) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        PreparedStatement pst = dbc.connect.prepareStatement(sql);
        pst.setString(1, fn1.getText());
        pst.setString(2, ln1.getText());
        pst.setString(3, ut1.getSelectedItem().toString());
        pst.setString(4, em1.getText());
        pst.setString(5, un1.getText());
        pst.setString(6, contact1.getText());
        pst.setString(7, hashedPassword);
        pst.setString(8, hashedCPassword);
        pst.setString(9, us.getSelectedItem().toString()); // status
        pst.setString(10, destination);                    // image path
        pst.setString(11, sq.getSelectedItem().toString()); // security question
        pst.setString(12, hashedAnswer);

        int inserted = pst.executeUpdate();

        if (inserted > 0) {
            try {
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Image save error: " + ex.getMessage());
                return;
            }

            JOptionPane.showMessageDialog(null, "Registration Success!");
            usersForm uf = new usersForm();
            uf.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Connection Error!");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
    }
}


    }//GEN-LAST:event_addActionPerformed

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDActionPerformed

    private void usercancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usercancelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_usercancelMouseEntered

    private void usercancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usercancelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_usercancelMouseExited

    private void usercancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usercancelActionPerformed
        usersForm urf = new usersForm();
        urf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_usercancelActionPerformed

    private void userupdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userupdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userupdateMouseEntered

    private void userupdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userupdateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userupdateMouseExited

    private void userupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userupdateActionPerformed
     if (fn1.getText().isEmpty() || ln1.getText().isEmpty() || em1.getText().isEmpty()
        || contact1.getText().isEmpty() || ps1.getText().isEmpty() || cps1.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null, "All fields are required!");

} else if (ps1.getText().length() < 8) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
    ps1.setText("");
    cps1.setText("");

} else if (!em1.getText().endsWith("@gmail.com")) {
    JOptionPane.showMessageDialog(null, "Invalid email format.");
    em1.setText("");

} else if (!isValidContactNumber(contact1.getText())) {
    JOptionPane.showMessageDialog(null, "Contact number must contain only digits and be 11 digits long.");
    contact1.setText("");

} else if (UpdateCheck()) {
    JOptionPane.showMessageDialog(null, "Duplicate record exists!");

} else {
    dbConnector dbc = new dbConnector();

    try {
        // Optional: You can hash passwords here if needed
        // String hashedPassword = passwordHasher.hashPassword(ps1.getText());

        String sql = "UPDATE tbl_user SET u_fname = ?, u_lname = ?, u_type = ?, u_email = ?, "
                   + "u_username = ?, u_contact = ?, u_password = ?, u_cpassword = ?, u_status = ?, u_image = ? "
                   + "WHERE u_id = ?";

        PreparedStatement pst = dbc.connect.prepareStatement(sql);
        pst.setString(1, fn1.getText());
        pst.setString(2, ln1.getText());
        pst.setString(3, ut.getSelectedItem().toString());
        pst.setString(4, em1.getText());
        pst.setString(5, un1.getText());
        pst.setString(6, contact1.getText());
        pst.setString(7, ps1.getText());  // Replace with hashedPassword if hashing
        pst.setString(8, cps1.getText());
        pst.setString(9, us.getSelectedItem().toString());
        pst.setString(10, destination);
        pst.setString(11, userID.getText());

        int updated = pst.executeUpdate();

        if (updated > 0) {
            // Handle image file updates
            if (destination.isEmpty()) {
                File existingFile = new File(oldpath);
                if (existingFile.exists()) {
                    existingFile.delete();
                }
            } else if (!oldpath.equals(path)) {
                imageUpdater(oldpath, path);
            }

            JOptionPane.showMessageDialog(null, "User updated successfully!");
            usersForm uf = new usersForm();
            uf.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Update failed!");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}
}
private boolean isValidContactNumber(String contact) {
    return contact.matches("\\d{11}");
    }//GEN-LAST:event_userupdateActionPerformed

    private void userrefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userrefreshMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userrefreshMouseEntered

    private void userrefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userrefreshMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userrefreshMouseExited

    private void userrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userrefreshActionPerformed
        
    }//GEN-LAST:event_userrefreshActionPerformed

    private void userclearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userclearMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userclearMouseEntered

    private void userclearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userclearMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userclearMouseExited

    private void userclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userclearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userclearActionPerformed

    private void userdeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userdeleteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userdeleteMouseEntered

    private void userdeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userdeleteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userdeleteMouseExited

    private void userdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userdeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this client?", 
                                            "Delete Confirmation", JOptionPane.YES_NO_OPTION);

if (confirm == JOptionPane.YES_OPTION) {
    dbConnector dbc = new dbConnector();

    try {
        String sql = "DELETE FROM tbl_user WHERE u_id = ?";
        PreparedStatement pst = dbc.connect.prepareStatement(sql);
        pst.setString(1, userID.getText()); // Make sure clientID holds the correct ID

        int deleted = pst.executeUpdate();

        if (deleted > 0) {
            JOptionPane.showMessageDialog(null, "Client deleted successfully!");

            usersForm cf = new usersForm();
            cf.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Delete failed. Record may not exist.");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}
    }//GEN-LAST:event_userdeleteActionPerformed

    private void ln1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ln1ActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
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
                              select.setEnabled(false);
                              remove.setEnabled(true);

                          }
                      } catch (Exception ex) {
                          System.out.println("File Error!");
                      }
                  }
    }//GEN-LAST:event_selectActionPerformed

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        select.setBackground(hovercolor);
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        select.setBackground(navcolor);
    }//GEN-LAST:event_selectMouseExited

    private void removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseEntered
        remove.setBackground(hovercolor);
    }//GEN-LAST:event_removeMouseEntered

    private void removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseExited
       remove.setBackground(navcolor);
    }//GEN-LAST:event_removeMouseExited

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
      remove.setEnabled(false);
      select.setEnabled(true);
      image.setIcon(null);
      destination = "";
      path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void ps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ps1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ps1ActionPerformed

    private void ut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ut1ActionPerformed
        
    }//GEN-LAST:event_ut1ActionPerformed

    private void sqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqActionPerformed

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JTextField ans;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField contact;
    public javax.swing.JTextField contact1;
    private javax.swing.JPasswordField cps;
    public javax.swing.JPasswordField cps1;
    private javax.swing.JTextField em;
    public javax.swing.JTextField em1;
    private javax.swing.JTextField fn;
    public javax.swing.JTextField fn1;
    public javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField ln;
    public javax.swing.JTextField ln1;
    private javax.swing.JPasswordField ps;
    public javax.swing.JPasswordField ps1;
    private javax.swing.JButton register;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    private javax.swing.JComboBox<String> sq;
    private javax.swing.JTextField un;
    public javax.swing.JTextField un1;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JTextField userID;
    private javax.swing.JButton usercancel;
    private javax.swing.JButton userclear;
    private javax.swing.JButton userdelete;
    private javax.swing.JButton userrefresh;
    public javax.swing.JButton userupdate;
    private javax.swing.JComboBox<String> ut;
    public javax.swing.JComboBox<String> ut1;
    // End of variables declaration//GEN-END:variables
}
