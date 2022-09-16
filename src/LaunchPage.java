import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

//import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class LaunchPage implements ActionListener{
	
	JFrame okvir = new JFrame();
	
	JLabel labela = new JLabel("Izaberite jednu od tri igre kako biste poceli sa igrom:");
	JLabel labela1 = new JLabel("Uvek koristitie velika slova u odgovorima!");
	
	JButton dugme1 = new JButton("Asocijacije");
	JButton dugme2 = new JButton("Ko zna zna");
	JButton dugme4 = new JButton("Ponudjeno");
	//JButton potvrda = new JButton("Da"); 

	LaunchPage(){
			
		labela.setBounds(120,60,800,40);
		labela.setFont(new Font(null, Font.PLAIN, 25));
		
		labela1.setBounds(120,100,800,40);
		labela1.setFont(new Font(null, Font.PLAIN, 20));
		
		dugme1.setBounds(100,160,200,40);
		dugme1.setFocusable(false);
		dugme1.addActionListener(this);
		
		dugme2.setBounds(320,160,200,40);
		dugme2.setFocusable(false);
		dugme2.addActionListener(this);
		
		dugme4.setBounds(540,160,200,40);
		dugme4.setFocusable(false);
		dugme4.addActionListener(this);
		
		
		
		okvir.add(dugme1);
		okvir.add(dugme2);
		okvir.add(dugme4);
		
		okvir.setTitle("Slagalica");
		okvir.add(labela);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setSize(900,400);
		okvir.setResizable(false);
		okvir.setLayout(null);
		okvir.setVisible(true);
		
	

/*	abstract class JDijalog implements ActionListener {
		JFrame okvir;
		
		public JDijalog()   {
			okvir=new JFrame("Da li ste sigurni");
			okvir.setSize(350,300);
			okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			okvir.setVisible(true);

			JPanel panel = new JPanel();
			okvir.add(panel);
			
			
		}
		}
	
	*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	/*	JDialog d = new JDialog();
		d.setSize(200,200);
		d.setVisible(true);
		potvrda.setSize(50,50);
		*/
		if(e.getSource()==dugme1) {
			//okvir.dispose();
			//new JDialog();
			//d.add(potvrda);
			/*if (e.getSource()== potvrda ) {*/
				AsocijacijeWindow Asocijacije = new AsocijacijeWindow();
		}
			
		

			
		if(e.getSource()==dugme2) {
			//okvir.dispose();
			KoZnaZnaWindow KoZnaZna = new KoZnaZnaWindow();		
		}
		
		if (e.getSource()==dugme4) {
			//okvir.dispose();
			PonudjenoWindow Ponudjeno = new PonudjenoWindow();		
		}	
	}

 class PonudjenoWindow implements ActionListener{

	String[] pitanja = {
						"Koji je glavni grad Togoa?",
						"Nije šija nego...",
						"Koliko milja ispod mora je Zeljko Samardzic?"
					   };
	String[][] opcije = {
							{"Benin","Lome", "Njujork", "Kabudza"},
							{"vrat", "konj", "šupa", "teta lija"},
							{"10", "8", "9", "7 i po"}
						};
	char[] odgovori =   {
						'B',
						'A',
						'C',
						};
	
	char pokusaj;
	char odgovor;
	int indeks;
	int tacan_pokusaj=0;
	int ukupno_pitanja = pitanja.length;
	int rezultat;
	int sekunde=8;

	JFrame okvir = new JFrame();
	JTextField tekst = new JTextField();
	JTextArea tekstoblast = new JTextArea();
	JButton dugmeA = new JButton();
	JButton dugmeB = new JButton();
	JButton dugmeC = new JButton();
	JButton dugmeD = new JButton();
	JLabel odgovor_labelaA = new JLabel();
	JLabel odgovor_labelaB = new JLabel();
	JLabel odgovor_labelaC = new JLabel();
	JLabel odgovor_labelaD = new JLabel();
	JTextField broj_tacnih = new JTextField();
	
	
	public PonudjenoWindow() {
		
		okvir.setSize(700,700);
		okvir.getContentPane().setBackground(new Color(120,20,60));
		okvir.setLayout(null);
		okvir.setResizable(false);
		
		tekst.setBounds(20,20,650,50);
		tekst.setBackground(new Color(100,20,60));
		tekst.setForeground(Color.white);
		tekst.setFont(new Font("Cambria", Font.PLAIN, 30));
		tekst.setBorder(BorderFactory.createBevelBorder(1));
		tekst.setHorizontalAlignment(JTextField.CENTER);
		tekst.setEditable(false);
		
		tekstoblast.setBounds(20,70,650,50);
		tekstoblast.setLineWrap(true);
		tekstoblast.setWrapStyleWord(true);
		tekstoblast.setBackground(new Color(100,20,60));
		tekstoblast.setForeground(Color.white);
		tekstoblast.setFont(new Font("Cambria", Font.PLAIN, 25));
		tekstoblast.setBorder(BorderFactory.createBevelBorder(1));
		tekstoblast.setEditable(false);
		tekstoblast.setText(null);
		
		dugmeA.setBounds(0,150,100,100);
		dugmeA.setFont(new Font("Cambria", Font.PLAIN, 35));
		dugmeA.setFocusable(false);
		dugmeA.addActionListener(this);
		dugmeA.setText("A");
		
		dugmeB.setBounds(0,260,100,100);
		dugmeB.setFont(new Font("Cambria", Font.PLAIN, 35));
		dugmeB.setFocusable(false);
		dugmeB.addActionListener(this);
		dugmeB.setText("B");
		
		dugmeC.setBounds(0,370,100,100);
		dugmeC.setFont(new Font("Cambria", Font.PLAIN, 35));
		dugmeC.setFocusable(false);
		dugmeC.addActionListener(this);
		dugmeC.setText("C");
		
		dugmeD.setBounds(0,480,100,100);
		dugmeD.setFont(new Font("Cambria", Font.PLAIN, 35));
		dugmeD.setFocusable(false);
		dugmeD.addActionListener(this);
		dugmeD.setText("D");
		
		odgovor_labelaA.setBounds(125,150,500,100);
		odgovor_labelaA.setBackground(new Color(100,20,60));
		odgovor_labelaA.setForeground(Color.white);
		odgovor_labelaA.setFont(new Font("Cambria", Font.PLAIN,35));
		
		odgovor_labelaB.setBounds(125,260,500,100);
		odgovor_labelaB.setBackground(new Color(100,20,60));
		odgovor_labelaB.setForeground(Color.white);
		odgovor_labelaB.setFont(new Font("Cambria", Font.PLAIN,35));
	
		odgovor_labelaC.setBounds(125,370,500,100);
		odgovor_labelaC.setBackground(new Color(100,20,60));
		odgovor_labelaC.setForeground(Color.white);
		odgovor_labelaC.setFont(new Font("Cambria", Font.PLAIN,35));
		
		odgovor_labelaD.setBounds(125,480,500,100);
		odgovor_labelaD.setBackground(new Color(100,20,60));
		odgovor_labelaD.setForeground(Color.white);
		odgovor_labelaD.setFont(new Font("Cambria", Font.PLAIN,35));

		
		broj_tacnih.setBounds(225,225,200,100);
		broj_tacnih.setBackground(new Color(150, 50, 50));
		broj_tacnih.setForeground(Color.green);
		broj_tacnih.setFont(new Font("Cambria", Font.BOLD,60));
		broj_tacnih.setBorder(BorderFactory.createBevelBorder(1));
		broj_tacnih.setHorizontalAlignment(JTextField.CENTER);
		broj_tacnih.setEditable(false);
		
		/*
		okvir.add(broj_tacnih);
		okvir.add(sekunde_labela);
		*/
		okvir.add(odgovor_labelaA);
		okvir.add(odgovor_labelaB);
		okvir.add(odgovor_labelaC);
		okvir.add(odgovor_labelaD);
		okvir.add(dugmeA);
		okvir.add(dugmeB);
		okvir.add(dugmeC);
		okvir.add(dugmeD);
		okvir.add(tekstoblast);
		okvir.add(tekst);
		okvir.setVisible(true);
		
		sledecePonudjeno();
		
	}
	
	public void sledecePonudjeno() {
		
		if(indeks>=ukupno_pitanja) {
			rezultat();	
		}
		
		else {
			tekst.setText("Pitanje" + (indeks+1));
			tekstoblast.setText(pitanja[indeks]);
			odgovor_labelaA.setText(opcije[indeks][0]);
			odgovor_labelaB.setText(opcije[indeks][1]);
			odgovor_labelaC.setText(opcije[indeks][2]);
			odgovor_labelaD.setText(opcije[indeks][3]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		dugmeA.setEnabled(false);
		dugmeB.setEnabled(false);
		dugmeC.setEnabled(false);
		dugmeD.setEnabled(false);
		
		if (e.getSource()==dugmeA) {
			odgovor = 'A';
			if (odgovor == odgovori [indeks]) {
				tacan_pokusaj++;
			}
		}
		
		if (e.getSource()==dugmeB) {
			odgovor = 'B';
			if (odgovor == odgovori [indeks]) {
				tacan_pokusaj++;
			}
		}
		
		if (e.getSource()==dugmeC) {
			odgovor = 'C';
			if (odgovor == odgovori [indeks]) {
				tacan_pokusaj++;
			}
		}
		
		if (e.getSource()==dugmeD) {
			odgovor = 'D';
			if (odgovor == odgovori [indeks]) {
				tacan_pokusaj++;
			}
		}
		
		prikaziOdgovor();
	}
	
	public void prikaziOdgovor() {
		
		dugmeA.setEnabled(false);
		dugmeB.setEnabled(false);
		dugmeC.setEnabled(false);
		dugmeD.setEnabled(false);
		
		if (odgovori[indeks] != 'A')
			odgovor_labelaA.setForeground(Color.red);
		if (odgovori[indeks] != 'B')
			odgovor_labelaB.setForeground(Color.red);
		if (odgovori[indeks] != 'C')
			odgovor_labelaC.setForeground(Color.red);
		if (odgovori[indeks] != 'D')
			odgovor_labelaD.setForeground(Color.red);

		Timer pause = new Timer(2000, new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e){
				
				odgovor_labelaA.setForeground(Color.white);
				odgovor_labelaB.setForeground(Color.white);
				odgovor_labelaC.setForeground(Color.white);
				odgovor_labelaD.setForeground(Color.white);
				
				odgovor = ' ';
				sekunde = 8;
				
				dugmeA.setEnabled(true);
				dugmeB.setEnabled(true);
				dugmeC.setEnabled(true);
				dugmeD.setEnabled(true);
				
				indeks++;
				sledecePonudjeno();
			}
		});
		
		pause.start();
		pause.setRepeats(false);
		
	}

	public void rezultat() {
		
		dugmeA.setEnabled(false);
		dugmeB.setEnabled(false);
		dugmeC.setEnabled(false);
		dugmeD.setEnabled(false);
	
		
		rezultat = tacan_pokusaj/ukupno_pitanja;
		
		tekst.setText("REZULTAT");
		tekstoblast.setText("");
		odgovor_labelaA.setText("");
		odgovor_labelaB.setText("");
		odgovor_labelaC.setText("");
		odgovor_labelaD.setText("");
		
		broj_tacnih.setText("("+tacan_pokusaj+"/"+ukupno_pitanja+")");
		
		okvir.add(broj_tacnih);

	}	
	}
 
 // Stavi automatska velika slova 
 // Skloni kucanje u rezyltatu
 //na mnogo mesto sam dodala toUpperCase
 
 class KoZnaZnaWindow implements ActionListener{

	String[] pitanja = {
						"Koja je gornja boja na zastavi Srbije?",
						"Koji je glavni grad Srbije?",
						"Koliko tockova ima prosecan automobil?",
						"Drzava koja se geograrfski nalazi unutar Juznoaficke republike na slovo L je:"
					   };
	String[] opcije = {
							"CRVENA",
							"BEOGRAD",
							"4",
							"LESOTO"
						};
	
	char pokusaj;
	char odgovor;
	int indeks;
	int tacan_pokusaj=0;
	int ukupno_pitanja = pitanja.length;
	int rezultat;

	ImageIcon ikonica = new ImageIcon("ikonica.png");
	JFrame okvir = new JFrame();
	JTextField tekst = new JTextField();
	JTextField tekstodgovor = new JTextField();
	JTextArea tekstoblast = new JTextArea();
	JButton dugmeX = new JButton();
	JTextField broj_tacnih = new JTextField();
	
	String name = tekstodgovor.getText();
	
	
	public KoZnaZnaWindow() {
		
		okvir.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		okvir.setSize(700,700);
		okvir.getContentPane().setBackground(new Color(120,20,60));
		okvir.setLayout(null);
		okvir.setResizable(false);
		
		tekst.setBounds(20,20,650,50);
		tekst.setBackground(new Color(100,20,60));
		tekst.setForeground(Color.white);
		tekst.setFont(new Font("Cambria", Font.PLAIN, 30));
		tekst.setBorder(BorderFactory.createBevelBorder(1));
		tekst.setHorizontalAlignment(JTextField.CENTER);
		tekst.setEditable(false);
		
		tekstodgovor.setBounds(20,200,650,50);
		tekstodgovor.setBackground(new Color(100,20,60));
		tekstodgovor.setForeground(Color.white);
		tekstodgovor.setFont(new Font("Cambria", Font.PLAIN, 30));
		tekstodgovor.setBorder(BorderFactory.createBevelBorder(1));
		tekstodgovor.setHorizontalAlignment(JTextField.CENTER);
		tekstodgovor.setEditable(true);
		tekstodgovor.setText(name.toUpperCase());
		
		tekstoblast.setBounds(20,70,650,80);
		tekstoblast.setLineWrap(true);
		tekstoblast.setWrapStyleWord(true);
		tekstoblast.setBackground(new Color(100,20,60));
		tekstoblast.setForeground(Color.white);
		tekstoblast.setFont(new Font("Cambria", Font.PLAIN, 25));
		tekstoblast.setBorder(BorderFactory.createBevelBorder(1));
		tekstoblast.setEditable(false);
		//tekstoblast.setText(null);
		
		dugmeX.setEnabled(true);
		dugmeX.setBounds(400,480,100,100);
		//dugmeX.setFont(new Font("Cambria", Font.PLAIN, 35));
		dugmeX.setFocusable(false);
		dugmeX.addActionListener(this);
		dugmeX.setIcon(ikonica);
		
		
		broj_tacnih.setBounds(225,250,200,100);
		broj_tacnih.setBackground(new Color(150, 50, 50));
		broj_tacnih.setForeground(Color.green);
		broj_tacnih.setFont(new Font("Cambria", Font.BOLD,60));
		broj_tacnih.setBorder(BorderFactory.createBevelBorder(1));
		broj_tacnih.setHorizontalAlignment(JTextField.CENTER);
		broj_tacnih.setEditable(false);
		
		/*
		okvir.add(broj_tacnih);
		okvir.add(sekunde_labela);
		*/
		okvir.add(tekstoblast);
		okvir.add(tekstodgovor);
		okvir.add(tekst);
		okvir.add(dugmeX);

		okvir.setVisible(true);
		
		sledecePonudjeno();
		
	}
	

	public void sledecePonudjeno() {
		
		if(indeks>=ukupno_pitanja) {
			rezultat();	
		}
		
		else {
			tekst.setText("Pitanje" + (indeks+1));
			tekstoblast.setText(pitanja[indeks]);
			tekstodgovor.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		dugmeX.setEnabled(false);
		
		String name = tekstodgovor.getText();
		

		if (e.getSource()==dugmeX) {
			if(name.equals(opcije[indeks])){
				tacan_pokusaj++;
			}
		}
		
		prikaziOdgovor();
	}
	
	public void prikaziOdgovor() {
		
		dugmeX.setEnabled(false);

		//Ovo je samo da oboji tekst
		String name = tekstodgovor.getText();
		
		if (!name.equals(opcije[indeks]))
			tekstodgovor.setForeground(Color.red);
		else tekstodgovor.setForeground(Color.green);
		

		Timer pause = new Timer(2000, new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				tekstodgovor.setForeground(Color.white);

				dugmeX.setEnabled(true);
				
				indeks++;
				sledecePonudjeno();
			}
		});
		
		pause.start();
		pause.setRepeats(false);
		
	}

	public void rezultat() {
		
		dugmeX.setEnabled(false);

		
		dugmeX.setEnabled(true);
		
		//rezultat = tacan_pokusaj/ukupno_pitanja;
		
		tekst.setText("REZULTAT");
		tekst.setEditable(false);
		
		tekstoblast.setText("");
		tekstoblast.setEditable(false);
		
		tekstodgovor.setText("");
		tekstoblast.setEditable(false);
		
		broj_tacnih.setText("("+tacan_pokusaj+"/"+ukupno_pitanja+")");
		
		okvir.add(broj_tacnih);
		okvir.add(dugmeX);
	}
 }
		

 //Dodaj automatska velika slova
 
