import java.util.Arrays;

public class Body {

	private Punto[] snake;
	public static int uni = 10;
	
	public Body(){
		snake=new Punto[0];
		for(int i = 0; i < 4; i++){
			increase('U');
		}
	}
	
	private void shiftRight(){
		for(int i = snake.length-1; i > 0; i--){
			snake[i]=snake[i-1];
		}
	}
	
	public int length(){
		return snake.length;
	}
	
	public int[] getItemCoordinates(int index){
		if(index < 0 || index >= snake.length)
			return null;
		return new int[] { snake[index].getX(), snake[index].getY()};
	}
	
	public boolean addSnakeElement(Punto p){
		if(p==null)
			return false;
		if(snake.length == 0 || !p.equals(snake[snake.length-1])){
			snake = Arrays.copyOf(snake, snake.length+1);
			shiftRight();
			snake[0] = new Punto(p);
			return true;
		}
		return false;
		
	}
	
	
	
	public boolean increase(char direction){
		Punto head = null;
		switch(direction){
		case 'd': case 'D': //down
			if(snake.length<1){ 	//it shouldn't be needed but managing also this case is better because we have to be sure to avoid any exception in runtime
				head = new Punto((Punto.xMax-uni)/2, (Punto.yMax-uni)/2+3*uni);
			}else{
				head = new Punto(snake[0].getX(), snake[0].getY()+uni);
			}
			break;
		case 'u': case 'U': //up
			if(snake.length<1){
				head = new Punto((Punto.xMax-uni)/2, (Punto.yMax-uni)/2-3*uni);
			}else{
				head = new Punto(snake[0].getX(), snake[0].getY()-uni);
			}
			break;
		case 'l': case 'L':	//left
			if(snake.length<1){		//it shouldn't be needed but managing also this case is better because we have to be sure to avoid any exception in runtime
				head = new Punto((Punto.xMax-uni)/2+3*uni, (Punto.yMax-uni)/2);
			}else{
				head = new Punto(snake[0].getX()-uni, snake[0].getY());
			}
			break;
		case 'r': case 'R':
			if(snake.length<1){ 	//it shouldn't be needed but managing also this case is better because we have to be sure to avoid any exception in runtime
				head = new Punto((Punto.xMax-uni)/2-3*uni, (Punto.yMax-uni)/2);
			}else{
				head = new Punto(snake[0].getX()+uni, snake[0].getY());
			}
			break;
		default:
			break;
		}
		return addSnakeElement(head);
	}
	
	
	
	
	
	
}
