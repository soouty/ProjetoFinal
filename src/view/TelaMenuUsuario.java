/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Vagas;
import model.dao.VagasDAO;

/**
 *
 * @author biela
 */
public class TelaMenuUsuario extends javax.swing.JFrame {



    /**
     * Creates new form TelaMenuUsuario
     */
    public TelaMenuUsuario() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTvagas.getModel();
        jTvagas.setRowSorter(new TableRowSorter(modelo));
        
        JTableVagas();
    }
    
    public void JTableVagas(){
       DefaultTableModel modelo = (DefaultTableModel) jTvagas.getModel();
       modelo.setNumRows(0);
       VagasDAO vdao = new VagasDAO();
        
       for(Vagas v: vdao.read()) {
            
           modelo.addRow(new Object[]{
               v.getEmpresa(),
               v.getVaga(),
               v.getDesc()
           
            });
        
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

        lblVagas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTvagas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Usuario");
        setResizable(false);
        getContentPane().setLayout(null);

        lblVagas.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblVagas.setForeground(new java.awt.Color(66, 141, 255));
        lblVagas.setText("VAGAS");
        getContentPane().add(lblVagas);
        lblVagas.setBounds(330, 60, 130, 48);

        jTvagas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTvagas.setForeground(new java.awt.Color(66, 141, 255));
        jTvagas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Empresa", "Vagas", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTvagas.setRowHeight(30);
        jTvagas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTvagasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTvagas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 180, 820, 290);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(66, 141, 255));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(700, 30, 75, 23);

        setSize(new java.awt.Dimension(823, 478));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTvagasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTvagasMouseClicked
        TelaEnviarCurriculo tela = new TelaEnviarCurriculo();
        tela.setVisible(true);
        
    }//GEN-LAST:event_jTvagasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        TelaLoginUsuario tela = new TelaLoginUsuario();
        tela.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
   
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTvagas;
    private javax.swing.JLabel lblVagas;
    // End of variables declaration//GEN-END:variables
}