package vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JIFVisiteRecapitulatif extends JInternalFrame {
	
	
private static final long serialVersionUID = 1L;
	
	protected JPanel m;
	protected JPanel mButton;
	protected JPanel mTexte;
	
	protected JButton JBmodifier;
	
	protected JLabel JLreference;
	protected JLabel JLdateVisite;
	protected JLabel JLmatriculeVisiteur;
	protected JLabel JLcodeMedecin;
	protected JLabel JLcommentaire;
	protected JLabel JLdepotLegal;
	protected JLabel JLquantiteOfferte;
	
	//Medicament 1 et 2
	protected JLabel JLmedicament1;
	protected JLabel JLmedicament2;
	
	protected JTextField JTreference;
	protected JTextField JTdateVisite;
	protected JTextField JTmatriculeVisiteur;
	protected JTextField JTcodeMedecin;
	protected JTextField JTcommentaire;
	protected JTextField JTdepotLegal;
	protected JTextField JTquantiteOfferte;
	
	//Medicament 1et2
	protected JTextField JTmedicament1;
	protected JTextField JTmedicament2;
	
	
	protected JTable tableMajVisite;
	
	
	public JIFVisiteRecapitulatif(){
		
		
		
		m = new JPanel();
		mButton = new JPanel();
		mTexte = new JPanel(new GridLayout(9,2));
		
		
		JBmodifier = new JButton("Modifier");
		mButton.add(JBmodifier);		

		 JLreference = new JLabel("Reference");
		 JLdateVisite = new JLabel("Date de visite");
		 JLmatriculeVisiteur = new JLabel("Matricule visiteur");
	     JLcodeMedecin = new JLabel("Code medecin");
		 JLcommentaire = new JLabel("Commentaire");
		 JLdepotLegal = new JLabel("Dépôt legal");
		 JLquantiteOfferte = new JLabel("Quantité offerte");
		 //Medicament 1et2
		 JLmedicament1 = new JLabel("Médicament 1");
		 JLmedicament2 = new JLabel("Médicament 2");
		 
		 
		 JTreference = new JTextField(20);
	     JTdateVisite= new JTextField();
	     
	     JTmatriculeVisiteur = new JTextField();    
	     JTcodeMedecin = new JTextField();
	     JTcommentaire = new JTextField();
	     
	     JTdepotLegal = new JTextField(20);
	     JTquantiteOfferte = new JTextField(20);
	     //Medicament 1et2
	     JTmedicament1 = new JTextField();
	     JTmedicament2 = new JTextField();
		 
		 
/*
 * REF
 * DATE
 * MATRIUCLE
 * codemed
 * commentaire
 * */
	     
	     //Tablau
	     
	     //Déclaration du header du tableau
	     String[] columnNames = {"", "Dépot légal", "Quantité offerte"};
	     
	     Object[][] data = {
	    		 {"Médicament 1", JTdepotLegal, JTquantiteOfferte},
	    			 {"Médicament 2", JTdepotLegal, JTquantiteOfferte},
	};
	    
	     
	     tableMajVisite = new JTable(data, columnNames);
	     
	     tableMajVisite.setPreferredScrollableViewportSize(new Dimension(400,50));
	     tableMajVisite.setFillsViewportHeight(true);
	       
	     JScrollPane scrollPane = new JScrollPane(tableMajVisite);
	     
	        
	        mTexte.add(JLreference);
	        mTexte.add(JTreference);
	        mTexte.add(JLdateVisite);
	        mTexte.add(JTdateVisite);
	        mTexte.add(JLmatriculeVisiteur);
	        mTexte.add(JTmatriculeVisiteur);
	        mTexte.add(JLcodeMedecin);
	        mTexte.add(JTcodeMedecin);
	        mTexte.add(JLcommentaire);
	        mTexte.add(JTcommentaire);
	        
	              
	        //Mise en forme du texte
	        
	        m.add(mTexte);
	        m.add(scrollPane);
	        m.add(mButton);
	        
	        Container contentPane = getContentPane();
	        contentPane.add(m);
		
	}

}
