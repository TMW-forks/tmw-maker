package Classes;

public class XmlFrame {
    public XmlFrame(int NovoIndex){
        index=NovoIndex;
    }
    public XmlFrame(int NovoIndex, int NovoOffsetX, int NovoOffsetY, int NovoDelay){
        index=NovoIndex;
        offsetX=NovoOffsetX;
        offsetY=NovoOffsetY;
        delay=NovoDelay;
    }

    private static int index = 0;
    private static int offsetX = 0;
    private static int offsetY = 0;
    private static int delay = 0;

    public int getIndex(){return index;}
    public int getOffsetX(){return offsetX;}
    public int getOffsetY(){return offsetY;}
    public int getDelay(){return delay;}

    public void setIndex(int NovoIndex){index=NovoIndex;}
    public void setOffsetX(int NovoOffsetX){offsetX=NovoOffsetX;}
    public void setOffsetY(int NovoOffsetY){offsetY=NovoOffsetY;}
    public void setDelay(int NovoDelay){delay=NovoDelay;}
}
