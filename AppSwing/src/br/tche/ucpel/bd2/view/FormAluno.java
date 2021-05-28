package br.tche.ucpel.bd2.view;

import br.tche.ucpel.bd2.bean.Aluno;
import br.tche.ucpel.bd2.dao.AlunoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author owzi
 */
public class FormAluno extends javax.swing.JInternalFrame {

    private JFrame mdi;

    /**
     * Creates new form FormAluno
     *
     * @param mdi MDI principal.
     */
    public FormAluno(JFrame mdi) {
        this.mdi = mdi;
        initComponents();
        this.atualizaLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlunos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        bExcluir = new javax.swing.JButton();
        bLimpar = new javax.swing.JButton();
        bSlavar = new javax.swing.JButton();
        bAtualiza = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Aluno");

        tbAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "Data de Ingresso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAlunos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbAlunos);

        jLabel1.setText("Matricula");

        jLabel2.setText("Nome");

        jLabel3.setText("Data de ingresso");

        txtMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatriculaFocusLost(evt);
            }
        });
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        bSlavar.setText("Salvar");
        bSlavar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSlavarActionPerformed(evt);
            }
        });

        bAtualiza.setText("Atualizar");
        bAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bSlavar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bExcluir))
                            .addComponent(bAtualiza, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLimpar)
                    .addComponent(bExcluir)
                    .addComponent(bSlavar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAtualiza)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void bSlavarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSlavarActionPerformed
        try {
            AlunoDAO alunoDAO = new AlunoDAO(MDISistema.getConexao());
             int mat = this.intCampoTelas(this.txtMatricula.getText());
            // int cod = this.intCampoTelas(this.txtMatricula.getText());
            if (mat > 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Aluno aluno = new Aluno();
                aluno.setMatricula(mat);
                aluno.setNome(this.txtNome.getText());
                aluno.setDtIngresso(sdf.parse(this.txtDate.getText()));
                alunoDAO.update(aluno);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Aluno aluno = new Aluno();
                aluno.setNome(this.txtNome.getText());
                aluno.setDtIngresso(sdf.parse(this.txtDate.getText()));
                alunoDAO.create(aluno);
                this.txtMatricula.setText(Integer.toString(aluno.getMatricula()));
            }
            JOptionPane.showMessageDialog(this.mdi, "Registro Salvo");
            this.limpaTela();
            this.atualizaLista();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.mdi, String.format("Erro ao gravar Aluno3:%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormDepartamento.class.getName()).log(Level.WARNING, "Erro ao gravar Departamento", ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this.mdi, "Data inválida");   // TODO add your handling code here:
        }
    }//GEN-LAST:event_bSlavarActionPerformed

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
        this.limpaTela();
        this.txtMatricula.requestFocus();
    }//GEN-LAST:event_bLimparActionPerformed

    private void bAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtualizaActionPerformed
        this.atualizaLista();
    }//GEN-LAST:event_bAtualizaActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed

    }//GEN-LAST:event_bExcluirActionPerformed

    private void txtMatriculaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatriculaFocusLost
        // TODO add your handling code here:
        int matricula = this.intCampoTelas(this.txtMatricula.getText());
        if (matricula > 21020999) {
            Aluno aluno = new Aluno(matricula);
            
            boolean ret = this.preencheTela(aluno);
            if (!ret) {
                JOptionPane.showMessageDialog(this.mdi, "Matricula do Aluno não existe no sistema", "Aviso", JOptionPane.WARNING_MESSAGE);
                this.txtMatricula.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtMatriculaFocusLost

    private void atualizaLista() {
        try {
            AlunoDAO alunoDAO = new AlunoDAO(MDISistema.getConexao());
            List<Aluno> lista = alunoDAO.listaTodos();
            DefaultTableModel dtm = (DefaultTableModel) this.tbAlunos.getModel();
            dtm.setRowCount(0);
            for (Aluno aluno : lista) {
                dtm.addRow(new Object[]{aluno.getMatricula(), aluno.getNome(), aluno.getDtIngresso()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.mdi, String.format("Erro ao ler os Alunos:%s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormAluno.class.getName()).log(Level.WARNING, "Erro ao ler os Alunos", ex);
        }
    }

    private void limpaTela() {
        this.txtMatricula.setEnabled(true);
        this.txtNome.setText(null);
        this.txtDate.setText(null);
    }

    private boolean preencheTela(Aluno aluno) {
        boolean ret = false;
        try {
            AlunoDAO alunoDAO = new AlunoDAO(MDISistema.getConexao());
            aluno = alunoDAO.retrieve(aluno);
            if (aluno != null && aluno.getMatricula() > 0) {
                this.txtMatricula.setText(Integer.toString(aluno.getMatricula()));
                this.txtMatricula.setEnabled(false);
                this.txtNome.setText(aluno.getNome());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                this.txtDate.setText(sdf.format(aluno.getDtIngresso()));
                ret = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.mdi, String.format("Não foi possível carregar Aluno1: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FormAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtualiza;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bLimpar;
    private javax.swing.JButton bSlavar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAlunos;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private int intCampoTelas(String valor) {
        int ret = 0;
        try {
            ret = Integer.parseInt(valor);
        } catch (NumberFormatException ex) {
        }
        return ret;
    }
}
