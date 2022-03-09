
package jmenubarmenuitems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author pawelstradomski
 */
public class JMenuBarMenuItems extends JFrame
{
    JMenuBarMenuItems()
    {
        super("Pasek menu");
        this.setBounds(600, 300, 300, 200);
        this.setDefaultCloseOperation(3);
        initComponent();
    }
    public void initComponent()
    {
        this.setJMenuBar(pasekMenu);
                                                                        
        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));                  //pasekMenu.add(new JMenu("Plik"));//ale zeby dodawac items lepiej:
        menuPlik.add("Nowy");                                               //dodaje item
        JMenuItem podMenu = menuPlik.add(new JMenuItem("Wczytaj"));         //dodaje item - 2g sposob z Action Listener
        
        podMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("wczytuje plik");
            }
        });
        
        
        menuPlik.addSeparator();                                            //separator pomiedzy item wczytaj/zapisz
        final JMenuItem podMenuZapisz = menuPlik.add(new JMenuItem("Zapisz"));    //dodaje item - 3ci sposob
        
        JMenu menuOpcje = new JMenu("Opcje");
        menuPlik.add(menuOpcje);
        menuOpcje.add("Opcja 1");
        menuOpcje.add("Opcja 2");
        menuOpcje.add(menuCheckBox);
        
        menuCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menuCheckBox.isSelected())
                    podMenuZapisz.setEnabled(false);
                else
                    podMenuZapisz.setEnabled(true);
            }
        });
        
        
        JMenu menuPomoc = pasekMenu.add(new JMenu("Pomoc"));
        menuPomoc.add("FAQ");
        
    }
    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBox menuCheckBox = new JCheckBox("Tylko do odczytu");  //JCheckBoxMenuItem nie dziala na MacOs

    
    public static void main(String[] args) {
        new JMenuBarMenuItems().setVisible(true);
    }
    
}
