package dmi.Pantalla;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import ecp.ASFA;
import ecp.Main;

public class TipoTren extends JLabel {

    String tipo;

    public TipoTren() {
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Helvetica-Condensed", 1, 15));
        setForeground(Color.white);
        set(120);
    }

    public void set(int T) {
        tipo = "T".concat(Integer.toString(T));
        update();
    }

    public void update() {
        setForeground(Main.ASFA.dmi.pantalla.modo == ModoDisplay.Día ? Color.black : Color.white);
        setText(tipo);
    }
}
