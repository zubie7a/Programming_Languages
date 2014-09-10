import javax.imageio.ImageIO             ;
import javax.swing.*                     ;
import java.awt.Color                    ;
import java.awt.Dimension                ;
import java.awt.Graphics                 ;
import java.awt.Image                    ;
import java.awt.event.MouseEvent         ;
import java.awt.event.MouseListener      ;
import java.awt.event.MouseMotionListener;
import java.io.IOException               ;
import java.net.MalformedURLException    ;
import java.net.URL                      ;

public class Graphi extends JComponent implements MouseMotionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;
	
	public Main main;
	private int Y2;
	private int Y3;
	private int x;
	private int y;
	private int y1;
	private int v;
	private int w;
	
	private URL url2;
	private URL url3;
	
	private Image image ;
	private Image image2;
	private Image image3;
	boolean press;
	boolean sen[];
	
	private int[] stat;
	
	public Graphi (Main main){
		  sen = new boolean[8];
		  stat = new int[16];
		  v=170;
		  w=170;
	      this.setSize(430,680);
	      
	      press=false;
	      
		  Y2=-184;
		  Y3=-184;
		  
		  try {
			  url2 = new URL("http://i43.tinypic.com/20htxjt.png");
			  url3 = new URL("http://i39.tinypic.com/23w01o3.jpg");
		  }
		  catch (MalformedURLException e) {}
		  
		  try {
			image2 = ImageIO.read(url2);
			image3 = ImageIO.read(url3);
		  }
		  catch (IOException e) {}
		  
		  addMouseMotionListener(this);
		        addMouseListener(this);
		              setVisible(true);
		              
		  this.main = main;		
    }
	

	public void mouseEntered(MouseEvent e){}
	public void  mouseExited(MouseEvent e){}  
	public void mouseClicked(MouseEvent e){}

	public void mousePressed(MouseEvent e){
		press=true;
	}
	
	public void mouseReleased(MouseEvent e){
		press=false;
    }
	  
	public void mouseMoved(MouseEvent event) {
		if(press==true){
			x = (int) event.getPoint().getX()    ;
			y = (int) event.getPoint().getY()-840;
			if(x>0 && x<215){
				if(y>y1){
					Y2+=(y-y1);
				}
				if(y<y1){
					Y2-=(y1-y);
				}
				if(Y2>-184){
					Y2=-184;
				}
				if(Y2<-840){
					Y2=-840;
				}
				v = Y2+184+170;				
			}
			
			if(x>215 && x<430){
				if(y>y1){
					Y3+=(y-y1);
				}
				if(y<y1){
					Y3-=(y1-y);	
				}
				if(Y3>-184){
					Y3=-184;
				}
				if(Y3<-840){
					Y3=-840;
				}
				w = Y3+184+170;				
			}
			repaint();
			y1= y;
		}
		else{
			y1 = (int) event.getPoint().getY() - 840;	
		}
	}
	
	public void mouseDragged(MouseEvent event) {
		 mouseMoved(event);
	}
	
	public void paint(Graphics g) {
		  Dimension dim = getSize();
		  checkImage();
		  Graphics graphics = image.getGraphics();
		  graphics.setColor(getBackground());
		  graphics.fillRect(0, 0, dim.width, dim.height);
		  paintOffscreen(image.getGraphics());
		  g.drawImage(image, 0, 0, null);
	 }
	  
	 private void checkImage() {
		  Dimension dim = getSize();
		  if (image == null || image.getWidth(null) != dim.width || image.getHeight(null) != dim.height) {
			 image = createImage(dim.width, dim.height);
		  }
	  }
	  
	  public void paintOffscreen(Graphics g) {
		  
		  stat = main.pedirColores();
		  g.drawImage(image3, 215, Y3, this);
		  g.drawImage(image2, 0, Y2,   this);
		  
		  g.setColor(Color.DARK_GRAY.brighter());
		  g.fillOval(157, v, 30, 30);
		  g.fillOval(157, v+316, 30, 30);
		  g.fillOval(157, v+631, 30, 30);
		  g.fillOval(157, v+947, 30, 30);
		  g.fillOval(373, w, 30, 30);
		  g.fillOval(372, w+314, 30, 30);
		  g.fillOval(372, w+631, 30, 30);
		  g.fillOval(372, w+946, 30, 30);
		  
		  g.setColor(Color.cyan);
		  if(stat[12]==0){g.setColor(Color.green);}
		  if(stat[12]==1){g.setColor(Color.red);}
		  g.fillOval(160, v+3, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[15]==0){g.setColor(Color.green);}
		  if(stat[15]==1){g.setColor(Color.red);}
		  g.fillOval(160, v+3+316, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[13]==0){g.setColor(Color.green);}
		  if(stat[13]==1){g.setColor(Color.red);}
		  g.fillOval(160, v+3+631, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[14]==0){g.setColor(Color.green);}
		  if(stat[14]==1){g.setColor(Color.red);}
		  g.fillOval(160, v+3+947, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[10]==0){g.setColor(Color.green);}
		  if(stat[10]==1){g.setColor(Color.red);}
		  g.fillOval(376, w+3, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[11]==0){g.setColor(Color.green);}
		  if(stat[11]==1){g.setColor(Color.red);}
		  g.fillOval(375, w+3+314, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[8]==0){g.setColor(Color.green);}
		  if(stat[8]==1){g.setColor(Color.red);}
		  g.fillOval(375, w+3+631, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[9]==0){g.setColor(Color.green);}
		  if(stat[9]==1){g.setColor(Color.red);}
		  g.fillOval(375, w+3+946, 24,24);
		  
		  if(sen[0]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(32, 42, 168, 285, 10, 10);
		  }
		  if(sen[1]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(32, 357, 168, 285, 10, 10);
		  }
		  if(sen[2]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(32, 18, 168, 285, 10, 10);
		  }
		  if(sen[3]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(32, 333, 168, 285, 10, 10);
		  }
		  if(sen[4]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(32+215, 41, 168, 285, 10, 10);
		  }
		  if(sen[5]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(32+215, 356, 168, 285, 10, 10);
		  }
		  if(sen[6]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(32+215, 17, 168, 285, 10, 10);
		  }
		  if(sen[7]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(32+215, 332, 168, 285, 10, 10);
		  }
	}
	public void buscamela(String temporal) {
		if(temporal.equals("entrada")){
			while(Y2<-184){
				Y2+=3;
				v+=3;
				if(Y2>-184){
					Y2 = -184;
				}
				delayah();
				paintImmediately(0,0,1000,1000);
			}
			while(Y2>-840){
				Y2-=1;
				v-=1;
				if(Y2<-840){
					Y2 = -840;
				}
				delayah();
				paintImmediately(0,0,1000,1000);
			}
		}
		if(temporal.equals("fuerte")){
			while(Y3<-184){
				Y3+=3;
				w+=3;
				if(Y3>-184){
					Y3 = -184;
				}
				delayah();
				paintImmediately(0,0,1000,1000);
			}
			while(Y3>-840){
				Y3-=1;
				w-=1;
				if(Y3<-840){
					Y3 = -840;
				}
				delayah();
				paintImmediately(0,0,1000,1000);
			}
		}
		if(temporal.equals("paella") || temporal.equals("conome") || temporal.equals("gazpacho") || temporal.equals("enalada")){
			if(temporal.equals("paella")||temporal.equals("conome")){
				while(Y2<-184){
					Y2+=4;
					v+=4;
					if(Y2>-184){
						Y2 = -184;
					}
					delayah();
					paintImmediately(0,0,1000,1000);
				}
				if(temporal.equals("paella")){
					sen[0] = true;
				}
				if(temporal.equals("conome")){
					sen[1] = true;
				}
			}
			if(temporal.equals("gazpacho")||temporal.equals("enalada")){
				while(Y2>-840){
					Y2-=4;
					v-=4;
					if(Y2<-840){
						Y2 = -840;
					}
					delayah();
					paintImmediately(0,0,1000,1000);
				}
				if(temporal.equals("gazpacho")){
					sen[2] = true;
				}
				if(temporal.equals("enalada")){
					sen[3] = true;
				}
			}
			
			for(int i=0;i<300;++i){
				paintImmediately(0,0,1000,1000);
				delayah();
			}
			sen[0]=false;
			sen[1]=false;
			sen[2]=false;
			sen[3]=false;
			repaint();
		}
		if(temporal.equals("filete") || temporal.equals("pollo") || temporal.equals("trucha") || temporal.equals("bacalao")){
			if(temporal.equals("filete")||temporal.equals("pollo")){
				while(Y3<-184){
					Y3+=4;
					w+=4;
					if(Y3>-184){
						Y3 = -184;
					}
					delayah();
					paintImmediately(0,0,1000,1000);
				}
				if(temporal.equals("filete")){
					sen[4] = true;
				}
				if(temporal.equals("pollo")){
					sen[5] = true;
				}
			}
			if(temporal.equals("trucha")||temporal.equals("bacalao")){
				while(Y3>-840){
					Y3-=4;
					w-=4;
					if(Y3<-840){
						Y3 = -840;
					}
					delayah();
					paintImmediately(0,0,1000,1000);
				}
				if(temporal.equals("trucha")){
					sen[6] = true;
				}
				if(temporal.equals("bacalao")){
					sen[7] = true;
				}
			}
			
			for(int i=0;i<300;++i){
				paintImmediately(0,0,1000,1000);
				delayah();
			}
			sen[4]=false;
			sen[5]=false;
			sen[6]=false;
			sen[7]=false;
			repaint();
		}
	}	
	public void delayah(){
		try{
			Thread.sleep(1);
		}
		catch(Exception e){
			
		}
	}

}
	