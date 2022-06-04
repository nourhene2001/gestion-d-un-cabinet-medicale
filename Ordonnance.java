package model;

public class Ordonnance {
	protected String numord;
	protected String nompatient;
	protected String prenompatient;
	protected String nommedicament;
	protected String dosagemedicament;
	public  Ordonnance(String numord,String nompatient,String prenompatient,String nommedicament,String dosagemedicament) {
		super();
		this.numord=numord;
		this.nompatient=nompatient;
		this.prenompatient=prenompatient;
		this.nommedicament=nommedicament;
		this.dosagemedicament=dosagemedicament;
	}
	
	public Ordonnance(String nommedicament,String dosagemedicament) {
		super();
		this.nommedicament=nommedicament;
		this.dosagemedicament=dosagemedicament;
	}
	public String getNumord() {
		return numord;
	}


	public void setNumord(String numord) {
		this.numord = numord;
	}


	public String getNompatient() {
		return nompatient;
	}
	public void setNompatient(String nompatient) {
		this.nompatient = nompatient;
	}
	public String getPrenompatient() {
		return prenompatient;
	}
	public void setPrenompatient(String prenompatient) {
		this.prenompatient = prenompatient;
	}
	public String getNommedicament() {
		return nommedicament;
	}
	public void setNommedicament(String nommedicament) {
		this.nommedicament = nommedicament;
	}
	public String getDosagemedicament() {
		return dosagemedicament;
	}
	public void setDosagemedicament(String dosagemedicament) {
		this.dosagemedicament = dosagemedicament;
	}	
	public Ordonnance() {
		super();
	}
}


