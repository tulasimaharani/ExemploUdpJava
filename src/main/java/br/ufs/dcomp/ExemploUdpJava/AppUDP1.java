package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            
            Scanner sc = new Scanner(System.in);
            String msg = '1';
            byte[] msg_buf;
            int msg_size;
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 20000;
            byte[] buf = new byte[20];
            DatagramPacket pack1 = new DatagramPacket(buf, buf.length);
            byte[] received_data;
            String received_msg;
            int origin_port;
            while (msg = sc.nextLine()) {
                
               
                
                byte[] msg_buf = msg.getBytes();
                int msg_size = msg_buf.length;
                 
    
                System.out.print("[ Montando datagrama UDP  ..................  ");
                DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
                System.out.println("[OK] ]");
                
                System.out.print("[ Enviando datagrama UDP  ..................  ");
                socket.send(pack);
                System.out.println("[OK] ]");
                
                
                System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
                socket.receive(pack1);
                System.out.println("[OK] ]");
                
                received_data = pack1.getData();
                received_msg = new String(received_data); 
                InetAddress origin_address = pack1.getAddress();
                origin_port = pack1.getPort();
                
                System.out.println("  Mensagem:             "+received_msg);
                System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
                System.out.println("  Porta de origem:      "+origin_port);

                
            }
    
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}