class AsocijacijeWindow implements ActionListener {

	
	JFrame okvir = new JFrame();
	
	JTextField A = new JTextField("");
	JTextField B = new JTextField("");
	JTextField C = new JTextField("");
	JTextField D = new JTextField("");
	JTextField K = new JTextField("");
	
	JButton dugmeA1 = new JButton("A1");
	JButton dugmeA2 = new JButton("A2");
	JButton dugmeA3 = new JButton("A3");
	JButton dugmeA4 = new JButton("A4");
	
	JButton dugmeB1 = new JButton("B1");
	JButton dugmeB2 = new JButton("B2");
	JButton dugmeB3 = new JButton("B3");
	JButton dugmeB4 = new JButton("B4");
	
	JButton dugmeC1 = new JButton("C1");
	JButton dugmeC2 = new JButton("C2");
	JButton dugmeC3 = new JButton("C3");
	JButton dugmeC4 = new JButton("C4");
	
	JButton dugmeD1 = new JButton("D1");
	JButton dugmeD2 = new JButton("D2");
	JButton dugmeD3 = new JButton("D3");
	JButton dugmeD4 = new JButton("D4");
	
	JButton dugmeX = new JButton("X");
	JButton dugmeK = new JButton("Konacno");
	
	
	AsocijacijeWindow(){
	
		okvir.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		okvir.setSize(700,700);
		okvir.setBackground(new Color(120,20,60));
		okvir.setLayout(null);
		okvir.setResizable(false);
		okvir.setVisible(true);
		
		abstract class dugme extends Dugmad {
		}
		
		dugmeA1.setBounds(10,30,190,50);
		dugmeA1.addActionListener(this);
	
		dugmeA2.setBounds(50,85,190,50);
		dugmeA2.addActionListener(this);
		
		dugmeA3.setBounds(90,140,190,50);
		dugmeA3.addActionListener(this);
		
		dugmeA4.setBounds(130,195,190,50);
		dugmeA4.addActionListener(this);
		
		dugmeB1.setBounds(480,30,190,50);
		dugmeB1.addActionListener(this);
		
		dugmeB2.setBounds(440,85,190,50);
		dugmeB2.addActionListener(this);
		
		dugmeB3.setBounds(400,140,190,50);
		dugmeB3.addActionListener(this);
		
		dugmeB4.setBounds(360,195,190,50);
		dugmeB4.addActionListener(this);
		
		dugmeC1.setBounds(130,435,190,50);
		dugmeC1.addActionListener(this);
		
		dugmeC2.setBounds(90,490,190,50);
		dugmeC2.addActionListener(this);
	
		dugmeC3.setBounds(50,545,190,50);
		dugmeC3.addActionListener(this);
		
		dugmeC4.setBounds(10,600,190,50);
		dugmeC4.addActionListener(this);
		
		dugmeD1.setBounds(360,435,190,50);
		dugmeD1.addActionListener(this);
		
		dugmeD2.setBounds(400,490,190,50);
		dugmeD2.addActionListener(this);
		
		dugmeD3.setBounds(440,545,190,50);
		dugmeD3.addActionListener(this);
		
		dugmeD4.setBounds(480,600,190,50);
		dugmeD4.addActionListener(this);
		
		dugmeX.setBounds(10,315,100,50);
		dugmeX.addActionListener(this);
		
		A.setBounds(130,250,190,50);
		A.setFont(new Font("Cambria", Font.PLAIN, 30));
		A.setBorder(BorderFactory.createBevelBorder(1));
		A.setHorizontalAlignment(JTextField.CENTER);
		A.setEditable(true);
		
		B.setBounds(360,250,190,50);
		B.setFont(new Font("Cambria", Font.PLAIN, 30));
		B.setBorder(BorderFactory.createBevelBorder(1));
		B.setHorizontalAlignment(JTextField.CENTER);
		B.setEditable(true);
		
		C.setBounds(130,380,190,50);
		C.setFont(new Font("Cambria", Font.PLAIN, 30));
		C.setBorder(BorderFactory.createBevelBorder(1));
		C.setHorizontalAlignment(JTextField.CENTER);
		C.setEditable(true);

		D.setBounds(360,380,190,50);
		D.setFont(new Font("Cambria", Font.PLAIN, 30));
		D.setBorder(BorderFactory.createBevelBorder(1));
		D.setHorizontalAlignment(JTextField.CENTER);
		D.setEditable(true);
		
		K.setBounds(250,315,190,50);
		K.setFont(new Font("Cambria", Font.PLAIN, 30));
		K.setBorder(BorderFactory.createBevelBorder(1));
		K.setHorizontalAlignment(JTextField.CENTER);
		K.setEditable(true);

		okvir.add(dugmeA1);
		okvir.add(dugmeA2);
		okvir.add(dugmeA3);
		okvir.add(dugmeA4);
		okvir.add(dugmeB1);
		okvir.add(dugmeB2);
		okvir.add(dugmeB3);
		okvir.add(dugmeB4);
		okvir.add(dugmeC1);
		okvir.add(dugmeC2);
		okvir.add(dugmeC3);
		okvir.add(dugmeC4);
		okvir.add(dugmeD1);
		okvir.add(dugmeD2);
		okvir.add(dugmeD3);
		okvir.add(dugmeD4);
		okvir.add(dugmeK);	
		okvir.add(A);
		okvir.add(B);
		okvir.add(C);
		okvir.add(D);
		okvir.add(K);
		okvir.add(dugmeK);
		okvir.add(dugmeX);
	}
// Kad se stisne na kolonu, napravi da se skloni tekst koji je bio tu pre (ime kolone)
	//Automatski neka moze da se kuca
	//Kada se otvori konacno, da se sva polja u koloni otvore
	public void actionPerformed(ActionEvent e) {
		
		String nameA = A.getText();
		String nameB = B.getText();
		String nameC = C.getText();
		String nameD = D.getText();
		String nameK = K.getText();
		
//PODACI IZ KOLONE ***A***
		
		if(e.getSource()==dugmeA1) {
			dugmeA1.setText("FAKULTET");
	}
		if(e.getSource()==dugmeA2) {
			dugmeA2.setText("PLATON");
	}
		if(e.getSource()==dugmeA3) {
			dugmeA3.setText("KANT");
	}
		if(e.getSource()==dugmeA4) {
			dugmeA4.setText("GRCKA");
	}

		if(e.getSource()==dugmeX){
			if (nameA.equals("FILOZOF") || nameA.equals("filozof")){
				A.setText(nameA);
				A.setEditable(false);
				A.setForeground(Color.GREEN);
				dugmeA1.setEnabled(false);
				dugmeA2.setEnabled(false);
				dugmeA3.setEnabled(false);
				dugmeA4.setEnabled(false);
				
	}	
	}
			
//PODACI IZ KOLONE ***B***
		
		if(e.getSource()==dugmeB1) {
				dugmeB1.setText("SKUPSTINA");
		}
		if(e.getSource()==dugmeB2) {
				dugmeB2.setText("SPOLJNA");
		}
		if(e.getSource()==dugmeB3) {
				dugmeB3.setText("DRZAVNA");
		}
		if(e.getSource()==dugmeB4) {
				dugmeB4.setText("FAKULTET");
		}
			
		if(e.getSource()==dugmeX){
			if (nameB.equals("POLITIKA") || nameB.equals("politika") ){
					B.setText(nameB.toUpperCase());
					B.setText(nameB);
					B.setEditable(false);
					B.setForeground(Color.GREEN);	
					dugmeB1.setEnabled(false);
					dugmeB2.setEnabled(false);
					dugmeB3.setEnabled(false);
					dugmeB4.setEnabled(false);
		}	
		}

//PODACI IZ KOLONE ***C***
		
	if(e.getSource()==dugmeC1) {
		dugmeC1.setText("RADMILOVIC");
	}
	if(e.getSource()==dugmeC2) {
		dugmeC2.setText("KESIC");
	}
	if(e.getSource()==dugmeC3) {
		dugmeC3.setText("Z");
	}
	if(e.getSource()==dugmeC4) {
		dugmeC4.setText("MUSKO IME");
	}
	
	if(e.getSource()==dugmeX){
		if (nameC.equals("ZORAN") || nameC.equals("zoran") ){
			C.setText(nameC.toUpperCase());
			C.setText(nameC);
			C.setEditable(false);
			C.setForeground(Color.GREEN);
			dugmeC1.setEnabled(false);
			dugmeC2.setEnabled(false);
			dugmeC3.setEnabled(false);
			dugmeC4.setEnabled(false);
		}	
		}

//PODACI IZ KOLONE ***D***

	if(e.getSource()==dugmeD1) {
		dugmeD1.setText("NAPAD");
	}
	if(e.getSource()==dugmeD2) {
		dugmeD2.setText("FRANC FERDINAND");
	}
	if(e.getSource()==dugmeD3) {
		dugmeD3.setText("DZON LENON");
	}
	if(e.getSource()==dugmeD4) {
		dugmeD4.setText("LINKOLN");
	}
	
	if(e.getSource()==dugmeX){
	if (nameD.equals("ATENTAT") || nameD.equals("atentat") ){
			D.setText(nameD.toUpperCase());
			D.setText(nameD);
			D.setEditable(false);
			D.setForeground(Color.GREEN);
			dugmeD1.setEnabled(false);
			dugmeD2.setEnabled(false);
			dugmeD3.setEnabled(false);
			dugmeD4.setEnabled(false);
		
	}	
	}
	//PODACI IZ POLJA ***KONACNO***
	if(e.getSource()==dugmeX){
	if (nameK.equals("DJINDJIC") || nameK.equals("djindjic") ){
		    K.setText(nameK.toUpperCase());
			K.setText(nameK);
			K.setEditable(false);
			K.setForeground(Color.GREEN);
		}
		}
}




/*	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
*/
}

}