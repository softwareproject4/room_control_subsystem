package com.upm.subsystem;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.upm.subsystem.model.GenericResponse;
import com.upm.subsystem.model.Light;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class LightController extends javax.swing.JFrame {

    /**
     * Creates new form LightController
     */
    public LightController() {
        initComponents();
        updateView();
    }

    public void updateView() {
        System.out.println("Update View Called");
      
         DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
         
        try {
            HttpResponse<GenericResponse> allLight = Unirest.get(Utility.url+"light/getAllLight")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asObject(GenericResponse.class);
            
             List  allLights=(List)allLight.getBody().getData();
             
               System.out.println("---- "+allLights.size());
               
               for (Object allLight1 : allLights) {
                   System.out.println("-------------- "+allLight1.toString());
                   HashMap<String,String> light=(HashMap<String,String>)allLight1;
                   System.out.println("---- "+light.get("deviceId"));
                 tableModel.addRow(new String[]{light.get("deviceId"),light.get("roomName"), light.get("lightType"), light.get("status"), light.get("time")});
                  
            }
                tableModel.fireTableDataChanged();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
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
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        switchOnBtn = new javax.swing.JButton();
        switchOffBtn = new javax.swing.JButton();
        removeLightBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Control Light");

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(0, 204, 51));
        addButton.setText("Add Light");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        switchOnBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        switchOnBtn.setForeground(new java.awt.Color(0, 102, 255));
        switchOnBtn.setText("Switch On Light");
        switchOnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchOnBtnActionPerformed(evt);
            }
        });

        switchOffBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        switchOffBtn.setForeground(new java.awt.Color(255, 153, 51));
        switchOffBtn.setText("Switch Off Light");
        switchOffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchOffBtnActionPerformed(evt);
            }
        });

        removeLightBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        removeLightBtn.setForeground(new java.awt.Color(255, 0, 0));
        removeLightBtn.setText("Remove Light");
        removeLightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeLightBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Device Id");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Room Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Light Type");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Status");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Night Bulb", "Tube Light", "Foot Light", "LED 10W", "LED 15W" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ON", "OFF" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox1, 0, 177, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(switchOnBtn)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(switchOffBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(removeLightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(switchOffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(switchOnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeLightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device ID", "Room Name", "Light Type", "Status", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        // Validation
        if(jTextField1.getText()== null || jTextField1.getText().isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Device Id can't be blank");
             return ;
        }
        
          if(jTextField2.getText()== null || jTextField2.getText().isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Room name can't be null");
             return ;
        }
        
        Light light = new Light();
        light.setDeviceId(jTextField1.getText());
        light.setLightType(jComboBox1.getSelectedItem().toString());
        light.setRoomName(jTextField2.getText());
        light.setStatus(jComboBox2.getSelectedItem().toString());
        light.setTime(new Date().toString());
        try {
            HttpResponse<GenericResponse> postResponse = Unirest.post(Utility.url+"light/addLight")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(light)
                    .asObject(GenericResponse.class);
            JOptionPane.showMessageDialog(rootPane, postResponse.getBody().getMessage());
           // Update row in table
           DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.addRow(new String[]{light.getDeviceId(),light.getRoomName(), light.getLightType(), light.getStatus(), light.getTime()});
           tableModel.fireTableDataChanged();     
           
            jTextField1.setText("");
           jTextField2.setText("");
           
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void switchOnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchOnBtnActionPerformed
        
          try {
                int rowIndex=jTable1.getSelectedRow();
                 DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
              String deviceId=(String) tableModel.getValueAt(rowIndex, 0);
              System.out.println("-- Device Id "+deviceId);
                        
            HttpResponse<GenericResponse> postResponse = Unirest.post(Utility.url+"light/switchOnLight/"+deviceId)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asObject(GenericResponse.class);
            JOptionPane.showMessageDialog(rootPane, postResponse.getBody().getMessage());
           // Update row in table
          tableModel.setValueAt("ON", rowIndex, 3);
          tableModel.fireTableDataChanged();
               
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
    }//GEN-LAST:event_switchOnBtnActionPerformed

    private void switchOffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchOffBtnActionPerformed
       try {
                int rowIndex=jTable1.getSelectedRow();
                 DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
              String deviceId=(String) tableModel.getValueAt(rowIndex, 0);
              System.out.println("-- Device Id "+deviceId);
                        
            HttpResponse<GenericResponse> postResponse = Unirest.post(Utility.url+"light/switchOffLight/"+deviceId)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asObject(GenericResponse.class);
            JOptionPane.showMessageDialog(rootPane, postResponse.getBody().getMessage());
           // Update row in table
          tableModel.setValueAt("OFF", rowIndex, 3);
          tableModel.fireTableDataChanged();
               
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_switchOffBtnActionPerformed

    private void removeLightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeLightBtnActionPerformed
        try {
                int rowIndex=jTable1.getSelectedRow();
                 DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
              String deviceId=(String) tableModel.getValueAt(rowIndex, 0);
              System.out.println("-- Device Id "+deviceId);
                        
            HttpResponse<GenericResponse> postResponse = Unirest.delete(Utility.url+"light/removeLight/"+deviceId)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asObject(GenericResponse.class);
            JOptionPane.showMessageDialog(rootPane, postResponse.getBody().getMessage());
           // Update row in table
         tableModel.removeRow(rowIndex);
          tableModel.fireTableDataChanged();
               
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_removeLightBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton removeLightBtn;
    private javax.swing.JButton switchOffBtn;
    private javax.swing.JButton switchOnBtn;
    // End of variables declaration//GEN-END:variables
}
