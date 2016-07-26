package interface_utilisateur;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import databaseDAOs.DBConnection;

public class TaskPaneDriver {
	private static Connection c = null;

	public static void main(String[] args) {
		JXFrame frame = new JXFrame();
		JXPanel fileBrowser = new JXPanel(new CardLayout());

		JXPanel a = new JXPanel();
		a.setBackground(Color.WHITE);

		JXPanel b = new JXPanel();
		b.setBackground(Color.BLUE);

		fileBrowser.add(a);
		fileBrowser.add(b);

		JXButton buttonA = new JXButton("A");
		JXButton buttonB = new JXButton("B");

		// a container to put all JXTaskPane together
		JXTaskPaneContainer taskPaneContainer = new JXTaskPaneContainer();

		// create a first taskPane with common actions
		JXTaskPane actionPane = new JXTaskPane();
		actionPane.setTitle("Files and Folders");
		actionPane.setSpecial(true);
		actionPane.add(buttonA);
		actionPane.add(buttonB);

		// // actions can be added, a hyperlink will be created
		// Action renameSelectedFile = createRenameFileAction();
		// actionPane.add(renameSelectedFile);
		// actionPane.add(createDeleteFileAction());

		// add this taskPane to the taskPaneContainer
		taskPaneContainer.add(actionPane);

		// create another taskPane, it will show details of the selected file
		JXTaskPane details = new JXTaskPane();
		details.setTitle("Details");

		// add standard components to the details taskPane
		JLabel searchLabel = new JLabel("Search:");
		JTextField searchField = new JTextField("");
		details.add(searchLabel);
		details.add(searchField);

		taskPaneContainer.add(details);

		// put the action list on the left
		frame.add(taskPaneContainer, BorderLayout.EAST);

		// and a file browser in the middle
		frame.add(fileBrowser, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
		
		c = DBConnection.getConnection(); 
	}
}
