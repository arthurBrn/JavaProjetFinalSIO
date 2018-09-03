package vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modele.visite;
import modele.dao.visiteDao;

public class JIFListeVisite extends JInternalFrame implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		
		private HashMap <String,visite> diccoVisite;
		//private ArrayList<visite> lesVisites;
		protected JPanel l;
		protected JPanel lButton;
		protected JPanel lTexte;
		protected JPanel lTexte2;
		protected JPanel lSaisie;
		
		/*
		 * Button
		 * */
		protected JButton JBdisplay;
		
		//On initialise scrollpane qui permettera de scroller
		protected JScrollPane scrollPane;
		
		//On crée une table qui est l'équivalent d'une tableau 
		protected JTable table;
		
		
		//On initialise des label pour les variables suivantes
		protected JLabel JLcodeVisiteur;
		protected JLabel JLdateVisite;
		protected JLabel JLreference;
		protected JLabel JLcodeMedecin;
		protected JLabel JLlieu;
		
		// On initialise des champs textes pour les variables suivantes
		protected JTextField JTcodeVisiteur;
		protected JTextField JTdateVisite;
		protected JTextField JTreference;
		protected JTextField JTcodeMedecin;
		protected JTextField JTlieu;
		
		/* Ci dessous les variables ajouter pour essai*/
		protected MenuPrincipal fenetreContainer;
		
		
	public JIFListeVisite(MenuPrincipal uneFenetreContainer){
		this.setTitle("Liste visite");
			fenetreContainer = uneFenetreContainer;
			
			
			//On place dans l'arraylist lesVisites la collection des visites de DAO
			//lesVisites = visiteDao.retournerCollectionDesVisites();
			// On donne à la variable nbLignes la taille de l'array lesVisites
			//int nbLignes = lesVisites.size();
			
			diccoVisite = visiteDao.retournerDictionnaireDesVisites();
			int nbLignes = diccoVisite.size();
					
			//JTable table;
			
			// On ajoute les différents composants à la fenêtre 
			l = new JPanel(); 
			lTexte = new JPanel(new GridLayout(2,15));
			lTexte2 = new JPanel(new GridLayout(2,15));
			lButton = new JPanel();
			
			
			

			int i =0;
			String[][] data = new String[nbLignes][3] ;
			//Parcours de l'objet hashMap
			for(Map.Entry<String, visite> uneVisite : diccoVisite.entrySet()) {
				data[i][0] = uneVisite.getValue().getReference();
				data[i][1] = uneVisite.getValue().getUnMedecin().getCodeMed();
				data[i][2] = uneVisite.getValue().getUnVisiteur().getUneLocalite().getVille();
				
			}			
			/*
			 * On place le titre des colonnes du tableau dans le tableau string columnNames
			*/
			String[] columnNames = {"Reference", "code Medecin", "Lieu"};
			/*
			 * On initialise un nouvel objet table dans lequel on insert le tableau avec le nom des colonnes +
			 * les données executer dans la boucle 
			 * */
			table = new JTable(data, columnNames);
			/*
			 * Permet action de l'utilisateur sur le tableau 
			 * */
			table.getSelectionModel().addListSelectionListener(table);
			
			
			
			
			
			/*
			 * On initialise un nouvel objet scrollpane avec pour objet table
			 * On fixe les dimensions du scrollPane
			 * On ajoute le scrollPane à la fenêtre 
			 * */
			
			/*
			 * On déclaire un nouveau champ texte pour la variable JTlieu
			 * On fixe la taille préférable pour JTlieu 
			 * On ajoute JTlieu à l'objet lSaisie
			 * */
			
			
			scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(400, 200));
			l.add(scrollPane);
			
			lSaisie = new JPanel();
			
			/*
			 * Déclaration du button
			 * */
			JBdisplay = new JButton("Visite détaillée");
			JBdisplay.addActionListener(this);
			
			
			lButton.add(JBdisplay);
			
			
			/*
			 * Champ de saisie pour rentrer le numéro de reference voulu 
			 * On fixe une taille 
			 * On ajoute le champ de saisie JTreference à l'objet lSaisie
			 * */
			
			JLreference = new JLabel("Code visiteur");
			lTexte2.add(JLreference);
					
			JTreference = new JTextField(20);
			JTreference.setMaximumSize(JTreference.getPreferredSize());
			lSaisie.add(JTreference);
			
			
			
			
			
			
			
			/*
			 * CODE VISITEUR ET DATE VISITE 
			 * On déclare les label de code visiteur et date visite 
			 * On déclare un champ texte pour code visiteur et date visite
			 * On ajoute les labels au champ lTexte de la fenêtre
			 * */
			JLcodeVisiteur = new JLabel("codeVisiteur");
			JLdateVisite = new JLabel("Date de visite");
			
			JTcodeVisiteur = new JTextField();
			JTdateVisite = new JTextField();
			
			lTexte.add(JLcodeVisiteur);
			lTexte.add(JTcodeVisiteur);
			lTexte.add(JLdateVisite);
			lTexte.add(JTdateVisite);
			
			
			
			/*JBdisplay = new JButton("Visite détaillée");
			lButton.add(JBdisplay);*/
			
			l.add(lTexte);
			l.add(lTexte2);
			l.add(lSaisie);
			l.add(lButton);


			
			
			Container contentPane = getContentPane();
			contentPane.add(l);
			
		}

	      


		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}

