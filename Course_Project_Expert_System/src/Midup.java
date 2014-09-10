
import javax.swing.*                ;
import javax.swing.border.*         ;
import java.awt.Color               ;
import java.awt.Dimension           ;
import java.awt.GridLayout          ;
import java.awt.event.ActionEvent   ;
import java.awt.event.ActionListener;
import java.util.ArrayList          ;
import java.util.Map                ;
import java.util.TreeMap            ;


public class Midup extends JPanel implements ActionListener{

	public static final long serialVersionUID = -4276379850493925908L;
	
	public final static String AGREGAR = "AGREGAR";
	
	public ArrayList<String> food;
	
	public Map<String, ArrayList<String> > comidas;
	public Map<String, ArrayList<String> > dteler;
	public Map<String, int[]> lteder;	
	
	public JCheckBox filete  ;
	public JCheckBox trucha  ;
	public JCheckBox ensalada;
	public JCheckBox bacalao ;
	public JCheckBox pollo   ;
	public JCheckBox consome ;
	public JCheckBox gazpacho;
	public JCheckBox flan    ;
	public JCheckBox nueces  ;
	public JCheckBox waffle  ;
	public JCheckBox naranja ;
	public JCheckBox paella  ;
	public JCheckBox agua    ;
	public JCheckBox te      ;
	public JCheckBox gaseosa ;
	public JCheckBox cerveza ;
	
	public JLabel entradas;
	public JLabel platof  ;
	public JLabel drink   ;
	public JLabel postre  ;
	public JLabel name1   ;
	public JLabel name2   ;
	
	public boolean entra;
	public boolean teven;
	
	public String prevname;
	public String verif   ;


	public JButton pedido   ;	
	public JTextField nombre;
	public Middle middle    ;
	public int[] parlim     ;
	public int[] lapize     ;

