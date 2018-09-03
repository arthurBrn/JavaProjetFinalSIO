package vue;


import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.medicament;

import java.awt.Container;
import java.awt.GridLayout;


public class JIFMedicament extends JInternalFrame {

/**

* Commentaire pour <code>serialVersionUID</code>

*/

private static final long serialVersionUID = 1L;

// déclaration des panneaux qui contiendront les composants graphiques

protected JPanel p;

protected JPanel pTexte;

protected JPanel pBoutons;

// déclaration des composants graphiques

protected JLabel JLdepotLegal;

protected JLabel JLnomCommercial;

protected JLabel JLnomComposition;

protected JLabel JLeffets;

protected JLabel JLcontreIndications;

protected JLabel JLcodeFamille;

protected JLabel JLlibelleFamille;


protected JTextField JTdepotLegal;

protected JTextField JTnomCommercial;

protected JTextField JTnomComposition;

protected JTextField JTeffets;

protected JTextField JTcontreIndications;

protected JTextField JTcodeFamille;

protected JTextField JTlibelleFamille;


public JIFMedicament() {

p = new JPanel(); // panneau principal de la fenêtre

pBoutons = new JPanel(); // panneau supportant les boutons

pTexte = new JPanel(new GridLayout(8,2));

 JLdepotLegal = new JLabel("Dépot Légal"); // instanciation des composants graphiques

 JLnomCommercial = new JLabel("Nom Commercial");

 JLnomComposition= new JLabel("Composition");

 JLeffets= new JLabel("Effets"); // les labels

 JLcontreIndications = new JLabel("Contre Indications");

 JLcodeFamille = new JLabel("Code Famille");

 JLlibelleFamille = new JLabel("Libelle Famille");


JTdepotLegal = new JTextField(20);

JTdepotLegal.setMaximumSize(JTdepotLegal.getPreferredSize());

JTnomCommercial = new JTextField(20);

JTnomComposition = new JTextField(20);

JTeffets = new JTextField(20);

JTcontreIndications = new JTextField(20); // les zones de texte

JTcodeFamille = new JTextField(20);

JTlibelleFamille = new JTextField(20);


pTexte.add(JLdepotLegal);

pTexte.add(JTdepotLegal);

pTexte.add(JLnomCommercial);

pTexte.add(JTnomCommercial);

pTexte.add(JLnomComposition);

pTexte.add(JTnomComposition);

pTexte.add(JLeffets);

pTexte.add(JTeffets); // placement des labels et des zones de texte

pTexte.add(JLcontreIndications); // le layout étant un gridLayout, les composants vont

pTexte.add(JTcontreIndications); // être placés les uns à la suite des autres dans la grille

pTexte.add(JLcodeFamille);

pTexte.add(JTcodeFamille);

pTexte.add(JLlibelleFamille);

pTexte.add(JTlibelleFamille);

// mise en forme de la fenêtre

p.add(pTexte);

p.add(pBoutons);

Container contentPane = getContentPane();

contentPane.add(p);

}

public void remplirText(medicament unMedicament)

{ // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres

JTdepotLegal.setText(unMedicament.getDepotLegal());

JTnomCommercial.setText(unMedicament.getNomCommercial());

JTnomComposition.setText(unMedicament.getComposition());

JTeffets.setText(unMedicament.getEffets());

JTcontreIndications.setText(unMedicament.getContreIndication());

JTcodeFamille.setText(unMedicament.getCodeFamille());

JTlibelleFamille.setText(unMedicament.getLibelleFamille());


}

public void viderText()

{ // méthode qui permet de vider les zones de texte

JTdepotLegal.setText("");

JTnomCommercial.setText("");

JTnomComposition.setText("");

JTeffets.setText("");

JTcontreIndications.setText("");

JTcodeFamille.setText("");

JTlibelleFamille.setText("");


}
}

