/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JDijalog implements ActionListener {
	JFrame okvir;
	
	public JDijalog()   {
		okvir=new JFrame("Okvir.");
		okvir.setSize(350,300);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setVisible(true);

		JPanel panel = new JPanel();
		okvir.add(panel);
		
		JButton b1 = new JButton("Klikni");
		b1.addActionListener((ActionListener) this);
		panel.add(b1);
	}
	
	public static void main (String[] args) {
		new JDijalog();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JDialog d = new JDialog(okvir, "JDijalog");
		d.setSize(200,200);
		d.setVisible(true);
		
		d.add(new JLabel("Ovo je JDijalog"));
	}
}
*/