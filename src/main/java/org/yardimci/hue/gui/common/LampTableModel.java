package org.yardimci.hue.gui.common;

import org.yardimci.hue.core.model.response.lamp.Lamp;
import org.yardimci.hue.lang.Bundle;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LampTableModel extends AbstractTableModel {

    public LampTableModel() {
    }

    public LampTableModel(List<Lamp> lampList) {
        data = new Object[lampList.size()][columnNames.length];
        int i = 0;
        for (Lamp lamp : lampList) {
            data[i][0] = lamp.getName();
            data[i][1] = lamp.getModelid();
            data[i][2] = lamp.getCapabilities().getControl().getMaxlumen();
            data[i][3] = lamp.getState().isReachable() && lamp.getState().isOn();
            i++;
        }
    }

    private static final String[] columnNames = {"label.name", "label.description", "label.id", "label.status"};
    private static final Class<?>[] columnTypes = new Class<?>[] {String.class, String.class, Integer.class,  Boolean.class};

    private Object[][] data ;

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return Bundle.getValue(columnNames[column]);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        /*if (columnIndex + 1 == columnNames.length) {
            final JButton button = new JButton(getColumnName(columnIndex));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button),
                            "Button clicked for row "+rowIndex);
                }
            });
            return button;
        }*/
        return data[rowIndex][columnIndex];
    }

    public void clear() {
        data = new Object[][]{};
    }

}
