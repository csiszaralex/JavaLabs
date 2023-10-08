package swingmvclab;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentData extends AbstractTableModel {

    List<Student> students = new ArrayList<Student>();
    public void addSt(Student st) {
        students.add(st);
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex) {
            case 0: return "Név";
            case 1: return "Neptun";
            case 2: return "Aláírás";
            default: return "Jegy";
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 3: return Integer.class;
            case 2: return Boolean.class;
            default: return String.class;
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 2;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Student st = students.get(rowIndex);
        if(columnIndex == 2) st.setSignature((boolean)aValue);
        else if(columnIndex == 3) st.setGrade((int)aValue);
        students.set(rowIndex, st);
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getName();
            case 1:
                return student.getNeptun();
            case 2:
                return student.hasSignature();
            default:
                return student.getGrade();
        }

    }
}
