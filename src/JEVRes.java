
package project;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class JEVRes extends javax.swing.JFrame
{
    Connection con = null;
    Statement st = null;
    String evusrname;
    int jobid;
    
    public JEVRes(String evusrname)
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
            rs=con.createStatement().executeQuery("select * from job inner join evaluator on job.evaluator=evaluator.username "
                    + "inner join evaluation_process on evaluation_process.username_eval=evaluator.username and teliko_apotelesma is not null where username= '"+evusrname+"'");
            dat.clear();
  
            
            col.add("id");
            col.add("bathmos_synenteyxis");
            col.add("bathmos_report");
            col.add("bathmos_loipon");
            col.add("username_eval");
            col.add("username_emp");
            col.add("teliko_apotelesma");
          
         
            //dat.clear();
           while(rs.next())
           {
               txtev.setText(rs.getString("username_eval").trim());
               txtid.setText(rs.getString("id").trim());
               txtempl.setText(rs.getString("username_emp").trim());
          
                Vector v =new Vector();

                v.add(rs.getString("job_id").trim());
                v.add(rs.getString("bathmos_synenteyxis").trim());
                v.add(rs.getString("bathmos_report").trim());
                v.add(rs.getString("bathmos_loipon").trim());
                v.add(rs.getString("username_eval").trim());
                v.add(rs.getString("username_emp").trim());
                v.add(rs.getString("teliko_apotelesma").trim());
             

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

        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtev = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblevaluationresults = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtempl = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtid.setEditable(false);

        jLabel1.setText("JID");

        jLabel2.setText("Evaluator");

        txtev.setEditable(false);
        txtev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtevActionPerformed(evt);
            }
        });

        tblevaluationresults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "jid", "bs", "br", "bl", "eval", "empl", "teliko"
            }
        ));
        jScrollPane2.setViewportView(tblevaluationresults);

        jLabel3.setText("Employee");

        txtempl.setEditable(false);
        txtempl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemplActionPerformed(evt);
            }
        });

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtempl, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(txtev)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtempl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtevActionPerformed

    private void txtemplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemplActionPerformed
       
    }//GEN-LAST:event_txtemplActionPerformed

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblevaluationresults;
    private javax.swing.JTextField txtempl;
    private javax.swing.JTextField txtev;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
