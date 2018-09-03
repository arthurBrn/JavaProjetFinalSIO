package vue;

import java.awt.Container;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.medicament;
import modele.dao.medicamentDao;

public class JIFMedicamentAjout extends JInternalFrame implements ActionListener{
   
    private static final long serialVersionUID = 1L;
   
    protected JPanel a;
    protected JPanel aBouton;
    protected JPanel aTexte;
   
    protected JLabel JLdepotLegal;
    protected JLabel JLnomCommercial;
    protected JLabel JLcomposition;
    protected JLabel JLeffets;
    protected JLabel JLcontreIndication;
    protected JLabel JLprixEchantillon;
    protected JLabel JLcodeFamille;
    protected JLabel JLlibelleFamille;
    
    protected JTextField JTdepotLegal;
    protected JTextField JTnomCommercial;
    protected JTextField JTcomposition;
    protected JTextField JTeffets;
    protected JTextField JTcontreIndication;
    protected JTextField JTprixEchantillon;
    protected JTextField JTcodeFamille;
    protected JTextField JTlibelleFamille;
    
    protected JButton JBajouterQuantite;

    public JIFMedicamentAjout(){
        a = new JPanel();  // panneau principal de la fenêtre
        aBouton = new JPanel();    // panneau supportant les boutons
        aTexte = new JPanel(new GridLayout(8,2));
       
        JLdepotLegal = new JLabel("Dépot légal");
        JLnomCommercial = new JLabel("Nom commercial");
        JLcomposition = new JLabel("Composition");
        JLeffets = new JLabel("Effets");
        JLcontreIndication = new JLabel("Contre indication");
        JLprixEchantillon = new JLabel("Prix échantillon");
        JLcodeFamille = new JLabel("Code famille");
        JLlibelleFamille = new JLabel("Libelle famille");
        
        
        
        
        JTdepotLegal= new JTextField();
        JTnomCommercial = new JTextField();
        JTcomposition = new JTextField();
        JTeffets = new JTextField();
        JTcontreIndication = new JTextField();
        JTprixEchantillon = new JTextField();
        JTcodeFamille = new JTextField();
        JTlibelleFamille = new JTextField();
        
        aTexte.add(JLdepotLegal);
        aTexte.add(JTdepotLegal);
        aTexte.add(JLnomCommercial);
        aTexte.add(JTnomCommercial);
        aTexte.add(JLcomposition);
        aTexte.add(JTcomposition);
        aTexte.add(JLeffets);
        aTexte.add(JTeffets);
        aTexte.add(JLcontreIndication);
        aTexte.add(JTcontreIndication);
        aTexte.add(JLprixEchantillon);
        aTexte.add(JTprixEchantillon);
        aTexte.add(JLcodeFamille);
        aTexte.add(JTcodeFamille);
        aTexte.add(JLlibelleFamille);
        aTexte.add(JTlibelleFamille);
       
        //Mise en forme du texte
       
        a.add(aTexte);
        a.add(aBouton);
        Container contentPane = getContentPane();
        contentPane.add(a);
       
        JBajouterQuantite = new JButton("Ajouter médicament");
        aBouton.add(JBajouterQuantite);    
        JBajouterQuantite.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent event) {

    	medicamentDao.ajouterMedicament(new medicament(JTdepotLegal.getText(), JTnomCommercial.getText(), JTcomposition.getText(),
    			JTeffets.getText(), JTcontreIndication.getText(), JTprixEchantillon.getText(), JTcodeFamille.getText(), 
    			JTlibelleFamille.getText()));
    			
    	

    	}
}