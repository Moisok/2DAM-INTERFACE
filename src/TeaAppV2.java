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
					//ReproducirSonido(start);
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
		frame.setBounds(100, 100, 259, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setAutoscrolls(false);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(130, 44, 104, 42);
		frame.getContentPane().add(textPane);
		textPane.setText("TeaApp By Moi :) ");
		textPane.setFont(new Font("UnDotum", Font.BOLD, 25));
		textPane.setForeground(Color.blue);
		
		
		Button button = new Button("Start!");
		button.setForeground(Color.CYAN);
		button.setBounds(0, 329, 118, 86);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JRadioButton rdbtnRedTea = new JRadioButton("Red Tea");
		rdbtnRedTea.setBorderPainted(true);
		rdbtnRedTea.setBackground(Color.GRAY);
		rdbtnRedTea.setBounds(0, 78, 118, 86);
		frame.getContentPane().add(rdbtnRedTea);
		//rdbtnRedTea.setOpaque(false);
		rdbtnRedTea.setForeground(Color.red);
		rdbtnRedTea.setFont(new Font("Roboto", Font.BOLD, 13));
		teaType.add(rdbtnRedTea);
		
		JRadioButton rdbtnBlackTea = new JRadioButton("Black Tea");
		rdbtnBlackTea.setBorderPainted(true);
		rdbtnBlackTea.setBackground(Color.GRAY);
		rdbtnBlackTea.setBounds(0, 163, 118, 86);
		frame.getContentPane().add(rdbtnBlackTea);
		//rdbtnBlackTea.setOpaque(false);
		rdbtnBlackTea.setForeground(Color.black);
		rdbtnBlackTea.setFont(new Font("Roboto", Font.BOLD, 13));
		
		teaType.add(rdbtnBlackTea);
		JRadioButton rdbtnGreenTea = new JRadioButton("Green Tea");
		rdbtnGreenTea.setBorderPainted(true);
		rdbtnGreenTea.setBackground(Color.GRAY);
		rdbtnGreenTea.setBounds(0, 0, 118, 86);
		frame.getContentPane().add(rdbtnGreenTea);
		//rdbtnGreenTea.setOpaque(false);
		rdbtnGreenTea.setForeground(Color.green);
		rdbtnGreenTea.setFont(new Font("Roboto", Font.BOLD, 13));
		teaType.add(rdbtnGreenTea);
		//Custom
		JRadioButton Custom = new JRadioButton("Custom Tea");
		Custom.setForeground(Color.ORANGE);
		Custom.setFont(new Font("Roboto", Font.BOLD, 13));
		Custom.setBorderPainted(true);
		Custom.setBackground(Color.GRAY);
		Custom.setBounds(0, 246, 118, 86);
		frame.getContentPane().add(Custom);
		teaType.add(Custom);
	}
		
		//Boton
		/*FuncionCalcula (rdbtnRedTea,rdbtnGreenTea,rdbtnBlackTea,Custom, textPane, button);
	}

	
		
	//Funcion calcula
	//Pasamos a la funcion los datos 
	private void FuncionCalcula (JRadioButton rdbtnRedTea, JRadioButton rdbtnGreenTea, 
	JRadioButton rdbtnblackTea, JRadioButton Custom, JTextPane time, Button Star){ 
	Star.addActionListener (new ActionListener(){
		//Timer
		//Variable
		String put;
		String getMinutes;
		int seconds;
		int minutes = 0;
		int minutesToInt;
		String sound = "second.wav";
		String ready = "ready.wav";
		//Timer
		Timer timer1 = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	seconds = seconds - 1;
            	ReproducirSonido(sound);
            	time.setText( minutes + ":" + seconds);
            	if (seconds == 0) {
            		seconds = 60;
            		minutes = minutes - 1;
            	}
            	if(minutes < 0) {
					timer1.stop();
					ReproducirSonido(ready);
					time.setText( "Finish");	
				}
            }
          
        });
		
		//Boton Start!
		public void actionPerformed (ActionEvent e) {
			if (rdbtnRedTea.isSelected()) {	
				seconds = 10;
				minutes = 0;
				timer1.start();
        	}
			
			if (rdbtnblackTea.isSelected()) {
				seconds = 60;
				minutes = 4;
				timer1.start();
        	}			
	
			if (rdbtnGreenTea.isSelected()) {
				seconds = 60;
				minutes = 1;
				timer1.start();
        	}
			if (Custom.isSelected()) {	
				seconds = 1;
				put = "Put minutes";
				getMinutes = JOptionPane.showInputDialog(put);
				minutesToInt = Integer.parseInt(getMinutes);
				minutes = minutesToInt;
				timer1.start();
        	}
			
		}
		
	});
}*/

	//Metodo para reproducir sonidos
		public static void ReproducirSonido(String x){
			try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(x).getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		       } catch(Exception e) { 
		         System.err.println("Error al reproducir el sonidito");
		       }
		     }

}