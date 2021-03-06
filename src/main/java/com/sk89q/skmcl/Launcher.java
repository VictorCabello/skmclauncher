/*
 * SK's Minecraft Launcher
 * Copyright (C) 2010, 2011 Albert Pham <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.skmcl;

import com.sk89q.skmcl.swing.SwingHelper;
import com.sk89q.skmcl.profile.ProfileManager;
import com.sk89q.skmcl.swing.CreateProfileDialog;
import com.sk89q.skmcl.swing.LauncherFrame;
import com.sk89q.skmcl.swing.SelectProfileTypeDialog;
import com.sk89q.skmcl.util.SharedLocale;
import lombok.Getter;
import lombok.NonNull;

import java.awt.*;
import java.io.File;
import java.util.Locale;

/**
 * Main launcher class.
 */
public class Launcher {

    @Getter
    private final File baseDir;
    @Getter
    private final ProfileManager profiles;

    public Launcher(@NonNull File baseDir) {
        this.baseDir = baseDir;
        this.profiles = new ProfileManager(baseDir);
    }

    public LauncherFrame showLauncher() {
        LauncherFrame frame = new LauncherFrame(this);
        frame.setVisible(true);
        return frame;
    }

    public SelectProfileTypeDialog showCreateProfile(Window owner) {
        SelectProfileTypeDialog dialog = new SelectProfileTypeDialog(owner, this);
        dialog.setVisible(true);
        return dialog;
    }

    public CreateProfileDialog showCreateRegularProfile(Window owner) {
        CreateProfileDialog dialog = new CreateProfileDialog(owner, this);
        dialog.setVisible(true);
        return dialog;
    }

    public static void main(String[] args) {
        SharedLocale.loadBundle("lang.Launcher", Locale.getDefault());
        SwingHelper.setLookAndFeel();

        File dir = new File(".");
        new Launcher(dir).showLauncher();
    }

}
