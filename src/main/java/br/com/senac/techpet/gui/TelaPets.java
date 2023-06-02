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

public class TelaPets extends javax.swing.JFrame {

    private String nomePetSelecionado;
    private Pet pet;
    private TelaHospedagem tlHospedagem;

    public TelaPets() {
        initComponents();

        PetDAO petDao = new PetDAO();
        List<Pet> pets = petDao.listar();
        preencheTabela(pets);
    }

    public void preencheTabela(List<Pet> pets) {
        String colunas[] = {"Id", "Nome", "Espécie", "Idade", "Dono"};
        String dados[][] = new String[pets.size()][colunas.length];

        int i = 0;
        for (Pet p : pets) {
            dados[i] = new String[]{
                String.valueOf(p.getId()),
                p.getNome(),
                p.getEspecie(),
                p.getIdade(),
                p.getDono().getNome()

            };
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        tblPets.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBranco = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        btnHospedar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Pets");

        jPanelBranco.setBackground(new java.awt.Color(255, 255, 255));

        tblPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Espécie", "Idade", "Dono"
            }
        ));
        jScrollPane.setViewportView(tblPets);

        btnHospedar.setBackground(new java.awt.Color(111, 149, 112));
        btnHospedar.setForeground(new java.awt.Color(255, 255, 255));
        btnHospedar.setText("Hospedar");
        btnHospedar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospedarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(111, 149, 112));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelBrancoLayout = new javax.swing.GroupLayout(jPanelBranco);
        jPanelBranco.setLayout(jPanelBrancoLayout);
        jPanelBrancoLayout.setHorizontalGroup(
            jPanelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addGroup(jPanelBrancoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnHospedar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addGap(148, 148, 148)
                .addComponent(btnVoltar)
                .addGap(35, 35, 35))
        );
        jPanelBrancoLayout.setVerticalGroup(
            jPanelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBrancoLayout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanelBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHospedar)
                    .addComponent(btnExcluir)
                    .addComponent(btnVoltar))
                .addGap(0, 61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBranco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBranco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (tblPets.getSelectedRow() >= 0) {
                String id = (String) tblPets.getValueAt(tblPets.getSelectedRow(), 0);

                int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir o registro " + id + "?");
                if (resposta == 0) {
                    //realizando a exclusão
                    PetDAO petDAO = new PetDAO();
                    petDAO.excluir(Integer.parseInt(id));
                    JOptionPane.showMessageDialog(this, "Registro excluído com sucesso");
                    List<Pet> pets = petDAO.listar();
                    preencheTabela(pets);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um pet para excluir.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnHospedarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospedarActionPerformed
        PetDAO petDAO = new PetDAO();
        HospedagemDAO hospedagemDAO = new HospedagemDAO();

        try {
            if (tblPets.getSelectedRow() >= 0) {
                String id = (String) tblPets.getValueAt(tblPets.getSelectedRow(), 0);

                Pet petSelecionado = petDAO.obter(Integer.parseInt(id));

                int resposta = JOptionPane.showConfirmDialog(this, "Deseja hospedar o pet: " + petSelecionado.getNome() + "?");
                if (resposta == 0) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                    LocalTime horaEntrada = LocalTime.now();
                    LocalTime horaEntradaFormatado = horaEntrada.withNano(0);
                    horaEntrada.format(formatter);

                    LocalTime horaSaida = LocalTime.parse("00:00:00", formatter);
                    LocalTime horaSaidaFormatado = horaSaida.withNano(0);
                    horaSaida.format(formatter);

                    Hospedagem hospedagem = new Hospedagem();
                    hospedagem.setPetHospedado(petSelecionado);
                    hospedagem.setHoraEntrada(horaEntradaFormatado);
                    hospedagem.setHoraSaida(horaSaidaFormatado);

                    hospedagemDAO.cadastrarHospedagem(hospedagem);

                    tlHospedagem = new TelaHospedagem();
                    tlHospedagem.recebeHospedagem(hospedagem);
                    tlHospedagem.setVisible(true);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um pet para hospedar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }

        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            LocalTime horaEntrada = LocalTime.now();
            LocalTime horaEntradaFormatado = horaEntrada.withNano(0);
            horaEntrada.format(formatter);

            LocalTime horaSaida = LocalTime.parse("00:00:00", formatter);
            LocalTime horaSaidaFormatado = horaSaida.withNano(0);
            horaSaida.format(formatter);

            Hospedagem hospedagem = new Hospedagem();
            hospedagem.setPetHospedado(pet);
            hospedagem.setHoraEntrada(horaEntradaFormatado);
            hospedagem.setHoraSaida(horaSaidaFormatado);

            HospedagemDAO.adicionarHospedagem(hospedagem);

            tlHospedagem = new TelaHospedagem();
            tlHospedagem.recebeHospedagem(hospedagem);
            tlHospedagem.setVisible(true);

            dispose();
        }*/
    }//GEN-LAST:event_btnHospedarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnHospedar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanelBranco;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable tblPets;
    // End of variables declaration//GEN-END:variables
}
