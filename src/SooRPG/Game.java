package SooRPG;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Game extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;

	private Image BackgroundImage = new ImageIcon(Main.class.getResource("../images/titleImage(GOLD).png")).getImage();
	private Image aboutBackgroundImage = new ImageIcon(Main.class.getResource("../images/aboutBackground.png")).getImage();
	private Image startBackgroundImage = new ImageIcon(Main.class.getResource("../images/startBackground.jpg")).getImage();

	private ImageIcon character1BasicImage = new ImageIcon(Main.class.getResource("../images/character1Basic.png"));
	private ImageIcon character2BasicImage = new ImageIcon(Main.class.getResource("../images/character2Basic.png"));
	private ImageIcon character3BasicImage = new ImageIcon(Main.class.getResource("../images/character3Basic.png"));
	private ImageIcon character1EnteredImage = new ImageIcon(Main.class.getResource("../images/character1Entered.png"));
	private ImageIcon character2EnteredImage = new ImageIcon(Main.class.getResource("../images/character2Entered.png"));
	private ImageIcon character3EnteredImage = new ImageIcon(Main.class.getResource("../images/character3Entered.png"));
	
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon loadButtonBasicImage = new ImageIcon(Main.class.getResource("../images/loadButtonBasic.png"));
	private ImageIcon title_exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/title_exitButtonBasic.png"));
	private ImageIcon ReturnButtonBasicImage = new ImageIcon(Main.class.getResource("../images/ReturnButtonBasic.png"));
	private ImageIcon aboutButtonBasicImage = new ImageIcon(Main.class.getResource("../images/aboutButtonBasic.png"));
	private ImageIcon menuBarExitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/menuBarExitButtonBasic.png"));
	
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon loadButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/loadButtonEntered.png"));
	private ImageIcon title_exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/title_exitButtonEntered.png"));
	private ImageIcon aboutButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/aboutButtonEntered.png"));
	private ImageIcon ReturnButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/ReturnButtonEntered.png"));
	private ImageIcon menuBarExitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/menuBarExitButtonEntered.png"));

	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton loadButton = new JButton(loadButtonBasicImage);
	private JButton title_exitButton = new JButton(title_exitButtonBasicImage);
	private JButton aboutButton = new JButton(aboutButtonBasicImage);
	private JButton menuBarExitButton = new JButton(menuBarExitButtonBasicImage);
	private JButton ReturnButton = new JButton(ReturnButtonBasicImage);
	private JButton character1Button = new JButton(character1BasicImage);
	private JButton character2Button = new JButton(character2BasicImage);
	private JButton character3Button = new JButton(character3BasicImage);
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	public int mouseX, mouseY;

	private boolean isMainScreen = false; // Main 화면으로 이동하면 true값을 갖게 할 예정
	private boolean isGameScreen = false; // 캐릭터 선택을 마친 뒤 Game 화면으로 이동하면 true값을 갖게 할 예정
	private int CharacterNumber;
	public Game() {
		setUndecorated(true);
		setTitle("SooRPG");
		setSize(Main.SCREEN_WIDTH, Main.SECREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		menuBarExitButton.setBounds(1245,1,35,35);
		menuBarExitButton.setBorderPainted(false);
		menuBarExitButton.setContentAreaFilled(false);
		menuBarExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBarExitButton.setIcon(menuBarExitButtonEnteredImage);
				menuBarExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuBarExitButton.setIcon(menuBarExitButtonBasicImage);
				menuBarExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				try {
					Thread.sleep(200);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(menuBarExitButton);
		
		ReturnButton.setBounds(490,540,300,100);
		ReturnButton.setBorderPainted(false);
		ReturnButton.setContentAreaFilled(false);
		ReturnButton.setVisible(false);
		ReturnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ReturnButton.setIcon(ReturnButtonEnteredImage);
				ReturnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ReturnButton.setIcon(ReturnButtonBasicImage);
				ReturnButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				startButton.setVisible(true);
				loadButton.setVisible(true);
				title_exitButton.setVisible(true);
				aboutButton.setVisible(true);
				ReturnButton.setVisible(false);
				character1Button.setVisible(false);
				character2Button.setVisible(false);
				character3Button.setVisible(false);
				if(isMainScreen) {
					isMainScreen = false;
					ReturnButton.setBounds(490,540,300,100);
				}
				BackgroundImage = new ImageIcon(Main.class.getResource("../images/titleImage(GOLD).png")).getImage();
			}
		});
		add(ReturnButton);
		
		startButton.setBounds(20, 250, 300, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				startButton.setVisible(false);
				loadButton.setVisible(false);
				title_exitButton.setVisible(false);
				aboutButton.setVisible(false);
				
				BackgroundImage = new ImageIcon(Main.class.getResource("../images/startBackground.jpg")).getImage();
				isMainScreen = true;
				ReturnButton.setBounds(490,540,300,170);
				ReturnButton.setVisible(true);
				character1Button.setVisible(true);
				character2Button.setVisible(true);
				character3Button.setVisible(true);
			}
		});
		add(startButton);
		
		
		
		loadButton.setBounds(20, 360, 300, 100);
		loadButton.setBorderPainted(false);
		loadButton.setContentAreaFilled(false);
		loadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loadButton.setIcon(loadButtonEnteredImage);
				loadButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loadButton.setIcon(loadButtonBasicImage);
				loadButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				startButton.setVisible(false);
				loadButton.setVisible(false);
				title_exitButton.setVisible(false);
				aboutButton.setVisible(false);
				ReturnButton.setVisible(true);
				
				BackgroundImage = new ImageIcon(Main.class.getResource("../images/loadBackground.png")).getImage();
			}
		});
		add(loadButton);
		
		title_exitButton.setBounds(20, 470, 300, 100);
		title_exitButton.setBorderPainted(false);
		title_exitButton.setContentAreaFilled(false);
		title_exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				title_exitButton.setIcon(title_exitButtonEnteredImage);
				title_exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				title_exitButton.setIcon(title_exitButtonBasicImage);
				title_exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				try {
					Thread.sleep(200);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(title_exitButton);
		
		aboutButton.setBounds(20, 580, 300, 100);
		aboutButton.setBorderPainted(false);
		aboutButton.setContentAreaFilled(false);
		aboutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				aboutButton.setIcon(aboutButtonEnteredImage);
				aboutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutButton.setIcon(aboutButtonBasicImage);
				aboutButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				startButton.setVisible(false);
				loadButton.setVisible(false);
				title_exitButton.setVisible(false);
				aboutButton.setVisible(false);
				ReturnButton.setVisible(true);
				BackgroundImage = new ImageIcon(Main.class.getResource("../images/aboutBackground.png")).getImage();
				
			}
		});
		add(aboutButton);
		
		character1Button.setBounds(35, 35, 380, 500);
		character1Button.setBorderPainted(false);
		character1Button.setContentAreaFilled(false);
		character1Button.setVisible(false);
		character1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				character1Button.setIcon(character1EnteredImage);
				character1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				character1Button.setIcon(character1BasicImage);
				character1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				isGameScreen = true;
				isMainScreen = false;
				character1Button.setVisible(false);
				character2Button.setVisible(false);
				character3Button.setVisible(false);
				ReturnButton.setVisible(false);
				CharacterNumber = 1;
			}
		});
		add(character1Button);
		
		character2Button.setBounds(450, 35, 380, 500);
		character2Button.setBorderPainted(false);
		character2Button.setContentAreaFilled(false);
		character2Button.setVisible(false);
		character2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				character2Button.setIcon(character2EnteredImage);
				character2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				character2Button.setIcon(character2BasicImage);
				character2Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				isGameScreen = true;
				isMainScreen = false;
				character1Button.setVisible(false);
				character2Button.setVisible(false);
				character3Button.setVisible(false);
				ReturnButton.setVisible(false);
				CharacterNumber = 2;
			}
		});
		add(character2Button);
		
		character3Button.setBounds(865, 35, 380, 500);
		character3Button.setBorderPainted(false);
		character3Button.setContentAreaFilled(false);
		character3Button.setVisible(false);
		character3Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				character3Button.setIcon(character3EnteredImage);
				character3Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				character3Button.setIcon(character3BasicImage);
				character3Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonEffectSound = new Music("ButtonEffectSound.mp3", false);
				ButtonEffectSound.start();
				isGameScreen = true;
				isMainScreen = false;
				character1Button.setVisible(false);
				character2Button.setVisible(false);
				character3Button.setVisible(false);
				ReturnButton.setVisible(false);
				CharacterNumber = 3;
			}
		});
		add(character3Button);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX(); //클릭 된 곳의 X 좌표
				mouseY = e.getY();
			}
			
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen(); // 화면 위의 순간순간 x 좌표
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar);
		
		Music titleBackgroundMusic = new Music("Happy Victorious Game Music - HeatleyBros.mp3", true);
		titleBackgroundMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SECREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(BackgroundImage, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}
