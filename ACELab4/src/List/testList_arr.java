package List;

public class testList_arr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list_arr la = new list_arr();
		
		la.add(0, 'A');
		System.out.println(la);
		
		la.add(0, 'B');
		System.out.println(la);

		System.out.println("get: "+la.get(1));

		System.out.println("set: "+la.set(2, 'C'));
		System.out.println(la);

		la.add(2, 'C');
		System.out.println(la);

		la.add(4, 'D');
		System.out.println(la);

		System.out.println("remove: "+la.remove(1));
		System.out.println(la);
		
		la.add(1,'D');
		System.out.println(la);
		
		la.add(1, 'E');
		System.out.println(la);
		
		System.out.println("get: "+la.get(4));

		la.add(4, 'F');
		System.out.println(la);

		System.out.println("set: "+la.set(2, 'G'));
		System.out.println(la);

		System.out.println(la.get(2));
;


	}

}
