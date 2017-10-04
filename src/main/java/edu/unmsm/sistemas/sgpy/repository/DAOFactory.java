package edu.unmsm.sistemas.sgpy.repository;

/**
 *
 * @author Grupo_10
 */
public class DAOFactory {

    private final static DAOFactory DAO_FACTORY_VAR;

    static {
        DAO_FACTORY_VAR = new DAOFactory();
    }

    public static DAOFactory getInstacia() {

        return DAO_FACTORY_VAR;
    }
}
