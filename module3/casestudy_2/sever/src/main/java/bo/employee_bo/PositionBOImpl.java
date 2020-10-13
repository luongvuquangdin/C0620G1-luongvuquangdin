package bo.employee_bo;

import dao.employee_dao.PositionDAO;
import dao.employee_dao.PositionDAOImpl;
import model.employee.Position;

import java.util.List;

public class PositionBOImpl implements PositionBO {
    PositionDAO positionDAO=new PositionDAOImpl();
    @Override
    public List<Position> findAllPosition() {
        return positionDAO.findAllPosition();
    }
}
