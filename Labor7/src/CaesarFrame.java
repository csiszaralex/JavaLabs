import javax.swing.*;
import java.awt.*;

public class CaesarFrame extends JFrame{
    private final JTextField txt_up = new JTextField(20);
    private final JTextField txt_dwn = new JTextField(20);
    private final JButton btn = new JButton("Code!");
    private final JComboBox<Object> cb = new JComboBox<>(abc);

    private static final Object[] abc = new Object[26];
    static{
        for (int i = 0; i < 26; i++) {
            abc[i] = (char)(i+'A');
        }
    }


    public CaesarFrame() { this("");}
    public CaesarFrame(String str) {
        super(str);
        frameInit();
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,110);
        this.setResizable(false);

        //txt_up.addActionListener((e)->{txt_dwn.setText(caesarCode(txt_up.getText(), (char)cb.getSelectedItem()));});
        btn.addActionListener((e)->{txt_dwn.setText(caesarCode(txt_up.getText(), (char)cb.getSelectedItem()));});

        setLayout(new GridLayout(2,1));

        JPanel upper = new JPanel();
        JPanel lower = new JPanel();
        upper.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
        lower.setLayout(new BorderLayout(0,0));

        upper.add(cb);
        upper.add(txt_up);
        upper.add(btn);

        JLabel label = new JLabel("Output: ");
        lower.add(label, BorderLayout.WEST);
        txt_dwn.setEditable(false);
        lower.add(txt_dwn);

        add(upper);
        add(lower);

        this.setVisible(true);
    }

    private static String caesarCode(String input, char offset) {
        input = input.toUpperCase();
        String ret = "";
        int v26 = ('Z' - 'A' + 1);
        int offs = (offset - 'A');
        for (int i = 0; i < input.length(); i++) {
            int ch = (input.charAt(i) - 'A');
            ret += (char) (((ch + offs) % v26) + 'A');
        }
        return ret;
    }
}
