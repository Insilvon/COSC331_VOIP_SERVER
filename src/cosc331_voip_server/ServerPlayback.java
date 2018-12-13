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
 * @author crcrowe0, emjetton0
 */
public class ServerPlayback extends Thread{
    /**
     * Datasocket which takes in new audio data
     */
    public DatagramSocket in;
    /**
     * DataLine for reading audio output
     */
    public SourceDataLine audioOutput;
    /**
     * Default buffer for datagram packets
     */
    byte[] buffer = new byte[512];

    /**
     * Implemented from the Thread class - core method which will receive data and write it to an audioOutput Dataline.
     */
    @Override
    public void run(){
        DatagramPacket input = new DatagramPacket(buffer, buffer.length);
        int i = 0;
        while(ServerVoice.online){

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
