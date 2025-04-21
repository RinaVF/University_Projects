class Node {
	public Node next;
	public Node prev;
	private int key;

	public Node(int key) {
		this.key = key;
	}

	public int key() {
		return this.key;
	}

	public void print(String pre, String post) {
		System.out.print(pre + this.key + post);
	}
}

class List {
	private Node head;
	private Node tail;

	public List() {
		head = new Node(0);
		tail = new Node(0);
		head.next = tail;
		tail.prev = head;
	}

	public void insertFirst(int key) {
		Node tmp = new Node(key);

		tmp.prev = head;
		tmp.next = head.next;

		head.next = tmp;
		tmp.next.prev = tmp;
	}

	public List copy() {
		List list = new List();
		Node node = this.tail.prev;
		while(node != this.head) {
			list.insertFirst(node.key());
			node = node.prev;
		}
		return list;
	}

	public void print() {
		Node current = this.head.next;
		System.out.print("[");
		while(current != this.tail) {
		       	current.print(" ", ",");
			current = current.next;
		}
		System.out.println(" ]");
	}

	public List filter(List list) {

		List newList = new List();			//Η λίστα με τα κοινά κλειδιά
		Node thisCurr = this.tail.prev;		//Ο τρέχον κόμβος του this
		Node listCurr = list.tail.prev;		//Ο τρέχον κόμβος του list
		Node newCurr = new Node(0);			//Ο τρέχον κόμβος του newList
		Boolean isInserted;					//Είναι το τρέχον κλειδί στην λίστα;

		//Όσο δεν έχουμε εξετάσει όλη την this:
		while(thisCurr!=this.head)
		{
			isInserted = false;	
			listCurr = list.tail.prev;	

			//Όσο δεν έχουμε εξετάσει όλη την list και δεν είναι το κλειδί στην λίστα:
			while(listCurr!=list.head && isInserted==false)
			{
				//Αν βρεθούν κοινά κλειδιά:
				if(thisCurr.key()==listCurr.key()) 
				{
					newCurr = newList.head.next;

					//Όσο δεν έχει εξεταστεί όλη η newList
					while(newCurr!=newList.tail && isInserted==false)
					{
						//Αν υπάρχει ήδη το κλειδί στην λίστα:
						if(newCurr.key()==thisCurr.key())
							isInserted = true;

						newCurr = newCurr.next;
					}

					//Αν δεν είναι το κλειδί ήδη στην λίστα:
					if(isInserted==false)
					{	
						newList.insertFirst(thisCurr.key());
						isInserted = true;	
					}
				}

				listCurr = listCurr.prev; 	//Ο επόμενως τρέχον κόμβος του list
		
			}

			thisCurr = thisCurr.prev; 	//Ο επόμενως τρέχον κόμβος του list
	
		}	

		return newList;							//Επέστρεψε καινούργια λίστα

	}

	public List mergeWith(List list) {
		
		List thisCopy = this.copy();		//Αντίγραφο της this
		List listCopy = list.copy();		//Αντίγραφο της this
		List newList = new List();			//Η λίστα που προκύπτει από συγχώνευση

		//Ταξινόμηση των αντιγράφων:
		insertionSort(thisCopy);
		insertionSort(listCopy);

		Node thisCurr = thisCopy.tail.prev;		//Τρέχον κόμβος λίστας this
		Node listCurr = listCopy.tail.prev;		//Τρέχον κόμβος λίστας list 

		//Όσο κάποια από τις λίστες this και list δεν είναι άδεια:
		while(thisCurr!=thisCopy.head && listCurr!=listCopy.head)
		{
			//Αν το κλειδί της this είναι μεγαλύτερο/ίσο του κλειδιού της list:
			if(thisCurr.key()>=listCurr.key())
			{
				newList.insertFirst(thisCurr.key());
				thisCurr = thisCurr.prev;

			}//Αν το κλειδί της this είναι μικρότερο του κλειδιού της list:
			else
			{
				newList.insertFirst(listCurr.key());
				listCurr = listCurr.prev;
			}
		}

		//Αν η λίστα this δεν έχει αδειάσει:
		while(thisCurr!=thisCopy.head)
		{
			newList.insertFirst(thisCurr.key());
			thisCurr = thisCurr.prev;
		}

		//Αν η λίστα list δεν έχει αδειάσει:
		while(listCurr!=listCopy.head)
		{
			newList.insertFirst(listCurr.key());
				listCurr = listCurr.prev;
		}

		return newList;							//Επέστρεψε συγχωνευμένη λίστα
	}

