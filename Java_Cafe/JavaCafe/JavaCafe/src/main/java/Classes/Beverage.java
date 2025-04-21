package Classes;

public class Beverage extends Drink
{
	//Fields:
	private String beverageType; 
	private String beverageSize;

	//Constructor:
	public Beverage(String drinkType, String sugarType, String syrupType, String milkType, String extraIngr, String specialOrders, String beverageType, String beverageSize)
	{
		super(drinkType, sugarType ,syrupType ,milkType ,extraIngr ,specialOrders);
		this.beverageType = beverageType;
		this.beverageSize = beverageSize;
	}

	//Setters and Getters:
		//Beverage type:
	public void setBeverageType(String beverageType)
	{
		this.beverageType = beverageType;
	}
	public String getBeverageType()
	{
		return this.beverageType;
	}
		//Beverage size:
	public void setBeverageSize(String beverageSize)
	{
		this.beverageSize = beverageSize;
	}
	public String getBeverageSize()
	{
		return this.beverageSize;
	}
}