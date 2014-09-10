#pragma once
#include<set>
#include<iostream>
#include<string>
#include<map>
#include<vector>
#include<cmath>
#include<sstream>

using namespace std;

set <string> xac;
set <string> unity;
set <string> disjoint;
set <string> carnes;
set <string> entradas;
set <string> pescados;
set <string> postres;
set <string> init;
set <string> final;
set <string> comidas;
set <string> ingredientes;
vector <string> carne;
vector <string> pescado;
vector <string> postre;
vector <string> entrada;
vector <string> output;
vector < vector<string> > outa;
map <string,int> precios;
map <string,int> calorias;
map <string,int> gens;
int precio;
int calor;
string sale;

void inicializadorSets(){
	precios["paella"]=10000;
	precios["gazpacho"]=8000;
	precios["consome"]=7000;
	precios["filete"]=21000;
	precios["trucha"]=20000;
	precios["bacalao"]=18000;
	precios["pollo"]=14000;
	precios["flan"]=6000;
	precios["nueces"]=8000;
	precios["naranja"]=5000;
	
	
	calorias["paella"]=200;
	calorias["gazpacho"]=150;
	calorias["consome"]=300;
	calorias["filete"]=400;
	calorias["trucha"]=160;
	calorias["bacalao"]=300;
	calorias["pollo"]=280;
	calorias["flan"]=200;
	calorias["nueces"]=500;
	calorias["naranja"]=50;
	
	carne.push_back("filete");
	carne.push_back("pollo");
	entrada.push_back("paella");
	entrada.push_back("gazpacho");
	entrada.push_back("consome");
	pescado.push_back("trucha");
	pescado.push_back("bacalao");
	postre.push_back("flan");
	postre.push_back("nueces");
	postre.push_back("naranja");
	
	for(int i=0; i<carne.size(); ++i){
		carnes.insert(carne[i]);
		ingredientes.insert(carne[i]);
	}
	for(int i=0; i<entrada.size(); ++i){
		entradas.insert(entrada[i]);
		ingredientes.insert(entrada[i]);
	}
	for(int i=0; i<pescado.size(); ++i){
		pescados.insert(pescado[i]);
		ingredientes.insert(pescado[i]);
	}
	for(int i=0; i<postre.size(); ++i){
		postres.insert(postre[i]);
		ingredientes.insert(postre[i]);
	}
	
	init.insert("Que");
	init.insert("Generar");
	final.insert("venden?");
	final.insert("restaurante");
	comidas.insert("postres");
	comidas.insert("carnes");
	comidas.insert("pescados");
	comidas.insert("entradas");
	
}

bool inicial(string x){
	if(init.find(x)!=init.end()){
		return true;
	}
	return false;
}


bool fin(string x){
	if(final.find(x)!=final.end()){
		return true;
	}
	return false;
}


/*4 parametros. 
 ax = la string que tiene todos los ingredientes, ya sea los que toca incluir o toca excluir
 bx = el booleano que indica que es un pedido especifico, no todos los posibles, si es verdadero hace un chorro de validaciones, si es falso se las salta y simplemente imprime todos los pedidos posibles del restaurante
 diverse = el booleano que siendo falso indica que los ingredientes a incluir son inclusivos. que quiere decir esto? que yo dije " con trucha y flan" o algo asi, osea, indica que la lista de ingredientes para incluir tienen que estar todos juntos. Si es verdadero, con que haya un solo de los ingredientes del pedido basta.
 reverse = el booleano que siendo falso indica que los ingredientes a excluir son inclusivos. que quiere decir esto? que yo dije "sin pollo y consome" o algo asi, osea, indica que la lista de ingredientes para excluir no pueden estar todos juntos. Si es verdadero, con que falte un solo de los ingredientes del pedido basta.
 cal = el limite de calorias dado. en caso de que se haya dicho que no, vale -1.
 pre = el limite de precio dado. en caso de que se haya dicho que no, vale -1.
 */
