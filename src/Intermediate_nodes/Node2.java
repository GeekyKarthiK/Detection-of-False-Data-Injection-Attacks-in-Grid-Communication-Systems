package Intermediate_nodes;

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
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class Node2 extends javax.swing.JFrame {
private Client ChatClient;
private ReadThread myRead=new ReadThread();
private String ServerName;
ServerSocket servsock;
 Socket sock;
 int filesize=9022386; // filesize temporary hardcoded
int bytesRead,rv=0;
int current = 0;
String str="D:\\temp.txt";
    /** Creates new form Node1 */
    public Node2() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Node 2");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Intermediate nodes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Node ID: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("Node 2");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Connect");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Incoming Data Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jPanel2.setOpaque(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Incoming Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("i-Trust");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("Send File");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButton7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addContainerGap(334, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addContainerGap(349, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 500, 400);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pattern.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-20, -30, 560, 790);

        setSize(new java.awt.Dimension(544, 472));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//       ChatClient=new Client();
//       ChatClient.start();
         try {
            sock = new Socket(Constants.NodeTwoIpAddress,2222);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try {
          IncomingDataDetails in=new IncomingDataDetails();
          this.show();
//            IncomingDataDetails.datasend = str;
//            IncomingDataDetails.nodeName="Node2";
//            IncomingDataDetails inObj = new IncomingDataDetails();
        } catch (IOException ex) {
   //         Logger.getLogger(Node1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
   //     Logger.getLogger(Node2.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        datas();
    second s=new second();
    s.show();
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {     
        MisDetect_intermediatenodes.nodename="Node1";
        MisDetect_intermediatenodes s=new MisDetect_intermediatenodes();
        s.show();
        String action="Performing SACK";
            String nname="Node1";
            new logdetails(nname,action);
    } catch (SQLException ex) {
        Logger.getLogger(Node1.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
      
            
           try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/false_data","root","admin");
            PreparedStatement pre=con.prepareStatement("select * from node3");
             ResultSet re=pre.executeQuery();
            if(re.next())
            {
                 String m=""+re.getString("filepath");
                 String filesize=getfilesize(m);
        System.out.println("filesize = " +filesize+ " Mega Bytes[MB]");
        jLabel4.setText(""+filesize);
        PreparedStatement pre1=con.prepareStatement("update node3 set filesize='"+jLabel4.getText()+"'");
             int re3=pre1.executeUpdate();
            
            try{
                JOptionPane.showMessageDialog(null, "in passing ");
            PreparedStatement check=con.prepareStatement("select * from node3");
            ResultSet re2=check.executeQuery();
            if(re2.next())
            {
//                String name1=""+re.getString(name);
                JOptionPane.showMessageDialog(null, "I am in passing function");
                try{
                PreparedStatement check1=con.prepareStatement("insert into full ( filename, filepath, ip, filesize, source_name, passing) values ('"+re2.getString("filename")+"','d:\\\\\\\\"+re2.getString("filename")+"','"+re2.getString("ip")+"','"+re2.getString("filesize")+"','"+re2.getString("source_name")+"','node3')");
                int re1=check1.executeUpdate();
                if(re1>0)
                {
           //         JOptionPane.showMessageDialog(null, "values passed into full table");
                    System.out.println("Done");
                }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            
//            Class.forName("");
            
//           String file=jLabel3.getText();
//                        Retrivingfiles files = new Retrivingfiles(file);
//
//                        // Socket cli= new Socket("127.0.0.1",2222);
//                        Socket cli = new Socket(Constants.NodeOneIpAddress, 2222);
//
//                        System.out.println("Connection accepeted ...");
//                        System.out.println("access accepted ...");
//                        sdata();
//                      
//            

            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "File Not Found");
            }
             }       } catch (Exception e) {
                        System.out.println(e);
                    }
       
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Node2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Node2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Node2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Node2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Node2().setVisible(true);
            }
        });
    }

    private String getfilesize(String m) {
         File file=new File(m);
         BufferedReader reader=null;
         int charCount=0;
         int lineCount=0;
         int wordCount=0;
         String megabytes=null;
        if(!file.exists() || !file.isFile())
        {
            System.out.println("FileSize Doe's Not exist ");
            return null;
        }
        try
        {
             
            reader = new BufferedReader(new FileReader(m));
             
            String currentLine = reader.readLine();
             
            while (currentLine != null)
            {
                 
                lineCount++;
            
                String[] words = currentLine.split(" ");
                 
                //Updating the wordCount
                 
                wordCount = wordCount + words.length;
                 
                //Iterating each word
                 
                for (String word : words)
                {
                    //Updating the charCount
                     
                    charCount = charCount + word.length();
                }
                 
                //Reading next line into currentLine
                 
                currentLine = reader.readLine();
            }
             
            //Printing charCount, wordCount and lineCount
             
            System.out.println("Number Of Chars In A File : "+charCount);
            megabytes=""+charCount; 
            System.out.println("Number Of Words In A File : "+wordCount);
             
            System.out.println("Number Of Lines In A File : "+lineCount);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();           //Closing the reader
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        
        
//        float bytes=file.length();
//        float kilobytes=(bytes/1024);
//        float megebytes=(kilobytes/1024);


        return megabytes;
       
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
        
       try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/false_data","root","admin");
            PreparedStatement check=con.prepareStatement("select * from digitalsig");
            ResultSet re=check.executeQuery();
        if(re.next())
        {
            String s1=""+re.getString("file_size");
            JOptionPane.showMessageDialog(null, s1);
            try{
                JOptionPane.showMessageDialog(null, "I am in try section");
             PreparedStatement check1=con.prepareStatement("select * from full");
            ResultSet re1=check1.executeQuery();
            String s2=null;
            while(re1.next())
            {
            s2=""+re1.getString("filesize");
            }
            JOptionPane.showMessageDialog(null, s2);
            if(s1==s2)
            {
                JOptionPane.showMessageDialog(null, "Your File does not have any false data");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Your file has been affected");
            }
        }catch(Exception e)
                {
                JOptionPane.showMessageDialog(null, e);
                }
        }
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
      
//         try 
//         {
//    byte [] mybytearray  = new byte [filesize];
//    InputStream is = sock.getInputStream();
//    FileOutputStream fos = new FileOutputStream(str);
//    BufferedOutputStream bos = new BufferedOutputStream(fos);
//    bytesRead = is.read(mybytearray,0,mybytearray.length);
//    current = bytesRead;
//
//    
//    do {
//       bytesRead =
//          is.read(mybytearray, current, (mybytearray.length-current));
//       if(bytesRead >= 0) current += bytesRead;
//    } while(bytesRead > -1);
//
//    bos.write(mybytearray, 0 , current);
//    bos.flush();
//
//    bos.close();
//    sock.close();
//      System.out.println(" Received File ");
//        Retrivingfiles file = new Retrivingfiles(str);
//        String[] fileary = file.OpenFile();
//
//        int i;
//        for (i = 0; i < fileary.length; i++) {
//            jTextArea1.append(fileary[i] + '\n');
//            //System.out.println(fileary[i]);
//        }
//         
//    }catch(Exception e)
//    {
//        e.printStackTrace();
//        System.out.println(e);
//    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
