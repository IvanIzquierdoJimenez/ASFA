package dmi.Pantalla;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dmi.Pantalla.Pantalla.ModoDisplay;
import ecp.ASFA;
import ecp.Config;
import ecp.Main;

public class VelocidadObjetivo extends JPanel {

    public Velocidad veloc;
    JLabel Triángulo;
    JLabel Rectángulo;
    Icono IconoTriángulo;
    public int figureVisible;

    public VelocidadObjetivo() {
        setLayout(null);
        setOpaque(false);
        setBorder(null);
        veloc = new Velocidad(Pantalla.blanco, Color.black);
        veloc.setBounds(Main.dmi.pantalla.getScale(45), Main.dmi.pantalla.getScale(3), Main.dmi.pantalla.getScale(75), Main.dmi.pantalla.getScale(31));
        veloc.Center = true;
        veloc.construct();
        add(veloc);
        Rectángulo = new JLabel();
        int fact = Config.Fabricante.equals("INDRA") ? 3 : 0;
        Rectángulo.setBounds(Main.dmi.pantalla.getScale(42), Main.dmi.pantalla.getScale(fact), Main.dmi.pantalla.getScale(81), Main.dmi.pantalla.getScale(37-fact));
        add(Rectángulo);
        Triángulo = new JLabel();
        Triángulo.setBounds(Main.dmi.pantalla.getScale(0), Main.dmi.pantalla.getScale(0), Main.dmi.pantalla.getScale(165), Main.dmi.pantalla.getScale(72));
        add(Triángulo);
        IconoTriángulo = new Icono(true, "Triángulo.png");
        set(0, 0);
    }

    public void set(int visible, int val) {
        figureVisible = visible;
        veloc.value = val;
        update();
    }

    public void update() {
        if (figureVisible != 0) {
        	veloc.update();
            veloc.setVisible(true);
            Rectángulo.setOpaque(true);
            Rectángulo.setBackground(Main.dmi.pantalla.modo == ModoDisplay.Noche ? new Color(221, 221, 221) : Color.black);
        } else {
        	veloc.setVisible(false);
            Rectángulo.setOpaque(false);
        }
        if (figureVisible == 2) {
            Triángulo.setIcon(IconoTriángulo.getIcon());
        } else {
            Triángulo.setIcon(null);
        }
        repaint();
    }
}
