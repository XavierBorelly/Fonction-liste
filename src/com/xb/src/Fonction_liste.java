package com.xb.src;

import java.util.List;

public interface Fonction_liste<T> {

	/**
	 * Fonction permettant de partitionner une liste en plusieurs sous-liste.
	 * Renvoie une liste vide en cas d'erreur sur la taille.
	 * 
	 * @param liste
	 *            la liste à partitionner
	 * @param taille
	 *            la taille des partitions
	 * @return la partition
	 */
	public List<List<T>> partition(List<T> liste, int taille);
}
