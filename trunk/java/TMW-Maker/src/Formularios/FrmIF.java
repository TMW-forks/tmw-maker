/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmIF.java
 *
 * Created on Apr 16, 2010, 8:28:43 PM
 */

package Formularios;

import Classes.Dados_Item;
import Classes.ImagemTratavel;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 *
 * @author indigovox
 */
public class FrmIF extends javax.swing.JDialog {

    /** Creates new form FrmIF */
    public FrmIF(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void MudarTipo(){
        if(OptCondicaoDeVariavel.isSelected()){
            CmbCondicaoDeVariavelValor1.setEnabled(true);
            CmbCondicaoDeVariavelComparador.setEnabled(true);
            CmbCondicaoDeVariavelValor2.setEnabled(true);
        }else{
            CmbCondicaoDeVariavelValor1.setEnabled(false);
            CmbCondicaoDeVariavelComparador.setEnabled(false);
            CmbCondicaoDeVariavelValor2.setEnabled(false);
            ChkCondicaoDeVariavelSeTextual1.setEnabled(false);
            ChkCondicaoDeVariavelSeTextual2.setEnabled(false);
        }

        if(OptCondicaoDeItem.isSelected()){
            CmbCondicaoDeItemID.setEnabled(true);
            LblItem.setEnabled(true);
            CmbCondicaoDeItemComparador.setEnabled(true);
            SpnCondicaoDeItemValor.setEnabled(true);
        }else{
            CmbCondicaoDeItemID.setEnabled(false);
            LblItem.setEnabled(false);
            CmbCondicaoDeItemComparador.setEnabled(false);
            SpnCondicaoDeItemValor.setEnabled(false);
        }

        if(OptCondicaoPersonalizada.isSelected()){
            TxtCondicaoPersonalizada.setEnabled(true);
            TxtCondicaoPersonalizada.setBackground(java.awt.SystemColor.text);
            BtnAddE.setEnabled(true);
            BtnAddOU.setEnabled(true);
        }else{
            TxtCondicaoPersonalizada.setEnabled(false);
            TxtCondicaoPersonalizada.setBackground(java.awt.SystemColor.window);
            BtnAddE.setEnabled(false);
            BtnAddOU.setEnabled(false);
        }

        AtualizarCodigo();
    }
    public void AtualizarCodigo(){
        if(OptCondicaoDeVariavel.isSelected()){
            try {
                String Editado=CmbCondicaoDeVariavelValor1.getEditor().getItem().toString();
                String Selecionado=CmbCondicaoDeVariavelValor1.getItemAt(CmbCondicaoDeVariavelValor1.getSelectedIndex()).toString();
                if(!Editado.equals(Selecionado)){
                    ChkCondicaoDeVariavelSeTextual1.setEnabled(true);
                }else{
                    ChkCondicaoDeVariavelSeTextual1.setSelected(false);
                    ChkCondicaoDeVariavelSeTextual1.setEnabled(false);
                }
            } catch (Exception e) {
                ChkCondicaoDeVariavelSeTextual1.setEnabled(true);
            }

            try {
                String Editado=CmbCondicaoDeVariavelValor2.getEditor().getItem().toString();
                String Selecionado=CmbCondicaoDeVariavelValor2.getItemAt(CmbCondicaoDeVariavelValor2.getSelectedIndex()).toString();
                if(!Editado.equals(Selecionado)){
                    ChkCondicaoDeVariavelSeTextual2.setEnabled(true);
                }else{
                    ChkCondicaoDeVariavelSeTextual2.setSelected(false);
                    ChkCondicaoDeVariavelSeTextual2.setEnabled(false);
                }
            } catch (Exception e) {
                ChkCondicaoDeVariavelSeTextual2.setEnabled(true);
            }
            

            TxtResultado.setText("if("+
                (ChkCondicaoDeVariavelSeTextual1.isSelected()?"\"":"")+
                CmbCondicaoDeVariavelValor1.getEditor().getItem().toString()+
                (ChkCondicaoDeVariavelSeTextual1.isSelected()?"\"":"")+
                CmbCondicaoDeVariavelComparador.getItemAt(CmbCondicaoDeVariavelComparador.getSelectedIndex()) +
                (ChkCondicaoDeVariavelSeTextual2.isSelected()?"\"":"")+
                CmbCondicaoDeVariavelValor2.getEditor().getItem().toString()+
                (ChkCondicaoDeVariavelSeTextual2.isSelected()?"\"":"")+
            ")");
            //TxtResultado.setText(TxtResultado.getText()+"[*]");
        }else if(OptCondicaoDeItem.isSelected()){
            String ID =CmbCondicaoDeItemID.getItemAt(CmbCondicaoDeItemID.getSelectedIndex()).toString();
            TxtResultado.setText("if("+
                "countitem("+
                    ID.substring(0, 4) +
                ")"+
                CmbCondicaoDeItemComparador.getItemAt(CmbCondicaoDeItemComparador.getSelectedIndex()) +
                SpnCondicaoDeItemValor.getValue()+
            ")");
        }else if(OptCondicaoPersonalizada.isSelected()){
            String ID =CmbCondicaoDeItemID.getItemAt(CmbCondicaoDeItemID.getSelectedIndex()).toString();
            TxtResultado.setText("if("+
                TxtCondicaoPersonalizada.getText()+
            ")");
        }
        BtnAdicionar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoTipoDeCondicao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        CmbCondicaoDeVariavelValor1 = new javax.swing.JComboBox();
        OptCondicaoDeVariavel = new javax.swing.JRadioButton();
        ChkCondicaoDeVariavelSeTextual2 = new javax.swing.JCheckBox();
        CmbCondicaoDeVariavelValor2 = new javax.swing.JComboBox();
        CmbCondicaoDeVariavelComparador = new javax.swing.JComboBox();
        ChkCondicaoDeVariavelSeTextual1 = new javax.swing.JCheckBox();
        BtnFechar = new javax.swing.JButton();
        BtnAdicionar = new javax.swing.JButton();
        TxtResultado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        OptCondicaoPersonalizada = new javax.swing.JRadioButton();
        TxtCondicaoPersonalizada = new javax.swing.JTextField();
        BtnAddE = new javax.swing.JButton();
        BtnAddOU = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        OptCondicaoDeItem = new javax.swing.JRadioButton();
        LblItem = new javax.swing.JLabel();
        CmbCondicaoDeItemID = new javax.swing.JComboBox();
        CmbCondicaoDeItemComparador = new javax.swing.JComboBox();
        SpnCondicaoDeItemValor = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comando [IF]");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CmbCondicaoDeVariavelValor1.setEditable(true);
        CmbCondicaoDeVariavelValor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "StatusPoint", "BaseLevel", "SkillPoint", "Class", "Upper", "Zeny", "Sex", "Weight", "MaxWeight", "JobLevel", "BaseExp", "NextBaseExp", "NextJobExp", "Hp", "MaxHp", "Sp", "MaxSp", "BaseJob" }));
        CmbCondicaoDeVariavelValor1.setSelectedIndex(13);
        CmbCondicaoDeVariavelValor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCondicaoDeVariavelValor1ActionPerformed(evt);
            }
        });

        GrupoTipoDeCondicao.add(OptCondicaoDeVariavel);
        OptCondicaoDeVariavel.setSelected(true);
        OptCondicaoDeVariavel.setText("De Variável:");
        OptCondicaoDeVariavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptCondicaoDeVariavelActionPerformed(evt);
            }
        });

        ChkCondicaoDeVariavelSeTextual2.setText("Dado Textual");
        ChkCondicaoDeVariavelSeTextual2.setEnabled(false);
        ChkCondicaoDeVariavelSeTextual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkCondicaoDeVariavelSeTextual2ActionPerformed(evt);
            }
        });

        CmbCondicaoDeVariavelValor2.setEditable(true);
        CmbCondicaoDeVariavelValor2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "StatusPoint", "BaseLevel", "SkillPoint", "Class", "Upper", "Zeny", "Sex", "Weight", "MaxWeight", "JobLevel", "BaseExp", "NextBaseExp", "NextJobExp", "Hp", "MaxHp", "Sp", "MaxSp", "BaseJob" }));
        CmbCondicaoDeVariavelValor2.setSelectedIndex(14);
        CmbCondicaoDeVariavelValor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCondicaoDeVariavelValor2ActionPerformed(evt);
            }
        });

        CmbCondicaoDeVariavelComparador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "==", "!=", ">=", "<=", ">", "<" }));
        CmbCondicaoDeVariavelComparador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCondicaoDeVariavelComparadorActionPerformed(evt);
            }
        });

        ChkCondicaoDeVariavelSeTextual1.setText("Dado Textual");
        ChkCondicaoDeVariavelSeTextual1.setEnabled(false);
        ChkCondicaoDeVariavelSeTextual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkCondicaoDeVariavelSeTextual1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OptCondicaoDeVariavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CmbCondicaoDeVariavelValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CmbCondicaoDeVariavelComparador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ChkCondicaoDeVariavelSeTextual1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChkCondicaoDeVariavelSeTextual2)
                    .addComponent(CmbCondicaoDeVariavelValor2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 229, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptCondicaoDeVariavel)
                    .addComponent(CmbCondicaoDeVariavelValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbCondicaoDeVariavelValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbCondicaoDeVariavelComparador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkCondicaoDeVariavelSeTextual2)
                    .addComponent(ChkCondicaoDeVariavelSeTextual1)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbCondicaoDeVariavelValor1, CmbCondicaoDeVariavelValor2});

        BtnFechar.setMnemonic('F');
        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        BtnAdicionar.setMnemonic('A');
        BtnAdicionar.setText("Adicionar");
        BtnAdicionar.setEnabled(false);
        BtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdicionarActionPerformed(evt);
            }
        });

        TxtResultado.setEditable(false);
        TxtResultado.setFont(new java.awt.Font("Monospaced", 0, 13));
        TxtResultado.setForeground(java.awt.Color.blue);
        TxtResultado.setText("if(\"\"==\"\")");
        TxtResultado.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        GrupoTipoDeCondicao.add(OptCondicaoPersonalizada);
        OptCondicaoPersonalizada.setText("Personalizada:");
        OptCondicaoPersonalizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptCondicaoPersonalizadaActionPerformed(evt);
            }
        });

        TxtCondicaoPersonalizada.setText("countitem(3017)>=10 && Zeny>=100000");
        TxtCondicaoPersonalizada.setEnabled(false);

        BtnAddE.setText("&&");
        BtnAddE.setEnabled(false);
        BtnAddE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddEActionPerformed(evt);
            }
        });

        BtnAddOU.setText("||");
        BtnAddOU.setEnabled(false);
        BtnAddOU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddOUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OptCondicaoPersonalizada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtCondicaoPersonalizada, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAddE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAddOU, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnAddE, BtnAddOU});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptCondicaoPersonalizada)
                    .addComponent(TxtCondicaoPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAddOU)
                    .addComponent(BtnAddE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnAddE, BtnAddOU, TxtCondicaoPersonalizada});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        GrupoTipoDeCondicao.add(OptCondicaoDeItem);
        OptCondicaoDeItem.setText("De Item:");
        OptCondicaoDeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptCondicaoDeItemActionPerformed(evt);
            }
        });

        LblItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))); // NOI18N
        LblItem.setEnabled(false);

        CmbCondicaoDeItemID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3064: Gema de Diamante", "3024: Veneno de Ninfas", "3017: Colar Horcrux (Alma de Fada)" }));
        CmbCondicaoDeItemID.setSelectedIndex(2);
        CmbCondicaoDeItemID.setEnabled(false);
        CmbCondicaoDeItemID.setOpaque(false);
        CmbCondicaoDeItemID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCondicaoDeItemIDActionPerformed(evt);
            }
        });

        CmbCondicaoDeItemComparador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "==", "!=", ">=", "<=", ">", "<" }));
        CmbCondicaoDeItemComparador.setSelectedIndex(2);
        CmbCondicaoDeItemComparador.setEnabled(false);
        CmbCondicaoDeItemComparador.setOpaque(false);
        CmbCondicaoDeItemComparador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCondicaoDeItemComparadorActionPerformed(evt);
            }
        });

        SpnCondicaoDeItemValor.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1)));
        SpnCondicaoDeItemValor.setEnabled(false);
        SpnCondicaoDeItemValor.setOpaque(false);
        SpnCondicaoDeItemValor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpnCondicaoDeItemValorStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OptCondicaoDeItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblItem)
                .addGap(18, 18, 18)
                .addComponent(CmbCondicaoDeItemID, 0, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbCondicaoDeItemComparador, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpnCondicaoDeItemValor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(OptCondicaoDeItem)
                    .addComponent(LblItem)
                    .addComponent(CmbCondicaoDeItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbCondicaoDeItemComparador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpnCondicaoDeItemValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbCondicaoDeItemComparador, CmbCondicaoDeItemID, SpnCondicaoDeItemValor});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(TxtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnAdicionar, BtnFechar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnFechar)
                    .addComponent(BtnAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnAdicionar, BtnFechar, TxtResultado});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed
    private void CmbCondicaoDeVariavelValor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCondicaoDeVariavelValor1ActionPerformed
        AtualizarCodigo();
    }//GEN-LAST:event_CmbCondicaoDeVariavelValor1ActionPerformed
    private void ChkCondicaoDeVariavelSeTextual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkCondicaoDeVariavelSeTextual1ActionPerformed
        AtualizarCodigo();
    }//GEN-LAST:event_ChkCondicaoDeVariavelSeTextual1ActionPerformed
    private void CmbCondicaoDeVariavelComparadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCondicaoDeVariavelComparadorActionPerformed
        AtualizarCodigo();
    }//GEN-LAST:event_CmbCondicaoDeVariavelComparadorActionPerformed
    private void CmbCondicaoDeVariavelValor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCondicaoDeVariavelValor2ActionPerformed
        AtualizarCodigo();
    }//GEN-LAST:event_CmbCondicaoDeVariavelValor2ActionPerformed
    private void ChkCondicaoDeVariavelSeTextual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkCondicaoDeVariavelSeTextual2ActionPerformed
        AtualizarCodigo();
    }//GEN-LAST:event_ChkCondicaoDeVariavelSeTextual2ActionPerformed
    private void OptCondicaoDeVariavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptCondicaoDeVariavelActionPerformed
        MudarTipo();
    }//GEN-LAST:event_OptCondicaoDeVariavelActionPerformed
    private void OptCondicaoDeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptCondicaoDeItemActionPerformed
        MudarTipo();
    }//GEN-LAST:event_OptCondicaoDeItemActionPerformed
    private void OptCondicaoPersonalizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptCondicaoPersonalizadaActionPerformed
        MudarTipo();
    }//GEN-LAST:event_OptCondicaoPersonalizadaActionPerformed
    private void CmbCondicaoDeItemIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCondicaoDeItemIDActionPerformed
        /*String Selecionado=CmbCondicaoDeItemID.getItemAt(CmbCondicaoDeItemID.getSelectedIndex()).toString();
        String Partes[] = Selecionado.split(":");
        if(Partes.length>=2){
            Dados_Item Item = FrmPrincipal.Itens.getItemPorID(Integer.parseInt(Partes[0]));
            LblItem.setIcon(new javax.swing.ImageIcon(Item.getIconeImagem()));
            LblItem.setToolTipText("<html><font size=\"+1\">"+
                "<b>Nome(ID:"+Item.getID()+"):</b> " + Item.getNomeTitulo()+"<br/>"+
                "<b>Imagem:</b> " + Item.getIconePNG()+"?cor="+Item.getIconeCor()+" ("+Item.getIconeImagem().getWidth()+"x"+Item.getIconeImagem().getHeight()+"px)"+"<br/>"+
                "<b>Descrição:</b> " + Item.getDescricao()+"<br/>"
            );
        }else{
            LblItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icone4.png")));
            LblItem.setToolTipText(null);
        }/**/
        Dados_Item Item = FrmPrincipal.Itens.getItemPorOrdem(CmbCondicaoDeItemID.getSelectedIndex());
        LblItem.setIcon(new javax.swing.ImageIcon(Item.getIconeImagem()));
        LblItem.setToolTipText("<html><font size=\"+1\">"+
            "<b>Nome(ID:"+Item.getID()+"):</b> " + Item.getNomeTitulo()+"<br/>"+
            "<b>Imagem:</b> " + Item.getIconePNG()+"?cor="+Item.getIconeCor()+" ("+Item.getIconeImagem().getWidth()+"x"+Item.getIconeImagem().getHeight()+"px)"+"<br/>"+
            "<b>Descrição:</b> " + Item.getDescricao()+"<br/>"
        );


        AtualizarCodigo();
    }//GEN-LAST:event_CmbCondicaoDeItemIDActionPerformed
    private void CmbCondicaoDeItemComparadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCondicaoDeItemComparadorActionPerformed
        AtualizarCodigo();
    }//GEN-LAST:event_CmbCondicaoDeItemComparadorActionPerformed
    private void SpnCondicaoDeItemValorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpnCondicaoDeItemValorStateChanged
        AtualizarCodigo();
    }//GEN-LAST:event_SpnCondicaoDeItemValorStateChanged
    private void BtnAddEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddEActionPerformed
        TxtCondicaoPersonalizada.setText(TxtCondicaoPersonalizada.getText()+" && ");
    }//GEN-LAST:event_BtnAddEActionPerformed
    private void BtnAddOUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddOUActionPerformed
        TxtCondicaoPersonalizada.setText(TxtCondicaoPersonalizada.getText()+" || ");
    }//GEN-LAST:event_BtnAddOUActionPerformed
    private void BtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAdicionarActionPerformed
        String Conteudo=FrmPalco.TxtScriptPalco.getText();
        String TxtInicio=Conteudo.substring(0,FrmPalco.TxtScriptPalco.getSelectionStart());
        String TxtFinal=Conteudo.substring(FrmPalco.TxtScriptPalco.getSelectionStart(),FrmPalco.TxtScriptPalco.getText().length());
        FrmPalco.TxtScriptPalco.setText(TxtInicio+TxtResultado.getText()+TxtFinal+" ");
        dispose();
    }//GEN-LAST:event_BtnAdicionarActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Vector Itens = new Vector();
        for(int i=0;i<FrmPrincipal.Itens.getContItens();i++){
            if(i==0){
                Dados_Item Item = FrmPrincipal.Itens.getItemPorOrdem(i);
                LblItem.setIcon(new javax.swing.ImageIcon(Item.getIconeImagem()));
                LblItem.setToolTipText("<html><font size=\"+1\">"+
                    "<b>Nome(ID:"+Item.getID()+"):</b> " + Item.getNomeTitulo()+"<br/>"+
                    "<b>Imagem:</b> " + Item.getIconePNG()+"?cor="+Item.getIconeCor()+" ("+Item.getIconeImagem().getWidth()+"x"+Item.getIconeImagem().getHeight()+"px)"+"<br/>"+
                    "<b>Descrição:</b> " + Item.getDescricao()+"<br/>"
                );
            }
            Itens.add(FrmPrincipal.Itens.getItemPorOrdem(i).getID()+": "+FrmPrincipal.Itens.getItemPorOrdem(i).getNomeTitulo());
        }
        //if(Itens.capacity()>=1)
        CmbCondicaoDeItemID.setModel(new javax.swing.DefaultComboBoxModel(Itens));
        AtualizarCodigo();
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmIF dialog = new FrmIF(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddE;
    private javax.swing.JButton BtnAddOU;
    private javax.swing.JButton BtnAdicionar;
    private javax.swing.JButton BtnFechar;
    private javax.swing.JCheckBox ChkCondicaoDeVariavelSeTextual1;
    private javax.swing.JCheckBox ChkCondicaoDeVariavelSeTextual2;
    private javax.swing.JComboBox CmbCondicaoDeItemComparador;
    private javax.swing.JComboBox CmbCondicaoDeItemID;
    private javax.swing.JComboBox CmbCondicaoDeVariavelComparador;
    private javax.swing.JComboBox CmbCondicaoDeVariavelValor1;
    private javax.swing.JComboBox CmbCondicaoDeVariavelValor2;
    private javax.swing.ButtonGroup GrupoTipoDeCondicao;
    private javax.swing.JLabel LblItem;
    private javax.swing.JRadioButton OptCondicaoDeItem;
    private javax.swing.JRadioButton OptCondicaoDeVariavel;
    private javax.swing.JRadioButton OptCondicaoPersonalizada;
    private javax.swing.JSpinner SpnCondicaoDeItemValor;
    private javax.swing.JTextField TxtCondicaoPersonalizada;
    private javax.swing.JTextField TxtResultado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
