package JavaCafe.gui.JavaCafe;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import Classes.Drink;
import Classes.Coffee;
import Classes.Beverage;
import Classes.Order;

public class ManageSceneCreator extends SceneCreator implements EventHandler<MouseEvent>
{
	private int AA = 0; //Total orders
	private Order selectedOrder = null; //Initialise selected order
	private Drink originalDrink = null; //Initialise selected order
	private ArrayList<Double> priceList = new ArrayList<>();
	private ArrayList<Drink> drinkList = new ArrayList<>();
	private static ArrayList<Order> orderList = new ArrayList<>();
	private FlowPane buttonFlowpane;
	private GridPane rootGridpane, orderInputGridPane;
	private VBox tableButtonsVbox;
	private TableView<Order> manageTV;
	private Button newOrderBtn, upOrderBtn, canOrderBtn, returnBtn;
	private Label drinkTypeLbl, sugarTypeLbl, syrupTypeLbl, milkTypeLbl, extraIngrLbl, specialOrdersLbl;
	private Label coffeeTypeLbl, coffeeDoseLbl, sugarAmountLbl;
	private Label beverageTypeLbl, beverageSizeLbl;
	private Label orderDayLbl, orderMonthLbl, orderYearLbl, orderWayLbl, orderAddrLbl, orderStatusLbl, orderHourLbl, orderMinsLbl, orderTotalPriceLbl;
	private ComboBox<String> drinkTypeCB, sugarTypeCB, syrupTypeCB, milkTypeCB, extraIngrCB;
	private ComboBox<String> coffeeTypeCB, coffeeDoseCB, sugarAmountCB;
	private ComboBox<String> beverageTypeCB, beverageSizeCB;
	private ComboBox<String> orderDayCB, orderMonthCB, orderYearCB, orderHourCB, orderMinsCB, orderStatusCB, orderWayCB;
	private TextField specialOrderTF;
	private TextField orderAddrTF;
	private TextField orderTotalPriceTF;
	
