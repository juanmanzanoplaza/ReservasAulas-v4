package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa durante cuanto tiempo se reserva un aula. Esta clase
 * permite que se pueda reservar un aula por un tramo completo (ma�ana o tarde)
 * 
 * @see Tramo
 * @see Permanencia
 * @author Juan Antonio Manzano Plaza
 * @version 3
 *
 */
public class PermanenciaPorTramo extends Permanencia implements Serializable {

	private static final int PUNTOS = 10;
	private Tramo tramo;

	/**
	 * Constructor de la clase
	 * 
	 * @param dia
	 *            el d�a que es reservada el aula
	 * @param tramo
	 *            el tramo para el que es reservada el aula
	 * @throws IllegalArgumentException
	 *             si el d�a o el tramo no son v�lidos
	 */
	public PermanenciaPorTramo(LocalDate dia, Tramo tramo) throws IllegalArgumentException {
		super(dia);
		setTramo(tramo);
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param dia
	 *            el d�a que es reservada el aula
	 * @param tramo
	 *            el tramo para el que es reservada el aula
	 * @throws IllegalArgumentException
	 *             si el d�a o el tramo par�metros no son v�lidos
	 */
	public PermanenciaPorTramo(String dia, Tramo tramo) throws IllegalArgumentException {
		super(dia);
		setTramo(tramo);
	}

	/**
	 * Constructor copia
	 * 
	 * @param otra
	 *            la permanencia a copiar
	 * @throws IllegalArgumentException
	 *             si la permanencia es nula
	 */
	public PermanenciaPorTramo(PermanenciaPorTramo otra) throws IllegalArgumentException {
		if (otra == null)
			throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
		super.setDia(otra.getDia());
		setTramo(otra.getTramo());
	}

	/**
	 * M�todo get para el tramo de la reserva
	 * 
	 * @return el tramo para el que es reservada el aula
	 */
	public Tramo getTramo() {
		return tramo;
	}

	/**
	 * M�todo set para el tramo de la reserva
	 * 
	 * @param tramo
	 *            el tramo para el que es reservada el aula
	 * @throws IllegalArgumentException
	 *             si el tramo es nulo
	 */
	private void setTramo(Tramo tramo) throws IllegalArgumentException {
		if (tramo == null)
			throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");
		this.tramo = tramo;
	}

	/**
	 * M�todo get para el n�mero de puntos que cuesta reservar esta Permanencia
	 * 
	 * @return el n�mero de puntos que cuesta reservar esta Permanencia
	 */
	public int getPuntos() {
		return PUNTOS;
	}

	/**
	 * M�todo hashCode para la clase. Sirve para diferenciar objetos.
	 * 
	 * @return el c�digo hash correspondiente al objeto
	 */
	public int hashCode() {
		return Objects.hash(dia, tramo, PUNTOS);
	}

	/**
	 * M�todo equals para la clase. Compara dos PermanenciaPorTramo
	 * 
	 * @return true si son iguales, false si no lo son
	 */
	public boolean equals(Object o) {
		if (!(o instanceof PermanenciaPorTramo))
			return false;
		PermanenciaPorTramo otra = (PermanenciaPorTramo) o;
		if (this.getDia().equals(otra.getDia()) && this.getTramo().equals(otra.getTramo()))
			return true;
		return false;
	}

	/**
	 * M�todo toString de la clase. Define como debe mostrarse una
	 * PermanenciaPorTramo
	 * 
	 * @return la representaci�n en forma de texto de la Permanencia
	 */
	public String toString() {
		return "[dia=" + getDia().format(FORMATO_DIA) + ", tramo=" + tramo + "]";
	}

}
