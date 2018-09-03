package vue;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modele.medicament;
import modele.visiteur;
import modele.dao.medicamentDao;
import modele.dao.visiteurDao;

public class JIFMedicamentStock extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<medicament> lesMedicaments;

	protected JPanel p;

	protected JScrollPane scrollPane;

	protected JPanel pSaisie;

	protected JTextField JTcodeVisiteur;

	protected JButton JBafficherFiche;

	protected MenuPrincipal fenetreContainer;

	

	@Override

	public void actionPerformed(ActionEvent arg0) {

	Object source = arg0.getSource();

	if (source == JBafficherFiche){

	visiteur unVisiteur = visiteurDao.rechercher(JTcodeVisiteur.getText());


	}

	}
	
	public JIFMedicamentStock(MenuPrincipal uneFenetreContainer) {

	fenetreContainer = uneFenetreContainer;

	// récupération des données Medicament dans la collection

	lesMedicaments = medicamentDao.retournerCollectionDesMedicaments();

	int nbLignes = lesMedicaments.size();

	JTable table;

	p = new JPanel(); // panneau principal de la fenêtre

	int i=0;

	String[][] data = new String[nbLignes][4] ;

	for(medicament unMedicament : lesMedicaments){

	data[i][0] = unMedicament.getDepotLegal();

	data[i][1] = unMedicament.getNomCommercial();

	//data[i][2] = unMedicament.getVisiteur.getQteStock();

	i++;

	}

	String[] columnNames = {"Code", "Nom","Stock"};

	table = new JTable(data, columnNames);

	scrollPane = new JScrollPane(table);

	scrollPane.setPreferredSize(new Dimension(400, 200));

	p.add(scrollPane);

	pSaisie = new JPanel();

	JTcodeVisiteur = new JTextField(20);

	JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());

	pSaisie.add(JTcodeVisiteur);

	p.add(pSaisie);

	// mise en forme de la fenêtre

	Container contentPane = getContentPane();

	contentPane.add(p);

	}

}
