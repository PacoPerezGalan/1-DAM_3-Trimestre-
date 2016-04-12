package prova_jtable;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class valorsFila extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNom;
	private JTextField textFieldCognoms;
	private JTextField textFieldModul;
	private JTextField textFieldCurs;
	DefaultTableModel dtm2;
	Object[] valorsFila;

	/**
	 * Create the dialog.
	 */
	public valorsFila(DefaultTableModel dtm,Object[] valor) {
		dtm2=dtm;
		valorsFila= new Object[dtm2.getColumnCount()];
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(4, 2, 0, 5));
		{
			JLabel lblNom = new JLabel("Nom:");
			lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblNom);
		}
		{
			textFieldNom = new JTextField();
			contentPanel.add(textFieldNom);
			textFieldNom.setColumns(10);
		}
		{
			JLabel lblCognoms = new JLabel("Cognoms:");
			lblCognoms.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblCognoms);
		}
		{
			textFieldCognoms = new JTextField();
			contentPanel.add(textFieldCognoms);
			textFieldCognoms.setColumns(10);
		}
		{
			JLabel lblModul = new JLabel("Modul:");
			lblModul.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblModul);
		}
		{
			textFieldModul = new JTextField();
			contentPanel.add(textFieldModul);
			textFieldModul.setColumns(10);
		}
		{
			JLabel lblCurs = new JLabel("Curs:");
			lblCurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblCurs);
		}
		{
			textFieldCurs = new JTextField();
			contentPanel.add(textFieldCurs);
			textFieldCurs.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accio=e.getActionCommand();
		if(accio.compareTo("OK")==0){
			//Comprovem les dades introduides
			if(comprovaDades()==true){
				dtm2.addRow(valorsFila);
				//Tanca la finestra.
				dispose();
			}else{
				//informem a l'usuari de les dades erronies
			}
		}
		if(accio.compareTo("Cancel")==0){
			//Tanca la finestra.
			dispose();
		}
	}
	
	private boolean comprovaDades(){
		boolean dadesCorrectes=true;
		if(textFieldNom.getText().trim().equals("")){
			valorsFila[0]=null;
			dadesCorrectes=false;
		}else{
			valorsFila[0]=textFieldNom.getText();
		}
		if(textFieldCognoms.getText().trim().equals("")){
			valorsFila[1]=null;
			dadesCorrectes=false;
		}else{
			valorsFila[1]=textFieldCognoms.getText();
		}
		if(textFieldModul.getText().trim().equals("")){
			valorsFila[2]=null;
			dadesCorrectes=false;
		}else{
			valorsFila[2]=textFieldModul.getText();
		}
		if(textFieldCurs.getText().trim().equals("")){
			valorsFila[3]=null;
			dadesCorrectes=false;
		}else{
			valorsFila[3]=textFieldCurs.getText();
		}
		
		if(dadesCorrectes==true){
			return true;
		}else{
			return false;
		}
	}
}
