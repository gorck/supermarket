/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.supermarket.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author jose
 */
public class ConexaoAction {

    private final String serverIP = "127.1.1.1";
    private final Integer port = 10020;

    public void conect() throws IOException {

        Socket client = new Socket(serverIP, port);

        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        
        try {

            out.writeBytes("Conectado");
            while (true) {
                System.out.println("Esperando conecxão");
                String s = in.readUTF();
                out.writeBytes("Obrigado!");
                System.out.println(s);
            }

        } catch (Exception ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
        in.close();
        out.close();
        client.close();
    }
}
