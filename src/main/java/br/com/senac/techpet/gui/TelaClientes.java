package br.com.senac.techpet.gui;

import br.com.senac.techpet.model.Cliente;
import br.com.senac.techpet.model.ClienteDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaClientes extends javax.swing.JFrame {

    private String nomeDono;
    private TelaCadastroPet tlCadastroPet;

    Cliente dono;

    public TelaClientes() {
        initComponents();

        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> clientes = clienteDao.listar();
        preencheTabela(clientes);

    }

    public void preencheTabela(List<Cliente> clientes) {
        String colunas[] = {"Id", "Nome", "Email", "Endereço", "Telefone"};
        String dados[][] = new String[clientes.size()][colunas.length];

        int i = 0;
        for (Cliente c : clientes) {
            dados[i] = new String[]{
                String.valueOf(c.getId()),
                c.getNome(),
                c.getEmail(),
                c.getEndereco(),
                c.getTelefone()
            };
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        tblClientes.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnCadastrarPet = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de Clientes");

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Email", "Endereço", "Telefone"
            }
        ));
        jScrollPane.setViewportView(tblClientes);

        btnCadastrarPet.setBackground(new java.awt.Color(111, 149, 112));
        btnCadastrarPet.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarPet.setText("Cadastrar Pet");
        btnCadastrarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPetActionPerformed(evt);
            }
        });

        btnExcluirCliente.setBackground(new java.awt.Color(111, 149, 112));
        btnExcluirCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirCliente.setText("Excluir");
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setBackground(new java.awt.Color(111, 149, 112));
        btnEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(111, 149, 112));
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnCadastrarPet)
                .addGap(177, 177, 177)
                .addComponent(btnExcluirCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(btnEditarCliente))
                .addGap(42, 42, 42))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarPet)
                    .addComponent(btnExcluirCliente)
                    .addComponent(btnEditarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
        try {
            if (tblClientes.getSelectedRow() >= 0) { 
                String id = (String) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0);
                
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir o registro " + id + "?");
                if (resposta == 0)
                {
                    //realizando a exclusão
                    ClienteDAO clienteDAO = new ClienteDAO();
                    clienteDAO.excluir(Integer.parseInt(id));
                    JOptionPane.showMessageDialog(this, "Registro excluído com sucesso");
                    List<Cliente> clientes = clienteDAO.listar();
                    preencheTabela(clientes);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }

    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void btnCadastrarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPetActionPerformed

        try {

            TelaCadastroPet cadastroPet = new TelaCadastroPet();

            if (tblClientes.getSelectedRow() >= 0) {
                String id = (String) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0);

                ClienteDAO clienteDao = new ClienteDAO();
                Cliente clienteSelecionado = clienteDao.obter(Integer.parseInt(id));

                cadastroPet.recebeDono(clienteSelecionado);
                cadastroPet.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Cliente/Dono para cadastrar seu pet.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }


    }//GEN-LAST:event_btnCadastrarPetActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        try {

            TelaCadastroCliente cadastro = new TelaCadastroCliente();

            if (tblClientes.getSelectedRow() >= 0) {
                String id = (String) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0);

                ClienteDAO clienteDao = new ClienteDAO();
                Cliente clienteSelecionado = clienteDao.obter(Integer.parseInt(id));
                
                dispose();
                cadastro.preencheEdicao(clienteSelecionado);
                cadastro.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Cliente para editar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarPet;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
