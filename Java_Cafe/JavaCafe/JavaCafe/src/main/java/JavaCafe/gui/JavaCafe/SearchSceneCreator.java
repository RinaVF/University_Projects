package JavaCafe.gui.JavaCafe;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import Classes.Beverage;
import Classes.Drink;
import Classes.Coffee;
import Classes.Order;
import java.util.ArrayList;
import java.util.List;

public class SearchSceneCreator extends SceneCreator implements EventHandler<MouseEvent> 
{
	private TableView<Order> searchTV;
	private FlowPane buttonFlowpane;
	private GridPane rootGridpane, searchInfoGridpane;
	private Button searchBtn, returnBtn;
	private Label coffeeBeverageLbl, orderDateLbl, fromLlb, toLbl, orderStatusLbl;
	private ComboBox<String> coffeeBeverageCB, orderStatusCB;
	private TextField fromTF, toTF;
	private VBox tableButtonVbox;
	private ManageSceneCreator orderList = new ManageSceneCreator(0,0);
	
	public SearchSceneCreator(double width, double height)
	{
		super(width, height);
		
		//Create and set Buttons:
		searchBtn = new Button("Αναζήτηση");
		returnBtn = new Button("Επιστροφή");
			//Assign Handler to buttons:
		searchBtn.setOnMouseClicked(this);
		returnBtn.setOnMouseClicked(this);
		buttonFlowpane = new FlowPane();
		buttonFlowpane.setAlignment(Pos.CENTER);
		buttonFlowpane.getChildren().addAll(searchBtn, returnBtn);
		buttonFlowpane.setVgap(5);
		buttonFlowpane.setHgap(5);
		
		//Create Labels:
		coffeeBeverageLbl = new Label("Τύπος Ροφήματος"); 
		orderDateLbl = new Label("Ημερομηνία Παραγγελίας");
		fromLlb = new Label("Από:"); 
		toLbl = new Label("Μέχρι:"); 
		orderStatusLbl = new Label("Κατάσταση Παραγγελίας");
		
		//Create Comboboxes and Textfields:
		coffeeBeverageCB = new ComboBox<>();
		coffeeBeverageCB.getItems().addAll("Καφές",
								  		   "Ρόφημα");
		coffeeBeverageCB.setPromptText("-----");
		fromTF = new TextField();	
		fromTF.setEditable(true);
		fromTF.setPromptText("DDMMYYYYHHMM");
		toTF = new TextField();
		toTF.setEditable(true);
		toTF.setPromptText("DDMMYYYYHHMM");
		orderStatusCB = new ComboBox<>();
		orderStatusCB.getItems().addAll("Καταχωρημένη", 
										   "Σε επεξεργασία", 
										   "Έτοιμη για παραλαβή από το κατάστημα", 
										   "Έτοιμη για Παράδοση", 
										   "Προς παράδοση", 
										   "Ολοκληρωμένη");
		orderStatusCB.setPromptText("-----");
		
		//Customise gridpane:
		searchInfoGridpane = new GridPane();
		searchInfoGridpane.add(coffeeBeverageLbl, 0, 0);
		searchInfoGridpane.add(coffeeBeverageCB, 1, 0);
		searchInfoGridpane.add(orderDateLbl, 0, 1);
		searchInfoGridpane.add(fromLlb, 0, 2);
		searchInfoGridpane.add(fromTF, 1, 2);
		searchInfoGridpane.add(toLbl, 0, 3);
		searchInfoGridpane.add(toTF, 1, 3);
		searchInfoGridpane.add(orderStatusLbl, 0, 4);
		searchInfoGridpane.add(orderStatusCB, 0, 5);
		searchInfoGridpane.setVgap(5);
		searchInfoGridpane.setHgap(5);
		
		//Create TableView columns:	
		searchTV = new TableView<>();
		TableColumn<Order, String> orderCodeColumn = new TableColumn<>("Αριθμός παραγγελίας");
		orderCodeColumn.setCellValueFactory(new PropertyValueFactory<>("orderCode"));
		searchTV.getColumns().add(orderCodeColumn);
		TableColumn<Order, String> orderDateColumn = new TableColumn<>("Ημερομηνία παραγγελίας");
		orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
		searchTV.getColumns().add(orderDateColumn);
		TableColumn<Order, String> orderAddrColumn = new TableColumn<>("Τόπος παράδοσης");
		orderAddrColumn.setCellValueFactory(new PropertyValueFactory<>("orderAddr"));
		searchTV.getColumns().add(orderAddrColumn);
		TableColumn<Order, String> orderWayColumn = new TableColumn<>("Τρόπος παράδοσης");
		orderWayColumn.setCellValueFactory(new PropertyValueFactory<>("orderWay"));
		searchTV.getColumns().add(orderWayColumn);
		TableColumn<Order, String> orderStatusColumn = new TableColumn<>("Κατάσταση παραγγελίας");
		orderStatusColumn.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
		searchTV.getColumns().add(orderStatusColumn);
        	
        //Add table and buttons to vbox:
        tableButtonVbox = new VBox(searchTV, buttonFlowpane);
        
       //Add vbox and order search info gridpane to root gridpane:
        rootGridpane = new GridPane();
        rootGridpane.add(tableButtonVbox, 0, 0);
        rootGridpane.add(searchInfoGridpane, 1, 0);
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
			
		}
		
