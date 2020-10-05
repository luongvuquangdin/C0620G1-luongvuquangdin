package bo.boemployee;

import dao.daoemployee.DivisionDAO;
import dao.daoemployee.DivisionDAOImpl;
import model.modelemployee.Division;

import java.util.List;

public class DivisionBOImpl implements DivisionBO {
    DivisionDAO divisionDAO=new DivisionDAOImpl();
    @Override
    public List<Division> findAllDivision() {
        return divisionDAO.findAllDivision();
    }
}
