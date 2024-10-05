package lottery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BetGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 20;
	public static final int MAX_VALUE_LUCKY = 10;
	public static final int MAX_BET = 1000000;

	private JLabel labelChoose;
	private JLabel labelBet;
	private JLabel labelWelcome;
	private JLabel sign;

	private JTextField n1;
	private JTextField n2;
	private JTextField n3;
	private JTextField n4;
	private JTextField luckynb;
	private JTextField betNb;

	private JButton submitButton;
	private JButton submitSuperBet;
	private JRadioButton rb;

	private int nb1;
	private int nb2;
	private int nb3;
	private int nb4;
	private int bet;
	private int luck;
	private Tolo t;

	public BetGUI() {
		// frame

		setTitle("Tolo bet interface");
		setSize(450, 350);
		
		setLocation(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setBackground(Color.LIGHT_GRAY); // Set the background color here

//		getContentPane().setBackground(new Color(173, 216, 230)); // Light Blue
//        getContentPane().setBackground(new Color(120, 122, 148)); // Dark Blue
//        getContentPane().setBackground(new Color(117, 162, 209)); // Dark Blue

		labelWelcome = new JLabel("Welcome to the Tolo bet interface");

		labelChoose = new JLabel("Choose a number :");
		n1 = new JTextField(2);
		n2 = new JTextField(2);
		n3 = new JTextField(2);
		n4 = new JTextField(2);

		labelBet = new JLabel("Bet :  ");
		betNb = new JTextField(5);
		sign = new JLabel("$");

		rb = new JRadioButton("Wanna go lucky ?  ");
		luckynb = new JTextField(2);

		submitButton = new JButton("Draw numbers ");
		submitSuperBet = new JButton("SuperBet");

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String userInput = n1.getText()+n2.getText()+ n3.getText() +n4.getText();
				// System.out.println("is it empty : " + n1.getText().trim().isEmpty());
				try {

					nb1 = Integer.parseInt(n1.getText());
					nb2 = Integer.parseInt(n2.getText());
					nb3 = Integer.parseInt(n3.getText());
					nb4 = Integer.parseInt(n4.getText());
					bet = Integer.parseInt(betNb.getText());

					if (n1.getText().length() >= 1 && n1.getText().length() <= 2 && n2.getText().length() >= 1
							&& n2.getText().length() <= 2 && n3.getText().length() >= 1 && n3.getText().length() <= 2
							&& n4.getText().length() >= 1 && n4.getText().length() <= 2) {
						if (nb1 >= MIN_VALUE && nb1 <= MAX_VALUE && nb2 >= MIN_VALUE && nb2 <= MAX_VALUE
								&& nb3 >= MIN_VALUE && nb3 <= MAX_VALUE && nb4 >= MIN_VALUE && nb4 <= MAX_VALUE) {
							if (nb1 != nb2 && nb1 != nb3 && nb1 != nb4 && nb2 != nb3 && nb2 != nb4 && nb3 != nb4) {
								if (bet <= MAX_BET && bet > 0) {
									t = new Tolo();
									t.getBet().setBetMoney(bet);
									t.createBet(nb1, nb2, nb3, nb4, bet);
									ResultGUI resultGUI = new ResultGUI(t, t.getBet().computeGain(t));
									resultGUI.setVisible(true);

									setVisible(false);
								} else {
									JOptionPane.showMessageDialog(null, "Bet range[1,1000000] ");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Numbers chosen must be different ");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Numbers chosen must be between this range [1,20]");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Number of 2 digits expected.");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Some fields are empty or incorrect format of the input. ");
				}
			}
		});
		rb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rb.isSelected()) {
					add(luckynb);
					luckynb.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
					luckynb.setVisible(true);
					luckynb.setBounds(230, 150, 30, 30);
					submitButton.setVisible(false);
					add(submitSuperBet);
					submitSuperBet.setVisible(true);
					submitSuperBet.setBounds(160, 240, 100, 30);
				} else {
					luckynb.setVisible(false);
					submitSuperBet.setVisible(false);
					submitButton.setVisible(true);
				}
			}

		});

		submitSuperBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("is it empty" + n1.getText().trim().isEmpty());
				try {

					nb1 = Integer.parseInt(n1.getText());
					nb2 = Integer.parseInt(n2.getText());
					nb3 = Integer.parseInt(n3.getText());
					nb4 = Integer.parseInt(n4.getText());
					luck = Integer.parseInt(luckynb.getText());
					bet = Integer.parseInt(betNb.getText());

					if (n1.getText().length() >= 1 && n1.getText().length() <= 2 && n2.getText().length() >= 1
							&& n2.getText().length() <= 2 && n3.getText().length() >= 1 && n3.getText().length() <= 2
							&& n4.getText().length() >= 1 && n4.getText().length() <= 2
							&& luckynb.getText().length() >= 1 && luckynb.getText().length() <= 2) {
						if (nb1 >= MIN_VALUE && nb1 <= MAX_VALUE && nb2 >= MIN_VALUE && nb2 <= MAX_VALUE
								&& nb3 >= MIN_VALUE && nb3 <= MAX_VALUE && nb4 >= MIN_VALUE && nb4 <= MAX_VALUE
								&& luck >= MIN_VALUE && luck <= MAX_VALUE_LUCKY) {
							if (nb1 != nb2 && nb1 != nb3 && nb1 != nb4 && nb2 != nb3 && nb2 != nb4 && nb3 != nb4) {
								if (bet <= MAX_BET && bet > 0) {
									t = new Tolo();
									t.getSuperBet().setBetMoney(bet);
									t.createBet(nb1, nb2, nb3, nb4, luck, bet);

									System.out.println(
											"-------------------------------------------------------------------------------");
									ResultGUI resultGUI = new ResultGUI(t, t.getSuperBet().computeGain(t),
											t.getSuperBet().getLuckyNb());
									resultGUI.setVisible(true);
									setVisible(false);
								} else {
									JOptionPane.showMessageDialog(null, "Bet range[1,1000000] ");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Numbers chosen must be different ");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Chosen numbers[1,20] ; Lucky number[1,10]");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Number of 2 digits expected. ");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Some fields are empty or incorrect format of the input. ");
				}
			}
		});

		getContentPane().setLayout(null);
		setResizable(false);

		labelWelcome.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 20));
		labelChoose.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		labelBet.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		rb.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		sign.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));

		labelWelcome.setBounds(55, 20, 400, 30);
		labelChoose.setBounds(40, 80, 400, 30);
		n1.setBounds(50, 110, 30, 30);
		n2.setBounds(90, 110, 30, 30);
		n3.setBounds(130, 110, 30, 30);
		n4.setBounds(170, 110, 30, 30);
		rb.setBounds(30, 150, 200, 30);
		labelBet.setBounds(40, 200, 300, 30);
		betNb.setBounds(90, 200, 80, 30);
		sign.setBounds(185, 200, 80, 30);
		submitButton.setBounds(140, 240, 150, 30);

//        labelWelcome.setForeground(Color.white);
//        labelChoose.setForeground(Color.white);
//        labelBet.setForeground(Color.white);

		add(labelWelcome);
		add(labelChoose);
		add(n1);
		add(n2);
		add(n3);
		add(n4);
		add(rb);
		// add(luckynb);
		add(labelBet);
		add(betNb);
		add(sign);
		add(submitButton);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BetGUI().setVisible(true);
			}
		});
	}
}
