/*
 * FrmEditorSAS.java
 * Created on 30/01/2013, 20:59:20
 * @author lunovox
 */
package formularios;

import classes.DialogClass;
import classes.FileClass;
import classes.ImagemClass;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.ImageIcon;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class FrmEditorSAS extends javax.swing.JFrame {
	public FrmEditorSAS() {
		initComponents();
	}
	private FrmEditorSAS(String PastaDoLocalhost) {
		System.out.println(PastaDoLocalhost);
		try {
			//super.setIconImage((new ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))).getImage());
			super.setIconImage((new ImageIcon(getClass().getResource("/imagens/botoes/sbl_good.png"))).getImage());
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Icone erro:\n" + e.getMessage());
		}
		pastaDoLocalhost = PastaDoLocalhost;
		pastaDeTmwData = pastaDoLocalhost + bar + "tmwdata";
		pastaDeSprites = pastaDeTmwData + bar + "graphics" + bar + "sprites";

		initComponents();
	}
	//ImagemClass $Handler = new ImagemClass("/home/lunovox/Desenvolvimento/TMW/localhost/tmwdata/graphics/sprites/player_female_base.png");
	//ImagemClass $Handler = new ImagemClass("/home/lunovox/Desenvolvimento/TMW/localhost/tmwdata/graphics/sprites/monstro-fafidragon.png");
	public Element xmlBase;
	public String sptBaseUrl="";
	public ImagemClass sptBaseImg=null;
	public int sptBaseWidth=0;
	public int sptBaseHeight=0;

	public Element xmlMain;
	public String sptMainUrl="";
	public ImagemClass sptMainImg=null;
	public int sptMainWidth=0;
	public int sptMainHeight=0;


	private String bar = System.getProperty("file.separator");
	public String pastaDoLocalhost = "";
	public String pastaDeSprites = "";
	public String pastaDeTmwData = "";
	public Double zoom = 1.0;
	public String urlSalve = "";

	public String getTipo(Element $XML, int $Action, int $Animation, int $FrameSeq){
		Vector $ContAction = new Vector();
		NodeList $MyNode = $XML.getChildNodes();
		for (int $ac=0; $ac<$MyNode.getLength(); $ac++) {
			if($MyNode.item($ac).getNodeName().equals("action")){
				$ContAction.addElement($ContAction.size()+1);
				Element $ActionTag = (Element) $MyNode.item($ac);
				if($ContAction.size()-1==$Action){
					Vector $ContAnimation = new Vector();
					NodeList $ActionNode = $ActionTag.getChildNodes();
					for (int $an=0; $an<$ActionNode.getLength(); $an++) {
						if($ActionNode.item($an).getNodeName().equals("animation")){
							$ContAnimation.addElement($ContAnimation.size()+1);
							Element $AnimationTag = (Element) $ActionNode.item($an);
							if($ContAnimation.size()-1==$Animation){
								Vector $ContFrameSeq = new Vector();
								NodeList $AnimationNode = $AnimationTag.getChildNodes();
								for (int $fs=0; $fs<$AnimationNode.getLength(); $fs++) {
									if($AnimationNode.item($fs).getNodeName().equals("frame") || $AnimationNode.item($fs).getNodeName().equals("sequence") || $AnimationNode.item($fs).getNodeName().equals("end")){
										$ContFrameSeq.addElement($ContFrameSeq.size()+1);
										if($ContFrameSeq.size()-1==$FrameSeq){
											Element $FrameSeqTag = (Element) $AnimationNode.item($fs);
											return $FrameSeqTag.getNodeName();
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return "";
	}
	public String getPropriedade(Element $XML, int $Action, int $Animation, int $FrameSeq, String $Atributo){
		Vector $ContAction = new Vector();
		NodeList $MyNode = $XML.getChildNodes();
		for (int $ac=0; $ac<$MyNode.getLength(); $ac++) {
			if($MyNode.item($ac).getNodeName().equals("action")){
				$ContAction.addElement($ContAction.size()+1);
				Element $ActionTag = (Element) $MyNode.item($ac);
				if($ContAction.size()-1==$Action){
					Vector $ContAnimation = new Vector();
					NodeList $ActionNode = $ActionTag.getChildNodes();
					for (int $an=0; $an<$ActionNode.getLength(); $an++) {
						if($ActionNode.item($an).getNodeName().equals("animation")){
							$ContAnimation.addElement($ContAnimation.size()+1);
							Element $AnimationTag = (Element) $ActionNode.item($an);
							if($ContAnimation.size()-1==$Animation){
								Vector $ContFrameSeq = new Vector();
								NodeList $AnimationNode = $AnimationTag.getChildNodes();
								for (int $fs=0; $fs<$AnimationNode.getLength(); $fs++) {
									if($AnimationNode.item($fs).getNodeName().equals("frame") || $AnimationNode.item($fs).getNodeName().equals("sequence") || $AnimationNode.item($fs).getNodeName().equals("end")){
										$ContFrameSeq.addElement($ContFrameSeq.size()+1);
										if($ContFrameSeq.size()-1==$FrameSeq){
											Element $FrameSeqTag = (Element) $AnimationNode.item($fs);
											return $FrameSeqTag.getAttribute($Atributo);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return "";
	}
	public void setPropriedade(Element $XML, int $Action, int $Animation, int $FrameSeq, String $Atributo, String $Valor){
		if($Action>=0 && $Animation>=0 && $FrameSeq>=0){
			Vector $ContAction = new Vector();
			NodeList $MyNode = $XML.getChildNodes();
			for (int $ac=0; $ac<$MyNode.getLength(); $ac++) {
				if($MyNode.item($ac).getNodeName().equals("action")){
					$ContAction.addElement($ContAction.size()+1);
					Element $ActionTag = (Element) $MyNode.item($ac);
					if($ContAction.size()-1==$Action){
						Vector $ContAnimation = new Vector();
						NodeList $ActionNode = $ActionTag.getChildNodes();
						for (int $an=0; $an<$ActionNode.getLength(); $an++) {
							if($ActionNode.item($an).getNodeName().equals("animation")){
								$ContAnimation.addElement($ContAnimation.size()+1);
								Element $AnimationTag = (Element) $ActionNode.item($an);
								if($ContAnimation.size()-1==$Animation){
									Vector $ContFrameSeq = new Vector();
									NodeList $AnimationNode = $AnimationTag.getChildNodes();
									for (int $fs=0; $fs<$AnimationNode.getLength(); $fs++) {
										if($AnimationNode.item($fs).getNodeName().equals("frame") || $AnimationNode.item($fs).getNodeName().equals("sequence") || $AnimationNode.item($fs).getNodeName().equals("end")){
											$ContFrameSeq.addElement($ContFrameSeq.size()+1);
											if($ContFrameSeq.size()-1==$FrameSeq){
												Element $FrameSeqTag = (Element) $AnimationNode.item($fs);
												//return $FrameSeqTag.getAttribute($Atributo);
												$FrameSeqTag.setAttribute($Atributo,$Valor);
												return;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void RedesenhaPalco(){
		Graphics2D $G2D = (Graphics2D)cnvPalco.getGraphics();
		//cnvPalco = new CnvPalco(cnvPalco, "/home/lunovox/Desenvolvimento/TMW/localhost/tmwdata/graphics/sprites/player_female_base.png");
		//cnvPalco.repaint();
		//int $Alura = cnvPalco.getHeight()/2;
		int $Alura = (cnvPalco.getHeight()*scrAltura.getValue())/scrAltura.getMaximum();

		$G2D.clearRect(0, 0, cnvPalco.getWidth(), cnvPalco.getHeight());
		$G2D.setColor(Color.yellow);
		$G2D.drawLine(0, $Alura, cnvPalco.getWidth(), $Alura);
		$G2D.drawLine(cnvPalco.getWidth()/2, 0, cnvPalco.getWidth()/2, cnvPalco.getHeight());

		if(sptBaseImg!=null && !sptBaseUrl.equals("") && sptBaseImg.getLargura()>0){
			if(cmbAction.getSelectedIndex()>=0 && cmbAnimation.getSelectedIndex()>=0 && cmbFrameSeq.getSelectedIndex()>=0){
				ImagemClass $imgBase = new ImagemClass(sptBaseImg.getImage());
				String Tipo = getTipo(xmlBase, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex());
				int Bloco = 0;
				if(Tipo.equals("frame")){
					//Bloco = sldFrameImagem.getValue();
					Bloco = Integer.parseInt(getPropriedade(xmlBase, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"index"));
					//lblFrameImagem.setText("Imagem("+Bloco+"):");
				}else if(Tipo.equals("sequence")){
					//Bloco = sldSeqStart.getValue();
					Bloco = Integer.parseInt(getPropriedade(xmlBase, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"start"));
					//int Bloco2 = Integer.parseInt(getPropriedade(xmlBase, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"end"));
					//lblSeqStart.setText("Início("+Bloco+"):");
					//lblSeqEnd.setText("Final("+Bloco2+"):");
				}/**/
				if(Tipo.equals("frame") || Tipo.equals("sequence")){
					int BlocoY = ((Bloco*sptBaseWidth)/sptBaseImg.getLargura())*sptBaseHeight;
					int BlocoX = (Bloco*sptBaseWidth)%sptBaseImg.getLargura();
					$imgBase.setCorte(BlocoX, BlocoY, sptBaseWidth, sptBaseHeight);

					$imgBase.setZoom(zoom);
					String $StrOffsetX = getPropriedade(xmlBase, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"offsetX");
					String $StrOffsetY = getPropriedade(xmlBase, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"offsetY");
					$StrOffsetX=$StrOffsetX.equals("")?"0":$StrOffsetX;
					$StrOffsetY=$StrOffsetY.equals("")?"0":$StrOffsetY;
					int $OffsetX = (cnvPalco.getWidth() - $imgBase.getLargura())/2;
					int $OffsetY = $Alura - $imgBase.getAltura();
					$G2D.drawImage($imgBase.getImage(), $OffsetX, $OffsetY, this);
				}/**/
			}
		}
		if(sptMainImg!=null && !sptMainUrl.equals("") && sptMainImg.getLargura()>0){
			if(cmbAction.getSelectedIndex()>=0 && cmbAnimation.getSelectedIndex()>=0 && cmbFrameSeq.getSelectedIndex()>=0){
				ImagemClass $imgMain = new ImagemClass(sptMainUrl);
				String Tipo = getTipo(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex());
				int Bloco = 0;
				if(Tipo.equals("frame")){
					//lblFrameImagem.setText("Imagem("+sldFrameImagem.getValue()+"):");
					Bloco = Integer.parseInt(getPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"index"));
				}else if(Tipo.equals("sequence")){
					Bloco = Integer.parseInt(getPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"start"));
					//int Bloco2 = Integer.parseInt(getPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"end"));
					//lblSeqStart.setText("Início("+Bloco+"):");
					//lblSeqEnd.setText("Final("+Bloco2+"):");
				}
				if(Tipo.equals("frame") || Tipo.equals("sequence")){
					int BlocoY = ((Bloco*sptMainWidth)/sptMainImg.getLargura())*sptMainHeight;
					int BlocoX = (Bloco*sptMainWidth)%sptMainImg.getLargura();
					$imgMain.setCorte(BlocoX, BlocoY, sptMainWidth, sptMainHeight);

					$imgMain.setZoom(zoom);
					String $StrOffsetX = getPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"offsetX");
					String $StrOffsetY = getPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"offsetY");
					$StrOffsetX=$StrOffsetX.equals("")?"0":$StrOffsetX;
					$StrOffsetY=$StrOffsetY.equals("")?"0":$StrOffsetY;
					int $OffsetX = ((cnvPalco.getWidth() - $imgMain.getLargura())/2) + ((int)(Integer.parseInt($StrOffsetX)*zoom));
					int $OffsetY = $Alura + (int)((Integer.parseInt($StrOffsetY)-sptMainHeight)*zoom);
					$G2D.drawImage($imgMain.getImage(), $OffsetX, $OffsetY, this);
				}
			}
		}

		$G2D.setColor(Color.white);
		$G2D.drawString("Rand("+(int) (1 + (Math.random() * 100))+")", 10, 30);
		//cnvPalco.paint(g2);
		//cnvPalco.update(g2);
	}
	double arredondar(double valor, int casas, int ceilOrFloor) {
      double arredondado = valor;
      arredondado *= (Math.pow(10, casas));
      if (ceilOrFloor == 0) {
         arredondado = Math.ceil(arredondado);
      } else {
         arredondado = Math.floor(arredondado);
      }
      arredondado /= (Math.pow(10, casas));
      return arredondado;
   }
	public void ListarAnimation(){
		//frmAnimationEditor.xmlMain = FileClass.arquivoAbrirXML($urlBase);
		Vector $Animation = new Vector();
		NodeList $MainNode = xmlMain.getChildNodes();
		for (int $ac=0; $ac<xmlMain.getChildNodes().getLength(); $ac++) {
			if($MainNode.item($ac).getNodeName().equals("action")){
				Element $ActionTag = (Element) $MainNode.item($ac);
				if($ActionTag.getAttribute("name").equals(cmbAction.getSelectedItem().toString())){
					NodeList $ActionNode = $ActionTag.getChildNodes();
					for (int $an=0; $an<$ActionNode.getLength(); $an++) {
						if($ActionNode.item($an).getNodeName().equals("animation")){
							Element $AnimationTag = (Element) $ActionNode.item($an);
							String $Directon = $AnimationTag.getAttribute("direction").equals("")?"default":$AnimationTag.getAttribute("direction");
							$Animation.addElement($Directon);
						}
					}
				}
			}
		}
		cmbAnimation.setModel(new javax.swing.DefaultComboBoxModel($Animation.toArray()));
		cmbAnimation.setEnabled(true);
		ListarFrameSequence();
	}
	public void ListarFrameSequence(){
		//frmAnimationEditor.xmlMain = FileClass.arquivoAbrirXML($urlBase);
		Vector $FrameSequence = new Vector();
		NodeList $MainNode = xmlMain.getChildNodes();
		for (int $ac=0; $ac<xmlMain.getChildNodes().getLength(); $ac++) {
			if($MainNode.item($ac).getNodeName().equals("action")){
				Element $ActionTag = (Element) $MainNode.item($ac);
				if($ActionTag.getAttribute("name").equals(cmbAction.getSelectedItem().toString())){
					NodeList $ActionNode = $ActionTag.getChildNodes();
					for (int $an=0; $an<$ActionNode.getLength(); $an++) {
						if($ActionNode.item($an).getNodeName().equals("animation")){
							Element $AnimationTag = (Element) $ActionNode.item($an);
							if(cmbAnimation.getSelectedItem().toString().equals("default") || $AnimationTag.getAttribute("direction").equals(cmbAnimation.getSelectedItem().toString())){
								NodeList $FrameSeqNode = $AnimationTag.getChildNodes();
								for (int $fs=0; $fs<$FrameSeqNode.getLength(); $fs++) {
									if($FrameSeqNode.item($fs).getNodeName().equals("frame")){
										Element $FrameSeqTag = (Element) $FrameSeqNode.item($fs);
										$FrameSequence.addElement(($FrameSequence.size()+1)+":Frame");
									}else if($FrameSeqNode.item($fs).getNodeName().equals("sequence")){
										Element $FrameSeqTag = (Element) $FrameSeqNode.item($fs);
										$FrameSequence.addElement(($FrameSequence.size()+1)+":Sequência");
									}else if($FrameSeqNode.item($fs).getNodeName().equals("end")){
										Element $FrameSeqTag = (Element) $FrameSeqNode.item($fs);
										$FrameSequence.addElement(($FrameSequence.size()+1)+":Parada");
									}
								}
							}
						}
					}
				}
			}
		}
		cmbFrameSeq.setModel(new javax.swing.DefaultComboBoxModel($FrameSequence.toArray()));
		cmbFrameSeq.setEnabled(true);
		//tplFrameSeq.setEnabled(true);
		ListarPropriedade();
	}
	public void ListarPropriedade(){
		if(cmbAction.getSelectedIndex()>=0 && cmbAnimation.getSelectedIndex()>=0 && cmbFrameSeq.getSelectedIndex()>=0){
			//frmAnimationEditor.xmlMain = FileClass.arquivoAbrirXML($urlBase);
			NodeList $MainNode = xmlMain.getChildNodes();
			for (int $ac=0; $ac<xmlMain.getChildNodes().getLength(); $ac++) {
				if($MainNode.item($ac).getNodeName().equals("action")){
					Element $ActionTag = (Element) $MainNode.item($ac);
					if($ActionTag.getAttribute("name").equals(cmbAction.getSelectedItem().toString())){
						NodeList $ActionNode = $ActionTag.getChildNodes();
						for (int $an=0; $an<$ActionNode.getLength(); $an++) {
							if($ActionNode.item($an).getNodeName().equals("animation")){
								Element $AnimationTag = (Element) $ActionNode.item($an);
								if(cmbAnimation.getSelectedItem().toString().equals("default") || $AnimationTag.getAttribute("direction").equals(cmbAnimation.getSelectedItem().toString())){
									NodeList $AnimationNode = $AnimationTag.getChildNodes();
									for (int $fs=0; $fs<$AnimationNode.getLength(); $fs++) {
										if($AnimationNode.item($fs).getNodeName().equals("frame")){
											Element $FrameSeqTag = (Element) $AnimationNode.item($fs);
											if(cmbFrameSeq.getSelectedItem().toString().indexOf("Frame")>=0){
												//$FrameSequence.addElement(($FrameSequence.size()+1)+":Frame("+$FrameSeqTag.getAttribute("index")+")");
												sldFrameImagem.setEnabled(true);
												sldFrameImagem.setValue(Integer.parseInt($FrameSeqTag.getAttribute("index")));
												lblFrameImagem.setEnabled(true);
												lblFrameImagem.setText("Imagem ("+sldFrameImagem.getValue()+"):");

												sldFrameOffsetX.setValue(Integer.parseInt($FrameSeqTag.getAttribute("offsetX").equals("")?"0":$FrameSeqTag.getAttribute("offsetX")));
												sldFrameOffsetX.setEnabled(true);
												lblFrameOffsetX.setEnabled(true);
												lblFrameOffsetX.setText("Deslocamento X ("+sldFrameOffsetX.getValue()+"px):");

												sldFrameOffsetY.setValue(Integer.parseInt($FrameSeqTag.getAttribute("offsetY").equals("")?"0":$FrameSeqTag.getAttribute("offsetY")));
												sldFrameOffsetY.setEnabled(true);
												lblFrameOffsetY.setEnabled(true);
												lblFrameOffsetY.setText("Deslocamento Y ("+sldFrameOffsetY.getValue()+"px):");

												sldFrameDelay.setEnabled(true);
												sldFrameDelay.setValue(Integer.parseInt($FrameSeqTag.getAttribute("delay").equals("")?"0":$FrameSeqTag.getAttribute("delay")));
												lblFrameDelay.setEnabled(true);
												lblFrameDelay.setText("Intervalo ("+sldFrameDelay.getValue()+"ms):");

												tplFrameSeq.setSelectedIndex(0);
											}
										}else if($AnimationNode.item($fs).getNodeName().equals("sequence")){
											Element $FrameSeqTag = (Element) $AnimationNode.item($fs);
											if(cmbFrameSeq.getSelectedItem().toString().indexOf("Sequência")>=0){
												
												sldSeqStart.setEnabled(true);
												sldSeqStart.setValue(Integer.parseInt($FrameSeqTag.getAttribute("start")));
												lblSeqStart.setEnabled(true);
												lblSeqStart.setText("Início("+sldSeqStart.getValue()+"):");

												sldSeqEnd.setEnabled(true);
												sldSeqEnd.setValue(Integer.parseInt($FrameSeqTag.getAttribute("end")));
												lblSeqEnd.setEnabled(true);
												lblSeqEnd.setText("Final("+sldSeqEnd.getValue()+"):");

												sldSeqOffsetX.setValue(Integer.parseInt($FrameSeqTag.getAttribute("offsetX").equals("")?"0":$FrameSeqTag.getAttribute("offsetX")));
												sldSeqOffsetX.setEnabled(true);
												lblSeqOffsetX.setEnabled(true);
												lblSeqOffsetX.setText("Deslocamento X ("+sldSeqOffsetX.getValue()+"px):");

												sldSeqOffsetY.setValue(Integer.parseInt($FrameSeqTag.getAttribute("offsetY").equals("")?"0":$FrameSeqTag.getAttribute("offsetY")));
												sldSeqOffsetY.setEnabled(true);
												lblSeqOffsetY.setEnabled(true);
												lblSeqOffsetY.setText("Deslocamento Y ("+sldSeqOffsetY.getValue()+"px):");

												sldSeqDelay.setEnabled(true);
												sldSeqDelay.setValue(Integer.parseInt($FrameSeqTag.getAttribute("delay").equals("")?"0":$FrameSeqTag.getAttribute("delay")));
												lblSeqDelay.setEnabled(true);
												lblSeqDelay.setText("Intervalo ("+sldSeqDelay.getValue()+"ms):");

												tplFrameSeq.setSelectedIndex(1);
											}
										}else if($AnimationNode.item($fs).getNodeName().equals("end")){
											Element $FrameSeqTag = (Element) $AnimationNode.item($fs);
											if(cmbFrameSeq.getSelectedItem().toString().indexOf("Parada")>=0){
												//$FrameSequence.addElement(($FrameSequence.size()+1)+":Parada");
												//pnlEnd.setEnabled(true);
												//if($FrameSequence.size()==1){tplFrameSeq.setSelectedIndex(2);}
												tplFrameSeq.setSelectedIndex(2);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			//cmbFrameSeq.setModel(new javax.swing.DefaultComboBoxModel($FrameSequence.toArray()));
			//cmbFrameSeq.setEnabled(true);
			//tplFrameSeq.setEnabled(true);
		}
	}
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      cmbAction = new javax.swing.JComboBox();
      cmbAnimation = new javax.swing.JComboBox();
      btnActionNew = new javax.swing.JButton();
      btnActionDel = new javax.swing.JButton();
      btnAnimationNew = new javax.swing.JButton();
      btnAnimationDel = new javax.swing.JButton();
      tplFrameSeq = new javax.swing.JTabbedPane();
      pnlFrame = new javax.swing.JPanel();
      lblFrameImagem = new javax.swing.JLabel();
      sldFrameImagem = new javax.swing.JSlider();
      lblFrameOffsetX = new javax.swing.JLabel();
      sldFrameOffsetX = new javax.swing.JSlider();
      lblFrameOffsetY = new javax.swing.JLabel();
      sldFrameOffsetY = new javax.swing.JSlider();
      lblFrameDelay = new javax.swing.JLabel();
      sldFrameDelay = new javax.swing.JSlider();
      pnlSequence = new javax.swing.JPanel();
      sldSeqStart = new javax.swing.JSlider();
      lblSeqOffsetX = new javax.swing.JLabel();
      sldSeqOffsetX = new javax.swing.JSlider();
      lblSeqOffsetY = new javax.swing.JLabel();
      sldSeqOffsetY = new javax.swing.JSlider();
      lblSeqDelay = new javax.swing.JLabel();
      sldSeqDelay = new javax.swing.JSlider();
      lblSeqStart = new javax.swing.JLabel();
      lblSeqEnd = new javax.swing.JLabel();
      sldSeqEnd = new javax.swing.JSlider();
      pnlEnd = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jButton5 = new javax.swing.JButton();
      cmbFrameSeq = new javax.swing.JComboBox();
      jToolBar1 = new javax.swing.JToolBar();
      btnNovo = new javax.swing.JButton();
      btnAbrir = new javax.swing.JButton();
      btnSalvar = new javax.swing.JButton();
      jSeparator2 = new javax.swing.JToolBar.Separator();
      jToolBar2 = new javax.swing.JToolBar();
      lblEstatus = new javax.swing.JLabel();
      jPanel2 = new javax.swing.JPanel();
      cnvPalco = new java.awt.Canvas();
      scrAltura = new javax.swing.JScrollBar();
      jMenuBar1 = new javax.swing.JMenuBar();
      mnpArquivo = new javax.swing.JMenu();
      mnuNovo = new javax.swing.JMenuItem();
      mnuAbrir = new javax.swing.JMenuItem();
      mnuSalvar = new javax.swing.JMenuItem();
      mnuSalvarComo = new javax.swing.JMenuItem();
      jSeparator1 = new javax.swing.JPopupMenu.Separator();
      mnuSair = new javax.swing.JMenuItem();
      mnpAjuda = new javax.swing.JMenu();
      mnuAjudaSobre = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Editor de Sequência de Animação de Sprites");

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

      cmbAction.setToolTipText("Lista de Ações");
      cmbAction.setEnabled(false);
      cmbAction.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbActionActionPerformed(evt);
         }
      });

      cmbAnimation.setToolTipText("Lista de Animações");
      cmbAnimation.setEnabled(false);
      cmbAnimation.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbAnimationActionPerformed(evt);
         }
      });

      btnActionNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_estrela.gif"))); // NOI18N
      btnActionNew.setEnabled(false);

      btnActionDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_lixeira.png"))); // NOI18N
      btnActionDel.setEnabled(false);

      btnAnimationNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_estrela.gif"))); // NOI18N
      btnAnimationNew.setEnabled(false);

      btnAnimationDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_lixeira.png"))); // NOI18N
      btnAnimationDel.setEnabled(false);

      tplFrameSeq.setEnabled(false);

      lblFrameImagem.setText("Imagem(0):");
      lblFrameImagem.setEnabled(false);

      sldFrameImagem.setMajorTickSpacing(12);
      sldFrameImagem.setMaximum(60);
      sldFrameImagem.setPaintLabels(true);
      sldFrameImagem.setPaintTicks(true);
      sldFrameImagem.setPaintTrack(false);
      sldFrameImagem.setValue(0);
      sldFrameImagem.setEnabled(false);
      sldFrameImagem.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldFrameImagemStateChanged(evt);
         }
      });

      lblFrameOffsetX.setText("Deslocamento X (0px):");
      lblFrameOffsetX.setEnabled(false);

      sldFrameOffsetX.setMaximum(150);
      sldFrameOffsetX.setMinimum(-150);
      sldFrameOffsetX.setPaintLabels(true);
      sldFrameOffsetX.setValue(0);
      sldFrameOffsetX.setEnabled(false);
      sldFrameOffsetX.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldFrameOffsetXStateChanged(evt);
         }
      });

      lblFrameOffsetY.setText("Deslocamento Y (0px):");
      lblFrameOffsetY.setEnabled(false);

      sldFrameOffsetY.setMaximum(150);
      sldFrameOffsetY.setMinimum(-150);
      sldFrameOffsetY.setPaintLabels(true);
      sldFrameOffsetY.setValue(0);
      sldFrameOffsetY.setEnabled(false);
      sldFrameOffsetY.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldFrameOffsetYStateChanged(evt);
         }
      });

      lblFrameDelay.setText("Intervalo (0ms):");
      lblFrameDelay.setEnabled(false);

      sldFrameDelay.setMajorTickSpacing(1000);
      sldFrameDelay.setMaximum(2000);
      sldFrameDelay.setPaintLabels(true);
      sldFrameDelay.setPaintTicks(true);
      sldFrameDelay.setPaintTrack(false);
      sldFrameDelay.setValue(0);
      sldFrameDelay.setEnabled(false);
      sldFrameDelay.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldFrameDelayStateChanged(evt);
         }
      });

      javax.swing.GroupLayout pnlFrameLayout = new javax.swing.GroupLayout(pnlFrame);
      pnlFrame.setLayout(pnlFrameLayout);
      pnlFrameLayout.setHorizontalGroup(
         pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pnlFrameLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(lblFrameImagem)
               .addComponent(sldFrameImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblFrameOffsetX)
               .addComponent(sldFrameOffsetX, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblFrameOffsetY)
               .addComponent(sldFrameOffsetY, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblFrameDelay)
               .addComponent(sldFrameDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
      );
      pnlFrameLayout.setVerticalGroup(
         pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pnlFrameLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lblFrameImagem)
            .addGap(2, 2, 2)
            .addComponent(sldFrameImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(lblFrameOffsetX)
            .addGap(2, 2, 2)
            .addComponent(sldFrameOffsetX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(lblFrameOffsetY)
            .addGap(2, 2, 2)
            .addComponent(sldFrameOffsetY, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(lblFrameDelay)
            .addGap(2, 2, 2)
            .addComponent(sldFrameDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      tplFrameSeq.addTab("Frame", pnlFrame);

      sldSeqStart.setMajorTickSpacing(12);
      sldSeqStart.setMaximum(60);
      sldSeqStart.setPaintLabels(true);
      sldSeqStart.setPaintTicks(true);
      sldSeqStart.setPaintTrack(false);
      sldSeqStart.setValue(0);
      sldSeqStart.setEnabled(false);
      sldSeqStart.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldSeqStartStateChanged(evt);
         }
      });

      lblSeqOffsetX.setText("Deslocamento X (0px):");
      lblSeqOffsetX.setEnabled(false);

      sldSeqOffsetX.setMaximum(150);
      sldSeqOffsetX.setMinimum(-150);
      sldSeqOffsetX.setPaintLabels(true);
      sldSeqOffsetX.setValue(0);
      sldSeqOffsetX.setEnabled(false);
      sldSeqOffsetX.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldSeqOffsetXStateChanged(evt);
         }
      });

      lblSeqOffsetY.setText("Deslocamento Y (0px):");
      lblSeqOffsetY.setEnabled(false);

      sldSeqOffsetY.setMaximum(150);
      sldSeqOffsetY.setMinimum(-150);
      sldSeqOffsetY.setPaintLabels(true);
      sldSeqOffsetY.setValue(0);
      sldSeqOffsetY.setEnabled(false);
      sldSeqOffsetY.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldSeqOffsetYStateChanged(evt);
         }
      });

      lblSeqDelay.setText("Intervalo (ms):");
      lblSeqDelay.setEnabled(false);

      sldSeqDelay.setMajorTickSpacing(1000);
      sldSeqDelay.setMaximum(2000);
      sldSeqDelay.setPaintLabels(true);
      sldSeqDelay.setPaintTicks(true);
      sldSeqDelay.setPaintTrack(false);
      sldSeqDelay.setValue(0);
      sldSeqDelay.setEnabled(false);
      sldSeqDelay.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldSeqDelayStateChanged(evt);
         }
      });

      lblSeqStart.setText("Início(0):");
      lblSeqStart.setEnabled(false);

      lblSeqEnd.setText("Final(0):");
      lblSeqEnd.setEnabled(false);

      sldSeqEnd.setMajorTickSpacing(12);
      sldSeqEnd.setMaximum(60);
      sldSeqEnd.setPaintLabels(true);
      sldSeqEnd.setPaintTicks(true);
      sldSeqEnd.setPaintTrack(false);
      sldSeqEnd.setValue(0);
      sldSeqEnd.setEnabled(false);
      sldSeqEnd.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            sldSeqEndStateChanged(evt);
         }
      });

      javax.swing.GroupLayout pnlSequenceLayout = new javax.swing.GroupLayout(pnlSequence);
      pnlSequence.setLayout(pnlSequenceLayout);
      pnlSequenceLayout.setHorizontalGroup(
         pnlSequenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(9, 9, 9)
            .addComponent(lblSeqStart, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(sldSeqStart, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lblSeqEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(sldSeqEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lblSeqOffsetX, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addComponent(sldSeqOffsetX, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lblSeqOffsetY, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(sldSeqOffsetY, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lblSeqDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(sldSeqDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      pnlSequenceLayout.setVerticalGroup(
         pnlSequenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pnlSequenceLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(lblSeqStart)
            .addGap(6, 6, 6)
            .addComponent(sldSeqStart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lblSeqEnd)
            .addGap(6, 6, 6)
            .addComponent(sldSeqEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12)
            .addComponent(lblSeqOffsetX)
            .addGap(6, 6, 6)
            .addComponent(sldSeqOffsetX, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(lblSeqOffsetY)
            .addGap(9, 9, 9)
            .addComponent(sldSeqOffsetY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(7, 7, 7)
            .addComponent(lblSeqDelay)
            .addGap(4, 4, 4)
            .addComponent(sldSeqDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      tplFrameSeq.addTab("Sequência", pnlSequence);

      jLabel1.setText("<html><p align=\"justify\">A leitura da propriedade \"<b>Parada</b>\" serve para impedir a repetição da animação. Neste ponto não será exibida nenhuma imagem.</p>");
      jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

      javax.swing.GroupLayout pnlEndLayout = new javax.swing.GroupLayout(pnlEnd);
      pnlEnd.setLayout(pnlEndLayout);
      pnlEndLayout.setHorizontalGroup(
         pnlEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pnlEndLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      pnlEndLayout.setVerticalGroup(
         pnlEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pnlEndLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(182, Short.MAX_VALUE))
      );

      tplFrameSeq.addTab("Parada", pnlEnd);

      jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_good.gif"))); // NOI18N
      jButton5.setEnabled(false);

      cmbFrameSeq.setToolTipText("Lista de Quadros e Sequências");
      cmbFrameSeq.setEnabled(false);
      cmbFrameSeq.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbFrameSeqActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(cmbAnimation, 0, 209, Short.MAX_VALUE)
               .addComponent(cmbAction, 0, 209, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addComponent(btnActionNew, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(0, 0, 0)
                  .addComponent(btnActionDel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addComponent(btnAnimationNew, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(0, 0, 0)
                  .addComponent(btnAnimationDel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(tplFrameSeq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(cmbFrameSeq, 0, 237, Short.MAX_VALUE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, 0))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(cmbAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(cmbAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(btnActionDel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btnActionNew, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(btnAnimationDel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btnAnimationNew, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(cmbFrameSeq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tplFrameSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );

      jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActionDel, btnActionNew, cmbAction});

      jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAnimationDel, btnAnimationNew, cmbAnimation});

      jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbFrameSeq, jButton5});

      jToolBar1.setFloatable(false);
      jToolBar1.setRollover(true);

      btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_xml.gif"))); // NOI18N
      btnNovo.setToolTipText("Novo (Ctrl+N)");
      btnNovo.setFocusable(false);
      btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      btnNovo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNovoActionPerformed(evt);
         }
      });
      jToolBar1.add(btnNovo);

      btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_pasta.gif"))); // NOI18N
      btnAbrir.setToolTipText("Abrir (Ctrl+A)");
      btnAbrir.setEnabled(false);
      btnAbrir.setFocusable(false);
      btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      jToolBar1.add(btnAbrir);

      btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_disquete.gif"))); // NOI18N
      btnSalvar.setToolTipText("Salvar (Ctrl+S)");
      btnSalvar.setEnabled(false);
      btnSalvar.setFocusable(false);
      btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      jToolBar1.add(btnSalvar);
      jToolBar1.add(jSeparator2);

      jToolBar2.setFloatable(false);
      jToolBar2.setRollover(true);

      lblEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_localhost-tmw.png"))); // NOI18N
      lblEstatus.setText("Edita animações de Sprites em Arquivo XML");
      lblEstatus.setAlignmentX(0.5F);
      jToolBar2.add(lblEstatus);

      jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

      cnvPalco.setBackground(java.awt.Color.gray);
      cnvPalco.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
         public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            cnvPalcoMouseWheelMoved(evt);
         }
      });
      cnvPalco.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
         public void mouseMoved(java.awt.event.MouseEvent evt) {
            cnvPalcoMouseMoved(evt);
         }
      });

      scrAltura.setMinimum(15);
      scrAltura.setValue(75);
      scrAltura.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
         public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
            scrAlturaAdjustmentValueChanged(evt);
         }
      });

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addComponent(cnvPalco, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
            .addGap(0, 0, 0)
            .addComponent(scrAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(scrAltura, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
         .addComponent(cnvPalco, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
      );

      mnpArquivo.setText("Arquivo");

      mnuNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
      mnuNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_xml.gif"))); // NOI18N
      mnuNovo.setText("Novo");
      mnuNovo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuNovoActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuNovo);

      mnuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
      mnuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_pasta.gif"))); // NOI18N
      mnuAbrir.setText("Abri");
      mnuAbrir.setEnabled(false);
      mnuAbrir.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuAbrirActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuAbrir);

      mnuSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
      mnuSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_disquete.gif"))); // NOI18N
      mnuSalvar.setMnemonic('S');
      mnuSalvar.setText("Salvar");
      mnuSalvar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSalvarActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuSalvar);

      mnuSalvarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
      mnuSalvarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/sbl_disquete.gif"))); // NOI18N
      mnuSalvarComo.setText("Salvar como...");
      mnuSalvarComo.setEnabled(false);
      mnuSalvarComo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSalvarComoActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuSalvarComo);
      mnpArquivo.add(jSeparator1);

      mnuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
      mnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/fechar.png"))); // NOI18N
      mnuSair.setText("Sair");
      mnuSair.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mnuSairActionPerformed(evt);
         }
      });
      mnpArquivo.add(mnuSair);

      jMenuBar1.add(mnpArquivo);

      mnpAjuda.setText("Ajuda");

      mnuAjudaSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botoes/ajuda.gif"))); // NOI18N
      mnuAjudaSobre.setText("Sobre...");
      mnuAjudaSobre.setEnabled(false);
      mnpAjuda.add(mnuAjudaSobre);

      jMenuBar1.add(mnpAjuda);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
         .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

	private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
		//System.out.close();
		System.exit(0);
	}//GEN-LAST:event_mnuSairActionPerformed
	private void mnuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNovoActionPerformed
		FrmCriarSAS frmAnimacaoNova = new FrmCriarSAS(this, rootPaneCheckingEnabled);
		frmAnimacaoNova.setLocation(
				  ((this.getWidth() - frmAnimacaoNova.getWidth()) / 2) + this.getX(),
				  ((this.getHeight() - frmAnimacaoNova.getHeight()) / 2) + this.getY());
		frmAnimacaoNova.pack();
		frmAnimacaoNova.setModal(true);
		frmAnimacaoNova.setVisible(true);/**/
	}//GEN-LAST:event_mnuNovoActionPerformed
	private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
		mnuNovoActionPerformed(evt);
	}//GEN-LAST:event_btnNovoActionPerformed
	private void cnvPalcoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnvPalcoMouseMoved
		//RedesenhaPalco();
	}//GEN-LAST:event_cnvPalcoMouseMoved
	private void cnvPalcoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_cnvPalcoMouseWheelMoved
		// TODO add your handling code here:
		if(evt.getWheelRotation()>=1){
			if(zoom<4.0) {zoom+=0.1;}
		}else{
			if(zoom>0.4) {zoom-=0.1;}
		}
		//lblEstatus.setText("Zoom = "+Math.scalb(zoom, 2));
		//lblEstatus.setText("Zoom = "+(Math.round(zoom*100)/100));
		lblEstatus.setText("Zoom = "+arredondar(zoom, 1, 1)+"x");
		RedesenhaPalco();
	}//GEN-LAST:event_cnvPalcoMouseWheelMoved
	private void sldFrameImagemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldFrameImagemStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"index",String.valueOf(sldFrameImagem.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldFrameImagemStateChanged
	private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirActionPerformed
		//RedesenhaPalco();
	}//GEN-LAST:event_mnuAbrirActionPerformed
	private void sldSeqStartStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSeqStartStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"start",String.valueOf(sldSeqStart.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldSeqStartStateChanged
	private void sldSeqEndStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSeqEndStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"end",String.valueOf(sldSeqEnd.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldSeqEndStateChanged
	private void cmbActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbActionActionPerformed
		ListarAnimation();
		//ListarFrameSequence();
		//ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_cmbActionActionPerformed
	private void cmbAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnimationActionPerformed
		ListarFrameSequence();
		//ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_cmbAnimationActionPerformed
	private void cmbFrameSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFrameSeqActionPerformed
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_cmbFrameSeqActionPerformed
	private void sldFrameOffsetXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldFrameOffsetXStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"offsetX",String.valueOf(sldFrameOffsetX.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldFrameOffsetXStateChanged
	private void sldFrameOffsetYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldFrameOffsetYStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"offsetY",String.valueOf(sldFrameOffsetY.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldFrameOffsetYStateChanged
	private void scrAlturaAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_scrAlturaAdjustmentValueChanged
		RedesenhaPalco();
	}//GEN-LAST:event_scrAlturaAdjustmentValueChanged
	private void sldSeqOffsetXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSeqOffsetXStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"offsetX",String.valueOf(sldSeqOffsetX.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldSeqOffsetXStateChanged
	private void sldSeqOffsetYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSeqOffsetYStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"offsetY",String.valueOf(sldSeqOffsetY.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldSeqOffsetYStateChanged
	private void sldFrameDelayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldFrameDelayStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"delay",String.valueOf(sldFrameDelay.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldFrameDelayStateChanged
	private void sldSeqDelayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSeqDelayStateChanged
		setPropriedade(xmlMain, cmbAction.getSelectedIndex(), cmbAnimation.getSelectedIndex(), cmbFrameSeq.getSelectedIndex(),"delay",String.valueOf(sldSeqDelay.getValue()));
		ListarPropriedade();
		RedesenhaPalco();
	}//GEN-LAST:event_sldSeqDelayStateChanged

	private void mnuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalvarActionPerformed
		mnuSalvarComoActionPerformed(evt);
	}//GEN-LAST:event_mnuSalvarActionPerformed

	private void mnuSalvarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalvarComoActionPerformed
		FrmSalvarComo frmAnimationSalvarComo = new FrmSalvarComo(this, rootPaneCheckingEnabled);
		frmAnimationSalvarComo.setLocation(
				  ((this.getWidth() - frmAnimationSalvarComo.getWidth()) / 2) + this.getX(),
				  ((this.getHeight() - frmAnimationSalvarComo.getHeight()) / 2) + this.getY());
		frmAnimationSalvarComo.pack();
		frmAnimationSalvarComo.setModal(true);
		frmAnimationSalvarComo.setVisible(true);/**/
	}//GEN-LAST:event_mnuSalvarComoActionPerformed

	public static void main(final String args[]) {
		// TODO code application logic here
		if (args.length >= 2) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					for (int $a = 0; $a < args.length; $a++) {
						//System.out.println(args[$a]);
						if ($a < args.length - 1 && args[$a].toLowerCase().equals("--localhost")) {
							//System.out.println(args[$a]);
							if (FileClass.seExiste(args[$a + 1])) {
								Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
								FrmEditorSAS frmActionEditor = new FrmEditorSAS(args[$a + 1]);
								frmActionEditor.setBounds(
										  (Tela.width - frmActionEditor.getWidth()) / 2,
										  (Tela.height - frmActionEditor.getHeight()) / 2,
										  frmActionEditor.getWidth(), frmActionEditor.getHeight());/**/
								frmActionEditor.setExtendedState(MAXIMIZED_BOTH);
								frmActionEditor.pack();/**/
								frmActionEditor.setVisible(true);
								//new FrmSpawnEditor(args[$a + 1]).setVisible(true);/**/
							} else {
								DialogClass.showErro(
									  "<html>Não foi possível encontrar a pasta do localhost declarada: <br/>"
									  + "<br/>"
									  + " → <font color=\"#FF0000\">" + args[$a + 1] + "</FONT>",
									  "LOCALHOST NÃO ENCONTRADO");
								//System.exit(0);
							}
						}
					}
				}
			});
		} else {
			DialogClass.showErro("<html>Declare a pasta do localhost do TMW pelo argumento: <font color=\"#FF0000\">--localhost \"endereço\"</FONT>", "FALTA DE ARGUMENTO");
			//System.exit(0);
		}
	}
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAbrir;
   public javax.swing.JButton btnActionDel;
   public javax.swing.JButton btnActionNew;
   public javax.swing.JButton btnAnimationDel;
   public javax.swing.JButton btnAnimationNew;
   private javax.swing.JButton btnNovo;
   private javax.swing.JButton btnSalvar;
   public javax.swing.JComboBox cmbAction;
   public javax.swing.JComboBox cmbAnimation;
   public javax.swing.JComboBox cmbFrameSeq;
   private java.awt.Canvas cnvPalco;
   private javax.swing.JButton jButton5;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPopupMenu.Separator jSeparator1;
   private javax.swing.JToolBar.Separator jSeparator2;
   private javax.swing.JToolBar jToolBar1;
   private javax.swing.JToolBar jToolBar2;
   private javax.swing.JLabel lblEstatus;
   private javax.swing.JLabel lblFrameDelay;
   public javax.swing.JLabel lblFrameImagem;
   private javax.swing.JLabel lblFrameOffsetX;
   private javax.swing.JLabel lblFrameOffsetY;
   private javax.swing.JLabel lblSeqDelay;
   public javax.swing.JLabel lblSeqEnd;
   private javax.swing.JLabel lblSeqOffsetX;
   private javax.swing.JLabel lblSeqOffsetY;
   public javax.swing.JLabel lblSeqStart;
   private javax.swing.JMenu mnpAjuda;
   private javax.swing.JMenu mnpArquivo;
   private javax.swing.JMenuItem mnuAbrir;
   private javax.swing.JMenuItem mnuAjudaSobre;
   private javax.swing.JMenuItem mnuNovo;
   private javax.swing.JMenuItem mnuSair;
   private javax.swing.JMenuItem mnuSalvar;
   private javax.swing.JMenuItem mnuSalvarComo;
   public javax.swing.JPanel pnlEnd;
   public javax.swing.JPanel pnlFrame;
   public javax.swing.JPanel pnlSequence;
   private javax.swing.JScrollBar scrAltura;
   private javax.swing.JSlider sldFrameDelay;
   public javax.swing.JSlider sldFrameImagem;
   private javax.swing.JSlider sldFrameOffsetX;
   private javax.swing.JSlider sldFrameOffsetY;
   private javax.swing.JSlider sldSeqDelay;
   public javax.swing.JSlider sldSeqEnd;
   private javax.swing.JSlider sldSeqOffsetX;
   private javax.swing.JSlider sldSeqOffsetY;
   public javax.swing.JSlider sldSeqStart;
   public javax.swing.JTabbedPane tplFrameSeq;
   // End of variables declaration//GEN-END:variables

}
