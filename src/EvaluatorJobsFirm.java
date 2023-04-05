
package project;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class EvaluatorJobsFirm extends javax.swing.JFrame
{
    Connection con = null;
    Statement st = null;
    String evusrname;
    String AFM;
    
    public EvaluatorJobsFirm(String evusrname)
    {
        this.evusrname=evusrname;
        this.AFM=JOptionPane.showInputDialog("Δώσε ΑΦΜ Εταιρείας");
        
        ResultSet rs = null;
        Vector dat= new Vector();
        Vector col= new Vector();
        
        ResultSet rs2 = null;
        Vector dat2= new Vector();
        Vector col2= new Vector();
       
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
         {     // where evaluator.username= '"+evusrname+"'"+" and job.id ='"+jobid+"'");
            //rs=con.createStatement().executeQuery("select * from job inner join evaluator on job.evaluator=evaluator.username where evaluator= "+evusrname+"'+'" and evaluator.firm ="'+evusrname);
            rs=con.createStatement().executeQuery("select * from job inner join evaluator on job.evaluator=evaluator.username where evaluator.username= '"+evusrname+"'"+" and evaluator.firm ='"+AFM+"'");

             
             dat.clear();
  
            col.add("Job Id");
            col.add("Salary");
            col.add("Position");
            col.add("Edra");
            col.add("announce_date");
            col.add("submission_date");
            col.add("start_date");
          
      
           while(rs.next())
           {
               txtev.setText(rs.getString("evaluator").trim());
               txtAFM.setText(this.AFM.toString());
          
                Vector v =new Vector();

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
       
       
         try
         {     
            rs=con.createStatement().executeQuery("select * from job inner join evaluator on job.evaluator=evaluator.username where evaluator.username <> '"+evusrname+"'"+" and evaluator.firm ='"+this.AFM+"'");
            dat2.clear();
         
            col2.add("Job Id");
            col2.add("Salary");
            col2.add("Position");
            col2.add("Edra");
            col2.add("announce_date");
            col2.add("submission_date");
            col2.add("start_date");
            col2.add("evaluator");
           
           while(rs.next())
           {
                Vector v2 =new Vector();
                

                v2.add(rs.getString("id").trim());
                v2.add(rs.getString("salary").trim());
                v2.add(rs.getString("position").trim());
                v2.add(rs.getString("edra").trim());
                v2.add(rs.getString("announce_date").trim());
                v2.add(rs.getString("submission_date").trim());
                v2.add(rs.getString("start_date").trim());
                v2.add(rs.getString("evaluator").trim());
               
                dat2.add(v2);
            }
            table2.setModel(new DefaultTableModel(dat2,col2));
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAFM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtev = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAFM.setEditable(false);

        jLabel1.setText("Firm");

        jLabel2.setText("Evaluator");

        txtev.setEditable(false);
        txtev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtevActionPerformed(evt);
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
        ));
        jScrollPane2.setViewportView(table1);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setEnabled(false);
        jScrollPane1.setViewportView(table2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47)
                                .addComponent(txtAFM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtev, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(383, 383, 383))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtAFM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtevActionPerformed
        
    }//GEN-LAST:event_txtevActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTextField txtAFM;
    private javax.swing.JTextField txtev;
    // End of variables declaration//GEN-END:variables
}
