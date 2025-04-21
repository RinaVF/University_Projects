package Classes;

public class Order implements PriceList
{
	//Fields:
	private String orderCode;
	private Drink orderDrink;
	private String orderDate;
	private String orderWay;
	private String orderAddr;
	private String orderStatus;

	//Constructor:
	public Order(String orderCode, Drink orderDrink, String orderDate, String orderWay, String orderAddr, String orderStatus)
	{
		this.orderCode =orderCode;
		this.orderDrink = orderDrink;
		this.orderDate = orderDate;
		this.orderWay = orderWay;
		this.orderAddr = orderAddr;
		this.orderStatus = orderStatus;
	}
	
	@Override
	public double calculateTolalPrice(String orderCode, Drink orderDrink)
	{
		//Initialise total cost of order:
		double totalPrice = 0.00;

		//Calculate cost:
			//Price of drink:
		if (orderCode.contains("Coffee"))
		{	
			totalPrice = totalPrice + coffeePrice; 
			
				//Price of Dose:
			if (((Coffee) orderDrink).getCoffeeDose().equals("Μονός"))
			{
				totalPrice = totalPrice + singleDosePrice;	
			} else if (((Coffee) orderDrink).getCoffeeDose().equals("Διπλός"))
			{
				totalPrice = totalPrice + doubleDosePrice;
			}

		}else if (orderCode.contains("Beverage"))
		{
			totalPrice = totalPrice + beveragePrice;

				//Price of size:
			if (((Beverage) orderDrink).getBeverageSize().equals("Μικρό – 12oz")) 
			{ 
				totalPrice = totalPrice + smallSizePrice;
			}else if (((Beverage) orderDrink).getBeverageSize().equals("Μεσαίο – 16oz")) 
			{
				totalPrice = totalPrice + mediumSizePrice;
			}else if (((Beverage) orderDrink).getBeverageSize().equals("Μεγάλο – 18oz")) 
			{
				totalPrice = totalPrice + largeSizePrice;
			}
		}
			//Price of syrup and extra ingredients:
		if (!orderDrink.getSyrupType().equals(null)) 
		{
			totalPrice = totalPrice + syrupPrice;
		}
		if (orderDrink.getExtraIngr().equals("Σαντιγύ")) 
		{
			totalPrice = totalPrice + whippedCream;
		}
		return totalPrice;
	}
	
	//Setters and Getters:
		//Order's code number:
	public void setOrderCode(String orderCode)
	{
		this.orderCode = orderCode;
	}
	public String getOrderCode()
	{
		return this.orderCode;
	}
		//Order's Drink:
	public void setOrderDrink(Drink orderDrink)
	{			
		this.orderDrink = orderDrink;
	}
	public Drink getOrderDrink()
	{
		return this.orderDrink;
	}
	//Order's Date and Time:
	public void setOrderDate(String orderDate)
	{			
		this.orderDate = orderDate;
	}
	public String getOrderDate()
	{
			return this.orderDate;
	}
	//Order's way of receipt:
	public void setOrderWay(String orderWay)
	{			
		this.orderWay = orderWay;
	}
	public String getOrderWay()
	{
			return this.orderWay;
	}
	//Order's Address:
	public void setOrderAddr(String orderAddr)
	{			
		this.orderAddr = orderAddr;
	}
	public String getOrderAddr()
	{
			return this.orderAddr;
	}
	//Order's status:
	public void setOrderStatus(String orderStatus)
	{			
		this.orderStatus = orderStatus;
	}
	public String getOrderStatus()
	{
		return this.orderStatus;
	}
}