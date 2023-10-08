package swingmvclab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.*;

/*
 * A megjelen�tend� ablakunk oszt�lya.
 */
public class StudentFrame extends JFrame {
    
     private StudentData data;
     private JTextField nev;
     private JTextField neptun;

    private void initComponents() {
        this.setLayout(new BorderLayout());

        JTable jt = new JTable();
        jt.setFillsViewportHeight(true);
        jt.setModel(data);

        JScrollPane js  = new JScrollPane(jt);
        this.add(js, BorderLayout.CENTER);

        JPanel jp = new JPanel();
        JLabel nevL = new JLabel("Név: ");
        JLabel neptunL = new JLabel("Neptun: ");
        nev = new JTextField("", 6);
        neptun = new JTextField("", 20);
        JButton add = new JButton("Felvesz");
        jp.add(nevL);
        jp.add(nev);
        jp.add(neptunL);
        jp.add(neptun);
        jp.add(add);
        add.addActionListener(e->addStudent(nev.getText(), neptun.getText()));
        this.add(jp, BorderLayout.SOUTH);
    }
    public void addStudent(String nameS, String neptunS) {
        Student uj = new Student(nameS, neptunS, false, 0);
        data.addSt(uj);
        data.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    public StudentFrame() {
        super("Hallgatói nyilvántartás");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            data = new StudentData();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            data.students = (List<Student>)ois.readObject();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
                    oos.writeObject(data.students);
                    oos.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setMinimumSize(new Dimension(500, 200));
        initComponents();
    }


    public static void main(String[] args) {
        // Megjelen�tj�k az ablakot
        StudentFrame sf = new StudentFrame();
        sf.setVisible(true);
    }
}
