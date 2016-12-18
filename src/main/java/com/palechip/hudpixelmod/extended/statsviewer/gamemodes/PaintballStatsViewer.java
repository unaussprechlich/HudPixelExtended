/*
 * HudPixelReloaded - License
 * <p>
 * The repository contains parts of Minecraft Forge and its dependencies. These parts have their licenses
 * under forge-docs/. These parts can be downloaded at files.minecraftforge.net.This project contains a
 * unofficial copy of pictures from the official Hypixel website. All copyright is held by the creator!
 * Parts of the code are based upon the Hypixel Public API. These parts are all in src/main/java/net/hypixel/api and
 * subdirectories and have a special copyright header. Unfortunately they are missing a license but they are obviously
 * intended for usage in this kind of application. By default, all rights are reserved.
 * The original version of the HudPixel Mod is made by palechip and published under the MIT license.
 * The majority of code left from palechip's creations is the component implementation.The ported version to
 * Minecraft 1.8.9 and up HudPixel Reloaded is made by PixelModders/Eladkay and also published under the MIT license
 * (to be changed to the new license as detailed below in the next minor update).
 * <p>
 * For the rest of the code and for the build the following license applies:
 * <p>
 * # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
 * #  HudPixel by PixelModders, Eladkay & unaussprechlich is licensed under a Creative Commons         #
 * #  Attribution-NonCommercial-ShareAlike 4.0 International License with the following restrictions.  #
 * #  Based on a work at HudPixelExtended & HudPixel.                                                  #
 * # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
 * <p>
 * Restrictions:
 * <p>
 * The authors are allowed to change the license at their desire. This license is void for members of PixelModders and
 * to unaussprechlich, except for clause 3. The licensor cannot revoke these freedoms in most cases, as long as you follow
 * the following license terms and the license terms given by the listed above Creative Commons License, however in extreme
 * cases the authors reserve the right to revoke all rights for usage of the codebase.
 * <p>
 * 1. PixelModders, Eladkay & unaussprechlich are the authors of this licensed material. GitHub contributors are NOT
 * considered authors, neither are members of the HudHelper program. GitHub contributers still hold the rights for their
 * code, but only when it is used separately from HudPixel and any license header must indicate that.
 * 2. You shall not claim ownership over this project and repost it in any case, without written permission from at least
 * two of the authors.
 * 3. You shall not make money with the provided material. This project is 100% non commercial and will always stay that
 * way. This clause is the only one remaining, should the rest of the license be revoked. The only exception to this
 * clause is completely cosmetic features. Only the authors may sell cosmetic features for the mod.
 * 4. Every single contibutor owns copyright over his contributed code when separated from HudPixel. When it's part of
 * HudPixel, it is only governed by this license, and any copyright header must indicate that. After the contributed
 * code is merged to the release branch you cannot revoke the given freedoms by this license.
 * 5. If your own project contains a part of the licensed material you have to give the authors full access to all project
 * related files.
 * 6. You shall not act against the will of the authors regarding anything related to the mod or its codebase. The authors
 * reserve the right to take down any infringing project.
 */

package com.palechip.hudpixelmod.extended.statsviewer.gamemodes;

import com.palechip.hudpixelmod.extended.statsviewer.msc.AbstractStatsViewer;

import java.util.UUID;

public class PaintballStatsViewer extends AbstractStatsViewer {

    /*
     *Lets add some static finals. Players love static finals.
     */
    private static final String KILLS = D_GRAY + " [" + GRAY + "⚔" + D_GRAY + "] ";
    private static final String DEATHS = D_GRAY + " [" + GRAY + "☠" + D_GRAY + "] ";
    private static final String WINS = D_GRAY + " [" + GRAY + "Wins" + D_GRAY + "] ";
    private static final String KD = D_GRAY + " [" + GRAY + "K/D" + D_GRAY + "] ";
    private static final String SHOTS = D_GRAY + " [" + GRAY + "Shots" + D_GRAY + "] ";
    private static final String ENDURANCE = D_GRAY + " [" + GRAY + "E" + D_GRAY + "] ";
    private static final String GODFATHER = D_GRAY + " [" + GRAY + "G" + D_GRAY + "] ";
    private static final String FORTUNE = D_GRAY + " [" + GRAY + "F" + D_GRAY + "] ";
    private static final String HEADSTART = D_GRAY + " [" + GRAY + "H" + D_GRAY + "] ";
    private static final String SUPERLUCK = D_GRAY + " [" + GRAY + "L" + D_GRAY + "] ";
    //lets get some variables in here
    private int kills;
    private int deaths;
    private int wins;
    private int shots;
    private int endurance, godfather, fortune, headstart, superluck;
    private double kd;


    public PaintballStatsViewer(UUID uuid, String statsName) {
        super(uuid, statsName);
    }

    private void generateRenderList() {
        renderList.add(ENDURANCE + GOLD + endurance + FORTUNE + GOLD + fortune + HEADSTART + GOLD + headstart + SUPERLUCK + GOLD + superluck + GODFATHER + GOLD + godfather);
        renderList.add(KILLS + GOLD + kills + DEATHS + GOLD + deaths + KD + GOLD + kd);
        renderList.add(WINS + GOLD + wins + SHOTS + GOLD + shots);
    }

    @Override
    protected void composeStats() {
        this.kills = getInt("kills");
        this.deaths = getInt("deaths");
        this.shots = getInt("shots_fired");
        this.wins = getInt("wins");
        this.endurance = getInt("endurance");
        this.godfather = getInt("godfather");
        this.fortune = getInt("fortune");
        this.superluck = getInt("superluck");
        this.headstart = getInt("headstart");

        kd = calculateKD(kills, deaths);

        generateRenderList();

    }
}
