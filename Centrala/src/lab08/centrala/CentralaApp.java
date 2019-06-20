package lab08.centrala;

import lab08.gazetomat.Gazetomat;
import lab08.gazetomat.Paper;

import javax.swing.*;
import javax.xml.ws.Endpoint;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class CentralaApp extends JFrame implements Runnable {

    private JPanel MainPanel;
    private JList<String> mainList;

    private DefaultListModel<String> listModel = new DefaultListModel<String>();

    private CentralaImpl centralaImpl;

    private ArrayList<String> frontArray = new ArrayList<String>();

    public CentralaApp() {
        super("Central");

        centralaImpl = new CentralaImpl();
        Endpoint.publish("http://localhost:8090/WS/Cent", centralaImpl);

        updateList();
        mainList.setModel(listModel);

        Thread thread = new Thread(this);
        thread.start();

        setMinimumSize(new Dimension(400,300));
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }


    private void updateList(){
        listModel.clear();
        frontArray.clear();
        for (Gazetomat gaz : centralaImpl.gazetomats){
            StringBuilder sb = new StringBuilder();
            sb.append(gaz.getId()).append(": ");
            for (Paper p : gaz.getItems()){
                sb.append(" ").append(p.getName()).append(" : ").append(p.getCount());
            }
            frontArray.add(sb.toString());
        }
        for (int i=0;i<frontArray.size();i++){
            listModel.addElement(frontArray.get(i));
        }
        System.out.println("Updating");
        mainList.setModel(listModel);
    }


    public static void main(String[] args) {
        new CentralaApp();
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(2000);
                for (Gazetomat g : centralaImpl.gazetomats){
                    centralaImpl.updateRequest(g.getId());
                }
                updateList();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
