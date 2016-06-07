package uade.tpo.impl;

import uade.tpo.tda.AutorTDA;
import uade.tpo.tda.LibrosAutorTDA;

public class AutorTDAImpl implements AutorTDA {
	private Autor raiz;
	
	public void Inicializar() {
		raiz=null;
	}

	public void Agregar(String nombreAutor) {
		if(raiz==null){
			raiz= new Autor();
			raiz.setNombre(nombreAutor);
			raiz.setLibrosAutor= new LibrosAutorTDAImpl();
			raiz.getLibrosAutor= Inicializar(); //????????
			raiz.setHi=new AutorTDAImpl();
			raiz.setHd= new AutorTDAImpl();
			raiz.getHi=Inicializar();
			raiz.getHd=Inicializar();
			raiz=Autor;
		}else{
			if (raiz.getNombre().compareTo(nombreAutor) > 0) {
				raiz.getHi().Agregar(nombreAutor);
			} else {
				raiz.getHd().Agregar(nombreAutor);
			}
		}
		
	}

	public AutorTDA HijoIzquierdo() {
		return raiz.getHi();
	}

	public AutorTDA HijoDerecho() {
		return raiz.getHd();
	}

	public void Eliminar(String nombreAutor) {
		if(raiz!=null){
			if(raiz.getNombre().equals(nombreAutor) && raiz.getHi.ArbolVacio() && raiz.getHd.ArbolVacio()){
				raiz=null;
			}else{
				if(raiz.getNombre().equals(nombreAutor) && !raiz.getHd.ArbolVacio()){
					raiz=Mayor(raiz.getHi);
					raiz.getHi.Eliminar(raiz.getNombre());
				}else{
					if(raiz.getNombre().equals(nombreAutor) && !raiz.getHd.ArbolVacio()){
						raiz=Menor(raiz.getHd);
						raiz.getHd.Eliminar(raiz.getNombre());
					}else{
						if(raiz.getNombre().compareTo(nombreAutor)>0){
							raiz.getHi.Eliminar(nombreAutor);
						}else{
							raiz.getHd.Eliminar(nombreAutor);
						}
					}
				}
			}
		}
		
	}
	private Autor Mayor(AutorTDA autor){
		if(autor.HijoDerecho().ArbolVacio()){
			return autor.Raiz();
		}else{
			return Mayor(autor.HijoDerecho());
		}
	}
	private Autor Menor(AutorTDA autor){
		if(autor.HijoIzquierdo().ArbolVacio()){
			return autor.Raiz();
		}else{
			return Menor(autor.HijoIzquierdo());
		}
	}

	public String Raiz() {
		return raiz.getNombre;
	}

	public boolean AutorVacio() {
		return raiz==null;
	}

	public void AgregarLibro(String nombreAutor, String tituloLibro,float precio) {
		Autor aux= BuscarAutor(raiz, nombreAutor);
		aux.LibrosAutor.Agregar(tituloLibro, precio); //El autor tenia que existir.
	}
	private AutorTDA BuscarAutor(AutorTDA raiz, String nombreAutor){
		Autor aux=raiz;
		if(aux!=null){
			if(aux.getNombre().equals(nombreAutor)){
				return aux;
			}else{
				if(aux.getNombre().compareTo(nombreAutor)>0){
					Buscar(aux.Hijoizquierdo(), nombreAutor());
				}else{
					Buscar(aux.HijoDerecho(), nombreAutor());
				}
			}
		}
	}

	public LibrosAutorTDA GetLibros(String nombreAutor) {
		Autor aux=BuscarAutor(raiz, nombreAutor);  //Como el autor tiene que existir no lo chequeo.
		return aux.getLibrosAutor;  	//No me acuerdo como estaba el nombre del arbol de libros
	}

}
