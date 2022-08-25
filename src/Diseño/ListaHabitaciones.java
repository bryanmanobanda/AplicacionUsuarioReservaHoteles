package Diseño;

import Conexion.SQLTipoHab;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ListaHabitaciones extends JPanel implements ItemListener{
  private final Color cuerpo = new Color(147,171,169);
  private final Color pieCol = new Color(195,116,94);
  private final Font Ftitulo = new Font("Open Sans Semibold", Font.BOLD, 18);
  JComboBox combo = new JComboBox();
  //JComboBoxRound busqueda = new JComboBoxRound(combo);
  JScrollPane jsPanel = new JScrollPane();
  public JPanel panel = new JPanel(new GridLayout(0, 3, 30, 30));
  public JPanel pie = new JPanel(new AbsoluteLayout());
  public JPanel busque = new JPanel(new AbsoluteLayout());
  Dimension tam = new Dimension(1000, 50);
  SQLTipoHab conexTipo = new SQLTipoHab();
  JLabel titulo= new JLabel();
  ArrayList<CajaHabitacion> lista = new ArrayList<>();
  
  public ListaHabitaciones() throws ClassNotFoundException, SQLException{
    combo.setPreferredSize(new Dimension(300, 25));
    jsPanel.setBackground(cuerpo);
    jsPanel.setBorder(null);
    this.setBackground(cuerpo);
    combo.setModel(new DefaultComboBoxModel<>(conexTipo.busquedaTipos()));
    busque.setBackground(cuerpo);
    panel.setBackground(cuerpo);
    pie.setBackground(pieCol);
    titulo.setFont(Ftitulo);
    titulo.setForeground(Color.WHITE);
    this.setLayout(new BorderLayout());
    busque.setPreferredSize(tam);
    pie.setPreferredSize(tam);
    pie.add(titulo, new AbsoluteConstraints(600, 14, -1,-1));
    busque.add(combo, new AbsoluteConstraints(350, 14, -1,-1));
    this.add(busque, BorderLayout.NORTH);
    this.add(jsPanel, BorderLayout.CENTER);
    this.add(pie,BorderLayout.SOUTH);
    jsPanel.getViewport().add(panel);
    combo.addItemListener(this);
  }
  
  public void arreglo(CajaHabitacion caja){
    lista.add(caja);
    panel.add(caja);
  }  

  public JLabel getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo.setText(titulo);
  }
  
  public JPanel getPie() {
    return pie;
  }

  public void setPie(JPanel pie) {
    this.pie = pie;
  }
  
  public void limpiar(){
    panel.removeAll();
    panel.updateUI();
    pie.updateUI();
    combo.removeAll();
    lista.clear();
    busque.updateUI();
  }

  @Override
  public void itemStateChanged(ItemEvent ie) {
    combo.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent ie) {
        if(combo.getSelectedIndex() == 0){
            panel.removeAll();
            for(int i = 0; i < lista.size(); i++){
                panel.add(lista.get(i));
            }
          panel.updateUI();
          }else{
        String seleccionado=(String)combo.getSelectedItem();
        panel.removeAll();
        for(int i = 0; i < lista.size(); i++){
          if(lista.get(i).getHabitacionselec().getTipoHabitacion().getNombreTipo().equals(seleccionado)){
            panel.add(lista.get(i));
          }
        }
          panel.updateUI();
        }}
      });
  }
}
