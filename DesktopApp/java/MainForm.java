import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;
public class MainForm {
    private JPanel mainPanel;
    private JTextArea surname;
    private JButton collapseButton;
    private JTextArea name;
    private JTextArea lastname;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel lastnameLabel;
    private JButton clearButton;
    private JLabel text;
    private JLabel text1;
    private JLabel text2;
    public JPanel getMainPanel() {
        return mainPanel;
    }
    public MainForm() {
        clearButton.addActionListener ( new Action () {
            @Override
            public Object getValue(String key) {
                return null;
            }
            @Override
            public void putValue(String key, Object value) {
            }
            @Override
            public void setEnabled(boolean b) {
            }
            @Override
            public boolean isEnabled() {
                return false;
            }
            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
            }
            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Objects.equals ( name.getText (), "" )) {
                    name.setText ( "" );
                    surname.setText ( "" );
                    lastname.setText ( "" );

                    if(Objects.equals ( name.getText (), "" ) || Objects.equals ( surname.getText (), "" ) || Objects.equals ( lastname.getText (), "" )) {
                        text.setText ( "Имя очищено" );
                        text1.setText ( "Фамилия очищена" );
                        text2.setText ( "Отчество очищено" );
                    }
                }

            }
        } );
        collapseButton.addActionListener(actionEvent -> {
            if (collapseButton.getText().equals("Collapse")) {
                if (name.getText().isEmpty() || surname.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Заполните имя и фамилию.");
                    text.setText ( "" );
                    text1.setText ( "" );
                    text2.setText ( "" );
                } else {
                    name.setVisible(false);
                    nameLabel.setVisible(false);
                    surname.setVisible(false);
                    surnameLabel.setVisible(false);
                    lastname.setSize(100, 50);
                    lastname.setText(collapseText ());
                    lastnameLabel.setText("Имя, " +
                            "Отчество, " +
                            " Фамилия");
                    collapseButton.setText("Expand");
                    text.setText ( "" );
                    text1.setText ( "" );
                    text2.setText ( "" );
                }
            } else if (collapseButton.getText().equals("Expand")) {
                var fio = lastname.getText().split("\n");
                if (fio.length > 3 ) {
                    text.setText ( "" );
                    text1.setText ( "" );
                    text2.setText ( "" );
                    JOptionPane.showMessageDialog(mainPanel, "Не более трёх слов (Фамилия и Имя, Отчество).");

                } else {
                    if (fio.length < 2) {
                        text.setText ( "" );
                        text1.setText ( "" );
                        text2.setText ( "" );
                        JOptionPane.showMessageDialog ( mainPanel, "Не менее двух слов (Фамилия и Имя, Отчество). Каждое слово с новой строки." );

                    } else {
                        int n = fio.length - 1;
                        lastname.setSize ( 100, -1 );
                        name.setText ( fio[0] );
                        surname.setText ( fio[n] );
                        lastname.setText ( "" );
                        if (fio.length == 3) {
                            lastname.setText ( fio[1] );
                        }
                        name.setVisible ( true );
                        nameLabel.setVisible ( true );
                        surname.setVisible ( true );
                        surnameLabel.setVisible ( true );
                        lastnameLabel.setText ( "Отчество" );
                        surnameLabel.setText ( "Фамилия" );
                        nameLabel.setText ( "Имя" );
                        collapseButton.setText ( "Collapse" );
                    }
                }
            }

        });
    }
    private String collapseText(){
        return name.getText() + "\n" + lastname.getText() + "\n" + surname.getText();
    }
    }