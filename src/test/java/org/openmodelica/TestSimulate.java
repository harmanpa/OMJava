/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmodelica;

import org.junit.Test;
import org.openmodelica.corba.ConnectException;
import org.openmodelica.corba.Result;
import org.openmodelica.corba.SmartProxy;
import org.openmodelica.corba.parser.ParseException;

/**
 *
 * @author peter
 */
public class TestSimulate {

    @Test
    public void test() throws ConnectException, ParseException {
        SmartProxy proxy = new SmartProxy("test", "Modelica", true, true);
        proxy.sendExpression("cd(\"" + System.getProperty("user.dir").replace("\\", "/") + "\")");
        proxy.sendExpression("loadModel(Modelica);");
        proxy.sendExpression("setCommandLineOptions(\"+d=visxml\");");
        Result result =  proxy.sendExpression("simulate(Modelica.Mechanics.MultiBody.Examples.Systems.RobotR3.fullRobot);");
        
    }
}
