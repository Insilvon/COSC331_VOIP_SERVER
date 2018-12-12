/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc331_voip_server;

/**
 *
 * @author colin
 */
public class ServerVoice {
    public static boolean calling = false;
    public static void main(String[] args){
        ServerFrame frame = new ServerFrame();
        frame.setVisible(true);
    }
}
