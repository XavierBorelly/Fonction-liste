package com.xb.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xb.beenTest.Chaussure;
import com.xb.src.Fonction_liste;
import com.xb.src.impl.ImplFonction_liste;

public class Test_Fonction_liste {

	/**
	 * Ce test va permettre de v�rifier que le typage des variables est conserv�
	 * Tester avec String, Integer, Float et une classe "chaussure" compos� d'un
	 * Integer et d'un string.
	 */
	@Test
	public void testCorrespondanceTypage() {
		// Cr�ation de la classe Fonction_liste permettant d'aller par la suite
		// chercher les fonctions � utiliser sur les listes, et notamment
		// .partition.
		Fonction_liste<String> fl_string = new ImplFonction_liste<String>();
		// Cr�ation d'un ensemble de listes contenant des strings, et d'une
		// liste contenant des strings.
		List<List<String>> listeString_partionnee = new ArrayList<List<String>>();
		List<String> string_value = new ArrayList<String>();
		// Remplissage de la liste des strings avec une valeur.
		string_value.add("ABCD");
		// Partitionnage de la liste de string.
		listeString_partionnee = fl_string.partition(string_value, 1);

		// Test pour v�rifier que la liste partitionn�e est bien compos�e
		// uniquement de string.
		for (List<?> type : listeString_partionnee) {
			for (Object item : type) {
				assertEquals(item.getClass(), string_value.get(0).getClass());
			}
		}

		// m�me test que plus haut avec un Integer.
		Fonction_liste<Integer> fl_int = new ImplFonction_liste<Integer>();
		List<List<Integer>> listeInteger_partionnee = new ArrayList<List<Integer>>();
		List<Integer> int_value = new ArrayList<Integer>();
		int_value.add(42);
		listeInteger_partionnee = fl_int.partition(int_value, 1);

		for (List<?> type : listeInteger_partionnee) {
			for (Object item : type) {
				assertEquals(item.getClass(), int_value.get(0).getClass());
			}
		}

		// m�me test que plus haut avec un float.
		Fonction_liste<Float> fl_float = new ImplFonction_liste<Float>();
		List<List<Float>> listeFloat_partionnee = new ArrayList<List<Float>>();
		List<Float> float_value = new ArrayList<Float>();
		float_value.add(1.8F);
		listeFloat_partionnee = fl_float.partition(float_value, 1);

		for (List<?> type : listeFloat_partionnee) {
			for (Object item : type) {
				assertEquals(item.getClass(), float_value.get(0).getClass());
			}
		}

		// m�me test que plus haut avec une chaussure (objet m�tier basique).
		Fonction_liste<Chaussure> fl_chaussure = new ImplFonction_liste<Chaussure>();
		List<List<Chaussure>> listeChaussure_partionnee = new ArrayList<List<Chaussure>>();
		List<Chaussure> chaussure_value = new ArrayList<Chaussure>();
		chaussure_value.add(new Chaussure("Nike", 48));
		listeChaussure_partionnee = fl_chaussure.partition(chaussure_value, 1);

		for (List<?> type : listeChaussure_partionnee) {
			for (Object item : type) {
				assertEquals(item.getClass(), chaussure_value.get(0).getClass());
			}
		}
	}

