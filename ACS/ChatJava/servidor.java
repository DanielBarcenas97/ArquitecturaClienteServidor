import java.net.*;
import java.io.*;
import java.io.Console;

public class servidor{
	public static void main(String a[]){
		/**Inicializacion del socket ,peticion y respuesta**/
		ServerSocket serverSocket = null;
		Socket socket = null;
		String peticion = null;
		String respuesta = "Datos incorrectos";
		Console con = System.console();
		
		try{
			System.out.println("Escuchando por el puerto 8000");
			serverSocket = new ServerSocket(8000);
		}catch(IOException e){
			System.out.println("java.io.IOException generada");
			e.printStackTrace();
		}
		System.out.println("Esperando a que los clientes se conecten...");
		while(true){
			try{
				 socket = serverSocket.accept();
				 //System.out.println("Se conecto un cliente: " + socket.getInetAddress().getHostName());
				 /**dis es el objeto que va a recibir mensaje del cliente*/
				 DataInputStream dis = new DataInputStream( socket.getInputStream());
				 peticion = dis.readUTF();
				 System.out.println("Cliente: " + peticion);
				 /**dos es nuestra respuesta al cliente*/
				 DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				 if(peticion.equals("bye")) {
				 	System.out.println("Se desconecto el cliente " + peticion);
				 	dos.writeUTF("Finalizo sesion");
				 	dos.close();
					dis.close();
					socket = null;
					System.out.println("Esperando a que los clientes se conecten...");
				 }else if(peticion != null){
				 	System.out.print("Escribir a Cliente: ");
				 	String s = con.readLine();
				 	respuesta = s;
				 	//System.out.println("Servidor escribio " + respuesta);
					dos.writeUTF(respuesta);
					dos.close();
					dis.close();
					socket = null;
				 }
			}catch(IOException e){
				 System.out.println("java.io.IOException generada");
				 e.printStackTrace();
			}
		}

	}
}