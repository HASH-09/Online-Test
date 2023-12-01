import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class Online_Test extends JFrame implements ActionListener {

    JLabel l;
    JRadioButton r[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int marks[] = new int[10];

    Online_Test(String str) {
        super(str);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            r[i] = new JRadioButton();
            add(r[i]);
            bg.add(r[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        r[0].setBounds(50, 80, 100, 20);
        r[1].setBounds(50, 110, 100, 20);
        r[2].setBounds(50, 140, 100, 20);
        r[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            marks[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = marks[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
        r[4].setSelected(true);
        if (current == 0) {
            l.setText("Que1: Which one among these is not a datatype");
            r[0].setText("int");
            r[1].setText("Float");
            r[2].setText("boolean");
            r[3].setText("char");
        }
        if (current == 1) {
            l.setText("Que2: Which class is available to all the class automatically");
            r[0].setText("Swing");
            r[1].setText("Applet");
            r[2].setText("Object");
            r[3].setText("ActionEvent");
        }
        if (current == 2) {
            l.setText("Que3: Which package is directly available to our class without importing it");
            r[0].setText("swing");
            r[1].setText("applet");
            r[2].setText("net");
            r[3].setText("lang");
        }
        if (current == 3) {
            l.setText("Que4: String class is defined in which package");
            r[0].setText("lang");
            r[1].setText("Swing");
            r[2].setText("Applet");
            r[3].setText("awt");
        }
        if (current == 4) {
            l.setText("Que5: Which institute is best for java coaching");
            r[0].setText("Utek");
            r[1].setText("Aptech");
            r[2].setText("SSS IT");
            r[3].setText("jtek");
        }
        if (current == 5) {
            l.setText("Que6: Which one among these is not a keyword");
            r[0].setText("class");
            r[1].setText("int");
            r[2].setText("get");
            r[3].setText("if");
        }
        if (current == 6) {
            l.setText("Que7: Which one among these is not a class ");
            r[0].setText("Swing");
            r[1].setText("Actionperformed");
            r[2].setText("ActionEvent");
            r[3].setText("Button");
        }
        if (current == 7) {
            l.setText("Que8: which one among these is not a function of Object class");
            r[0].setText("toString");
            r[1].setText("finalize");
            r[2].setText("equals");
            r[3].setText("getDocumentBase");
        }
        if (current == 8) {
            l.setText("Que9: which function is not present in Applet class");
            r[0].setText("init");
            r[1].setText("main");
            r[2].setText("start");
            r[3].setText("destroy");
        }
        if (current == 9) {
            l.setText("Que10: Which one among these is not a valid component");
            r[0].setText("JButton");
            r[1].setText("JList");
            r[2].setText("JButtonGroup");
            r[3].setText("JTextArea");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            r[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (r[1].isSelected());
        if (current == 1)
            return (r[2].isSelected());
        if (current == 2)
            return (r[3].isSelected());
        if (current == 3)
            return (r[0].isSelected());
        if (current == 4)
            return (r[2].isSelected());
        if (current == 5)
            return (r[2].isSelected());
        if (current == 6)
            return (r[1].isSelected());
        if (current == 7)
            return (r[3].isSelected());
        if (current == 8)
            return (r[1].isSelected());
        if (current == 9)
            return (r[2].isSelected());
        return false;

    }

    public static void main(String str[]) {
        new Online_Test("Online Test Of Java");
    }

}