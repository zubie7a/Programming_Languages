import java.awt.*         ;
import javax.swing.*      ;
import java.util.ArrayList;


public class Middle extends JPanel{

	public static final long serialVersionUID = -4276379850493925908L;

    public final static String ALFA = "ALFA"; 
    
	public JLabel sortearAlfa ;
	public JTextField input   ;
    public ArrayList<String> a;
    
	public Main main  ;
	public Midup midup;
	public Midas midas;
	public Midon midon;
    
    public Middle(Main main){
    	
        setLayout(new GridLayout(3, 1));
        
        midup = new Midup(this);
        midas = new Midas(this);
        midon = new Midon(this);
        
        add(midup);
        add(midas);
        add(midon);
        
        this.main = main;
    }
    public void cuentaUpdate(ArrayList<String> food,String nombre){
    	midon.cuentaActualiza(food,nombre);
    }
    
    public void creaUser(String nombre){
    	midon.nuevoUser(nombre);
    	midup.creaUsar(nombre) ;
    }
    
    public void establecerLimites(int[] lim, ArrayList<String> exc){
    	midup.limitador(lim,exc);
    }
    
    public void limpiador(){
    	midup.cleanse();
    	midon.bleach() ;
    }
    
    public void nombrar(String nema){
		midup.poner(nema);
	}
    
	public ArrayList<String> getComida(String neko) {
		return midup.dameComida(neko);
	}
	
	public void eraser(String chao) {
		midup.sayonara(chao);
		midon.aurevoir(chao);
	}
	public int[] askColors() {
		return midup.colores();
	}
	public void pintor() {
		main.picasso();		
	}
	public void getTheHellOut(int tip) {
		midon.outtaHere(tip);
	}
	public void pintora(String temporal) {
		main.creatividadEnNombres(temporal);
	}
	public void socializa(int[] parlim) {
		midas.metaliza(parlim);
	}
}
