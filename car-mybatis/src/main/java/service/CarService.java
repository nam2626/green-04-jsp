package service;

import config.DBManager;
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
}
