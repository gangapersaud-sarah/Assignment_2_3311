package YazanCode;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ColorRenderer extends JLabel implements TableCellRenderer  {

	public ColorRenderer() {
		setOpaque(true); //MUST do this for background to show up.
	}

	public Component getTableCellRendererComponent(
			JTable table, Object value,
			boolean isSelected, boolean hasFocus,
			int row, int column) { 
		if (table.getValueAt(row, 1).equals("disabled"))
		{
			setBackground(Color.RED);
		}
		else
		{
			setBackground(Color.GREEN);
		}
		//}
		return this;
	}
}
