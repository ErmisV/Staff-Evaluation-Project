
package project;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MOA_A extends javax.swing.JFrame
{
    Connection con = null;
    Statement st = null;
    String evusrname;
    int jobid;
    
    public MOA_A(String evusrname)
    {
        this.evusrname=evusrname;
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
           
            rs=con.createStatement().executeQuery("select username_eval,avg(teliko_apotelesma) as mo,manager.firm from manager,evaluator,evaluation_process \n" +
"where manager.firm=evaluator.firm and evaluation_process.username_eval=evaluator.username group by username_eval;");
           
                     
            dat.clear();
  
            
            col.add("Evaluator");
            col.add("Average of his/her Evaluations");
           
           while(rs.next())
           {
                Vector v =new Vector();
                System.out.println(rs.getString("mo").trim());

                v.add(rs.getString("username_eval").trim());
                v.add(rs.getString("mo").trim());
               

                dat.add(v);
            }
            tblevaluationresults.setModel(new DefaultTableModel(dat,col));
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblevaluationresults = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblevaluationresults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Evaluator", "Evaluation Average"
            }
        ));
        jScrollPane2.setViewportView(tblevaluationresults);
        if (tblevaluationresults.getColumnModel().getColumnCount() > 0) {
            tblevaluationresults.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) 
    {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblevaluationresults;
    // End of variables declaration//GEN-END:variables
}
