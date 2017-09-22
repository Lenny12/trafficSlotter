package mobilityhackathon.model;

public class PlaceWrapper {
	
	private String returnCode;
	private Place[] results;
	
	public PlaceWrapper() {
        super();
    }
	
	public PlaceWrapper(String returnCode, Place[] results) {
		this.setReturnCode(returnCode);
		this.setResults(results);
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public Place[] getResults() {
		return results;
	}

	public void setResults(Place[] results) {
		this.results = results;
	}
	
	public Place getPlace() {
		if (results != null && results.length > 0) {
			return results[0];
		} else {
			return null;
		}
	}

}
