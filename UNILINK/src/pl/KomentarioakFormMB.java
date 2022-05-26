package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class KomentarioakFormMB {

	private String testua;
	
	public KomentarioakFormMB() {
		// TODO Auto-generated constructor stub
	}

	public KomentarioakFormMB(String testua) {
		super();
		this.testua = testua;
	}

	public String getTestua() {
		return testua;
	}

	public void setTestua(String testua) {
		this.testua = testua;
	}
	
	public void clearForm()
	{
		this.testua=null;
	}

}
