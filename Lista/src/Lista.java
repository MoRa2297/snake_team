import java.awt.Container;

public class Lista {
	
	private Nodo head;
	
	public Lista(){
		head=null;
	}
	
public int Conta(){
		
	int c=0;
	Nodo p=head;
	
	while(p!=null){
			
		c++;
		p=p.getLink();
			
	}
	return c;
}


public boolean cerca(int x){
	boolean flag=false;
	Nodo p = head;
	while(p!=null){
		if(p.getLink()==x){
			flag=true;
		}
		p=p.getLink();
	}
	return flag;
}

public void inserisciInTesta(int x){
	Nodo p = new Nodo();
	p.setInfo(x);
	p.setLink(head);
	head=p;
}

public void inserisciInCoda(int x){
	Nodo p;
	Nodo pn = new Nodo(x);
	if(head==null){
		head=pn;
	}else{
		for(p=head;p.getLink()!=null;p=p.getLink());
		p.setLink(pn);
	}
}

}