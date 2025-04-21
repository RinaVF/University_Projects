package Classes;

interface PriceList
{
	//Prices:
	final double coffeePrice = 2.00;
	final double beveragePrice = 3.00;
	final double singleDosePrice = 0.00;
	final double doubleDosePrice = 0.30;
	final double smallSizePrice = 0.00;
	final double mediumSizePrice = 0.30;
	final double largeSizePrice = 0.60;
	final double syrupPrice = 0.30;
	final double whippedCream = 0.30;

	//Return calculated Price:
	public double calculateTolalPrice(String orderCode, Drink orderDrink);
}