package com.xb.src.impl;

import java.util.ArrayList;
import java.util.List;

import com.xb.src.Fonction_liste;

/**
 * Classe regroupant des fonctions sur les listes.
 * 
 * @author Xavier Borelly
 *
 * @param <T>
 */
public class ImplFonction_liste<T> implements Fonction_liste<T> {

	@Override
	public List<List<T>> partition(List<T> liste, int taille) {
		List<List<T>> partition = new ArrayList<List<T>>();

		// Si la taille est inférieur à 0, on renvoie une liste vide.
		if (taille > 0) {
			// Génération de compteur pour savoir où en est le remplissage
			// des sous-listes et la position globale dans la liste à
			// partitionner.
			int position = 0;
			int position_total = liste.size();
			List<T> elements = new ArrayList<T>();

			// Pour chaque élément dans la liste à partionner :
			for (T element : liste) {
				// On va ajouter cet élément à la sous-liste.
				elements.add(element);
				// Incrémenter la position dans la sous-liste.
				position++;
				// Décrémenter la position générale.
				position_total--;
				// Et si la sous-liste est totalement remplie ou que la liste à
				// partitionner est vide :
				if (position == taille || position_total == 0) {
					// On remet la position dans la sous-liste à 0.
					position = 0;
					// On ajoute la sous-liste dans le résultat.
					partition.add(elements);
					// Et on remet à 0 la sous-liste.
					elements = new ArrayList<T>();
				}
			}

		}
		return partition;
	}

}
