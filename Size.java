package beverageShop;

public enum Size {
	SMALL(0),
	MEDIUM(1),
	LARGE(2);
	
	private final int value;
	
	Size(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
}