	public List largest(int k) {
	
		List newList = new List();			//Η λίστα με τα k μεγαλύτερα κλειδιά της λίστας this
		List workSpace = new List();		//Βοηθητική λίστα
		Node tmp = new Node(0);				//Βοηθητικός κόμβος
		int counter = k;					//Πόσα στοιχεία χρειαζόμαστε για την νέα λίστα

		//Η workspace είναι ταξινομημένο αντίγραφο της this:
		workSpace = this.copy();
		insertionSort(workSpace);

		tmp = workSpace.tail.prev;			//Ο βοηθητικός κόμβος είναι το μεγαλύτερο κλειδί

		//Όσο το counter δεν είναι 0:
		while(counter>0)
		{
			newList.insertFirst(tmp.key());
			tmp = tmp.prev;

			//Αν δεν υπάρχει άλλο στοιχείο στην λίστα:
			if(tmp == workSpace.head) 
				return newList;

			counter--;						//Χρειαζόμαστε ένα λιγότερο στοιχείο
		}

		return newList;						//Επέστρεψε καινούργια Λίστα
	}

	public static void insertionSort(List list) {
		
		List sorted = new List();				//Λίστα με ταξινομημένα στοιχεία
		List workSpace = new List();			//Βοηθητική λίστα
		Node current = list.head.next.next;		//Τρέχον κόμβος σύγκρισης
		Node back = current.prev;				//Οι προυηγούμενοι κόμβοι από τον τρέχον

		//Αν η Λίστα δεν είναι άδεια ή με ένα στοιχείο:
		if(list.head.next!=list.tail && list.head.next.next!=list.tail)
		{
			//Όσο δεν έχουμε εξετάσει όλη την λίστα:
			while(current!=list.tail)
			{
				//Άδειασμα βοηθητικής λίστας:
				workSpace.head.next = workSpace.tail;
				workSpace.tail.prev = workSpace.head;

				//Αν ο τρέχον κόμβος είναι μεγαλύτερος/ίσος του προυηγούμενο του:
				if(current.key()>=back.key())
				{
					//Εισαγωγή του τρέχον κόμβου:
					workSpace.insertFirst(current.key());
					//Εισαγωγή των προυηγούμενων του τρέχον κόμβων:
					while(back!=list.head && back!=sorted.head)
					{
						workSpace.insertFirst(back.key());
						back = back.prev;
					}

				}
				else //Αν ο τρέχον κόμβος είναι μικρότερος του προυηγούμενου του:
				{
					//Εισαγωγή των προυηγούμενων του τρέχον κόμβων που είναι μεγαλύτεροι του:
					while(back!=list.head && back!=sorted.head && current.key()<back.key())
					{
						workSpace.insertFirst(back.key());
						back = back.prev;
					}
					//Εισαγωγή του τρέχον κόμβου:
					workSpace.insertFirst(current.key());

					//Αν ο τρέχον κόμβος δεν είναι μικρότερος όλων των προυηγούμενων κόμβων του:
					while(back!=list.head && back!=sorted.head)
					{
						workSpace.insertFirst(back.key());
						back = back.prev;
					}

				}

				sorted = workSpace.copy();			//Η ταξινομημένη λίστα είναι αντίγραφο της βοηθητικής
				current = current.next;				//Ο επόμενως τρέχον κόμβος
				back = sorted.tail.prev;			//Ο προυγούμενος του τρέχον κόμβου (το τελευταίο στοιχείο sorted)
			}	
			
			//Η λίστα list γίνεται η ταξινομημένη λίστα:
			list.head.next = sorted.head.next;		// list.head ---> sorted.head.next
			sorted.head.next.prev = list.head;		// list.head <--- sorted.head.next
			list.tail.prev = sorted.tail.prev;		// sorted.tail.prev <--- list.tail
			sorted.tail.prev.next = list.tail;		// sorted.tail.prev ---> list.tail
				
		}//End of if(list.head.next!=list.tail && list.head.next.next!=list.tail)

	}

	public static void main(String[] args) 
    {
        //Test-Run:
        List a = new List();

		a.insertFirst(1);
		a.insertFirst(12);
		a.insertFirst(14);
		a.insertFirst(16);
		a.insertFirst(15);
		a.insertFirst(6);
		a.insertFirst(4);

		System.out.print("\n Before Sort");
		a.print();
		// Display all node
		insertionSort(a);
		System.out.print("\n After Sort");
		a.print();

		List b = new List();
		b = a.largest(3);
		System.out.print("\n Largest:");
		b.print();

		List c = new List();
		c = b.filter(a);
		System.out.print("\n Filter:");
		c.print();

		List d = new List();
		d = b.mergeWith(a);
		System.out.print("\n mergeWith:");
		d.print();


	
	}
}
