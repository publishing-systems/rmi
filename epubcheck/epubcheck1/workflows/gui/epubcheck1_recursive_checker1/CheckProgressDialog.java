/* Copyright (C) 2015  Stephan Kreutzer
 *
 * This file is part of epubcheck1_recursive_checker1 GUI.
 *
 * epubcheck1_recursive_checker1 GUI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License version 3 or any later version,
 * as published by the Free Software Foundation.
 *
 * epubcheck1_recursive_checker1 GUI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License 3 for more details.
 *
 * You should have received a copy of the GNU Affero General Public License 3
 * along with epubcheck1_recursive_checker1 GUI. If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * @file $/epubcheck/epubcheck1/workflows/gui/epubcheck1_recursive_checker1/CheckProgressDialog.java
 * @brief Shows progress of the epubcheck run.
 * @author Stephan Kreutzer
 * @since 2015-07-14
 */



import javax.swing.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import java.io.UnsupportedEncodingException;



public class CheckProgressDialog
  extends JDialog
{

    public CheckProgressDialog(JFrame parent)
    {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event)
            {
                event.getWindow().setVisible(false);
                event.getWindow().dispose();
                System.exit(2);
            }
        });

        JProgressBar pb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        pb.setIndeterminate(true);
        pb.setStringPainted(true);
        getContentPane().add(pb, BorderLayout.NORTH);

        setModalityType(ModalityType.TOOLKIT_MODAL);

        setTitle("Checking...");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(parent);
        setSize(200, 100);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
    }

    /**
     * @brief This method interprets i10n strings from a .properties file as encoded in UTF-8.
     */
   /*
    public String getI10nString(String key)
    {
        if (this.i10nGUI == null)
        {
            this.i10nGUI = ResourceBundle.getBundle("i10n.i10nCheckProgressDialogGUI", getLocale());
        }
    
        try
        {
            return new String(this.i10nGUI.getString(key).getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException ex)
        {
            return this.i10nGUI.getString(key);
        }
    }

    private ResourceBundle i10nGUI;
    */
}
