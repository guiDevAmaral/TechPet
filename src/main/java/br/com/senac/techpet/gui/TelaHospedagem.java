package br.com.senac.techpet.gui;

import br.com.senac.techpet.model.Hospedagem;
import br.com.senac.techpet.model.HospedagemDAO;
import br.com.senac.techpet.model.Pet;
import br.com.senac.techpet.model.PetDAO;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaHospedagem extends javax.swing.JFrame {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String nomePetSelecionado;
    private Hospedagem hospedagem;
    private Pet pet;
    
    

    public TelaHospedagem() {
        initComponents();

        HospedagemDAO hospedagemDAO = new HospedagemDAO();
        List<Hospedagem> hospedagens = hospedagemDAO.listar();
        preencheTabela(hospedagens);

    }

    public void preencheTabela(List<Hospedagem> hospedagens) {
        String colunas[] = {"Vaga", "Pet", "Entrada", "Saída"};
        String dados[][] = new String[hospedagens.size()][colunas.length];

        int i = 0;
        for (Hospedagem h : hospedagens) {
            dados[i] = new String[]{
                String.valueOf(h.getId()),
                h.getPetHospedado().getNome(),
                h.getHoraEntrada().format(formatter),
                h.getHoraSaida().format(formatter)

            };
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        tblHospedagem.setModel(model);
        lblQuantidadeHospedado.setText(String.valueOf(hospedagens.size()));
    }

    public void recebeHospedagem(Hospedagem hosp) {
        this.hospedagem = hosp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblHospedagem = new javax.swing.JTable();
        btnHospedarNovoPet = new javax.swing.JButton();
        btnDono = new javax.swing.JButton();
        btnFinalizarHospedagem = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lblLimiteMaxHosp = new javax.swing.JLabel();
        lblPetsHospedados = new javax.swing.JLabel();
        lblQuantidadeHospedado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hospedagem");

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

        tblHospedagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaga", "Pet", "Entrada", "Saida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane.setViewportView(tblHospedagem);

        btnHospedarNovoPet.setBackground(new java.awt.Color(111, 149, 112));
        btnHospedarNovoPet.setForeground(new java.awt.Color(255, 255, 255));
        btnHospedarNovoPet.setText("Hospedar novo pet");
        btnHospedarNovoPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospedarNovoPetActionPerformed(evt);
            }
        });

        btnDono.setBackground(new java.awt.Color(111, 149, 112));
        btnDono.setForeground(new java.awt.Color(255, 255, 255));
        btnDono.setText("Dono");
        btnDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonoActionPerformed(evt);
            }
        });

        btnFinalizarHospedagem.setBackground(new java.awt.Color(111, 149, 112));
        btnFinalizarHospedagem.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarHospedagem.setText("Finalizar hospedagem");
        btnFinalizarHospedagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarHospedagemActionPerformed(evt);
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

        lblLimiteMaxHosp.setText("Limite máximo de pets hospedados: 10");

        lblPetsHospedados.setText("Pets hospedados: ");

        jButton1.setBackground(new java.awt.Color(111, 149, 112));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(btnHospedarNovoPet)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizarHospedagem)
                        .addGap(18, 18, 18)
                        .addComponent(btnDono)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(175, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(lblLimiteMaxHosp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPetsHospedados)
                        .addGap(18, 18, 18)
                        .addComponent(lblQuantidadeHospedado)
                        .addGap(87, 87, 87))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLimiteMaxHosp)
                    .addComponent(lblPetsHospedados)
                    .addComponent(lblQuantidadeHospedado))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHospedarNovoPet)
                    .addComponent(btnFinalizarHospedagem)
                    .addComponent(btnDono)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
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

    private void btnDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonoActionPerformed
        if (tblHospedagem.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Pet");
        } else {
            nomePetSelecionado = (String) tblHospedagem.getValueAt(tblHospedagem.getSelectedRow(), 1);
            PetDAO pDAO = new PetDAO();
            List<Pet> listaPets = pDAO.listar();

            for (Pet c : listaPets) {
                if (c.getNome().equals(nomePetSelecionado)) {
                    pet = c;

                }

            }
            JOptionPane.showMessageDialog(null, "Nome do dono: " + pet.getDono().getNome()
                    + "\nTelefone: " + pet.getDono().getTelefone());

        }

    }//GEN-LAST:event_btnDonoActionPerformed

    private void btnHospedarNovoPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospedarNovoPetActionPerformed
        dispose();
        new TelaPets().setVisible(true);
    }//GEN-LAST:event_btnHospedarNovoPetActionPerformed

    private void btnFinalizarHospedagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarHospedagemActionPerformed
        if (tblHospedagem.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Pet ");
        } else {
            HospedagemDAO hDAO = new HospedagemDAO();
            List<Hospedagem> hospedagens = hDAO.listar();

            nomePetSelecionado = (String) tblHospedagem.getValueAt(tblHospedagem.getSelectedRow(), 1);

            for (Hospedagem h : hospedagens) {
                if (h.getPetHospedado().getNome().equals(nomePetSelecionado)) {
                    hospedagem = h;
                }
            }
            LocalTime horaSaida = LocalTime.now();
            LocalTime horaSaidaFormatado = horaSaida.withNano(0);
            horaSaida.format(formatter);

            hospedagem.setHoraSaida(horaSaidaFormatado);
            hDAO.atualizar(hospedagem);
            dispose();
            new TelaHospedagem().setVisible(true);
        }


    }//GEN-LAST:event_btnFinalizarHospedagemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tblHospedagem.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma hospedagem finalizada");
        } else {
            String[] options = {"Sim", "Não"};

            int deletar = JOptionPane.showOptionDialog(
                    rootPane,
                    "Tem certeza que deseja excluir esta hospedagem?",
                    "Fechamento da hospedagem",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (deletar == 0) {
                int certeza = JOptionPane.showOptionDialog(
                        rootPane,
                        "O cliente já realizou o pagamento ?",
                        "Fechamento da hospedagem",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );
                if (certeza == 0) {
                    HospedagemDAO hDAO = new HospedagemDAO();

                    String idHospedagemSelecionada = (String) tblHospedagem.getValueAt(tblHospedagem.getSelectedRow(), 0);

                    hDAO.excluir(Integer.parseInt(idHospedagemSelecionada));
                    dispose();
                    new TelaHospedagem().setVisible(true);
                }

            } else {

                tblHospedagem.clearSelection();
            }

        }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaHospedagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDono;
    private javax.swing.JButton btnFinalizarHospedagem;
    private javax.swing.JButton btnHospedarNovoPet;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblLimiteMaxHosp;
    private javax.swing.JLabel lblPetsHospedados;
    private javax.swing.JLabel lblQuantidadeHospedado;
    private javax.swing.JTable tblHospedagem;
    // End of variables declaration//GEN-END:variables
}