		if (event.getSource() == searchBtn)
		{
			//Get input:
			
			if (!orderList.getOrderList().equals(null))
			{
				String drinkType = coffeeBeverageCB.getValue();
				if (drinkType != null)
				{
					if (coffeeBeverageCB.getValue().equals("Καφές")) 
					{
						//Is coffee:
						drinkType = "Coffee";
					} else if (coffeeBeverageCB.getValue().equals("Ρόφημα"))
					{
						//Is beverage:
						drinkType = "Beverage";
					}
				}
				
				String from = fromTF.getText();	
				String to = toTF.getText();
				int dayFrom = 0;
				int monthFrom = 0;
				int yearFrom = 0;
				int hourFrom = 0;
				int minsFrom = 0;
				int dayTo = 0;
				int monthTo = 0;
				int yearTo = 0;
				int hourTo = 0;
				int minsTo = 0;
				if (from.length() >= 12 && to.length() >= 12)
				{
					String day;
					String month;
					String year;
					String hour;
					String mins;
					dayFrom = Integer.parseInt(from.substring(0, 2));
					monthFrom = Integer.parseInt(from.substring(2, 4));
					yearFrom = Integer.parseInt(from.substring(4, 8));
					 hourFrom = Integer.parseInt(from.substring(8, 10));
					 minsFrom = Integer.parseInt(from.substring(10, 12));
					 dayTo = Integer.parseInt(to.substring(0,2));
					 monthTo = Integer.parseInt(to.substring(2, 4));
					 yearTo = Integer.parseInt(to.substring(4, 8));
					 hourTo = Integer.parseInt(from.substring(8, 10));
					 minsTo = Integer.parseInt(to.substring(10, 12));
				}
				String orderStatus = orderStatusCB.getValue();
				
				//Check if input is correct and execute search:
				if (drinkType != null && from.equals("") && to.equals("") && orderStatus == null)
				{
					//Search according to type:
					searchFromDrink(drinkType);
					clearText();
				}else if (drinkType == null && !from.equals("") && !to.equals("") && orderStatus == null)
				{
					//If date input is wrong:
					if (dayFrom < 01 || dayFrom > 31 || monthFrom < 00 || monthFrom > 12 || yearFrom < 2022 || yearFrom > 2027 ||
						hourFrom <= 00 || hourFrom >= 24 || minsFrom <= 00 || minsFrom >= 59 ||
						dayTo < 00 || dayTo > 31 || monthTo < 00 || monthTo > 12 || yearTo < 2022 || yearTo > 2027 ||
						hourTo < 00 || hourTo > 24 || minsTo < 00 || minsTo >= 59)
					{
						//If drink's info is not completed:
						clearText();
	        			Alert alertType = new Alert(Alert.AlertType.ERROR);
	        			alertType.setTitle("Invalid value");
	        			alertType.setContentText("Λάθος εισαγωγή ημερομηνίας");
	        			alertType.show();
					} else
					{
						//Search from date:
						searchFromDate (dayFrom, monthFrom, yearFrom, hourFrom, minsFrom, dayTo, monthTo, yearTo, hourTo, minsTo);
						clearText();
					}
					
				}else if (drinkType == null && from.equals("") && to.equals("") && orderStatus != null)
				{
					//Search from Status:
					searchFromStatus(orderStatus);
				}else
				{
					//If input is wrong:
					clearText();
					Alert alertType = new Alert(Alert.AlertType.ERROR);
	    			alertType.setTitle("Invalid value");
	    			alertType.setContentText("Η αναζήτηση μπορεί να γίνει με τους εξής τρόπους"+
	    										"α) Βάση το είδος του ροφήματος που έχει παραγγελθεί\n"+
	    										"β) Βάση την κατάσταση της παραγγελίας\n"+
	    										"γ) Βάση τη χρονική στιγμή που καταχωρήθηκε η παραγγελία\n");
	    			alertType.show();
				}
			}else if (orderList.getOrderList().equals(null))
			{
				clearText();
				Alert alertType = new Alert(Alert.AlertType.ERROR);
    			alertType.setTitle("Invalid value");
    			alertType.setContentText("Δεν υπάρχουν Καταχωρημένες παραγγελίες");
    			alertType.show();
			}
		}
	}
	
	//Search using type
	public void searchFromDrink(String DrinkType)
	{
		 List<Order> items = searchTV.getItems();
	     items.clear();
	     for (Order o : orderList.getOrderList()) 
	     {
	    	 if(o.getOrderCode().contains(DrinkType)) {if (o instanceof Order) { items.add((Order) o);}}
	     }
	}
	
	//Search using Date:
	public void searchFromDate(int dayFrom, int monthFrom, int yearFrom, int hourFrom, int minsFrom, int dayTo,  int monthTo, int yearTo, int hourTo, int minsTo)
	{
		 List<Order> items = searchTV.getItems();
		 items.clear();
		 for (Order o : orderList.getOrderList()) 
		 {
			 if (Integer.parseInt(o.getOrderDate().substring(0, 2)) >= dayFrom && Integer.parseInt(o.getOrderDate().substring(0, 2)) <= dayTo)
			 {
				 if (Integer.parseInt(o.getOrderDate().substring(2, 4)) >= monthFrom && Integer.parseInt(o.getOrderDate().substring(2, 4)) <= monthTo)
				 {
					 if (Integer.parseInt(o.getOrderDate().substring(4, 8)) >= yearFrom && Integer.parseInt(o.getOrderDate().substring(4, 8)) <= yearTo)
					 {
						 if (Integer.parseInt(o.getOrderDate().substring(8, 10)) >= hourFrom && Integer.parseInt(o.getOrderDate().substring(8, 10)) <= hourTo)
						 {
							 if (Integer.parseInt(o.getOrderDate().substring(10, 12)) >= minsFrom && Integer.parseInt(o.getOrderDate().substring(10, 12)) <= minsTo)
							 {
								 if (o instanceof Order) { items.add((Order) o);}
							 }
						 }
					 }
				 }
			 }
		 }
	}
	
	//Search using Status:
	public void searchFromStatus(String orderStatus)
	{
		List<Order> items = searchTV.getItems();
	     items.clear();
	     for (Order o : orderList.getOrderList()) 
	     {
	    	 if(o.getOrderStatus().equals(orderStatus)) {if (o instanceof Order) { items.add((Order) o);}}
	     }
	}
	
	//Clear text:
	public void clearText() 
    {
		coffeeBeverageCB.setValue(null);
		fromTF.setText("");
		toTF.setText("");
		orderStatusCB.setValue(null);
    }

	@Override
	Scene createScene() { return new Scene(rootGridpane, 800, 650);}

}
