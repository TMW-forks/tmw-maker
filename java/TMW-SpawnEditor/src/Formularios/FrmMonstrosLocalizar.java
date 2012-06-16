/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmItemLocalizar.java
 *
 * Created on 09/06/2010, 15:20:20
 */

package Formularios;

//import Classes.ConfigClass;
//import Classes.DialogClass;
import classes.DialogClass;
import javax.swing.JOptionPane;

public class FrmMonstrosLocalizar extends javax.swing.JDialog {

    public FrmMonstrosLocalizar(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public FrmMonstrosLocalizar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      GrpTipoDeItem = new javax.swing.ButtonGroup();
      jPanel1 = new javax.swing.JPanel();
      OptNomeTitulo = new javax.swing.JRadioButton();
      OptNomeSumonico = new javax.swing.JRadioButton();
      BtnFechar = new javax.swing.JButton();
      BtnLocalizar = new javax.swing.JButton();
      TxtLocalizar = new javax.swing.JTextField();
      jLabel1 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Localizar Monstros");
      setResizable(false);

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Localizar em:"));

      GrpTipoDeItem.add(OptNomeTitulo);
      OptNomeTitulo.setSelected(true);
      OptNomeTitulo.setText("Nome Título");

      GrpTipoDeItem.add(OptNomeSumonico);
      OptNomeSumonico.setText("Nome Sumônico");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(OptNomeTitulo)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
            .addComponent(OptNomeSumonico)
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(OptNomeTitulo)
               .addComponent(OptNomeSumonico))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      BtnFechar.setMnemonic('F');
      BtnFechar.setText("Fechar");
      BtnFechar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnFecharActionPerformed(evt);
         }
      });

      BtnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes/sbl_lupa.gif"))); // NOI18N
      BtnLocalizar.setMnemonic('L');
      BtnLocalizar.setText("Localizar");
      BtnLocalizar.setEnabled(false);
      BtnLocalizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
      BtnLocalizar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            BtnLocalizarActionPerformed(evt);
         }
      });

      TxtLocalizar.setMinimumSize(new java.awt.Dimension(10, 30));
      TxtLocalizar.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            TxtLocalizarKeyPressed(evt);
         }
         public void keyReleased(java.awt.event.KeyEvent evt) {
            TxtLocalizarKeyReleased(evt);
         }
      });

      jLabel1.setText("Informação:");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(BtnLocalizar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(BtnFechar))
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(TxtLocalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
            .addContainerGap())
      );

      layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnFechar, BtnLocalizar});

      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(TxtLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(BtnFechar)
               .addComponent(BtnLocalizar))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnFechar, BtnLocalizar});

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed
    private void BtnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLocalizarActionPerformed
        Localizar();
    }//GEN-LAST:event_BtnLocalizarActionPerformed
    private void TxtLocalizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtLocalizarKeyReleased
        BtnLocalizar.setEnabled(TxtLocalizar.getText().length()>=1);
    }//GEN-LAST:event_TxtLocalizarKeyReleased

    private void TxtLocalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtLocalizarKeyPressed
        if(BtnLocalizar.isEnabled() && evt.getKeyCode()==evt.VK_ENTER) Localizar();
        if(BtnLocalizar.isEnabled() && evt.getKeyCode()==evt.VK_ESCAPE) TxtLocalizar.setText("");
    }//GEN-LAST:event_TxtLocalizarKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMonstrosLocalizar dialog = new FrmMonstrosLocalizar(new javax.swing.JDialog(), true);
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
   private javax.swing.JButton BtnFechar;
   private javax.swing.JButton BtnLocalizar;
   private javax.swing.ButtonGroup GrpTipoDeItem;
   private javax.swing.JRadioButton OptNomeSumonico;
   private javax.swing.JRadioButton OptNomeTitulo;
   private javax.swing.JTextField TxtLocalizar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables

    private void Localizar() {
        int Inicio=FrmSpawnEditor.cmbIDs.getSelectedIndex();
        int Ponteiro=Inicio;
        if(Ponteiro==FrmSpawnEditor.cmbIDs.getItemCount()-1) Ponteiro=0;
        boolean SeSair=false,Redirecionado=false;
        TxtLocalizar.setEnabled(false);
        OptNomeTitulo.setEnabled(false);
        OptNomeSumonico.setEnabled(false);
        BtnLocalizar.setEnabled(false);
        BtnFechar.setEnabled(false);

        do{
            Ponteiro++;
            if(
                (OptNomeTitulo.isSelected() && FrmSpawnEditor.bdMOBs.getMonstroPorOrdem(Ponteiro).getNomeTitulo().toLowerCase().indexOf(TxtLocalizar.getText().toLowerCase())>=0) ||
                (OptNomeSumonico.isSelected() && FrmSpawnEditor.bdMOBs.getMonstroPorOrdem(Ponteiro).getNomeSumonico().toLowerCase().indexOf(TxtLocalizar.getText().toLowerCase())>=0)
            ){
                SeSair=true;
                FrmSpawnEditor.cmbIDs.setSelectedIndex(Ponteiro);
            }else if(Ponteiro==FrmSpawnEditor.cmbIDs.getItemCount()-1 && SeSair==false && Redirecionado==false){
                int R = JOptionPane.YES_OPTION;
                Object[] Opcoes = {"Sim", "N�o"};
                R = JOptionPane.showOptionDialog(
                    null, "<html>" +
                    "N�o foi possivel encontrar \""+TxtLocalizar.getText()+"\"<br/>" +
                    "Deseja procurar novamente desde o in�cio??",
                    "LOCALIZADOR DE ITENS",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Opcoes,
                    Opcoes[1]
                );
                if(R == JOptionPane.YES_OPTION){
                    Redirecionado=true;
                    Ponteiro=-1;
                }else{
                    SeSair=true;
                }
            }else if(Ponteiro==FrmSpawnEditor.cmbIDs.getItemCount()-1 && SeSair==false && Redirecionado==true){
                SeSair=true;
                DialogClass.showErro("Item n�o encontrado!","LOCALIZADOR DE ITENS");
            }
        }while(!SeSair);
        TxtLocalizar.setEnabled(true);
        OptNomeTitulo.setEnabled(true);
        OptNomeSumonico.setEnabled(true);
        BtnLocalizar.setEnabled(true);
        BtnFechar.setEnabled(true);
    }

}