	/**
	 * Ce test va permettre de v�rifier le bon partitionnement des listes.
	 * 
	 * Il permet aussi de voir que l'insertion de valeur null au sein de la
	 * liste n'influence pas le partitionnage.
	 */
	@Test
	public void testTaillePartition() {
		// Cr�ation de la classe Fonction_liste permettant d'aller par la suite
		// chercher les fonctions � utiliser sur les listes, et notamment
		// .partition.
		Fonction_liste<Integer> fl_int = new ImplFonction_liste<Integer>();
		// Cr�ation d'un ensemble de listes contenant des Integers, et d'une
		// liste contenant des Integers.
		List<List<Integer>> listeInteger_partionnee = new ArrayList<List<Integer>>();
		List<Integer> int_value = new ArrayList<Integer>();
		// Remplissage avec sept valeurs null la liste des Integers.
		int_value.add(null);
		int_value.add(null);
		int_value.add(null);
		int_value.add(null);
		int_value.add(null);
		int_value.add(null);
		int_value.add(null);

		// Partitionnage de la liste des Integers par la taille de la partition
		// (ici
		// 1).
		int taillePartition = 1;

		// Cr�ation d'une valeur pour tester s'il n�y a bien qu�une seule
		// sous-liste avec une taille diff�rente (la derni�re si il y en a une).
		int testTaille = 0;

		listeInteger_partionnee = fl_int.partition(int_value, taillePartition);

		// Cr�ation d'un indice pour v�rifier la position dans la liste, pour
		// pouvoir v�rifier le dernier �l�ment au cas o� il serait diff�rent des
		// autres.
		int tailleList = listeInteger_partionnee.size();

		// Test pour v�rifier que la partition a la taille d�sir�e (test
		// en deux parties car le dernier �l�ment de la liste peut avoir une
		// taille diff�rente).
		for (List<?> taille : listeInteger_partionnee) {
			tailleList--;
			if (taille.size() != taillePartition) {
				testTaille++;
			}

			assertTrue(testTaille == 0 || testTaille == 1 && tailleList == 0);
		}

		// M�me test que plus pr�c�demment : ici taille de partition de 2.
		taillePartition = 2;
		testTaille = 0;
		listeInteger_partionnee = fl_int.partition(int_value, taillePartition);
		tailleList = listeInteger_partionnee.size();

		for (List<?> taille : listeInteger_partionnee) {
			tailleList--;
			if (taille.size() != taillePartition) {
				testTaille++;
			}

			assertTrue(testTaille == 0 || testTaille == 1 && tailleList == 0);
		}

		// M�me test que plus pr�c�demment : ici taille de partition de 4.
		taillePartition = 4;
		testTaille = 0;
		listeInteger_partionnee = fl_int.partition(int_value, taillePartition);
		tailleList = listeInteger_partionnee.size();

		for (List<?> taille : listeInteger_partionnee) {
			tailleList--;
			if (taille.size() != taillePartition) {
				testTaille++;
			}

			assertTrue(testTaille == 0 || testTaille == 1 && tailleList == 0);
		}

		// M�me test que plus pr�c�demment : ici taille de partition de 8.
		taillePartition = 8;
		testTaille = 0;
		listeInteger_partionnee = fl_int.partition(int_value, taillePartition);
		tailleList = listeInteger_partionnee.size();

		for (List<?> taille : listeInteger_partionnee) {
			tailleList--;
			if (taille.size() != taillePartition) {
				testTaille++;
			}

			assertTrue(testTaille == 0 || testTaille == 1 && tailleList == 0);
		}

	}

	/**
	 * Ce test permet de tester les diff�rentes erreurs non rep�r�es par le
	 * compilateur.
	 * 
	 * A l'heure actuelle, ces erreurs regroupe,t :
	 *
	 * -La tentation de cr�ation d'une partition de taille null ou n�gative.
	 */
	@Test
	public void testCasNonNominal() {
		// Cr�ation de la classe Fonction_liste permettant d'aller par la suite
		// chercher les fonctions � utiliser sur les listes, et notamment
		// .partition.
		Fonction_liste<Integer> fl_int = new ImplFonction_liste<Integer>();
		// Cr�ation d'un ensemble de listes contenant des Integers, et d'une
		// liste contenant des Integers.
		List<List<Integer>> listeInteger_partionnee = new ArrayList<List<Integer>>();
		List<Integer> int_value = new ArrayList<Integer>();
		// Remplissage avec sept valeurs la liste des Integers.
		int_value.add(17);
		int_value.add(1);
		int_value.add(105);
		int_value.add(42);
		int_value.add(3);
		int_value.add(1);
		int_value.add(9054);

		// Partitionnage de la liste des Integers par la taille de la partition (ici
		// -1).
		int taillePartition = -1;

		listeInteger_partionnee = fl_int.partition(int_value, taillePartition);

		// Test pour v�rifier que la partition poss�de bien avec une valeur nulle
		for (List<?> erreur : listeInteger_partionnee) {
			assertTrue(erreur.equals(null));
		}

		// M�me test que plus haut, ici taille de partition de 0.
		taillePartition = 0;
		listeInteger_partionnee = fl_int.partition(int_value, taillePartition);

		for (List<?> erreur : listeInteger_partionnee) {
			assertTrue(erreur.equals(null));
		}
	}

}
