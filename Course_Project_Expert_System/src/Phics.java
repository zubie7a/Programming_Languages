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

public class Phics extends JComponent implements MouseMotionListener, MouseListener{
	
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
	
	public Phics (Main main){
		  sen = new boolean[8];
		  stat = new int[16];
		  v=170;
		  w=170;
	      this.setSize(430,680);
	      
	      press=false;
	      
		  Y2=-184;
		  Y3=-184;
		  
		  try {
			  url2 = new URL("http://i42.tinypic.com/23sxgdi.png") ;
			  url3 = new URL("http://i44.tinypic.com/8yi0ef.png");
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
		  g.fillOval(25, v, 30, 30);
		  g.fillOval(25, v+312, 30, 30);
		  g.fillOval(25, v+630, 30, 30);
		  g.fillOval(25, v+945, 30, 30);
		  g.fillOval(240, w, 30, 30);
		  g.fillOval(240, w+314, 30, 30);
		  g.fillOval(240, w+630, 30, 30);
		  g.fillOval(240, w+945, 30, 30);
		  
		  g.setColor(Color.cyan);
		  if(stat[4]==0){g.setColor(Color.green);}
		  if(stat[4]==1){g.setColor(Color.red);}
		  g.fillOval(28, v+3, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[5]==0){g.setColor(Color.green);}
		  if(stat[5]==1){g.setColor(Color.red);}
		  g.fillOval(28, v+3+312, 24,24);
	
		  g.setColor(Color.cyan);
		  if(stat[6]==0){g.setColor(Color.green);}
		  if(stat[6]==1){g.setColor(Color.red);}
		  g.fillOval(28, v+3+630, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[7]==0){g.setColor(Color.green);}
		  if(stat[7]==1){g.setColor(Color.red);}
		  g.fillOval(28, v+3+945, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[2]==0){g.setColor(Color.green);}
		  if(stat[2]==1){g.setColor(Color.red);}
		  g.fillOval(243, w+3, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[1]==0){g.setColor(Color.green);}
		  if(stat[1]==1){g.setColor(Color.red);}
		  g.fillOval(243, w+3+314, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[0]==0){g.setColor(Color.green);}
		  if(stat[0]==1){g.setColor(Color.red);}
		  g.fillOval(243, w+3+630, 24,24);
		  
		  g.setColor(Color.cyan);
		  if(stat[3]==0){g.setColor(Color.green);}
		  if(stat[3]==1){g.setColor(Color.red);}
		  g.fillOval(243, w+3+945, 24,24);
		  
		  if(sen[0]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(14, 42, 168, 285, 10, 10);
		  }
		  if(sen[1]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(14, 357, 168, 285, 10, 10);
		  }
		  if(sen[2]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(14, 18, 168, 285, 10, 10);
		  }
		  if(sen[3]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(14, 333, 168, 285, 10, 10);
		  }
		  if(sen[4]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(14+215, 41, 168, 285, 10, 10);
		  }
		  if(sen[5]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(14+215, 356, 168, 285, 10, 10);
		  }
		 if(sen[6]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(14+215, 17, 168, 285, 10, 10);
		  }
		  if(sen[7]==true){
			  g.setColor(Color.white);
			  g.drawRoundRect(14+215, 332, 168, 285, 10, 10);
		  }
	}
	public void buscamelo(String temporal) {
		if(temporal.equals("potre")){
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
		if(temporal.equals("bebida")){
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
		if(temporal.equals("waffle") || temporal.equals("flan") || temporal.equals("nuece") || temporal.equals("naranja")){
			if(temporal.equals("waffle")||temporal.equals("flan")){
				while(Y2<-184){
					Y2+=4;
					v+=4;
					if(Y2>-184){
						Y2 = -184;
					}
					delayah();
					paintImmediately(0,0,1000,1000);
				}
				if(temporal.equals("waffle")){
					sen[0] = true;
				}
				if(temporal.equals("flan")){
					sen[1] = true;
				}
			}
			if(temporal.equals("nuece")||temporal.equals("naranja")){
				while(Y2>-840){
					Y2-=4;
					v-=4;
					if(Y2<-840){
						Y2 = -840;
					}
					delayah();
					paintImmediately(0,0,1000,1000);
				}
				if(temporal.equals("nuece")){
					sen[2] = true;
				}
				if(temporal.equals("naranja")){
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
		if(temporal.equals("gaeoa") || temporal.equals("te") || temporal.equals("agua") || temporal.equals("cerveza")){
			if(temporal.equals("gaeoa")||temporal.equals("te")){
				while(Y3<-184){
					Y3+=4;
					w+=4;
					if(Y3>-184){
						Y3 = -184;
					}
					delayah();
					paintImmediately(0,0,1000,1000);
				}
				if(temporal.equals("gaeoa")){
					sen[4] = true;
				}
				if(temporal.equals("te")){
					sen[5] = true;
				}
			}
			if(temporal.equals("agua")||temporal.equals("cerveza")){
				while(Y3>-840){
					Y3-=4;
					w-=4;
					if(Y3<-840){
						Y3 = -840;
					}
					delayah();
					paintImmediately(0,0,1000,1000);
				}
				if(temporal.equals("agua")){
					sen[6] = true;
				}
				if(temporal.equals("cerveza")){
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
			Thread.sleep(10);
		}
		catch(Exception e){
			
		}
	}
}
	