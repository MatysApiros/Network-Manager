package MainPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.snmp4j.smi.OID;

import Manager.Chart;
import Manager.SNMPManager;
import Model.OIDClass;
import View.FirstScreen;

public class Main {
	
	public  static void main (String [] args) throws IOException, InterruptedException {
		
		SNMPManager client = new SNMPManager("udp:127.0.0.1/161");

    	try {
			client.start();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    	OIDClass oidIfInOctets  = new OIDClass();
    	OIDClass oidIfOutOctets = new OIDClass();
    	
    	OIDClass oidClass       = new OIDClass();
    	OIDClass oidClass2      = new OIDClass();
    	OIDClass oidClass3      = new OIDClass();
    	OIDClass oidClass4      = new OIDClass();
    	OIDClass oidClass5      = new OIDClass();
    	
    	OIDClass oidIpIn        = new OIDClass();
    	OIDClass oidIpOut       = new OIDClass();
    	OIDClass oidTcpIn       = new OIDClass();
    	OIDClass oidTcpOut      = new OIDClass();
    	OIDClass oidUdpIn       = new OIDClass();
    	OIDClass oidUdpOut      = new OIDClass();

    	System.out.println("============== Gerente de Redes ==============");
    	System.out.println("==================== Menu ====================");

    	
    	//OIDs para o Calculo do Link
    	String oidIfInOctetsValue  = ".1.3.6.1.2.1.2.2.1.10.20";
    	String oidIfOutOctetsValue = ".1.3.6.1.2.1.2.2.1.16.19";
    	
    	//OIDs Genéricos
    	String oid  = ".1.3.6.1.2.1.11.19.0"; //SNMP In Traps
    	String oid2 = ".1.3.6.1.2.1.11.20.0"; //SNMP Out Too Big
    	String oid3 = ".1.3.6.1.2.1.4.9.0"  ; //IP In Delivers
    	String oid4 = ".1.3.6.1.2.1.5.1.0"  ; //ICMP In Messages
    	String oid5 = ".1.3.6.1.2.1.5.3.0"  ; //ICMP Destiny Unreachs
    	
    	//OIDs Obrigatórios
    	String oidIpInValue   = ".1.3.6.1.2.1.4.3.0" ; //IPs In
    	String oidIpOutValue  = ".1.3.6.1.2.1.4.10.0"; //IPs Out
    	String oidTcpInValue  = ".1.3.6.1.2.1.6.10.0"; //TCPs In
    	String oidTcpOutValue = ".1.3.6.1.2.1.6.11.0"; //TCPs Out
    	String oidUdpInValue  = ".1.3.6.1.2.1.7.1.0" ; //UDPs In
    	String oidUdpOutValue = ".1.3.6.1.2.1.7.4.0" ; //UDPs Out

    	FirstScreen frame = new FirstScreen();
    	
    	FirstScreen frame2 = new FirstScreen();
		
    	FirstScreen frame3 = new FirstScreen();
					
    	FirstScreen frame4 = new FirstScreen();			
		
    	FirstScreen frame5 = new FirstScreen();
		
    	FirstScreen frame6 = new FirstScreen();
    	
    	while (true) {
    		
    		String sysDescrIfIn;
    		try {
    			sysDescrIfIn = client.getAsString(new OID(oid));
    			oidIfInOctets.setIfInOctetsOld(oidIfInOctets.getIfInOctets());
    			oidIfInOctets.setIfInOctets(Double.parseDouble(sysDescrIfIn));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		String sysDescrIfOut;
    		try {
    			sysDescrIfOut = client.getAsString(new OID(oid));
    			oidIfOutOctets.setIfOutOctetsOld(oidIfOutOctets.getIfOutOctets());
    			oidIfOutOctets.setIfOutOctets(Double.parseDouble(sysDescrIfOut));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		String sysDescr;
    		try {
    			sysDescr = client.getAsString(new OID(oid));
    			oidClass.addValues(Double.parseDouble(sysDescr));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
        	
        	String sysDescr2;
    		try {
    			sysDescr2 = client.getAsString(new OID(oid2));
    			oidClass2.addValues(Double.parseDouble(sysDescr2));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
        	
        	String sysDescr3;
    		try {
    			sysDescr3 = client.getAsString(new OID(oid3));
    			oidClass3.addValues(Double.parseDouble(sysDescr3));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
        	
        	String sysDescr4;
    		try {
    			sysDescr4 = client.getAsString(new OID(oid4));
    			oidClass4.addValues(Double.parseDouble(sysDescr4));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
        	
        	String sysDescr5;
    		try {
    			sysDescr5 = client.getAsString(new OID(oid5));
    			oidClass5.addValues(Double.parseDouble(sysDescr5));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		String sysDescrIpIn;
    		try {
    			sysDescrIpIn = client.getAsString(new OID(oidIpInValue));
    			oidIpIn.addValues(Double.parseDouble(sysDescrIpIn));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		String sysDescrIpOut;
    		try {
    			sysDescrIpOut = client.getAsString(new OID(oidIpOutValue));
    			oidIpOut.addValues(Double.parseDouble(sysDescrIpOut));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		String sysDescrTcpIn;
    		try {
    			sysDescrTcpIn = client.getAsString(new OID(oidTcpInValue));
    			oidTcpIn.addValues(Double.parseDouble(sysDescrTcpIn));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		String sysDescrTcpOut;
    		try {
    			sysDescrTcpOut = client.getAsString(new OID(oidTcpOutValue));
    			oidTcpOut.addValues(Double.parseDouble(sysDescrTcpOut));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		String sysDescrUdpIn;
    		try {
    			sysDescrUdpIn = client.getAsString(new OID(oidUdpInValue));
    			oidUdpIn.addValues(Double.parseDouble(sysDescrUdpIn));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}
    		
    		String sysDescrUdpOut;
    		try {
    			sysDescrUdpOut = client.getAsString(new OID(oidUdpOutValue));
    			oidUdpOut.addValues(Double.parseDouble(sysDescrUdpOut));
    		} catch (IOException e1) {
    			e1.printStackTrace();
    		}

    		System.out.println("==============================================\n");
        	System.out.println("Mostrando o históricos dos OIDs:\n");
        	System.out.println(oidClass .getOIDs());
        	System.out.println(oidClass2.getOIDs());
        	System.out.println(oidClass3.getOIDs());
        	System.out.println(oidClass4.getOIDs());
        	System.out.println(oidClass5.getOIDs());
        	System.out.println("\n==============================================");
        	System.out.println("==============================================\n");
        	System.out.println("Mostrando o históricos dos OIDs Obrigatórios:\n" );
        	System.out.println("IPs In:   "  + oidIpIn  .getOIDs());
        	System.out.println("IPs Out:  "  + oidIpOut .getOIDs() + "\n");
        	System.out.println("TCPs In:  "  + oidTcpIn .getOIDs());
        	System.out.println("TCPs Out: "  + oidTcpOut.getOIDs() + "\n");
        	System.out.println("UDPs In:  "  + oidUdpIn .getOIDs());
        	System.out.println("UDPs Out: "  + oidUdpOut.getOIDs());
        	System.out.println("\n==============================================");
//        	System.out.println("==============================================\n");
//        	System.out.println(oidIfInOctets .getIfInOctets    ());
//        	System.out.println(oidIfOutOctets.getIfOutOctets   ());
//        	System.out.println(oidIfInOctets .getIfInOctetsOld ());
//        	System.out.println(oidIfOutOctets.getIfOutOctetsOld());
//        	System.out.println("\n==============================================");
        	
        	Chart chart  = new Chart();
        	Chart chart2 = new Chart();
        	Chart chart3 = new Chart();
        	Chart chart4 = new Chart();
        	Chart chart5 = new Chart();
        	Chart chart6 = new Chart();
        	
        	frame .addChartPanel(chart , oidIpIn  .getOIDs(), "IPs In"  );
			frame2.addChartPanel(chart2, oidIpOut .getOIDs(), "IPs Out" );
			frame3.addChartPanel(chart3, oidTcpIn .getOIDs(), "TCPs In" );
			frame4.addChartPanel(chart4, oidTcpOut.getOIDs(), "TCPs Out");			
			frame5.addChartPanel(chart5, oidUdpIn .getOIDs(), "UDPs In" );
			frame6.addChartPanel(chart6, oidUdpOut.getOIDs(), "UDPs Out");
			
			frame .setVisible(true);
			frame2.setVisible(true);
			frame3.setVisible(true);
			frame4.setVisible(true);
			frame5.setVisible(true);
			frame6.setVisible(true);
        	
        	Thread.sleep(7000);
    	}
    }
}