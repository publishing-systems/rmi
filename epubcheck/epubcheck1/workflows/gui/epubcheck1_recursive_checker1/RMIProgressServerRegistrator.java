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
 * @file $/epubcheck/epubcheck1/workflows/gui/epubcheck1_recursive_checker1/RMIProgressServerRegistrator.java
 * @brief Registers the RMIProgressServer.
 * @author Stephan Kreutzer
 * @since 2015-07-09
 */



import java.io.File;
import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.*;



public class RMIProgressServerRegistrator
{
    public RMIProgressServerRegistrator(epubcheck1_recursive_checker1 parent)
    {
        this.parent = parent;
    }

    public void register()
    {
        String programPath = RMIProgressServerRegistrator.class.getProtectionDomain().getCodeSource().getLocation().getFile();

        try
        {
            programPath = new File(programPath).getCanonicalPath() + File.separator;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            System.exit(-1);
        }

        System.setProperty("java.rmi.server.codebase", "file://" + programPath);
        System.setProperty("java.security.policy", "file://" + programPath + "rmi.policy");
        System.setSecurityManager(new SecurityManager());

        try
        {
            RMIProgressServer progressServer = new RMIProgressServer(this.parent);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", Registry.REGISTRY_PORT);
            registry.rebind("epubcheck1_recursive_checker1_gui_progress_server", progressServer);
        }
        catch (RemoteException ex)
        {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    private epubcheck1_recursive_checker1 parent;
}
