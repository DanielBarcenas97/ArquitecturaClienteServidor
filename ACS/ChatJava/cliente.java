import java.net.*;
import java.io.*;
import java.io.Console;

public class cliente {

	public static void main(String a[]){
		Socket socket = null;
		Console con = System.console();
		String s = "";
		String peticion = "";
		String respuesta = null;
		
			try{
				System.out.println("Me conecto al puerto 8000 del servidor");
				while(!peticion.equals("bye")){
					socket = new Socket(a[0],8000);
					System.out.print("Escribir a Servidor: ");
					s = con.readLine();
					peticion = s;
					System.out.println("Cliente Escribio: " + peticion);
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					dos.writeUTF(peticion);
					DataInputStream dis = new DataInputStream( socket.getInputStream());
					respuesta = dis.readUTF();
					//System.out.println("Servidor Escribio : " +respuesta);
					dos.close();
					dis.close();
					socket.close();
				}
			}catch(IOException e){
				System.out.println("java.io.IOException generada");
				e.printStackTrace();
			}
			System.out.println("Hasta Pronto:");
	} 
}
