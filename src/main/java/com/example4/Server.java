package com.example4;
import java.io.*;
import java.net.*;



public class Server {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringModifica = null;
    BufferedReader inDalClient;
    ObjectOutputStream outVersoClient;
    File fileDaInviare;
    FileInputStream reader; //istanza per leggere un file binario

    public Socket attendi(){
        try{
            //server parte in esecuzioine
            System.out.println(" SERVER partito in esecuzione");
            server = new ServerSocket(6789);

            //server accetta la connessione con il client
            client = server.accept();
            
            
            outVersoClient = new ObjectOutputStream(client.getOutputStream());
            reader = new FileInputStream("images.jpg");
    server.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }

    public void comunica(){
        byte[] buffer = new byte[1024];
        int lenghRead;
       
        try{
            System.out.println("INVIO FILE.JPG AL CLIENT");
             while((lenghRead = reader.read(buffer)) > 0){
            outVersoClient.write(buffer , 0 , lenghRead);
            
            
        }
            System.out.println("ho finito di inviare");
        }catch(Exception e){System.out.println("nonfa procodue");};
    }

}
