import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.*;
class Menu extends JMenuBar{
    private JMenu[] menues;
    
    public Menu(ActionListener elEscuchador, String[][] elMenu){
        menues = new JMenu[elMenu.length];
        for (int indiceMenu=0;indiceMenu<elMenu.length; indiceMenu++){
            menues[indiceMenu] = new JMenu(elMenu[indiceMenu][0]);
            this.add(menues[indiceMenu]);
            
            for (int indiceItem=1; indiceItem<elMenu[indiceMenu].length; indiceItem++){
                String etiquetaItem = elMenu[indiceMenu][indiceItem];
                JMenuItem item = new JMenuItem(etiquetaItem);
                item.addActionListener(elEscuchador);
                menues[indiceMenu].add(item);
            }
        }
    }
}