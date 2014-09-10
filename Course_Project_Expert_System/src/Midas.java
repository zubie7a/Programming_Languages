
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


public class Midas extends JPanel implements ActionListener{

	public static final long serialVersionUID = -4276379850493925908L;

	public final static String FIN = "FINALIZAR";
	public final static String RES = "RESET"    ;
	public final static String APP = "APPLY"    ;
	public final static String ACT = "ACTIVAR"  ;
    public final static String USR = "USUARIOS" ;
    public final static String REQ = "REQUESTS" ;
	public JButton fin    ;
	public JButton reset  ;
	public JButton activa ;
	public JButton aplicar;
	public JButton users;
	public JButton request;

	public JLabel usuario;
	public JLabel excluir;
	public JLabel prec   ;
	public JLabel cal    ;
	
	public JTextField exctex;
	public JTextField prelim;
	public JTextField callim;
	public JTextField user  ;

	public Map<String,int[]> limits;
	public Map<String, ArrayList<String> > exclusion;
	
	public String content ;
	public String temporal;
	public String tip;
	public String ask;
	
	public int tippah;

	public int lim[];
	
	public ArrayList<String> exc;
	public ArrayList<String> present;
	
	public Middle middle;
	

	public Midas(Middle middle){
    	
		present = new ArrayList<String>();
		limits = new TreeMap<String,int[]>();
		exclusion = new TreeMap<String,ArrayList<String> >();
        setLayout(new GridLayout(7, 2));
        setPreferredSize(new Dimension(0, 65));

        TitledBorder borde = BorderFactory.createTitledBorder("Operaciones");
        borde.setTitleColor(Color.white);
        borde.setBorder(BorderFactory.createLineBorder(Color.blue));
        setBorder(borde);
        
        fin     = new JButton("Finalizar cuenta (archivo)");
        reset   = new JButton("Reiniciar campos"          );
        aplicar = new JButton("Crear usuario"             );
        activa  = new JButton("Cambiar de usuario");   
        users   = new JButton("Mostrar usuarios activos");
        request = new JButton("Preguntar");

        excluir = new JLabel("                 Ingredientes a excluir:"       );
        prec    = new JLabel("                         Limite de precio:"     );
        cal     = new JLabel("                       Limite de calorias:"     );
        usuario = new JLabel("                                       Usuario:");

        excluir.setForeground(Color.white); 
           prec.setForeground(Color.white); 
            cal.setForeground(Color.white);
        usuario.setForeground(Color.white);

        exctex = new JTextField("");
        prelim = new JTextField("");
        callim = new JTextField("");
        user   = new JTextField("");
        exctex.setEditable(true);
        prelim.setEditable(true);
        callim.setEditable(true);
          user.setEditable(true);

        exctex.setForeground(Color.black);
        prelim.setForeground(Color.black);
        callim.setForeground(Color.black);
          user.setForeground(Color.black);

        exctex.setBackground(Color.white);
        prelim.setBackground(Color.white);
        callim.setBackground(Color.white);
          user.setBackground(Color.white);

        
            fin.setActionCommand(FIN);
          reset.setActionCommand(RES);
        aplicar.setActionCommand(APP);
         activa.setActionCommand(ACT);
          users.setActionCommand(USR);
        request.setActionCommand(REQ);

        add(prec   );
        add(prelim );
        add(cal    );
        add(callim );
        add(excluir);
        add(exctex );
        add(usuario);
        add(user   );
        add(reset  );
        add(aplicar);        
        add(fin    );
        add(activa );
        add(users  );
        add(request);
        
            fin.addActionListener(this);
          reset.addActionListener(this);
         activa.addActionListener(this);
        aplicar.addActionListener(this);
          users.addActionListener(this);
        request.addActionListener(this);

        
        this.setBackground(Color.DARK_GRAY);
        this.middle = middle;
    }
    