	public ManageSceneCreator(double width, double height) 
	{
		super(width, height);
		
		//Create and set buttons:
		newOrderBtn = new Button("Υποβολή");
		upOrderBtn = new Button("Επεξεργασία");
		canOrderBtn = new Button("Ακύρωση");
		returnBtn = new Button("Επιστροφή");
		buttonFlowpane = new FlowPane();
		buttonFlowpane.setAlignment(Pos.CENTER);
		buttonFlowpane.setVgap(5);
		buttonFlowpane.setHgap(5);
		buttonFlowpane.getChildren().addAll(newOrderBtn, upOrderBtn, canOrderBtn, returnBtn);
			//Assign Handler to buttons:
		newOrderBtn.setOnMouseClicked(this);
		upOrderBtn.setOnMouseClicked(this);
		canOrderBtn.setOnMouseClicked(this);
		returnBtn.setOnMouseClicked(this);
	
		//Create and set order's info:
			//Create Labels:
		drinkTypeLbl = new Label("Τύπος");			//Drink
		sugarTypeLbl = new Label("Γλυκαντική ουσία");
		syrupTypeLbl = new Label("Σιρόπι");
		milkTypeLbl = new Label("Τύπος γαλακτοκομικών");
		extraIngrLbl = new Label("Επιπλέον συστατικά");
		specialOrdersLbl = new Label("Ειδικές οδηγίες");
		coffeeTypeLbl = new Label("Τύπος Καφέ"); 		//Coffee
		coffeeDoseLbl = new Label("Δόση"); 
		sugarAmountLbl = new Label("Ποσ. Ζάχαρης");
		beverageTypeLbl = new Label("Είδος ροφήματος");		//Beverage
		beverageSizeLbl = new Label("Μέγεθος");
		orderDayLbl = new Label("DD");				//Order
		orderMonthLbl = new Label("MM");
		orderYearLbl = new Label("YYYY"); 
		orderWayLbl = new Label("Τρόπος παράδοσης");
 		orderAddrLbl = new Label("Τόπος παράδοσης");
		orderStatusLbl = new Label("Κατάσταση παραγγελίας");
		orderHourLbl = new Label("H");
		orderMinsLbl = new Label("M");
		orderTotalPriceLbl = new Label("Συνολική Τιμή");

			//create comboboxes and TextFields:
		drinkTypeCB = new ComboBox<>();				//Drink
		drinkTypeCB.getItems().addAll("Ζεστός", "Κρύος");
		drinkTypeCB.setPromptText("-----");
		sugarTypeCB = new ComboBox<>();
		sugarTypeCB.getItems().addAll("Λευκή Ζάχαρη", 
					      "Μαύρη Ζάχαρη", 
					      "Στέβια", 
					      "Ζαχαρίνη");
		sugarTypeCB.setPromptText("-----");
		syrupTypeCB = new ComboBox<>();
		syrupTypeCB.getItems().addAll("Φράουλα",
					      "Φουντούκι", 
					      "Καραμέλα", 
					      "Σοκολάτα");
		syrupTypeCB.setPromptText("-----");
		milkTypeCB = new ComboBox<>();
		milkTypeCB.getItems().addAll("Γάλα πλήρες", 
					     "Γάλα light", 
					     "Γάλα χωρίς λακτόζη");
		milkTypeCB.setPromptText("-----");
		extraIngrCB = new ComboBox<>();
		extraIngrCB.getItems().addAll("Σαντιγύ", 
									  "Κανέλα", 
									  "Σοκολάτα");
		extraIngrCB.setPromptText("-----");
		specialOrderTF = new TextField(); 
		specialOrderTF.setEditable(true);
		specialOrderTF.setPromptText("-----");
		coffeeTypeCB = new ComboBox<>();			//Coffee
		coffeeTypeCB.getItems().addAll("Στιγμιαίος", 
						"Γαλλικός", 	
						"Εσπρέσο", 
						"Καπουτσίνο");
		coffeeTypeCB.setPromptText("-----");
		coffeeDoseCB = new ComboBox<>();
		coffeeDoseCB.getItems().addAll(	"Μονός", 
										"Διπλός");
		coffeeDoseCB.setPromptText("-----");
		sugarAmountCB = new ComboBox<>();
		sugarAmountCB.getItems().addAll("Σκέτος", 
						"Με ολίγη", 
						"Μέτριος", 
						"Γλυκός");
		sugarAmountCB.setPromptText("-----");
		beverageTypeCB = new ComboBox<>();			//Beverage
		beverageTypeCB.getItems().addAll("Coffeeccino", 
						 "Σοκολάτα");
		beverageTypeCB.setPromptText("-----");
		beverageSizeCB = new ComboBox<>();
		beverageSizeCB.getItems().addAll("Μικρό – 12oz" ,
						 "Μεσαίο – 16oz",
						 "Μεγάλο – 18oz");
		beverageSizeCB.setPromptText("-----");
		orderDayCB = new ComboBox<>();				//Order
		orderDayCB.getItems().addAll("01","02","03","04","05",
					     "06","07","08","09","10",
					     "11","12","13","14","15",
					     "16","17","18","19","20",
					     "21","22","23","24","25",
					     "26","27","28","29","30","31");
		orderDayCB.setPromptText("-----");
		orderMonthCB = new ComboBox<>();
		orderMonthCB.getItems().addAll("01","02","03","04","05","06",
						"07","08","09","10","11","12");
		orderMonthCB.setPromptText("-----");
		orderYearCB = new ComboBox<>();
		orderYearCB.getItems().addAll("2022","2023","2024",
					      "2025","2026", "2027");
		orderYearCB.setPromptText("-----");
		orderHourCB = new ComboBox<>();
		orderHourCB.getItems().addAll("01","02","03","04","05",
					     "06","07","08","09","10",
					     "11","12","13","14","15",
					     "16","17","18","19","20",
					     "21","22","23","24");
		orderHourCB.setPromptText("-----");
		orderMinsCB = new ComboBox<>();
		orderMinsCB.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10",
									"11","12","13","14","15","16","17","18","19","20",
									"21","22","23","24","25","26","27","28","29","30",
									"31","32","33","34","35","36","37","38","39","40",
									"41","42","43","44","45","46","47","48","49","50",
									"51","52","53","54","55","56","57","58","59");
		orderMinsCB.setPromptText("-----");
		orderWayCB = new ComboBox<>();
		orderWayCB.getItems().addAll("Παραλαβή από το μαγαζί",
					     "Παράδοση σε κάποια διεύθυνση");
		orderWayCB.setPromptText("-----");
 		orderAddrTF= new TextField();
		orderAddrTF.setEditable(true);
		orderAddrTF.setPromptText("-----");
		orderStatusCB = new ComboBox<>();
		orderStatusCB.getItems().addAll("Καταχωρημένη", 
						"Σε επεξεργασία", 
						"Έτοιμη για παραλαβή από το κατάστημα", 
						"Έτοιμη για Παράδοση", 
						"Προς παράδοση", 
						"Ολοκληρωμένη");
		orderStatusCB.setPromptText("-----");
		orderTotalPriceTF = new TextField();
		orderTotalPriceTF.setEditable(false);
		orderTotalPriceTF.setPromptText("Επιλεγμένης παραγγελίας");
		
		
			//Customise gridpane:
		orderInputGridPane = new GridPane();
		orderInputGridPane.add(drinkTypeLbl, 0, 0);		//Drink
		orderInputGridPane.add(drinkTypeCB, 1, 0);
		orderInputGridPane.add(sugarTypeLbl, 0, 1);
		orderInputGridPane.add(sugarTypeCB, 1, 1);
		orderInputGridPane.add(syrupTypeLbl, 0, 2);
		orderInputGridPane.add(syrupTypeCB, 1, 2);
		orderInputGridPane.add(milkTypeLbl, 0, 3);
		orderInputGridPane.add(milkTypeCB, 1, 3);
		orderInputGridPane.add(extraIngrLbl, 0, 4);
		orderInputGridPane.add(extraIngrCB, 1, 4);
		orderInputGridPane.add(specialOrdersLbl, 0, 5);
		orderInputGridPane.add(specialOrderTF, 1, 5);
		orderInputGridPane.add(coffeeTypeLbl, 2, 0);		//Coffee
		orderInputGridPane.add(coffeeTypeCB, 3, 0);
		orderInputGridPane.add(coffeeDoseLbl, 2, 1);
		orderInputGridPane.add(coffeeDoseCB, 3, 1);
		orderInputGridPane.add(sugarAmountLbl, 2, 2);
		orderInputGridPane.add(sugarAmountCB, 3, 2);
		orderInputGridPane.add(beverageTypeLbl, 2, 7);		//Beverage		
		orderInputGridPane.add(beverageTypeCB, 3, 7);
		orderInputGridPane.add(beverageSizeLbl, 2, 8);
		orderInputGridPane.add(beverageSizeCB, 3, 8);
		orderInputGridPane.add(orderDayLbl, 0, 6);			//Order
		orderInputGridPane.add(orderDayCB, 1, 6);
		orderInputGridPane.add(orderMonthLbl , 0, 7);
		orderInputGridPane.add(orderMonthCB, 1, 7);
		orderInputGridPane.add(orderYearLbl, 0, 8);
		orderInputGridPane.add(orderYearCB, 1, 8);
		orderInputGridPane.add(orderHourLbl, 0, 9);
		orderInputGridPane.add(orderHourCB, 1, 9);
		orderInputGridPane.add(orderMinsLbl, 0, 10);
		orderInputGridPane.add(orderMinsCB, 1, 10);
		orderInputGridPane.add(orderWayLbl, 0, 11);
		orderInputGridPane.add(orderWayCB, 1, 11);
		orderInputGridPane.add(orderAddrLbl, 0, 12);
		orderInputGridPane.add(orderAddrTF, 1, 12);
		orderInputGridPane.add(orderStatusLbl, 0, 13);
		orderInputGridPane.add(orderStatusCB, 1, 13);;
		orderInputGridPane.add(orderTotalPriceLbl, 2, 10);
		orderInputGridPane.add(orderTotalPriceTF, 2, 11);
		orderInputGridPane.setVgap(5);
		orderInputGridPane.setHgap(5);
		
