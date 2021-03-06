/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package meka.classifiers.multitarget;

/**
 * CC.java - Multi-target version of Classifier Chains (CC).
 * Only the confidence information is different, since multi-target implies a multi-dimensional posterior distribution.
 *
 * @see 	meka.classifiers.multilabel.CC
 * @author 	Jesse Read 
 * @version	Jan 2012
 */
import java.util.Arrays;

import meka.classifiers.multilabel.MultilabelClassifier;
import weka.core.Instance;
import weka.classifiers.trees.J48;
import weka.core.RevisionUtils;

public class CC extends meka.classifiers.multilabel.CC implements MultiTargetClassifier {

	/** for serialization. */
	private static final long serialVersionUID = 2395428645144026318L;

	public CC() {
		// default classifier for GUI
		this.m_Classifier = new J48();
	}

	@Override
	protected String defaultClassifierString() {
		// default classifier for CLI
		return "weka.classifiers.trees.J48";
	}

	/**
	 * Description to display in the GUI.
	 * 
	 * @return		the description
	 */
	@Override
	public String globalInfo() {
		return 
				"The Classifier Chains (CC) method.\n"
				+ "Multi-target version of CC (directly applicable, but the posterior distribution is multidimensional (may help ensemble performance)).";
	}

	@Override
	public double[] distributionForInstance(Instance x) throws Exception {
		int L = x.classIndex();
		double y_long[] = Arrays.copyOf(super.distributionForInstance(x),L*2);
		Arrays.fill(y_long,L,y_long.length,1.0);
		return y_long;
	}

	@Override
	public String getRevision() {
	    return RevisionUtils.extract("$Revision: 9117 $");
	}

	public static void main(String args[]) {
		MultilabelClassifier.evaluation(new meka.classifiers.multitarget.CC(),args);
	}
}
