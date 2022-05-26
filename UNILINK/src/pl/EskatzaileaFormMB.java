package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EskatzaileaFormMB {

	public EskatzaileaFormMB() {
		// TODO Auto-generated constructor stub
	}

	private String bizilekua;
	private String email;
	private String gaitasunak;
	private String hizkuntzak;
	private String izenAbizenak;
	private String pasahitza;
	private String tituluak;
	private String username;
	
	public EskatzaileaFormMB(String bizilekua, String email, String gaitasunak, String hizkuntzak, String izenAbizenak,
			String pasahitza, String tituluak, String username) {
		super();
		this.bizilekua = bizilekua;
		this.email = email;
		this.gaitasunak = gaitasunak;
		this.hizkuntzak = hizkuntzak;
		this.izenAbizenak = izenAbizenak;
		this.pasahitza = pasahitza;
		this.tituluak = tituluak;
		this.username = username;
	}
	
	public void balioakHasieratu(ProfilaViewMB profilaViewMB)
	{
		bizilekua=profilaViewMB.ikasBatenDatuakLortuDB().getBizilekua();
		email=profilaViewMB.ikasBatenDatuakLortuDB().getEmail();
		gaitasunak=profilaViewMB.ikasBatenDatuakLortuDB().getGaitasunak();
		hizkuntzak=profilaViewMB.ikasBatenDatuakLortuDB().getHizkuntzak();
		izenAbizenak=profilaViewMB.ikasBatenDatuakLortuDB().getIzenAbizenak();
		pasahitza=profilaViewMB.ikasBatenDatuakLortuDB().getPasahitza();
		tituluak=profilaViewMB.ikasBatenDatuakLortuDB().getTituluak();
		username=profilaViewMB.ikasBatenDatuakLortuDB().getUsername();
	}

	public String getBizilekua() {
		return bizilekua;
	}

	public void setBizilekua(String bizilekua) {
		this.bizilekua = bizilekua;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGaitasunak() {
		return gaitasunak;
	}

	public void setGaitasunak(String gaitasunak) {
		this.gaitasunak = gaitasunak;
	}

	public String getHizkuntzak() {
		return hizkuntzak;
	}

	public void setHizkuntzak(String hizkuntzak) {
		this.hizkuntzak = hizkuntzak;
	}

	public String getIzenAbizenak() {
		return izenAbizenak;
	}

	public void setIzenAbizenak(String izenAbizenak) {
		this.izenAbizenak = izenAbizenak;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getTituluak() {
		return tituluak;
	}

	public void setTituluak(String tituluak) {
		this.tituluak = tituluak;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "EskatzaileaFormMB [bizilekua=" + bizilekua + ", email=" + email + ", gaitasunak=" + gaitasunak
				+ ", hizkuntzak=" + hizkuntzak + ", izenAbizenak=" + izenAbizenak + ", pasahitza=" + pasahitza
				+ ", tituluak=" + tituluak + ", username=" + username + "]";
	}
	
	public void clearForm()
	{
		bizilekua="";
		email="";
		gaitasunak="";
		hizkuntzak="";
		izenAbizenak="";
		pasahitza="";
		tituluak="";
		username="";
	}
}
