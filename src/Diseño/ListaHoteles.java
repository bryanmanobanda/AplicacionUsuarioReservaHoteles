package Diseño;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ListaHoteles extends JPanel implements ItemListener{
  private final Color cuerpo = new Color(147,171,169);
  JComboBox combo = new JComboBox();
  JComboBoxRound busqueda = new JComboBoxRound(combo);
  JScrollPane jsPanel = new JScrollPane();
  public JPanel panel = new JPanel(new GridLayout(0, 3, 30, 30));
  public JPanel busque = new JPanel(new AbsoluteLayout());
  ArrayList<CajaHotel> lista = new ArrayList<>();
  String[] paises;
  public ListaHoteles() throws ClassNotFoundException, SQLException{
    combo.setPreferredSize(new Dimension(300, 25));
    jsPanel.setBackground(cuerpo);
    jsPanel.setBorder(null);
    this.setBackground(cuerpo);
    busque.setBackground(cuerpo);
    panel.setBackground(cuerpo);
    this.setLayout(new BorderLayout());
    busque.setPreferredSize(new Dimension(1000, 50));
    busque.add(combo, new AbsoluteConstraints(350, 14, -1,-1));
    this.add(busque, BorderLayout.NORTH);
    this.add(jsPanel, BorderLayout.CENTER);
    jsPanel.getViewport().add(panel);
    combo.addItemListener(this);
  }
  
  public void arreglo(CajaHotel caja){
      lista.add(caja);
      panel.add(caja);
  }
  
  public void pais(String[] paises ){
    this.paises = paises;
    combo.setModel(new DefaultComboBoxModel<>(paises));
  }
  public void limpiar(){
    panel.removeAll();
    combo.removeAll();
    lista.clear();
    panel.updateUI();
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
          if(lista.get(i).getHotelSelec().getPais().equals(seleccionado)){
            panel.add(lista.get(i));
          }
        }
          panel.updateUI();
        }}
      });
  }
}