	public Midup(Middle middle){
    	
		lteder  = new TreeMap<String, int[]>();
		comidas = new TreeMap<String, ArrayList<String> >();
		dteler  = new TreeMap<String, ArrayList<String> >();

        setLayout(new GridLayout(6, 4));
        setPreferredSize(new Dimension(0, 65));
        TitledBorder borde = BorderFactory.createTitledBorder("Comidas Restaurante");
        borde.setTitleColor(Color.white);
        borde.setBorder(BorderFactory.createLineBorder(Color.magenta.darker()));
        setBorder(borde);
        
        
        nombre = new JTextField("");
        nombre.setEditable(false)  ;
        prevname = "";
        pedido = new JButton("Agregar");
        
        name1    = new JLabel("       Usuario que");
        name2    = new JLabel("  hace pedido:")    ;
        entradas = new JLabel("Entradas:")         ;
        platof   = new JLabel("Plato Fuerte:")     ;
        postre   = new JLabel("Postres:")          ;
        drink    = new JLabel("Bebidas:")          ;
        
            agua = new JCheckBox("Agua")    ;
              te = new JCheckBox("Te")      ;
         gaseosa = new JCheckBox("Gaseosa") ;
         cerveza = new JCheckBox("Cerveza") ;
        ensalada = new JCheckBox("Ensalada");
          waffle = new JCheckBox("Waffle")  ;
          filete = new JCheckBox("Filete")  ;
          paella = new JCheckBox("Paella")  ;
          trucha = new JCheckBox("Trucha")  ;
           pollo = new JCheckBox("Pollo")   ;
         bacalao = new JCheckBox("Bacalao") ;
         consome = new JCheckBox("Consome") ;
        gazpacho = new JCheckBox("Gazpacho");
            flan = new JCheckBox("Flan")    ;
          nueces = new JCheckBox("Nueces")  ;
         naranja = new JCheckBox("Naranja") ;
        
           name1.setForeground(Color.white);
           name2.setForeground(Color.white);
        entradas.setForeground(Color.white);
          platof.setForeground(Color.white);
          postre.setForeground(Color.white);
           drink.setForeground(Color.white);
            agua.setForeground(Color.white);
              te.setForeground(Color.white);
         gaseosa.setForeground(Color.white);
         cerveza.setForeground(Color.white);
        ensalada.setForeground(Color.white);
          waffle.setForeground(Color.white);
          filete.setForeground(Color.white);
          paella.setForeground(Color.white);
          trucha.setForeground(Color.white);
           pollo.setForeground(Color.white);
         bacalao.setForeground(Color.white);
         consome.setForeground(Color.white);
        gazpacho.setForeground(Color.white);
            flan.setForeground(Color.white);
          nueces.setForeground(Color.white);
         naranja.setForeground(Color.white);


        add(entradas);
        add(platof)  ;
        add(postre)  ;
        add(drink)   ;
        
        add(paella) ;
        add(filete) ;
        add(waffle) ;
        add(gaseosa);
        
        add(consome);
        add(pollo)  ;
        add(flan)   ;
        add(te)     ;
        
        add(gazpacho);       
        add(trucha)  ;
        add(nueces)  ;
        add(agua)    ;
        
        add(ensalada);      
        add(bacalao) ;
        add(naranja) ;
        add(cerveza) ;
        
        add(name1) ;
        add(name2) ;
        add(nombre);
        add(pedido);
        
      pedido.setActionCommand(AGREGAR);

        agua.setActionCommand("AGUA")    ;
          te.setActionCommand("TE")      ;
     gaseosa.setActionCommand("GASEOSA") ;
     cerveza.setActionCommand("CERVEZA") ;
    ensalada.setActionCommand("ENSALADA");
      waffle.setActionCommand("WAFFLE")  ;
      filete.setActionCommand("FILETE")  ;
      paella.setActionCommand("PAELLA")  ;
      trucha.setActionCommand("TRUCHA")  ;
       pollo.setActionCommand("POLLO")   ;
     bacalao.setActionCommand("BACALAO") ;
     consome.setActionCommand("CONSOME") ;
    gazpacho.setActionCommand("GAZPACHO");
        flan.setActionCommand("FLAN")    ;
      nueces.setActionCommand("NUECES")  ;
     naranja.setActionCommand("NARANJA") ;

      pedido.addActionListener(this);

        agua.addActionListener(this);
          te.addActionListener(this);
     gaseosa.addActionListener(this);
     cerveza.addActionListener(this);
    ensalada.addActionListener(this);
      waffle.addActionListener(this);
      filete.addActionListener(this);
      paella.addActionListener(this);
      trucha.addActionListener(this);
       pollo.addActionListener(this);
     bacalao.addActionListener(this);
     consome.addActionListener(this);
    gazpacho.addActionListener(this);
        flan.addActionListener(this);
      nueces.addActionListener(this);
     naranja.addActionListener(this);
        
        this.setBackground(Color.DARK_GRAY);
        this.middle = middle;
    }
    
