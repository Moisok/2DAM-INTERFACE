//Tea APP for Moises Sepulveda Segarra

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//


public class TeaAppV2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeaAppV2 window = new TeaAppV2();
					window.frame.setVisible(true);
					window.frame.setTitle("TeaTimerApp :) By Moises Sepulveda");
					window.frame.setResizable(false);
					String start = "start.wav";
					ReproducirSonido(start);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeaAppV2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        
		ButtonGroup teaType = new ButtonGroup();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 471, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setAutoscrolls(false);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(153, 44, 209, 42);
		frame.getContentPane().add(textPane);
		textPane.setText("TeaApp By Moi :) ");
		textPane.setFont(new Font("UnDotum", Font.BOLD, 25));
		textPane.setForeground(Color.blue);
		
		
		Button button = new Button("Start!");
		button.setForeground(Color.CYAN);
		button.setBounds(139, 113, 238, 51);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JRadioButton rdbtnRedTea = new JRadioButton("Red Tea");
		rdbtnRedTea.setBorderPainted(true);
		rdbtnRedTea.setBackground(Color.GRAY);
		rdbtnRedTea.setBounds(21, 90, 97, 67);
		frame.getContentPane().add(rdbtnRedTea);
		//rdbtnRedTea.setOpaque(false);
		rdbtnRedTea.setForeground(Color.red);
		rdbtnRedTea.setFont(new Font("Roboto", Font.BOLD, 13));
		teaType.add(rdbtnRedTea);
		
		JRadioButton rdbtnBlackTea = new JRadioButton("Black Tea");
		rdbtnBlackTea.setBorderPainted(true);
		rdbtnBlackTea.setBackground(Color.GRAY);
		rdbtnBlackTea.setBounds(21, 161, 97, 67);
		frame.getContentPane().add(rdbtnBlackTea);
		//rdbtnBlackTea.setOpaque(false);
		rdbtnBlackTea.setForeground(Color.black);
		rdbtnBlackTea.setFont(new Font("Roboto", Font.BOLD, 13));
		
		teaType.add(rdbtnBlackTea);
		JRadioButton rdbtnGreenTea = new JRadioButton("Green Tea");
		rdbtnGreenTea.setBorderPainted(true);
		rdbtnGreenTea.setBackground(Color.GRAY);
		rdbtnGreenTea.setBounds(21, 19, 97, 67);
		frame.getContentPane().add(rdbtnGreenTea);
		//rdbtnGreenTea.setOpaque(false);
		rdbtnGreenTea.setForeground(Color.green);
		rdbtnGreenTea.setFont(new Font("Roboto", Font.BOLD, 13));
		teaType.add(rdbtnGreenTea);
		
		//Boton
		JButton btnCostumizate = new JButton("Costumizate");
		btnCostumizate.setBounds(12, 232, 124, 27);
		frame.getContentPane().add(btnCostumizate);
		
		FuncionCalcula (rdbtnRedTea,rdbtnGreenTea,rdbtnBlackTea, textPane, button, 0);
		Botonper(textPane, button, rdbtnRedTea, rdbtnBlackTea, rdbtnGreenTea, btnCostumizate);
	}

	//Boton personalizado
	private void Botonper(JTextPane textPane, Button button, JRadioButton rdbtnRedTea, JRadioButton rdbtnBlackTea,
	JRadioButton rdbtnGreenTea, JButton btnCostumizate) {
		btnCostumizate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String jFrame = "Put time";
			String getMessage = JOptionPane.showInputDialog(jFrame);
			int seconds2 = Integer.parseInt(getMessage);
			int seconds3 = seconds2;
			JOptionPane.showInputDialog(jFrame, "You put: "+ seconds3 + " seconds");
			FuncionCalcula (rdbtnRedTea,rdbtnGreenTea,rdbtnBlackTea, textPane, button, seconds3);
				}
			});
	}
		
	//Funcion calcula
	//Pasamos a la funcion los datos 
	private void FuncionCalcula (JRadioButton rdbtnRedTea, JRadioButton rdbtnGreenTea, 
	JRadioButton rdbtnblackTea, JTextPane time, Button Star, int seconds2){ 
	Star.addActionListener (new ActionListener(){
		//Variable
		int seconds3 = seconds2;
		int seconds;
		int minutes = 0;
		String sound = "second.wav";
		
		//Timer
		Timer timer1 = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	seconds = seconds - 1;
            	seconds3 = seconds3 -1;
            	ReproducirSonido(sound);
            		if (seconds > 10) {
            			time.setText("0" + minutes + ":" + seconds);
            		}
            		if (seconds < 10) {
            			time.setText("0" + minutes + ":0" + seconds);
            		}
            		if (seconds == 0) {
            			seconds = 60;
            			minutes = minutes - 1;
                   	}
            		if (seconds3 > 0 ||  !rdbtnblackTea.isSelected() || !rdbtnblackTea.isSelected() || !rdbtnGreenTea.isSelected()) {
            			time.setText (seconds3 + " ");
            		}
            		if (minutes < 0 || seconds3 <= 0) {
            			timer1.stop();
            			String ready = "ready.wav";
						ReproducirSonido(ready);
            			time.setText("Tea ready!");
            		}
            		
            }
        });
		
		//Boton Start!
		public void actionPerformed (ActionEvent e) {
			if (rdbtnRedTea.isSelected()) {	
				minutes = 0;
				seconds = 60;
				timer1.start();
        	}
			
			if (rdbtnblackTea.isSelected()) {	
				minutes = 4;
				seconds = 60;
				timer1.start();
        	}
			
			if (rdbtnGreenTea.isSelected()) {	
				minutes = 3;
				seconds = 60;
				timer1.start();
        	}
			else {
				timer1.start();
			}
		}
		
	});
	
	
	

	}
	
	//Metodo para reproducir sonidos
		public static void ReproducirSonido(String ready){
		       try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ready).getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
		         System.out.println("Error al reproducir el sonido.");
		       }
		     }
}