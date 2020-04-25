package selenium.utilities;
import java.awt.*; 
import java.awt.event.*; 
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import selenium.utilities.ConfigurationReader;
import com.sun.corba.se.impl.protocol.INSServerRequestDispatcher;

public class Gui extends JFrame implements ActionListener
{	
	//JPanel instan=new JPanel();
	ConfigurationReader conf=new ConfigurationReader("00_backup/ConfigurationFiles/configuration.properties");
	public static int instanceNo;
	JPanel filePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel mailPanel = new JPanel();
	JLabel sikuli = new JLabel("Sikuli Only");
	JComboBox sikuliOnly= new JComboBox();
	JLabel pname = new JLabel("Product Name");
	JTextField productName = new JTextField("EMS");
	JLabel ver = new JLabel("Version");
	JTextField version = new JTextField("2.1.0");
	JLabel buildno = new JLabel("Build No.");
	JTextField build = new JTextField("1722");
	JLabel mailHost= new JLabel("Mail Host");
	JTextField mailSenderHost = new JTextField("172.25.11.20");
	JLabel from=new JLabel("Mail from");
	JTextField mailFrom = new JTextField("EMS-QAT");
	JLabel to = new JLabel("Mail To");
	JTextField mailTo = new JTextField("agarg@safenet-inc.com");
	JLabel subject = new JLabel("Mail Subject");
	JTextField mailSubject = new JTextField("Selenium Reports");
	JLabel filePath = new JLabel("Ext. File Path");
	JTextField externalFilePath = new JTextField();
	JButton selectFile = new JButton("...");
	JFileChooser chooseFile = new JFileChooser();
	JButton mailOk= new JButton("OK");
	JButton mailCancel = new JButton("Cancel");
	JPanel[] multpanel;
	JLabel instance_no[];
	JTextField inputFile[];
	JTextField server_host[];
	JTextField ser_port[];
	JComboBox brow[];
	JTextField baseUrl[];
	JComboBox startup_mode[];
	JLabel input_File[];
	JLabel server_Label[];
	JLabel portLabel[];
	JLabel selectBrowser[];
	JLabel baseURL[];
	JLabel start_mode[];
	JButton nextInstance=new JButton("Next");
	JButton back = new JButton("back");
	JButton start_multiple=new JButton("Start");
	JFrame frame = new JFrame("Selenium Framework");
	JPanel finalPane = new JPanel();
	JPanel pane1= new JPanel();
	JLabel inst= new JLabel("Instance");
	JComboBox instances = new JComboBox();
	JLabel num = new JLabel("Total");
	JTextField number = new JTextField(20);
	JButton next = new JButton("Next");
	JLabel InputLabel = new JLabel("Input Files");
	JTextField inputFiles = new JTextField(20);
	JLabel serverLabel=new JLabel("Server Host");

	JTextField serverHost=new JTextField("localhost",20);
	JPanel pane = new JPanel();
	JLabel port=new JLabel("Server Port");
	JTextField serverPort=new JTextField("4444",10);
	JLabel browser = new JLabel("browser");
	
	JComboBox selBrowser=new JComboBox();
	JLabel url=new JLabel("Browser Base Url");
	JTextField browserUrl=new JTextField("https://10.162.104.204/ems",30);
	JLabel startup=new JLabel("Selenium Stratup mode");
	JComboBox mode=new JComboBox();
	JLabel sendMail = new JLabel("Send Mail");
	JButton mailProperties = new JButton("Mail Settings");
	JComboBox mailOptions=new JComboBox();
	
	JSeparator sep = new JSeparator();
	JButton pressme = new JButton("Start");
	public int total_instances;
	 
