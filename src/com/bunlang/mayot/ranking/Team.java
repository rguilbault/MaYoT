/*
 * MaYoT : Manage Your Tournament
 * Copyright (C) 2015 - Ronan GUILBAULT
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.bunlang.mayot.ranking;

import org.apache.log4j.Logger;

import javax.swing.JPanel;

/** Manage a Team.
 *
 *  @author bunlanG
 */
public class Team implements Comparable<Team> {
    private static Logger logger = Logger.getLogger("com.bunlang.mayot");
    // Fields
    protected String _name;

    protected int _pTotal;
    protected int _mPlayed;
    protected int _sDiff;
    protected String _pos;

    protected int _mWins;
    protected int _mDraws;
    protected int _mLoses;
    protected int _pBonus;
    protected int _pFixer;
    protected int _sFor;
    protected int _sAgnst;

    protected TeamUI _ui;


    public Team(String name, int mWins, int mDraws, int mLoses, int pBonus, int pFixer, int sFor, int sAgnst) {
        _name = name;
        _mWins = 0;
        _mDraws = 0;
        _mLoses = 0;
        _pBonus = 0;
        _pFixer = 0;
        _sFor = 0;
        _sAgnst = 0;

        _ui = new TeamUI(this);

        this.updateAdd(mWins,mDraws,mLoses,pBonus,pFixer, sFor,sAgnst);

        if(logger.isDebugEnabled()) {
            logger.debug("ranking.Team created : " + this);
        }
    }

    /** Update all fields by adding all params to their linked fileds
     *
     * @param mWins
     * @param mDraws
     * @param mLoses
     * @param pBonus
     * @param pFixer
     * @param sFor
     * @param sAgnst
     */
    public void updateAdd(int mWins, int mDraws, int mLoses, int pBonus, int pFixer, int sFor, int sAgnst) {
        // Raw Fields
        _mWins += mWins;
        _mDraws += mDraws;
        _mLoses += mLoses;
        _pBonus += pBonus;
        _pFixer += pFixer;
        _sFor += sFor;
        _sAgnst += sAgnst;

        // Calculated Fields
        _pTotal =  3 * _mWins + _mDraws + _pBonus + _pFixer;
        _mPlayed = _mWins + _mDraws + _mLoses;
        _sDiff = _sFor - _sAgnst;
        _pos = ".";

        _ui.update();

        if(logger.isDebugEnabled()) {
            logger.debug("ranking.Team updated : " + this);
        }
    }

    @Override
    public int compareTo(Team t) {
        if(this.getPTotal() != t.getPTotal()) {
            return (t.getPTotal() - this.getPTotal());
        } else if(this.getSDiff() != t.getSDiff()){
            return (t.getSDiff() - this.getSDiff());
        } else {
            return (this.getName().compareTo(t.getName()));
        }
    }

    // Getters / Setters
    public String getPos() {
        return _pos;
    }

    public String getName() {
        return _name;
    }

    public int getPTotal() {
        return _pTotal;
    }

    public int getMPlayed() {
        return _mPlayed;
    }

    public int getMWins() {
        return _mWins;
    }

    public int getMDraws() {
        return _mDraws;
    }

    public int getMLoses() {
        return _mLoses;
    }

    public int getPBonus() {
        return _pBonus;
    }

    public int getPFixer() {
        return _pFixer;
    }

    public int getSFor() {
        return _sFor;
    }

    public int getSAgnst() {
        return _sAgnst;
    }

    public int getSDiff() {
        return _sDiff;
    }

    public JPanel getPanel() {
        return _ui.getPanel();
    }

    public String toString() {
        return _name + " | " + _pTotal + ':' + _mWins + '-' + _mDraws + '-' + _mLoses + " | " + _sFor + '-' + _sAgnst;
    }
}
