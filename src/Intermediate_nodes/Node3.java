package Intermediate_nodes;

import Data.trans.acknowledgement;
import Receiver.Receiver;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.constants.Constants;
import com.sun.corba.se.impl.util.PackagePrefixChecker;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Node1.java
 *
 * Created on Jul 26, 2013, 6:23:18 PM
 */
/**
 *
 * @author Admin
 */
public class Node3 extends javax.swing.JFrame {
private Client ChatClient;
private ReadThread myRead=new ReadThread();
private String ServerName;
ServerSocket servsock;
 Socket sock;
 String name="node3";
 int filesize=9022386; // filesize temporary hardcoded
int bytesRead,rv=0;
int current = 0;
String str="D:\\temp.txt";
    /** Creates new form Node1 */
    public Node3() {
        initComponents();
        setSize(650, 550);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Node 3");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Intermediate nodes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(false);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Connect");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "File\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.black));
        jPanel2.setOpaque(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Incoming Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("Check true");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("Node 3");

        jButton1.setText("Send- ACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel1))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 580, 400));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tj/user/lightbackground.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-32, -10, 2490, 1100));

        setSize(new java.awt.Dimension(621, 472));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//       ChatClient=new Client();
//       ChatClient.start();
//         try {
//            sock = new Socket(Constants.NodeTwoIpAddress,2222);
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/false_data","root","admin");
            PreparedStatement check=con.prepareStatement("select * from full where passing='"+name+"'");
            ResultSet re=check.executeQuery();
            if(re.next())
            {
       //         JOptionPane.showMessageDialog(null, "you are in node 3 name section");
                jTextArea1.setText(re.getString("passing")+"\n"+re.getString("ip"));
                
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 try{
            
             Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/false_data","root","admin");
            PreparedStatement check=con.prepareStatement("select * from full");
            ResultSet re=check.executeQuery();
            while(re.next())
            {
//                JOptionPane.showMessageDialog(null, "you are in node 3 name section");
//                jTextArea1.setText(re.getString("passing")+"\n"+re.getString("ip"));
                String r=""+re.getString("filepath");
                 try
        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/false_data","root","admin");
//            PreparedStatement check=con.prepareStatement("select * from digitalsig ");
//            ResultSet re=check.executeQuery();
//            while(re.next())
//            {
                // JOptionPane.showMessageDialog(null, "JOptionPane.showMessageDialog(null, r);");
                // String r=""+re.getInt("id");
                //  JOptionPane.showMessageDialog(null, r);
//                String r=""+re.getString("dsfilelocation");
//                String filename=r;
                //        JFileChooser choose=new JFileChooser();
                //        choose.showOpenDialog(null);
                //        File f=choose.getSelectedFile();
                //        String filename=f.getAbsolutePath();
                try
                {
                    FileReader reader=new FileReader(r);
                    BufferedReader br=new BufferedReader(reader);
//                    BufferedReader m=br;
                    jTextArea1.read(br, null);
                    br.close();
                    jTextArea1.requestFocus();
                  //  jButton1.setVisible(true);
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
//            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
                       
                
                
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
       
        pass();
//fileRead();
//        datas();


        
    
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/false_data","root","admin");
            PreparedStatement check=con.prepareStatement("select * from digitalsig");
            ResultSet re=check.executeQuery();
        if(re.next())
        {
//            float s1=Float.parseFloat(re.getString("file_size"));
            String s1=""+re.getString("file_size");
          //  JOptionPane.showMessageDialog(null, s1);
            try{
        //        JOptionPane.showMessageDialog(null, "I am in try section");
             PreparedStatement check1=con.prepareStatement("select * from full");
            ResultSet re1=check1.executeQuery();

String s2=null;
            while(re1.next())
            {
//            s2=Float.parseFloat(re1.getString("filesize"));
               s2=""+re1.getString("filesize");
            }
         //   JOptionPane.showMessageDialog(null, s2);
            if(s1.equals(s2))
            {
                //JOptionPane.showMessageDialog(null, "true data");
         
                
            }
            else
            {
               //  JOptionPane.showMessageDialog(null, "false data");
                       JOptionPane.showMessageDialog(null, "false data", "Message", HEIGHT);
            }
        }catch(Exception e)
                {
              //  JOptionPane.showMessageDialog(null, e);
                }
        }
        
        }catch(Exception e)
        {
       //     JOptionPane.showMessageDialog(null, e);
        }
        
//         saveBtn();


         
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try
        {
        MisDetect_intermediatenodes m=new MisDetect_intermediatenodes();
        m.show();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private String storeAllString="";
    private void fileRead(){
        try{    
          FileReader read = new FileReader(str);
          Scanner scan = new Scanner(read);
             while(scan.hasNextLine()){
              String temp=scan.nextLine()+"\n";
              storeAllString=storeAllString+temp;
             }
             jTextArea1.setText(storeAllString);
      }
        catch (Exception exception)
         {
         exception.printStackTrace();
         }
    }   
    
    private void saveBtn(){
        File file = null;
        FileWriter out=null;


        try {
            file = new File(str);
            out = new FileWriter(file);     
            out.write(jTextArea1.getText());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Node3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Node3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Node3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Node3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Node3().setVisible(true);
            }
        });
    }

    private void pass() {
       
        
    }

  
       public class Client extends Thread {
        private static final int PORT=9999;
        private LinkedList Clients;
        private ByteBuffer ReadBuffer;
        private ByteBuffer writeBuffer;
        private SocketChannel SChan;
        private Selector ReadSelector;
        private CharsetDecoder asciiDecoder;
        
        public Client() {
            Clients=new LinkedList();
            ReadBuffer=ByteBuffer.allocateDirect(300);
            writeBuffer=ByteBuffer.allocateDirect(300);
            asciiDecoder = Charset.forName( "US-ASCII").newDecoder();
        }
        
        public void run() {
            
            ServerName=Constants.NodeTwoHostAddress;
            System.out.println(ServerName);
            
            
            Connect(ServerName);
            myRead.start();
            while (true) {
                
                ReadMassage();
                
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ie){
                }
            }
            
        }
        public void Connect(String hostname) {
            try {
                ReadSelector = Selector.open();
                InetAddress addr = InetAddress.getByName(hostname);
                SChan = SocketChannel.open(new InetSocketAddress(addr, PORT));
                SChan.configureBlocking(false);
                
                SChan.register(ReadSelector, SelectionKey.OP_READ, new StringBuffer());
            }
            
            catch (Exception e) {
            }
        }
        public void SendMassage(String messg) {
            prepareBuffer(messg);
            channelWrite(SChan);
        }
        
        
        public void prepareBuffer(String massg) {
            writeBuffer.clear();
            writeBuffer.put(massg.getBytes());
            writeBuffer.putChar('\n');
            writeBuffer.flip();
        }
        
        public void channelWrite(SocketChannel client) {
            long num=0;
            long len=writeBuffer.remaining();
            while(num!=len) {
                try {
                    num+=SChan.write(writeBuffer);
                    
                    Thread.sleep(5);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch(InterruptedException ex) {
                    
                }
                
            }
            writeBuffer.rewind();
        }
        
        public void ReadMassage() {
            
            try {
                
                ReadSelector.selectNow();
                
                Set readyKeys = ReadSelector.selectedKeys();
                
                Iterator i = readyKeys.iterator();
                
                while (i.hasNext()) {
                    
                    SelectionKey key = (SelectionKey) i.next();
                    i.remove();
                    SocketChannel channel = (SocketChannel) key.channel();
                    ReadBuffer.clear();
                    
                    
                    long nbytes = channel.read(ReadBuffer);
                    
                    if (nbytes == -1) {
                        jTextArea1.append("You logged out !\n");
                        channel.close();
                    } else {
                        
                        StringBuffer sb = (StringBuffer)key.attachment();
                        
                        ReadBuffer.flip( );
                        String str = asciiDecoder.decode( ReadBuffer).toString( );
                        sb.append( str );
                        ReadBuffer.clear( );
                        
                        
                        String line = sb.toString();
                        if ((line.indexOf("\n") != -1) || (line.indexOf("\r") != -1)) {
                            line = line.trim();
                            jTextArea1.setText("");
                            jTextArea1.append("> "+ line);
                            jTextArea1.append(""+'\n');
                             jLabel4.setText(line);
                            sb.delete(0,sb.length());
                        }
                    }
                }
            } catch (IOException ioe) {
            } catch (Exception e) {
            }
        }
    }
        class ReadThread extends Thread {
        public void run() {
            ChatClient.ReadMassage();
        }
    }
         public void sdata() {
        try {
while (true) {

                // sendfile
    String file=str;
                File myFile = new File(file);
                byte[] mybytearray = new byte[(int) myFile.length()];
                FileInputStream fis = new FileInputStream(myFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                bis.read(mybytearray, 0, mybytearray.length);
                OutputStream os = sock.getOutputStream();
                System.out.println("Sending...");
                JOptionPane.showMessageDialog(null, "Forwarding file.......");
                os.write(mybytearray, 0, mybytearray.length);
                os.flush();
                sock.close();
                
            }
        } catch (Exception e) {
        }

    }
//        public void save() throws IOException{
//    JFileChooser ch = new JFileChooser();
//    rv =ch.showSaveDialog(ch);
//     if (rv == JFileChooser.APPROVE_OPTION){
//                           str= ch.getSelectedFile().toString();
//                           System.out.println(" Path : "+str);
//                          jLabel4.setText(str);
//                        }   
//       
//    }
    
         
    public void datas()
    {
      
         try 
         {
    byte [] mybytearray  = new byte [filesize];
    InputStream is = sock.getInputStream();
    FileOutputStream fos = new FileOutputStream(str);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    bytesRead = is.read(mybytearray,0,mybytearray.length);
    current = bytesRead;

    
    do {
       bytesRead =
          is.read(mybytearray, current, (mybytearray.length-current));
       if(bytesRead >= 0) current += bytesRead;
    } while(bytesRead > -1);

    bos.write(mybytearray, 0 , current);
    bos.flush();

    bos.close();
    sock.close();
      System.out.println(" Received File ");
        Retrivingfiles file = new Retrivingfiles(str);
        String[] fileary = file.OpenFile();

        int i;
        for (i = 0; i < fileary.length; i++) {
            jTextArea1.append(fileary[i] + '\n');
            //System.out.println(fileary[i]);
        }
         
    }catch(Exception e)
    {
        e.printStackTrace();
        System.out.println(e);
    }}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
