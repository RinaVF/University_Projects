package Classes;

public class Coffee extends Drink
{
	//Fields:
	private String coffeeType;
	private String coffeeDose;
	private String sugarAmount;

	//Constructor:
	public Coffee(String drinkType, String sugarType, String syrupType, String milkType, String extraIngr, String specialOrders, String coffeeType, String coffeeDose, String sugarAmount)
	{
		super(drinkType, sugarType, syrupType, milkType, extraIngr, specialOrders);
		this.coffeeType = coffeeType;
		this.coffeeDose = coffeeDose;
		this.sugarAmount = sugarAmount;
	}

	//Setters and Getters:
		//Coffee type:
	public void setCoffeeType(String coffeeType)
	{
		this.coffeeType = coffeeType;
	}
	public String getCoffeeType()
	{
		return this.coffeeType;
	}
		//Coffee dose:
	public void setCoffeeDose(String coffeeDose)
	{
		this.coffeeDose = coffeeDose;
	}
	public String getCoffeeDose()
	{
		return this.coffeeDose;
	}
		//Sugar Amount:
	public void setSugarAmount(String sugarAmount)
	{
		this.sugarAmount = sugarAmount;
	}
	public String getSugarAmount()
	{
		return this.sugarAmount;
	}
} 