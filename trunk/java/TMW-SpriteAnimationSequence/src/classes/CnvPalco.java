/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author lunovox
 */
public class CnvPalco extends Canvas {
	public CnvPalco() {
		
	}
	public CnvPalco(String $Sprite) {
		$Handler = new ImagemClass($Sprite);
	}
	public CnvPalco(Canvas myCanvas, String $Sprite) {
		//throw new UnsupportedOperationException("Not yet implemented");
		$Handler = new ImagemClass($Sprite);
		//this.gc = myCanvas.getGraphicsConfiguration();
		//bounds = gc.getBounds();
	}/**/


	public CnvPalco(GraphicsConfiguration gc) {
		super(gc);
		this.gc = gc;
		bounds = gc.getBounds();
	}
	ImagemClass $Handler;
	GraphicsConfiguration gc;
	Rectangle bounds;

	public Dimension getPreferredSize() {
		return new Dimension(300, 150);
	}

	public void paint(Graphics g) {
		//g.setColor(Color.green);
		//g.fillRect(0, 0, this.getHeight(), this.getHeight()) ;
		//g.clearRect(0, 0, this.getHeight(), this.getHeight());
		//g.clearRect(bounds.x,bounds.y,bounds.height,bounds.width);
		g.clearRect(0, 0, 1000, 1000);
		/*g.setColor(Color.red);
		g.fillRect(0, 0, 100, 150);
		g.setColor(Color.green);
		g.fillRect(100, 0, 100, 150);
		g.setColor(Color.blue);
		g.fillRect(200, 0, 100, 150);
		g.setColor(Color.black);
		//g.drawString("ScreenSize="+Integer.toString(bounds.width)+"X"+ Integer.toString(bounds.height), 10, 15);/**/
		g.drawImage($Handler.getImage(), 0, 0, this);
		//g.drawString(gc.toString(), 10, 30);
		int i = (int) (1 + (Math.random() * 100));
		g.setColor(Color.black);
		g.drawString(String.valueOf(i), 10, 30);
		//g.drawString(bounds.height+" "+bounds.width, 10, 50);

	}

	public void update() {
		repaint();
	}
}
