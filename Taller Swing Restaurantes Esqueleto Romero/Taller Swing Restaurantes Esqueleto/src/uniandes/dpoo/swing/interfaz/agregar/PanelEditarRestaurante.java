package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante()
    {
        // Usamos un GridLayout con 3 filas y 2 columnas
        setLayout(new GridLayout(3, 2, 5, 5));

        // Crea el campo para el nombre con una etiqueta al frente
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        add(lblNombre);
        add(txtNombre);

        // Crea el selector para la calificación con una etiqueta al frente
        JLabel lblCalificacion = new JLabel("Calificación:");
        cbbCalificacion = new JComboBox<>(new String[] { "1", "2", "3", "4", "5" });
        add(lblCalificacion);
        add(cbbCalificacion);

        // Crea el selector para indicar si ya ha sido visitado, con una etiqueta al frente
        JLabel lblVisitado = new JLabel("¿Visitado?");
        cbbVisitado = new JComboBox<>(new String[] { "Sí", "No" });
        add(lblVisitado);
        add(cbbVisitado);
    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return true si fue visitado, false si no
     */
    public boolean getVisitado()
    {
        return cbbVisitado.getSelectedItem().equals("Sí");
    }

    /**
     * Indica la calificación marcada en el selector
     * @return Calificación seleccionada (1 a 5)
     */
    public int getCalificacion()
    {
        String calif = (String) cbbCalificacion.getSelectedItem();
        return Integer.parseInt(calif);
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return Nombre ingresado en el campo de texto
     */
    public String getNombre()
    {
        return txtNombre.getText().trim();
    }
}
