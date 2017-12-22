/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.viptech.rserveconnection;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 *
 * @author sklcarvalho
 */
public class NovoClass {

    public static void main(String[] args) throws RserveException {
        RConnection c = new RConnection("localhost", 6311);
        if (c.isConnected()) {
            System.out.println("Connected to RServe.");
            org.rosuda.REngine.REXP x0 = c.eval("R.version.string");
            System.out.println(x0.toString());
            if (c.needLogin()) {
                System.out.println("Providing Login");
                c.login("username", "password");
            }
        } else {
            System.out.println("Rserve could not connect");
        }
        c.close();
        System.out.println("Session Closed");
    }

}
