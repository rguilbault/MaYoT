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

package com.bunlang.mayot.scores;

/**
 *
 * @author bunlanG
 */

public class Team {
    // Fields
    protected int _score;
    protected com.bunlang.mayot.ranking.Team _teamRef;

    public Team(com.bunlang.mayot.ranking.Team teamRef) {
        init(teamRef, 0);
    }

    protected void init(com.bunlang.mayot.ranking.Team teamRef, int score) {
        _teamRef = teamRef;
        _score = score;
    }

    // Getters / Setters
    public int getScore() {
        return _score;
    }

    public String getTeamName() {
        return _teamRef.getName();
    }

    public void setScore(int score) {
        _score = score;
    }

    public void addToScore(int scoreOffset) {
        _score += scoreOffset;
    }
}