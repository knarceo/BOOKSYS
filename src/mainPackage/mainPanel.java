/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.awt.BorderLayout;

/**
 *
 * @author Windows8.1
 */
public class mainPanel extends javax.swing.JPanel {

    public mainPanel() {
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

        loginButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        loginButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        applyButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        applyButton.setText("Apply For Card");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setText("WELCOME TO OUR LIBRARY SYSTEM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addGap(101, 101, 101)
                .addComponent(applyButton)
                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(loginButton))
                .addContainerGap(174, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        mainFrame.mainPanel.removeAll();
        mainFrame.mainPanel.setVisible(false);
        mainFrame.mainPanel.setLayout(new BorderLayout());
        mainFrame.mainPanel.add(new loginPanel(), BorderLayout.CENTER);
        mainFrame.mainPanel.repaint();
        mainFrame.mainPanel.setVisible(true);

    }//GEN-LAST:event_loginButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed

        mainFrame.mainPanel.removeAll();
        mainFrame.mainPanel.setVisible(false);
        mainFrame.mainPanel.setLayout(new BorderLayout());
        mainFrame.mainPanel.add(new applyPanel(), BorderLayout.CENTER);
        mainFrame.mainPanel.repaint();
        mainFrame.mainPanel.setVisible(true);

    }//GEN-LAST:event_applyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables
}
