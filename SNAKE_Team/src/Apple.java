import java.util.Random;

public class Apple {
	
	private Punto mela;
	
	public Apple(){
		mela=new Punto();
	}
	
	public int randomAppleX(){
		 Random rand = new Random();
		  int xRand = rand.nextInt((mela.xMax - mela.xmin) + 1) + mela.xmin;
		  return xRand;
	}
	
	public int randomAppleY(){
		 Random rand = new Random();
		  int yRand = rand.nextInt((mela.yMax - mela.ymin) + 1) + mela.ymin;
		  return yRand;
	}
	
}











