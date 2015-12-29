package reital.parquesamanes.domain;

import java.util.List;

import reital.parquesamanes.domain.entidades.FranjaHoraria;

public interface FranjaHorariaRepository {

	List<FranjaHoraria> getAll();

	boolean create(String codigo, String nombre, String horaInicio, String horaFin, String observaciones, String horasValores);

	boolean update(String codigo, String nombre, String horaInicio, String horaFin, String observaciones, String horasValores);

	boolean delete(String codigo);

}
