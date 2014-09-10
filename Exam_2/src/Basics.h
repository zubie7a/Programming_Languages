#pragma once
#include<set>
#include<iostream>
#include<string>
#include<map>
#include<vector>
#include<sstream>

using namespace std;

set <string> digits;
set <string> asign;	
set <string> maths;
set <string> vars;
set <string> init;


void inicializadorSets(){
	
	digits.insert("1");
	digits.insert("2");
	digits.insert("3");
	digits.insert("4");
	digits.insert("5");
	digits.insert("6");
	digits.insert("7");
	digits.insert("8");
	digits.insert("9");
	digits.insert("0");
	vars.insert("V");
	vars.insert("W");
	vars.insert("X");
	vars.insert("Y");
	vars.insert("Z");
	maths.insert("mas");
	maths.insert("menos");
	maths.insert("por");
	maths.insert("sobre");
	asign.insert("dando");	
	init.insert("Haga");
}

bool inicial(string x){
	if(init.find(x)!=init.end()){
		return true;
	}
	return false;
}

bool variable(string x) {
	if(vars.find(x)!=vars.end()){
		return true;
	}
	return false;
}


bool digito(string x) {
	if(digits.find(x)!=digits.end()){
		return true;
	}
	return false;
}

bool numero(string x){
	if(x.size()==1){
		return digito(x);
	}
	return digito(x.substr(0,1)) && numero(x.substr(1,x.size()));
}


bool asignacion(string x) {
	if(asign.find(x)!=asign.end()){
		return true;
	}
	return false;
}


bool operacion(string x) {
	if(maths.find(x)!=maths.end()){
		return true;
	}
	return false;
}


bool expresion(vector <string> z){
	if(!z.size()){
		return false;
	}
	if (z.size()==1){
		return numero(z[0]);
	}
	if(!(z.size()%2)){
		return false;
	}
	if(!numero(z[0])||!operacion(z[1])){
		return false;
	}
	z.erase(z.begin(),z.begin()+2);
	return expresion(z);
}