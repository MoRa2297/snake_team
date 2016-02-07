
public class Nodo {
	private int info;
	private Nodo link;
	
	public Nodo(){
		link = null;
		info = 1;
	}

	public Nodo(int i,Nodo n){
		setLink(n);
		setInfo(i);
	}

	public Nodo(Nodo n){
		info = n.getInfo();
		link = n.getLink();
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int i) {
		info = i;
		if(info < 0){
			info = 1;
		}
	}

	public Nodo getLink() {
		return link;
	}

	public void setLink(Nodo lin) {
		link = lin;
	}

	
	

	
	
}
