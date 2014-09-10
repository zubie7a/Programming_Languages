
import javax.swing.*             ;
import javax.swing.border.*      ;
import java.awt.Color            ;
import java.awt.Dimension        ;
import java.awt.GridLayout       ;
import java.io.BufferedWriter    ;
import java.io.FileWriter        ;
import java.util.ArrayList       ;
import java.util.Map             ;  
import java.util.TreeMap         ;
import java.util.Calendar        ;
import java.text.SimpleDateFormat;


public class Midon extends JPanel{
	
	public FileWriter fstream; 
	public BufferedWriter out;
	public static final long serialVersionUID = -4276379850493925908L;
	public static final String DATE_FORMAT_NOW = "yyyy:MM:dd HH.mm.ss";
	public Middle middle;
	public JTextArea area;
	public Map<String, int[]> cantidad;
	public String nam;
	public JScrollPane scroll;
	public int[] contador;
	public boolean alga;
	public int totalp;
	public int totalc;
    public Calendar cal;
    public SimpleDateFormat sdf;

	
	public Midon(Middle middle){
		
		cantidad = new TreeMap<String, int[] >();
        setLayout(new GridLayout(1, 1));
        setPreferredSize(new Dimension(0, 65));
        TitledBorder borde = BorderFactory.createTitledBorder("Salida");
        borde.setTitleColor(Color.white);
        borde.setBorder(BorderFactory.createLineBorder(Color.cyan.darker()));
        setBorder(borde);
        this.setBackground(Color.DARK_GRAY);
        
        area = new JTextArea("", 20, 32);
        area.setEditable(false);
        area.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        scroll = new JScrollPane(area);

        add(scroll);
        this.middle = middle;
    }
	
