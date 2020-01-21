package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import utils.ImageUtil;

public class MainView extends JFrame{
    private final String APP_TITILE = "Random Giải bóng đá chuyên Toán LTT";
    private final String APP_IMAGE = "D:\\Java\\random_app\\src\\main\\java\\images\\ball_icon.jpg";
    private final int INITIAL_PADDING_X = 150;
    private final int INITIAL_PADDING_Y = 50;
    private final int APP_WIDTH = 700;
    private final int APP_HEIGHT = 500;
    
    private JLabel lbInput;
    private JTextField tfInput;
    private JButton btEnter;
    private JLabel lbOutput;
    private JTextArea taOutput;
    private JButton btShuffle;
    private JLabel lbGroupA;
    private JLabel lbGroupB;
    private JTextArea taGroupA;
    private JTextArea taGroupB;

    private final Container conn = getContentPane();
    private final List<String> classes = new ArrayList<>();
    private final List<String> groupA = new ArrayList<>();
    private final List<String> groupB = new ArrayList<>();
    
    
    public MainView() {
        initComponents();
        initEvents();
    }
    
    public static void main(String[] args) {
        MainView main = new MainView();
        main.setVisible(true);
    }

    private void initComponents() {
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(ImageUtil.loadImage(APP_IMAGE));
        setSize(APP_WIDTH, APP_HEIGHT);
        setLocationRelativeTo(null);
        setTitle(APP_TITILE);
        
        conn.setBackground(Color.GRAY);
        conn.setLayout(null);
        
        setLbInputView();
        setTfInputView();
        setBtEnter();
        setLbOutputView();
        setTaOutputView();
        setBtShuffleView();
        setLbGroupAView();
        setLbGroupBView();
        
        conn.add(lbInput);
        conn.add(tfInput);
        conn.add(btEnter);
        conn.add(lbOutput);
        conn.add(taOutput);
        conn.add(btShuffle);
        conn.add(lbGroupA);
        conn.add(lbGroupB);
    }

    private void setLbInputView() {
        String inputText = "Nhập";
        
        lbInput = new JLabel();
        lbInput.setText(inputText);
        lbInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbInput.setBounds(INITIAL_PADDING_X, 
                INITIAL_PADDING_Y, 
                getPreWidth(lbInput), 
                getPreHeight(lbInput));
        
        lbInput.setSize(70, getPreHeight(lbInput));
    }

    private void setTfInputView() {
        tfInput = new JTextField();
        int width = 200;
        
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfInput.setColumns(1);
        tfInput.setText("");
        tfInput.setBounds(getX(lbInput) + getWidth(lbInput) + 20, 
                getY(lbInput), 
                width, 
                getHeight(lbInput));
        tfInput.setSize(width, getHeight(lbInput));
    }

    private void setBtEnter() {
        btEnter = new JButton();
        String text = "Enter";
        
        btEnter.setFocusPainted(false);
        btEnter.setText(text);
        btEnter.setFont(new Font("Tahoma", Font.BOLD, 18));
        btEnter.setBounds(getX(tfInput) + getWidth(tfInput) + 20, 
                getY(lbInput), 
                getPreWidth(btEnter), 
                getHeight(lbInput));
    }

    private void setLbOutputView() {
        lbOutput = new JLabel();
        String text = "Các lớp:";
        
        lbOutput.setText(text);
        lbOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbOutput.setBounds(INITIAL_PADDING_X, 
                getY(lbInput) + getHeight(lbInput) + 10, 
                getPreWidth(lbOutput), 
                getPreHeight(lbOutput));
        lbOutput.setSize(getWidth(lbInput), getPreHeight(lbOutput));
    }

    private void setTaOutputView() {
        taOutput = new JTextArea();
        
        taOutput.setEditable(false);
        taOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        taOutput.setText("");
        taOutput.setBounds(getX(lbOutput) + getWidth(lbOutput) + 20, 
                getY(lbOutput), 
                getWidth(tfInput), 
                getPreHeight(taOutput) * 2);
    }