    public void actionPerformed(ActionEvent evento){ 
        if (evento.getActionCommand() == "AGUA"){
			if(eventual()){
				if(agua.isSelected()==true){
					parlim[0] -= 2500;
					parlim[1] -= 10;
				}
				else{
					parlim[0] += 2500;
					parlim[1] += 10;
				}
				middle.socializa(parlim);
				limitadorValores(parlim,dteler.get(nombre.getText()),"AGUA");
				lteder.put(nombre.getText(),parlim);
			}
			else{
				agua.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "TE"){
			if(eventual()){
	        	if(te.isSelected()==true){
	        		parlim[0] -= 3000;
	        		parlim[1] -= 150;
	        	}
	        	else{
	        		parlim[0] += 3000;
	        		parlim[1] += 150;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"TE");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				te.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "GASEOSA"){
			if(eventual()){
	        	if(gaseosa.isSelected()==true){
	        		parlim[0] -= 2500;
	        		parlim[1] -= 300;
	        	}
	        	else{
	        		parlim[0] += 2500;
	        		parlim[1] += 300;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"GASEOSA");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				gaseosa.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "CERVEZA"){
			if(eventual()){
	        	if(cerveza.isSelected()==true){
	        		parlim[0] -= 3500;
	        		parlim[1] -= 400;
	        	}
	        	else{
	        		parlim[0] += 3500;
	        		parlim[1] += 400;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"CERVEZA");
	        	lteder.put(nombre.getText(),parlim);
        	}
			else{
				cerveza.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "ENSALADA"){
			if(eventual()){
	        	if(ensalada.isSelected()==true){
	        		parlim[0] -= 9000;
	        		parlim[1] -= 75;
	        	}
	        	else{
	        		parlim[0] += 9000;
	        		parlim[1] += 75;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"ENSALADA");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				ensalada.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "WAFFLE"){
			if(eventual()){
	        	if(waffle.isSelected()==true){
	        		parlim[0] -= 8000;
	        		parlim[1] -= 500;
	        	}
	        	else{
	        		parlim[0] += 8000;
	        		parlim[1] += 500;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"WAFFLE");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				waffle.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "FILETE"){
			if(eventual()){
	        	if(filete.isSelected()==true){
	        		parlim[0] -= 21000;
	        		parlim[1] -= 400;
	        	}
	        	else{
	        		parlim[0] += 21000;
	        		parlim[1] += 400;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"FILETE");
	        	lteder.put(nombre.getText(),parlim);
        	}
			else{
				filete.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "PAELLA"){
			if(eventual()){
	        	if(paella.isSelected()==true){
	        		parlim[0] -= 10000;
	        		parlim[1] -= 200;
	        	}
	        	else{
	        		parlim[0] += 10000;
	        		parlim[1] += 200;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"PAELLA");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				paella.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "TRUCHA"){
			if(eventual()){
	        	if(trucha.isSelected()==true){
	        		parlim[0] -= 20000;
	        		parlim[1] -= 160;
	        	}
	        	else{
	        		parlim[0] += 20000;
	        		parlim[1] += 160;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"TRUCHA");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				trucha.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "POLLO"){
        	if(eventual()){
	        	if(pollo.isSelected()==true){
	        		parlim[0] -= 14000;
	        		parlim[1] -= 280;
	        	}
	        	else{
	        		parlim[0] += 14000;
	        		parlim[1] += 280;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"POLLO");
	        	lteder.put(nombre.getText(),parlim);
        	}
        	else{
				pollo.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "BACALAO"){
			if(eventual()){
	        	if(bacalao.isSelected()==true){
	        		parlim[0] -= 18000;
	        		parlim[1] -= 300;
	        	}
	        	else{
	        		parlim[0] += 18000;
	        		parlim[1] += 300;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"BACALAO");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				bacalao.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "CONSOME"){
			if(eventual()){
	        	if(consome.isSelected()==true){
	        		parlim[0] -= 7000;
	        		parlim[1] -= 300;
	        	}
	        	else{
	        		parlim[0] += 7000;
	        		parlim[1] += 300;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"CONSOME");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				consome.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "GAZPACHO"){
			if(eventual()){
	        	if(gazpacho.isSelected()==true){
	        		parlim[0] -= 8000;
	        		parlim[1] -= 150;
	        	}
	        	else{
	        		parlim[0] += 8000;
	        		parlim[1] += 150;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"GAZPACHO");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				gazpacho.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "FLAN"){
			if(eventual()){
	        	if(flan.isSelected()==true){
	        		parlim[0] -= 6000;
	        		parlim[1] -= 200;
	        	}
	        	else{
	        		parlim[0] += 6000;
	        		parlim[1] += 200;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"FLAN");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				flan.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "NUECES"){
			if(eventual()){
				if(nueces.isSelected()==true){
	        		parlim[0] -= 8000;
	        		parlim[1] -= 400;
	        	}
	        	else{
	        		parlim[0] += 8000;
	        		parlim[1] += 400;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"NUECES");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				nueces.setSelected(false);
			}
        }
        if (evento.getActionCommand() == "NARANJA"){
			if(eventual()){
	        	if(naranja.isSelected()==true){
	        		parlim[0] -= 5000;
	        		parlim[1] -= 150;
	        	}
	        	else{
	        		parlim[0] += 5000;
	        		parlim[1] += 150;
	        	}
				middle.socializa(parlim);
	        	limitadorValores(parlim,dteler.get(nombre.getText()),"NARANJA");
	        	lteder.put(nombre.getText(),parlim);
			}
			else{
				naranja.setSelected(false);
			}
        }
    	if(evento.getActionCommand().equals(AGREGAR)){
    		if(nombre.getText().equals("")){
    			JOptionPane.showMessageDialog(this, "Ingrese un usuario!");
    		}
    		else{
    			entra=false;
    			food = new ArrayList<String>();
    			food = comidas.get(nombre.getText());
    			if(    agua.isSelected()==true){    food.add(    agua.getActionCommand());  entra=true;      agua.setSelected(false);}
    			if(      te.isSelected()==true){    food.add(      te.getActionCommand());  entra=true;        te.setSelected(false);}
   				if( gaseosa.isSelected()==true){    food.add( gaseosa.getActionCommand());  entra=true;   gaseosa.setSelected(false);}
   				if( cerveza.isSelected()==true){    food.add( cerveza.getActionCommand());  entra=true;   cerveza.setSelected(false);}
   				if(  waffle.isSelected()==true){    food.add(  waffle.getActionCommand());  entra=true;    waffle.setSelected(false);}
   				if(    flan.isSelected()==true){    food.add(    flan.getActionCommand());  entra=true;      flan.setSelected(false);}
   				if(  nueces.isSelected()==true){    food.add(  nueces.getActionCommand());  entra=true;    nueces.setSelected(false);}
    			if( naranja.isSelected()==true){    food.add( naranja.getActionCommand());  entra=true;   naranja.setSelected(false);}
    			if(  trucha.isSelected()==true){    food.add(  trucha.getActionCommand());  entra=true;    trucha.setSelected(false);}
    			if( bacalao.isSelected()==true){    food.add( bacalao.getActionCommand());  entra=true;   bacalao.setSelected(false);}
   				if(  filete.isSelected()==true){    food.add(  filete.getActionCommand());  entra=true;    filete.setSelected(false);}
   				if(   pollo.isSelected()==true){    food.add(   pollo.getActionCommand());  entra=true;     pollo.setSelected(false);}
   				if(  paella.isSelected()==true){    food.add(  paella.getActionCommand());  entra=true;    paella.setSelected(false);}
    			if(gazpacho.isSelected()==true){    food.add(gazpacho.getActionCommand());  entra=true;  gazpacho.setSelected(false);}
    			if(ensalada.isSelected()==true){    food.add(ensalada.getActionCommand());  entra=true;  ensalada.setSelected(false);}
    			if( consome.isSelected()==true){    food.add( consome.getActionCommand());  entra=true;   consome.setSelected(false);}
   				if(entra==true){
   				                     	comidas.put(nombre.getText(), food);
   					middle.cuentaUpdate(comidas.get(nombre.getText()),nombre.getText());
   					    limitadorValores(lteder.get(nombre.getText()),dteler.get(nombre.getText()),"");
   				}
    			else{
   	    			JOptionPane.showMessageDialog(this, "Ingrese un ingrediente al menos!");
    			}
    		}
    	}
    }

	public void limitador(int[] lim, ArrayList<String> exc) {
		lteder.put(nombre.getText(), lim);
		dteler.put(nombre.getText(), exc);
		    agua.setEnabled(true);
	          te.setEnabled(true);
		 gaseosa.setEnabled(true);
		 cerveza.setEnabled(true);	
		  waffle.setEnabled(true);
		    flan.setEnabled(true);
		  nueces.setEnabled(true);
		 naranja.setEnabled(true);
    	  trucha.setEnabled(true);
		 bacalao.setEnabled(true);
		  filete.setEnabled(true);
		   pollo.setEnabled(true);
		  paella.setEnabled(true);
		gazpacho.setEnabled(true);
		ensalada.setEnabled(true);
	     consome.setEnabled(true);
	     parlim = new int[2];
	     parlim = lteder.get(prevname);
	     if(    agua.isSelected()==true){  parlim[0] += 2500 ; parlim[1] += 10 ;     agua.setSelected(false); }
		 if(      te.isSelected()==true){  parlim[0] += 3000 ; parlim[1] += 150;       te.setSelected(false); }  
		 if( gaseosa.isSelected()==true){  parlim[0] += 2500 ; parlim[1] += 300;  gaseosa.setSelected(false); }
	  	 if( cerveza.isSelected()==true){  parlim[0] += 3500 ; parlim[1] += 400;  cerveza.setSelected(false); }
		 if(  waffle.isSelected()==true){  parlim[0] += 8000 ; parlim[1] += 500;   waffle.setSelected(false); }
		 if(    flan.isSelected()==true){  parlim[0] += 6000 ; parlim[1] += 200;     flan.setSelected(false); }
		 if(  nueces.isSelected()==true){  parlim[0] += 8000 ; parlim[1] += 400;   nueces.setSelected(false); }
		 if( naranja.isSelected()==true){  parlim[0] += 5000 ; parlim[1] += 150;  naranja.setSelected(false); }
	  	 if(  trucha.isSelected()==true){  parlim[0] += 20000; parlim[1] += 160;   trucha.setSelected(false); }
		 if( bacalao.isSelected()==true){  parlim[0] += 18000; parlim[1] += 300;  bacalao.setSelected(false); }
		 if(  filete.isSelected()==true){  parlim[0] += 21000; parlim[1] += 400;   filete.setSelected(false); }
		 if(   pollo.isSelected()==true){  parlim[0] += 14000; parlim[1] += 280;    pollo.setSelected(false); }
		 if(  paella.isSelected()==true){  parlim[0] += 10000; parlim[1] += 200;   paella.setSelected(false); }
		 if(gazpacho.isSelected()==true){  parlim[0] += 8000 ; parlim[1] += 150; gazpacho.setSelected(false); }
		 if(ensalada.isSelected()==true){  parlim[0] += 9000 ; parlim[1] += 75 ; ensalada.setSelected(false); }
		 if( consome.isSelected()==true){  parlim[0] += 7000 ; parlim[1] += 300;  consome.setSelected(false); }
		 lteder.put(prevname,parlim);
	     if(lim!=null || exc!=null){
	    	limitadorValores(lim,exc,"");
	    }
	} 

	public void limitadorValores(int[] lim, ArrayList<String> exc, String come){
		middle.pintor();
		if((lim[1]>=10  || lim[0]>=2500 ) && !come.equals("AGUA"    )){     agua.setEnabled(true);}
		if((lim[1]>=150 || lim[0]>=3000 ) && !come.equals("TE"      )){       te.setEnabled(true);}
		if((lim[1]>=300 || lim[0]>=2500 ) && !come.equals("GASEOSA" )){  gaseosa.setEnabled(true);}
		if((lim[1]>=400 || lim[0]>=3500 ) && !come.equals("CERVEZA" )){  cerveza.setEnabled(true);}
		if((lim[1]>=500 || lim[0]>=8000 ) && !come.equals("WAFFLE"  )){   waffle.setEnabled(true);}
		if((lim[1]>=200 || lim[0]>=6000 ) && !come.equals("FLAN"    )){     flan.setEnabled(true);}
		if((lim[1]>=400 || lim[0]>=8000 ) && !come.equals("NUECES"  )){   nueces.setEnabled(true);}
		if((lim[1]>=150 || lim[0]>=5000 ) && !come.equals("NARANJA" )){  naranja.setEnabled(true);}
		if((lim[1]>=160 || lim[0]>=20000) && !come.equals("TRUCHA"  )){   trucha.setEnabled(true);}
		if((lim[1]>=300 || lim[0]>=18000) && !come.equals("BACALAO" )){  bacalao.setEnabled(true);}
		if((lim[1]>=400 || lim[0]>=21000) && !come.equals("FILETE"  )){   filete.setEnabled(true);}
		if((lim[1]>=280 || lim[0]>=14000) && !come.equals("POLLO"   )){    pollo.setEnabled(true);}
		if((lim[1]>=200 || lim[0]>=10000) && !come.equals("PAELLA"  )){   paella.setEnabled(true);}
		if((lim[1]>=150 || lim[0]>=8000 ) && !come.equals("GAZPACHO")){ gazpacho.setEnabled(true);}
		if((lim[1]>=75  || lim[0]>=9000 ) && !come.equals("ENSALADA")){ ensalada.setEnabled(true);}
		if((lim[1]>=300 || lim[0]>=7000 ) && !come.equals("CONSOME" )){  consome.setEnabled(true);}

		if((lim[1]<10  || lim[0]<2500 ) && !come.equals("AGUA"    )){     agua.setEnabled(false);}
		if((lim[1]<150 || lim[0]<3000 ) && !come.equals("TE"      )){       te.setEnabled(false);}
		if((lim[1]<300 || lim[0]<2500 ) && !come.equals("GASEOSA" )){  gaseosa.setEnabled(false);}
		if((lim[1]<400 || lim[0]<3500 ) && !come.equals("CERVEZA" )){  cerveza.setEnabled(false);}
		if((lim[1]<500 || lim[0]<8000 ) && !come.equals("WAFFLE"  )){   waffle.setEnabled(false);}
		if((lim[1]<200 || lim[0]<6000 ) && !come.equals("FLAN"    )){     flan.setEnabled(false);}
		if((lim[1]<400 || lim[0]<8000 ) && !come.equals("NUECES"  )){   nueces.setEnabled(false);}
		if((lim[1]<150 || lim[0]<5000 ) && !come.equals("NARANJA" )){  naranja.setEnabled(false);}
		if((lim[1]<160 || lim[0]<20000) && !come.equals("TRUCHA"  )){   trucha.setEnabled(false);}
		if((lim[1]<300 || lim[0]<18000) && !come.equals("BACALAO" )){  bacalao.setEnabled(false);}
		if((lim[1]<400 || lim[0]<21000) && !come.equals("FILETE"  )){   filete.setEnabled(false);}
		if((lim[1]<280 || lim[0]<14000) && !come.equals("POLLO"   )){    pollo.setEnabled(false);}
		if((lim[1]<200 || lim[0]<10000) && !come.equals("PAELLA"  )){   paella.setEnabled(false);}
		if((lim[1]<150 || lim[0]<8000 ) && !come.equals("GAZPACHO")){ gazpacho.setEnabled(false);}
		if((lim[1]<75  || lim[0]<9000 ) && !come.equals("ENSALADA")){ ensalada.setEnabled(false);}
		if((lim[1]<300 || lim[0]<7000 ) && !come.equals("CONSOME" )){  consome.setEnabled(false);}
		
		
		for(int i=0; i<exc.size(); ++i){
			verif = exc.get(i);
			if(verif.equals("agua"    )){     agua.setEnabled(false);}
			if(verif.equals("te"      )){       te.setEnabled(false);}
			if(verif.equals("gaseosa" )){  gaseosa.setEnabled(false);}
			if(verif.equals("cerveza" )){  cerveza.setEnabled(false);}
			if(verif.equals("waffle"  )){   waffle.setEnabled(false);}
			if(verif.equals("flan"    )){     flan.setEnabled(false);}
			if(verif.equals("nueces"  )){   nueces.setEnabled(false);}
			if(verif.equals("naranja" )){  naranja.setEnabled(false);}
			if(verif.equals("trucha"  )){   trucha.setEnabled(false);}
			if(verif.equals("bacalao" )){  bacalao.setEnabled(false);}
			if(verif.equals("filete"  )){   filete.setEnabled(false);}
			if(verif.equals("pollo"   )){    pollo.setEnabled(false);}
			if(verif.equals("paella"  )){   paella.setEnabled(false);}
			if(verif.equals("gazpacho")){ gazpacho.setEnabled(false);}
			if(verif.equals("ensalada")){ ensalada.setEnabled(false);}
			if(verif.equals("consome" )){  consome.setEnabled(false);}
		}
	} 
	
	
	public void cleanse(){
	      agua.setSelected(false);
	        te.setSelected(false);
	   gaseosa.setSelected(false);
	   cerveza.setSelected(false);
	    waffle.setSelected(false);
          flan.setSelected(false);
        nueces.setSelected(false);
	   naranja.setSelected(false);
	    trucha.setSelected(false);
	   bacalao.setSelected(false);
	    filete.setSelected(false);
	     pollo.setSelected(false);
	    paella.setSelected(false);
	  gazpacho.setSelected(false);
	  ensalada.setSelected(false);
	   consome.setSelected(false);
	      agua.setEnabled(true)  ;
            te.setEnabled(true)  ;
	   gaseosa.setEnabled(true)  ;
	   cerveza.setEnabled(true)  ;	
	    waffle.setEnabled(true)  ;
	      flan.setEnabled(true)  ;
	    nueces.setEnabled(true)  ;
	   naranja.setEnabled(true)  ;
	    trucha.setEnabled(true)  ;
	   bacalao.setEnabled(true)  ;
	    filete.setEnabled(true)  ;
	     pollo.setEnabled(true)  ;
	    paella.setEnabled(true)  ;
	  gazpacho.setEnabled(true)  ;
	  ensalada.setEnabled(true)  ;
       consome.setEnabled(true)  ;
        nombre.setText("")       ;
	}
	public boolean eventual(){
		if(comidas.get(nombre.getText())==null){
			JOptionPane.showMessageDialog(this, "Cree un usuario con parametros antes de escoger!");
			return false;
		}
		else{
			parlim = new int[2];
			parlim = lteder.get(nombre.getText());
			return true;
		}
	}
	public void creaUsar(String nama){
		food = new ArrayList<String>();
		comidas.put(nama,food);
	}
	
	public void poner(String nema){
		prevname = nombre.getText();
		nombre.setText(nema);
	}
	
	public ArrayList<String> dameComida(String naka){
		return comidas.get(naka);
	}

	public void sayonara(String chao) {
		comidas.put(chao,null);
		 lteder.put(chao,null);
		 dteler.put(chao,null);
	}

	public int[] colores() {
		 lapize = new int[16];
		 for(int i=0;i<16;++i){
			 lapize[i]=2;
		 }
	     if(    agua.isEnabled()==false){lapize[ 0]=1;}
		 if(      te.isEnabled()==false){lapize[ 1]=1;} 
		 if( gaseosa.isEnabled()==false){lapize[ 2]=1;}
	  	 if( cerveza.isEnabled()==false){lapize[ 3]=1;}
		 if(  waffle.isEnabled()==false){lapize[ 4]=1;}
		 if(    flan.isEnabled()==false){lapize[ 5]=1;}
		 if(  nueces.isEnabled()==false){lapize[ 6]=1;}
		 if( naranja.isEnabled()==false){lapize[ 7]=1;}
	  	 if(  trucha.isEnabled()==false){lapize[ 8]=1;}
		 if( bacalao.isEnabled()==false){lapize[ 9]=1;}
		 if(  filete.isEnabled()==false){lapize[10]=1;}
		 if(   pollo.isEnabled()==false){lapize[11]=1;}
		 if(  paella.isEnabled()==false){lapize[12]=1;}
		 if(gazpacho.isEnabled()==false){lapize[13]=1;}
		 if(ensalada.isEnabled()==false){lapize[14]=1;}
		 if( consome.isEnabled()==false){lapize[15]=1;}

	     if(    agua.isSelected()==true){lapize[ 0]=0;}
		 if(      te.isSelected()==true){lapize[ 1]=0;} 
		 if( gaseosa.isSelected()==true){lapize[ 2]=0;}
	  	 if( cerveza.isSelected()==true){lapize[ 3]=0;}
		 if(  waffle.isSelected()==true){lapize[ 4]=0;}
		 if(    flan.isSelected()==true){lapize[ 5]=0;}
		 if(  nueces.isSelected()==true){lapize[ 6]=0;}
		 if( naranja.isSelected()==true){lapize[ 7]=0;}
	  	 if(  trucha.isSelected()==true){lapize[ 8]=0;}
		 if( bacalao.isSelected()==true){lapize[ 9]=0;}
		 if(  filete.isSelected()==true){lapize[10]=0;}
		 if(   pollo.isSelected()==true){lapize[11]=0;}
		 if(  paella.isSelected()==true){lapize[12]=0;}
		 if(gazpacho.isSelected()==true){lapize[13]=0;}
		 if(ensalada.isSelected()==true){lapize[14]=0;}
		 if( consome.isSelected()==true){lapize[15]=0;}

		return lapize;
	}
}