	  Gui()        // the frame constructor
	  {		 
	  
	  mailPanel.setLayout(null);
	  mailPanel.setLocation(10,0);
	  mailPanel.setSize(800,800);
	  pname.setLocation(50,50);
	  pname.setSize(120,20);
	  productName.setLocation(150,50);
	  productName.setSize(120,20);
	  ver.setLocation(50,100);
	  ver.setSize(120,20);
	  version.setLocation(150,100);
	  version.setSize(120,20);
	  buildno.setLocation(50,150);
	  buildno.setSize(120,20);
	  build.setLocation(150,150);
	  build.setSize(120,20);
	  mailHost.setLocation(50,200);
	  mailHost.setSize(120,20);
	  mailSenderHost.setLocation(150,200);
	  mailSenderHost.setSize(120,20);
	  from.setLocation(50,250);
	  from.setSize(120,20);
	  mailFrom.setLocation(150,250);
	  mailFrom.setSize(120,20);
	  to.setLocation(50,300);
	  to.setSize(120,20);
	  mailTo.setLocation(150,300);
	  mailTo.setSize(120,20);
	  subject.setLocation(50,350);
	  subject.setSize(120,20);
	  mailSubject.setLocation(150,350);
	  mailSubject.setSize(120,20);
	  filePath.setLocation(50,400);
	  filePath.setSize(120,20);
	  externalFilePath.setSize(120,20);
	  externalFilePath.setLocation(150,400);
	  selectFile.setLocation(300,400);
	  selectFile.setSize(40,20);
	  mailOk.setLocation(50,500);
	  mailOk.setSize(80,20);
	  mailCancel.setSize(80,20);
	  mailCancel.setLocation(150,500);
	  mailPanel.setVisible(false);
	  mailOk.addActionListener(this);
	  mailCancel.addActionListener(this);
	  mailPanel.add(pname);
	  mailPanel.add(productName);
	  mailPanel.add(ver);
	  mailPanel.add(version);
	  mailPanel.add(buildno);
	  mailPanel.add(build);
	  mailPanel.add(mailHost);
	  mailPanel.add(mailSenderHost);
	  mailPanel.add(from);
	  mailPanel.add(mailFrom);
	  mailPanel.add(to);
	  mailPanel.add(mailTo);
	  mailPanel.add(subject);
	  mailPanel.add(mailSubject);
	  mailPanel.add(filePath);
	  mailPanel.add(externalFilePath);
	  mailPanel.add(mailOk);
	  mailPanel.add(mailCancel);
	  selectFile.addActionListener(this);
	  mailPanel.add(selectFile);
	  
	  filePanel.add(chooseFile);
	  filePanel.setLayout(null);
	  filePanel.setSize(600,600);
	  filePanel.setLocation(10,0);
	  chooseFile.setLocation(10,0);
	  chooseFile.setSize(590,600);
	  chooseFile.addActionListener(this);
	  filePanel.setVisible(false);
		  
		  
		  
		  
		  
		  nextInstance.setLocation(50,0);
	  nextInstance.setSize(120,20);
	  
	  back.setLocation(200,0);
	  back.setSize(120,20);
	  back.setVisible(false);
	  start_multiple.setVisible(false);
	  start_multiple.setLocation(50,0);
	  start_multiple.setSize(120,20);
	  nextInstance.addActionListener(this);
	  back.addActionListener(this);
	  start_multiple.addActionListener(this);
	  buttonPanel.add(nextInstance);
	  buttonPanel.add(back);
	  buttonPanel.add(start_multiple);
	  buttonPanel.setLayout(null);
	  buttonPanel.setLocation(10,350);
	  buttonPanel.setSize(500,500);
	  buttonPanel.setVisible(false);
		  
		  	pane.setVisible(false);
		  	sikuli.setLocation(50,50);
		  	sikuli.setSize(120,20);
		  	sikuliOnly.addItem("no");
		  	sikuliOnly.addItem("yes");
		  	sikuliOnly.setLocation(150,50);
		  	sikuliOnly.setSize(120,20);
		  	sikuliOnly.addActionListener(this);
		  	instances.addItem("Single");
	  		instances.addItem("Multiple");
	  		instances.addActionListener(this);
	  		inst.setLocation(50,100);
	  		inst.setSize(120, 20);
		  	instances.setLocation(150,100);
		  	instances.setSize(120,20);
		  	num.setLocation(50,150);
		  	num.setSize(120,20);
		  	number.setLocation(150,150);
		  	number.setSize(120,20);
		  	num.setVisible(false);
		  	number.setVisible(false);
		  	next.setLocation(50,300);
		  	next.setSize(120,20);
		  	next.addActionListener(this);
		  	pane1.setLayout(null);
			InputLabel.setLocation(50,50);
		  	InputLabel.setSize(120,20);
		  	pane.setLocation(10,0);
		  	pane.setSize(500,500);
		  	selBrowser.addItem("*firefox");
		  	selBrowser.addItem("*iexplore");
		  	selBrowser.addItem("*googlechrome");
		  	mode.addItem("server");
		  	mode.addItem("grid");
		  	
		  	pane.setLayout(null);
		    
		  	pressme.addActionListener(this);
		  
		  	//InputLabel.setHorizontalAlignment(0);
		    pane.add(InputLabel);
		    inputFiles.setLocation(160,50);
		    //inputFiles.setHorizontalAlignment(0);
		    inputFiles.setSize(120,20);
		    pane.add(inputFiles);
		    serverLabel.setLocation(50,100);
		    serverLabel.setSize(120,20);
		     pane.add(serverLabel);
		    serverHost.setLocation(160,100);
		    serverHost.setSize(120,20);
		     pane.add(serverHost);
		    port.setLocation(50,150);
		    port.setSize(120,20);
		    pane.add(port);
		    serverPort.setLocation(160,150);
		    serverPort.setSize(120,20);
		    pane.add(serverPort);
		    browser.setLocation(50, 200);
		    browser.setSize(120,20);
		    pane.add(browser);
		    selBrowser.setLocation(160, 200);
		    selBrowser.setSize(120,20);
		    pane.add(selBrowser);
		    url.setLocation(50,250);
		    url.setSize(120,20);
		    pane.add(url);
		    browserUrl.setLocation(160,250);
		    browserUrl.setSize(120,20);
		    pane.add(browserUrl);
		    startup.setLocation(50,300);
		    startup.setSize(150,20);
		    pane.add(startup);
		    mode.setLocation(200,300);
		    mode.setSize(120,20);
		    pane.add(mode);
		    pressme.setLocation(50,350);
		    pressme.setSize(120,20);
		    pane.add(pressme);
		    pressme.requestFocus();
		  	mailOptions.addItem("yes");
		  	mailOptions.addItem("no");
		  	sendMail.setLocation(50,200);
		  	mailOptions.setLocation(150,200);
		  	mailOptions.addActionListener(this);
		  	sendMail.setSize(120,20);
		  	mailOptions.setSize(120,20);
		  	mailProperties.setLocation(50,250);
		  	mailProperties.setSize(120,20);
		  	mailProperties.addActionListener(this);
		  	pane1.setSize(500,500);
		  	pane1.setLocation(10, 0);
		  	pane1.add(sikuli);
		  	pane1.add(sikuliOnly);
		  	pane1.add(inst);
		  	pane1.add(instances);
		  	pane1.add(num);
		  	pane1.add(number);
		  	pane1.add(next);
		  	pane1.add(sendMail);
		  	pane1.add(mailOptions);
		  	pane1.add(mailProperties);
		    finalPane.add(mailPanel);
		  	finalPane.add(pane);
		    finalPane.add(pane1);
		    finalPane.add(buttonPanel);
		    finalPane.add(filePanel);
		    //finalPane.add(pane1);
		    pane1.setVisible(true);
		    finalPane.setLayout(null);
		    finalPane.setOpaque(true);
		    
		    // customize panel here
		    // pane.add(someWidget);
		    JFrame.setDefaultLookAndFeelDecorated(true);
	        

	        //Create and set up the content pane.
	        frame.getContentPane().add(finalPane);

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400,500);
	        frame.setVisible(true);
		     // display this frame
	  }
	  public void singleInstance()
	  {
			pane.setLocation(10,0);
		  	pane.setSize(500,500);
		  	
		    pane.setVisible(true);
	  }
	  public void singleInstanceSikuli()
	  {
		  pane.setLocation(10,0);
		  pane.setSize(500,500);
		  serverHost.setEnabled(false);
		  serverPort.setEnabled(false);
		  selBrowser.setEnabled(false);
		  browserUrl.setEnabled(false);
		  mode.setEnabled(false);
		  pane.setVisible(true);
	  }
	  public void multipleInstances(int instance)
	  {
		  multpanel[instance].setLocation(10,0);
		  multpanel[instance].setSize(500,500);
		  multpanel[instance].setLayout(null);
		 // multpanel[instance].setOpaque(true);
		  instance_no[instance]=new JLabel();
		  instance_no[instance].setLocation(50,10);
		  instance_no[instance].setSize(120,20);
		  int i = instance+1;
		  instance_no[instance].setText("Instance "+i);
		  inputFile[instance]=new JTextField();
		  inputFile[instance].setLocation(150,50);
		  inputFile[instance].setSize(120,20);
		  server_host[instance]=new JTextField("localhost");
		  //server_host[instance]=serverHost;
		  server_host[instance].setLocation(150, 100);
		  server_host[instance].setSize(120,20);
		  //server_host[instance].validate();
		  server_host[instance].setVisible(true);
		  ser_port[instance]=new JTextField("4444");
		  ser_port[instance].setLocation(150,150);
		  ser_port[instance].setSize(120,20);
		  brow[instance]=new JComboBox();
		  brow[instance].addItem("*firefox");
		  brow[instance].addItem("*iexplore");
		  brow[instance].addItem("*googlechrome");
		  brow[instance].setLocation(150,200);
		  brow[instance].setSize(120,20);
		  baseUrl[instance]=new JTextField("https://10.162.104.204/ems/");
		  baseUrl[instance].setLocation(150,250);
		  baseUrl[instance].setSize(120,20);
		  
		  startup_mode[instance]=new JComboBox();
		  startup_mode[instance].addItem("grid");
		  startup_mode[instance].addItem("server");
		  startup_mode[instance].setLocation(150,300);
		  startup_mode[instance].setSize(120,20);
		  input_File[instance] = new JLabel("Input Files");
		  input_File[instance].setLocation(50,50);
		  input_File[instance].setSize(120,20);
		  server_Label[instance]=new JLabel("Server Host");;
		  server_Label[instance].setLocation(50,100);
		  server_Label[instance].setSize(120,20);
		  portLabel[instance]=new JLabel("Server Port");
		  portLabel[instance].setSize(120,20);
		  portLabel[instance].setLocation(50,150);
		  selectBrowser[instance]=new JLabel("Browser");
		  selectBrowser[instance].setLocation(50,200);
		  selectBrowser[instance].setSize(120,20);
		  baseURL[instance]=new JLabel("Base URL");
		  baseURL[instance].setLocation(50,250);
		  baseURL[instance].setSize(120, 20);
		  start_mode[instance]=new JLabel("Startup Mode");
		  start_mode[instance].setLocation(50,300);
		  start_mode[instance].setSize(120,20);
		  multpanel[instance].add(instance_no[instance]);
		  multpanel[instance].add(inputFile[instance]);
		  multpanel[instance].add(server_host[instance]);
		  multpanel[instance].add(ser_port[instance]);
		  multpanel[instance].add(brow[instance]);
		  multpanel[instance].add(baseUrl[instance]);
		  multpanel[instance].add(startup_mode[instance]);
		  multpanel[instance].setVisible(false);
		  multpanel[instance].add(input_File[instance]);
		  multpanel[instance].add(server_Label[instance]);
		  multpanel[instance].add(portLabel[instance]);
		  multpanel[instance].add(selectBrowser[instance]);
		  multpanel[instance].add(baseURL[instance]);
		  multpanel[instance].add(start_mode[instance]);
		 
		
		  
		  
	  }
	  public void actionPerformed(ActionEvent event)
	  {
	    Object source = event.getSource();
	    
	    if(source==sikuliOnly)
	    {
	    	if(sikuliOnly.getSelectedItem().equals("yes"))
	    	{
	    		instances.setEnabled(false);
	    	}
	    	else
	    	{
	    		instances.setEnabled(true);
	    	}
	    }
	    if(source==mailOk)
	    {
	    	if(productName.getText().equals("")||version.getText().equals("")||build.getText().equals("")||mailSenderHost.getText().equals("")||mailFrom.getText().equals("")||mailTo.getText().equals("")||mailSubject.getText().equals(""))
	    	{
	    		JOptionPane.showMessageDialog(null,"One or more Field is Blank","Error",
  				      JOptionPane.ERROR_MESSAGE);
	    	}
	    	else
	    	{
	    	conf.setPropertyValue("productName",productName.getText());
	    	conf.setPropertyValue("version",version.getText());
	    	conf.setPropertyValue("build",build.getText());
	    	conf.setPropertyValue("mailSenderHost",mailSenderHost.getText());
	    	conf.setPropertyValue("maillFrom",mailFrom.getText());
	    	conf.setPropertyValue("mailTo",mailTo.getText());
	    	conf.setPropertyValue("mailSubject", mailSubject.getText());
	    	conf.setPropertyValue("externalFilePath",externalFilePath.getText());
	    	
	    	mailPanel.setVisible(false);
	    	pane1.setVisible(true);
	    	}
	    }
	    if(source==mailCancel)
	    {
	    	mailPanel.setVisible(false);
	    	pane1.setVisible(true);
	    }
	    if(source==selectFile)
	    {
	    	
	    	filePanel.setVisible(true);
	    	int status = chooseFile.showOpenDialog(null);
	    	
	    	if(status==chooseFile.APPROVE_OPTION)
	    	{
	    		File extFile=chooseFile.getSelectedFile();
	    		externalFilePath.setText(extFile.getAbsolutePath());
	    		filePanel.setVisible(false);
	    	}
	    	if(status == chooseFile.CANCEL_OPTION)
	    	{
	    		filePanel.setVisible(false);
	    	}
	    }
	    if(source==mailProperties)
	    {
	    	mailPanel.setVisible(true);
	    	pane1.setVisible(false);
	    }
	    if(source==mailOptions)
	    {
	    	if(mailOptions.getSelectedItem().equals("no"))
	    	{
	    		mailProperties.setVisible(false);
	    	}
	    	else
	    		mailProperties.setVisible(true);
	    }
	    if(source==instances)
	    {
	    	if(instances.getSelectedItem().equals("Multiple"))
	    	{
	    		num.setVisible(true);
	    		number.setVisible(true);
	    	}
	    	else
	    	{
	    		num.setVisible(false);
	    		number.setVisible(false);
	    	}
	    }
	    if(source==next)
	    {
	    	
	    	if(sikuliOnly.getSelectedItem().equals("yes"))
	    	{
	    		pane1.setVisible(false);
	    		conf.setPropertyValue("mailsend",(String) mailOptions.getSelectedItem());
	    		conf.setPropertyValue("sikuliOnly",sikuliOnly.getSelectedItem().toString());
	    		singleInstanceSikuli();
	    	}
	    	else if(instances.getSelectedItem().equals("Single"))
	    	{
	    		pane1.setVisible(false);
	    		conf.setPropertyValue("mailsend",(String) mailOptions.getSelectedItem());
	    		conf.setPropertyValue("sikuliOnly",sikuliOnly.getSelectedItem().toString());
	    		singleInstance();
	    	}
	    	else
	    	{
	    		if(number.getText().equals(""))
	    		{
	    			 JOptionPane.showMessageDialog(null,"Please enter total number of instances","Error",
	    				      JOptionPane.ERROR_MESSAGE);
	    		}
	    		
	    		else if((Integer.parseInt(number.getText()))<2)
	    		{
	    			JOptionPane.showMessageDialog(null,"Please enter value greater than one","Error",
	    				      JOptionPane.ERROR_MESSAGE);
	    		}
	    		else
	    		{
	    			pane1.setVisible(false);
	    			conf.setPropertyValue("mailsend",(String) mailOptions.getSelectedItem());
	    			conf.setPropertyValue("sikuliOnly",sikuliOnly.getSelectedItem().toString());
	    			total_instances=Integer.parseInt(number.getText());
	    			multpanel=new JPanel[total_instances];
	    			 instance_no=new JLabel[total_instances];
	    			 inputFile=new JTextField[total_instances];
	    			 server_host=new JTextField[total_instances];
	    			 ser_port=new JTextField[total_instances];
	    			 brow=new JComboBox[total_instances];
	    			 baseUrl=new JTextField[total_instances];
	    			 startup_mode=new JComboBox[total_instances];
	    			 input_File =new JLabel[total_instances];
	    			 server_Label=new JLabel[total_instances];
	    			 portLabel=new JLabel[total_instances];
	    			 selectBrowser=new JLabel[total_instances];
	    			 baseURL=new JLabel[total_instances];
	    			 start_mode=new JLabel[total_instances];
	    			 for(int i=0;i<total_instances;i++)
	    			 {
	    				 multpanel[i]=new JPanel();
	    				 multipleInstances(i);
	    				 finalPane.add(multpanel[i]);
	    				
	    				 
	    			 }
	    			buttonPanel.setVisible(true);
	    			multpanel[0].setVisible(true);
	    			instanceNo=0;
	    			
	    		}
	    	}
	    }
	    
	    if (source == pressme)
	    {
	    	
	      if(inputFiles.getText().equals("")||serverHost.getText().equals("")||serverPort.getText().equals("")||selBrowser.getSelectedItem().equals("")||browserUrl.getText().equals("")||mode.getSelectedItem().equals(""))
	      {
	      JOptionPane.showMessageDialog(null,"One or more Field is missing, Please enter again","Error",
	      JOptionPane.ERROR_MESSAGE); //setVisible(true);  // show something
	      }
	      else
	      {
	    	  conf.setPropertyValue("inputFiles",inputFiles.getText());
	    	  conf.setPropertyValue("serverHost",serverHost.getText());
	    	  conf.setPropertyValue("serverPort",serverPort.getText());
	    	  conf.setPropertyValue("browserURL",browserUrl.getText());
	    	  conf.setPropertyValue("selenium",mode.getSelectedItem().toString());
	    	  conf.setPropertyValue("browserStartCommand",selBrowser.getSelectedItem().toString());
	    	  try {
	    		 
					Runtime.getRuntime().exec("cmd.exe /c start ant run");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  
	      }
	      }
	    if(source==nextInstance)
	    {
	    	multpanel[instanceNo].setVisible(false);
	    	instanceNo++;
	    	multpanel[instanceNo].setVisible(true);
	    	if(instanceNo==(total_instances-1))
	    	{
	    		nextInstance.setVisible(false);
	    		start_multiple.setVisible(true);
	    	}
	    	back.setVisible(true);
	    }
	    if(source== start_multiple)
	    {
	    	int i;
	    	for( i=0;i<total_instances;i++)
	    	{	
	    		int j=i+1;
	    		if(ser_port[i].getText().equals("")||inputFile[i].getText().equals("")||baseUrl[i].getText().equals("")||server_host[i].getText().equals("")||brow[i].getSelectedItem().equals("")||startup_mode[i].getSelectedItem().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"One or More field in instance "+j+" is Blank","Error",
	    				      JOptionPane.ERROR_MESSAGE); 
	    			break;
	    		}
	    	}
	    	if(i==total_instances)
	    	for(i=0;i<total_instances;i++)
	    	{
	    		conf.setPropertyValue("serverPort",ser_port[i].getText());
	    		conf.setPropertyValue("inputFiles",inputFile[i].getText());
	    		conf.setPropertyValue("browserStartCommand", (String) brow[i].getSelectedItem());
	    		 conf.setPropertyValue("browserURL",baseUrl[i].getText());
		    	  conf.setPropertyValue("selenium",startup_mode[i].getSelectedItem().toString());
		    	  conf.setPropertyValue("serverHost",server_host[i].getText());
	    		try {
					Runtime.getRuntime().exec("cmd.exe /c start ant run");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    }
	    if(source==back)
	    {
	    	
	    	multpanel[instanceNo].setVisible(false);
	    	instanceNo--;
	    	multpanel[instanceNo].setVisible(true);
	    	nextInstance.setVisible(true);
	    	start_multiple.setVisible(false);
	    	if(instanceNo==0)
	    	{
	    		back.setVisible(false);
	    	}
	    }
	      
	  }
	  public static void main(String args[]) {
		  new Gui();
	}
}
