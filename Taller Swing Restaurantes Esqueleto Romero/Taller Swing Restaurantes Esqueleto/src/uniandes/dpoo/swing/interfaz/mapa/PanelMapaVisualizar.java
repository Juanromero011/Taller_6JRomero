package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se muestra el mapa como imagen de fondo
     */
    private JLabel labMapa;

    /**
     * Lista interna de restaurantes a dibujar en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar()
    {
        setLayout(new BorderLayout());

        this.labMapa = new JLabel(new ImageIcon("./imagenes/mapa.png"));
        labMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        add(labMapa, BorderLayout.CENTER);

        this.restaurantes = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Restaurante r : restaurantes)
        {
            int x = r.getX();
            int y = r.getY();

            // Dibuja punto rojo
            g2d.setColor(Color.RED);
            g2d.fillOval(x - 5, y - 5, 10, 10);

            // Dibuja el nombre al lado del punto
            g2d.setColor(Color.BLACK);
            g2d.drawString(r.getNombre(), x + 8, y);
        }
    }

    /**
     * Actualiza los restaurantes a mostrar en el mapa
     * @param nuevosRestaurantes lista nueva
     */
    public void actualizarMapa(List<Restaurante> nuevosRestaurantes)
    {
        this.restaurantes = new ArrayList<>(nuevosRestaurantes);
        repaint();
    }
}
