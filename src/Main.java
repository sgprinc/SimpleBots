import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main {

	public static Robot robot;
	public static Random random = new Random();
	
	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		robot = new Robot();
		robot.setAutoDelay(40);
		robot.setAutoWaitForIdle(true);

		// Wait a couple seconds before jumping into action
		System.out.println("Starting Program");

		// Bots - Uncomment the action you want
		//RuneScape Bots
		// alchemyBot();
		// fayreBot();
		// fayreArcheryBot();
		// superHeatBot();
		// smithBot();

		//MapleStory2 Bots
		//fishingBot();
		
		java.awt.Toolkit.getDefaultToolkit().beep();
		java.awt.Toolkit.getDefaultToolkit().beep();
		java.awt.Toolkit.getDefaultToolkit().beep();
		System.out.println("-DONE-");
	}

	
	//RuneScape Bots
	public static void alchemyBot() {
		int iterations = 400;
		int itemX, itemY;
		robot.delay(3000);
		itemX = MouseInfo.getPointerInfo().getLocation().x;
		itemY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		// Operational loop
		for (int i = 0; i < iterations; ++i) {
			System.out.print("["+i+"/"+iterations+"] - ");
			// Press 0
			shortCutPress(KeyEvent.VK_0);

			// Clicking down
			randomTwitch(itemX, itemY, 45, 45);
			leftClick();

			// Waiting for action animation0
			actionCooldown(1350);
			randomWait();
		}
	}

	public static void fayreArcheryBot() {
		int targetX, targetY;
		int buttonX, buttonY;
		
		robot.delay(3000);
		targetX = MouseInfo.getPointerInfo().getLocation().x;
		targetY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();

		robot.delay(3000);
		buttonX = MouseInfo.getPointerInfo().getLocation().x;
		buttonY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		for (int i = 0; i < 100; i++) {
			moveToTarget(targetX, targetY, 40, 40);
			leftClick();
			actionCooldown(300);
			
			moveToTarget(buttonX, buttonY, 150, 50);
			leftClick();
			actionCooldown(31000);
			randomWait();
		}

	}

	public static void superHeatBot() {
		int oreX, oreY;
		int bankerX, bankerY;
		int coalBagX, coalBagY;
		int fillOptionX, fillOptionY;
		
		robot.delay(3000);
		oreX = MouseInfo.getPointerInfo().getLocation().x;
		oreY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();

		robot.delay(3000);
		bankerX = MouseInfo.getPointerInfo().getLocation().x;
		bankerY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		robot.delay(3000);
		coalBagX = MouseInfo.getPointerInfo().getLocation().x;
		coalBagY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		robot.delay(3000);
		fillOptionX = MouseInfo.getPointerInfo().getLocation().x;
		fillOptionY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();		

		robot.delay(2000);
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		// Operational loop
		for (int i = 0; i < 100; ++i) {// Clicking down
			moveToTarget(oreX, oreY, 50, 50);
			for (int j = 0; j < 21; j++) {
				randomTwitch(oreX, oreY, 50, 50);
				shortCutPress(KeyEvent.VK_0);
				actionCooldown(150);
				leftClick();
				actionCooldown(300);
			}
			randomWait();
			
			// Click Banker
			moveToTarget(bankerX, bankerY, 50, 50);
			leftClick();
			actionCooldown(150);
			
			//Fill Coal Bag
			moveToTarget(coalBagX, coalBagY, 50, 50);
			rightClick();
			moveToTarget(fillOptionX, fillOptionY, 220, 5);
			leftClick();
			actionCooldown(100);
			
			// Load Ore
			shortCutPress(KeyEvent.VK_1);
			actionCooldown(150);
			
		}
	}

	public static void smithBot() {
		int anvilX, anvilY;
		int bankerX, bankerY;
		//Due to camera movement, the first run has to be hard coded
		
		robot.delay(3000);
		anvilX = MouseInfo.getPointerInfo().getLocation().x;
		anvilY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();

		//Go & Click Anvil
		leftClick();
		actionCooldown(5000);
		
		//Click & Smith
		shortCutPress(KeyEvent.VK_SPACE);
		actionCooldown(35000);
		randomWait();
		
		//Get Banker Location
		robot.delay(3000);
		bankerX = MouseInfo.getPointerInfo().getLocation().x;
		bankerY = MouseInfo.getPointerInfo().getLocation().y;
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		//Go to Bank and Load Preset
		leftClick();
		actionCooldown(5000);
		shortCutPress(KeyEvent.VK_2);
		actionCooldown(200);
				
		// Operational loop
		for (int i = 0; i < 100; ++i) {
			//Go & Click Anvil
			moveToTarget(anvilX, anvilY, 40, 40);
			leftClick();
			actionCooldown(4500);
			
			//Click & Smith
			shortCutPress(KeyEvent.VK_SPACE);
			actionCooldown(35000);
			randomWait();

			// Clicking down
			moveToTarget(bankerX, bankerY, 50 , 50);
			leftClick();
			actionCooldown(4500);
			shortCutPress(KeyEvent.VK_2);
			actionCooldown(175);				
			
			// Waiting for action animation0
			randomWait();
		}
	}

	public static void leftClick() {
		System.out.println("Clicking");
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(random.nextInt(100) + 50);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(random.nextInt(100) + 100);
	}
	
	public static void rightClick() {
		System.out.println("Clicking");
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.delay(random.nextInt(100) + 50);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
		robot.delay(random.nextInt(100) + 100);
	}

	public static void shortCutPress(int key) {
		System.out.println("Activating hotkey");
		robot.keyPress(key);
		robot.delay(random.nextInt(100) + 50);
		robot.keyRelease(key);
		robot.delay(random.nextInt(100) + 50);
	}

	//MapleStory Bots
	public static void fishingBot(){
		int iterations = 100;
		int itemX, itemY;
		robot.delay(3000);
		itemX = MouseInfo.getPointerInfo().getLocation().x;
		itemY = MouseInfo.getPointerInfo().getLocation().y;
		System.out.println("X-Y: "+ itemX + " - " + itemY);
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		// Operational loop
		for (int i = 0; i < iterations; ++i) {
			System.out.print("["+i+"/"+iterations+"] - ");
			
			// Clicking down
			randomTwitch(itemX, itemY, 45, 45);
			leftClick();

			// Waiting for action animation0
			actionCooldown(2000);
		}
		
	}
	
	public static void actionCooldown(int time) {
		System.out.println("Waiting");
		int wait = random.nextInt(time/2) + time;
		robot.delay(wait);
	}

	public static void randomWait() {
		int randomWait = random.nextInt(5000) + 3;
		if (randomWait % 3 == 0 || randomWait % 7 == 0) {
			System.out.println("Random wait of " + randomWait + " miliseconds");
			robot.delay(randomWait);
		}
	}

	public static void randomTwitch(int itemX, int itemY, int rangeX, int rangeY) {
		int randomChance = random.nextInt(500) + 3;
		if (randomChance % 10 == 0) {
			System.out.println("Random mouse movement");

			int currentX = MouseInfo.getPointerInfo().getLocation().x;
			int currentY = MouseInfo.getPointerInfo().getLocation().y;

			int variationX = (random.nextInt(rangeX) - rangeX/2);
			int variationY = (random.nextInt(rangeY) - rangeY/2);

			int steps = 30;

			double dx = (itemX + variationX - currentX) / ((double) steps);
			double dy = (itemY + variationY - currentY) / ((double) steps);

			for (int step = 1; step <= steps; step++) {
				robot.mouseMove((int) (currentX + dx * step), (int) (currentY + dy * step));
				robot.delay(1);
			}

		}
	}

	public static void moveToTarget(int targetX, int targetY, int rangeX, int rangeY) {

		int currentX = MouseInfo.getPointerInfo().getLocation().x;
		int currentY = MouseInfo.getPointerInfo().getLocation().y;

		int variationX = (random.nextInt(rangeX) - rangeX/2);
		int variationY = (random.nextInt(rangeY) - rangeY/2);

		int steps = 20;

		double dx = (targetX + variationX - currentX) / ((double) steps);
		double dy = (targetY + variationY - currentY) / ((double) steps);

		for (int step = 1; step <= steps; step++) {
			robot.mouseMove((int) (currentX + dx * step), (int) (currentY + dy * step));
			robot.delay(1);
		}
	}
}
