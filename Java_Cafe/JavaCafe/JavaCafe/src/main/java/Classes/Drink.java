package Classes;

public class Drink
{
	//Fields:
	private String drinkType;
	private String sugarType;
	private String syrupType;
	private String milkType;
	private String extraIngr;
	private String specialOrders;

	//Constructor:
	public Drink(String drinkType, String sugarType, String syrupType, String milkType, String extraIngr, String specialOrders)
	{
		this.drinkType = drinkType;
		this.sugarType = sugarType;
		this.syrupType = syrupType;
		this.milkType = milkType;
		this.extraIngr = extraIngr;
		this.specialOrders = specialOrders;
	}

	//Setters and Getters:
		//Drink type:
	public void setDrinkType(String drinkType)
	{
		this.drinkType = drinkType;
	}
	public String getDrinkType()
	{
		return this.drinkType;
	}
		//Sugar type:
	public void setSugarType(String sugarType)
	{
		this.sugarType = sugarType;
	}
	public String getSugarType()
	{
		return this.sugarType;
	}
		//Syrup type:
	public void setSyrupType(String syrupType)
	{
		this.syrupType = syrupType;
	}
	public String getSyrupType()
	{
		return this.syrupType;
	}
		//Milk type:
	public void setMilkType(String milkType)
	{
		this.milkType = milkType;
	}
	public String getMilkType()
	{
		return this.milkType;
	}
		//Extra ingredients: 
	public void setExtraIngr(String extraIngr)
	{
		this.extraIngr = extraIngr;
	}
	public String getExtraIngr()
	{
		return this.extraIngr;
	}
		//Special orders:
	public void setSpecialOrders(String specialOrders)
	{
		this.specialOrders = specialOrders;
	}
	public String getSpecialOrders()
	{
		return this.specialOrders;
	}
}