
import java.util.Arrays;

public class Polyline {
	private Punto [] ElencoPunti;
	private final int NUM_MAX_PUNTI = 50;

	
	public Polyline(){
		ElencoPunti = new Punto[0];
	}
	
	public boolean agg(Punto c){
		if(ElencoPunti.length == NUM_MAX_PUNTI){
			return false;
		}else{
			ElencoPunti=Arrays.copyOf(ElencoPunti,ElencoPunti.length+1);
			ElencoPunti[ElencoPunti.length-1]= c;
			return true;
		}
	}
	
	public void visElenco(){
		for(int i=0;i<ElencoPunti.length;i++){
			System.out.println(ElencoPunti[i].toString());
		}

	}
	
	public boolean eli(int pos){
		if(pos>=NUM_MAX_PUNTI || pos>ElencoPunti.length-1){
			return false;
		}else{
			for(int i=pos;i<ElencoPunti.length-1;i++){
				ElencoPunti[i]=ElencoPunti[i+1];
			}
			ElencoPunti=Arrays.copyOf(ElencoPunti, ElencoPunti.length-1);
			return true;
		}
	}
	
	public Punto getPunto(int pos){
		Punto a=new Punto();
		if(pos>=NUM_MAX_PUNTI || pos>ElencoPunti.length-1){
			return null;
		}else{
			a = new Punto( ElencoPunti[pos]);
			return a;
		}
	}
	public int[] getElenco(){
		int v[]=new int [ElencoPunti.length*2];
		int j=0;
		for(int i=0;i<ElencoPunti.length;i++){
			v[j]=(int) ElencoPunti[i].getX();
			j++;
			v[j]=(int) ElencoPunti[i].getY();
			j++;
		}
		return v;
	}
}