    private void setBtShuffleView() {
        btShuffle = new JButton();
        String text = "RANDOM";
        
        btShuffle.setFocusPainted(false);
        btShuffle.setText(text);
        btShuffle.setFont(new Font("Tahoma", Font.BOLD, 18));
        btShuffle.setBounds((APP_WIDTH - getPreWidth(btShuffle)) / 2, 
                getY(lbOutput) + getHeight(lbOutput) + 70, 
                getPreWidth(btShuffle),
                getPreHeight(btShuffle));
    }

    private void setLbGroupAView() {
        String text = "Group A";
        lbGroupA = new JLabel();
        
        lbGroupA.setText(text);
        lbGroupA.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbGroupA.setBounds(100, 
                getY(btShuffle) + getHeight(btShuffle) + 10, 
                getPreWidth(lbGroupA), 
                getPreHeight(lbGroupA));
    }

    private void setLbGroupBView() {
        String text = "Group B";
        lbGroupB = new JLabel();
        
        lbGroupB.setText(text);
        lbGroupB.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbGroupB.setBounds((APP_WIDTH - getX(lbGroupA) - getPreWidth(lbGroupB)), 
                getY(btShuffle) + getHeight(btShuffle) + 10, 
                getPreWidth(lbGroupB), 
                getPreHeight(lbGroupB));
    }

    private int getPreWidth(Component component){
        return (int) component.getPreferredSize().getWidth();
    }
    
    private int getPreHeight(Component component){
        return (int) component.getPreferredSize().getHeight();
    }
    
    private int getWidth(Component component){
        return (int) component.getWidth();
    }
    
    private int getHeight(Component component){
        return (int) component.getHeight();
    }

    private int getX(Component component){
        return (int) component.getLocation().getX();
    }
    
    private int getY(Component component){
        return (int) component.getLocation().getY();
    }

    private void initEvents() {
        setTfInputEvents();
        setBtEnterEvents();
        setBtShuffleEvents();
    }

    private void setTfInputEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    inputNewClass();
                    tfInput.setText("");
                }
            }
            
        });
    }

    private void setBtEnterEvents() {
        btEnter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inputNewClass();
                tfInput.setText("");
            }
        });
    }

    private void setBtShuffleEvents() {
        btShuffle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                do{
                    groupA.clear();
                    groupB.clear();
                    
                    Collections.shuffle(classes);
                    for(int i = 0; i < classes.size() / 2; i++){
                        groupA.add(classes.get(i));
                        groupB.add(classes.get(i + classes.size() / 2));
                    }
                } while(groupA.contains("TK4") && !groupA.contains("TK5") 
                        || !groupA.contains("TK4") && groupA.contains("TK5"));
                
                setTaGroupAView();
                setTaGroupBView();
                
                conn.add(taGroupA);
                conn.add(taGroupB);
            }
        });
    }
    
    private void inputNewClass(){
        String newClass = tfInput.getText();
        classes.add(newClass);
        
        List<String> tmpList = new ArrayList<>(classes);
        if(tmpList.size() > 4){
            tmpList.set(4, "\n" + tmpList.get(4));
        }
        String classesOutput = String.join(", ", tmpList);
        taOutput.setText(classesOutput);
    }
    
    private void setTaGroupAView(){
        taGroupA = new JTextArea();
        String output = String.join("\n", groupA);
        
        taGroupA.setEditable(false);
        taGroupA.setFont(new Font("Tahoma", Font.BOLD, 18));
        taGroupA.setText(output);
        taGroupA.setBounds(getX(lbGroupA) + (getWidth(lbGroupA) - getPreWidth(taGroupA)) / 2, 
                getY(lbGroupA) + getHeight(lbGroupA) + 10, 
                getPreWidth(taGroupA), 
                getPreHeight(taGroupA));
    }
    
    private void setTaGroupBView(){
        taGroupB = new JTextArea();
        String output = String.join("\n", groupB);
        
        taGroupB.setEditable(false);
        taGroupB.setFont(new Font("Tahoma", Font.BOLD, 18));
        taGroupB.setText(output);
        taGroupB.setBounds(getX(lbGroupB) + (getWidth(lbGroupB) - getPreWidth(taGroupB)) / 2, 
                getY(lbGroupB) + getHeight(lbGroupB) + 10, 
                getPreWidth(taGroupB), 
                getPreHeight(taGroupB));
        
        taGroupB.setSize(getPreWidth(taGroupB), getPreHeight(taGroupB));
    }
}
