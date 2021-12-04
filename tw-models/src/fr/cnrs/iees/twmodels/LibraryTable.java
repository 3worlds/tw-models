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

import java.io.InputStream;

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
	/*-	Menu name,	|	ProposedName|	File name,	|	category, | dependency archive (*.zip)*/
	Template1("1 Blank", "Prj1", "Blank.utg", LibraryType.Template,null), //
	Template2("2 SimpleClock", "Prj1", "SimpleClock_1.utg", LibraryType.Template,null), //
	//
	Tut1("1 Logistic", "Logistic1", "Logistic_1.utg", LibraryType.Tutorial,null), //
	Tut2("2 LotkaVolterra", "LotkaVolterra1", "LotkaVolterra_1.utg", LibraryType.Tutorial,null), //
	Tut3("3 I.D.H.", "IdhClock1", "IdhClock.utg", LibraryType.Tutorial,null), //
	Tut4("4 Event timer","Pulse1","Pulse1.utg",LibraryType.Tutorial,null), //
	Tut5("5 Panmixia", "Panmixia1", "Panmixia.utg", LibraryType.Tutorial,null), //
	Tut6("6 Spatial", "Spatial1", "Spatial.utg", LibraryType.Tutorial,null), //
	Tut7("7 Boids", "Boids1", "Flock.utg", LibraryType.Tutorial,null), //
	Tut8("8 LittleForest", "LittleForest1", "LittleForest.utg", LibraryType.Tutorial,null), //
	Tut9("9 Headless(Logistic)", "Headless1", "LogisticHeadless.utg", LibraryType.Tutorial,null), //
	Tut10("10 Random number generators", "Rng1", "Rng_1.utg", LibraryType.Tutorial,null), //
	//
	Model1("1 Palms", "Palms1", "Palms.utg", LibraryType.Model,null), //
	Model2("2 Resproutch", "Resproutch1", "Resproutch.utg", LibraryType.Model,"Resproutch.zip"), //
	Model3("3 GDDM", "GDDM1", "CDU_GDDMdev.utg", LibraryType.Model, "CDU_GDDM.zip"), //
	//
	Test1("1 TestRelations", "TestRelations1", "TestRelations.utg", LibraryType.Test,null), //
	Test2("2 TestLifeCycle", "TestLifeCycle1", "TestLifeCycle.utg", LibraryType.Test,null), //
	Test3("3 TestXYPlot", "TestXYPlot1", "TestXYPlot.utg", LibraryType.Test,null), //
	Test4("4 ParallelTest (Logistic)", "Logistic1", "ParallelTestLogistic.utg", LibraryType.Test,null), //
	Test5("5 ParallelTest (Boids)", "Boids1", "ParallelTestBoids.utg", LibraryType.Test,null), //
	Test6("6 Timer test (clock/event)", "TimerTest1", "TimerTest.utg", LibraryType.Test,null), //
	Test7("7 Timer test (calendar time)", "TimerTest1", "TimerTestCalendarTime.utg", LibraryType.Test,null), //
	Test8("8 Landscape A", "LMA", "Ockham1.utg", LibraryType.Test,"Ockham1.zip"), //
	Test9("9 Landscape B", "LMB", "Ockham2.utg", LibraryType.Test,null), //
	Test10("10 Landscape C", "LMC", "Ockham3.utg", LibraryType.Test,null), //
	Test11("11 Landscape D", "LMD", "Ockham4.utg", LibraryType.Test,null), //
;

	private final String displayName;
	private final String proposedName;
	private final String fileName;
	private final LibraryType libraryType;
	private final String dependencyArchive;

	private LibraryTable(String displayName, String proposedName, String fileName, LibraryType lt,
			String dependencyArchive) {
		this.displayName = displayName;
		this.proposedName = proposedName;
		this.fileName = fileName;
		this.libraryType = lt;
		this.dependencyArchive = dependencyArchive;
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

	public InputStream dependencyArchive() {
		if (dependencyArchive == null)
			return null;
		Class<?> associatedClass;
		switch (libraryType) {
		case Template: {
			associatedClass = TemplatesDummy.class;
			break;
		}
		case Tutorial: {
			associatedClass = TutorialsDummy.class;
			break;
		}
		case Model: {
			associatedClass = ModelsDummy.class;
			break;
		}
		default: {
			associatedClass = TestsDummy.class;
			break;
		}

		}
		return  associatedClass.getResourceAsStream(dependencyArchive);
	}

	@SuppressWarnings("unchecked")
	public TreeGraph<TreeGraphDataNode, ALEdge> getGraph() {
		switch (libraryType) {
		case Template: {
			return (TreeGraph<TreeGraphDataNode, ALEdge>) GraphImporter.importGraph(fileName, TemplatesDummy.class);
		}
		case Tutorial: {
			return (TreeGraph<TreeGraphDataNode, ALEdge>) GraphImporter.importGraph(fileName, TutorialsDummy.class);
		}
		case Model: {
			return (TreeGraph<TreeGraphDataNode, ALEdge>) GraphImporter.importGraph(fileName, ModelsDummy.class);
		}
		default: {
			return (TreeGraph<TreeGraphDataNode, ALEdge>) GraphImporter.importGraph(fileName, TestsDummy.class);
		}
		}
	}

}