void generador(string ax, bool bx, bool diverse,bool reverse,int cal,int pre){
	vector<string> j;
	vector<string> never;
	vector<string> nov;
	string g="";
	string h="";
	string hh="";
	string neg="";
	int uncont=0;
	int encont=0;
	int arcont=0;
	int orcont=0;
	int ircont=0;
	gens.clear();
	outa.clear();
	unity.clear();
	disjoint.clear();
	/*Aqui entra si es un pedido especifico, lo que hace es meter los ingredientes que se quieran usar en un vector j, y los ingredientes que se      
	 quieran excluir en un vector never. Los elementos a excluir estan marcados con una A al principio, se les quita y luego se ingresan a vector.
	 Como es posible que el usuario pida un ingrediente que nisiquiera se tiene en el restaurante, en caso de que este no exista en la lista de      
	 ingredientes posibles, se ingresa en un vector nov, para indicarle luego amablemente al usuario que no vendemos esa clase de comidas */
	if(bx){
		for(int jx=0; jx<ax.size(); ++jx){
			if(ax[jx]!=' '){
				g+= ax[jx];
			}
			else{
				if(ax[jx]==' ' && ax[jx-1]==' ' && jx){
					g="";
					continue;
				}
				else{
					if(ingredientes.find(g)!=ingredientes.end()){
						j.push_back(g);
						g="";
						continue;
					}
					else{
						if(g[0]=='A'){
							for(int zmz=1;zmz<g.length();++zmz){
								if(g[zmz]==','){break;}
								neg+=g[zmz];
							}
							if(ingredientes.find(neg)!=ingredientes.end()){
								never.push_back(neg);
								g="";
								neg="";
							}
							else{
								nov.push_back(neg);
								neg="";
								g="";
							}
						}
						else{
							nov.push_back(g);
							g="";
						}
					}
				}
			}
			if(jx+1==ax.size()){
				if(ingredientes.find(g)!=ingredientes.end()){
					j.push_back(g);
					g="";
					continue;
				}
				else{
					if(g[0]=='A'){
						for(int zmz=1;zmz<g.length();++zmz){
							if(g[zmz]==','){break;}
							neg+=g[zmz];
						}
						if(ingredientes.find(neg)!=ingredientes.end()){
							never.push_back(neg);
							g="";
							neg="";
						}
						else{
							nov.push_back(neg);
							neg="";
							g="";
						}
					}
					else{
						nov.push_back(g);
						g="";
					}
				}
			}
		}
	}
	/*Aqui entra si reverse o diverse es falso, es decir, que al menos uno de los dos requiera una condición de inclusividad de todos los i  
	 ingredientes pedidos ya sea para que esten todos presentes en la orden, o que no este ninguno presente*/
	if(!diverse || reverse){
		int af=0;
		int bf=0;
		int cf=0;
		int ar=0;
		int br=0;
		int cr=0;
		/*En caso de que sea requerido que todos los elementos a incluir esten juntos, va a contar cuantos de estos pertenecen a cada categoria,
		 ya sea entrada, plato fuerte(pescados o carnes) o postres*/
		for(int mz=0;!diverse && mz<j.size();++mz){
			if(carnes.find(j[mz])!=carnes.end() || pescados.find(j[mz])!=pescados.end()){
				bf++;
			}
			if(entradas.find(j[mz])!=entradas.end()){
				af++;
			}
			if(postres.find(j[mz])!=postres.end()){
				cf++;
			}
		}
		/*En caso de que sea requerido que todos los elementos a excluir esten juntos, va a contar cuantos de estos pertenecen a cada categoria,
		 ya sea entrada, plato fuerte(pescados o carnes) o postres*/
		for(int mz=0;reverse && mz<never.size();++mz){
			if(carnes.find(never[mz])!=carnes.end() || pescados.find(never[mz])!=pescados.end()){
				br++;
			}
			if(entradas.find(never[mz])!=entradas.end()){
				ar++;
			}
			if(postres.find(never[mz])!=postres.end()){
				cr++;
			}
		}
		
		/*Cuando todos los elementos a incluir tienen que estar juntos, y hay mas de uno de una categoria, es imposible hacer el pedido debido a 
		 que una comida esta conformada por una entrada, un plato fuerte, y un postre, entonces le pide al usuario que de las multiples entradas, 
		 platos fuertes, o postres que ingreso, seleccione solamente uno. todos los demás elementos de la categoria con exceso se cambian por
		 '-'*/
		if(!diverse && bf>1){
			cout << "No se puede incluir mas de un plato fuerte (carnes o pescados) en una orden, escoja solo uno de los siguientes: " << endl;
			for(int mz=0;mz<j.size();++mz){
				if(carnes.find(j[mz])!=carnes.end() || pescados.find(j[mz])!=pescados.end()){
					cout << j[mz] << ", precio: " << precios[j[mz]] << ", Calorias: " << calorias[j[mz]] << endl;
				}
			}
			cout << '\n';
		    cin >> g;
			for(int mz=0;mz<j.size();++mz){
				if(carnes.find(j[mz])!=carnes.end() || pescados.find(j[mz])!=pescados.end()){
					if(j[mz]!=g){
						j[mz]="-";
						uncont++;
					}
				}
			}
		}
		if(!diverse && af>1){
			cout << "No se puede incluir mas de una entrada en una orden, escoja solo uno de los siguientes: " << endl;
			for(int mz=0;mz<j.size();++mz){
				if(entradas.find(j[mz])!=entradas.end()){
					cout << j[mz] << ", precio: " << precios[j[mz]] << ", Calorias: " << calorias[j[mz]] << endl;;
				}
			}			
			cout << '\n';
			cin >> g;
			for(int mz=0;mz<j.size();++mz){
				if(entradas.find(j[mz])!=entradas.end()){
					if(j[mz]!=g){
						j[mz]="-";
						uncont++;
					}
				}
			}
		}
		if(!diverse && cf>1){
			cout << "No se puede incluir mas de un postre en una orden, escoja solo uno de los siguientes: " << endl;
			for(int mz=0;mz<j.size();++mz){
				if(postres.find(j[mz])!=postres.end()){
					cout << j[mz] << ", precio: " << precios[j[mz]] << ", Calorias: " << calorias[j[mz]] << endl;
				}
			}
			cout << '\n';
		    cin >> g;
			for(int mz=0;mz<j.size();++mz){
				if(postres.find(j[mz])!=postres.end()){
					if(j[mz]!=g){
						j[mz]="-";
						uncont++;
					}
				}
			}
		}
		
		/*De igual manera, como una comida debe contener una entrada, un plato fuerte y un postre, si un usuario decide excluir todas las  
		 posibilidades de una categoria, es imposible realizar el pedido, por lo que se le pide que por favor de los elementos que pidio excluir,  
		 escoja uno que desea mantener en el pedido, para asi cumplir la condicion de 1 elemento por categoria. Todos los demás elementos de la 
		 categoria con exceso se cambian por '-'*/
		
		if(reverse && ar==3){
			cout << "No se puede dejar sola la categoria de entrada, escoja uno para descartar de sus restricciones: " << endl;
			for(int mz=0;mz<never.size();++mz){
				if(entradas.find(never[mz])!=entradas.end()){
					cout << never[mz] << ", precio: " << precios[never[mz]] << ", Calorias: " << calorias[never[mz]] << endl;;

				}
			}
			cout << '\n';
		    cin >> g;
			for(int mz=0;mz<never.size();++mz){
				if(entradas.find(never[mz])!=entradas.end()){
					if(never[mz]!=g){
						never[mz]="-";
						arcont++;
					}
				}
			}
		}
		if(reverse && br==4){
			cout << "No se puede dejar sola la categoria de plato fuerte (carnes o pescados), escoja uno para descartar de sus restricciones: "<< endl;
			for(int mz=0;mz<never.size();++mz){
				if(carnes.find(never[mz])!=carnes.end() || pescados.find(never[mz])!=pescados.end()){
					cout << never[mz] << ", precio: " << precios[never[mz]] << ", Calorias: " << calorias[never[mz]] << endl;;

				}
			}
			cout << '\n';
		    cin >> g;
			for(int mz=0;mz<never.size();++mz){
				if(carnes.find(never[mz])!=carnes.end() || pescados.find(never[mz])!=pescados.end()){
					if(never[mz]!=g){
						never[mz]="-";
						arcont++;
					}
				}
			}
		}
		if(reverse && cr==3){
			cout << "No se puede dejar sola la categoria de postre, escoja uno para descartar de sus restricciones: " << endl;
			for(int mz=0;mz<never.size();++mz){
				if(postres.find(never[mz])!=postres.end()){
					cout << never[mz] << ", precio: " << precios[never[mz]]<< ", Calorias: " << calorias[never[mz]] << endl;;

				}
			}
			cout << '\n';
		    cin >> g;
			for(int mz=0;mz<never.size();++mz){
				if(postres.find(never[mz])!=postres.end()){
					if(never[mz]!=g){
						never[mz]="-";
						arcont++;
					}
				}
			}
		}
		/*Si en el pedido es requerido que todos los elementos a incluir esten juntos o que no este ninguno, entones se meten a un set. Esto ya es 
		 despues de haber cambiado por "-" los excesos. Con este set se verifica al momento de imprimir que si todos tienen que estar juntos o  
		 ninguno de los dados, y hay alguno que no, entonces se salta este resultado*/
		for(int mz=0;!diverse && mz<j.size();++mz){
			if(j[mz]!="-"){
				unity.insert(j[mz]);
			}
		}
		for(int mz=0;reverse && mz<never.size();++mz){
			if(never[mz]!="-"){
				disjoint.insert(never[mz]);
			}
		}
	}
	
	/*Con los elementos de never, se va a pegar a un string, que es lo que se ve al imprimir cuando se ven los elementos que se estan 
	 excluyendo*/
	neg="";
	for(int sm=0; sm<never.size(); sm++){
		g = never[sm];
		if(g=="-"){
			continue;
		}
		disjoint.insert(g);
		if(sm==0){
			neg=g;
		}
		else{
			if(sm+1!=never.size()){
				neg+= ", " + g;
			}
			else{
				if(reverse){
					neg+= " o " + g;
				}
				else {
					neg+= " y " + g;
				}
			}
		}
	}
	/*en caso de que j.size() sea vacio, esto quiere decir 2 cosas: o que se esta haciendo un pedido de todos los elementos posibles, o que se esta  
	 haciendo un pedido de exclusion sin ninguno de inclusion. Entonces se le agrega algo vacio a j, para que entre al menos 1 vez al siguiente 
	 ciclo, una sola ves necesaria para que genere todas las combinaciones posibles. Si es un pedido de exclusion, se generan todas las 
	 combinaciones posibles, y se obvian al imprimir las que tengan alguna o todas las pedidas a excluir de acuerdo al booleano reverse*/
	if(j.size()==0){
		bx=false;
		j.push_back("");
	}
	for(int zm=0; zm<j.size(); zm++){
	/*Con los elementos de never, se va a pegar a un string, que es lo que se ve al imprimir cuando se ven los elementos que se estan 
	 excluyendo*/
		g = j[zm];
	if(g=="-"){
		continue;
	}
	if(zm==0){
		h=g;
	}
	else{
		if(zm+1!=j.size()){
			h+= ", " + g;
		}
		else{
			if(diverse){
				h+= " o " + g;
			}
			else {
				h+= " y " + g;
			}
		}
	}
	/*si bx es falso (ya sea porque se pidieron todos los pedidos posibles, o solo se pidio excluir cosas sin algo especifico a incluir), se  
	 generan todos los casos posibles. En caso de que hayan cosas a incluir (y por lo tanto j tenga elementos), para ahorrar algo de tiempo,  
	 solo se generan elementos que contengan la j[iterador], que en este caso esta asignada a g. Los resultados repetidos se saltan gracias al  
	 mapa*/
	for(int am=0; am<entrada.size(); am++){
		for(int bm=0; bm<carne.size(); bm++){
			for(int cm=0; cm<postre.size(); cm++){
				xac.insert(entrada[am]);
				xac.insert(carne[bm]);
				xac.insert(postre[cm]);
				if(bx && xac.find(g)==xac.end()){
					xac.clear();
					continue;
				}
				else {
					if(!gens[entrada[am]+carne[bm]+postre[cm]]){
						output.push_back(entrada[am]);
						output.push_back(carne[bm]);
						output.push_back(postre[cm]);
						outa.push_back(output);
						output.clear();
						gens[entrada[am]+carne[bm]+postre[cm]]=1;
					}
				}
				xac.clear();
			}
		}
		for(int bm=0; bm<pescado.size(); bm++){
			for(int cm=0; cm<postre.size(); cm++){
				xac.insert(entrada[am]);
				xac.insert(pescado[bm]);
				xac.insert(postre[cm]);
				if(bx && xac.find(g)==xac.end()){
					xac.clear();
					continue;
				}
				else {
					if(!gens[entrada[am]+pescado[bm]+postre[cm]]){
						output.push_back(entrada[am]);
						output.push_back(pescado[bm]);
						output.push_back(postre[cm]);
						outa.push_back(output);
						output.clear();
						gens[entrada[am]+pescado[bm]+postre[cm]]=1;
					}
				}
				xac.clear();
			}
		}
	}
}
/*Esto imprime la linea que indica todo lo que se esta incluyendo (ya sea con Y o O) y todo lo que se esta excluyendo (ya sea con Y o O)*/
if(h!=""){
	cout << "\nComidas con " << h;
	if(neg!=""){
		cout << ", ademas sin " << neg;
	}
	cout << ": \n";
	}	
	else {
		if(neg!=""){
			cout << "\nComidas sin " << neg << ": \n";
		}
		else{
			cout << "\nTodas las combinaciones posibles del restaurante son:\n";
		}
	}
	
	/*Esto imprime los platos generados. Se obtienen los precios de un mapa, y se hacen las verificaciones de que si diverse es falso, y se  
	 encontraron todos los elementos, es que estan todos los solicitados juntos y se imprima eso. Si diverse es verdadero, es que los pedidos  
	 pueden estar por separado, y esto ya se cubrio en la generacion previa de posibles resultados, entonces simplemente imprime. En el caso de 
	 reverse, si es verdad es que entonces los elementos pedidos a excluir no tienen que estar juntos, osea que con que solo haya uno se  
	 excluye este resultado. Si reverse es falso, es que todos los elementos pedidos a excluir tienen que estar juntos, osea que solo se excluye el 
	 resultado en caso de que todos los elementos a quitar esten en el pedido, tambien se obvian los resultados que excedan el limite calorico
	 o el limite de precio en caso de haber sido dados (osea ser diferentes a -1)*/
	for(int gm=0;gm<outa.size();gm++){
		precio=0;
		calor=0;
		sale = "\t\t";
		encont = uncont;
		ircont = 0;
		for(int mg=0;mg<outa[gm].size();mg++){
			orcont=0;
			precio += precios[outa[gm][mg]];
			calor += calorias[outa[gm][mg]];
			sale += outa[gm][mg];
			if(!diverse && unity.find(outa[gm][mg])!=unity.end()){
				encont++;
			}
			if(disjoint.find(outa[gm][mg])!=disjoint.end()){
				ircont++;
			}
			if(mg+1<outa[gm].size()){
				sale+= ", ";
			}
			else{
				for(int jk=0;;++jk){
					if(sale.length()<30){
						sale+=" ";
					}
					else{
						break;
					}
				}
				if(!diverse){ 
					if(encont==j.size()){
						if(reverse && ircont || !reverse && ircont+arcont == never.size()){
						}
						else{
							if(calor<=cal || cal==-1){
								if(precio<=pre || pre==-1){
									cout << sale << "\t el precio es:" << precio << "/ las calorias son:" << calor << '\n';
								}
							}	
						}
					}
				}
				else{
					if(reverse && ircont || !reverse && ircont+arcont==never.size()){
					}
					else{
						if(calor<=cal || cal==-1){
							if(precio<=pre || pre==-1){
								cout << sale << "\t el precio es:" << precio << "/ las calorias son:" << calor << '\n';
							}
						}
					}			
				}
			}
		}
	}
	/*Esto sencillamente dice: de esta cosa que ud nos pidio, no vendemos de eso. Aunque el usuario pida algo que no se vende, no afecta el 
	 proceso de generacion de las diversas comidas del restaurante*/
	if(nov.size()){
		g="";
		for(int ag=0; ag<nov.size(); ag++){
			g += " " + nov[ag];
			if(ag+1!=nov.size()){
				g += " ni";
			}
			else{
				g+= ".";
			}
		}
		cout << "\nNo vendemos" << g << endl;
	}
	}
	
	
	/*Esto es para cuando el usuario pregunta por que carnes, pescados, entradas o postres vende el restaurante*/
	void vendemos(string fx){
		int zz;
		cout << "\nEn " << fx << " tenemos:\n\n ";
		if(fx=="carnes"){
			for(zz=0; zz<carne.size(); ++zz){
				cout << "\t\t" << carne[zz] << ", Precio: "<< "\t" << precios[carne[zz]] << ", Calorias: " << calorias[carne[zz]] << endl;
			}
		}
		else if(fx=="pescados"){
			for(zz=0; zz<pescado.size(); ++zz){
				cout << "\t\t" << pescado[zz] << ", Precio: "<< "\t" << precios[pescado[zz]] << ", Calorias: " << calorias[pescado[zz]] << endl;
			}
		}
		else if(fx=="postres"){
			for(zz=0; zz<postre.size(); ++zz){
				cout << "\t\t" << postre[zz] << ", Precio: "<< "\t" << precios[postre[zz]]<< ", Calorias: " << calorias[postre[zz]] << endl;

			}
		}
		else if(fx=="entradas"){
			for(zz=0; zz<entrada.size(); ++zz){
				cout << "\t\t" << entrada[zz] << ", Precio: "<< ((entrada[zz]!="gazpacho")?"\t":"") << precios[entrada[zz]] << ", Calorias: " << calorias[entrada[zz]] << endl;

			}
		}
	}
	
	
	/*Esto separa las cosas que el restaurante vende a las que no, para luego aclararle amablemente al usuario que no se vende alguna de las cosas que solicito sin afectar el proceso de la solicitud de las cosas que si se venden*/
	void parteComida(string x){
		vector <string> nov;
		string f="";
		for(int z=0; z<x.size(); ++z){
			if(x[z]!=' '){
				f+= x[z];
			}
			else {
				if(comidas.find(f)!=comidas.end()){
					vendemos(f);
					f="";
					continue;
				}
				else{
					if(f!=""){
						nov.push_back(f);
						f="";
					}
				}
			}
			if(z+1==x.size()){
				if(comidas.find(f)!=comidas.end()){
					vendemos(f);
					f="";
					continue;
				}
				else{
					if(f!=""){
						nov.push_back(f);
						f="";
					}
				}
			}
		}
		if(nov.size()){
			f="";
			for(int ag=0; ag<nov.size(); ag++){
				f += " " + nov[ag];
				if(ag+1!=nov.size()){
					f += " ni";
				}
				else{
					f+= ".";
				}
			}
			cout << "\nNo vendemos" << f << endl;
		}
	}