    public void actionPerformed(ActionEvent evento){
    	if(evento.getActionCommand().equals("REQUESTS")){
    		ask=JOptionPane.showInputDialog(this,
    				"Para realizar una pregunta, siga este formato:\n\n"+
    				"Preguntando por una comida:      Muestreme el filete\n"+
    				"Preguntando por una categoria:   Que tienen de platos fuertes?\n"
    				);
			temporal = "";
			if(ask==null){
				ask="z";
			}
			for(int i=0; i<ask.length(); i++){
					if(ask.charAt(i)!=' '){
						temporal = temporal + ask.charAt(i);
					}
					else{
						if(temporal.equals("Muestreme")||temporal.equals("Que")){
							temporal="";
							for(int j=0; j<ask.length(); ++j){
								if(ask.charAt(j)!='?' && ask.charAt(j)!='s'){
									temporal = temporal + ask.charAt(j);
								}
								if(ask.charAt(j)==' '){temporal="";}
							}
							middle.pintora(temporal);
							break;
						}
					}
			  }
    	}
    	if(evento.getActionCommand().equals("USUARIOS")){
    		temporal = "Usuarios activos:\n ---------------------\n";
    		for(int i=0; present!= null && i<present.size(); ++i){
    			temporal = temporal +"\n" + present.get(i);
    		}
    		JOptionPane.showMessageDialog(this,temporal);
    	}
    	if(evento.getActionCommand().equals("FINALIZAR")){
    		limits.put(user.getText(),null);
    		if(user.getText().equals("")){
    			JOptionPane.showMessageDialog(this,"Ingrese un usuario!");
    		}
    		else{
	    		tip = JOptionPane.showInputDialog(this,"Desea dar una propina? en caso de que no, deje vacio.");
	       		try{
	    			tippah =  Integer.parseInt(tip);
	    		}
	    		catch(Exception e){
	    			tippah = 0;
	    		}
	    		if(tippah>0){
	        		JOptionPane.showMessageDialog(this, "Muchas gracias!");
	    		}
	    		else{
	        		JOptionPane.showMessageDialog(this, "Malagradecido!!!");
	    		}
	    		middle.getTheHellOut(tippah);
	    		exclusion.put(user.getText(),null);
	    		middle.eraser(user.getText());
	    		present.remove(user.getText());
	    		middle.pintor();
	    		middle.limpiador();
	    		prelim.setText("");
	    		callim.setText("");
	        	  user.setText("");
	    		exctex.setText("");
    		}
    	}
    	if(evento.getActionCommand().equals("ACTIVAR")){
    		middle.cuentaUpdate(middle.getComida(user.getText()), user.getText());
			middle.establecerLimites(limits.get(user.getText()),exclusion.get(user.getText()));
			middle.nombrar(user.getText());
			lim = new int[2];
			lim = limits.get(user.getText());
			try{
				if(lim[0]<1000000){
					prelim.setText(Integer.toString(lim[0]));
				}
				else{
					prelim.setText("");
				}
			}
			catch(Exception e){
				prelim.setText("");
			}
			try{
				if(lim[1]<1000000){
					callim.setText(Integer.toString(lim[1]));
				}
				else{
					callim.setText("");
				}
			}
			catch(Exception e){
				callim.setText("");
			}
    		middle.pintor();
    	}
    	if(evento.getActionCommand().equals("RESET")){
    		middle.limpiador();
    		prelim.setText("");
    		callim.setText("");
        	  user.setText("");
    		exctex.setText("");
    		middle.pintor();
    	}
    	if(evento.getActionCommand().equals("APPLY")){
    		if(user.getText().equals("")){
    			JOptionPane.showMessageDialog(this,"Ingrese un usuario al cual aplicar los parametros!");
    		}
    		else{
    			exc = new ArrayList<String>();
    			lim = new int[2];
    			if(prelim.getText().equals("")){
    				lim[0] = 1152442748;
    			}
    			else{
    				lim[0] = Integer.parseInt(prelim.getText());
    			}
    			if(callim.getText().equals("")){
    				lim[1] = 1152442748;
    			}
    			else{
    				lim[1] = Integer.parseInt(callim.getText());
    			}
    			content = exctex.getText();
    			temporal = "";
    			for(int i=0; i<content.length(); ++i){
    				if(content.charAt(i)!=',' && content.charAt(i)!=' '){
    					temporal = temporal + content.charAt(i);
    				}
    				else{
    					if(temporal.compareTo("")!=0){
    						exc.add(temporal);
    					}
    					temporal = "";
    				}
    			}
    			middle.limpiador();
    			exc.add(temporal);
    			   limits.put(     user.getText(), lim);
    			exclusion.put(     user.getText(), exc);
        		   middle.creaUser(user.getText()     );
        	   if(present.contains(user.getText())==false){
        			   present.add(user.getText()     );
        		   }
    			   middle.nombrar( user.getText()     );
    			   middle.establecerLimites(lim,exc   );
    		}
    	}
    	
    }

	public void metaliza(int[] parlim) {
		if(parlim[0]<1000000){
			prelim.setText(Integer.toString(parlim[0]));
		}
		else{
			prelim.setText("");
		}
		if(parlim[1]<1000000){
			callim.setText(Integer.toString(parlim[1]));
		}
		else{
			callim.setText("");
		}
	}
}
