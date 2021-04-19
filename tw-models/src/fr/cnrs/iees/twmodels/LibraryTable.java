/**************************************************************************
 *  TW-MODELS - 3Worlds model library                                     *
 *                                                                        *
 *  Copyright 2018: Shayne Flint, Jacques Gignoux & Ian D. Davies         *
 *       shayne.flint@anu.edu.au                                          * 
 *       jacques.gignoux@upmc.fr                                          *
 *       ian.davies@anu.edu.au                                            * 
 *                                                                        *
 *  TW-MODELS is a library published models, tutorials and test cases     *
 *                                                                        *
 **************************************************************************                                       
 *  This file is part of TW-MODELS (3Worlds model library).               *
 *                                                                        *
 *  TW-MODELS is free software: you can redistribute it and/or modify     *
 *  it under the terms of the GNU General Public License as published by  *
 *  the Free Software Foundation, either version 3 of the License, or     *
 *  (at your option) any later version.                                   *
 *                                                                        *
 *  TW-MODELS is distributed in the hope that it will be useful,          *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *  GNU General Public License for more details.                          *                         
 *                                                                        *
 *  You should have received a copy of the GNU General Public License     *
 *  along with TW-MODELS.                                                 *
 *  If not, see <https://www.gnu.org/licenses/gpl.html>                   *
 *                                                                        *
 **************************************************************************/

package fr.cnrs.iees.twmodels;

import fr.cnrs.iees.twmodels.models.*;
import fr.cnrs.iees.twmodels.templates.*;
import fr.cnrs.iees.twmodels.tests.*;
import fr.cnrs.iees.twmodels.tutorials.*;
import fr.cnrs.iees.graph.impl.ALEdge;
import fr.cnrs.iees.graph.impl.TreeGraph;
import fr.cnrs.iees.graph.impl.TreeGraphDataNode;
import fr.cnrs.iees.graph.io.GraphImporter;

/**
 * A lookup enum for entries in ModelMaker "New" menu. Display order is the
 * declaration order in this enum. Entries are grouped as either a Template,
 * Tutorial or Model with utg files placed in the appropriate package.
 * 
 * This whole system can be moved to TW-APPS.
 */
/**
 * @author Ian Davies
 *
 * @date 11 Nov. 2020
 * 
 */
public enum LibraryTable {
	/*-	Menu name,	|	ProposedName|	File name,	|	category,	|package file association */
	Template1("1 Blank", "Prj1", "Blank.utg", LibraryType.Template, TemplatesDummy.class), //
	Template2("2 SimpleClock", "Prj1", "SimpleClock_1.utg", LibraryType.Template, TemplatesDummy.class), //
	//
	Tut1("1 Logistic", "Logistic1", "Logistic_1.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut2("2 LotkaVolterra", "LotkaVolterra1", "LotkaVolterra_1.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut3("3 I.D.H.(clock)", "IdhClock1", "IdhClock.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut4("4 I.D.H.(event)", "IdhEvent1", "IdhEvent.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut5("5 Panmixia", "Panmixia1", "Panmixia.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut6("6 Spatial", "Spatial1", "Spatial.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut7("7 Boids", "Boids1", "Flock.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut8("8 LittleForest", "LittleForest1", "LittleForest.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut9("9 Headless(Logistic)", "Headless1", "LogisticHeadless.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	Tut10("10 Random number generators", "Rng1", "Rng_1.utg", LibraryType.Tutorial, TutorialsDummy.class), //
	//
	Model1("1 Palms", "Palms1", "Palms.utg", LibraryType.Model, ModelsDummy.class), //
	Model2("2 Resproutch", "Resproutch1", "Resproutch.utg", LibraryType.Model, ModelsDummy.class), //
	//
	Test1("1 TestRelations", "TestRelations1", "TestRelations.utg", LibraryType.Test, TestsDummy.class), //
	Test2("2 TestLifeCycle", "TestLifeCycle1", "TestLifeCycle.utg", LibraryType.Test, TestsDummy.class), //
	Test3("3 WrapTest", "WrapTest1", "WrapTest.utg", LibraryType.Test, TestsDummy.class), //
	Test4("4 TestXYPlot", "TestXYPlot1", "TestXYPlot.utg", LibraryType.Test, TestsDummy.class), //
	Test5("5 ParallelTest (Palms)", "Palms1", "ParallelTestPalms.utg", LibraryType.Test, TestsDummy.class), //
	Test6("6 ParallelTest (Logistic)", "Logistic1", "ParallelTestLogistic.utg", LibraryType.Test, TestsDummy.class), //
	Test7("7 ParallelTest (Boids)", "Boids1", "ParallelTestBoids.utg", LibraryType.Test, TestsDummy.class), //
	Test8("8 ParallelTest (LittleForest)", "LittleForest1", "ParallelTestLittleForest.utg", LibraryType.Test,
			TestsDummy.class), //
	Test9("9 Animal (Table)", "AnimalT1", "CDU_AnimalT1.utg", LibraryType.Test, TestsDummy.class), //
	Test10("10 Animal (Continuous Space)", "AnimalC1", "CDU_AnimalC1.utg", LibraryType.Test, TestsDummy.class), //
//	Test11("11 Animal (Dist.)", "AnimalDist1", "CDU_Demography_Disturbance1.utg", LibraryType.Test, TestsDummy.class,
//			"SquarePatterns.jav"), //

	;

// NB File dependencies e.g SquarePatterns.jav is not implemented yet.
	private final String displayName;
	private final String proposedName;
	private final String fileName;
	private final LibraryType libraryType;
	private final Class<?> pkclass;
	/**
	 * TODO: Just an idea for java, jar and data(?) file dependencies:
	 * 
	 * If java file, parse the package name to prepend code.<system id> and create
	 * dir and place there?
	 * 
	 * Java files will produce a compile error (within the tw-models library if they
	 * have dependencies so the file must be renamed: suggest *.jav.
	 * 
	 * If *.jar we know how to handle that (I think we just add it to the compile
	 * tree.)
	 * 
	 * Otherwise assume its data and put in some fixed location?? Should there ever
	 * be data for ModelMaker? What would it be used for at Model configure time.
	 * Data seems only necessary for RunTime? Take care not to confound these two
	 * things.
	 * 
	 * Alternatively, these string elements could be a DB query?
	 */

	private final String[] depFiles;

	private LibraryTable(String displayName, String proposedName, String fileName, LibraryType lt, Class<?> pkclass,
			String... depFiles) {
		this.displayName = displayName;
		this.proposedName = proposedName;
		this.fileName = fileName;
		this.libraryType = lt;
		this.pkclass = pkclass;
		this.depFiles = depFiles;
	}

	public String displayName() {
		return displayName;
	}

	public String proposedName() {
		return proposedName.replaceAll("_", "");
	}

	public LibraryType libraryType() {
		return libraryType;
	}

	public String[] depFiles() {
		return depFiles;
	}

	@SuppressWarnings("unchecked")
	public TreeGraph<TreeGraphDataNode, ALEdge> getGraph() {
		return (TreeGraph<TreeGraphDataNode, ALEdge>) GraphImporter.importGraph(fileName, pkclass);

	}

}
