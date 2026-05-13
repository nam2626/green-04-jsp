package service;

import java.util.List;

import config.DBManager;
import dto.CarDTO;
import mapper.CarMapper;

public class CarService {
	private static CarService instance = new CarService();
	private CarMapper mapper;
	
	private CarService() {	
		mapper = DBManager.getInstance().openSession().getMapper(CarMapper.class);		
	}
	
	public static CarService getInstance() {
		if(instance == null)
			instance = new CarService();
		return instance;
	}

	public List<CarDTO> selectAllCar() {
		return mapper.selectAllCar();
	}
}






