package mapper;

import java.util.List;

import dto.CarDTO;

public interface CarMapper {

	List<CarDTO> selectAllCar();

	int insertCar(CarDTO newCar);

	int deleteCar(String string);

	int updateCar(CarDTO newCar);

}
