package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;
import java.util.Scanner;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");

            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 10000; 

            byte[] buf = new byte[20];
            
            byte[] received_data;
            int origin_port;
            
            
            byte[] msg_buf;
            int msg_size;
            
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite sua mensagem");
            while (true) {
              //  if(sc.nextLine()){
                    //...........enviar..............//
                    
                    String msg = sc.nextLine();
                    msg_buf = msg.getBytes();
                    msg_size = msg_buf.length;
                    
                    //System.out.print("[ Montando datagrama UDP  ..................  ");
                    DatagramPacket pack1 = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
                    //System.out.println("[OK] ]");
                    
                    //System.out.print("[ Enviando datagrama UDP  ..................  ");
                    socket.send(pack1);
                    //System.out.println("[OK] ]");
                
               // }else{
                    //...........receber.............//
                    DatagramPacket pack = new DatagramPacket(buf, buf.length);
                    //System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
                    socket.receive(pack);
                   // System.out.println("[OK] ]");
                    
                    received_data = pack.getData();
                    String received_msg = new String(received_data); 
                    //InetAddress origin_address = pack.getAddress();
                    //origin_port = pack.getPort();
                    
                    System.out.println("  Mensagem:             "+received_msg);
                   // System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
                   // System.out.println("  Porta de origem:      "+origin_port);
                  
               // }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}