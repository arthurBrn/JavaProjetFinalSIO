/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package vue;

import java.awt.BorderLayout;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Isabelle 22 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;
	protected JMenu mVisites;

	/**
	 * 
	 */
	public MenuPrincipal() {

		
		
		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
		
		
		// JInternalFrame � la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("");
		setSize(500, 400);

		// Ajout d'une barre de menus � la fen�tre
		mbar = new JMenuBar();
		
		/*
		 * MEDECINS
		 * */
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un �couteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);

		/*
		 * MEDICAMENTS
		 * */
		mMedicaments = new JMenu("Medicaments");
		JMenuItem mE1 = new JMenuItem("Consultation Medicament");
		mE1.addActionListener(this); // installation d'un �couteur d'action
		mMedicaments.add(mE1);
		JMenuItem mE2 = new JMenuItem("Ajout Medicaments");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);
		JMenuItem mE3 = new JMenuItem("Stock Medicaments");
		mE3.addActionListener(this);
		mMedicaments.add(mE3);
		

		/**
		 * VISITES
		 */
		mVisites = new JMenu("Visites");
		
		
		JMenuItem mA1= new JMenuItem("Ajout Visite");
		mA1.addActionListener(this);
		mVisites.add(mA1);
		
		JMenuItem mA2 = new JMenuItem("Mise � jour visite");
		mA2.addActionListener(this);
		mVisites.add(mA2);
		
		JMenuItem mA3 = new JMenuItem("Liste des visites");
		mA3.addActionListener(this);
		mVisites.add(mA3);
		
		JMenuItem mA4 = new JMenuItem("R�capitulatif visites");
		mA4.addActionListener(this);;
		mVisites.add(mA4);
		
		
		mbar.add(mMedecins);
		mbar.add(mMedicaments);
		mbar.add(mVisites);
		setJMenuBar(mbar);
		this.setVisible(true);
		//Cette commande permet de fermer le programme quand on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Raccord de m�thode auto-g�n�r�
		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();

			//MEDECINS
			if (ChoixOption.equals("Consultation Medecin")) {
				// Creation d'une sous-fen�tre
				ouvrirFenetre(new JIFMedecinCons());

			} else if (ChoixOption.equals("Liste Medecins")) {
				ouvrirFenetre(new JIFMedecinListeDic(this));
			}
			
			//VISITES
			else if (ChoixOption.equals("Ajout Visite")) {
				ouvrirFenetre(new JIFAjoutVisite());
			}
			else if(ChoixOption.equals("Mise � jour visite")){
				ouvrirFenetre(new JIFMiseAJourVisite());
			}
			else if(ChoixOption.equals("Liste des visites")){
				ouvrirFenetre(new JIFListeVisite(this));
			}
			else if(ChoixOption.equals("R�capitualatif visite")) {
				ouvrirFenetre(new JIFVisiteRecapitulatif());
			}
			//MEDICAMENTS
			else if (ChoixOption.equals("Consultation Medicament")) {
				ouvrirFenetre(new JIFMedicamentListe(this));
			}
			else if (ChoixOption.equals("Stock Medicaments")) {
				ouvrirFenetre(new JIFMedicamentStock(this));
			}
			else if (ChoixOption.equals("Ajout Medicaments")) {
				ouvrirFenetre(new JIFMedicamentAjout());
			}

		}

	}

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fen�tre �tait dej� affich�e, elle
									// est lib�r�e
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(480, 380);
		desktopPane.add(myJInternalFrame);
	}

}
