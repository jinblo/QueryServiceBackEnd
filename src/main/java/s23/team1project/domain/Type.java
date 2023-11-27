package s23.team1project.domain;

public enum Type {

	TEXT("Text"),
	RADIOBUTTON("Radiobutton");
	
	private final String displayName;
	
	Type(String displayName) {
		this.displayName = displayName;
		}
	
	public String getDisplayName() {
		return displayName;
		}
}




