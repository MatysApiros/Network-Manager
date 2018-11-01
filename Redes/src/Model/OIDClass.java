package Model;

import java.util.ArrayList;

public class OIDClass {
	
	private ArrayList<Double> values = new ArrayList<Double>();
	private double ifInOctets    ;
	private double ifOutOctets   ;
	private double ifInOctetsOld ;
	private double ifOutOctetsOld;
	
	public OIDClass () {
		this.ifInOctets  = 0;
		this.ifOutOctets = 0;
	}
	
	public void addValues (double v) {
		values.add(v);
	}
	
	public double getIfInOctets() {
		return ifInOctets;
	}
	
	public double getIfOutOctets() {
		return ifOutOctets;
	}
	
	public double getIfInOctetsOld() {
		return ifInOctetsOld;
	}
	
	public double getIfOutOctetsOld() {
		return ifOutOctetsOld;
	}

	public ArrayList<Double> getOIDs () {
		return values;
	}
	
	public void setIfInOctets (double value) {
		this.ifInOctets = value;
	}
	
	public void setIfOutOctets (double value) {
		this.ifOutOctets = value;
	}
	
	public void setIfInOctetsOld(double ifInOctetsOld) {
		this.ifInOctetsOld = ifInOctetsOld;
	}
	
	public void setIfOutOctetsOld(double ifOutOctetsOld) {
		this.ifOutOctetsOld = ifOutOctetsOld;
	}
}
