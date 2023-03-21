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
import fr.cnrs.iees.omugi.graph.impl.*;
import fr.cnrs.iees.omugi.graph.io.GraphImporter;

/**
 * A lookup table for entries in ModelMaker "New" menu.
 * <p>
 * The menu display order is the declaration order in this enum. Entries are
 * grouped as either a Template, Tutorial, Model or Test with utg and other
 * dependencies in the form of a single zip file placed in the appropriate
 * package.
 * 
 * @author Ian Davies - 11 Nov. 2020
 * 
 */
public enum LibraryTable {
	/*-	Menu name,	|	ProposedName|	File name,	|	category, | dependency archive (*.zip)*/
	/**
	 * A starting point for any model development.
	 */
	Template1("1 Blank", "Prj1", "Blank.utg", LibraryType.Template, null), //
	/**
	 * A starting point for any model the requires a {@code Clock} timer model.
	 */
	Template2("2 SimpleClock", "Prj1", "SimpleClock_1.utg", LibraryType.Template, null), //
	//
	/**
	 * The simplest possible model in 3Worlds that contains one driver, one constant
	 * and one process.
	 */
	Tut1("1 Logistic", "Logistic1", "Logistic_1.utg", LibraryType.Tutorial, null), //
	/**
	 * Lotka-Volterra tutorial introducing tables.
	 */
	Tut2("2 LotkaVolterra", "LotkaVolterra1", "LotkaVolterra_1.utg", LibraryType.Tutorial, null), //
	/**
	 * Intermediate disturbance hypothesis - using a disturbance category.
	 */
	Tut3("3 I.D.H.", "IdhClock1", "IdhClock.utg", LibraryType.Tutorial, null), //
	/**
	 * Non-spatial event driven example
	 */
	Tut4("4 Event timer 1", "PulseNS1", "EventDrivenIBMNonSpatial.utg", LibraryType.Tutorial, null), //
	/**
	 * Spatial event driven example
	 */
	Tut5("5 Event timer 2", "PulseS1", "EventDrivenIBMSpatial.utg", LibraryType.Tutorial, null), //
	/**
	 * Non-spatial IBM with mating.
	 */
	Tut6("6 Panmixia", "Panmixia1", "Panmixia.utg", LibraryType.Tutorial, null), //
	/**
	 * Test of spatial concepts.
	 */
	Tut7("7 Spatial", "Spatial1", "Spatial.utg", LibraryType.Tutorial, null), //
	/**
	 * An agent-based flocking model of boids.
	 */
	Tut8("8 Boids", "Boids1", "Flock.utg", LibraryType.Tutorial, "Boids.zip"), //
	/**
	 * A simplistic individual based forest model to test the use of groups.
	 */
	Tut9("9 LittleForest", "LittleForest1", "LittleForest.utg", LibraryType.Tutorial, null), //
	/**
	 * Discrete logistic model. 100,000 parallel unattended simulations without GUI.
	 */
	Tut10("10 Headless(Logistic)", "Headless1", "LogisticHeadless.utg", LibraryType.Tutorial, null), //
	/**
	 * 3Worlds random number system.
	 */
	Tut11("11 Random number generators", "Rng1", "Rng_1.utg", LibraryType.Tutorial, null), //
	/**
	 * Introduction to experiment design system.
	 */
	Tut12("12 Running experiments", "Prj1", "ExperimentTut.utg", LibraryType.Tutorial, "GDDM.zip"),
	//
	/**
	 * Population dynamics of the palm tree Borassus aethiopum.
	 */
	Model1("1 Palms", "Palms1", "Palms.utg", LibraryType.Model, null), //
	/**
	 * Fire spread model derived from very simple empirical rules that capture the
	 * behavioural complexity of the interactions between fire, fuels, terrain, and
	 * weather.
	 */
	Model2("2 Rabbit Rules", "RabbitRules", "RabbitRules.utg", LibraryType.Model, null), //
	/**
	 * IBM with males and females, overlapping generations and genetics in a
	 * disturbance prone landscape
	 */
	Model3("3 GDDM", "GDDM1", "GDDM.utg", LibraryType.Model, "GDDM.zip"), //
	//
	/**
	 * A test model for relations
	 */
	Test1("1 TestRelations", "TestRelations1", "TestRelations.utg", LibraryType.Test, null), //
	/**
	 * A test of the life-cycle concept in 3Worlds.
	 */
	Test2("2 TestLifeCycle", "TestLifeCycle1", "TestLifeCycle.utg", LibraryType.Test, null), //
//	Test3("3 TestXYPlot", "TestXYPlot1", "TestXYPlot.utg", LibraryType.Test,null), //
	/**
	 * Test UI widgets when running multiple simulations.
	 */
	Test4("4 ParallelTest (Logistic)", "Logistic1", "ParallelTestLogistic.utg", LibraryType.Test, null), //
	/**
	 * Test UI widgets when running multiple simulations.
	 */
	Test5("5 ParallelTest (Boids)", "Boids1", "ParallelTestBoids.utg", LibraryType.Test, null), //
	/**
	 * Testing multiple times of different steps and types.
	 */
	Test6("6 Timer test (clock/event)", "TimerTest1", "TimerTest.utg", LibraryType.Test, null), //
	/**
	 * Test Clock timer with Gregorian time scale.r
	 */
	Test7("7 Timer test (calendar time)", "TimerTest1", "TimerTestCalendarTime.utg", LibraryType.Test, null), //
	/**
	 * Spatial IBM with single sex, non-overlapping generations and disturbance.
	 */
	Test8("8 Landscape A", "LMA", "LMA.utg", LibraryType.Test, "LM1.zip"), //
	/**
	 * Spatial IBM with single sex, overlapping generations and disturbance.
	 */
	Test9("9 Landscape B", "LMB", "LMB.utg", LibraryType.Test, "LM1.zip"), //
	/**
	 * Spatial IBM with males, females,, overlapping generations and disturbance.
	 */
	Test10("10 Landscape C", "LMC", "LMC.utg", LibraryType.Test, "LM1.zip"), //
	/**
	 * Spatial IBM with males, females, overlapping generations, landscape genetics
	 * and disturbance.
	 */
	Test11("11 Landscape D", "LMD", "LMD.utg", LibraryType.Test, "LM2.zip"), //
	/**
	 * Test data loading system.
	 */
	Test12("12 Data loading from files", "TestDataLoading", "TestDataLoading.utg", LibraryType.Test,
			"TestDataLoading.zip"), //
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

