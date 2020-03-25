#include <stdio.h>
#include <unistd.h> //Declara funciones que son parte del estándar POSIX
int main ()
{
 printf ("The process ID is %d\n", getpid ());
 printf ("The parent process ID is %d\n", (int) getppid ());
 return 0;
}
