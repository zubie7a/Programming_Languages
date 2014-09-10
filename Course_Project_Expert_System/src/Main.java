import java.awt.*   ;
import javax.swing.*;

public class Main extends JFrame{
 
  private static final long serialVersionUID = -6726496159882184210L;
 
  Graphi graphi;
  Phics  phics ;
  Middle middle;
  public Main() {
	  this.setTitle("Expert Waiter");
      this.setSize(1280,680)        ;
      this.setResizable(false)      ;

      setLayout(new GridLayout(1,3));
      graphi = new Graphi(this)     ;
      middle = new Middle(this)     ;
      phics = new Phics(this)       ;
      this.add(graphi)              ;
      this.add(middle)              ;
      this.add(phics)               ;
      this.setFocusable(true)       ;
  }
  
  public static void main(String[] args) {
		Main main = new Main(); 
	    main.setVisible(true) ;
  }

public int[] pedirColores() {
	return middle.askColors();
}

public void picasso() {
	graphi.repaint();
	 phics.repaint();
}

public void creatividadEnNombres(String temporal) {
	if(temporal.equals("paella") || temporal.equals("conome") || temporal.equals("gazpacho") || temporal.equals("enalada") || temporal.equals("filete") || temporal.equals("pollo") || temporal.equals("trucha") || temporal.equals("bacalao") || temporal.equals("entrada") || temporal.equals("fuerte")){
		graphi.buscamela(temporal);
	}
	else{
		if(temporal.equals("waffle") || temporal.equals("flan") || temporal.equals("nuece") || temporal.equals("naranja") || temporal.equals("gaeoa") || temporal.equals("agua") || temporal.equals("te") || temporal.equals("cerveza") || temporal.equals("potre")||temporal.equals("bebida")){
			phics.buscamelo(temporal);
		}
	}
}
  
  

}


