package dao.employee_dao;

import model.employee.Position;

import java.util.List;

public interface PositionDAO {
    List<Position> findAllPosition();
}
