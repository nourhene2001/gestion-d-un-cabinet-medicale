package model;
public class RDV {
    protected String id;
	protected String DateRDV;
	protected String CINPatient;
	protected String HeureRDV;
	
	public RDV(String iD, String dateRDV,String heurerdv, String cINPatient) {
		super();
		this.id = iD;
		this.DateRDV = dateRDV;
		this.CINPatient = cINPatient;
		this.HeureRDV=heurerdv;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHeureRDV() {
		return HeureRDV;
	}
	public void setHeureRDV(String heureRDV) {
		HeureRDV = heureRDV;
	}
	public RDV(String id) {
		this.id = id;
		
	}
	public RDV() {
		
	}
        public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	public String getDateRDV() {
		return DateRDV;
	}
	public void setDateRDV(String dateRDV) {
		DateRDV = dateRDV;
	}

	public String getCINPatient() {
		return CINPatient;
	}
	public void setCINPatient(String cINPatient) {
		CINPatient = cINPatient;
	}
	@Override
	public String toString() {
		return "RDV [id=" + id + ", DateRDV=" + DateRDV + ", CINPatient=" + CINPatient + "]";
	}

        
}
