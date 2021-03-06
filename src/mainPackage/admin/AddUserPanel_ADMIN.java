/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.admin;

import mainPackage.admin.AddBookPanel_ADMIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mainPackage.RegistrationPanel;

/**
 *
 * @author Windows8.1
 */
public class AddUserPanel_ADMIN extends javax.swing.JPanel {

    private final String DATABSE_URL = "jdbc:derby://localhost:1527/libraryDb";
    private final String username = "oracle";
    private final String password = "pass";
    private final String ADD_REC = "INSERT INTO ACCOUNTS VALUES(?, ?, ?, ?, ?, ?,0,NULL,?)";//Student Number,First Name,Last Name,Middle Name,Username,Password,Book id
    private final String CHECK_RECORDS = "SELECT * FROM ACCOUNTS WHERE STUDENT_NUMBER = ? OR USERNAME = ?";

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private ResultSetMetaData rsMetadata;

    public AddUserPanel_ADMIN() {
        initComponents();
        try {
            connection = DriverManager.getConnection(DATABSE_URL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(AddUserPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int checkRecords(String sNumber, String username) {

        int count = 0;

        try {
            statement = connection.prepareStatement(CHECK_RECORDS);
            statement.setString(1, sNumber);
            statement.setString(2, username);
            resultset = statement.executeQuery();

            while (resultset.next()) {
                count = count + 1;
            }

            if (count == 1) {

                return count;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddBookPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count = 0;

    }

    public void addRecord(String sNumber, String fName, String lName, String mName, String username, String password, String acct_status) {

        try {

            if (checkRecords(sNumber, username) >= 1) {

                JOptionPane.showMessageDialog(null, "Student Number OR Username already Exists!");
//                studIdField.setText("");
//                fNameField.setText("");
//                lNameField.setText("");
//                mNameField.setText("");
//                userNameField.setText("");
//                passwordField.setText("");

            } else {

                statement = connection.prepareStatement(ADD_REC);
                statement.setString(1, sNumber);
                statement.setString(2, fName);
                statement.setString(3, lName);
                statement.setString(4, mName);
                statement.setString(5, username);
                statement.setString(6, password);
                statement.setString(7, acct_status);

                String ADDQUERY = "INSERT INTO ACCOUNTS (STUDENT_NUMBER, FIRST_NAME, LAST_NAME, MIDDLE_NAME, USERNAME, PASSWORD) "
                        + "VALUES ("+sNumber+", '"+fName+"', '"+lName+"', '"+mName+"', '"+username+"', '"+password+"')";
                statement = connection.prepareStatement(ADDQUERY);
//                statement.setString(1, sNumber);
//                statement.setString(2, fName);
//                statement.setString(3, lName);
//                statement.setString(4, mName);
//                statement.setString(5, username);
//                statement.setString(6, password);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Account Created!");

                studIdField.setText("");
                fNameField.setText("");
                lNameField.setText("");
                mNameField.setText("");
                userNameField.setText("");
                passwordField.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        studIdField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fNameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mNameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("Create New Account");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel2.setText("Student ID:");

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel10.setText("Personal Information");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel3.setText("First Name:");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel5.setText("Last Name:");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel6.setText("Middle Name:");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel7.setText("Account Information");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel8.setText("Username:");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel9.setText("Password:");

        submitButton.setBackground(new java.awt.Color(102, 255, 102));
        submitButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        submitButton.setText("REGISTER");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(submitButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(mNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                                .addComponent(lNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fNameField, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                            .addComponent(jLabel9)
                                            .addComponent(passwordField)
                                            .addComponent(jLabel2)
                                            .addComponent(studIdField)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addGap(183, 183, 183)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        try {

            String studId = studIdField.getText();
            String fName = fNameField.getText();
            String lName = lNameField.getText();
            String mName = mNameField.getText();
            String username = userNameField.getText();
            String password = new String(passwordField.getPassword());

            if (studId.equals("") || fName.equals("") || lName.equals("") || mName.equals("") || username.equals("") || password.equals("")) {

                JOptionPane.showMessageDialog(null, "Please Fill out all the needed areas.");

            } else {
                addRecord(studId, fName, lName, mName, username, password, "ACTIVATED");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Fill up all the needed Areas.");
        }
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lNameField;
    private javax.swing.JTextField mNameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField studIdField;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
