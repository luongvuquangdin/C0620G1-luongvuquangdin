package dao.daoemployee;

import model.modelemployee.Position;

import java.util.List;

public interface PositionDAO {
    List<Position> findAllPosition();
}
