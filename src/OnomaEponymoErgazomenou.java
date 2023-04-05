
package project;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;


public class OnomaEponymoErgazomenou extends javax.swing.JFrame 
{
    Connection con = null;
    Statement st = null;
    String eusrname;
    String name,surname;
     
    
    public OnomaEponymoErgazomenou(String eusrname) 
    {
        this.eusrname=eusrname;
        name=JOptionPane.showInputDialog("Δώσε Όνομα employee");
        surname=JOptionPane.showInputDialog("Δώσε Επώνυμο employee");
       
        ResultSet rs = null;
        ResultSet rs2 = null;
        Vector dat= new Vector();
        Vector col= new Vector();
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
         {     
            rs=con.createStatement().executeQuery("select name,surname,aa_aitisis from employee inner join user on "
                    + " employee.username=user.username inner join ypoboli_aitiseon on "
                    + " eusername=employee.username inner join manager on manager.firm=employee.firm and "
                    + " manager.managerusername= '"+eusrname+"'"+" and user.name='"+name+"'"+"and user.surname='"+surname+"'");
            dat.clear();
              
            col.add("Όνομα");
            col.add("Επώνυμο");
            col.add("Α/Α Αίτησης");
          
           while(rs.next())
           {
                 Vector v =new Vector();

                v.add(rs.getString("name").trim());
                v.add(rs.getString("surname").trim());
                v.add(rs.getString("aa_aitisis").trim());
           
                dat.add(v);
            }
            jTable1.setModel(new DefaultTableModel(dat,col));
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         
         try
         {     
            rs2=con.createStatement().executeQuery("select distinct aa,job_id,username_eval,username_emp,name,surname,"
                    + "teliko_apotelesma,evaluation_process.job_id,username_eval,username_emp,"
                    + "bathmos_synenteyxis,bathmos_report,bathmos_loipon from employee inner join"
                    + " user on employee.username=user.username inner join manager on manager.firm=employee.firm inner join"
                    + " evaluation_process on evaluation_process.username_eval=managerusername and teliko_apotelesma is not null and user.name='"+name+"'"+" and user.surname='"+surname+"'");
            dat2.clear();
         
           
            col2.add("Όνομα");
            col2.add("Επώνυμο");
            col2.add("Α/Α");
            col2.add("JOB ID");
            col2.add("Evaluator");
            col2.add("Υπάλληλος");
            col2.add("Τελικό Αποτέλεσμα");
          
         
           while(rs2.next())
           {
                Vector v2 =new Vector();

                v2.add(rs2.getString("name").trim());
                v2.add(rs2.getString("surname").trim());
                v2.add(rs2.getString("aa").trim());
                v2.add(rs2.getString("job_id").trim());
                v2.add(rs2.getString("username_eval").trim());
                v2.add(rs2.getString("username_emp").trim());
                v2.add(rs2.getString("teliko_apotelesma").trim());
               
                dat2.add(v2);
            }
            jTable2.setModel(new DefaultTableModel(dat2,col2));
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Show/Change Employe Portfolio");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(330, 330, 330))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false); 
        dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    public void theQuery(String query)
    {
       con = null;
       st = null;
      
      try
      {
          con = DriverManager.getConnection("jdbc:mysql://localhost/staffevaluation","root","");
          st = con.createStatement();
          st.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Η τροποποίηση του φακέλου του Employee έγινε επιτυχώς");
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
    }
    
    
   
    public static void main(String args[]) 
    {
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
