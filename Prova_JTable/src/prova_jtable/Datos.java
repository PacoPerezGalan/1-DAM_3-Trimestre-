package prova_jtable;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.EventListenerList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Datos extends JFrame {

	private JPanel panelDeContingut;
	private JTable dades;
	Object[] valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datos frame = new Datos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Datos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		panelDeContingut = new JPanel();
		panelDeContingut.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelDeContingut);
		
		String nomsColumnes[]={"Nom","Cognoms","Modul","Curs","Cicle"};
		Object[] dadesTaula = new Object[5];
		DefaultTableModel dtm=new DefaultTableModel();
		JTable dades=new JTable(dtm);
			
		for(int columna=0;columna<5;columna++){
			dtm.addColumn(nomsColumnes[columna]);
		}
		
		for(int row=0;row<10;row++){
			for(int column=0;column<5;column++){
				dadesTaula[column]="Celda "+row+","+column;
			}
			dtm.addRow(dadesTaula);
		}
		panelDeContingut.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane= new JScrollPane(dades);
		panelDeContingut.add(scrollPane);
		
		JButton btnAfegirFila = new JButton("Afegir Fila");
		panelDeContingut.add(btnAfegirFila, BorderLayout.NORTH);
		
		JButton btnAfegirColumna = new JButton("Afegir Columna");
		panelDeContingut.add(btnAfegirColumna, BorderLayout.SOUTH);
		
		btnAfegirFila.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				valor=new Object[dtm.getColumnCount()];
				for (int i=0;i<dtm.getColumnCount();i++){
					valor[i]=dtm.getColumnName(i);
				}
				new AfegirFila(dtm,valor).setVisible(true);
				
				/*valor=new Object[dtm.getColumnCount()];
				for (int i=0;i<dtm.getColumnCount();i++){
					valor[i]=JOptionPane.showInputDialog(null,"Afegix valor per a "+dtm.getColumnName(i));
				}
				dtm.addRow(valor);*/
			}
		});
		
		btnAfegirColumna.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dtm.addColumn(JOptionPane.showInputDialog(null,"Afegix nom de columna"));
			}
		});
		
		/*
		 String dadesTaula[][]={{"Manel","Viel","PROGRAMACIO","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"JuanMi","Ruiz","SISTEMES","1","DAM"},{"Toni","Ruiz","BBDD","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"},{"Paco","Gomez","ENTORNS","1","DAM"},
				{"Paco","Gomez","ENTORNS","1","DAM"}};
		
		String nomsColumnes[]={"Nom","Cognoms","Modul","Curs","Cicle"};
		
		
		dades = new JTable(dadesTaula,nomsColumnes);
		dades.setBackground(new Color (100,100,250));
		
		JScrollPane scrollPane= new JScrollPane(dades);
		panelDeContingut.add(scrollPane);
		*/
		
	}

}
