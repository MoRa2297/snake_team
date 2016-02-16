import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class SnakeApp {
	
	protected Shell shell;
	private Canvas canvas;
	private Body snake;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SnakeApp window = new SnakeApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void draw(){
		GC gc = new GC(canvas);
		gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
			
			for(int i = 0; i < snake.length(); i++){
				gc.drawOval(snake.getItemCoordinates(i)[0], snake.getItemCoordinates(i)[1], Body.uni, Body.uni);
			}
		
	}
	
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		
		
		
		
		shell.setSize(650, 450);
		shell.setText("Snake");
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				Body.uni = 10;
				snake=new Body();
				Punto.xMax = canvas.getBounds().width;
				Punto.yMax = canvas.getBounds().height;
				System.out.println(canvas.getBounds());
				GC gc = new GC(canvas);
				for(int i = 0; i < snake.length(); i++){
					gc.drawOval(snake.getItemCoordinates(i)[0], snake.getItemCoordinates(i)[1], Body.uni, Body.uni);
					//gc.drawOval(10,20, Body.uni, Body.uni);
					
				}
				gc.dispose();
			}
		});
		canvas.setBounds(0, 0, 634, 412);

	}
}
