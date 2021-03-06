package uade.tpo.tda;

import uade.tpo.model.Libro;

public interface LibrosAutorTDA {

	/**
	 * Inicializa la estructura<br>
	 * PRE: -<br>
	 * POS: Estructura inicializada
	 */
	public void Inicializar();

	/**
	 * Agrega un libro ordenado por precio.<br>
	 * PRE: Estructura inicializada. El libro no debe existir.<br>
	 * POS: Estructura modificada en un (1) elemento mas
	 */
	public void Agregar(String nombre, float precio);

	/**
	 * Determina si un libro existe. TRUE existe, FALSE no existe.<br>
	 * PRE: Estructura inicializada POS: -<br>
	 */
	public boolean LibroPertenece(String nombre);

	/**
	 * Devuelve el hijo izquierdo del �rbol de libros<br>
	 * PRE: Estructura inicializada y no vacia<br>
	 * POS: -
	 */
	public LibrosAutorTDA HijoIzquierdo();

	/**
	 * Devuelve el hijo derecho del �rbol de libros<br>
	 * PRE: Estructura inicializada y no vacia<br>
	 * POS: -
	 */
	public LibrosAutorTDA HijoDerecho();

	/**
	 * Elimina un libro<br>
	 * PRE: Estructura inicializada y no vacia.<br>
	 * POS: Estructura modificada en un (1) elemento menos.
	 */
	public void Eliminar(String nombre);

	/**
	 * Devuelve un objeto libro que se encuentra en la raiz<br>
	 * PRE: Estructura inicializada y no vacia<br>
	 * POS: -
	 */
	public Libro Raiz();

	/**
	 * Determina si la estructura se encuentra vacia o no. TRUE: estructura
	 * vacia, FALSE: no vacia.<br>
	 * PRE: Estructura inicializada<br>
	 * POS: -
	 */
	public boolean LibroVacio();
}