		//Create TableView columns:	
		manageTV = new TableView<>();
		manageTV.setOnMouseClicked(this);
		TableColumn<Order, String> orderCodeColumn = new TableColumn<>("Αριθμός παραγγελίας");
        orderCodeColumn.setCellValueFactory(new PropertyValueFactory<>("orderCode"));
        manageTV.getColumns().add(orderCodeColumn);
		TableColumn<Order, String> orderDateColumn = new TableColumn<>("Ημερομηνία παραγγελίας");
       	orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        manageTV.getColumns().add(orderDateColumn);
		TableColumn<Order, String> orderAddrColumn = new TableColumn<>("Τόπος παράδοσης");
       	orderAddrColumn.setCellValueFactory(new PropertyValueFactory<>("orderAddr"));
       	manageTV.getColumns().add(orderAddrColumn);
		TableColumn<Order, String> orderWayColumn = new TableColumn<>("Τρόπος παράδοσης");
       	orderWayColumn.setCellValueFactory(new PropertyValueFactory<>("orderWay"));
       	manageTV.getColumns().add(orderWayColumn);
		TableColumn<Order, String> orderStatusColumn = new TableColumn<>("Κατάσταση παραγγελίας");
       	orderStatusColumn.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
       	manageTV.getColumns().add(orderStatusColumn);

