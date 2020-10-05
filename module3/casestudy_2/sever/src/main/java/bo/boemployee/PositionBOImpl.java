package bo.boemployee;

import dao.daoemployee.PositionDAO;
import dao.daoemployee.PositionDAOImpl;
import model.modelemployee.Position;

import java.util.List;

public class PositionBOImpl implements PositionBO {
    PositionDAO positionDAO=new PositionDAOImpl();
    @Override
    public List<Position> findAllPosition() {
        return positionDAO.findAllPosition();
    }
}
