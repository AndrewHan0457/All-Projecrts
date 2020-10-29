package List;

public class list_arr {
	
	private Object[] os;
	
	public list_arr() {
		os = new Object[1];
	}
	
	public int size() {
		return os.length;
	}
	
	public Boolean isEmpty() {
		if(os[0]==null)
			return true;
		else
			return false;
	}
	
	public Object get(int i) {
		if(i>=0&&i<=this.size()-1)
			return os[i];
		System.out.println("ERROR From Get: Invalid i!");
		return null;
	}
	
	public Object set(int i, Object o) {
		if(i>=0&&i<=this.size()-1) {
			Object temo = this.get(i);
			os[i] = o;
			return temo;
		}
		System.out.println("ERROR From Set: Invalid i!");		
		return null;
	}
	
	public void add(int i, Object o) {
		if(i>=0&&i<=this.size()) {
			if(this.isEmpty()) {
				os[0] = o;
				return;
			}
			Object[] os2 = new Object[this.size()+1];
			for(int m = 0; m < i; m++) {
				os2[m] = os[m];
			}
			System.arraycopy(os, i, os2, i+1, this.size()-i);
			os2[i] = o;
			os = os2;
			return;
		}
		System.out.println("ERROR From Add: Invalid i!");
	}

	public Object remove(int i) {
		if(i>=0&&i<=this.size()-1) {
			if(this.isEmpty()) {
				System.out.println("Error From Remove: Empty!");
				return null;
			}
			Object temo = this.get(i);
			this.set(i, null);
			Object[] os2 = new Object[this.size()-1];
			for(int m = 0; m < i; m++) {
				os2[m] = os[m];
			}
			System.arraycopy(os, i+1, os2, i, this.size()-i-1);
			this.os = os2;
			return temo;
		}
		System.out.println("ERROR From Remove: Invalid i!");		
		return null;
	}

	@Override
	public String toString() {
		String str = "";
		for(int i=0;i<this.size();i++) {
			str = str +" "+ os[i].toString();
		}
		return "list_arr [" +str.trim()+ "]";
	}
	
	
	
}
