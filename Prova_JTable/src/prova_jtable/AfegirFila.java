package prova_jtable;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AfegirFila extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultTableModel dtm2;
	Object[] columnes;
	Object[] dades;
	JTextField[] arrayJT;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public AfegirFila(DefaultTableModel dtm,Object[] valor) {
		dtm2=dtm;
		columnes=valor;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			
			
			{
				JPanel panelDades = new JPanel();
				panelDades.setLayout(new GridLayout(0, 2, columnes.length, 0));
				{
					arrayJT=new JTextField[columnes.length];
					dades=new Object[columnes.length];
					for(int i=0;i<columnes.length;i++){
						JLabel label =new JLabel();
						{
							label.setText(dtm2.getColumnName(i)+" : ");
						}
						panelDades.add(label);
						arrayJT[i]=new JTextField();
						{
							
						}
						panelDades.add(arrayJT[i]);
					}
					
				}
				JScrollPane scrollPane = new JScrollPane(panelDades);
				
				
				contentPanel.add(scrollPane);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						for(int i=0;i<columnes.length;i++){
							dades[i]=arrayJT[i].getText();
						}
						dtm2.addRow(dades);
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}

}
