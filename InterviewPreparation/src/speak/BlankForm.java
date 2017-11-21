package speak;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlankForm extends JPanel implements ActionListener{//, ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5528574480912963183L;
	private JPanel panel0, panelA, panelB, panelC, panelD;
	GridBagLayout layout;

	private static JFrame frame;
	private JCheckBox imp;
	private JLabel hindiLbl, write_HereLbl, engLbl, idLbl, idVal, totLbl,
			totVal, saveStatus;
	private JButton next, cancel, englBtn, saveBtn;
	private JTextArea hindiTA, engTA, writeHereTA;
	private static Map<Integer, String> hindiMap = new HashMap<Integer, String>();
	private static Map<Integer, String> engMap = new HashMap<Integer, String>();
	private static int cntr = 0;
	private static List<Integer> randList = new ArrayList<Integer>();
	
	//public static boolean isImpOnly;

	public static void main(String[] args)
	// public static void SplitWindow_form()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				getData(false);
				initializeRandom();
				form4SplitWindow();

			}
		});
	} // MAIN

	public static void form4SplitWindow() {
		try {
			
			//isImpOnly = imp;
			frame = new JFrame();
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setTitle("English Speak Practice Window");

			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setResizable(true);

			JComponent newContentPane = new BlankForm();

			newContentPane.setOpaque(true);
			frame.setContentPane(newContentPane);

			frame.pack();
			frame.setVisible(true);

		}// try
		catch (Exception e) {
			e.printStackTrace();
		}

	}// form4SplitWindow

	public BlankForm() {
		try {

			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			panel0 = new JPanel();
			layout = new GridBagLayout();
			panel0.setLayout(layout);
			panel0.setBackground(new Color(185, 185, 185));
			panel0.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createEtchedBorder(), "Give User's Info. "));

						// ////////////////////////////////////////////////////////////////////////

			panelA = new JPanel();
			GridBagLayout layout = new GridBagLayout();
			panelA.setLayout(layout);
			panelA.setBackground(new Color(185, 185, 185));
			panelA.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createEtchedBorder(), "Data"));

			idLbl = new JLabel("Id");
			idVal = new JLabel(randList.get(0).toString());

			totLbl = new JLabel("Total");
			String str = "Total Size = : " + new Integer(randList.size())
					+ " >> Seen = : " + new Integer(cntr + 1).toString();
			totVal = new JLabel(str);

			hindiLbl = new JLabel("Hindi");
			hindiTA = new JTextArea(5, 60);

			write_HereLbl = new JLabel("Write Here");
			writeHereTA = new JTextArea(5, 60);

			engLbl = new JLabel("English");
			engTA = new JTextArea(5, 60);
			saveStatus = new JLabel("");

			hindiTA.setText(hindiMap.get(randList.get(cntr)));
			engTA.setText(engMap.get(randList.get(cntr)));
			engTA.setForeground(Color.WHITE);
			
			
			
			
			engTA.setLineWrap(true);
			hindiTA.setLineWrap(true);
			writeHereTA.setLineWrap(true);
			writeHereTA.setWrapStyleWord(true);
			engTA.setWrapStyleWord(true);
			hindiTA.setWrapStyleWord(true);

			panelA.add(idLbl, new GBC(0, 0).setAnchor(GBC.EAST));
			panelA.add(idVal, new GBC(1, 0).setInsets(4));

			panelA.add(totLbl, new GBC(0, 1).setAnchor(GBC.EAST));
			panelA.add(totVal, new GBC(1, 1).setInsets(4));

			panelA.add(hindiLbl, new GBC(0, 2).setAnchor(GBC.EAST));
			panelA.add(hindiTA, new GBC(1, 2).setInsets(4));

			panelA.add(write_HereLbl, new GBC(0, 3).setAnchor(GBC.EAST));
			panelA.add(writeHereTA, new GBC(1, 3).setInsets(4));

			panelA.add(engLbl, new GBC(0, 4).setAnchor(GBC.EAST));
			panelA.add(engTA, new GBC(1, 4).setInsets(4));
			
			panelA.add(new JLabel("Dictionary"), new GBC(0, 5).setAnchor(GBC.EAST));
			panelA.add(new JTextField("http://www.shabdkosh.com/hi/translate?e=busted&l=hi"), new GBC(1, 5).setInsets(4));
			
			panelA.add(new JLabel("Translation"), new GBC(0, 6).setAnchor(GBC.EAST));
			panelA.add(new JTextField("http://translation2.paralink.com/Hindi-English-Translator"), new GBC(1, 6).setInsets(4));
			panelA.add(saveStatus, new GBC(1, 7).setInsets(4));
			//
			

			
			panelD = new JPanel();
			panelD.setBackground(new Color(185, 185, 185));

			next = new JButton("Next");
			next.setMnemonic(KeyEvent.VK_N);
			next.addActionListener(this);

			englBtn = new JButton("English");
			englBtn.setMnemonic(KeyEvent.VK_E);
			englBtn.addActionListener(this);

			cancel = new JButton("Cancel");
			cancel.setMnemonic(KeyEvent.VK_C);
			cancel.addActionListener(this);

			
			saveBtn = new JButton("Save");
			saveBtn.setMnemonic(KeyEvent.VK_S);
			saveBtn.addActionListener(this);

			panelD.add(panelA);
			panelD.add(next);
			panelD.add(englBtn);
			panelD.add(cancel);
			panelD.add(saveBtn);

			add(panelD);

		}// try
		catch (Exception e) {
			e.printStackTrace();
		}

	} // CONSTRUCTOR

	public void actionPerformed(ActionEvent evt)
	{

		String src = evt.getActionCommand();

		try {
			if (src.equals("Cancel")) {
				frame.dispose();
			}

			if (src.equals("English")) {
				if (engTA.getForeground() == Color.WHITE) {
					engTA.setForeground(Color.BLUE);
				} else {
					engTA.setForeground(Color.WHITE);
				}

			}
			
			if (src.equals("Save")) {
			
				System.out.println("save hit");
				String result = updateTable(idVal.getText(), hindiTA.getText(),engTA.getText(),writeHereTA.getText() );
				saveStatus.setText("Total Update = : "+result);
				saveStatus.setForeground(Color.BLUE);
			}

			if (src.equals("Next")) {
				++cntr;
				if (cntr >= engMap.size()) {
					cntr = 0;
				}
				Integer nextIdx = randList.get(cntr);
				idVal.setText(nextIdx.toString());

				String str = "Total Size = : " + new Integer(randList.size())
						+ " >> Seen = : " + new Integer(cntr + 1).toString();
				totVal.setText(str);

				hindiTA.setText(hindiMap.get(randList.get(cntr)));
				engTA.setText(engMap.get(randList.get(cntr)));
				engTA.setForeground(Color.WHITE);
				engTA.setLineWrap(true);
				hindiTA.setLineWrap(true);
				writeHereTA.setLineWrap(true);
				writeHereTA.setWrapStyleWord(true);
				engTA.setWrapStyleWord(true);
				hindiTA.setWrapStyleWord(true);
				writeHereTA.setText("");
				saveStatus.setText("");

			}
		}// try

		catch (Exception e) {
			e.printStackTrace();
		}

	}// AP

	private String updateTable(String id, String hinText, String engText, String writeHereText) {
		int affectedRow = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/speak", "root", "root");
			PreparedStatement update = connection.prepareStatement
				    ("UPDATE datatable SET english = ?, hindi = ?, writeHere = ? WHERE id = ?");

				int intId = new Integer(id).intValue();
				update.setString(1, engText);
				update.setString(2, hinText);
				update.setString(3, writeHereText);
				update.setInt(4, intId);

				affectedRow = update.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new Integer(affectedRow).toString();
	}

	public static void getData(boolean isImpOnly) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/speak", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet result = null;
			/*if(isImpOnly){
				System.out.println("249 executed");
				result = statement.executeQuery("select * from datatable where important = 1 and id >= 60 and required is NULL ");
			}else{
				System.out.println("252 executed");
				result = statement.executeQuery("select * from datatable where id >= 60 and required is NULL ");
			}
			*/

			result = statement.executeQuery("select * from datatable where id > 60  ");
			while (result.next()) {
				Integer id = result.getInt("id");
				String hin = result.getString("hindi");
				String eng = result.getString("english");
				String impStr = result.getString("important");
				//if (eng != null && eng.length() > 0) {
					hindiMap.put(id, hin);
					engMap.put(id, eng);
				//}
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Class Not Found! " + ex);
		} catch (SQLException exception) {
			System.out.println("SQL Error " + exception);
		}
	
	}// getData

	public static void initializeRandom() {
		/*for (int i = 0; i < engMap.size(); i++) {
			randList.add(i + 1);
		}*/
		
		for (Map.Entry<Integer, String> pair : engMap.entrySet()) {
			randList.add(pair.getKey());
		}

		
		Collections.shuffle(randList);
	

	}

	
} // CLASS SplitWindows

