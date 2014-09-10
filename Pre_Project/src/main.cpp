#include "Syntax.h"

int main () {
	string w,x,y;
	int cal;
	bool lack;
	string coma;
	vector<string> z;
	vector<bool> diverse;
	vector<bool> reverse;
	vector<int> calx;
	vector<int> prex;
	vector< vector<string> > inst;
	inicializadorSets();
	cout << "\nIngresar Solicitud:\n";
	diverse.push_back(true);
	reverse.push_back(true);
	lack=false;
	while(cin>>x) {
		z.push_back(x);
		while(true){
			/*La idea general al leer es que si un elemento tiene una coma o tenga y/o, concatenarlo con lo que siga en ves de hacer push.
			 Esto permite que al final todos los requests queden en una sola string del vector, a la ves marcados los que se quieran remover.*/
			while(true){
				cin >> x;
				if(x=="sin"){
					lack = true;
					z.push_back(x);
					cin >> x;
					x = 'A' + x; 
					/*Se marca con la letra A las que se quieran remover de los resultados*/
				}
				
				coma=z[z.size()-1];
				if(coma[coma.length()-1]==',' && x!="ademas"){
					if(lack){
						x= 'A' + x;
						z[z.size()-1] += " " + x;
					}
					else {
						z[z.size()-1] += " " + x;
					}
				}
				else if(x=="y" || x=="o" || x=="ademas"){
					cin >> y;
					if(x=="ademas"){
						if(y=="con"){
							lack = false;
						}
						else {
							if(y=="sin"){
								lack = true;
							}
						}
						cin >> y;
					}
					if(x=="y"){
						if(lack){
							reverse[reverse.size()-1]=false;
						}
						else{
							diverse[diverse.size()-1]=false;
						}
					}
					else {
						if(x=="o"){
							if(lack){
								reverse[reverse.size()-1]=true;
							}
							else{
								diverse[diverse.size()-1]=true;
							}						
						}
					}
					if(lack){
						y= 'A' + y;
						z[z.size()-1] += " " + y;
					}
					else {
						z[z.size()-1] += " " + y;
					}
					
				}
				else{
					z.push_back(x);
				}
				if(cin.peek()=='\n')break;
			}
			if(z[0]=="Generar"){
				cout << "\nDesea establecer algun limite calorico?\n";
				cin >> w;
				if(w=="Si"||w=="si"){
					cout << "\nQue numero?\n";
					cin >> cal;
					calx.push_back(cal);
				}
				else{
					calx.push_back(-1);
				}
			}
			else {
				calx.push_back(-1);
			}
			if(z[0]=="Generar"){
				cout << "\nDesea establecer algun limite de precio?\n";
				cin >> w;
				if(w=="Si"||w=="si"){
					cout << "\nQue numero?\n";
					cin >> cal;
					prex.push_back(cal);
				}
				else{
					prex.push_back(-1);
				}
			}
			else {
				prex.push_back(-1);
			}
			cout << "\nAlgo mas?\n";
			cin >> x;
			inst.push_back(z);
			z.clear();
			if(x=="no"||x=="No"){
				break;
			}
			else {
				z.push_back(x);
			}
			diverse.push_back(true);
			reverse.push_back(true);
			lack=false;
		}
		/*se usa un vector de vector de strings, para que se puedan hacer todos los queries que se quieran hacer antes de pasar a imprimir los  
		 resultados, en cada iteracion pasando un vector de strings como parametro, y sus correspondentes booleanos al analizador*/ 
		for(int m=0;m<inst.size();++m){
			invocarAnalizadorSintactico(inst[m],diverse[m],reverse[m],calx[m],prex[m]);
		}
		cout << "\nDesea terminar?\n";
		cin>>x;
		if(x=="Si"||x=="si"){
			break;
		}
		inst.clear();
		diverse.clear();
		reverse.clear();
		diverse.push_back(true);
		reverse.push_back(true);
		lack = false;
		calx.clear();
		prex.clear();
		cout << "\nIngresar Solicitud:\n";
	}
}
