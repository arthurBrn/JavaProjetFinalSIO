package vue;

import java.awt.Container;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.medicament;
import modele.visite;
import modele.dao.medicamentDao;
import modele.dao.visiteDao;
import modele.dao.LocaliteDao;
import modele.dao.MedecinDao;
import modele.dao.visiteurDao;
import service.VisiteService;

public class JIFAjoutVisite extends JInternalFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	protected JPanel a;
	protected JPanel aButton;
	protected JPanel aTexte;
	
	
	
	protected JPanel faux;
	protected JPanel fauxTexte;
	
	protected JButton JBajoutVisite;
	
	
	protected JLabel JLreference;
	protected JLabel JLdateVisite;
	protected JLabel JLcommentaire;
	protected JLabel JLmatriculeVisiteur;
	protected JLabel JLcodeMedecin;
	protected JLabel JLFAUX;
	
	protected JLabel messageApresAjout;
	
	protected JTextField JTreference;
	protected JTextField JTdateVisite;
	protected JTextField JTcommentaire;
	protected JTextField JTmatriculeVisiteur;
	protected JTextField JTcodeMedecin;
	
	public String recupRef;
	public String recupDateVisite;
	public String recupCommentaire;
	public String recupMatricule;
	public String recupCodeMedecin;
	

	public JIFAjoutVisite(){
		this.setTitle("Vue ajouter visite");
		
    	a = new JPanel();  // panneau principal de la fenêtre
        aButton = new JPanel();    // panneau supportant les boutons
        aTexte = new JPanel(new GridLayout(9,2));
        
        
        
        
        JLreference = new JLabel("Reference");
        JLdateVisite = new JLabel("Date de visite");
        JLcommentaire = new JLabel("Commentaire");
        JLmatriculeVisiteur = new JLabel("Matricule du visiteur");
        JLcodeMedecin = new JLabel("Code medecin ");
        JLFAUX = new JLabel("TOUS LES CHAMPS DOIVENT ETRE COMPELETER");
        
        JTreference = new JTextField(20);
        JTdateVisite= new JTextField(10);
        JTcommentaire = new JTextField(10);
        JTmatriculeVisiteur = new JTextField(10);    
        JTcodeMedecin = new JTextField(10);
        
        
        
        
        
        aTexte.add(JLreference);
        aTexte.add(JTreference);
        aTexte.add(JLdateVisite);
        aTexte.add(JTdateVisite);
        aTexte.add(JLcommentaire);
        aTexte.add(JTcommentaire);
        aTexte.add(JLmatriculeVisiteur);
        aTexte.add(JTmatriculeVisiteur);
        aTexte.add(JLcodeMedecin);
        aTexte.add(JTcodeMedecin);
        
        JBajoutVisite = new JButton("Ajouter");
        JBajoutVisite.addActionListener(this);
        
        // On ajoute le bouton au frame 
        aButton.add(JBajoutVisite);
        
        messageApresAjout = new JLabel();
        
        //Mise en forme du texte
        
        a.add(messageApresAjout);
        a.add(aTexte);
        a.add(aButton);
        Container contentPane = getContentPane();
        contentPane.add(a);
}
	
		@Override
		
		public void actionPerformed(ActionEvent event) {
			
			
			if(VisiteService.verification(JTreference.getText(), JTdateVisite.getText(), 
					JTcommentaire.getText(), JLmatriculeVisiteur.getText(), JTcodeMedecin.getText())) {
				
				visiteDao.ajouterVisite(new visite(JTreference.getText(), JTdateVisite.getText(), JTcommentaire.getText(),
						visiteurDao.rechercher(JTmatriculeVisiteur.getText()),
						MedecinDao.rechercher(JTcodeMedecin.getText())));
				
				JOptionPane.showMessageDialog(new JFrame(), "Visite Créer");
			}
			
		}
	}

	
	
	
	
	
	