	public void nuevoUser(String name){
		if(cantidad.get(name)==null){
			contador = new int[16];
			cantidad.put(name, contador);
			nam=name;
		}
	}
    public void cuentaActualiza(ArrayList<String> food, String nombre){
    	alga = false;
    	nam = nombre;
    	contador = new int[16];
    	for(int i=0; food!=null && i<food.size(); ++i){
    		if(food.get(i)=="AGUA"){    contador[ 0]++; alga = true;}
    		if(food.get(i)=="TE"){      contador[ 1]++; alga = true;}
    		if(food.get(i)=="GASEOSA"){ contador[ 2]++; alga = true;}
    		if(food.get(i)=="CERVEZA"){ contador[ 3]++; alga = true;}
    		if(food.get(i)=="WAFFLE"){  contador[ 4]++; alga = true;}
    		if(food.get(i)=="FLAN"){    contador[ 5]++; alga = true;}
    		if(food.get(i)=="NUECES"){  contador[ 6]++; alga = true;}
    		if(food.get(i)=="NARANJA"){ contador[ 7]++; alga = true;}
    		if(food.get(i)=="TRUCHA"){  contador[ 8]++; alga = true;}
    		if(food.get(i)=="BACALAO"){ contador[ 9]++; alga = true;}
    		if(food.get(i)=="FILETE"){  contador[10]++; alga = true;}
    		if(food.get(i)=="POLLO"){   contador[11]++; alga = true;}
    		if(food.get(i)=="PAELLA"){  contador[12]++; alga = true;}
    		if(food.get(i)=="GAZPACHO"){contador[13]++; alga = true;}
    		if(food.get(i)=="ENSALADA"){contador[14]++; alga = true;}
    		if(food.get(i)=="CONSOME"){ contador[15]++; alga = true;}
    	}
    	if(alga==true){
    		cantidad.put(nombre,contador);
    	}
    	if(cantidad.get(nombre)==null){
    		JOptionPane.showMessageDialog(this, "El usuario " + nombre + " no existe!");
    	}
    	else{
			middle.nombrar(nombre);
    		area.setText("");
    		totalp=0;
    		totalc=0;
        	area.append("Cuenta de "+nombre+":\n"+"---------------------\n");
        	if(contador[ 0]>0){area.append("Agua \t x"    +contador[ 0] + "\t Precio:" +  2500*contador[ 0] + "\t Calorias: " +  10*contador[ 0] + "\n"); totalc +=   10*contador[ 0];  totalp +=  2500*contador[ 0];}
        	if(contador[ 1]>0){area.append("Te \t x"      +contador[ 1] + "\t Precio:" +  3000*contador[ 1] + "\t Calorias: " + 150*contador[ 1] + "\n"); totalc +=  150*contador[ 1];  totalp +=  3000*contador[ 1];}
        	if(contador[ 2]>0){area.append("Gaseosa \t x" +contador[ 2] + "\t Precio:" +  2500*contador[ 2] + "\t Calorias: " + 300*contador[ 2] + "\n"); totalc +=  300*contador[ 2];  totalp +=  2500*contador[ 2];}
        	if(contador[ 3]>0){area.append("Cerveza \t x" +contador[ 3] + "\t Precio:" +  3500*contador[ 3] + "\t Calorias: " + 400*contador[ 3] + "\n"); totalc +=  400*contador[ 3];  totalp +=  3500*contador[ 3];}
        	if(contador[ 4]>0){area.append("Waffle \t x"  +contador[ 4] + "\t Precio:" +  8000*contador[ 4] + "\t Calorias: " + 500*contador[ 4] + "\n"); totalc +=  500*contador[ 4];  totalp +=  8000*contador[ 4];}
        	if(contador[ 5]>0){area.append("Flan \t x"    +contador[ 5] + "\t Precio:" +  6000*contador[ 5] + "\t Calorias: " + 200*contador[ 5] + "\n"); totalc +=  200*contador[ 5];  totalp +=  6000*contador[ 5];}
        	if(contador[ 6]>0){area.append("Nueces \t x"  +contador[ 6] + "\t Precio:" +  8000*contador[ 6] + "\t Calorias: " + 400*contador[ 6] + "\n"); totalc +=  400*contador[ 6];  totalp +=  8000*contador[ 6];}
        	if(contador[ 7]>0){area.append("Naranja \t x" +contador[ 7] + "\t Precio:" +  5000*contador[ 7] + "\t Calorias: " + 150*contador[ 7] + "\n"); totalc +=  150*contador[ 7];  totalp +=  5000*contador[ 7];}
        	if(contador[ 8]>0){area.append("Trucha \t x"  +contador[ 8] + "\t Precio:" + 20000*contador[ 8] + "\t Calorias: " + 160*contador[ 8] + "\n"); totalc +=  160*contador[ 8];  totalp += 20000*contador[ 8];}
        	if(contador[ 9]>0){area.append("Bacalao \t x" +contador[ 9] + "\t Precio:" + 18000*contador[ 9] + "\t Calorias: " + 300*contador[ 9] + "\n"); totalc +=  300*contador[ 9];  totalp += 18000*contador[ 9];}
        	if(contador[10]>0){area.append("Filete \t x"  +contador[10] + "\t Precio:" + 21000*contador[10] + "\t Calorias: " + 400*contador[10] + "\n"); totalc +=  400*contador[10];  totalp += 21000*contador[10];}
        	if(contador[11]>0){area.append("Pollo \t x"   +contador[11] + "\t Precio:" + 14000*contador[11] + "\t Calorias: " + 280*contador[11] + "\n"); totalc +=  280*contador[11];  totalp += 14000*contador[11];}
        	if(contador[12]>0){area.append("Paella \t x"  +contador[12] + "\t Precio:" + 10000*contador[12] + "\t Calorias: " + 200*contador[12] + "\n"); totalc +=  200*contador[12];  totalp += 10000*contador[12];}
        	if(contador[13]>0){area.append("Gazpacho \t x"+contador[13] + "\t Precio:" +  8000*contador[13] + "\t Calorias: " + 150*contador[13] + "\n"); totalc +=  150*contador[13];  totalp +=  8000*contador[13];}
        	if(contador[14]>0){area.append("Ensalada \t x"+contador[14] + "\t Precio:" +  9000*contador[14] + "\t Calorias: " +  75*contador[14] + "\n"); totalc +=   75*contador[14];  totalp +=  9000*contador[14];}
        	if(contador[15]>0){area.append("Consome \t x" +contador[15] + "\t Precio:" +  7000*contador[15] + "\t Calorias: " + 300*contador[15] + "\n"); totalc +=  300*contador[15];  totalp +=  7000*contador[15];}
        	area.append("---------------------\n"+"Precio total: "+totalp+"\t Calorias totales: "+totalc);
    	}
    }
    public void bleach(){
    	area.setText("");
    }

	public void aurevoir(String chao) {
		cantidad.put(chao,null);
	}
	
	public void outtaHere(int tip){
	   try{
		    cal = Calendar.getInstance();
		    sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    fstream = new FileWriter(nam+" "+sdf.format(cal.getTime())+".txt");
			out = new BufferedWriter(fstream);
			totalp+=tip;
     	    out.write("\n"+
     	    		  "\n" +
     	    		  "\n" +
     	    		  "\n" +
     	    		  "\t\t   UNIVERSIDAD EAFIT" +
     	    		  "\n" +
     	    		  "\n" +
     	    		  "      El restaurante en la esquina del universo" +
     	    		  "\n" +
     	    		  "\n" +
     	    		  "\n" +
     	    		  "\t\t  NIT. 1.152.442.748" +
     	    		  "\n" +
     	    		  "\t\t  Tel. 815-416-2342" +
     	    		  "\n" +
     	    		  "\n" +
     	    		  "\n" + 
     	    		  area.getText() + 
     	    		  "\n" +
     	    		  "\n" +
     	    		  "Propina: "+tip +
     	    		  "\n" +
     	    		  "\n" +
     	    		  "Total definitivo: "+totalp
     	    		  );
	        out.close();
	   }
	   catch (Exception e){}  
	}
	
}


