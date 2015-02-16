public class OpenEntry implements Entry {
	
	private String key;
	private String value;
	
	public OpenEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
}
