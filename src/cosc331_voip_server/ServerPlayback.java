/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc331_voip_server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author colin
 */
public class ServerPlayback extends Thread{
    public DatagramSocket in;
    public SourceDataLine audioOutput;
    byte[] buffer = new byte[512];
    @Override
    public void run(){
        DatagramPacket input = new DatagramPacket(buffer, buffer.length);
        while(ServerVoice.calling){
            int i = 0;
            try {
                in.receive(input);
                buffer = input.getData();
                audioOutput.write(buffer, 0,buffer.length);
                System.out.println("#"+i++);
            } catch (IOException ex) {
                Logger.getLogger(ServerPlayback.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        audioOutput.close();
        audioOutput.drain();
        System.out.println("End of thread.");
    }
}
