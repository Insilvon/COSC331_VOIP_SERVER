/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc331_voip_server;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author crcrowe0, emjetton0
 * Main method of the program
 */
public class ServerVoice {
    /**
     * variable which checks if the server is actively listening for voice data
     */
    public static boolean online = false;

    /**
     * Main method. Begins by printing THIS computer's IP address so the client knows what to connect to. The default port is 4001.
     * It will then generate the beginning frame to be used.
     * @param args
     */
    public static void main(String[] args){
        try{
            System.out.println(InetAddress.getLocalHost().getHostAddress().trim());
        }
        catch(UnknownHostException e){
            e.printStackTrace();
        }
        ServerFrame frame = new ServerFrame();
        frame.setVisible(true);
    }
}
