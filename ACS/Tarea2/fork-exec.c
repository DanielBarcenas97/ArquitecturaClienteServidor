#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
int spawn (char* program, char** arg_list){

	pid_t child_pid; //cre a una variable de tipo id proceso
	child_pid = fork ();  //Se crea un nuevo proceso

	if (child_pid != 0){ //Si el proceso hijo es diferente de 
		printf("jaja");
		return child_pid;  //Regresa el proceso hijo
	}else {
	/*execvp toma el nombre de un archivo, si el nombre no contiene 
	una “/”, buscara dentro de $PATH un comando que coincida 
	con el nombre para ser ejecutado*/
		execvp (program, arg_list);
		fprintf (stderr, "an error occurred in execvp\n");  //Salida de un error
		abort ();
	}
}


int main (){
	//Areglo de comandos que se van a ejecutar
	char* arg_list[] = { "ls", "-l", "/",NULL };
	printf("done with main program\n");
	printf("Barcenas Martinez Edgar Daniel\n");
	/*Se manda a llamar la funcion spaw y se le pasa 
	un comando y un arreglo de comandos.*/
	spawn ("ls", arg_list);
	return 0;
}