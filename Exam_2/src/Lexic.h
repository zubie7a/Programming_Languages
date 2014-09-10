#pragma once
#include "Basics.h"

void invocarAnalizadorLexico(vector <string> z){
	
	cout << "\n\nAnalizador Lexico:\n\n";
	for(int i=0;i<z.size();++i){
		cout << z[i] << "\t\t";
		if(inicial(z[i])){
		    cout << "es instruccion inicial";
		}
		else{ 
			 if(numero(z[i])){
				 cout << "\tes numero";
			 }
			 else{ 
				  if(variable(z[i])){
					  cout << "\tes variable";
				  }
				  else{ 
					   if(asignacion(z[i])){
						   cout << "es operador de asignacion";
					   }
					   else{ 
						    if(operacion(z[i])){
							    if(!z[i].compare("mas")){
									cout << "\tes operador de suma";	
								}
									else{ 
										 if(!z[i].compare("menos")){
										 cout << "es operador de resta";
										 }
										 else{ 
											  if(!z[i].compare("por")){
											  cout << "\tes operador de multiplicacion";
											  }
											  else{ 
												   if(!z[i].compare("sobre")){
												   cout << "es operador de division";
												   }
											  }
										 }
									}
								}
							else{
								cout << "es invalida";
							}
						}
				  }
			 }
		}
		cout << '\n';
	}
}


