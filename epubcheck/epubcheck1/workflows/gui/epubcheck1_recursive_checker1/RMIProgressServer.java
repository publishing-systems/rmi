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
 * @file $/epubcheck/epubcheck1/workflows/gui/epubcheck1_recursive_checker1/RMIProgressServer.java
 * @brief Provides the RMI server implementation for the workflow to notify the GUI about a change in progress state.
 * @author Stephan Kreutzer
 * @since 2015-07-09
 */



import java.rmi.*;
import java.rmi.server.*;
import javax.swing.JOptionPane;



public class RMIProgressServer
  extends UnicastRemoteObject
  implements RMIProgressServerInterface
{
    public RMIProgressServer(epubcheck1_recursive_checker1 parent)
      throws RemoteException
    {
        this.parent = parent;
        this.count = 0;
    }
    
    public void notifyProgressChange(String changeInfo)
      throws RemoteException
    {
        this.count += 1;

        this.parent.updateProgress(changeInfo, this.count);
    }

    private epubcheck1_recursive_checker1 parent;
    private int count;
}
