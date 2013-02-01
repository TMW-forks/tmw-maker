/*
 * FrmImportador.java
 * @author lunovox
 * Created on 17/06/2012, 22:25:05
 */
package formularios;

import classes.DialogClass;
import classes.FileClass;
import classes.ImagemClass;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class FrmImportador extends javax.swing.JDialog {
	public FrmImportador(java.awt.Frame parent, boolean modal, String $PastaLocalhost) {
		super(parent, modal);
		pastaLocalhost=$PastaLocalhost;
		//baseScripts = pastaLocalhost + Barra + "eathena-data" + Barra + "npc";
		pastaDeMapas = pastaLocalhost + bar + "tmwdata" + bar + "maps";
		initComponents();
	}
	private static String bar = System.getProperty("file.separator");
	String pastaLocalhost;
	private static String pastaDeMapas;

	private void MapasListar() {
		final Vector MapasFiltrados = new Vector();
		String $Mapas[] = FileClass.listarArquivos(pastaDeMapas);
		MapasFiltrados.clear();
		for (int $m = 0; $m < $Mapas.length; $m++) {
			if ($Mapas[$m].toLowerCase().indexOf(".tmx")>=0) {
				MapasFiltrados.add($Mapas[$m]);
			}
		}/**/
		lstMapas.setModel(new javax.swing.AbstractListModel() {
			public int getSize() { return MapasFiltrados.size(); }
			public Object getElementAt(int i) { return MapasFiltrados.get(i); }
		});/**/
	}
	private void MapaVisualizar(String $NomeDoArquivoDoMapa) {
		String $EnderecoMapa = FrmTMWMaker2.conf.getTMWData()+bar+"maps"+bar+$NomeDoArquivoDoMapa;
		if(FileClass.seExiste($EnderecoMapa)){
			btnCompilar.setEnabled(true);
			btnAbrir.setEnabled(true);
			//lblMiniatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png")));
			ImagemClass $mini = new ImagemClass(new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-441x548.png")));
			//ImagemClass $mini = new ImagemClass("/imagens/simbolos/icon-tmw-maker-fenix-441x548.png");
			if($mini.getAltura()>lblMiniatura.getHeight()){$mini.setZoom((double)lblMiniatura.getHeight()/(double)$mini.getAltura());}
			if($mini.getLargura()>lblMiniatura.getWidth()){$mini.setZoom((double)lblMiniatura.getWidth()/(double)$mini.getLargura());}
			lblMiniatura.setIcon($mini.getIcone());
			//txtNome.setText($NomeDoArquivoDoMapa);
			try {
				Element Elementos = FileClass.arquivoAbrirXML($EnderecoMapa);
				NodeList noPropriedades = Elementos.getElementsByTagName("property");
				for (int i = 0; i < noPropriedades.getLength(); i++) {
					//Vector Registro = new Vector();
					Element tagPropriedade = (Element) noPropriedades.item(i);
					if (FileClass.getAtributo(tagPropriedade, "name", "").toLowerCase().equals("name")) {
						txtNome.setText(FileClass.getAtributo(tagPropriedade, "value", ""));
					}else if (FileClass.getAtributo(tagPropriedade, "name", "").toLowerCase().equals("minimap")) {
						String $EnderecoMiniatura = FrmTMWMaker2.conf.getTMWData()+bar+FileClass.getAtributo(tagPropriedade, "value", "");
						if(FileClass.seExiste($EnderecoMiniatura)){
							$mini = new ImagemClass($EnderecoMiniatura);
							if($mini.getAltura()>lblMiniatura.getHeight()){$mini.setZoom((double)lblMiniatura.getHeight()/(double)$mini.getAltura());}
							if($mini.getLargura()>lblMiniatura.getWidth()){$mini.setZoom((double)lblMiniatura.getWidth()/(double)$mini.getLargura());}
							lblMiniatura.setIcon($mini.getIcone());
						}
					}
				}
			} catch (ClassCastException ex) {
				 Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
			}
		}else{
			txtNome.setText("");
			btnCompilar.setEnabled(false);
			btnAbrir.setEnabled(false);
		}
	}
	private void MapaAbrir(final String $NomeDoArquivo) {
		String $Tiled = FileClass.getPastaDoSistema()+bar+"lib"+bar+"tiled.jar";
		$Tiled=$Tiled.replaceAll("src/bibliotecas/FileClass.ja", "dist");
		String $Mapa = "";
		//$Mapa = conf.getTMWData()+bar+"maps"+bar+"halicarnazo.tmx"; //← Ta funcionando correto!
		//$Mapa = FrmTMWMaker2.conf.getTMWData()+bar+"maps"+bar+lstMapas.getSelectedValue().toString();
		$Mapa = FrmTMWMaker2.conf.getTMWData()+bar+"maps"+bar+$NomeDoArquivo;
		if(FileClass.seExiste($Tiled)){
			if($Mapa.equals("") || FileClass.seExiste($Mapa)){
				FileClass.doBash("java -jar "+$Tiled+($Mapa!=""?" "+$Mapa:"")); //← Ta funcionando correto!
			}else{
				FrmTMWMaker2.addLinhaPainel("Arquivo '"+$Mapa+"' não encontrando!");
				DialogClass.showErro("Arquivo '"+FileClass.getPastaDoSistema()+bar+"lib"+bar+"tiled.jar"+"' não encontrando!", "TILED NÃO ENCONTRADO");
			}
		}else{
			FrmTMWMaker2.addLinhaPainel("Arquivo '"+$Tiled+"' não encontrando!");
			DialogClass.showErro(
			  "<html>Tiled não encontrado!<br>"
			  + "<br/>"
			  + " → '"+FileClass.getPastaDoSistema()+bar+"lib"+bar+"tiled.jar"+"'",
			  "TILED NÃO ENCONTRADO"
			 );
		}

		//tiled.mapeditor.MapEditor tiled = new tiled.mapeditor.MapEditor();
		//tiled.loadMap("/home/lunovox/Desenvolvimento/TMW/localhost/tmwdata/maps/halicarnazo.tmx");
		//tiled.shutdown();
	}
	public void MapaCompilar(final String $NomeDoArquivo) {
		int $r = 0; //0 = "Compilar"
		$r = DialogClass.showOpcoes(
			"<html>"+
			"Se os dados de '<font color='#FF0000'>"+$NomeDoArquivo+"</font>' estiverem incorretos, <br/>"+
			"o compilador danificará o código fonte do localhost.<br/>"+
			"<br/>"+
			"<font color='#0000FF'>Deseja realmente compilá-lo agora?</font>",
			"COMPILAR MAPA",
			new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png")),
			//new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png")),
			new Object[] {"Compilar", "Cancelar"},
			0
		);
		if($r==0){
			String $EnderecoMapa = FrmTMWMaker2.conf.getTMWData()+bar+"maps"+bar+$NomeDoArquivo;
			if(FileClass.seExiste($EnderecoMapa)){
            try {
					Element Elementos = FileClass.arquivoAbrirXML($EnderecoMapa);
					NodeList noPropriedades = Elementos.getElementsByTagName("property");
					//Vector Propriedades = new Vector();
					String $PastaDoMapa = "";

					for (int i = 0; i < noPropriedades.getLength(); i++) {
						//Vector Registro = new Vector();
						Element tagPropriedade = (Element) noPropriedades.item(i);
						if (FileClass.getAtributo(tagPropriedade, "name", "").toLowerCase().equals("pasta") || FileClass.getAtributo(tagPropriedade, "name", "").toLowerCase().equals("folder")) {
							$PastaDoMapa = FileClass.getAtributo(tagPropriedade, "value", "");
						}
						//Registro.addElement(FileClass.getAtributo(tagPropriedade,"name",""));
						//Registro.addElement(FileClass.getAtributo(tagPropriedade,"value",""));
						//Propriedades.add(Registro);
					}
					String $EnderecoDaPastaNPCs = FrmTMWMaker2.conf.getEathenaData() + bar + "npc";
					String $EnderecoDaPastaDoMapa = $EnderecoDaPastaNPCs+bar+$PastaDoMapa;
					NodeList noObject, noObjectGroup;
					if(FileClass.seExiste($EnderecoDaPastaDoMapa)){
						noObject = Elementos.getElementsByTagName("object");
						noObjectGroup = Elementos.getElementsByTagName("objectgroup");

						String $EnderecoMobs = $EnderecoDaPastaDoMapa + bar + "_mobs.txt";
						String $ConteudoMobs1=
						"///////////////////////////////////////////////////////////////////\n"+
						"//  IDE: TMW-Maker 2 Java\n"+
						"//   → Arquivo compilado apartir de "+$NomeDoArquivo+"\n"+
						//"//  MODIFICADO: "+FileClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+ // ← Arquivos compilados não devem ter sua data interna alterada pq são muito compilados!
						"///////////////////////////////////////////////////////////////////\n"+
						"\n";
						String $ConteudoMobs2="", $ConteudoMobs3="";
						FileClass.arquivoSalvar($EnderecoMobs, $ConteudoMobs1); //← Salva somente para fazer o arquivo existir no _import.txt!

						String $EnderecoWarps = $EnderecoDaPastaDoMapa + bar + "_warps.txt";
						String $ConteudoWarps=
						"///////////////////////////////////////////////////////////////////\n"+
						"//  IDE: TMW-Maker 2 Java\n"+
						"//   → Arquivo compilado apartir de "+$NomeDoArquivo+"\n"+
						//"//  MODIFICADO: "+FileClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+ // ← Arquivos compilados não devem ter sua data interna alterada pq são muito compilados!
						"///////////////////////////////////////////////////////////////////\n"+
						"\n";
						FileClass.arquivoSalvar($EnderecoWarps, $ConteudoWarps); //← Salva somente para fazer o arquivo existir no _import.txt!

						String $EnderecoImport = $EnderecoDaPastaDoMapa + bar + "_import.txt";
						String $ConteudoImport=
						"///////////////////////////////////////////////////////////////////\n"+
						"//  IDE: TMW-Maker 2 Java\n"+
						"//   → Arquivo compilado apartir de "+$NomeDoArquivo+"\n"+
						//"//  MODIFICADO: "+FileClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+ // ← Arquivos compilados não devem ter sua data interna alterada pq são muito compilados!
						"///////////////////////////////////////////////////////////////////\n"+
						"\n";
						$ConteudoImport+="map: "+$NomeDoArquivo.replace(".tmx", ".gat")+"\n";

						if(FileClass.seExiste($EnderecoDaPastaDoMapa+bar+"_mobs.txt")){$ConteudoImport+="\nnpc: npc/"+$PastaDoMapa+"/"+"_mobs.txt";}
						if(FileClass.seExiste($EnderecoDaPastaDoMapa+bar+"_scripts.txt")){$ConteudoImport+="\nnpc: npc/"+$PastaDoMapa+"/"+"_scripts.txt";}
						if(FileClass.seExiste($EnderecoDaPastaDoMapa+bar+"_warps.txt")){$ConteudoImport+="\nnpc: npc/"+$PastaDoMapa+"/"+"_warps.txt";}
						if(FileClass.seExiste($EnderecoDaPastaDoMapa+bar+"_shops.txt")){$ConteudoImport+="\nnpc: npc/"+$PastaDoMapa+"/"+"_shops.txt";}
						$ConteudoImport+="\n\n";

						for (int $o = 0; $o < noObjectGroup.getLength(); $o++) { // Label: _AddNPC
							Element tagObjectGroup = (Element) noObjectGroup.item($o);
							if (FileClass.getAtributo(tagObjectGroup, "name", "").toLowerCase().equals("scripts")) {
								NodeList noProperty = tagObjectGroup.getElementsByTagName("property");
								for (int $p = 0; $p < noProperty.getLength(); $p++) {
									Element tagProperty = (Element) noProperty.item($p);
									if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().indexOf("file")==0) {
										String $ArquivoScript = FileClass.getAtributo(tagProperty, "value", "");
										$ConteudoImport+="npc: npc/"+$PastaDoMapa+"/"+$ArquivoScript+"\n";
									}
								}
							}
						}

						for (int $o = 0; $o < noObject.getLength(); $o++) {
							Element tagObjet = (Element) noObject.item($o);

							if (FileClass.getAtributo(tagObjet, "type", "").toLowerCase().equals("warp")) {
								String $Name=FileClass.getAtributo(tagObjet, "name", "");
								int $X= FileClass.getAtributo(tagObjet, "x", 0)/32;
								int $Y= FileClass.getAtributo(tagObjet, "y", 0)/32;
								int $width= FileClass.getAtributo(tagObjet, "width", 0)/32;
								int $height= FileClass.getAtributo(tagObjet, "height", 0)/32;
								//$X+=$width/2;	$Y+=$height/2;
								String $toMap =""; int $toX=0, $toY=0;

								NodeList noProperty = tagObjet.getElementsByTagName("property");
								for (int $p = 0; $p < noProperty.getLength(); $p++) {
									Element tagProperty = (Element) noProperty.item($p);
									if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("map")) {
										$toMap = FileClass.getAtributo(tagProperty, "value", "");
									}else if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("dest_map")) {
										$toMap = FileClass.getAtributo(tagProperty, "value", "");
									}
									if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("x")) {
										$toX = FileClass.getAtributo(tagProperty, "value", 0);
									}else if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("dest_x")) {
										$toX = FileClass.getAtributo(tagProperty, "value", 0)/32;
									}
									if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("y")) {
										$toY = FileClass.getAtributo(tagProperty, "value", 0);
									}else if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("dest_y")) {
										$toY = FileClass.getAtributo(tagProperty, "value", 0)/32;
									}
								}
								$ConteudoWarps+=$NomeDoArquivo.replace(".tmx", ".gat")+","+($X+($width/2))+","+($Y+($height/2))+"\twarp\t"+$Name+"\t"+($width-1)+","+($height-1)+","+$toMap+".gat,"+$toX+","+$toY+"\n";
								
							/*}else if (FileClass.getAtributo(tagObjet, "type", "").toLowerCase().equals("script")) { //← Código desnecessário pq o código em "_AddNPC" ja adiciona das duas forma!
								NodeList noProperty = tagObjet.getElementsByTagName("property");
								for (int $p = 0; $p < noProperty.getLength(); $p++) {
									Element tagProperty = (Element) noProperty.item($p);
									if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().indexOf("file")==0) {
										String $ArquivoScript = FileClass.getAtributo(tagProperty, "value", "");
										$ConteudoImport+="npc: npc"+bar+$PastaDoMapa+bar+$ArquivoScript+"\n";
									}
								}/**/
							}else if (FileClass.getAtributo(tagObjet, "type", "").toLowerCase().equals("spawn")) {
								String $Name=FileClass.getAtributo(tagObjet, "name", "");
								int $X= FileClass.getAtributo(tagObjet, "x", 0)/32;
								int $Y= FileClass.getAtributo(tagObjet, "y", 0)/32;
								int $width= FileClass.getAtributo(tagObjet, "width", 0)/32;
								int $height= FileClass.getAtributo(tagObjet, "height", 0)/32;
								int $id=0, $amount=0, $delay1=0, $delay2=0;
								NodeList noProperty = tagObjet.getElementsByTagName("property");
								for (int $p = 0; $p < noProperty.getLength(); $p++) {
									Element tagProperty = (Element) noProperty.item($p);
									if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("id")) {
										$id = FileClass.getAtributo(tagProperty, "value", 0);
									}else if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("amount")) {
										$amount = FileClass.getAtributo(tagProperty, "value", 0);
									}else if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("delay1")) {
										$delay1 = FileClass.getAtributo(tagProperty, "value", 0);
									}else if (FileClass.getAtributo(tagProperty, "name", "").toLowerCase().equals("delay2")) {
										$delay2 = FileClass.getAtributo(tagProperty, "value", 0);
									}
								}
								if($id>0 && $amount>0){
									$ConteudoMobs2+=
									$NomeDoArquivo.replace(".tmx", ".gat")+","+($X+($width/2))+","+($Y+($height/2))+","+$width+","+$height+
									"\tmonster\t"+$Name+"\t"+
									$id+","+$amount+","+$delay1+","+$delay2+",Mob"+$NomeDoArquivo.replace(".tmx", "")+"::On"+$id+"\n";
									if($ConteudoMobs3.indexOf("On"+$id+":")==-1){
										$ConteudoMobs3+=
										"On"+$id+":\n"+
										"\tset @mobID, "+$id+";\n"+
										"\tcallfunc \"MobPoints\";\n"+
										//"\tcallsub _MOBS_queimaduraTartaruga;\n"+
										"break;\n\n";
									}
								}
							}

						}
						if(!$ConteudoMobs2.equals("")){
							$ConteudoMobs2+="\n"+$NomeDoArquivo.replace(".tmx", ".gat")+",0,0,0\tscript\tMob"+$NomeDoArquivo.replace(".tmx", "")+"\t-1,{\n\n";
							$ConteudoMobs2+=$ConteudoMobs3;
							$ConteudoMobs2+="end;\n}";
							$ConteudoMobs1+=$ConteudoMobs2;
							FileClass.arquivoSalvar($EnderecoMobs, $ConteudoMobs1);
						}
						FileClass.arquivoSalvar($EnderecoWarps, $ConteudoWarps);
						FileClass.arquivoSalvar($EnderecoImport, $ConteudoImport);

						DialogClass.showAlerta(
							"<html>Mapa '<font color='#0000FF'>"+$NomeDoArquivo+"</font>' compilado com sucesso!",
							"COMPILADOR",
							new javax.swing.ImageIcon(getClass().getResource("/imagens/simbolos/icon-tmw-maker-fenix-96x119.png"))
						);
					}else{
						DialogClass.showErro("<html>A pasta '<font color='#FF0000'>"+$EnderecoDaPastaDoMapa+"</font>' foi apagado ou não existe!","PASTA NÃO ENCONTRADA");
					}
				} catch (ClassCastException ex) {
                Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            }
			}else{
				DialogClass.showErro("<html>O mapa '<font color='#FF0000'>"+$NomeDoArquivo+"</font>' foi apagado ou não existe!","ARQUIVO NÃO ENCONTRADO");
			}
		}
	}

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jTabbedPane1 = new javax.swing.JTabbedPane();
      jPanel1 = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      lstMapas = new javax.swing.JList();
      btnImportar = new javax.swing.JButton();
      btnCompilar = new javax.swing.JButton();
      lblMiniatura = new javax.swing.JLabel();
      btnAbrir = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();
      txtNome = new javax.swing.JTextField();

      setTitle("Importador");
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
         }
      });

      lstMapas.setModel(new javax.swing.AbstractListModel() {
         String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      lstMapas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      lstMapas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            lstMapasValueChanged(evt);
         }
      });
      jScrollPane1.setViewportView(lstMapas);

      btnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_dependencias.gif"))); // NOI18N
      btnImportar.setText("Importar");
      btnImportar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnImportarActionPerformed(evt);
         }
      });

      btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_atomico.gif"))); // NOI18N
      btnCompilar.setText("Compilar");
      btnCompilar.setEnabled(false);
      btnCompilar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCompilarActionPerformed(evt);
         }
      });

      lblMiniatura.setBackground(java.awt.Color.black);
      lblMiniatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblMiniatura.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
      lblMiniatura.setOpaque(true);

      btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_pasta.gif"))); // NOI18N
      btnAbrir.setText("Abrir");
      btnAbrir.setEnabled(false);
      btnAbrir.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAbrirActionPerformed(evt);
         }
      });

      jLabel1.setText("Nome:");

      txtNome.setEditable(false);
      txtNome.setOpaque(false);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(lblMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(btnImportar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnCompilar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnAbrir))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)))
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1)
                     .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(lblMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btnImportar)
                     .addComponent(btnCompilar)
                     .addComponent(btnAbrir))))
            .addContainerGap())
      );

      jTabbedPane1.addTab("Mapas", jPanel1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
            .addContainerGap())
      );
   }// </editor-fold>//GEN-END:initComponents

	private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		// TODO add your handling code here:
		MapasListar();
	}//GEN-LAST:event_formWindowOpened
	private void lstMapasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstMapasValueChanged
		// TODO add your handling code here:
		Thread tThread = new Thread(
			new Runnable() {
			  public void run() {
				  MapaVisualizar(lstMapas.getSelectedValue().toString());
			  }
			});
		tThread.start();
	}//GEN-LAST:event_lstMapasValueChanged
	private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
		Thread tThread = new Thread(
			new Runnable() {
			  public void run() {
				  MapaAbrir(lstMapas.getSelectedValue().toString());
			  }
			});
		tThread.start();
	}//GEN-LAST:event_btnAbrirActionPerformed
	private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
		Thread tThread = new Thread(
			new Runnable() {
			  public void run() {
				  MapaCompilar(lstMapas.getSelectedValue().toString());
			  }
			});
		tThread.start();
	}//GEN-LAST:event_btnCompilarActionPerformed
	private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
		//javax.swing.JDialog frmMapaImportador = new FrmMapaImportador(this, rootPaneCheckingEnabled);
		//FrmMapaImportador dialog = new FrmMapaImportador(new javax.swing.JFrame(), true, "");
		FrmMapaImportador frmMapaImportador = new FrmMapaImportador(this, true, pastaLocalhost);
		frmMapaImportador.setLocation(
			((this.getWidth() - frmMapaImportador.getWidth()) / 2) + this.getX(),
			((this.getHeight() - frmMapaImportador.getHeight()) / 2) + this.getY()
		);
		frmMapaImportador.pack();
		frmMapaImportador.setModal(true);
		frmMapaImportador.setVisible(true);/**/
	}//GEN-LAST:event_btnImportarActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAbrir;
   private javax.swing.JButton btnCompilar;
   private javax.swing.JButton btnImportar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTabbedPane jTabbedPane1;
   public static javax.swing.JLabel lblMiniatura;
   private javax.swing.JList lstMapas;
   public static javax.swing.JTextField txtNome;
   // End of variables declaration//GEN-END:variables

}