		//Add table and buttons to vbox:
		tableButtonsVbox = new VBox(manageTV, buttonFlowpane);
		
		//Add vbox and order input gridpane to root gridpane:
		rootGridpane = new GridPane();
		rootGridpane.add(tableButtonsVbox, 0, 0);
		rootGridpane.add(orderInputGridPane, 1, 0);
		rootGridpane.setVgap(5);
		rootGridpane.setHgap(5);
	}

	@Override
	public void handle(MouseEvent event) 
	{
		
		if (event.getSource() == returnBtn)
		{
			//Set Main Scene Window:
			App.primaryStage.setTitle("JavaCafe");
			App.primaryStage.setScene(App.mainScene);
		} //End of returnBtn
	
		if (event.getSource() == newOrderBtn)
		{
			String coffeeType = coffeeTypeCB.getValue();				//Coffee
			String coffeeDose = coffeeDoseCB.getValue();
			String sugarAmount = sugarAmountCB.getValue();
			String beverageType = beverageTypeCB.getValue();			//Beverage
			String beverageSize =  beverageSizeCB.getValue();
			String drinkType = drinkTypeCB.getValue();					//Drink
			String sugarType = sugarTypeCB.getValue();
			String syrupType =syrupTypeCB.getValue();
			String milkType = milkTypeCB.getValue();
			String extraIngr = extraIngrCB.getValue();
			String specialOrders = specialOrderTF.getText();
			String orderDay = orderDayCB.getValue();					//Order
			String orderMonth = orderMonthCB.getValue();
			String orderYear = orderYearCB.getValue();
			String orderWay = orderWayCB.getValue();
			String orderAddr = orderAddrTF.getText();
			String orderStatus = orderStatusCB.getValue(); 
			String hour = orderHourCB.getValue();
			String mins = orderMinsCB.getValue();
				
			//Handle exceptions:
			if (drinkType == null || sugarType == null || syrupType == null || milkType == null || extraIngr == null || orderDay == null || orderMonth == null || orderYear == null || orderWay == null || (orderAddr.equals("") && !orderWay.equals("Παραλαβή από το μαγαζί")) || (!orderAddr.equals("") && orderWay.equals("Παραλαβή από το μαγαζί")) || orderStatus == null || hour == null || mins == null)
			{	
				//If drink's info is not completed:
				clearText();
				Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Invalid value");
                alertType.setContentText("Λάθος εισαγωγή τιμών. \n Exception message: ");
                alertType.show();
			}
			else
			{
				AA++;
				String orderTime = hour + mins;
				String orderDate = orderDay + orderMonth + orderYear;
				String  orderCode = orderDate + "-" + AA + "-";
				orderDate = orderDate + orderTime;
				
				//Take order and handle exceptions:
				if (coffeeType != null && coffeeDose != null && sugarAmount != null && beverageType == null && beverageSize == null) 
				{
					//If the order is coffee:
					orderCode = orderCode + "Coffee";
					Drink orderDrink = createCoffee( drinkType, sugarType, syrupType, milkType, extraIngr, specialOrders, coffeeType, coffeeDose, sugarAmount);
					createOrder(orderCode, orderDrink, orderDate, orderWay, orderAddr, orderStatus);
					tableSync();
				} 
				else if (coffeeType == null && coffeeDose == null && sugarAmount == null && beverageType != null && beverageSize != null)
				{
					//If the order is beverage:
					orderCode = orderCode + "Beverage";
					Drink orderDrink = createBeverage(drinkType, sugarType, syrupType, milkType, extraIngr, specialOrders, beverageType, beverageSize);
					createOrder(orderCode, orderDrink, orderDate, orderWay, orderAddr, orderStatus);
					tableSync();
				} 
				else
				{
					//If order's info is not filled correctly:
					clearText();
					Alert alertType = new Alert(Alert.AlertType.ERROR);
	                alertType.setTitle("Invalid value");
	                alertType.setContentText("Λάθος εισαγωγή τιμών. \n Exception message: ");
	                alertType.show();
				}
				clearText();
			}
		} //End of newOrderBtn
		
		if (event.getSource() == manageTV)
		{
			selectedOrder = manageTV.getSelectionModel().getSelectedItem();
            if (selectedOrder != null) 
            {	
            	
            	//Initialise coffee and beverage:
           		String coffeeType = null;
           		String coffeeDose = null;
           		String sugarAmount = null;
           		String beverageType = null;
           		String beverageSize = null;
            		
           		Drink drink = selectedOrder.getOrderDrink();
           		originalDrink = drink;
           		if (selectedOrder.getOrderCode().contains("Coffee"))
           		{
           			Coffee coffee = (Coffee) drink;
           			coffeeTypeCB.valueProperty().set(coffee.getCoffeeType());				//Coffee
           			coffeeType = coffee.getCoffeeType();
            		coffeeDoseCB.valueProperty().set(coffee.getCoffeeDose());
            		coffeeDose = coffee.getCoffeeDose();
            		sugarAmountCB.valueProperty().set(coffee.getSugarAmount());
           			sugarAmount = coffee.getSugarAmount();
           		} else 
           		{
           			Beverage beverage = (Beverage) drink;
           			beverageTypeCB.valueProperty().set(beverage.getBeverageType());		//Beverage
           			beverageType = beverage.getBeverageType();
           			beverageSizeCB.valueProperty().set(beverage.getBeverageSize());
           			beverageSize = beverage.getBeverageSize();
           		}
            	
           		drinkTypeCB.valueProperty().set(drink.getDrinkType());				//Drink
           		String drinkType = drink.getDrinkType();
           		sugarTypeCB.valueProperty().set(drink.getSugarType());
           		String sugarType =drink.getSugarType();
           		syrupTypeCB.valueProperty().set(drink.getSyrupType());
           		String syrupType = drink.getSyrupType(); 
            	milkTypeCB.valueProperty().set(drink.getMilkType());
            	String milkType = drink.getMilkType();
           		extraIngrCB.valueProperty().set(drink.getExtraIngr());
           		String extraIngr = drink.getExtraIngr();
           		specialOrderTF.setText(drink.getSpecialOrders());
           		String specialOrders = drink.getSpecialOrders();
           		orderWayCB.valueProperty().set(selectedOrder.getOrderWay());		//Order
           		String orderWay = selectedOrder.getOrderWay();
           		orderAddrTF.setText(selectedOrder.getOrderAddr());
          		String orderAddr = selectedOrder.getOrderAddr();
           		orderStatusCB.valueProperty().set(selectedOrder.getOrderStatus());
            	String orderStatus = selectedOrder.getOrderStatus();
            	String orderCode = selectedOrder.getOrderCode();
            	String orderDate = selectedOrder.getOrderDate();
            	String day = orderDate.substring(0, 2);
            	orderDayCB.valueProperty().set(day);
            	String month = orderDate.substring(2, 4);
            	orderMonthCB.valueProperty().set(month);
            	String Year = orderDate.substring(4, 8);
            	orderYearCB.valueProperty().set(Year);
            	String Hour = orderDate.substring(8, 10);
            	orderHourCB.valueProperty().set(Hour);
            	String Mins = orderDate.substring(10, 12);
            	orderMinsCB.valueProperty().set(Mins);
            	orderTotalPriceTF.setText( ""+selectedOrder.calculateTolalPrice(selectedOrder.getOrderCode(), selectedOrder.getOrderDrink()));
            }
		}
            		
        if (event.getSource() == upOrderBtn )
        {
        	
        	if (selectedOrder != null && originalDrink !=null) 
        	{
        		//Get new Input to upload order:
        		String coffeeType = coffeeTypeCB.getValue();				//Coffee
        		String coffeeDose = coffeeDoseCB.getValue();
        		String sugarAmount = sugarAmountCB.getValue();
        		String beverageType = beverageTypeCB.getValue();			//Beverage
        		String beverageSize =  beverageSizeCB.getValue();
        		String drinkType = drinkTypeCB.getValue();					//Drink
        		String sugarType = sugarTypeCB.getValue();
        		String syrupType =syrupTypeCB.getValue();
        		String milkType = milkTypeCB.getValue();
        		String extraIngr = extraIngrCB.getValue();
        		String specialOrders = specialOrderTF.getText();
        		String orderDay = orderDayCB.getValue();					//Order
        		String orderMonth = orderMonthCB.getValue();
        		String orderYear = orderYearCB.getValue();
        		String orderWay = orderWayCB.getValue();
        		String orderAddr = orderAddrTF.getText();
        		String orderStatus = orderStatusCB.getValue();
        		String hour = orderHourCB.getValue();
        		String mins = orderMinsCB.getValue();
        		
        		//Handle exceptions:
        		if (drinkType == null || sugarType == null || syrupType == null || milkType == null || extraIngr == null || orderDay == null || orderMonth == null || orderYear == null || orderWay == null || orderAddr == null || orderStatus == null || hour == null || mins == null)
        		{	
        			//If drink's info is not completed:
        			Alert alertType = new Alert(Alert.AlertType.ERROR);
        			alertType.setTitle("Invalid value");
        			alertType.setContentText("Λάθος εισαγωγή τιμών.");
        			alertType.show();
        		}
        		else
        		{
        			String orderDate = orderDay + orderMonth + orderYear + hour + mins;
        			//Take new input and handle exceptions:
        			if (((coffeeType != null && coffeeDose != null && sugarAmount != null && beverageType == null && beverageSize == null) || (coffeeType == null && coffeeDose == null && sugarAmount == null && beverageType != null && beverageSize != null)) && selectedOrder.getOrderStatus().equals("Καταχωρημένη")) 
        			{
        				//Upload order:
        				uploadOrder(selectedOrder.getOrderCode(), coffeeType, coffeeDose, sugarAmount, beverageType, beverageSize, drinkType, sugarType, syrupType, milkType, extraIngr, specialOrders, orderDate, orderWay, orderAddr, orderStatus, originalDrink);
        				tableSync();
        				clearText();
        			} else
        			{
        				//If order's info is not filled correctly:
        				clearText();
        				Alert alertType = new Alert(Alert.AlertType.ERROR);
        				alertType.setTitle("Invalid value");
        				alertType.setContentText("Λάθος εισαγωγή τιμών ή η παραγγελία δεν είναι καταχωρημένη");
        				alertType.show();
        			}
        		}
        	}
        } //End of upOrderBtn
      
        if (event.getSource() == canOrderBtn)
      	{
        	if (selectedOrder != null && originalDrink != null)
        	{
        		if (selectedOrder.getOrderCode().equals("Καταχωρημένη"))
        		{
        			cancelOrder(selectedOrder.getOrderCode(), originalDrink);
        			tableSync();
        			clearText();
        		}else
        		{
        			clearText();
            		Alert alertType = new Alert(Alert.AlertType.ERROR);
            		alertType.setTitle("Invalid value");
            		alertType.setContentText("Δεν έχει επιλεχθεί καταχωρημένη παραγγελία.");
            		alertType.show();
        		}
        	}
      	}
	}

	//Create coffee order:
	public Drink createCoffee(String drinkType, String sugarType, String syrupType, String milkType, String extraIngr, String specialOrders, String coffeeType, String coffeeDose, String sugarAmount)
	{
		Drink c = new Coffee(drinkType, sugarType, syrupType, milkType, extraIngr, specialOrders, coffeeType, coffeeDose, sugarAmount);
		drinkList.add(c);
		return c;
	}
	
	//Create beverage order:
	public Drink createBeverage(String drinkType, String sugarType, String syrupType, String milkType, String extraIngr, String specialOrders, String beverageType, String beverageSize)
	{
		Drink b = new Beverage(drinkType, sugarType, syrupType, milkType, extraIngr, specialOrders, beverageType, beverageSize);
		drinkList.add(b);
		return b;
	}
	
	//Create order:
	public void createOrder(String orderCode, Drink orderDrink, String orderDate, String orderWay, String orderAddr, String orderStatus)
	{
		Order o = new Order(orderCode, orderDrink, orderDate, orderWay, orderAddr, orderStatus);
		orderList.add(o);
		priceList.add(o.calculateTolalPrice(orderCode, orderDrink));
	}
    
    //Update order:
    public void uploadOrder(String orderCode, String coffeeType, String coffeeDose, String sugarAmount, String beverageType, String beverageSize, String drinkType, String sugarType, String syrupType, String milkType, String extraIngr, String specialOrders,String orderDate, String orderWay, String orderAddr, String orderStatus, Drink originalDrink)
    {
    	//Create updated drink and check if it's a coffee or a beverage:
    	Drink orderDrink;
    	String drinkIs;
    	if (orderCode.contains("Coffee"))
		{
    		drinkIs = "Coffee";
			orderDrink = new Coffee(drinkType, sugarType, syrupType, milkType, extraIngr, specialOrders, coffeeType, coffeeDose, sugarAmount);
		} else
		{
			drinkIs = "Beverage";
			orderDrink = new Beverage(drinkType, sugarType, syrupType, milkType, extraIngr, specialOrders, beverageType, beverageSize);
		}
    	
    	//Update orderList:
    	for (Order o : orderList) 
    	{
            if ((o.getOrderCode()).equals(orderCode)) 
            {
            	//Update:
                o.setOrderAddr(orderAddr);
                o.setOrderWay(orderWay);
                o.setOrderDate(orderDate);
                o.setOrderStatus(orderStatus);
                o.setOrderDrink(orderDrink);
                priceList.add(orderList.indexOf(o),o.calculateTolalPrice(orderCode, orderDrink));
            }
        }
    	
    	//Update drinkList:
    	for (Drink d : drinkList)
    	{
    		if (d.equals(originalDrink))
    		{
    			d.setDrinkType(drinkType);
    			d.setSugarType(sugarType);
    			d.setSyrupType(syrupType);
    			d.setMilkType(milkType);
    			d.setExtraIngr(extraIngr);
    			d.setSpecialOrders(specialOrders);
    			
    			if (drinkIs.equals("Coffee"))
    			{
    				((Coffee) d).setCoffeeType(coffeeType);
    				((Coffee) d).setCoffeeDose(coffeeDose);
    				((Coffee) d).setSugarAmount(sugarAmount);
    			} else if (drinkIs.equals("Beverage"))
    			{
    				((Beverage) d).setBeverageType(beverageType);
    				((Beverage) d).setBeverageSize(beverageSize);
    			}
    		}
    	}
    }
     
    //Cancel Order:
    public void cancelOrder(String orderCode, Drink originalDrink)
    {
    	for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderCode().equals(orderCode))
            {
            	//Remove Order and price:
            	orderList.remove(i);
            	priceList.remove(i);
                break;
            }
        }
    	
    	for (int i = 0; i < drinkList.size(); i++)
    	{
    		if (drinkList.get(i).equals(originalDrink))
    		{
    			//Remove Drink:
    			drinkList.remove(i);
    			break;
    		}
    	}
    }
    
    //Sync TableView:
    public void tableSync()
    {
        List<Order> items = manageTV.getItems();
        items.clear();
        for (Order o : orderList) 
        {
            if (o instanceof Order) { items.add((Order) o);}
        }
    }
    
     //Clear Input:
     public void clearText() 
     {
    	 coffeeTypeCB.valueProperty().set(null);				//Coffee
		 coffeeDoseCB.valueProperty().set(null);	
		 sugarAmountCB.valueProperty().set(null);
	     beverageTypeCB.valueProperty().set(null);				//Beverage
		 beverageSizeCB.valueProperty().set(null);
		 drinkTypeCB.valueProperty().set(null);					//Drink
		 sugarTypeCB.valueProperty().set(null);
		 syrupTypeCB.valueProperty().set(null);
		 milkTypeCB.valueProperty().set(null);
		 extraIngrCB.valueProperty().set(null);
		 specialOrderTF.setText("");
		 orderDayCB.valueProperty().set(null);					//Order
		 orderMonthCB.valueProperty().set(null);
		 orderYearCB.valueProperty().set(null);
		 orderWayCB.valueProperty().set(null);
		 orderAddrTF.setText("");
		 orderStatusCB.valueProperty().set(null);
		 orderHourCB.valueProperty().set(null);
		 orderMinsCB.valueProperty().set(null);
     }
     
     //Getters:
     public ArrayList<Order> getOrderList(){return orderList;}
     public ArrayList<Drink> getDrinkList(){return drinkList;}
     
	@Override
	Scene createScene() { return new Scene(rootGridpane, 800, 650);}
	
}