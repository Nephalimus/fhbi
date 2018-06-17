
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class WindowBuilder extends JFrame{
	private JTextField textField;
	public WindowBuilder() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
