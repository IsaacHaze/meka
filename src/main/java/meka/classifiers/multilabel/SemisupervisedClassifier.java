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

package meka.classifiers.multilabel;

import weka.core.Instances;

/**
 *  SemisupervisedClassifier.java - An Interface for Multilabel Semisupervised Classifiers.
 *  This is an interface for multi-label semisupervised classificatation. For classifiers implementing this interface, the method setUnlabelledData(unlabeledInstances) will be called prior to buildClassifier(trainingInstances). Note that as of writing this comment, this is only the test data -- there is not yet any option for setting other unlabelled data -- although this is planned for future versions.
 *
 * 	@author 	Jesse Read (jesse@tsc.uc3m.es)
 * 	@version	January 2012
 */

public interface SemisupervisedClassifier {

	/**
	 *  Set Unlabelled Data - provide unlabelled data prior to calling buildClassifier(Instances).
	 *  @param	unlabeledInstances	Instances for which the true class labels are not available for each instance.
	 */
	void setUnlabelledData(Instances unlabeledInstances);
}
