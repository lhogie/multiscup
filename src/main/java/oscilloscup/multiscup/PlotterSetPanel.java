/* (C) Copyright 2009-2013 CNRS (Centre National de la Recherche Scientifique).

Licensed to the CNRS under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The CNRS licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.

*/

/* Contributors:

Luc Hogie (CNRS, I3S laboratory, University of Nice-Sophia Antipolis) 

*/
 
 


package oscilloscup.multiscup;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Set;

import javax.swing.JPanel;

import oscilloscup.SwingPlotter;

class PlotterSetPanel extends JPanel
{
	public PlotterSetPanel()
	{
		setBackground(Color.white);
		setOpaque(true);
	}

	public void setPlotters(Set<SwingPlotter> plottersToShow)
	{
		setVisible(false);
		removeAll();
		int sz = plottersToShow.size();

		if (sz > 0)
		{
			final int nbCols = (int) Math.sqrt(sz);
			int nbRows = nbCols;

			if (nbCols * nbRows < sz)
			{
				++nbRows;
			}

			setLayout(new GridLayout(nbRows, nbCols));

			for (SwingPlotter p : plottersToShow)
			{
				add(p);
			}
		}

		setVisible(true);
		doLayout();
	}

}
