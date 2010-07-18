package Classes.XmlDeEquip;

public class XmlAnimacao {
    public XmlAnimacao(String Nome){Banco_Nome=Nome;}
    public XmlAnimacao(String Nome, XmlFrame Frames[]){
        Banco_Nome=Nome;
        Banco_Frames = Frames;
        /*Banco_Frames = new Frame[Frames.length];
        for(int b=0;b<Frames.length;b++){
            Banco_Frames[b] = new Frame();
            Banco_Frames[b].setIndex(Frames[b].getIndex());
            Banco_Frames[b].setOffsetX(Frames[b].getOffsetX());
            Banco_Frames[b].setOffsetY(Frames[b].getOffsetY());
            Banco_Frames[b].setDelay(Frames[b].getDelay());
        }/**/
    }

    private static String Banco_Nome="";
    private static XmlFrame Banco_Frames[]; //Não deve ser instaciado agora!!!!

    public String getNome(){return Banco_Nome;}
    public XmlFrame[] getFrames(){return Banco_Frames;}
    public XmlFrame getFrame(int Ordem){
        if(Banco_Frames != null){
            return Banco_Frames[Ordem];
        }else{
            return null;
        }
    }
    public int getContFrames(){
        if(Banco_Frames != null){
            return Banco_Frames.length;
        }else{
            return 0;
        }
    }

    public void setNome(String NovoNome){Banco_Nome=NovoNome;}
    public void setFrames(XmlFrame Frames[]){Banco_Frames = Frames;}
    public void setFrame(int Ordem, XmlFrame Frame){
        Banco_Frames[Ordem]=Frame;
    }
    public void setNovoFrame(int Index, int OffsetX, int OffsetY, int Delay){
        setNovoFrame(new XmlFrame(Index, OffsetX, OffsetY, Delay));
    }
    public void setNovoFrame(XmlFrame NovoFrame){
        if(Banco_Frames != null){
            XmlFrame Novo_Banco_Frames[] = new XmlFrame[Banco_Frames.length+1];
            for(int b=0;b<Banco_Frames.length;b++){
                Novo_Banco_Frames[b] = new XmlFrame(
                    Banco_Frames[b].getIndex(),
                    Banco_Frames[b].getOffsetX(),
                    Banco_Frames[b].getOffsetY(),
                    Banco_Frames[b].getDelay()
                );
            }
            Novo_Banco_Frames[Banco_Frames.length] = new XmlFrame(
                NovoFrame.getIndex(),
                NovoFrame.getOffsetX(),
                NovoFrame.getOffsetY(),
                NovoFrame.getDelay()
            );
            Banco_Frames = Novo_Banco_Frames;
        }else{
            XmlFrame Novo_Banco_Frames[] = new XmlFrame[1];

            Novo_Banco_Frames[0] = new XmlFrame(
                NovoFrame.getIndex(),
                NovoFrame.getOffsetX(),
                NovoFrame.getOffsetY(),
                NovoFrame.getDelay()
            );
            Banco_Frames = Novo_Banco_Frames;
        }
    }
    public void setNovaSequencia(int IndexInicio, int IndexFinal, int OffsetX, int OffsetY, int Delay){
        for(int f=IndexInicio;f<=IndexFinal;f++){
            setNovoFrame(f, OffsetX, OffsetY, Delay);
        }
    }
}
