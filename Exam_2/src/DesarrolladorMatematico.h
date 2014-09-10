#pragma once
#include "Basics.h"

int valorFinal(vector <string> z){
	
	int valor = 0;
	string outstr=z[0];
	istringstream (outstr) >> valor;
	int net = valor;
	z.erase(z.begin(),z.begin()+1);
	for(int i=0;i<z.size()-1;i+=2){
		outstr = z[i+1];
		istringstream(outstr) >> valor;
		outstr = z[i];
		if(outstr=="mas"){
			net += valor;
		}
		else{ 
			 if(outstr=="menos"){
				 net -= valor;
			 }
			 else{ 
				  if(outstr=="por"){
						net *= valor;
				  }
				  else{ 
					   if(outstr=="sobre"){
							 net /= valor;
					   }
				  }
			 }
		}
	}
	return net;
}