	/**
	 * The text used to show in the menu item.
	 * 
	 * @return The text to display
	 */
	public String displayName() {
		return displayName;
	}

	/**
	 * The default prompt name to display when this project is instantiated. The
	 * actual name will be modified to remove all underscores and an integer added
	 * to ensure the name is unqiue within the project scope.
	 * 
	 * @return Text of the proposed name
	 */
	public String proposedName() {
		return proposedName.replaceAll("_", "");
	}

	/**
	 * @return The type of library
	 * @see LibraryType
	 */
	public LibraryType libraryType() {
		return libraryType;
	}

	/**
	 * Returns a zip file containing any dependencies associated with this model or
	 * null if the model has no dependencies.
	 * <p>
	 * The contents of the archive are extracted and place in the appropriate
	 * location for the model.
	 * 
	 * @return The archive file (*.zip) containing any dependent files for a model
	 *         configuration. Can be null.
	 */
	public InputStream dependencyArchive() {
		if (dependencyArchive == null)
			return null;
		Class<?> associatedClass = getAssociatedClass();
		return associatedClass.getResourceAsStream(dependencyArchive);
	}

	/**
	 * Instantiates a configuration graph of the model.
	 * 
	 * @return Configuration graph.
	 */
	@SuppressWarnings("unchecked")
	public TreeGraph<TreeGraphDataNode, ALEdge> getGraph() {
		return (TreeGraph<TreeGraphDataNode, ALEdge>) GraphImporter.importGraph(fileName, getAssociatedClass());
	}

	boolean configExists() {
		Class<?> associatedClass = getAssociatedClass();
		return associatedClass.getResourceAsStream(fileName) != null;
	}

	boolean dependencyExists() {
		if (dependencyArchive == null)
			return true;
		else if (!dependencyArchive.endsWith(".zip"))
			return false;
		else
			return dependencyArchive() != null;
	}

	/**
	 * @return A dummy class to provide the package name wherein the required model
	 *         file and dependencies are located.
	 */
	private Class<?> getAssociatedClass() {
		switch (libraryType) {
		case Template: {
			return TemplatesDummy.class;
		}
		case Tutorial: {
			return TutorialsDummy.class;
		}
		case Model: {
			return ModelsDummy.class;
		}
		default: {
			return TestsDummy.class;
		}
		}

	}

}
