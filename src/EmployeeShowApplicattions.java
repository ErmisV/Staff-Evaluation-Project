
package project;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class EmployeeShowApplicattions extends javax.swing.JFrame
{
    Connection con = null;
    Statement st = null;
    String empusrname;
    int jobid;
    
    public EmployeeShowApplicattions(String empusrname)
    {
        this.empusrname=empusrname;
        
        ResultSet rs = null;
        Vector dat= new Vector();
        Vector col= new Vector();
          
        initComponents();
        
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/staffevaluation","root","");
            st = con.createStatement();
            
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
        try
         {     
            rs=con.createStatement().executeQuery("select * from  ypoboli_aitiseon inner join job on job_id=id inner join employee on eusername=username where eusername= '"+empusrname+"'");
            dat.clear();
  
            
            col.add("A/A Aitisis");
            col.add("Job ID");
            col.add("Salary");
            col.add("Position");
            col.add("Edra");
            col.add("announce_date");
            col.add("submission_date");
            col.add("start_date");
          
      
           while(rs.next())
           {
               txtem.setText(rs.getString("eusername").trim());
             
                Vector v =new Vector();

                v.add(rs.getString("aa_aitisis").trim());
                v.add(rs.getString("id").trim());
                v.add(rs.getString("salary").trim());
                v.add(rs.getString("position").trim());
                v.add(rs.getString("edra").trim());
                v.add(rs.getString("announce_date").trim());
                v.add(rs.getString("submission_date").trim());
                v.add(rs.getString("start_date").trim());
                dat.add(v);
            }
            table1.setModel(new DefaultTableModel(dat,col));
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Υπάλληλος");

        txtem.setEditable(false);
        txtem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "jid", "salary", "postion", "edra", "announce_date", "sumission_date", "start_date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table1.setEnabled(false);
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Εμφάνιση Υποβληθέντων Αιτήσεων");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(txtem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public boolean isCellEditable(int row, int column) {
        return column == 1 || column==5  ? false : true;
    }
  
    private void txtemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemActionPerformed
        
    }//GEN-LAST:event_txtemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false); 
        dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) 
    {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtem;
    // End of variables declaration//GEN-END:variables
}
