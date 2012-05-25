package Classes;

import classes.FileClass;
import Formularios.FrmPrincipal;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TranslateClass {
    public TranslateClass(){
        idiomaXML=FrmPrincipal.Config.getPastaDoSistema()+barra+"translate_"+FrmPrincipal.Config.getIdiomaDoSistema()+".xml";
        if(!FileClass.seExiste(idiomaXML)){
            String myURL="http://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Traducoes/translate_"+FrmPrincipal.Config.getIdiomaDoSistema()+".xml";
            String Conteudo = FileClass.urlAbrir(myURL);
            if(Conteudo!=null && !Conteudo.equals("")) FileClass.arquivoSalvar(idiomaXML, Conteudo);
        }   
        //idiomaXML=System.getProperty("user.home")+System.getProperty("file.separator")+"translate_en.xml";
        //http://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Traducoes/translate_en.xml
        abrirTraducao(idiomaXML);
    }
    public TranslateClass(String Endereco){
        idiomaXML=Endereco;
        abrirTraducao(Endereco);
    }
    static String barra = System.getProperty("file.separator");
    private String idiomaXML = "";
    private String language="pt";
    private String by="";
    private String email="";
    private String update="";

    private FormClass Formularios[]=null;

    private void abrirTraducao(String Endereco){
        if(FileClass.seExiste(Endereco)){
            Element Elementos=FileClass.arquivoAbrirXML(Endereco);
            NodeList noProperties = Elementos.getElementsByTagName("properties");
            if(noProperties.getLength()>=1){
                Element tagProperties = (Element) noProperties.item(0);
                language=FileClass.getAtributo(tagProperties,"language","pt");
                by=FileClass.getAtributo(tagProperties,"by","");
                email=FileClass.getAtributo(tagProperties,"email","");
                update=FileClass.getAtributo(tagProperties,"update","");
            }
            NodeList noFormularios = Elementos.getElementsByTagName("form");
            for(int F=0;F<noFormularios.getLength();F++){
                Element tagFormularios = (Element) noFormularios.item(F);
                addFormulario(FileClass.getAtributo(tagFormularios,"name",""));
                NodeList noTranslate = tagFormularios.getElementsByTagName("translate");
                for(int T=0;T<noTranslate.getLength();T++){
                    Element tagTranslate = (Element) noTranslate.item(T);
                    getFormularioPorOrdem(getContFormulario()-1).addComponente(FileClass.getAtributo(tagTranslate,"id",""),tagTranslate.getFirstChild().getTextContent());
                }
            }
        }
    }
    public String getTraducao(String Formulario, String ID){
        return getTraducao(Formulario, ID, "");
    }
    public String getNortizacao(String Testo){
        StringClass testoNormativador = new StringClass(Testo);
        testoNormativador.setSubstituicao("[html]", "<html>");
        testoNormativador.setSubstituicao("[/html]", "</html>");
        testoNormativador.setSubstituicao("[br]", "<br/>");
        testoNormativador.setSubstituicao("[br/]", "<br/>");
        testoNormativador.setSubstituicao("[b]", "<b>");
        testoNormativador.setSubstituicao("[/b]", "</b>");
        testoNormativador.setSubstituicao("[i]", "<i>");
        testoNormativador.setSubstituicao("[/i]", "</i>");
        testoNormativador.setSubstituicao("[u]", "<u>");
        testoNormativador.setSubstituicao("[/u]", "</u>");
        testoNormativador.setSubstituicao("[/font]", "</font>");
        testoNormativador.setSubstituicao("[color[", "<font color=\"");
        testoNormativador.setSubstituicao("]color]", "\">");
        testoNormativador.setSubstituicao("[/color]", "</font>");
        return testoNormativador.getTesto();
    }
    public String getTraducaoNormatizada(String Formulario, String ID, String TestoAlternativo){
        return getNortizacao(getTraducao(Formulario, ID, TestoAlternativo));
    }
    public String getTraducaoNormatizada(String Formulario, String ID, String TestoAlternativo, String Variaveis){
        return getNortizacao(getTraducao(Formulario, ID, TestoAlternativo, Variaveis));
    }
    public String getTraducaoNormatizada(String Formulario, String ID, String TestoAlternativo, String Variaveis[]){
        return getNortizacao(getTraducao(Formulario, ID, TestoAlternativo, Variaveis));
    }
    public String getTraducao(String Formulario, String ID, String TestoAlternativo, String Variaveis){
        String Partes[] = Variaveis.split("&&");
        return getTraducao(Formulario, ID, TestoAlternativo, Partes);
    }
    public String getTraducao(String Formulario, String ID, String TestoAlternativo, String Variaveis[]){
        String Testo = getTraducao(Formulario, ID, TestoAlternativo);
        for(int v=0;v<Variaveis.length;v++){
            Testo=Testo.replaceAll("%"+(v+1), Variaveis[v]);
        }
        return Testo;
    }
    public String getTraducao(String Formulario, String ID, String TestoAlternativo){
        FormClass Form = getFormularioPorNome(Formulario);
        if(Form != null){
            FormClass.ComponenteClass Comp = Form.getFormularioPorID(ID);
            if(Comp != null){return Comp.getTraducao();}
        }
        return TestoAlternativo;
    }
    public String getEnderecoXML(){return idiomaXML;}
    public int getContFormulario(){
        if(Formularios != null) return Formularios.length;
        return 0;
    }
    public FormClass getFormularioPorOrdem(int ordem){
        if(Formularios != null) return Formularios[ordem];
        return null;
    }
    public FormClass getFormularioPorNome(String Nome){
        if(Formularios != null){
            for(int ordem=0;ordem<Formularios.length;ordem++){
                if(Formularios[ordem].getNome().equals(Nome)){
                    return Formularios[ordem];
                }
            }
        }
        return null;
    }
    public void addFormulario(String Nome){
        if(Formularios != null){
            FormClass novosFormularios[] = new FormClass[getContFormulario()+1];
            for(int b=0;b<getContFormulario();b++){
                novosFormularios[b]=getFormularioPorOrdem(b);
            }
            novosFormularios[Formularios.length] = new FormClass(Nome);
            Formularios = novosFormularios;
        }else{
            FormClass novosFormularios[] = new FormClass[1];
            novosFormularios[0] = new FormClass(Nome);
            Formularios = novosFormularios;
        }
    }

    public class FormClass {
        private String Nome="";
        private ComponenteClass Componentes[]=null;
        public FormClass(String Nome){
            setNome(Nome);
        }
        public String getNome(){return Nome;}
        public void setNome(String novoNome){Nome=novoNome;}

        public int getContComponente(){
            if(Componentes != null) return Componentes.length;
            return 0;
        }
        public ComponenteClass getComponentePorOrdem(int ordem){
            if(Componentes != null) return Componentes[ordem];
            return null;
        }
        public ComponenteClass getFormularioPorID(String ID){
            if(Componentes != null){
                for(int ordem=0;ordem<Componentes.length;ordem++){
                    if(Componentes[ordem].getID().equals(ID)){
                        return Componentes[ordem];
                    }
                }
            }
            return null;
        }

        public void addComponente(String novoID, String novaTraducao){
            if(Componentes != null){
                ComponenteClass novosComponentes[] = new ComponenteClass[getContComponente()+1];
                for(int b=0;b<getContComponente();b++){
                    novosComponentes[b]=getComponentePorOrdem(b);
                }
                novosComponentes[Componentes.length] = new ComponenteClass(novoID, novaTraducao);
                Componentes = novosComponentes;
            }else{
                ComponenteClass novosComponentes[] = new ComponenteClass[1];
                novosComponentes[0] = new ComponenteClass(novoID, novaTraducao);
                Componentes = novosComponentes;
            }
        }
        public class ComponenteClass {
            private String id="";
            private String traducao="";
            public ComponenteClass(String novoID, String novaTraducao){
                setID(novoID);
                setTraducao(novaTraducao);
            }
            public String getID(){return id;}
            public void setID(String novoID){id=novoID;}
            public String getTraducao(){return traducao;}
            public void setTraducao(String novaTraducao){traducao=novaTraducao;}
        }
    }
}
